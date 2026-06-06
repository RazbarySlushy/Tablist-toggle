package de.nauren.tablisttoggle;

import de.nauren.tablisttoggle.platform.Platform;

import java.util.logging.Logger;

//? fabric {
import de.nauren.tablisttoggle.platform.fabric.FabricPlatform;
//?} neoforge {
/*import de.nauren.tablisttoggle.platform.neoforge.NeoforgePlatform;
 *///?}

public class TablistToggle {

	public static final String MOD_ID = /*$ mod_id*/ "tablisttoggle";
	public static final String MOD_VERSION = /*$ mod_version*/ "1.0.0";
	public static final String MOD_FRIENDLY_NAME = /*$ mod_name*/ "Tablist Toggle";
	public static final Logger LOGGER = Logger.getLogger(MOD_ID);

	private static final Platform PLATFORM = createPlatformInstance();

	public static void onInitialize() {
		LOGGER.fine(() -> "Initializing " + MOD_ID + " on " + xplat().loader());
	}

	public static void onInitializeClient() {
		LOGGER.fine(() -> "Initializing " + MOD_ID + " client on " + xplat().loader());
		TablistToggleConfig.load();
	}

	public static Platform xplat() {
		return PLATFORM;
	}

	private static Platform createPlatformInstance() {
		//? fabric {
		return new FabricPlatform();
		//?} neoforge {
		/*return new NeoforgePlatform();
		 *///?}
	}
}
