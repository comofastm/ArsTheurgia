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
import team.comofas.arstheurgia.blocks.ceramicaltar.CeramicAltarBlockEntity;
import team.comofas.arstheurgia.blocks.table.TableBlockEntity;
import team.comofas.arstheurgia.entity.UdugEntity;
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

public class UdugSummon extends Ritual {

    public static UdugSummon INSTANCE = new UdugSummon("udug", 70);

    public UdugSummon(String name, int cooldown) {
        super(name, cooldown);

        List<BlockPos> tableBlocks = new ArrayList<>();

        for (int x = -1; x < 2; x++) {
            tableBlocks.add(new BlockPos(x, 0, 0));
        }

        List<BlockPos> figurineBlocks = new ArrayList<>();
        figurineBlocks.add(new BlockPos(0, 1, 0));

        validBlocks.put(ArsBlocks.PAZUZU_FIGURINE, figurineBlocks);
        validBlocks.put(ArsBlocks.TABLE, tableBlocks);
        validBlocks.put(ArsBlocks.FLOUR, RitualUtils.SquareIterate(3, new BlockPos(0, 0, 0)));

    }

    @Override
    public boolean checkRitual() {
        return checkRitualWithRotation();
    }

    @Override
    public void onCall(Hand hand) {

        if (player.world.isDay()) {
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
                if (!entity.getPos().equals(hit.getBlockPos()))
                    player.world.removeBlock(entity.getPos(), false);
        }

        Entity lightningEntity = new LightningEntity(EntityType.LIGHTNING_BOLT, this.player.world);
        lightningEntity.teleport(pos.getX(), pos.getY(), pos.getZ());

        player.world.spawnEntity(lightningEntity);
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 50, 3, false, false));


        watchingPlayers.forEach(player ->
                ServerSidePacketRegistry.INSTANCE.sendToPlayer(player, ArsTheurgia.CONSUME_ITEM_PARTICLE, passedData));

        if (player.inventory.armor.get(EquipmentSlot.CHEST.getEntitySlotId()).getItem() != ArsItems.PAZUZU_AMULET) {
            player.damage(DamageSource.MAGIC, 2000);
            return;
        }

        player.getEntityWorld().playSound(null, pos, ArsSounds.RITUAL_CHIME, SoundCategory.AMBIENT, 1f, 1f);

        UdugEntity udug = new UdugEntity(ArsTheurgia.UDUG, player.world);
        udug.teleport(pos.getX(), pos.getY(), pos.getZ());

        PlayerComponents.KNOWLEDGE.get(player).setKnowledge("activeUdug", true);
        udug.setOwner(player);

        player.world.spawnEntity(udug);

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
                        if (placedItem.getItem() != ArsItems.BILE) {
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
