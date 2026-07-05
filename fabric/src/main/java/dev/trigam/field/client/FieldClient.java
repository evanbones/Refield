package dev.trigam.field.client;

import dev.trigam.field.block.entity.BlockEntityInit;
import dev.trigam.field.client.model.BannerFlagModel;
import dev.trigam.field.client.model.HangingBannerModel;
import dev.trigam.field.client.model.WallHangingBannerModel;
import dev.trigam.field.client.renderer.HangingBannerRenderer;
import dev.trigam.field.client.renderer.WallHangingBannerRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class FieldClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayerInit.BANNER_FLAG, BannerFlagModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayerInit.HANGING_BANNER, HangingBannerModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayerInit.WALL_HANGING_BANNER, WallHangingBannerModel::getTexturedModelData);

        BlockEntityRenderers.register(BlockEntityInit.HANGING_BANNER, HangingBannerRenderer::new);
        BlockEntityRenderers.register(BlockEntityInit.WALL_HANGING_BANNER, WallHangingBannerRenderer::new);
    }
}