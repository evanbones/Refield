package dev.trigam.field.tag;

import dev.trigam.field.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class BlockTagInit {
    public static final TagKey<Block> WALL_HANGING_DECORATIONS = of("wall_hanging_decorations");

    private static TagKey<Block> of(String id) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, id));
    }

    public static void init() {
    }
}
