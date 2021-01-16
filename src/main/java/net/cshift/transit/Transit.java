package net.cshift.transit;

import net.fabricmc.api.ModInitializer;
import net.cshift.transit.type.group.simple.SimpleGroups;

public class Transit implements ModInitializer {

	@Override
	public void onInitialize() {
		SimpleGroups.init();
	}

}
