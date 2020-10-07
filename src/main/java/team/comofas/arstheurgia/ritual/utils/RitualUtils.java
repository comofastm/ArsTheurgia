package team.comofas.arstheurgia.ritual.utils;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class RitualUtils {

    public static BlockPos SquareCoordinates(int r, int c, BlockPos pos) {
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

        return mutable;
    }
    public static List<BlockPos> FoldSquare(int r, int o, BlockPos pos) {
        int perimeter = 4*(r*2);
        int steps = perimeter/o;

        List<BlockPos> validBlocks = new ArrayList<>();

        for (int i = 0; i < perimeter; i=i+steps) {
            validBlocks.add(SquareCoordinates(r, i, pos));
        }
        return validBlocks;
    }
    public static List<BlockPos> SquareIterate(int r, BlockPos pos) {
        List<BlockPos> blocks = new ArrayList<>();
        for (int x = -r; x <= r; x++) {
            BlockPos.Mutable mutable = new BlockPos.Mutable();
            //-z
            mutable.set(pos).move(Direction.NORTH, r).move(Direction.EAST, x);
            blocks.add(mutable.toImmutable());

            //+z
            mutable.set(pos).move(Direction.SOUTH, r).move(Direction.EAST, x);
            blocks.add(mutable.toImmutable());

            //-x
            mutable.set(pos).move(Direction.WEST, r).move(Direction.SOUTH, x);
            blocks.add(mutable.toImmutable());

            //+x
            mutable.set(pos).move(Direction.EAST, r).move(Direction.SOUTH, x);
            blocks.add(mutable.toImmutable());

        }
        return blocks;
    }
}
