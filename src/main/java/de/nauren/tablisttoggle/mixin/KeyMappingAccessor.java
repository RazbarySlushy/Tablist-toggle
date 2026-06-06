package de.nauren.tablisttoggle.mixin;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * Reads the bound key of a {@link KeyMapping}. Used instead of {@code KeyMapping#getKey()}
 * because that accessor was removed in 1.21.11+ / 26.x; the {@code key} field is stable.
 */
@Mixin(KeyMapping.class)
public interface KeyMappingAccessor {

	@Accessor("key")
	InputConstants.Key tablisttoggle$getBoundKey();
}
