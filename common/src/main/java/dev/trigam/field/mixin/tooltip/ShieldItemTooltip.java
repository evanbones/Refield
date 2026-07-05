package dev.trigam.field.mixin.tooltip;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.trigam.field.util.Tooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import java.util.List;

@Mixin(ShieldItem.class)
public class ShieldItemTooltip {

    @WrapOperation(
        method = "appendHoverText(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/Item$TooltipContext;Ljava/util/List;Lnet/minecraft/world/item/TooltipFlag;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/item/BannerItem;appendHoverTextFromBannerBlockEntityTag(Lnet/minecraft/world/item/ItemStack;Ljava/util/List;)V"
        )
    )
    private void appendBannerTooltip(ItemStack stack, List<Component> tooltip, Operation<Void> original) {
        Tooltip.appendBannerTooltip(stack, tooltip);
    }
}
