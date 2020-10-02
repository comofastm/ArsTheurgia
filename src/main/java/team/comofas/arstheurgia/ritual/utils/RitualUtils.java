package team.comofas.arstheurgia.ritual.utils;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class RitualUtils {
    public static boolean SquareCoordinates(Block block, int r, int c, int offset, World world, BlockPos pos) {
        boolean isValid = true;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        mutable.setY(pos.getY());
        int co = Math.floorMod(c, 4*(r*2));
        int it = Math.floorMod(co,r*2);
        int x = (int) Math.floor(co/(r*2));
        switch (x) {
            case 0:
                mutable.setX(r+pos.getX());
                mutable.setZ(-1*it+r+pos.getZ());
                break;
            case 1:
                mutable.setX(-1*it+r+pos.getX());
                mutable.setZ(-1*r+pos.getZ());
                break;
            case 2:
                mutable.setX(-r+pos.getX());
                mutable.setZ(it+-r+pos.getZ());
                break;
            case 3:
                mutable.setX(it+-r+pos.getX());
                mutable.setZ(r+pos.getZ());
                break;
            default: break;
        }
        BlockState blockState = world.getBlockState(mutable);
        if (!blockState.isOf(block)) {
            isValid = false;
        }
        return isValid;
    }
    public static boolean FoldSquare(Block block, int r, int offset, int o, World world, BlockPos pos) {
        boolean isValid = true;
        int perimeter = 4*(r*2);
        int steps = perimeter/o;
        for (int i = 0; i < perimeter; i=i+steps) {
            if (!(SquareCoordinates(block, r, i, offset, world, pos))) {
                isValid = false;
            }
        }
        return isValid;
    }
    public static boolean SquareIterate(Block block, int r, World world, BlockPos pos) {
        boolean isValid = true;
        for (int x = -r; x <= r; x++) {
            BlockPos.Mutable mutable = new BlockPos.Mutable();
            //-z
            mutable.set(pos).move(Direction.NORTH, r).move(Direction.EAST, x);
            BlockState blockState = world.getBlockState(mutable);
            if (!blockState.isOf(block)) {
                isValid = false;
            }
            //+z
            mutable.set(pos).move(Direction.SOUTH, r).move(Direction.EAST, x);
            blockState = world.getBlockState(mutable);
            if (!blockState.isOf(block)) {
                isValid = false;
            }
            //-x
            mutable.set(pos).move(Direction.WEST, r).move(Direction.SOUTH, x);
            blockState = world.getBlockState(mutable);
            if (!blockState.isOf(block)) {
                isValid = false;
            }
            //+x
            mutable.set(pos).move(Direction.EAST, r).move(Direction.SOUTH, x);
            blockState = world.getBlockState(mutable);
            if (!blockState.isOf(block)) {
                isValid = false;
            }
        }
        return isValid;
    }
}
