package team.comofas.arstheurgia;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.comofas.arstheurgia.entity.AnzuEntity;
import team.comofas.arstheurgia.entity.LamassuEntity;
import team.comofas.arstheurgia.entity.TormentedCreeperEntity;
import team.comofas.arstheurgia.entity.UdugEntity;
import team.comofas.arstheurgia.events.LootTableEvent;
import team.comofas.arstheurgia.registry.*;

public class ArsTheurgia implements ModInitializer {


    public static final EntityType<UdugEntity> UDUG = Registry.register(
            Registry.ENTITY_TYPE,
            ArsUtils.getIdentifier("udug"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, UdugEntity::new).dimensions(EntityDimensions.fixed(1f, 2f)).build()
    );

    public static final EntityType<LamassuEntity> LAMASSU = Registry.register(
            Registry.ENTITY_TYPE,
            ArsUtils.getIdentifier("lamassu"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, LamassuEntity::new).dimensions(EntityDimensions.fixed(1f, 2f)).build()
    );

    public static final EntityType<AnzuEntity> ANZU = Registry.register(
            Registry.ENTITY_TYPE,
            ArsUtils.getIdentifier("anzu"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AnzuEntity::new).dimensions(EntityDimensions.fixed(1f, 2f)).build()
    );

    public static final EntityType<TormentedCreeperEntity> TORMENTEDCREEPER = Registry.register(
            Registry.ENTITY_TYPE,
            ArsUtils.getIdentifier("tormented_creeper"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TormentedCreeperEntity::new).dimensions(EntityDimensions.fixed(1f, 3f)).build()
    );

    public static final Identifier CONSUME_ITEM_PARTICLE = ArsUtils.getIdentifier("consume_item");

    @Override
    public void onInitialize() {

        ArsSounds.init();
        ArsBlocks.registerAll();
        ArsItems.registerAll();
        ArsEffects.registerAll();
        //ArsStructures.registerAll();
        LootTableEvent.register();

        FabricDefaultAttributeRegistry.register(UDUG, UdugEntity.createMobAttributes());

        FabricDefaultAttributeRegistry.register(LAMASSU, LamassuEntity.createMobAttributes());

        FabricDefaultAttributeRegistry.register(ANZU, AnzuEntity.createMobAttributes());

        FabricDefaultAttributeRegistry.register(TORMENTEDCREEPER, TormentedCreeperEntity.createAttributes());
    }
}
