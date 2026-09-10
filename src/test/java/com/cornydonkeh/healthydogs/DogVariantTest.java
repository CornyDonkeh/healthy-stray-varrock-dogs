package com.cornydonkeh.healthydogs;

import java.util.EnumSet;
import java.util.Random;
import net.runelite.api.gameval.NpcID;
import org.junit.Test;
import static org.junit.Assert.*;

public class DogVariantTest
{
	private final HealthyDogsConfig favorites = new HealthyDogsConfig()
	{
		@Override
		public boolean randomBreeds() { return true; }
		@Override
		public boolean corgiPuppyFawn() { return true; }
		@Override
		public boolean labradorAdultChocolate() { return true; }
	};

	@Test
	public void dukeNeverChangesBreed()
	{
		assertNull(DogVariant.choose(NpcID.XMAS24_STRAYDOG_FINAL, favorites, new Random(1)));
	}

	@Test
	public void emptyFavoritesFallBackToHealing()
	{
		HealthyDogsConfig empty = new HealthyDogsConfig()
		{
			@Override
			public boolean randomBreeds() { return true; }
		};
		assertNull(DogVariant.choose(NpcID.DOG_STRAY2, empty, new Random(1)));
	}

	@Test
	public void disablingRandomizationPreservesFavoriteSettingsButUsesHealing()
	{
		HealthyDogsConfig disabled = new HealthyDogsConfig()
		{
			@Override
			public boolean corgiPuppyFawn() { return true; }
		};
		assertNull(DogVariant.choose(NpcID.DOG_STRAY, disabled, new Random(1)));
	}

	@Test
	public void randomChoicesUseOnlyExactCheckedAgeAndColorCombinations()
	{
		Random random = new Random(42);
		EnumSet<DogVariant> seen = EnumSet.noneOf(DogVariant.class);
		for (int i = 0; i < 100; i++)
		{
			DogVariant choice = DogVariant.choose(NpcID.DOG_STRAY, favorites, random);
			assertTrue(choice == DogVariant.CORGI_PUPPY_FAWN || choice == DogVariant.LABRADOR_ADULT_CHOCOLATE);
			seen.add(choice);
		}
		assertEquals(EnumSet.of(DogVariant.CORGI_PUPPY_FAWN, DogVariant.LABRADOR_ADULT_CHOCOLATE), seen);
	}
}
