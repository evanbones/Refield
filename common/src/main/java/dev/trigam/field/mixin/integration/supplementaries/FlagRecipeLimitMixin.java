package dev.trigam.field.mixin.integration.supplementaries;

import dev.trigam.field.config.ModConfig;
import net.mehvahdjukaar.supplementaries.common.items.crafting.FlagFromBannerRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = FlagFromBannerRecipe.class, remap = false)
public class FlagRecipeLimitMixin {

    @Inject(method = "getMaxBannerPatterns", at = @At("HEAD"), cancellable = true, remap = false)
    private static void getRefieldMaxPatterns(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(ModConfig.get().bannerLayers);
    }
}
