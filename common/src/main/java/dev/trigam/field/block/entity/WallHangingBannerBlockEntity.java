package dev.trigam.field.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class WallHangingBannerBlockEntity extends BannerBlockEntity {
    public WallHangingBannerBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    public WallHangingBannerBlockEntity(BlockPos pos, BlockState state, DyeColor baseColor) {
        super(pos, state, baseColor);
    }

    @Override
    public @NotNull BlockEntityType<?> getType() {
        return BlockEntityInit.WALL_HANGING_BANNER;
    }
}
