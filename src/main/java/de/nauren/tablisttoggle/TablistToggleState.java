package de.nauren.tablisttoggle;

/**
 * Runtime state shared between the mixins and the options screen.
 *
 * <p>{@link #mode} is the persisted HELD/TOGGLE preference. {@link #visible} is the
 * transient "is the tab list currently shown" flag used only in {@link Mode#TOGGLE}
 * mode; it is deliberately <b>not</b> persisted and is reset to {@code false} every
 * time the player joins a world or server.</p>
 */
public final class TablistToggleState {

	private static volatile Mode mode = Mode.HELD;

	/** Whether the tab list is currently toggled on (only meaningful in TOGGLE mode). */
	public static volatile boolean visible = false;

	private TablistToggleState() {
	}

	public static Mode mode() {
		return mode;
	}

	/** Sets the mode and persists it to disk. */
	public static void setMode(Mode newMode) {
		if (newMode == null || newMode == mode) {
			return;
		}
		mode = newMode;
		// Leaving TOGGLE mode should not strand a "shown" state behind.
		if (mode == Mode.HELD) {
			visible = false;
		}
		TablistToggleConfig.save();
	}

	/** Used by the config loader to apply the persisted value without re-saving. */
	static void setModeSilently(Mode newMode) {
		if (newMode != null) {
			mode = newMode;
		}
	}
}
