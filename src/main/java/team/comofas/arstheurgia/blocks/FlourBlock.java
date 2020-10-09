package team.comofas.arstheurgia.blocks;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import java.util.Map;

public class FlourBlock extends Block {

    public static final BooleanProperty NORTH;
    public static final BooleanProperty EAST;
    public static final BooleanProperty SOUTH;
    public static final BooleanProperty WEST;
    private static final Map<Direction, BooleanProperty> FACING_PROPERTIES;

    public FlourBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(((((this.stateManager.getDefaultState()).with(NORTH, false)).with(EAST, false)).with(SOUTH, false)).with(WEST, false));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 1.0D, 13.0D);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockView blockView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        return (((this.getDefaultState().with(NORTH, this.shouldConnectTo(blockView.getBlockState(blockPos.north())))).with(EAST, this.shouldConnectTo(blockView.getBlockState(blockPos.east())))).with(SOUTH, this.shouldConnectTo(blockView.getBlockState(blockPos.south())))).with(WEST, this.shouldConnectTo(blockView.getBlockState(blockPos.west())));
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return direction.getAxis().isHorizontal() ? state.with(FACING_PROPERTIES.get(direction), this.shouldConnectTo(newState)) : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }


    public boolean shouldConnectTo(BlockState state) {
        Block block = state.getBlock();
        return block == this;
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        switch(rotation) {
            case CLOCKWISE_180:
                return (((state.with(NORTH, state.get(SOUTH))).with(EAST, state.get(WEST))).with(SOUTH, state.get(NORTH))).with(WEST, state.get(EAST));
            case COUNTERCLOCKWISE_90:
                return (((state.with(NORTH, state.get(EAST))).with(EAST, state.get(SOUTH))).with(SOUTH, state.get(WEST))).with(WEST, state.get(NORTH));
            case CLOCKWISE_90:
                return (((state.with(NORTH, state.get(WEST))).with(EAST, state.get(NORTH))).with(SOUTH, state.get(EAST))).with(WEST, state.get(SOUTH));
            default:
                return state;
        }
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        switch(mirror) {
            case LEFT_RIGHT:
                return (state.with(NORTH, state.get(SOUTH))).with(SOUTH, state.get(NORTH));
            case FRONT_BACK:
                return (state.with(EAST, state.get(WEST))).with(WEST, state.get(EAST));
            default:
                return super.mirror(state, mirror);
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH);
    }

    static {

        NORTH = ConnectingBlock.NORTH;
        EAST = ConnectingBlock.EAST;
        SOUTH = ConnectingBlock.SOUTH;
        WEST = ConnectingBlock.WEST;
        FACING_PROPERTIES = ConnectingBlock.FACING_PROPERTIES.entrySet().stream().filter((entry) -> (entry.getKey()).getAxis().isHorizontal()).collect(Util.toMap());

    }
}
