package team.comofas.arstheurgia.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
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
import team.comofas.arstheurgia.ArsTheurgia;
import team.comofas.arstheurgia.blocks.ChalkBlock;
import team.comofas.arstheurgia.player.PlayerComponents;
import team.comofas.arstheurgia.registry.ArsBlocks;
import team.comofas.arstheurgia.registry.ArsSounds;

import java.util.*;

import static net.minecraft.block.HorizontalFacingBlock.FACING;

public class ChalkItem extends Item {

    private List ChalkList = new ArrayList();;

    public ChalkItem(Item.Settings settings) { super(settings); }

    private void getPlayerChalkList(PlayerEntity player) {
        List temp = new ArrayList();;
        Iterator it = ChalkBlock.getChalk().iterator();

        while (it.hasNext()) {
            Block block = (Block) it.next();
            if (PlayerComponents.KNOWLEDGE.get(player).hasKnowledge(block.getTranslationKey())) {
                temp.add(block);

            }
        }
        ChalkList = temp;
    }

    private Block getBlockItem(int index) {
        return (Block) ChalkList.get(index);
    }

    private void cycle(NbtCompound current, boolean inverse) {
        int index = current.getInt("index");
        int length = ChalkList.size();
        if (length != 0) {
            if (!inverse) {
                current.putInt("index", (index+1)%length);
            } else {
                if (index > 0) {
                    current.putInt("index", (index-1)%length);
                } else {
                    current.putInt("index", length-1);
                }
            }
        } else {
            current.putInt("index", 0);
        }
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        getPlayerChalkList(user);
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
        NbtCompound compoundTag = stack.getOrCreateSubNbt("Index");
        if (update) {
            world.setBlockState(placePos.offset(hit.getSide()), getBlockItem(compoundTag.getInt("index")).getDefaultState().with(FACING, player.getHorizontalFacing()), 3);
            stack.setCount(1);
            stack.damage(1, new Random(), (ServerPlayerEntity) player);
            world.playSound(null, placePos, ArsSounds.CHALK, SoundCategory.BLOCKS, 1f, 1f);
        } else {
            cycle(compoundTag, player.isSneaking());
            player.sendMessage(Text.of(""+ChalkList.get(compoundTag.getInt("index"))), true);
        }

    }
}