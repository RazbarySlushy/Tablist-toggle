package de.nauren.tablisttoggle.platform;

import java.nio.file.Path;

public interface Platform {
	boolean isModLoaded(String modId);

	ModLoader loader();

	String mcVersion();

	/** The loader's config directory (e.g. {@code .minecraft/config}). */
	Path configDir();

	boolean isDevelopmentEnvironment();

	default boolean isDebug() {
		return isDevelopmentEnvironment();
	}

	enum ModLoader {
		FABRIC, NEOFORGE, FORGE, QUILT
	}
}
