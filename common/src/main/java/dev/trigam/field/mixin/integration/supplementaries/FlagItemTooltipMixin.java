package dev.trigam.field.mixin.integration.supplementaries;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.trigam.field.util.Tooltip;
import net.mehvahdjukaar.supplementaries.common.items.FlagItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(value = FlagItem.class, remap = false)
public class FlagItemTooltipMixin {

    @WrapOperation(
            method = "appendHoverText(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/Item$TooltipContext;Ljava/util/List;Lnet/minecraft/world/item/TooltipFlag;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/BannerItem;appendHoverTextFromBannerBlockEntityTag(Lnet/minecraft/world/item/ItemStack;Ljava/util/List;)V"
            )
    )
    private void wrapFlagTooltip(ItemStack stack, List<Component> tooltipComponents, Operation<Void> original) {
        Tooltip.appendBannerTooltip(stack, tooltipComponents);
    }
}
