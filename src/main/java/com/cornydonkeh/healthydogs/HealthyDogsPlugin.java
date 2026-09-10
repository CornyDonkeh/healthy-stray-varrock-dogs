package com.cornydonkeh.healthydogs;

import com.google.inject.Provides;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Random;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Animation;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.GameObject;
import net.runelite.api.Model;
import net.runelite.api.ModelData;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Renderable;
import net.runelite.api.Scene;
import net.runelite.api.TileObject;
import net.runelite.api.RuneLiteObject;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.gameval.NpcID;
import net.runelite.api.gameval.AnimationID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.callback.RenderCallback;
import net.runelite.client.callback.RenderCallbackManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Healthy Stray Varrock Dogs",
	description = "Cosmetically makes Varrock's stray dogs and Duke appear healthy.",
	tags = {"dog", "dogs", "varrock", "duke", "cosmetic"}
)
public class HealthyDogsPlugin extends Plugin
{
	@Inject
	private Client client;
	@Inject
	private HealthyDogsConfig config;
	@Inject
	private ClientThread clientThread;
	@Inject
	private RenderCallbackManager renderCallbackManager;

	// NPC indices can be reused after despawn: track the actual NPC instances.
	private final Map<NPC, DogAppearance> dogs = new IdentityHashMap<>();
	private final Random random = new Random();
	private final RenderCallback drawListener = new RenderCallback()
	{
		@Override
		public boolean drawObject(Scene scene, TileObject object)
		{
			return !(object instanceof GameObject)
				|| shouldDraw(((GameObject) object).getRenderable());
		}
	};
	private volatile boolean running;
	// Share geometry only among dogs with the same original color palette.
	private final Map<Integer, Model> healthyModels = new HashMap<>();

	@Provides
	HealthyDogsConfig provideConfig(ConfigManager manager)
	{
		return manager.getConfig(HealthyDogsConfig.class);
	}

	@Override
	protected void startUp()
	{
		running = true;
		renderCallbackManager.register(drawListener);
		clientThread.invoke(this::refresh);
	}

	@Override
	protected void shutDown()
	{
		running = false;
		renderCallbackManager.unregister(drawListener);
		clientThread.invoke(() ->
		{
			clearDogs();
			healthyModels.clear();
			// Handle a quick re-enable that occurred before queued cleanup.
			if (running)
			{
				refresh();
			}
		});
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (HealthyDogsConfig.GROUP.equals(event.getGroup()))
		{
			clientThread.invoke(this::refresh);
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			refresh();
		}
		else
		{
			clearDogs();
			healthyModels.clear();
		}
	}

	private void refresh()
	{
		clearDogs();
		if (!running || !config.healVarrockDogs() || client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}
		// One scan on enable/login/config change, never on every tick or frame.
		for (NPC npc : client.getTopLevelWorldView().npcs())
		{
			track(npc);
		}
		createReplacements();
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		track(event.getNpc());
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		removeDog(event.getNpc());
	}

	@Subscribe
	public void onNpcChanged(NpcChanged event)
	{
		DogAppearance previous = dogs.get(event.getNpc());
		if (previous != null && previous.originalNpcId == event.getNpc().getId())
		{
			return;
		}
		removeDog(event.getNpc());
		track(event.getNpc());
	}

	private void track(NPC npc)
	{
		if (running && config.healVarrockDogs() && npc != null
			&& npc.getWorldView() == client.getTopLevelWorldView() && isDog(npc.getId()))
		{
			// Choose once per encounter, not on render, animation change, or asset retry.
			dogs.computeIfAbsent(npc, dog -> new DogAppearance(dog.getId(),
				DogVariant.choose(dog.getId(), config, random)));
		}
	}

	private static boolean isDog(int id)
	{
		return id == NpcID.DOG_STRAY || id == NpcID.DOG_STRAY2 || id == NpcID.XMAS24_STRAYDOG_FINAL;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		// Retry missing cache assets only while tracked dogs are present.
		createReplacements();
	}

	private void createReplacements()
	{
		if (!running || !config.healVarrockDogs() || dogs.isEmpty())
		{
			return;
		}
		for (Map.Entry<NPC, DogAppearance> entry : dogs.entrySet())
		{
			DogAppearance appearance = entry.getValue();
			if (appearance.replacement != null)
			{
				continue;
			}
			NPCComposition original = entry.getKey().getTransformedComposition();
			if (original == null)
			{
				continue;
			}
			int modelKey = appearance.variant == null ? original.getId() : appearance.variant.npcId;
			Model healthyModel = healthyModels.get(modelKey);
			if (healthyModel == null)
			{
				healthyModel = appearance.variant == null ? loadHealedModel(original)
					: loadPetModel(appearance.variant);
				if (healthyModel == null)
				{
					continue;
				}
				healthyModels.put(modelKey, healthyModel);
			}
			RuneLiteObject replacement = client.createRuneLiteObject();
			replacement.setModel(healthyModel);
			replacement.setShouldLoop(true);
			appearance.replacement = replacement;
			log.debug("Created appearance {} for NPC {}", modelKey, original.getId());
		}
	}

