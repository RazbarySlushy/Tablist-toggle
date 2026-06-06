package de.nauren.tablisttoggle.mixin;

import com.mojang.blaze3d.platform.InputConstants;
import de.nauren.tablisttoggle.Mode;
import de.nauren.tablisttoggle.TablistToggleState;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Drives the tab list from our toggle state.
 *
 * <p>The HUD decides whether to render the player list by querying
 * {@code minecraft.options.keyPlayerList.isDown()}. In {@link Mode#TOGGLE} we make that
 * call return our {@link TablistToggleState#visible} flag instead of the physical key
 * state, and we flip the flag on each fresh press via the static {@code click} hook.</p>
 */
@Mixin(KeyMapping.class)
public abstract class KeyMappingMixin {

	@Inject(method = "isDown", at = @At("HEAD"), cancellable = true)
	private void tablisttoggle$overrideTabListHold(CallbackInfoReturnable<Boolean> cir) {
		if (TablistToggleState.mode() != Mode.TOGGLE) {
			return;
		}
		Minecraft mc = Minecraft.getInstance();
		if (mc == null || mc.options == null) {
			return;
		}
		if ((Object) this == mc.options.keyPlayerList) {
			cir.setReturnValue(TablistToggleState.visible);
		}
	}

	@Inject(method = "click", at = @At("HEAD"))
	private static void tablisttoggle$onPress(InputConstants.Key key, CallbackInfo ci) {
		if (TablistToggleState.mode() != Mode.TOGGLE) {
			return;
		}
		Minecraft mc = Minecraft.getInstance();
		if (mc == null || mc.options == null || mc.screen != null) {
			return;
		}
		InputConstants.Key bound = ((KeyMappingAccessor) (Object) mc.options.keyPlayerList).tablisttoggle$getBoundKey();
		if (key.equals(bound)) {
			TablistToggleState.visible = !TablistToggleState.visible;
		}
	}
}
