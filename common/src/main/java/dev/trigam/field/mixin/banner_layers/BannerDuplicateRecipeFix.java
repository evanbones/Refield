package dev.trigam.field.mixin.banner_layers;

import dev.trigam.field.config.ModConfig;
import net.minecraft.world.item.crafting.BannerDuplicateRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(BannerDuplicateRecipe.class)
public class BannerDuplicateRecipeFix {

    @ModifyConstant(
            method = "matches(Lnet/minecraft/world/item/crafting/CraftingInput;Lnet/minecraft/world/level/Level;)Z",
            constant = @Constant(intValue = 6)
    )
    private int getMatchesLayerLimit(int limit) {
        return ModConfig.get().bannerLayers;
    }

    @ModifyConstant(
            method = "assemble(Lnet/minecraft/world/item/crafting/CraftingInput;Lnet/minecraft/core/HolderLookup$Provider;)Lnet/minecraft/world/item/ItemStack;",
            constant = @Constant(intValue = 6)
    )
    private int getAssembleLayerLimit(int limit) {
        return ModConfig.get().bannerLayers;
    }
}
