package dev.trigam.field;

import dev.trigam.field.block.BlockInit;
import dev.trigam.field.block.entity.BlockEntityInit;
import dev.trigam.field.config.ModConfig;
import dev.trigam.field.item.ItemInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.Arrays;
import java.util.List;

public class Field implements ModInitializer {

    public static final List<Item> BANNERS = Arrays.asList(
            Items.WHITE_BANNER, Items.LIGHT_GRAY_BANNER, Items.GRAY_BANNER, Items.BLACK_BANNER,
            Items.BROWN_BANNER, Items.RED_BANNER, Items.ORANGE_BANNER, Items.YELLOW_BANNER,
            Items.LIME_BANNER, Items.GREEN_BANNER, Items.CYAN_BANNER, Items.LIGHT_BLUE_BANNER,
            Items.BLUE_BANNER, Items.PURPLE_BANNER, Items.MAGENTA_BANNER, Items.PINK_BANNER
    );

    @Override
    public void onInitialize() {
        CommonClass.init();

        BlockInit.BLOCKS.forEach((id, block) -> Registry.register(BuiltInRegistries.BLOCK, id, block));
        BlockEntityInit.BLOCK_ENTITIES.forEach((id, type) -> Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, type));
        ItemInit.ITEMS.forEach((id, item) -> Registry.register(BuiltInRegistries.ITEM, id, item));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(content -> {
            content.addAfter(Items.GUSTER_BANNER_PATTERN, ItemInit.STAR_BANNER_PATTERN);
        });

        DefaultItemComponentEvents.MODIFY.register(context -> {
            if (ModConfig.get().bannerStackSize != 16) {
                for (Item banner : BANNERS) {
                    context.modify(banner, builder -> builder.set(DataComponents.MAX_STACK_SIZE, ModConfig.get().bannerStackSize));
                }
                for (String color : Arrays.asList("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black")) {
                    ResourceLocation id = ResourceLocation.fromNamespaceAndPath("supplementaries", "flag_" + color);
                    BuiltInRegistries.ITEM.getOptional(id).ifPresent(item -> {
                        context.modify(item, builder -> builder.set(DataComponents.MAX_STACK_SIZE, ModConfig.get().bannerStackSize));
                    });
                }
            }
        });
    }
}