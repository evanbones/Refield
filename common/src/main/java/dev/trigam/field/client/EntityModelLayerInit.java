package dev.trigam.field.client;

import dev.trigam.field.Constants;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class EntityModelLayerInit {
    public static final ModelLayerLocation BANNER_FLAG = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "banner"),
            "flag"
    );

    public static final ModelLayerLocation HANGING_BANNER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "hanging_banner"),
            "main"
    );

    public static final ModelLayerLocation WALL_HANGING_BANNER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "wall_hanging_banner"),
            "main"
    );
}
