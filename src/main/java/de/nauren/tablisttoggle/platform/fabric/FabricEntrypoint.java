package de.nauren.tablisttoggle.platform.fabric;

//? fabric {

import de.nauren.tablisttoggle.TablistToggle;
import net.fabricmc.api.ModInitializer;

public class FabricEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		TablistToggle.onInitialize();
	}
}
//?}
