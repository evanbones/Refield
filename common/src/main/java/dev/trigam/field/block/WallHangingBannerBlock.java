package dev.trigam.field.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.trigam.field.block.entity.WallHangingBannerBlockEntity;
import dev.trigam.field.tag.BlockTagInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class WallHangingBannerBlock extends AbstractBannerBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final VoxelShape NORTH_SOUTH_COLLISION_SHAPE = Block.box(0.0D, 14.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    public static final VoxelShape EAST_WEST_COLLISION_SHAPE = Block.box(6.0D, 14.0D, 0.0D, 10.0D, 16.0D, 16.0D);
    public static final VoxelShape NORTH_SOUTH_BANNER_SHAPE = Block.box(1.0D, -16.0D, 6.0D, 15.0D, 13.5D, 10.0D);
    public static final VoxelShape EAST_WEST_BANNER_SHAPE = Block.box(6.0D, -16.0D, 1.0D, 10.0D, 13.5D, 15.0D);
    public static final VoxelShape NORTH_SOUTH_SHAPE = Shapes.or(NORTH_SOUTH_COLLISION_SHAPE, NORTH_SOUTH_BANNER_SHAPE);
    public static final VoxelShape EAST_WEST_SHAPE = Shapes.or(EAST_WEST_COLLISION_SHAPE, EAST_WEST_BANNER_SHAPE);
    private static final Map<Direction, VoxelShape> OUTLINE_SHAPES = Maps.newEnumMap(ImmutableMap.of(
            Direction.NORTH, NORTH_SOUTH_SHAPE,
            Direction.SOUTH, NORTH_SOUTH_SHAPE,
            Direction.EAST, EAST_WEST_SHAPE,
            Direction.WEST, EAST_WEST_SHAPE
    ));
    private static final Map<DyeColor, Block> COLORED_BANNERS = Maps.newHashMap();
    public static final MapCodec<WallHangingBannerBlock> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    DyeColor.CODEC.fieldOf("color").forGetter(AbstractBannerBlock::getColor),
                    propertiesCodec()
            ).apply(instance, WallHangingBannerBlock::new)
    );

    public WallHangingBannerBlock(DyeColor dyeColor, BlockBehaviour.Properties properties) {
        super(dyeColor, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
        COLORED_BANNERS.put(dyeColor, this);
    }

    public static Block getForColor(DyeColor color) {
        return COLORED_BANNERS.getOrDefault(color, BlockInit.WHITE_WALL_HANGING_BANNER);
    }

    @Override
    protected @NotNull MapCodec<? extends AbstractBannerBlock> codec() {
        return CODEC;
    }

    @Override
    public @NotNull BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new WallHangingBannerBlockEntity(pos, state, this.getColor());
    }

    protected boolean canAttachAt(BlockState state, LevelReader level, BlockPos pos) {
        Direction direction = state.getValue(FACING).getClockWise();
        Direction direction2 = state.getValue(FACING).getCounterClockWise();
        return this.canAttachTo(level, state, pos.relative(direction), direction2)
                || this.canAttachTo(level, state, pos.relative(direction2), direction);
    }

    public boolean canAttachTo(LevelReader level, BlockState state, BlockPos pos, Direction direction) {
        BlockState blockState = level.getBlockState(pos);
        return blockState.is(BlockTagInit.WALL_HANGING_DECORATIONS)
                ? blockState.getValue(FACING).getAxis() == state.getValue(FACING).getAxis()
                : blockState.isFaceSturdy(level, pos, direction, SupportType.FULL);
    }

    @Override
    protected boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
        return this.canAttachAt(state, level, pos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockState = this.defaultBlockState();
        LevelReader levelReader = context.getLevel();
        BlockPos blockPos = context.getClickedPos();

        for (Direction direction : context.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal() && direction.getAxis() != context.getClickedFace().getAxis()) {
                Direction facing = direction.getOpposite();
                blockState = blockState.setValue(FACING, facing);
                if (blockState.canSurvive(levelReader, blockPos) && this.canAttachAt(blockState, levelReader, blockPos)) {
                    return blockState;
                }
            }
        }

        return null;
    }

    @Override
    protected @NotNull BlockState updateShape(BlockState state, Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        return direction.getAxis() == state.getValue(FACING).getClockWise().getAxis() && !state.canSurvive(level, pos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    protected @NotNull BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    protected @NotNull BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return OUTLINE_SHAPES.get(state.getValue(FACING));
    }

    @Override
    protected @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return this.getShape(state, level, pos, CollisionContext.empty());
    }

    @Override
    protected @NotNull VoxelShape getCollisionShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case EAST, WEST -> EAST_WEST_COLLISION_SHAPE;
            default -> NORTH_SOUTH_COLLISION_SHAPE;
        };
    }
}
