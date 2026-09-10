package com.cornydonkeh.healthydogs;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class HealthyDogsPluginLauncher
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(HealthyDogsPlugin.class);
		RuneLite.main(args);
	}
}
