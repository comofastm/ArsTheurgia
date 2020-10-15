package team.comofas.arstheurgia.ritual.rituals;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.server.PlayerStream;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import team.comofas.arstheurgia.ArsTheurgia;
import team.comofas.arstheurgia.blocks.ceramicaltar.CeramicAltarBlockEntity;
import team.comofas.arstheurgia.blocks.table.TableBlockEntity;
import team.comofas.arstheurgia.registry.ArsBlocks;
import team.comofas.arstheurgia.registry.ArsItems;
import team.comofas.arstheurgia.registry.ArsSounds;
import team.comofas.arstheurgia.ritual.Ritual;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SharurRitual extends Ritual {

    public static SharurRitual INSTANCE = new SharurRitual("sharur", 70);

    public SharurRitual(String name, int cooldown) {
        super(name, cooldown);


        List<BlockPos> tableBlocks = new ArrayList<>();

        for (int x = -1; x < 2; x++) {
            tableBlocks.add(new BlockPos(x, 0, 0));
        }

        List<BlockPos> mirsuBlocks = new ArrayList<>();
        mirsuBlocks.add(new BlockPos(-1,0,1));
        mirsuBlocks.add(new BlockPos(1,0,1));

        List<BlockPos> figurineBlocks = new ArrayList<>();
        figurineBlocks.add(new BlockPos(0,0,1));

        validBlocks.put(ArsBlocks.MIRSU_BOWL, mirsuBlocks);
        validBlocks.put(ArsBlocks.SAMAS_FIGURINE, figurineBlocks);
        validBlocks.put(ArsBlocks.TABLE, tableBlocks);
    }


    @Override
    public boolean checkRitual() {
        return checkRitualWithRotation();
    }

    @Override
    public void onCall(Hand hand) {

        if (!player.world.isDay()) {
            player.sendMessage(new TranslatableText("ritual.pazuzu.notday"), true);
            return;
        }

        boolean hasNecessaryItems = hasNecessaryItems();

        if (!hasNecessaryItems) {
            return;
        }

        BlockPos pos = hit.getBlockPos();

        Stream<PlayerEntity> watchingPlayers = PlayerStream.watching(player.world, pos);
        PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());

        passedData.writeBlockPos(pos);

        for (BlockEntity entity : ritualBlocks) {
            if (entity instanceof TableBlockEntity) {
                TableBlockEntity tableBlockEntity = (TableBlockEntity) entity;
                tableBlockEntity.setPlacedItem(null);
                tableBlockEntity.sync();
            }

        }


        watchingPlayers.forEach(player ->
                ServerSidePacketRegistry.INSTANCE.sendToPlayer(player, ArsTheurgia.CONSUME_ITEM_PARTICLE, passedData));

        player.getEntityWorld().playSound(null, pos, ArsSounds.RITUAL_CHIME, SoundCategory.AMBIENT, 1f, 1f);

    }

    public boolean hasNecessaryItems() {
        boolean hasNecessaryItems = true;

        for (BlockEntity entity : ritualBlocks) {

            if (entity == null) {
                continue;
            }

            BlockPos pos = entity.getPos();

            if (entity instanceof TableBlockEntity) {

                TableBlockEntity ritualBlockEntity = (TableBlockEntity) entity;

                if (ritualBlockEntity.getPlacedItem() != null && !ritualBlockEntity.getPlacedItem().isEmpty()) {
                    ItemStack placedItem = ritualBlockEntity.getPlacedItem();
                    if (pos.getZ() == hit.getBlockPos().getZ() && pos.getX() == hit.getBlockPos().getX()) {
                        if (placedItem.getItem() != ArsItems.MACE ) {
                            hasNecessaryItems = false;
                        }
                    } else {
                        if (placedItem.getItem() != Items.DIAMOND && placedItem.getItem() != Items.EMERALD) {
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
