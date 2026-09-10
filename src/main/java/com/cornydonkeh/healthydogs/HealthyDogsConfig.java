package com.cornydonkeh.healthydogs;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup(HealthyDogsConfig.GROUP)
public interface HealthyDogsConfig extends Config
{
	// Preserve existing saved preferences from development versions.
	String GROUP = "healthydogs";
	String HEAL_VARROCK_DOGS = "healVarrockStray";

	@ConfigItem(
		keyName = HEAL_VARROCK_DOGS,
		name = "Heal Varrock Dogs",
		description = "Make Varrock's stray dogs and Duke appear healthy. This cosmetic change is local to your client."
	)
	default boolean healVarrockDogs()
	{
		return true;
	}

	@ConfigItem(keyName = "randomBreeds", name = "Random favorite breeds", description = "Replace strays with a random checked appearance when encountered. Duke stays Duke. No favorites selected: normal healing.", position = 1)
	default boolean randomBreeds()
	{
		return false;
	}

	@ConfigSection(name = "Bernese Mountain Dog", description = "Favorite Bernese Mountain Dog appearances", position = 10, closedByDefault = true)
	String berneseSection = "bernese";

	@ConfigItem(keyName = "bernesePuppyChocolate", name = "Puppy: Chocolate", description = "Include Bernese Mountain Dog puppy (chocolate) in random appearances.", section = berneseSection, position = 0)
	default boolean bernesePuppyChocolate()
	{
		return false;
	}

	@ConfigItem(keyName = "bernesePuppyMerle", name = "Puppy: Merle", description = "Include Bernese Mountain Dog puppy (merle) in random appearances.", section = berneseSection, position = 1)
	default boolean bernesePuppyMerle()
	{
		return false;
	}

	@ConfigItem(keyName = "bernesePuppyToasted", name = "Puppy: Toasted", description = "Include Bernese Mountain Dog puppy (toasted) in random appearances.", section = berneseSection, position = 2)
	default boolean bernesePuppyToasted()
	{
		return false;
	}

	@ConfigItem(keyName = "berneseAdultChocolate", name = "Adult: Chocolate", description = "Include Bernese Mountain Dog adult (chocolate) in random appearances.", section = berneseSection, position = 3)
	default boolean berneseAdultChocolate()
	{
		return false;
	}

	@ConfigItem(keyName = "berneseAdultMerle", name = "Adult: Merle", description = "Include Bernese Mountain Dog adult (merle) in random appearances.", section = berneseSection, position = 4)
	default boolean berneseAdultMerle()
	{
		return false;
	}

	@ConfigItem(keyName = "berneseAdultToasted", name = "Adult: Toasted", description = "Include Bernese Mountain Dog adult (toasted) in random appearances.", section = berneseSection, position = 5)
	default boolean berneseAdultToasted()
	{
		return false;
	}

	@ConfigSection(name = "Border Collie", description = "Favorite Border Collie appearances", position = 11, closedByDefault = true)
	String borderCollieSection = "borderCollie";

	@ConfigItem(keyName = "borderColliePuppyChocolate", name = "Puppy: Chocolate", description = "Include Border Collie puppy (chocolate) in random appearances.", section = borderCollieSection, position = 0)
	default boolean borderColliePuppyChocolate()
	{
		return false;
	}

	@ConfigItem(keyName = "borderColliePuppyMerle", name = "Puppy: Merle", description = "Include Border Collie puppy (merle) in random appearances.", section = borderCollieSection, position = 1)
	default boolean borderColliePuppyMerle()
	{
		return false;
	}

	@ConfigItem(keyName = "borderColliePuppyBlackWhite", name = "Puppy: Black & white", description = "Include Border Collie puppy (black & white) in random appearances.", section = borderCollieSection, position = 2)
	default boolean borderColliePuppyBlackWhite()
	{
		return false;
	}

	@ConfigItem(keyName = "borderCollieAdultChocolate", name = "Adult: Chocolate", description = "Include Border Collie adult (chocolate) in random appearances.", section = borderCollieSection, position = 3)
	default boolean borderCollieAdultChocolate()
	{
		return false;
	}

	@ConfigItem(keyName = "borderCollieAdultMerle", name = "Adult: Merle", description = "Include Border Collie adult (merle) in random appearances.", section = borderCollieSection, position = 4)
	default boolean borderCollieAdultMerle()
	{
		return false;
	}

