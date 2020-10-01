package team.comofas.arstheurgia.ritual;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

// Isso demonstra como vai ser implementando o check pra validar um ritual com blocos ao redor, depois criar funções pra quadrados
// e simetria de dobra de ordem n dentro do circulo, assim por tudo isso numa classe válida de ritual e eventualmente estágios.
public class CheckForRitual {
    public static boolean IsValidRitual(BlockPos pos, World world) {
        boolean isValid = true;

        // Checar por quadrado, eventualmente substituido por uma função.
        for (int x = -2; x <= 2; x++) {
            BlockPos.Mutable mutable = new BlockPos.Mutable();
            //-z
            mutable.set(pos).move(Direction.NORTH, 2).move(Direction.EAST, x);
            BlockState blockState = world.getBlockState(mutable);
            if (!blockState.isOf(Blocks.OBSIDIAN)) {
                isValid = false;
            }
            //+z
            mutable.set(pos).move(Direction.SOUTH, 2).move(Direction.EAST, x);
            blockState = world.getBlockState(mutable);
            if (!blockState.isOf(Blocks.OBSIDIAN)) {
                isValid = false;
            }
            //-x
            mutable.set(pos).move(Direction.WEST, 2).move(Direction.SOUTH, x);
            blockState = world.getBlockState(mutable);
            if (!blockState.isOf(Blocks.OBSIDIAN)) {
                isValid = false;
            }
            //+x
            mutable.set(pos).move(Direction.EAST, 2).move(Direction.SOUTH, x);
            blockState = world.getBlockState(mutable);
            if (!blockState.isOf(Blocks.OBSIDIAN)) {
                isValid = false;
            }
        }

        return isValid;
    }
}
