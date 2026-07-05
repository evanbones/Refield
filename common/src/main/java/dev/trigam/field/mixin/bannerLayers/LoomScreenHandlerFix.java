package dev.trigam.field.mixin.bannerLayers;

import dev.trigam.field.config.ModConfig;
import net.minecraft.world.inventory.LoomMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(LoomMenu.class)
public class LoomScreenHandlerFix {

    @ModifyConstant(
            method = "slotsChanged(Lnet/minecraft/world/Container;)V",
            constant = @Constant(intValue = 6)
    )
    private int getLayerLimit(int limit) {
        return ModConfig.get().bannerLayers;
    }
}
