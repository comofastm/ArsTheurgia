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
import team.comofas.arstheurgia.player.PlayerComponents;
import team.comofas.arstheurgia.registry.ArsBlocks;
import team.comofas.arstheurgia.registry.ArsEffects;
import team.comofas.arstheurgia.registry.ArsItems;
import team.comofas.arstheurgia.registry.ArsSounds;
import team.comofas.arstheurgia.ritual.Ritual;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SamasPurification extends Ritual {

    public static SamasPurification INSTANCE = new SamasPurification("samas", 70);

    public SamasPurification(String name, int cooldown) {
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
        return checkRitualWithRotation();
    }

    @Override
    public void onCall(Hand hand) {

        if (player.world.isDay()) {
            player.sendMessage(new TranslatableText("ritual.pazuzu.notnight"), true);
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
            if (entity != null)
                if (entity.getPos().equals(hit.getBlockPos()) && entity instanceof CeramicAltarBlockEntity) {
                    if (((CeramicAltarBlockEntity)entity).getPlacedItem().getItem() == ArsItems.PAZUZU_AMULET) {
                        ((CeramicAltarBlockEntity)entity).setPlacedItem(new ItemStack(ArsItems.PAZUZU_AMULET_INFUSED));
                        /*if (!player.world.isClient())
                            ((CeramicAltarBlockEntity)entity).sync();*/
                    }
                } else {
                    player.world.removeBlock(entity.getPos(), false);
                }



        }
        if (!player.world.isClient()) {
            Entity lightningEntity = new LightningEntity(EntityType.LIGHTNING_BOLT, this.player.world);
            lightningEntity.teleport(pos.getX(), pos.getY(), pos.getZ());

            player.world.spawnEntity(lightningEntity);
        }

        player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 50, 3, false, false));


        watchingPlayers.forEach(player ->
                ServerSidePacketRegistry.INSTANCE.sendToPlayer(player, ArsTheurgia.CONSUME_ITEM_PARTICLE, passedData));

        player.getEntityWorld().playSound(null, pos, ArsSounds.RITUAL_CHIME, SoundCategory.AMBIENT, 1f, 1f);

    }

    public boolean hasNecessaryItems() {
        boolean hasNecessaryItems = true;

        for (BlockEntity entity : ritualBlocks) {

            BlockPos pos = entity.getPos();

            if (entity instanceof CeramicAltarBlockEntity) {


                CeramicAltarBlockEntity ritualBlockEntity = (CeramicAltarBlockEntity) entity;

                if (ritualBlockEntity.getPlacedItem() != null && !ritualBlockEntity.getPlacedItem().isEmpty()) {
                    ItemStack placedItem = ritualBlockEntity.getPlacedItem();
                    if (pos.getZ() == hit.getBlockPos().getZ() && pos.getX() == hit.getBlockPos().getX()) {
                        if (placedItem == null || placedItem.isEmpty() ) {
                            hasNecessaryItems = false;
                        }
                    } else {
                        if (placedItem.getItem() != Items.HONEY_BOTTLE) {
                            hasNecessaryItems = false;
                        }
                    }
                } else {
                    hasNecessaryItems = false;
                }
            } else if (entity instanceof TableBlockEntity) {

                TableBlockEntity ritualBlockEntity = (TableBlockEntity) entity;
                if (ritualBlockEntity.getPlacedItem() != null && !ritualBlockEntity.getPlacedItem().isEmpty()) {
                    ItemStack placedItem = ritualBlockEntity.getPlacedItem();
                    if (!placedItem.getItem().isFood()) {
                        hasNecessaryItems = false;
                    }
                } else {
                    hasNecessaryItems = false;
                }


            }

        }

        return hasNecessaryItems;

    }

}
