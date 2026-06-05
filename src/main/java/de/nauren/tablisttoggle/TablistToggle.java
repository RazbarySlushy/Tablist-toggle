package de.nauren.tablisttoggle;

import de.nauren.tablisttoggle.platform.Platform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//? fabric {
import de.nauren.tablisttoggle.platform.fabric.FabricPlatform;
//?} neoforge {
/*import de.nauren.tablisttoggle.platform.neoforge.NeoforgePlatform;
 *///?}

public class TablistToggle {

	public static final String MOD_ID = /*$ mod_id*/ "tablisttoggle";
	public static final String MOD_VERSION = /*$ mod_version*/ "1.0.0";
	public static final String MOD_FRIENDLY_NAME = /*$ mod_name*/ "Tablist Toggle";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final Platform PLATFORM = createPlatformInstance();

	public static void onInitialize() {
		LOGGER.debug("Initializing {} on {}", MOD_ID, xplat().loader());
	}

	public static void onInitializeClient() {
		LOGGER.debug("Initializing {} client on {}", MOD_ID, xplat().loader());
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
