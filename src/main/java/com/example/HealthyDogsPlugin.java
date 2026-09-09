package com.example;

import com.google.inject.Provides;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Healthy Stray Varrock Dogs",
	description = "Gives a full veterinary treatment, bath, and flea prevention to the stray dogs in Varrock, including Charlie the Tramp's dog, Duke.",
	tags = {"dog", "stray", "varrock", "duke", "cosmetic", "stray dogs", "stray dog", "injured"}
)
public class HealthyDogsPlugin extends Plugin
{
	private static final int HEALTHY_CLAN_DOG_ID = 10760;

	@Inject
	private Client client;

	@Inject
	private HealthyDogsConfig config;

	private final Map<Integer, int[]> originalModels = new HashMap<>();
	private final Map<Integer, short[]> originalColors = new HashMap<>();

	@Provides
	HealthyDogsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HealthyDogsConfig.class);
	}

	@Override
	protected void shutDown()
	{
		restoreOriginals();
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		healDog(event.getNpc());
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (client.getGameState() != GameState.LOGGED_IN || !config.healVarrockStray())
		{
			return;
		}

		for (NPC npc : client.getNpcs())
		{
			healDog(npc);
		}
	}

	private void healDog(NPC npc)
	{
		if (npc == null)
		{
			return;
		}

		String name = npc.getName();
		if (name == null)
		{
			return;
		}

		if (name.equalsIgnoreCase("Duke") || name.equalsIgnoreCase("Stray dog"))
		{
			NPCComposition targetComp = npc.getComposition();
			if (targetComp == null)
			{
				return;
			}

			NPCComposition healthyComp = client.getNpcDefinition(HEALTHY_CLAN_DOG_ID);
			if (healthyComp == null)
			{
				return;
			}

			int[] targetModels = targetComp.getModels();
			int[] healthyModels = healthyComp.getModels();

			if (targetModels != null && healthyModels != null)
			{
				if (!originalModels.containsKey(targetComp.getId()))
				{
					originalModels.put(targetComp.getId(), targetModels.clone());
					short[] colors = targetComp.getColorToReplaceWith();
					if (colors != null)
					{
						originalColors.put(targetComp.getId(), colors.clone());
					}
				}

				for (int i = 0; i < targetModels.length; i++)
				{
					if (i < healthyModels.length)
					{
						targetModels[i] = healthyModels[i];
					}
					else
					{
						targetModels[i] = -1;
					}
				}
			}

			short[] targetColors = targetComp.getColorToReplaceWith();
			short[] healthyColors = healthyComp.getColorToReplaceWith();
			if (targetColors != null && healthyColors != null)
			{
				for (int i = 0; i < Math.min(targetColors.length, healthyColors.length); i++)
				{
					targetColors[i] = healthyColors[i];
				}
			}
		}
	}

	private void restoreOriginals()
	{
		for (Map.Entry<Integer, int[]> entry : originalModels.entrySet())
		{
			NPCComposition comp = client.getNpcDefinition(entry.getKey());
			if (comp != null && comp.getModels() != null)
			{
				int[] current = comp.getModels();
				int[] original = entry.getValue();
				System.arraycopy(original, 0, current, 0, Math.min(current.length, original.length));
			}
		}

		for (Map.Entry<Integer, short[]> entry : originalColors.entrySet())
		{
			NPCComposition comp = client.getNpcDefinition(entry.getKey());
			if (comp != null && comp.getColorToReplaceWith() != null)
			{
				short[] current = comp.getColorToReplaceWith();
				short[] original = entry.getValue();
				System.arraycopy(original, 0, current, 0, Math.min(current.length, original.length));
			}
		}

		originalModels.clear();
		originalColors.clear();
	}
}
