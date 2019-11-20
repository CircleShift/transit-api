package net.transit;

import net.fabricmc.api.ModInitializer;
import net.transit.type.group.simple.SimpleGroups;
import net.transit.type.simple.SimpleTypes;

public class InitTransit implements ModInitializer {
	
	@Override
	public void onInitialize() {
		SimpleGroups.initGroups();
		SimpleTypes.initTypes();
	}

}
