package dev.trigam.field.block.entity;

import dev.trigam.field.Constants;
import dev.trigam.field.block.BlockInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.LinkedHashMap;
import java.util.Map;

public class BlockEntityInit {
    public static final Map<ResourceLocation, BlockEntityType<?>> BLOCK_ENTITIES = new LinkedHashMap<>();

    public static final BlockEntityType<HangingBannerBlockEntity> HANGING_BANNER = registerBlockEntity("hanging_banner",
            BlockEntityType.Builder.of(HangingBannerBlockEntity::new,
                    BlockInit.WHITE_HANGING_BANNER, BlockInit.LIGHT_GRAY_HANGING_BANNER,
                    BlockInit.GRAY_HANGING_BANNER, BlockInit.BLACK_HANGING_BANNER,
                    BlockInit.BROWN_HANGING_BANNER, BlockInit.RED_HANGING_BANNER,
                    BlockInit.ORANGE_HANGING_BANNER, BlockInit.YELLOW_HANGING_BANNER,
                    BlockInit.LIME_HANGING_BANNER, BlockInit.GREEN_HANGING_BANNER,
                    BlockInit.CYAN_HANGING_BANNER, BlockInit.LIGHT_BLUE_HANGING_BANNER,
                    BlockInit.BLUE_HANGING_BANNER, BlockInit.PURPLE_HANGING_BANNER,
                    BlockInit.MAGENTA_HANGING_BANNER, BlockInit.PINK_HANGING_BANNER
            ).build(null)
    );

    public static final BlockEntityType<WallHangingBannerBlockEntity> WALL_HANGING_BANNER = registerBlockEntity("wall_hanging_banner",
            BlockEntityType.Builder.of(WallHangingBannerBlockEntity::new,
                    BlockInit.WHITE_WALL_HANGING_BANNER, BlockInit.LIGHT_GRAY_WALL_HANGING_BANNER,
                    BlockInit.GRAY_WALL_HANGING_BANNER, BlockInit.BLACK_WALL_HANGING_BANNER,
                    BlockInit.BROWN_WALL_HANGING_BANNER, BlockInit.RED_WALL_HANGING_BANNER,
                    BlockInit.ORANGE_WALL_HANGING_BANNER, BlockInit.YELLOW_WALL_HANGING_BANNER,
                    BlockInit.LIME_WALL_HANGING_BANNER, BlockInit.GREEN_WALL_HANGING_BANNER,
                    BlockInit.CYAN_WALL_HANGING_BANNER, BlockInit.LIGHT_BLUE_WALL_HANGING_BANNER,
                    BlockInit.BLUE_WALL_HANGING_BANNER, BlockInit.PURPLE_WALL_HANGING_BANNER,
                    BlockInit.MAGENTA_WALL_HANGING_BANNER, BlockInit.PINK_WALL_HANGING_BANNER
            ).build(null)
    );

    public static <T extends BlockEntityType<?>> T registerBlockEntity(String name, T type) {
        BLOCK_ENTITIES.put(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name), type);
        return type;
    }

    public static void init() {
    }
}
