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
import org.jetbrains.annotations.NotNull;

public class WallHangingBannerModel extends Model {
    private final ModelPart bar;
    private final ModelPart supportBar;
    private final ModelPart chain1;
    private final ModelPart chain2;
    private final ModelPart chain3;
    private final ModelPart chain4;

    public WallHangingBannerModel(ModelPart root) {
        super(RenderType::entitySolid);
        this.bar = root.getChild("bar");
        this.supportBar = root.getChild("support_bar");
        this.chain1 = root.getChild("chain_1");
        this.chain2 = root.getChild("chain_2");
        this.chain3 = root.getChild("chain_3");
        this.chain4 = root.getChild("chain_4");
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild(
                "bar",
                CubeListBuilder.create()
                        .texOffs(0, 42)
                        .addBox(-10.0F, -20.0F, -1.0F, 20.0F, 2.0F, 2.0F),
                PartPose.ZERO
        );

        partDefinition.addOrReplaceChild(
                "support_bar",
                CubeListBuilder.create()
                        .texOffs(0, 48)
                        .addBox(-8.0F, -16.0F, -2.0F, 16.0F, 2.0F, 4.0F),
                PartPose.ZERO
        );

        partDefinition.addOrReplaceChild(
                "chain_1",
                CubeListBuilder.create()
                        .texOffs(44, -3)
                        .addBox(0.0F, 23.0F, -1.5F, 0.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(-5.0F, -45.0F, 0.0F, 0.0F, -0.7854F, 0.0F)
        );
        partDefinition.addOrReplaceChild(
                "chain_2",
                CubeListBuilder.create()
                        .texOffs(50, -3)
                        .addBox(0.0F, 23.0F, -1.5F, 0.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(-5.0F, -45.0F, 0.0F, 0.0F, 0.7854F, 0.0F)
        );
        partDefinition.addOrReplaceChild(
                "chain_3",
                CubeListBuilder.create()
                        .texOffs(44, -3)
                        .addBox(0.0F, 23.0F, -1.5F, 0.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(5.0F, -45.0F, 0.0F, 0.0F, -0.7854F, 0.0F)
        );
        partDefinition.addOrReplaceChild(
                "chain_4",
                CubeListBuilder.create()
                        .texOffs(50, -3)
                        .addBox(0.0F, 23.0F, -1.5F, 0.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(5.0F, -45.0F, 0.0F, 0.0F, 0.7854F, 0.0F)
        );

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        this.bar.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);

        poseStack.pushPose();
        poseStack.scale(1.5F, 1.5F, 1.5F);
        this.supportBar.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        poseStack.popPose();

        this.chain1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        this.chain2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        this.chain3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        this.chain4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
