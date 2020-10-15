package team.comofas.arstheurgia.events;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.predicate.PlayerPredicate;
import net.minecraft.predicate.entity.EntityEquipmentPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;
import team.comofas.arstheurgia.ArsUtils;
import team.comofas.arstheurgia.registry.ArsItems;
import team.comofas.arstheurgia.ritual.Ritual;

public class LootTableEvent {

    private static final Identifier DESERT_PYRAMID_ID = new Identifier("minecraft", "chests/desert_pyramid");

    private static final Identifier GRASS_ID = new Identifier("minecraft", "blocks/grass");

    public static void register() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {

            if (DESERT_PYRAMID_ID.equals(id)) {
                for (Item item : Ritual.allTabletParts) {
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .rolls(ConstantLootTableRange.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.65f/Ritual.allTabletParts.size()))
                            .withEntry(ItemEntry.builder(item).build());

                    supplier.pool(poolBuilder);
                }
            } else if (GRASS_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05F))
                        .withEntry(ItemEntry.builder(ArsItems.PISTACHIO).build());

                supplier.pool(poolBuilder);
            }
        });
    }
}