	private Model loadHealedModel(NPCComposition original)
	{
		NPCComposition healthy = client.getNpcDefinition(NpcID.CLAN_HALL_DOG);
		return loadModel(healthy, original);
	}

	private Model loadPetModel(DogVariant variant)
	{
		NPCComposition pet = client.getNpcDefinition(variant.npcId);
		return loadModel(pet, pet);
	}

	private Model loadModel(NPCComposition healthy, NPCComposition colors)
	{
		if (healthy == null || colors == null || healthy.getModels() == null || healthy.getModels().length == 0)
		{
			return null;
		}
		int[] ids = healthy.getModels();
		ModelData[] parts = new ModelData[ids.length];
		for (int i = 0; i < ids.length; i++)
		{
			parts[i] = client.loadModelData(ids[i]);
			if (parts[i] == null)
			{
				return null;
			}
		}
		// Merge before lighting: merging lit Models loses legacy animation skin groups.
		// Copy the arrays we change so cached geometry and other NPCs remain untouched.
		ModelData data = (parts.length == 1 ? parts[0].shallowCopy() : client.mergeModels(parts))
			.cloneVertices().cloneColors();
		short[] from = colors.getColorToReplace();
		short[] to = colors.getColorToReplaceWith();
		if (from != null && to != null)
		{
			for (int i = 0; i < Math.min(from.length, to.length); i++)
			{
				data.recolor(from[i], to[i]);
			}
		}
		data.scale(healthy.getWidthScale(), healthy.getHeightScale(), healthy.getWidthScale());
		return data.light();
	}

	@Subscribe
	public void onBeforeRender(BeforeRender event)
	{
		// Follow just the tracked dogs, without loading models or scanning the scene.
		for (Map.Entry<NPC, DogAppearance> entry : dogs.entrySet())
		{
			DogAppearance appearance = entry.getValue();
			RuneLiteObject replacement = appearance.replacement;
			if (replacement == null)
			{
				continue;
			}
			NPC npc = entry.getKey();
			replacement.setLocation(npc.getLocalLocation(), npc.getWorldLocation().getPlane());
			replacement.setOrientation(npc.getCurrentOrientation());
			int animationId = npc.getAnimation() == -1 ? npc.getPoseAnimation() : npc.getAnimation();
			if (appearance.variant != null)
			{
				// Pet models have different skeletons. Do not apply stray attack/idle animations.
				animationId = npc.getPoseAnimation() == npc.getIdlePoseAnimation()
					? appearance.variant.idleAnimation : AnimationID.DOG_UPDATE_WALK;
			}
			Animation current = replacement.getAnimation();
			if ((current == null ? -1 : current.getId()) != animationId)
			{
				replacement.setAnimation(animationId == -1 ? null : client.loadAnimation(animationId));
			}
			if (!replacement.isActive())
			{
				replacement.setActive(true);
			}
		}
	}

	private boolean shouldDraw(Renderable renderable)
	{
		// Never reject addEntity: the original NPC must stay in the scene for native
		// click testing and menus. Suppress only its pixels once a replacement is ready.
		if (!running || !(renderable instanceof NPC))
		{
			return true;
		}
		DogAppearance appearance = dogs.get(renderable);
		return appearance == null || appearance.replacement == null || !appearance.replacement.isActive();
	}

	private void removeDog(NPC npc)
	{
		DogAppearance appearance = dogs.remove(npc);
		if (appearance != null && appearance.replacement != null)
		{
			appearance.replacement.setActive(false);
		}
	}

	private void clearDogs()
	{
		for (DogAppearance appearance : dogs.values())
		{
			if (appearance.replacement != null)
			{
				appearance.replacement.setActive(false);
			}
		}
		dogs.clear();
	}

	private static final class DogAppearance
	{
		private final int originalNpcId;
		private final DogVariant variant;
		private RuneLiteObject replacement;

		private DogAppearance(int originalNpcId, DogVariant variant)
		{
			this.originalNpcId = originalNpcId;
			this.variant = variant;
		}
	}
}
