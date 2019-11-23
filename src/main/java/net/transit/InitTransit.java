package net.transit;

import net.fabricmc.api.ModInitializer;
import net.transit.type.group.simple.SimpleGroups;

public class InitTransit implements ModInitializer {
	
	@Override
	public void onInitialize() {
		SimpleGroups.init();
	}

}
