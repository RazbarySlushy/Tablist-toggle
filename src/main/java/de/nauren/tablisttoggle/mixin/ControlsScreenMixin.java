package de.nauren.tablisttoggle.mixin;

import de.nauren.tablisttoggle.TablistToggleOptions;
import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.client.gui.screens.options.controls.ControlsScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Adds the "Tablist: HELD/TOGGLE" option to the Controls screen, right after the vanilla
 * Toggle Sneak / Toggle Sprint options. The options list lives on the superclass, so it is
 * fetched via {@link OptionsSubScreenAccessor} rather than a {@code @Shadow}.
 */
@Mixin(ControlsScreen.class)
@MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
public abstract class ControlsScreenMixin {

	@Inject(method = "addOptions", at = @At("TAIL"))
	private void tablisttoggle$addTablistOption(CallbackInfo ci) {
		OptionsList list = ((OptionsSubScreenAccessor) this).tablisttoggle$getOptionsList();
		if (list != null) {
			list.addSmall(TablistToggleOptions.modeOption());
		}
	}
}
