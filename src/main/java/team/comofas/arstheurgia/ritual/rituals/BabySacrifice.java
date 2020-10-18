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
import team.comofas.arstheurgia.blocks.table.TableBlockEntity;
import team.comofas.arstheurgia.player.PlayerComponents;
import team.comofas.arstheurgia.registry.ArsBlocks;
import team.comofas.arstheurgia.registry.ArsEffects;
import team.comofas.arstheurgia.registry.ArsItems;
import team.comofas.arstheurgia.registry.ArsSounds;
import team.comofas.arstheurgia.ritual.Ritual;
import team.comofas.arstheurgia.ritual.utils.RitualUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BabySacrifice extends Ritual {

    public static BabySacrifice INSTANCE = new BabySacrifice("baby", 70);

    public BabySacrifice(String name, int cooldown) {
        super(name, cooldown);

        List<BlockPos> altarBlocks = new ArrayList<>();

        for (int x = -1; x < 2; x++) {
            altarBlocks.add(new BlockPos(x, 0, 0));
        }

        List<BlockPos> figurineBlocks = new ArrayList<>();
        figurineBlocks.add(new BlockPos(0,0,1));

        validBlocks.put(ArsBlocks.PAZUZU_FIGURINE, figurineBlocks);
        validBlocks.put(ArsBlocks.CERAMIC_ALTAR, altarBlocks);
        validBlocks.put(ArsBlocks.VELINHA, RitualUtils.FoldSquare(3, 4, new BlockPos(0,0,0)));
        validBlocks.put(ArsBlocks.FLOUR, RitualUtils.SquareIterate(4, new BlockPos(0,0,0)));

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

        if (player.world.getTime()-PlayerComponents.RITUALTIME.get(player).getInt("killBaby") > 200) {
            player.sendMessage(new TranslatableText("ritual.baby.nosacrifice"), true);
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

        if (!player.world.isClient()) {
            Entity lightningEntity = new LightningEntity(EntityType.LIGHTNING_BOLT, this.player.world);
            lightningEntity.teleport(pos.getX(), pos.getY(), pos.getZ());

            player.world.spawnEntity(lightningEntity);
        }

        player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 50, 3, false, false));


        watchingPlayers.forEach(player ->
                ServerSidePacketRegistry.INSTANCE.sendToPlayer(player, ArsTheurgia.CONSUME_ITEM_PARTICLE, passedData));

        if (player.inventory.armor.get(EquipmentSlot.CHEST.getEntitySlotId()).getItem() != ArsItems.PAZUZU_AMULET_INFUSED) {
            player.damage(DamageSource.MAGIC, 2000);
            return;
        }

        player.getEntityWorld().playSound(null, pos, ArsSounds.RITUAL_CHIME, SoundCategory.AMBIENT, 1f, 1f);


        StatusEffectInstance lamashtuEffectInstance = new StatusEffectInstance(ArsEffects.LAMASHTU_BLESSING, 60, 0, true, false);

        player.addStatusEffect(lamashtuEffectInstance);

        PlayerComponents.KNOWLEDGE.get(player).setKnowledge("lamashtuBlessing", true);

        if (PlayerComponents.EVIL.get(player).getEvil() < 50) {
            PlayerComponents.EVIL.get(player).setEvil(50);
        }


        PlayerComponents.EVIL.get(player).setEvil(PlayerComponents.EVIL.get(player).getEvil()+7);

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
                        if (placedItem.getItem() != ArsItems.BILE ) {
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
            }

        }

        return hasNecessaryItems;

    }



}