	@ConfigItem(keyName = "borderCollieAdultBlackWhite", name = "Adult: Black & white", description = "Include Border Collie adult (black & white) in random appearances.", section = borderCollieSection, position = 5)
	default boolean borderCollieAdultBlackWhite()
	{
		return false;
	}

	@ConfigSection(name = "Chihuahua", description = "Favorite Chihuahua appearances", position = 12, closedByDefault = true)
	String chihuahuaSection = "chihuahua";

	@ConfigItem(keyName = "chihuahuaPuppyTan", name = "Puppy: Tan", description = "Include Chihuahua puppy (tan) in random appearances.", section = chihuahuaSection, position = 0)
	default boolean chihuahuaPuppyTan()
	{
		return false;
	}

	@ConfigItem(keyName = "chihuahuaPuppyWhite", name = "Puppy: White", description = "Include Chihuahua puppy (white) in random appearances.", section = chihuahuaSection, position = 1)
	default boolean chihuahuaPuppyWhite()
	{
		return false;
	}

	@ConfigItem(keyName = "chihuahuaPuppyToasted", name = "Puppy: Toasted", description = "Include Chihuahua puppy (toasted) in random appearances.", section = chihuahuaSection, position = 2)
	default boolean chihuahuaPuppyToasted()
	{
		return false;
	}

	@ConfigItem(keyName = "chihuahuaAdultTan", name = "Adult: Tan", description = "Include Chihuahua adult (tan) in random appearances.", section = chihuahuaSection, position = 3)
	default boolean chihuahuaAdultTan()
	{
		return false;
	}

	@ConfigItem(keyName = "chihuahuaAdultWhite", name = "Adult: White", description = "Include Chihuahua adult (white) in random appearances.", section = chihuahuaSection, position = 4)
	default boolean chihuahuaAdultWhite()
	{
		return false;
	}

	@ConfigItem(keyName = "chihuahuaAdultToasted", name = "Adult: Toasted", description = "Include Chihuahua adult (toasted) in random appearances.", section = chihuahuaSection, position = 5)
	default boolean chihuahuaAdultToasted()
	{
		return false;
	}

	@ConfigSection(name = "Corgi", description = "Favorite Corgi appearances", position = 13, closedByDefault = true)
	String corgiSection = "corgi";

	@ConfigItem(keyName = "corgiPuppyTan", name = "Puppy: Tan", description = "Include Corgi puppy (tan) in random appearances.", section = corgiSection, position = 0)
	default boolean corgiPuppyTan()
	{
		return false;
	}

	@ConfigItem(keyName = "corgiPuppyFawn", name = "Puppy: Fawn", description = "Include Corgi puppy (fawn) in random appearances.", section = corgiSection, position = 1)
	default boolean corgiPuppyFawn()
	{
		return false;
	}

	@ConfigItem(keyName = "corgiPuppyToasted", name = "Puppy: Toasted", description = "Include Corgi puppy (toasted) in random appearances.", section = corgiSection, position = 2)
	default boolean corgiPuppyToasted()
	{
		return false;
	}

	@ConfigItem(keyName = "corgiAdultTan", name = "Adult: Tan", description = "Include Corgi adult (tan) in random appearances.", section = corgiSection, position = 3)
	default boolean corgiAdultTan()
	{
		return false;
	}

	@ConfigItem(keyName = "corgiAdultFawn", name = "Adult: Fawn", description = "Include Corgi adult (fawn) in random appearances.", section = corgiSection, position = 4)
	default boolean corgiAdultFawn()
	{
		return false;
	}

	@ConfigItem(keyName = "corgiAdultToasted", name = "Adult: Toasted", description = "Include Corgi adult (toasted) in random appearances.", section = corgiSection, position = 5)
	default boolean corgiAdultToasted()
	{
		return false;
	}

	@ConfigSection(name = "Greyhound", description = "Favorite Greyhound appearances", position = 14, closedByDefault = true)
	String greyhoundSection = "greyhound";

	@ConfigItem(keyName = "greyhoundPuppyTan", name = "Puppy: Tan", description = "Include Greyhound puppy (tan) in random appearances.", section = greyhoundSection, position = 0)
	default boolean greyhoundPuppyTan()
	{
		return false;
	}

