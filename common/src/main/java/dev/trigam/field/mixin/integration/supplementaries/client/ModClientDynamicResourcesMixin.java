package dev.trigam.field.mixin.integration.supplementaries.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.platform.NativeImage;
import net.mehvahdjukaar.moonlight.api.misc.ThrowingSupplier;
import net.mehvahdjukaar.moonlight.api.resources.pack.ResourceSink;
import net.mehvahdjukaar.moonlight.api.resources.textures.TextureImage;
import net.mehvahdjukaar.moonlight.api.resources.textures.TextureOps;
import net.mehvahdjukaar.supplementaries.dynamicpack.ModClientDynamicResources;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = ModClientDynamicResources.class, remap = false)
public class ModClientDynamicResourcesMixin {

    @WrapOperation(
            method = "addMissingFlagPatterns",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/mehvahdjukaar/moonlight/api/resources/pack/ResourceSink;addTextureUnlessPresent(Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/resources/ResourceLocation;Lnet/mehvahdjukaar/moonlight/api/misc/ThrowingSupplier;)V"
            )
    )
    private void wrapAddTexture(ResourceSink instance, ResourceManager manager, ResourceLocation res, ThrowingSupplier<TextureImage> textureSupplier, Operation<Void> original) {
        if (res.getPath().contains("/field/")) {
            instance.addTextureUnlessPresent(manager, res, () -> {
                String name = res.getPath().substring(res.getPath().lastIndexOf('/') + 1);
                ResourceLocation originalId = ResourceLocation.fromNamespaceAndPath("field", "entity/banner/" + name);
                try (TextureImage oldText = TextureImage.open(manager, originalId)) {
                    TextureImage newImage = TextureOps.createScaled(oldText, 0.5f, 0.25f);
                    newImage.clear();

                    NativeImage src = oldText.getImage();
                    NativeImage dst = newImage.getImage();
                    for (int x = 0; x < 24; x++) {
                        for (int y = 0; y < 16; y++) {
                            float bannerX = (1.0f - y / 16.0f) * 20.0f;
                            float bannerY = (x / 24.0f) * 40.0f;

                            int srcX = Math.min(19, Math.max(0, (int) bannerX));
                            int srcY = Math.min(39, Math.max(0, (int) bannerY));

                            int color = src.getPixelRGBA(srcX, srcY);
                            dst.setPixelRGBA(x, y, color);
                        }
                    }
                    return newImage;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        } else {
            original.call(instance, manager, res, textureSupplier);
        }
    }
}
