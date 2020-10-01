package team.comofas.arstheurgia.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import team.comofas.arstheurgia.ritual.CheckForRitual;

public class RitualBlock extends Block {
    public RitualBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if (CheckForRitual.IsValidRitual(pos, world)) {
                player.sendMessage(new LiteralText("it does work"), true);
            }
        }

        return ActionResult.SUCCESS;
    }
}