	@ConfigItem(keyName = "greyhoundPuppyGrey", name = "Puppy: Grey", description = "Include Greyhound puppy (grey) in random appearances.", section = greyhoundSection, position = 1)
	default boolean greyhoundPuppyGrey()
	{
		return false;
	}

	@ConfigItem(keyName = "greyhoundPuppyCream", name = "Puppy: Cream", description = "Include Greyhound puppy (cream) in random appearances.", section = greyhoundSection, position = 2)
	default boolean greyhoundPuppyCream()
	{
		return false;
	}

	@ConfigItem(keyName = "greyhoundAdultTan", name = "Adult: Tan", description = "Include Greyhound adult (tan) in random appearances.", section = greyhoundSection, position = 3)
	default boolean greyhoundAdultTan()
	{
		return false;
	}

	@ConfigItem(keyName = "greyhoundAdultGrey", name = "Adult: Grey", description = "Include Greyhound adult (grey) in random appearances.", section = greyhoundSection, position = 4)
	default boolean greyhoundAdultGrey()
	{
		return false;
	}

	@ConfigItem(keyName = "greyhoundAdultCream", name = "Adult: Cream", description = "Include Greyhound adult (cream) in random appearances.", section = greyhoundSection, position = 5)
	default boolean greyhoundAdultCream()
	{
		return false;
	}

	@ConfigSection(name = "Husky", description = "Favorite Husky appearances", position = 15, closedByDefault = true)
	String huskySection = "husky";

	@ConfigItem(keyName = "huskyPuppyBlackWhite", name = "Puppy: Black & white", description = "Include Husky puppy (black & white) in random appearances.", section = huskySection, position = 0)
	default boolean huskyPuppyBlackWhite()
	{
		return false;
	}

	@ConfigItem(keyName = "huskyPuppyGrey", name = "Puppy: Grey", description = "Include Husky puppy (grey) in random appearances.", section = huskySection, position = 1)
	default boolean huskyPuppyGrey()
	{
		return false;
	}

	@ConfigItem(keyName = "huskyPuppyChocolate", name = "Puppy: Chocolate", description = "Include Husky puppy (chocolate) in random appearances.", section = huskySection, position = 2)
	default boolean huskyPuppyChocolate()
	{
		return false;
	}

	@ConfigItem(keyName = "huskyAdultBlackWhite", name = "Adult: Black & white", description = "Include Husky adult (black & white) in random appearances.", section = huskySection, position = 3)
	default boolean huskyAdultBlackWhite()
	{
		return false;
	}

	@ConfigItem(keyName = "huskyAdultGrey", name = "Adult: Grey", description = "Include Husky adult (grey) in random appearances.", section = huskySection, position = 4)
	default boolean huskyAdultGrey()
	{
		return false;
	}

	@ConfigItem(keyName = "huskyAdultChocolate", name = "Adult: Chocolate", description = "Include Husky adult (chocolate) in random appearances.", section = huskySection, position = 5)
	default boolean huskyAdultChocolate()
	{
		return false;
	}

	@ConfigSection(name = "Labrador", description = "Favorite Labrador appearances", position = 16, closedByDefault = true)
	String labradorSection = "labrador";

	@ConfigItem(keyName = "labradorPuppyGolden", name = "Puppy: Golden", description = "Include Labrador puppy (golden) in random appearances.", section = labradorSection, position = 0)
	default boolean labradorPuppyGolden()
	{
		return false;
	}

	@ConfigItem(keyName = "labradorPuppyChocolate", name = "Puppy: Chocolate", description = "Include Labrador puppy (chocolate) in random appearances.", section = labradorSection, position = 1)
	default boolean labradorPuppyChocolate()
	{
		return false;
	}

	@ConfigItem(keyName = "labradorPuppyBlack", name = "Puppy: Black", description = "Include Labrador puppy (black) in random appearances.", section = labradorSection, position = 2)
	default boolean labradorPuppyBlack()
	{
		return false;
	}

	@ConfigItem(keyName = "labradorAdultGolden", name = "Adult: Golden", description = "Include Labrador adult (golden) in random appearances.", section = labradorSection, position = 3)
	default boolean labradorAdultGolden()
	{
		return false;
	}

	@ConfigItem(keyName = "labradorAdultChocolate", name = "Adult: Chocolate", description = "Include Labrador adult (chocolate) in random appearances.", section = labradorSection, position = 4)
	default boolean labradorAdultChocolate()
	{
		return false;
	}

