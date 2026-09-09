package com.example;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("healthydogs")
public interface HealthyDogsConfig extends Config
{
	@ConfigItem(
		keyName = "healVarrockStray",
		name = "Heal Varrock Dogs",
		description = "Give's Varrock's stray dogs and Charlie's dog, Duke, a loving veterinary treatment, including a bath!"
	)
	default boolean healVarrockStray()
	{
		return true;
	}
}
