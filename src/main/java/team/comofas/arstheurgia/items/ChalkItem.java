package team.comofas.arstheurgia.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.Util;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Random;

public class ChalkItem extends Item {

    int length = 4;

    public ChalkItem(Item.Settings settings) { super(settings); }

    private Block getBlockItem(int index) {
        switch (index) {
            case 0: return Blocks.OBSIDIAN;
            case 1: return Blocks.ACACIA_FENCE;
            case 2: return Blocks.ACACIA_SLAB;
            default: return Blocks.YELLOW_CONCRETE;
        }
    }

    private void cycle(CompoundTag current, boolean inverse) {
        int index = current.getInt("index");
        if (!inverse) {
            current.putInt("index", (index+1)%length);
        } else {
            current.putInt("index", (index-1)%length);
        }
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        BlockHitResult hitResult = raycast(world, user, RaycastContext.FluidHandling.ANY);
        BlockPos blockPos = hitResult.getBlockPos();

        if (!world.isClient) {
            if (hitResult.getType() == HitResult.Type.BLOCK) {
                if (!(world.getBlockState(blockPos).isAir())) {
                    if (world.getBlockState(blockPos.offset(hitResult.getSide())).isAir()) {
                        this.place(blockPos, user, world, true, user.getStackInHand(hand), hitResult);
                    } else {
                        return new TypedActionResult<>(ActionResult.FAIL, user.getStackInHand(hand));
                    }

                }
            } else  {
                this.place(blockPos, user, world, false, user.getStackInHand(hand), null);
            }
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }

    private void place(BlockPos placePos, PlayerEntity player, WorldAccess world, boolean update, ItemStack stack, @Nullable BlockHitResult hit) {
        CompoundTag compoundTag = stack.getOrCreateSubTag("Index");
        if (update) {
            world.setBlockState(placePos.offset(hit.getSide()), getBlockItem(compoundTag.getInt("index")).getDefaultState(), 3);
            stack.setCount(1);
            stack.damage(1, new Random(), (ServerPlayerEntity) player);
        } else {
            cycle(compoundTag, player.isSneaking());
            player.sendMessage(Text.of(""+compoundTag.getInt("index")), true);
            System.out.println("hehe");
        }

    }
}