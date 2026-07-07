package dev.trigam.field.mixin.client.banner_layers;

import dev.trigam.field.config.ModConfig;
import net.minecraft.client.gui.screens.inventory.LoomScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(LoomScreen.class)
public class LoomScreenFix {

    @ModifyConstant(
            method = "containerChanged()V",
            constant = @Constant(intValue = 6)
    )
    private int getLayerLimit(int limit) {
        return ModConfig.get().bannerLayers;
    }
}
