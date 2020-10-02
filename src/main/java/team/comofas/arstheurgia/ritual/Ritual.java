package team.comofas.arstheurgia.ritual;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import team.comofas.arstheurgia.ritual.utils.RitualUtils;

// Isso demonstra como vai ser implementando o check pra validar um ritual com blocos ao redor, depois criar funções pra quadrados
// e simetria de dobra de ordem n dentro do circulo, assim por tudo isso numa classe válida de ritual e eventualmente estágios.
public class Ritual {
    public static void callRitual(Ritual rt, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        rt.onCall(state, world, pos, player, hand, hit);
    }

    public void onCall(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) { }
}
