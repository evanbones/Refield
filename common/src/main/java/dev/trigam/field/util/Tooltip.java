package dev.trigam.field.util;

import dev.trigam.field.config.ModConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BannerPatternLayers;

import java.util.ArrayList;
import java.util.List;

public class Tooltip {

    public static void appendBannerTooltip(ItemStack stack, List<Component> tooltip) {
        BannerPatternLayers patterns = stack.get(DataComponents.BANNER_PATTERNS);

        if (patterns != null) {
            List<BannerPatternLayers.Layer> bannerLayers = patterns.layers();
            List<BannerPatternLayers.Layer> reversedLayers = new ArrayList<>();
            for (int i = bannerLayers.size() - 1; i >= 0; i--) {
                reversedLayers.add(bannerLayers.get(i));
            }

            int numLayers = reversedLayers.size();
            int shownLayers = Math.min(numLayers, ModConfig.get().bannerTooltipLayers);
            int remaining = numLayers - shownLayers;

            if (numLayers > 0) {
                tooltip.add(Component.translatable("block.field.banner.patterns").withStyle(ChatFormatting.GRAY));
            }

            for (int i = 0; i < shownLayers; i++) {
                BannerPatternLayers.Layer layer = reversedLayers.get(i);
                MutableComponent layerTooltip = Tooltip.getLayerTooltip(layer, false);
                tooltip.add(Component.literal(" ").append(layerTooltip.withStyle(ChatFormatting.GRAY)));
            }

            if (remaining > 0) {
                Component remainingTooltip = Component.translatable("block.field.banner.more", remaining)
                        .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC);
                tooltip.add(Component.literal(" ").append(remainingTooltip));
            }
        }
    }

    public static MutableComponent getLayerTooltip(BannerPatternLayers.Layer layer, boolean isGlowing) {
        List<Component> parts = new ArrayList<>();

        parts.add(Component.translatable("block.field.banner." + layer.color().getName()));
        parts.add(Component.translatable(layer.pattern().value().translationKey()));

        MutableComponent glowing = Component.literal("(")
                .append(Component.translatable("block.field.banner.glowing"))
                .append(Component.literal(")"));
        if (isGlowing) parts.add(glowing);

        MutableComponent tooltip = Component.empty();
        tooltip.append(parts.getFirst());
        for (int i = 1; i < parts.size(); i++) {
            tooltip.append(Component.literal(" "));
            tooltip.append(parts.get(i));
        }

        return tooltip;
    }
}
