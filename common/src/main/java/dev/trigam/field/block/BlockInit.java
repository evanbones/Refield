package dev.trigam.field.block;

import dev.trigam.field.Constants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.LinkedHashMap;
import java.util.Map;

public class BlockInit {
    public static final Map<ResourceLocation, Block> BLOCKS = new LinkedHashMap<>();

    // Hanging Banners
    public static final Block WHITE_HANGING_BANNER = registerBlock("white_hanging_banner",
            new HangingBannerBlock(DyeColor.WHITE, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block LIGHT_GRAY_HANGING_BANNER = registerBlock("light_gray_hanging_banner",
            new HangingBannerBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block GRAY_HANGING_BANNER = registerBlock("gray_hanging_banner",
            new HangingBannerBlock(DyeColor.GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block BLACK_HANGING_BANNER = registerBlock("black_hanging_banner",
            new HangingBannerBlock(DyeColor.BLACK, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block BROWN_HANGING_BANNER = registerBlock("brown_hanging_banner",
            new HangingBannerBlock(DyeColor.BROWN, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block RED_HANGING_BANNER = registerBlock("red_hanging_banner",
            new HangingBannerBlock(DyeColor.RED, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block ORANGE_HANGING_BANNER = registerBlock("orange_hanging_banner",
            new HangingBannerBlock(DyeColor.ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block YELLOW_HANGING_BANNER = registerBlock("yellow_hanging_banner",
            new HangingBannerBlock(DyeColor.YELLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block LIME_HANGING_BANNER = registerBlock("lime_hanging_banner",
            new HangingBannerBlock(DyeColor.LIME, BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block GREEN_HANGING_BANNER = registerBlock("green_hanging_banner",
            new HangingBannerBlock(DyeColor.GREEN, BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block CYAN_HANGING_BANNER = registerBlock("cyan_hanging_banner",
            new HangingBannerBlock(DyeColor.CYAN, BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block LIGHT_BLUE_HANGING_BANNER = registerBlock("light_blue_hanging_banner",
            new HangingBannerBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block BLUE_HANGING_BANNER = registerBlock("blue_hanging_banner",
            new HangingBannerBlock(DyeColor.BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block PURPLE_HANGING_BANNER = registerBlock("purple_hanging_banner",
            new HangingBannerBlock(DyeColor.PURPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block MAGENTA_HANGING_BANNER = registerBlock("magenta_hanging_banner",
            new HangingBannerBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block PINK_HANGING_BANNER = registerBlock("pink_hanging_banner",
            new HangingBannerBlock(DyeColor.PINK, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_BANNER).sound(SoundType.HANGING_SIGN))
    );

    // Wall Hanging Banners
    public static final Block WHITE_WALL_HANGING_BANNER = registerBlock("white_wall_hanging_banner",
            new WallHangingBannerBlock(DyeColor.WHITE, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block LIGHT_GRAY_WALL_HANGING_BANNER = registerBlock("light_gray_wall_hanging_banner",
            new WallHangingBannerBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block GRAY_WALL_HANGING_BANNER = registerBlock("gray_wall_hanging_banner",
            new WallHangingBannerBlock(DyeColor.GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block BLACK_WALL_HANGING_BANNER = registerBlock("black_wall_hanging_banner",
            new WallHangingBannerBlock(DyeColor.BLACK, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block BROWN_WALL_HANGING_BANNER = registerBlock("brown_wall_hanging_banner",
            new WallHangingBannerBlock(DyeColor.BROWN, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block RED_WALL_HANGING_BANNER = registerBlock("red_wall_hanging_banner",
            new WallHangingBannerBlock(DyeColor.RED, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block ORANGE_WALL_HANGING_BANNER = registerBlock("orange_wall_hanging_banner",
            new WallHangingBannerBlock(DyeColor.ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block YELLOW_WALL_HANGING_BANNER = registerBlock("yellow_wall_hanging_banner",
            new WallHangingBannerBlock(DyeColor.YELLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block LIME_WALL_HANGING_BANNER = registerBlock("lime_wall_hanging_banner",
            new WallHangingBannerBlock(DyeColor.LIME, BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block GREEN_WALL_HANGING_BANNER = registerBlock("green_wall_hanging_banner",
            new WallHangingBannerBlock(DyeColor.GREEN, BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block CYAN_WALL_HANGING_BANNER = registerBlock("cyan_wall_hanging_banner",
            new WallHangingBannerBlock(DyeColor.CYAN, BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block LIGHT_BLUE_WALL_HANGING_BANNER = registerBlock("light_blue_wall_hanging_banner",
            new WallHangingBannerBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block BLUE_WALL_HANGING_BANNER = registerBlock("blue_wall_hanging_banner",
            new WallHangingBannerBlock(DyeColor.BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block PURPLE_WALL_HANGING_BANNER = registerBlock("purple_wall_hanging_banner",
            new WallHangingBannerBlock(DyeColor.PURPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block MAGENTA_WALL_HANGING_BANNER = registerBlock("magenta_wall_hanging_banner",
            new WallHangingBannerBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_BANNER).sound(SoundType.HANGING_SIGN))
    );
    public static final Block PINK_WALL_HANGING_BANNER = registerBlock("pink_wall_hanging_banner",
            new WallHangingBannerBlock(DyeColor.PINK, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_BANNER).sound(SoundType.HANGING_SIGN))
    );

    public static Block registerBlock(String name, Block block) {
        BLOCKS.put(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name), block);
        return block;
    }

    public static void init() {
    }
}
