package team.comofas.arstheurgia.ritual.utils;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.function.Function;

public class RitualUtils {

    public static boolean SquareCoordinates(Function<BlockPos.Mutable, Boolean> function, int r, int c, BlockPos pos) {
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

        return function.apply(mutable);
    }
    public static boolean FoldSquare(Function<BlockPos.Mutable, Boolean> function, int r, int o, BlockPos pos) {
        boolean isValid = true;
        int perimeter = 4*(r*2);
        int steps = perimeter/o;
        System.out.println("foldsquare");
        for (int i = 0; i < perimeter; i=i+steps) {

            if (!(SquareCoordinates(function, r, i, pos))) {
                isValid = false;
            }
            System.out.println(isValid);

        }
        return isValid;
    }
    public static boolean SquareIterate(Function<BlockPos.Mutable, Boolean> function, int r, BlockPos pos) {
        boolean isValid = true;
        System.out.println("squareiterate");
        for (int x = -r; x <= r; x++) {
            BlockPos.Mutable mutable = new BlockPos.Mutable();
            //-z
            mutable.set(pos).move(Direction.NORTH, r).move(Direction.EAST, x);
            if (!function.apply(mutable)) {
                isValid = false;
            }
            System.out.println(isValid);
            //+z
            mutable.set(pos).move(Direction.SOUTH, r).move(Direction.EAST, x);
            if (!function.apply(mutable)) {
                isValid = false;
            }
            System.out.println(isValid);
            //-x
            mutable.set(pos).move(Direction.WEST, r).move(Direction.SOUTH, x);
            if (!function.apply(mutable)) {
                isValid = false;
            }
            System.out.println(isValid);
            //+x
            mutable.set(pos).move(Direction.EAST, r).move(Direction.SOUTH, x);
            if (!function.apply(mutable)) {
                isValid = false;
            }
            System.out.println(isValid);
        }
        return isValid;
    }
}
