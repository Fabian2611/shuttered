package io.fabianbuthere.shuttered.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.BiConsumer;

public class ShuttersBlock extends HorizontalDirectionalBlock {
    private static final MapCodec<ShuttersBlock> CODEC = simpleCodec(ShuttersBlock::create);

    private static final VoxelShape NORTH_SHAPE = Block.box(0, 0, 0, 16, 16, 2);
    private static final VoxelShape SOUTH_SHAPE = Block.box(0, 0, 14, 16, 16, 16);
    private static final VoxelShape WEST_SHAPE = Block.box(0, 0, 0, 2, 16, 16);
    private static final VoxelShape EAST_SHAPE = Block.box(14, 0, 0, 16, 16, 16);

    private static final VoxelShape NORTH_SHAPE_OPEN = Shapes.or(Block.box(0, 0, 0, 2, 16, 8), Block.box(14, 0, 0, 16, 16, 8));
    private static final VoxelShape SOUTH_SHAPE_OPEN = Shapes.or(Block.box(0, 0, 8, 2, 16, 16), Block.box(14, 0, 8, 16, 16, 16));
    private static final VoxelShape WEST_SHAPE_OPEN = Shapes.or(Block.box(0, 0, 0, 8, 16, 2), Block.box(0, 0, 14, 8, 16, 16));
    private static final VoxelShape EAST_SHAPE_OPEN = Shapes.or(Block.box(8, 0, 0, 16, 16, 2), Block.box(8, 0, 14, 16, 16, 16));

    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    private static final Map<Direction, VoxelShape> SHAPES = Map.of(
            Direction.NORTH, NORTH_SHAPE,
            Direction.SOUTH, SOUTH_SHAPE,
            Direction.WEST, WEST_SHAPE,
            Direction.EAST, EAST_SHAPE
    );

    private static final Map<Direction, VoxelShape> SHAPES_OPEN = Map.of(
            Direction.NORTH, NORTH_SHAPE_OPEN,
            Direction.SOUTH, SOUTH_SHAPE_OPEN,
            Direction.WEST, WEST_SHAPE_OPEN,
            Direction.EAST, EAST_SHAPE_OPEN
    );

    private final boolean isWoodenType;

    protected ShuttersBlock(Properties properties, boolean isWoodenType) {
        super(properties.noOcclusion());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, false).setValue(POWERED, false));
        this.isWoodenType = isWoodenType;
    }

    public static ShuttersBlock create(Properties properties) {
        return new ShuttersBlock(properties.noOcclusion(), true);
    }

    public static ShuttersBlock createIronType(Properties properties) {
        return new ShuttersBlock(properties.noOcclusion(), false);
    }

    public boolean canBeManuallyToggled() {
        return this.isWoodenType;
    }

    @Override
    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        return this.isWoodenType;
    }

    @Override
    protected boolean useShapeForLightOcclusion(BlockState state) {
        return state.getValue(OPEN);
    }

    @Override
    protected boolean isOcclusionShapeFullBlock(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return false;
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState state, @NotNull BlockGetter _level, @NotNull BlockPos _pos) {
        return state.getValue(OPEN);
    }

    @Override
    protected void neighborChanged(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Block block, @NotNull BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {
            boolean flag = level.hasNeighborSignal(pos);
            if (flag != state.getValue(POWERED)) {
                if (state.getValue(OPEN) != flag) {
                    state = state.setValue(OPEN, flag);
                }

                level.setBlock(pos, state.setValue(POWERED, flag), 2);
            }
        }
    }

    @Override
    protected void onExplosionHit(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Explosion explosion, @NotNull BiConsumer<ItemStack, BlockPos> dropConsumer) {
        if (explosion.canTriggerBlocks() && !state.getValue(POWERED)) {
            BlockState newState = state.cycle(OPEN);
            level.setBlockAndUpdate(pos, newState);
        }

        super.onExplosionHit(state, level, pos, explosion, dropConsumer);
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player, @NotNull BlockHitResult hitResult) {
        if (player.isShiftKeyDown() || !this.canBeManuallyToggled()) {
            return InteractionResult.PASS;
        }

        if (!level.isClientSide) {
            BlockState newState = state.cycle(OPEN);
            level.setBlockAndUpdate(pos, newState);
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN, POWERED);
    }

    @Override
    protected @NonNull MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(OPEN, false);
    }

    @Override
    protected @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        if (state.getValue(OPEN)) {
            return SHAPES_OPEN.get(state.getValue(FACING));
        } else {
            return SHAPES.get(state.getValue(FACING));
        }
    }
}
