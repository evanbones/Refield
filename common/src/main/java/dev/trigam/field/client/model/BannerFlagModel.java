package dev.trigam.field.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class BannerFlagModel extends Model {
    public final ModelPart flag;

    public BannerFlagModel(ModelPart root) {
        super(RenderType::entitySolid);
        this.flag = root.getChild("flag");
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild(
                "flag",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-10.0F, 0.0F, -2.0F, 20.0F, 40.0F, 1.0F),
                PartPose.offset(0.0F, -44.0F, 0.0F)
        );

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    public void sway(float rotation) {
        this.flag.xRot = (-0.0125F + 0.01F * Mth.cos(((float) Math.PI * 2F) * rotation)) * (float) Math.PI;
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        this.flag.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
