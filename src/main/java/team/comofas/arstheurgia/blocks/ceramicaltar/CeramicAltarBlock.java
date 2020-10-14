package team.comofas.arstheurgia.blocks.ceramicaltar;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.comofas.arstheurgia.blocks.RitualBlockEntity;
import team.comofas.arstheurgia.items.OpenableTablet;
import team.comofas.arstheurgia.player.PlayerComponents;
import team.comofas.arstheurgia.ritual.Ritual;

public class CeramicAltarBlock extends Block implements BlockEntityProvider {

    public CeramicAltarBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        CeramicAltarBlockEntity blockentity = (CeramicAltarBlockEntity) world.getBlockEntity(pos);


        Item heldItem = player.getStackInHand(hand).getItem();

        ItemStack placedItem = blockentity.getPlacedItem();

        if (!world.isClient) {
            if (heldItem instanceof OpenableTablet) {
                if (PlayerComponents.KNOWLEDGE.get(player).hasKnowledge(((OpenableTablet) heldItem).ritualName)) {

                    Ritual ritual = Ritual.ritualsByName.get(((OpenableTablet) heldItem).ritualName);
                    PlayerComponents.KNOWLEDGE.get(player).setKnowledge("block.arstheurgia.asyriel_sigil_chalk", true);
                    PlayerComponents.KNOWLEDGE.get(player).setKnowledge("block.arstheurgia.autumn_symbol_chalk", true);
                    System.out.println("aa");
                    Ritual.callRitual(ritual, state, player, hand, hit);
                    return ActionResult.SUCCESS;

                } else {
                    player.sendMessage(new LiteralText("first " + PlayerComponents.KNOWLEDGE.get(player).hasKnowledge("creeper") + " " + player.getEntityId()), false);
                }
            }
        }

        if (!(heldItem instanceof OpenableTablet)) {
            if (heldItem.asItem() != Items.AIR && (blockentity.getPlacedItem() == null || blockentity.getPlacedItem().isEmpty())) {
                blockentity.setPlacedItem(player.getStackInHand(hand));
                player.inventory.removeOne(player.getStackInHand(hand));
                return ActionResult.CONSUME;
            } else if (placedItem != null && placedItem != ItemStack.EMPTY) {
                player.inventory.insertStack(placedItem);

                blockentity.setPlacedItem(null);
                return ActionResult.SUCCESS;
            }

        }

        return ActionResult.FAIL;

    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        player.inventory.insertStack(((RitualBlockEntity)blockEntity).getPlacedItem());
        super.afterBreak(world, player, pos, state, blockEntity, stack);

    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockView world) {
        return new CeramicAltarBlockEntity();
    }
}
