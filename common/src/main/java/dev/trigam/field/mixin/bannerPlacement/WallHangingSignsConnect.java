package dev.trigam.field.mixin.bannerPlacement;

import dev.trigam.field.tag.BlockTagInit;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallHangingSignBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(WallHangingSignBlock.class)
public class WallHangingSignsConnect {

    @ModifyArg(
            method = "canAttachTo",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/tags/TagKey;)Z"
            )
    )
    private TagKey<Block> replaceBlockTag(TagKey<Block> original) {
        return BlockTagInit.WALL_HANGING_DECORATIONS;
    }
}
