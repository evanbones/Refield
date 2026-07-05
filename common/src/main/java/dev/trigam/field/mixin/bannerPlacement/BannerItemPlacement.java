package dev.trigam.field.mixin.bannerPlacement;

import dev.trigam.field.block.HangingBannerBlock;
import dev.trigam.field.block.WallHangingBannerBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StandingAndWallBlockItem.class)
public class BannerItemPlacement {

    @Inject(
            method = "getPlacementState",
            at = @At("HEAD"),
            cancellable = true
    )
    public void getPlacementState(BlockPlaceContext context, CallbackInfoReturnable<BlockState> cir) {
        if (context.getPlayer() == null) return;

        StandingAndWallBlockItem thiz = (StandingAndWallBlockItem) (Object) this;
        if (thiz instanceof BannerItem banner) {
            Direction side = context.getClickedFace();
            Direction playerFacing = context.getPlayer().getDirection();

            // Floor Banner
            if (side == Direction.UP) {
                return;
            }
            // Hanging Banner
            else if (side == Direction.DOWN) {
                Block hangingBanner = HangingBannerBlock.getForColor(banner.getColor());
                BlockState state = hangingBanner.getStateForPlacement(context);
                if (state != null && state.canSurvive(context.getLevel(), context.getClickedPos())) {
                    cir.setReturnValue(state);
                }
            }
            // Wall Banner
            else if (side == playerFacing.getOpposite()) {
                return;
            }
            // Wall Hanging Banner
            else {
                Block hangingBanner = WallHangingBannerBlock.getForColor(banner.getColor());
                BlockState state = hangingBanner.getStateForPlacement(context);
                cir.setReturnValue(state);
            }
        }
    }
}
