package net.cshift.transit;

import net.fabricmc.api.ModInitializer;
import net.cshift.transit.type.group.SimpleGroups;

/**
 * @author Kyle Gunger
 * @apiNote This is the main entry point for Transit.  The api is mostly intended for use on server-side connections.
 */
public class Transit implements ModInitializer {

	@Override
	public void onInitialize() {
		SimpleGroups.init();
	}

}
