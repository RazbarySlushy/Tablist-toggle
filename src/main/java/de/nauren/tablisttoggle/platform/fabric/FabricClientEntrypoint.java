package de.nauren.tablisttoggle.platform.fabric;

//? fabric {

import de.nauren.tablisttoggle.TablistToggle;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ClientModInitializer;

@Entrypoint("client")
public class FabricClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		TablistToggle.onInitializeClient();
	}

}
//?}
