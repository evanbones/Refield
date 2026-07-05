package dev.trigam.field;

import dev.trigam.field.block.BlockInit;
import dev.trigam.field.block.entity.BlockEntityInit;
import dev.trigam.field.client.ClientConfigSetup;
import dev.trigam.field.client.EntityModelLayerInit;
import dev.trigam.field.client.model.BannerFlagModel;
import dev.trigam.field.client.model.HangingBannerModel;
import dev.trigam.field.client.model.WallHangingBannerModel;
import dev.trigam.field.client.renderer.HangingBannerRenderer;
import dev.trigam.field.client.renderer.WallHangingBannerRenderer;
import dev.trigam.field.config.ModConfig;
import dev.trigam.field.item.ItemInit;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.Arrays;
import java.util.List;

@Mod(Constants.MOD_ID)
public class Field {
    public static final List<Item> BANNERS = Arrays.asList(
            Items.WHITE_BANNER, Items.LIGHT_GRAY_BANNER, Items.GRAY_BANNER, Items.BLACK_BANNER,
            Items.BROWN_BANNER, Items.RED_BANNER, Items.ORANGE_BANNER, Items.YELLOW_BANNER,
            Items.LIME_BANNER, Items.GREEN_BANNER, Items.CYAN_BANNER, Items.LIGHT_BLUE_BANNER,
            Items.BLUE_BANNER, Items.PURPLE_BANNER, Items.MAGENTA_BANNER, Items.PINK_BANNER
    );
    private static boolean registered = false;

    public Field(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::onRegister);
        modEventBus.addListener(this::modifyComponents);
        modEventBus.addListener(this::addCreative);

        if (FMLEnvironment.dist.isClient()) {
            ClientConfigSetup.register(modContainer);
            modEventBus.addListener(this::registerRenderers);
            modEventBus.addListener(this::registerLayerDefinitions);
        }
    }

    private void onRegister(RegisterEvent event) {
        if (!registered) {
            CommonClass.init();
            registered = true;
        }

        if (event.getRegistryKey().equals(Registries.BLOCK)) {
            BlockInit.BLOCKS.forEach((id, block) -> event.register(Registries.BLOCK, id, () -> block));
        } else if (event.getRegistryKey().equals(Registries.BLOCK_ENTITY_TYPE)) {
            BlockEntityInit.BLOCK_ENTITIES.forEach((id, type) -> event.register(Registries.BLOCK_ENTITY_TYPE, id, () -> type));
        } else if (event.getRegistryKey().equals(Registries.ITEM)) {
            ItemInit.ITEMS.forEach((id, item) -> event.register(Registries.ITEM, id, () -> item));
        }
    }

    private void modifyComponents(ModifyDefaultComponentsEvent event) {
        if (ModConfig.get().bannerStackSize != 16) {
            for (Item banner : BANNERS) {
                event.modify(banner, builder -> builder.set(DataComponents.MAX_STACK_SIZE, ModConfig.get().bannerStackSize));
            }
        }
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ItemInit.STAR_BANNER_PATTERN);
        }
    }

    private void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BlockEntityInit.HANGING_BANNER, HangingBannerRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityInit.WALL_HANGING_BANNER, WallHangingBannerRenderer::new);
    }

    private void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(EntityModelLayerInit.BANNER_FLAG, BannerFlagModel::getTexturedModelData);
        event.registerLayerDefinition(EntityModelLayerInit.HANGING_BANNER, HangingBannerModel::getTexturedModelData);
        event.registerLayerDefinition(EntityModelLayerInit.WALL_HANGING_BANNER, WallHangingBannerModel::getTexturedModelData);
    }
}