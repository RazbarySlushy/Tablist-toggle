package de.nauren.tablisttoggle;

import net.minecraft.client.OptionInstance;
import net.minecraft.network.chat.Component;

/**
 * Builds the "Tablist: HELD/TOGGLE" option shown on the Controls screen next to the
 * vanilla Sprint/Sneak toggles. Client-only: only referenced from a client mixin.
 */
public final class TablistToggleOptions {

	private TablistToggleOptions() {
	}

	public static OptionInstance<Boolean> modeOption() {
		// The button widget already renders "<caption>: <value>", so the value stringifier
		// must return only the value label (else the caption is shown twice).
		return new OptionInstance<>(
				"tablisttoggle.option.mode",
				OptionInstance.noTooltip(),
				(caption, value) -> Component.translatable(value
						? "tablisttoggle.option.mode.toggle"
						: "tablisttoggle.option.mode.held"),
				OptionInstance.BOOLEAN_VALUES,
				TablistToggleState.mode() == Mode.TOGGLE,
				value -> TablistToggleState.setMode(value ? Mode.TOGGLE : Mode.HELD));
	}
}
