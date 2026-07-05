package dev.trigam.field.item;

import dev.trigam.field.Constants;
import dev.trigam.field.tag.BannerPatternTagInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.item.Item;

import java.util.LinkedHashMap;
import java.util.Map;

public class ItemInit {
    public static final Map<ResourceLocation, Item> ITEMS = new LinkedHashMap<>();

    public static final Item STAR_BANNER_PATTERN = registerItem("star_banner_pattern",
            new BannerPatternItem(BannerPatternTagInit.STAR_BANNER_PATTERN, new Item.Properties().stacksTo(1))
    );

    public static Item registerItem(String name, Item item) {
        ITEMS.put(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name), item);
        return item;
    }

    public static void init() {
    }
}
