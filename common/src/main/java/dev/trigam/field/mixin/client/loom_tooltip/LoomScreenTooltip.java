package dev.trigam.field.mixin.client.loom_tooltip;

import com.llamalad7.mixinextras.sugar.Local;
import dev.trigam.field.config.ModConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.LoomScreen;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BannerPattern;
import org.apache.commons.compress.utils.Lists;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(LoomScreen.class)
public class LoomScreenTooltip {

    @Inject(
            method = "renderBg(Lnet/minecraft/client/gui/GuiGraphics;FII)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screens/inventory/LoomScreen;renderPattern(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/core/Holder;II)V",
                    shift = At.Shift.AFTER
            )
    )
    private void drawBannerPatternTooltip(
            GuiGraphics context, float delta, int mouseX, int mouseY, CallbackInfo ci,
            @Local(ordinal = 0) boolean isHovered, @Local(ordinal = 10) int patternIndex
    ) {
        LoomScreen thiz = (LoomScreen) (Object) this;
        if (isHovered && ModConfig.get().loomTooltip) {
            Holder<BannerPattern> hoveredPattern = thiz.getMenu().getSelectablePatterns().get(patternIndex);
            List<Component> tooltipFields = Lists.newArrayList();
            boolean advancedTooltips = Minecraft.getInstance().options.advancedItemTooltips;

            Component patternName = Component.translatable(hoveredPattern.value().translationKey());
            Component patternId = Component.literal(hoveredPattern.unwrapKey().map(key -> key.location().toString()).orElse("[unknown]"))
                    .withStyle(ChatFormatting.DARK_GRAY);

            tooltipFields.add(patternName);
            if (advancedTooltips) tooltipFields.add(patternId);

            context.renderComponentTooltip(
                    Minecraft.getInstance().font, tooltipFields,
                    mouseX, mouseY
            );
        }
    }
}
