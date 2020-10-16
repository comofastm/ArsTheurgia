package team.comofas.arstheurgia.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class FallingArcheologicalBlock extends FallingBlock {
    public static final BooleanProperty NATURAL = BooleanProperty.of("natural");
    private static List<FallingArcheologicalBlock> blocks = new ArrayList<FallingArcheologicalBlock>();

    public FallingArcheologicalBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(NATURAL, false));
        blocks.add(this);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(NATURAL);
    }

    public void onLanding(World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
        if (blocks.contains(fallingBlockState.getBlock())) {
            world.setBlockState(pos, fallingBlockState.with(NATURAL, false));
        }
    }

    public static boolean isNatural(BlockState blockState) {
        if (blocks.contains(blockState.getBlock())) {
            return blockState.get(NATURAL);
        } else {
            return false;
        }
    }

}