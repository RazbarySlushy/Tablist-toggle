package de.nauren.tablisttoggle.mixin;

import de.nauren.tablisttoggle.TablistToggleState;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Resets the toggle to hidden whenever a new level is entered, so the tab list always
 * starts hidden on world/server join (the mode itself is persisted, the shown-state is not).
 */
@Mixin(Minecraft.class)
public abstract class MinecraftMixin {

	@Inject(method = "setLevel", at = @At("HEAD"))
	private void tablisttoggle$resetOnJoin(CallbackInfo ci) {
		TablistToggleState.visible = false;
	}
}
