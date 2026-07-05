package dev.trigam.field.tag;

import dev.trigam.field.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public class BannerPatternTagInit {
    public static final TagKey<BannerPattern> STAR_BANNER_PATTERN = of("pattern_item/star");

    private static TagKey<BannerPattern> of(String id) {
        return TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, id));
    }

    public static void init() {
    }
}
