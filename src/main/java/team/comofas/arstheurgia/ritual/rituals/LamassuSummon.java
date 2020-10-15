package team.comofas.arstheurgia.ritual.rituals;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.server.PlayerStream;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.damage.DamageSource;
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
import team.comofas.arstheurgia.blocks.ceramicaltar.CeramicAltarBlock;
import team.comofas.arstheurgia.blocks.ceramicaltar.CeramicAltarBlockEntity;
import team.comofas.arstheurgia.blocks.table.TableBlockEntity;
import team.comofas.arstheurgia.entity.LamassuEntity;
import team.comofas.arstheurgia.entity.UdugEntity;
import team.comofas.arstheurgia.player.PlayerComponents;
import team.comofas.arstheurgia.registry.ArsBlocks;
import team.comofas.arstheurgia.registry.ArsItems;
import team.comofas.arstheurgia.registry.ArsSounds;
import team.comofas.arstheurgia.ritual.Ritual;
import team.comofas.arstheurgia.ritual.utils.RitualUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LamassuSummon extends Ritual {

    public static LamassuSummon INSTANCE = new LamassuSummon("lamassu", 70);

    public LamassuSummon(String name, int cooldown) {
        super(name, cooldown);

        List<BlockPos> tableBlocks = new ArrayList<>();

        for (int x = -1; x < 2; x++) {
            tableBlocks.add(new BlockPos(x, 0, 0));
        }

        List<BlockPos> figurineBlocks = new ArrayList<>();
        figurineBlocks.add(new BlockPos(0, 1, 0));

        List<BlockPos> altarBlocks = new ArrayList<>();
        altarBlocks.add(new BlockPos(0, 0, 1));

        List<BlockPos> mirsuBlocks = new ArrayList<>();
        mirsuBlocks.add(new BlockPos(1, 0, 1));
        mirsuBlocks.add(new BlockPos(-1, 0, 1));

        validBlocks.put(ArsBlocks.CERAMIC_ALTAR, altarBlocks);
        validBlocks.put(ArsBlocks.SAMAS_FIGURINE, figurineBlocks);
        validBlocks.put(ArsBlocks.TABLE, tableBlocks);
        validBlocks.put(ArsBlocks.MIRSU_BOWL, mirsuBlocks);

    }

    @Override
    public boolean checkRitual() {
        return checkRitualWithRotation();
    }

    @Override
    public void onCall(Hand hand) {

        if (PlayerComponents.EVIL.get(player).getEvil() >= 30) {
            player.sendMessage(new TranslatableText("ritual.tooevil"), true);
            return;
        }

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
            if (entity != null)
                if (entity instanceof TableBlockEntity) {
                    ((TableBlockEntity)entity).setPlacedItem(null);
                    ((TableBlockEntity)entity).sync();
                } else if (entity instanceof CeramicAltarBlockEntity) {
                    ((CeramicAltarBlockEntity)entity).setPlacedItem(null);
                    ((CeramicAltarBlockEntity)entity).sync();
                }
        }

        player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 50, 3, false, false));

        watchingPlayers.forEach(player ->
                ServerSidePacketRegistry.INSTANCE.sendToPlayer(player, ArsTheurgia.CONSUME_ITEM_PARTICLE, passedData));


        player.getEntityWorld().playSound(null, pos, ArsSounds.RITUAL_CHIME, SoundCategory.AMBIENT, 1f, 1f);


        LamassuEntity entity = new LamassuEntity(ArsTheurgia.LAMASSU, player.world);
        entity.teleport(pos.getX(), pos.getY(), pos.getZ());
        entity.setOwner(player);
        player.world.spawnEntity(entity);

    }

    public boolean hasNecessaryItems() {
        boolean hasNecessaryItems = true;

        for (BlockEntity entity : ritualBlocks) {

            if (entity instanceof TableBlockEntity) {
                BlockPos pos = entity.getPos();

                TableBlockEntity ritualBlockEntity = (TableBlockEntity) entity;

                if (ritualBlockEntity.getPlacedItem() != null) {
                    ItemStack placedItem = ritualBlockEntity.getPlacedItem();
                    if (pos.getZ() == hit.getBlockPos().getZ() && pos.getX() == hit.getBlockPos().getX()) {
                        if (ritualBlockEntity.getPlacedItem() != null && !ritualBlockEntity.getPlacedItem().isEmpty()) {
                            hasNecessaryItems = false;
                        }
                    } else {
                        if (!placedItem.getItem().isFood()) {
                            hasNecessaryItems = false;
                        }
                    }
                } else {
                    hasNecessaryItems = false;
                }
            } else if (entity instanceof CeramicAltarBlockEntity) {

                CeramicAltarBlockEntity ritualBlockEntity = (CeramicAltarBlockEntity) entity;
                if (ritualBlockEntity.getPlacedItem() != null) {
                    ItemStack placedItem = ritualBlockEntity.getPlacedItem();

                    if (placedItem.getItem() != Items.BEEF) {
                        hasNecessaryItems = false;
                    } else if (placedItem.getCount() < 15) {
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
