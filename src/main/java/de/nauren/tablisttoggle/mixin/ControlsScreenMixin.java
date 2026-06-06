package de.nauren.tablisttoggle.mixin;

import de.nauren.tablisttoggle.TablistToggleOptions;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.gui.components.OptionsList;
//? >= 1.21 {
import net.minecraft.client.gui.screens.options.controls.ControlsScreen;
//?} else {
/*import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.controls.ControlsScreen;
*///?}
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Adds the "Tablist: Hold/Toggle" option to the Controls screen.
 *
 * <p>1.21+ exposes {@code addOptions()} and keeps the options list as a field on
 * {@code OptionsSubScreen} (read via {@link OptionsSubScreenAccessor}). Older versions build
 * the list inside {@code init()} and add it as a child widget, so we inject there and find
 * the {@link OptionsList} among the screen's children.</p>
 */
@Mixin(ControlsScreen.class)
public abstract class ControlsScreenMixin {

	//? >= 1.21 {
	@Inject(method = "addOptions", at = @At("TAIL"))
	private void tablisttoggle$addTablistOption(CallbackInfo ci) {
		OptionsList list = ((OptionsSubScreenAccessor) this).tablisttoggle$getOptionsList();
		if (list != null) {
			list.addSmall(new OptionInstance<?>[]{TablistToggleOptions.modeOption()});
		}
	}
	//?} else {
	/*@Inject(method = "init", at = @At("TAIL"))
	private void tablisttoggle$addTablistOption(CallbackInfo ci) {
		for (GuiEventListener child : ((Screen) (Object) this).children()) {
			if (child instanceof OptionsList) {
				((OptionsList) child).addSmall(new OptionInstance<?>[]{TablistToggleOptions.modeOption()});
				return;
			}
		}
	}
	*///?}
}
