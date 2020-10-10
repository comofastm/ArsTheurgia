package team.comofas.arstheurgia.ritual.rituals;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import team.comofas.arstheurgia.registry.ArsEffects;
import team.comofas.arstheurgia.registry.ArsSounds;
import team.comofas.arstheurgia.ritual.Ritual;
import team.comofas.arstheurgia.ritual.utils.RitualUtils;

import java.util.List;
import java.util.Map;

public class CreeperSummon extends Ritual {

    public static final CreeperSummon INSTANCE = new CreeperSummon("creeper", 70);

    public CreeperSummon(String name, int cooldown) {
        super(name, cooldown);
        validBlocks.put(Blocks.TORCH, RitualUtils.FoldSquare(3, 4, new BlockPos(0, 0, 0)));
        System.out.println(RitualUtils.SquareIterate(2, new BlockPos(0, 0, 0)));
        validBlocks.put(Blocks.REDSTONE_WIRE, RitualUtils.SquareIterate(2, new BlockPos(0, 0, 0)));
    }

    @Override
    public boolean checkRitual() {
        isValid = true;
        loop:
        for (Map.Entry<Block, List<BlockPos>> entry: this.validBlocks.entrySet()) {
            for (BlockPos p : entry.getValue()) {

                BlockState blockState = player.getEntityWorld().getBlockState(p.add(hit.getBlockPos()));
                if (!blockState.isOf(entry.getKey())) {
                    isValid = false;
                    break loop;
                }

            }
        }
        return isValid;
    }

    @Override
    public void onCall(Hand hand) {
        this.player = player;
        this.state = state;

        World world = this.player.getEntityWorld();
        BlockPos pos = this.hit.getBlockPos();

        player.getEntityWorld().playSound(null, hit.getBlockPos(), ArsSounds.RITUAL_CHIME, SoundCategory.AMBIENT, 1f, 1f);
        player.sendMessage(new LiteralText("it does work"), true);
        EntityType.CREEPER.spawn((ServerWorld) world, null, null, null, pos, SpawnReason.MOB_SUMMONED, true, true);
        player.addStatusEffect(new StatusEffectInstance(ArsEffects.PAZUZU_BLESSING, 69696, 1, true, false));
    }
}

