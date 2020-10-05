package team.comofas.arstheurgia.ritual.rituals;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import team.comofas.arstheurgia.ritual.Ritual;
import team.comofas.arstheurgia.ritual.utils.RitualUtils;

public class CreeperSummon extends Ritual {

    public static final CreeperSummon INSTANCE = new CreeperSummon("creeper");

    public CreeperSummon(String name) {
        super(name);
    }

    @Override
    public void onCall(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (RitualUtils.FoldSquare((mutable) -> {
                BlockState blockState = world.getBlockState(mutable);
                return blockState.isOf(Blocks.TORCH);
            }, 3, 4, pos)) {

            if (RitualUtils.SquareIterate((mutable) -> {
                BlockState blockState = world.getBlockState(mutable);
                return blockState.isOf(Blocks.REDSTONE_WIRE);
            }, 2, pos)) {
                player.sendMessage(new LiteralText("it does work"), true);
                EntityType.CREEPER.spawn((ServerWorld) world, null, null, null, pos, SpawnReason.MOB_SUMMONED, true, true);
            }

        }
    }
}

