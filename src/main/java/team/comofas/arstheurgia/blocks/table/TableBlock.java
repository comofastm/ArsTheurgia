package team.comofas.arstheurgia.blocks.table;

import net.fabricmc.fabric.api.server.PlayerStream;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.comofas.arstheurgia.blocks.RitualBlockEntity;
import team.comofas.arstheurgia.items.OpenableTablet;
import team.comofas.arstheurgia.player.PlayerComponents;
import team.comofas.arstheurgia.ritual.Ritual;

public class TableBlock extends Block implements BlockEntityProvider {

    public TableBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        TableBlockEntity blockentity = (TableBlockEntity) world.getBlockEntity(pos);


        Item heldItem = player.getStackInHand(hand).getItem();

        ItemStack placedItem = blockentity.getPlacedItem();

        if (!world.isClient) {
            if (heldItem instanceof OpenableTablet) {
                if (PlayerComponents.KNOWLEDGE.get(player).hasKnowledge(((OpenableTablet) heldItem).ritualName)) {

                    Ritual ritual = Ritual.ritualsByName.get(((OpenableTablet) heldItem).ritualName);
                    PlayerComponents.KNOWLEDGE.get(player).setKnowledge("block.arstheurgia.asyriel_sigil_chalk", true);
                    PlayerComponents.KNOWLEDGE.get(player).setKnowledge("block.arstheurgia.autumn_symbol_chalk", true);
                    Ritual.callRitual(ritual, state, player, hand, hit);
                    return ActionResult.SUCCESS;

                }
            }
        }

        if (!(heldItem instanceof OpenableTablet)) {

            if (heldItem instanceof BlockItem) {
                return ActionResult.FAIL;
            }

            if (heldItem.asItem() != Items.AIR && (blockentity.getPlacedItem() == null || blockentity.getPlacedItem().isEmpty())) {
                blockentity.setPlacedItem(player.getStackInHand(hand));
                /*if (!world.isClient())
                    blockentity.sync();*/
                player.getInventory().removeOne(player.getStackInHand(hand));
                return ActionResult.CONSUME;
            } else if (placedItem != null && placedItem != ItemStack.EMPTY) {
                player.getInventory().insertStack(placedItem);
                blockentity.setPlacedItem(ItemStack.EMPTY);
                /*if (!world.isClient())
                    blockentity.sync();*/
                return ActionResult.SUCCESS;
            }

        }

        return ActionResult.FAIL;

    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        player.getInventory().insertStack(((TableBlockEntity)blockEntity).getPlacedItem());
        super.afterBreak(world, player, pos, state, blockEntity, stack);

    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.25f, 0f, 0.25f, 0.75f, 1.0f, 0.75f);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TableBlockEntity(pos, state);
    }
}
