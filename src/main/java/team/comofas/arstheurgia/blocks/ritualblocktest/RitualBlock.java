package team.comofas.arstheurgia.blocks.ritualblocktest;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.comofas.arstheurgia.blocks.RitualBlockEntity;
import team.comofas.arstheurgia.items.OpenableTablet;
import team.comofas.arstheurgia.ritual.Ritual;
import team.comofas.arstheurgia.ritual.rituals.CreeperSummon;

public class RitualBlock extends Block implements BlockEntityProvider {

    public RitualBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        RitualBlockEntity blockentity = (RitualBlockEntity) world.getBlockEntity(pos);
        if (!world.isClient) {
            blockentity.addIndex();

            Item heldItem = player.getStackInHand(hand).getItem();
            if (heldItem instanceof OpenableTablet) {
                Ritual ritual = Ritual.ritualsByName.get(((OpenableTablet)heldItem).ritualName);

                player.sendMessage(new LiteralText(""+blockentity.getIndex()), false);

                Ritual.callRitual(ritual, state, world, pos, player, hand, hit);
            }

        }

        return ActionResult.SUCCESS;
    }


    @Override
    public @Nullable BlockEntity createBlockEntity(BlockView world) {
        return new RitualBlockEntity();
    }
}
