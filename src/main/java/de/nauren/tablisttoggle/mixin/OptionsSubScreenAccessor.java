package de.nauren.tablisttoggle.mixin;

import net.minecraft.client.gui.components.OptionsList;
//? >= 1.21 {
import net.minecraft.client.gui.screens.options.OptionsSubScreen;
//?} else {
/*import net.minecraft.client.gui.screens.OptionsSubScreen;
*///?}
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * Accesses the {@code list} field of {@link OptionsSubScreen}. It lives on the superclass,
 * so a {@code @Shadow} on the {@code ControlsScreen} subclass can't resolve it — an
 * accessor on the declaring class does.
 */
@Mixin(OptionsSubScreen.class)
public interface OptionsSubScreenAccessor {

	@Accessor("list")
	OptionsList tablisttoggle$getOptionsList();
}
