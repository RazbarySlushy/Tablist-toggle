package de.nauren.tablisttoggle.platform.fabric;

//? fabric {

import de.nauren.tablisttoggle.TablistToggle;
import net.fabricmc.api.ClientModInitializer;

public class FabricClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		TablistToggle.onInitializeClient();
	}

}
//?}
