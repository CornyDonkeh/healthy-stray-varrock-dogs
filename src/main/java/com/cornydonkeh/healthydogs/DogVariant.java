package com.cornydonkeh.healthydogs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import net.runelite.api.gameval.AnimationID;
import net.runelite.api.gameval.NpcID;

/**
 * Follower NPC IDs verified against OSRS Wiki breed pages and the local game cache
 * on 2026-09-10. These new NPCs have no constants in RuneLite 1.12.38 gameval.NpcID.
 * Replace numeric IDs with gameval constants when RuneLite publishes them.
 * See docs/dog-variants.md for provenance; no runtime wiki requests are made.
 */
enum DogVariant
{
	BERNESE_PUPPY_CHOCOLATE(16457, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::bernesePuppyChocolate),
	BERNESE_PUPPY_MERLE(16458, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::bernesePuppyMerle),
	BERNESE_PUPPY_TOASTED(16459, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::bernesePuppyToasted),
	BERNESE_ADULT_CHOCOLATE(16385, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::berneseAdultChocolate),
	BERNESE_ADULT_MERLE(16386, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::berneseAdultMerle),
	BERNESE_ADULT_TOASTED(16387, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::berneseAdultToasted),
	BORDER_COLLIE_PUPPY_CHOCOLATE(16442, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::borderColliePuppyChocolate),
	BORDER_COLLIE_PUPPY_MERLE(16443, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::borderColliePuppyMerle),
	BORDER_COLLIE_PUPPY_BLACK_WHITE(16444, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::borderColliePuppyBlackWhite),
	BORDER_COLLIE_ADULT_CHOCOLATE(16367, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::borderCollieAdultChocolate),
	BORDER_COLLIE_ADULT_MERLE(16368, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::borderCollieAdultMerle),
	BORDER_COLLIE_ADULT_BLACK_WHITE(16369, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::borderCollieAdultBlackWhite),
	CHIHUAHUA_PUPPY_TAN(16439, AnimationID.DOG_UPDATE_SMALL_DOG_READY_SIMPLE, HealthyDogsConfig::chihuahuaPuppyTan),
	CHIHUAHUA_PUPPY_WHITE(16440, AnimationID.DOG_UPDATE_SMALL_DOG_READY_SIMPLE, HealthyDogsConfig::chihuahuaPuppyWhite),
	CHIHUAHUA_PUPPY_TOASTED(16441, AnimationID.DOG_UPDATE_SMALL_DOG_READY_SIMPLE, HealthyDogsConfig::chihuahuaPuppyToasted),
	CHIHUAHUA_ADULT_TAN(16364, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::chihuahuaAdultTan),
	CHIHUAHUA_ADULT_WHITE(16365, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::chihuahuaAdultWhite),
	CHIHUAHUA_ADULT_TOASTED(16366, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::chihuahuaAdultToasted),
	CORGI_PUPPY_TAN(16445, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::corgiPuppyTan),
	CORGI_PUPPY_FAWN(16446, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::corgiPuppyFawn),
	CORGI_PUPPY_TOASTED(16447, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::corgiPuppyToasted),
	CORGI_ADULT_TAN(16370, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::corgiAdultTan),
	CORGI_ADULT_FAWN(16371, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::corgiAdultFawn),
	CORGI_ADULT_TOASTED(16372, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::corgiAdultToasted),
	GREYHOUND_PUPPY_TAN(16448, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::greyhoundPuppyTan),
	GREYHOUND_PUPPY_GREY(16449, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::greyhoundPuppyGrey),
	GREYHOUND_PUPPY_CREAM(16450, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::greyhoundPuppyCream),
	GREYHOUND_ADULT_TAN(16373, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::greyhoundAdultTan),
	GREYHOUND_ADULT_GREY(16374, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::greyhoundAdultGrey),
	GREYHOUND_ADULT_CREAM(16375, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::greyhoundAdultCream),
	HUSKY_PUPPY_BLACK_WHITE(16436, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::huskyPuppyBlackWhite),
	HUSKY_PUPPY_GREY(16437, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::huskyPuppyGrey),
	HUSKY_PUPPY_CHOCOLATE(16438, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::huskyPuppyChocolate),
	HUSKY_ADULT_BLACK_WHITE(16376, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::huskyAdultBlackWhite),
	HUSKY_ADULT_GREY(16377, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::huskyAdultGrey),
	HUSKY_ADULT_CHOCOLATE(16378, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::huskyAdultChocolate),
	LABRADOR_PUPPY_GOLDEN(16433, AnimationID.DOG_UPDATE_SMALL_DOG_READY_SIMPLE, HealthyDogsConfig::labradorPuppyGolden),
	LABRADOR_PUPPY_CHOCOLATE(16434, AnimationID.DOG_UPDATE_SMALL_DOG_READY_SIMPLE, HealthyDogsConfig::labradorPuppyChocolate),
	LABRADOR_PUPPY_BLACK(16435, AnimationID.DOG_UPDATE_SMALL_DOG_READY_SIMPLE, HealthyDogsConfig::labradorPuppyBlack),
	LABRADOR_ADULT_GOLDEN(16361, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::labradorAdultGolden),
	LABRADOR_ADULT_CHOCOLATE(16362, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::labradorAdultChocolate),
	LABRADOR_ADULT_BLACK(16363, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::labradorAdultBlack),
	PUG_PUPPY_FAWN(16451, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::pugPuppyFawn),
	PUG_PUPPY_BROWN(16452, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::pugPuppyBrown),
	PUG_PUPPY_BLACK(16453, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::pugPuppyBlack),
	PUG_ADULT_FAWN(16379, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::pugAdultFawn),
	PUG_ADULT_BROWN(16380, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::pugAdultBrown),
	PUG_ADULT_BLACK(16381, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::pugAdultBlack),
	SAMOYED_PUPPY_WHITE(16454, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::samoyedPuppyWhite),
	SAMOYED_PUPPY_GOLDEN(16455, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::samoyedPuppyGolden),
	SAMOYED_PUPPY_BLACK(16456, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::samoyedPuppyBlack),
	SAMOYED_ADULT_WHITE(16382, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::samoyedAdultWhite),
	SAMOYED_ADULT_GOLDEN(16383, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::samoyedAdultGolden),
	SAMOYED_ADULT_BLACK(16384, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::samoyedAdultBlack),
	SHIBA_PUPPY_TAN(16460, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::shibaPuppyTan),
	SHIBA_PUPPY_WHITE(16461, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::shibaPuppyWhite),
	SHIBA_PUPPY_TOASTED(16462, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::shibaPuppyToasted),
	SHIBA_ADULT_TAN(16388, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::shibaAdultTan),
	SHIBA_ADULT_WHITE(16389, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::shibaAdultWhite),
	SHIBA_ADULT_TOASTED(16390, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::shibaAdultToasted),
	SPANIEL_PUPPY_RED(16463, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::spanielPuppyRed),
	SPANIEL_PUPPY_WHITE(16464, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::spanielPuppyWhite),
	SPANIEL_PUPPY_BLACK(16465, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::spanielPuppyBlack),
	SPANIEL_ADULT_RED(16391, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::spanielAdultRed),
	SPANIEL_ADULT_WHITE(16392, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::spanielAdultWhite),
	SPANIEL_ADULT_BLACK(16393, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::spanielAdultBlack),
	YORKIE_PUPPY_BROWN(16466, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::yorkiePuppyBrown),
	YORKIE_PUPPY_WHITE(16467, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::yorkiePuppyWhite),
	YORKIE_PUPPY_GOLDEN(16468, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::yorkiePuppyGolden),
	YORKIE_ADULT_BROWN(16394, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::yorkieAdultBrown),
	YORKIE_ADULT_WHITE(16395, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::yorkieAdultWhite),
	YORKIE_ADULT_GOLDEN(16396, AnimationID.DOG_UPDATE_SMALL_DOG_READY, HealthyDogsConfig::yorkieAdultGolden);

	final int npcId;
	final int idleAnimation;
	private final Predicate<HealthyDogsConfig> selected;

	DogVariant(int npcId, int idleAnimation, Predicate<HealthyDogsConfig> selected)
	{
		this.npcId = npcId;
		this.idleAnimation = idleAnimation;
		this.selected = selected;
	}

	static DogVariant choose(int originalNpcId, HealthyDogsConfig config, Random random)
	{
		if (originalNpcId == NpcID.XMAS24_STRAYDOG_FINAL || !config.randomBreeds())
		{
			return null;
		}
		List<DogVariant> favorites = new ArrayList<>();
		for (DogVariant variant : values())
		{
			if (variant.selected.test(config))
			{
				favorites.add(variant);
			}
		}
		return favorites.isEmpty() ? null : favorites.get(random.nextInt(favorites.size()));
	}
}