	@ConfigItem(keyName = "labradorAdultBlack", name = "Adult: Black", description = "Include Labrador adult (black) in random appearances.", section = labradorSection, position = 5)
	default boolean labradorAdultBlack()
	{
		return false;
	}

	@ConfigSection(name = "Pug", description = "Favorite Pug appearances", position = 17, closedByDefault = true)
	String pugSection = "pug";

	@ConfigItem(keyName = "pugPuppyFawn", name = "Puppy: Fawn", description = "Include Pug puppy (fawn) in random appearances.", section = pugSection, position = 0)
	default boolean pugPuppyFawn()
	{
		return false;
	}

	@ConfigItem(keyName = "pugPuppyBrown", name = "Puppy: Brown", description = "Include Pug puppy (brown) in random appearances.", section = pugSection, position = 1)
	default boolean pugPuppyBrown()
	{
		return false;
	}

	@ConfigItem(keyName = "pugPuppyBlack", name = "Puppy: Black", description = "Include Pug puppy (black) in random appearances.", section = pugSection, position = 2)
	default boolean pugPuppyBlack()
	{
		return false;
	}

	@ConfigItem(keyName = "pugAdultFawn", name = "Adult: Fawn", description = "Include Pug adult (fawn) in random appearances.", section = pugSection, position = 3)
	default boolean pugAdultFawn()
	{
		return false;
	}

	@ConfigItem(keyName = "pugAdultBrown", name = "Adult: Brown", description = "Include Pug adult (brown) in random appearances.", section = pugSection, position = 4)
	default boolean pugAdultBrown()
	{
		return false;
	}

	@ConfigItem(keyName = "pugAdultBlack", name = "Adult: Black", description = "Include Pug adult (black) in random appearances.", section = pugSection, position = 5)
	default boolean pugAdultBlack()
	{
		return false;
	}

	@ConfigSection(name = "Samoyed", description = "Favorite Samoyed appearances", position = 18, closedByDefault = true)
	String samoyedSection = "samoyed";

	@ConfigItem(keyName = "samoyedPuppyWhite", name = "Puppy: White", description = "Include Samoyed puppy (white) in random appearances.", section = samoyedSection, position = 0)
	default boolean samoyedPuppyWhite()
	{
		return false;
	}

	@ConfigItem(keyName = "samoyedPuppyGolden", name = "Puppy: Golden", description = "Include Samoyed puppy (golden) in random appearances.", section = samoyedSection, position = 1)
	default boolean samoyedPuppyGolden()
	{
		return false;
	}

	@ConfigItem(keyName = "samoyedPuppyBlack", name = "Puppy: Black", description = "Include Samoyed puppy (black) in random appearances.", section = samoyedSection, position = 2)
	default boolean samoyedPuppyBlack()
	{
		return false;
	}

	@ConfigItem(keyName = "samoyedAdultWhite", name = "Adult: White", description = "Include Samoyed adult (white) in random appearances.", section = samoyedSection, position = 3)
	default boolean samoyedAdultWhite()
	{
		return false;
	}

	@ConfigItem(keyName = "samoyedAdultGolden", name = "Adult: Golden", description = "Include Samoyed adult (golden) in random appearances.", section = samoyedSection, position = 4)
	default boolean samoyedAdultGolden()
	{
		return false;
	}

	@ConfigItem(keyName = "samoyedAdultBlack", name = "Adult: Black", description = "Include Samoyed adult (black) in random appearances.", section = samoyedSection, position = 5)
	default boolean samoyedAdultBlack()
	{
		return false;
	}

	@ConfigSection(name = "Shiba", description = "Favorite Shiba appearances", position = 19, closedByDefault = true)
	String shibaSection = "shiba";

	@ConfigItem(keyName = "shibaPuppyTan", name = "Puppy: Tan", description = "Include Shiba puppy (tan) in random appearances.", section = shibaSection, position = 0)
	default boolean shibaPuppyTan()
	{
		return false;
	}

	@ConfigItem(keyName = "shibaPuppyWhite", name = "Puppy: White", description = "Include Shiba puppy (white) in random appearances.", section = shibaSection, position = 1)
	default boolean shibaPuppyWhite()
	{
		return false;
	}

