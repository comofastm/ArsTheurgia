package team.comofas.arstheurgia.ritual.rituals;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.server.PlayerStream;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.LiteralText;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import team.comofas.arstheurgia.ArsTheurgia;
import team.comofas.arstheurgia.blocks.CeramicAltarBlock;
import team.comofas.arstheurgia.blocks.CeramicAltarBlockEntity;
import team.comofas.arstheurgia.blocks.RitualBlockEntity;
import team.comofas.arstheurgia.registry.ArsBlocks;
import team.comofas.arstheurgia.registry.ArsEffects;
import team.comofas.arstheurgia.registry.ArsSounds;
import team.comofas.arstheurgia.ritual.Ritual;
import team.comofas.arstheurgia.ritual.utils.RitualUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class PazuzuBlessing extends Ritual {

    public static final PazuzuBlessing INSTANCE = new PazuzuBlessing("pazuzu", 70);

    public PazuzuBlessing(String name, int cooldown) {
        super(name, cooldown);

        List<BlockPos> altarBlocks = new ArrayList<>();

        for (int x = -1; x < 2; x++) {
            altarBlocks.add(new BlockPos(x, 0, 0));
        }

        List<BlockPos> tableBlocks = new ArrayList<>();

        for (int x = -1; x < 2; x++) {
            tableBlocks.add(new BlockPos(x, 0, 1));
        }


        validBlocks.put(ArsBlocks.CERAMIC_ALTAR, altarBlocks);
        validBlocks.put(ArsBlocks.TABLE, tableBlocks);

    }

    @Override
    public boolean checkRitual() {

        for (Map.Entry<Block, List<BlockPos>> entry: this.validBlocks.entrySet()) {

            List<BlockPos> blocks =  entry.getValue();

            for (int i = 0; i < 4; i++) {

                isValid = true;
                for (BlockPos p : blocks) {

                    World world = player.getEntityWorld();

                    BlockState blockState = world.getBlockState(p.add(hit.getBlockPos()));


                    if (!blockState.isOf(entry.getKey())) {
                        isValid = false;
                        break;
                    } else {
                        ritualBlocks.add(world.getBlockEntity(p.add(hit.getBlockPos())));
                    }

                }

                if (isValid) {
                    break;
                }

                for (int j = 0; j < blocks.size(); j++) {
                    blocks.set(j, blocks.get(j).rotate(BlockRotation.CLOCKWISE_90));
                }

            }

            if (!isValid) {
                break;
            }

        }
        return isValid;
    }

    @Override
    public void onCall(Hand hand) {


        boolean hasNecessaryItems = hasNecessaryItems();

        if (!hasNecessaryItems) {
            return;
        }

        Stream<PlayerEntity> watchingPlayers = PlayerStream.watching(player.getEntityWorld(),hit.getBlockPos());
        PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());

        passedData.writeBlockPos(hit.getBlockPos());

        for (BlockEntity entity : ritualBlocks) {
            if (entity != null)
                player.getEntityWorld().removeBlock(entity.getPos(), false);
        }


        watchingPlayers.forEach(player ->
                ServerSidePacketRegistry.INSTANCE.sendToPlayer(player, ArsTheurgia.CONSUME_ITEM_PARTICLE, passedData));

        player.getEntityWorld().playSound(null, hit.getBlockPos(), ArsSounds.RITUAL_CHIME, SoundCategory.AMBIENT, 1f, 1f);
        player.addStatusEffect(new StatusEffectInstance(ArsEffects.PAZUZU_BLESSING, 69696, 1, true, false));
    }

    public boolean hasNecessaryItems() {
        boolean hasNecessaryItems = true;



        for (BlockEntity entity : ritualBlocks) {

            if (entity instanceof CeramicAltarBlockEntity) {
                BlockPos pos = entity.getPos();

                CeramicAltarBlockEntity ritualBlockEntity = (CeramicAltarBlockEntity) entity;

                if (ritualBlockEntity.getPlacedItem() != null) {
                    ItemStack placedItem = ritualBlockEntity.getPlacedItem();
                    if (pos.getZ() == hit.getBlockPos().getZ() && pos.getX() == hit.getBlockPos().getX()) {
                        if (placedItem.getItem() != Items.GOLD_INGOT) {
                            hasNecessaryItems = false;
                        }
                    } else {
                        if (!placedItem.isFood()) {
                            hasNecessaryItems = false;
                        }
                    }
                } else {
                    hasNecessaryItems = false;
                }
            }

        }

        return hasNecessaryItems;

    }

}

