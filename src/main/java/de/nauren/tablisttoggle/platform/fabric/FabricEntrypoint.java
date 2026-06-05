package de.nauren.tablisttoggle.platform.fabric;

//? fabric {

import de.nauren.tablisttoggle.TablistToggle;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ModInitializer;

@Entrypoint("main")
public class FabricEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		TablistToggle.onInitialize();
	}
}
//?}