	@ConfigItem(keyName = "shibaPuppyToasted", name = "Puppy: Toasted", description = "Include Shiba puppy (toasted) in random appearances.", section = shibaSection, position = 2)
	default boolean shibaPuppyToasted()
	{
		return false;
	}

	@ConfigItem(keyName = "shibaAdultTan", name = "Adult: Tan", description = "Include Shiba adult (tan) in random appearances.", section = shibaSection, position = 3)
	default boolean shibaAdultTan()
	{
		return false;
	}

	@ConfigItem(keyName = "shibaAdultWhite", name = "Adult: White", description = "Include Shiba adult (white) in random appearances.", section = shibaSection, position = 4)
	default boolean shibaAdultWhite()
	{
		return false;
	}

	@ConfigItem(keyName = "shibaAdultToasted", name = "Adult: Toasted", description = "Include Shiba adult (toasted) in random appearances.", section = shibaSection, position = 5)
	default boolean shibaAdultToasted()
	{
		return false;
	}

	@ConfigSection(name = "Spaniel", description = "Favorite Spaniel appearances", position = 20, closedByDefault = true)
	String spanielSection = "spaniel";

	@ConfigItem(keyName = "spanielPuppyRed", name = "Puppy: Red", description = "Include Spaniel puppy (red) in random appearances.", section = spanielSection, position = 0)
	default boolean spanielPuppyRed()
	{
		return false;
	}

	@ConfigItem(keyName = "spanielPuppyWhite", name = "Puppy: White", description = "Include Spaniel puppy (white) in random appearances.", section = spanielSection, position = 1)
	default boolean spanielPuppyWhite()
	{
		return false;
	}

	@ConfigItem(keyName = "spanielPuppyBlack", name = "Puppy: Black", description = "Include Spaniel puppy (black) in random appearances.", section = spanielSection, position = 2)
	default boolean spanielPuppyBlack()
	{
		return false;
	}

	@ConfigItem(keyName = "spanielAdultRed", name = "Adult: Red", description = "Include Spaniel adult (red) in random appearances.", section = spanielSection, position = 3)
	default boolean spanielAdultRed()
	{
		return false;
	}

	@ConfigItem(keyName = "spanielAdultWhite", name = "Adult: White", description = "Include Spaniel adult (white) in random appearances.", section = spanielSection, position = 4)
	default boolean spanielAdultWhite()
	{
		return false;
	}

	@ConfigItem(keyName = "spanielAdultBlack", name = "Adult: Black", description = "Include Spaniel adult (black) in random appearances.", section = spanielSection, position = 5)
	default boolean spanielAdultBlack()
	{
		return false;
	}

	@ConfigSection(name = "Yorkie", description = "Favorite Yorkie appearances", position = 21, closedByDefault = true)
	String yorkieSection = "yorkie";

	@ConfigItem(keyName = "yorkiePuppyBrown", name = "Puppy: Brown", description = "Include Yorkie puppy (brown) in random appearances.", section = yorkieSection, position = 0)
	default boolean yorkiePuppyBrown()
	{
		return false;
	}

	@ConfigItem(keyName = "yorkiePuppyWhite", name = "Puppy: White", description = "Include Yorkie puppy (white) in random appearances.", section = yorkieSection, position = 1)
	default boolean yorkiePuppyWhite()
	{
		return false;
	}

	@ConfigItem(keyName = "yorkiePuppyGolden", name = "Puppy: Golden", description = "Include Yorkie puppy (golden) in random appearances.", section = yorkieSection, position = 2)
	default boolean yorkiePuppyGolden()
	{
		return false;
	}

	@ConfigItem(keyName = "yorkieAdultBrown", name = "Adult: Brown", description = "Include Yorkie adult (brown) in random appearances.", section = yorkieSection, position = 3)
	default boolean yorkieAdultBrown()
	{
		return false;
	}

	@ConfigItem(keyName = "yorkieAdultWhite", name = "Adult: White", description = "Include Yorkie adult (white) in random appearances.", section = yorkieSection, position = 4)
	default boolean yorkieAdultWhite()
	{
		return false;
	}

	@ConfigItem(keyName = "yorkieAdultGolden", name = "Adult: Golden", description = "Include Yorkie adult (golden) in random appearances.", section = yorkieSection, position = 5)
	default boolean yorkieAdultGolden()
	{
		return false;
	}

}
