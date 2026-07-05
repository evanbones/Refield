package dev.trigam.field.mixin.bannerPlacement;

import dev.trigam.field.config.ModConfig;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.Equipable;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BannerItem.class)
public class BannerItemWearableMixin implements Equipable {

    @Override
    public @NotNull EquipmentSlot getEquipmentSlot() {
        return ModConfig.get().wearableBanners ? EquipmentSlot.HEAD : EquipmentSlot.MAINHAND;
    }
}
