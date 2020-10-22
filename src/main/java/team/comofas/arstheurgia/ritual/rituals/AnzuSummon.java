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
import net.minecraft.item.Item;
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
import team.comofas.arstheurgia.entity.AnzuEntity;
import team.comofas.arstheurgia.entity.UdugEntity;
import team.comofas.arstheurgia.player.PlayerComponents;
import team.comofas.arstheurgia.registry.ArsBlocks;
import team.comofas.arstheurgia.registry.ArsItems;
import team.comofas.arstheurgia.registry.ArsSounds;
import team.comofas.arstheurgia.ritual.Ritual;
import team.comofas.arstheurgia.ritual.utils.RitualUtils;

import java.util.*;
import java.util.stream.Stream;

public class AnzuSummon extends Ritual {

    public static AnzuSummon INSTANCE = new AnzuSummon("anzu", 70);

    public AnzuSummon(String name, int cooldown) {
        super(name, cooldown);

        List<BlockPos> tableBlocks = new ArrayList<>();
        tableBlocks.add(new BlockPos(0, 0, 0));

        List<BlockPos> figurineBlocks = new ArrayList<>();
        figurineBlocks.add(new BlockPos(0, 0, 1));

        validBlocks.put(ArsBlocks.PAZUZU_FIGURINE, figurineBlocks);
        validBlocks.put(ArsBlocks.TABLE, tableBlocks);
        validBlocks.put(ArsBlocks.CERAMIC_ALTAR, RitualUtils.FoldSquare(2, 4, new BlockPos(0,0,0)));
        validBlocks.put(ArsBlocks.FLOUR, RitualUtils.SquareIterate(4, new BlockPos(0, 0, 0)));


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

        if (!PlayerComponents.KNOWLEDGE.get(player).hasKnowledge("lamashtuBlessing")) {
            return;
        }

        BlockPos pos = hit.getBlockPos();

        Stream<PlayerEntity> watchingPlayers = PlayerStream.watching(player.world, pos);
        PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());

        passedData.writeBlockPos(pos);


        for (BlockEntity entity : ritualBlocks) {
            if (entity != null)
                player.world.removeBlock(entity.getPos(), false);
        }

        /*Entity lightningEntity = new LightningEntity(EntityType.LIGHTNING_BOLT, this.player.world);
        lightningEntity.teleport(pos.getX(), pos.getY(), pos.getZ());

        player.world.spawnEntity(lightningEntity);*/
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 50, 3, false, false));


        watchingPlayers.forEach(player ->
                ServerSidePacketRegistry.INSTANCE.sendToPlayer(player, ArsTheurgia.CONSUME_ITEM_PARTICLE, passedData));

        player.getEntityWorld().playSound(null, pos, ArsSounds.RITUAL_CHIME, SoundCategory.AMBIENT, 1f, 1f);


        if (!player.world.isClient()) {
            AnzuEntity anzu = new AnzuEntity(ArsTheurgia.ANZU, player.world);
            anzu.teleport(pos.getX(), pos.getY(), pos.getZ());
            anzu.setOwner(player);

            player.world.spawnEntity(anzu);
        }

        PlayerComponents.EVIL.get(player).setEvil(PlayerComponents.EVIL.get(player).getEvil() + 2);


    }

    public boolean hasNecessaryItems() {
        boolean hasNecessaryItems = true;

        List<Item> altarItems = new ArrayList<>();
        List<Item> correctItems = Arrays.asList(Items.WATER_BUCKET, Items.NETHER_WART, Items.LAVA_BUCKET, Items.KELP);


        for (BlockEntity entity : ritualBlocks) {

            if (entity instanceof CeramicAltarBlockEntity) {

                BlockPos pos = entity.getPos();

                CeramicAltarBlockEntity ritualBlockEntity = (CeramicAltarBlockEntity) entity;

                if (ritualBlockEntity.getPlacedItem() != null) {
                    ItemStack placedItem = ritualBlockEntity.getPlacedItem();
                    if (pos.getZ() != hit.getBlockPos().getZ() || pos.getX() != hit.getBlockPos().getX()) {
                        altarItems.add(placedItem.getItem());
                    }
                } else {
                    hasNecessaryItems = false;
                }
            } else if (entity instanceof TableBlockEntity) {

                BlockPos pos = entity.getPos();

                TableBlockEntity ritualBlockEntity = (TableBlockEntity) entity;
                if (ritualBlockEntity.getPlacedItem() != null) {
                    if (pos.getZ() == hit.getBlockPos().getZ() && pos.getX() == hit.getBlockPos().getX()) {
                        if (ritualBlockEntity.getPlacedItem().getItem() != Items.FEATHER) {
                            hasNecessaryItems = false;
                        }
                    }
                } else {
                    hasNecessaryItems = false;
                }
            }

        }

        if (!(new HashSet<>(altarItems).equals(new HashSet<>(correctItems)))) {
            hasNecessaryItems = false;
        }

        return hasNecessaryItems;

    }

}
