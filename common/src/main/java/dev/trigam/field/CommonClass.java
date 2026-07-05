package dev.trigam.field;

import dev.trigam.field.block.BlockInit;
import dev.trigam.field.block.entity.BlockEntityInit;
import dev.trigam.field.config.ModConfig;
import dev.trigam.field.item.ItemInit;
import dev.trigam.field.tag.BannerPatternTagInit;
import dev.trigam.field.tag.BlockTagInit;

public class CommonClass {
    public static void init() {
        ModConfig.load();

        BlockInit.init();
        BlockEntityInit.init();
        ItemInit.init();
        BannerPatternTagInit.init();
        BlockTagInit.init();
    }
}