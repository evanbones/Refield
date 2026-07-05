package dev.trigam.field.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import dev.trigam.field.Constants;
import dev.trigam.field.block.WallHangingBannerBlock;
import dev.trigam.field.block.entity.WallHangingBannerBlockEntity;
import dev.trigam.field.client.EntityModelLayerInit;
import dev.trigam.field.client.model.BannerFlagModel;
import dev.trigam.field.client.model.WallHangingBannerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class WallHangingBannerRenderer implements BlockEntityRenderer<WallHangingBannerBlockEntity> {
    public static final Material SPRITE = new Material(
            Sheets.BANNER_SHEET,
            ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "entity/banner/base/wall_hanging_banner_base")
    );
    public final WallHangingBannerModel bannerModel;
    public final BannerFlagModel flagModel;

    public WallHangingBannerRenderer(BlockEntityRendererProvider.Context context) {
        this.bannerModel = new WallHangingBannerModel(context.bakeLayer(EntityModelLayerInit.WALL_HANGING_BANNER));
        this.flagModel = new BannerFlagModel(context.bakeLayer(EntityModelLayerInit.BANNER_FLAG));
    }

    @Override
    public void render(
            @NotNull WallHangingBannerBlockEntity banner, float tickDelta, @NotNull PoseStack matrices,
            @NotNull MultiBufferSource vertexConsumer, int light, int overlay
    ) {
        renderFrame(banner, matrices, vertexConsumer, light, overlay);
        renderFlag(banner, matrices, vertexConsumer, light, overlay, tickDelta);
    }

    public void renderFrame(
            WallHangingBannerBlockEntity banner, PoseStack matrices,
            MultiBufferSource vertexProvider, int light, int overlay
    ) {
        matrices.pushPose();

        matrices.translate(0.5F, 0.0F, 0.5F);
        Direction facing = banner.getBlockState().getValue(WallHangingBannerBlock.FACING);
        float rotation = -facing.toYRot();
        matrices.mulPose(Axis.YP.rotationDegrees(rotation));
        matrices.scale(0.6666667F, -0.6666667F, -0.6666667F);

        VertexConsumer vertexConsumer = SPRITE.buffer(vertexProvider, RenderType::entityCutoutNoCull);
        this.bannerModel.renderToBuffer(matrices, vertexConsumer, light, overlay, -1);

        matrices.popPose();
    }

    public void renderFlag(
            WallHangingBannerBlockEntity banner, PoseStack matrices,
            MultiBufferSource vertexProvider, int light, int overlay,
            float tickDelta
    ) {
        matrices.pushPose();

        matrices.translate(0.5F, -1.0F, 0.5F);
        Direction facing = banner.getBlockState().getValue(WallHangingBannerBlock.FACING);
        float rotation = -facing.toYRot();
        matrices.mulPose(Axis.YP.rotationDegrees(rotation));
        matrices.scale(0.6666667F, -0.6666667F, -0.6666667F);

        long worldTime = banner.getLevel() != null ? banner.getLevel().getGameTime() : 0L;
        BlockPos pos = banner.getBlockPos();
        float sway = (Math.floorMod((pos.getX() * 7L + pos.getY() * 9L + pos.getZ() * 13L) + worldTime, 100L) + tickDelta) / 100.0F;
        this.flagModel.sway(sway);

        VertexConsumer vertexConsumer = Sheets.BANNER_BASE.buffer(vertexProvider, RenderType::entitySolid);
        this.flagModel.renderToBuffer(matrices, vertexConsumer, light, overlay, -1);

        BannerRenderer.renderPatterns(
                matrices, vertexProvider, light, overlay,
                this.flagModel.flag, SPRITE, true,
                banner.getBaseColor(), banner.getPatterns()
        );

        matrices.popPose();
    }
}
