package de.nauren.tablisttoggle;

/**
 * How the player-list (tab list) key behaves.
 *
 * <ul>
 *     <li>{@link #HELD} – vanilla behaviour: the list shows only while the key is held.</li>
 *     <li>{@link #TOGGLE} – pressing the key flips the list on/off until pressed again.</li>
 * </ul>
 */
public enum Mode {
	HELD,
	TOGGLE;

	public Mode other() {
		return this == HELD ? TOGGLE : HELD;
	}
}
