package de.nauren.tablisttoggle;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * Tiny properties-backed config. Only the {@link Mode} is persisted; it survives
 * restarts and applies to every world/server.
 */
public final class TablistToggleConfig {

	private static final String FILE_NAME = "tablisttoggle.properties";
	private static final String KEY_MODE = "mode";

	private TablistToggleConfig() {
	}

	private static Path configFile() {
		return TablistToggle.xplat().configDir().resolve(FILE_NAME);
	}

	public static void load() {
		Path file = configFile();
		try {
			if (Files.exists(file)) {
				Properties props = new Properties();
				try (Reader reader = Files.newBufferedReader(file)) {
					props.load(reader);
				}
				String raw = props.getProperty(KEY_MODE, Mode.HELD.name());
				try {
					TablistToggleState.setModeSilently(Mode.valueOf(raw.trim().toUpperCase()));
				} catch (IllegalArgumentException ignored) {
					TablistToggleState.setModeSilently(Mode.HELD);
				}
			} else {
				save();
			}
		} catch (Exception e) {
			TablistToggle.LOGGER.warn("[{}] Could not read config, using defaults", TablistToggle.MOD_ID, e);
		}
	}

	public static void save() {
		Path file = configFile();
		try {
			Files.createDirectories(file.getParent());
			Properties props = new Properties();
			props.setProperty(KEY_MODE, TablistToggleState.mode().name());
			try (Writer writer = Files.newBufferedWriter(file)) {
				props.store(writer, "Tablist Toggle settings");
			}
		} catch (Exception e) {
			TablistToggle.LOGGER.warn("[{}] Could not write config", TablistToggle.MOD_ID, e);
		}
	}
}
