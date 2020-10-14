package team.comofas.arstheurgia;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.comofas.arstheurgia.entity.AnzuEntity;
import team.comofas.arstheurgia.entity.LamassuEntity;
import team.comofas.arstheurgia.entity.TormentedCreeperEntity;
import team.comofas.arstheurgia.entity.UdugEntity;
import team.comofas.arstheurgia.entity.anzu.AnzuEntityRenderer;
import team.comofas.arstheurgia.entity.lamassu.LamassuEntityRenderer;
import team.comofas.arstheurgia.entity.tormentedcreeper.TormentedCreeperEntityRenderer;
import team.comofas.arstheurgia.entity.udug.UdugEntityRenderer;
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
    public static final Identifier UPDATE_BLOCK_ENTITY = ArsUtils.getIdentifier("update_block_entity");

    @Override
    public void onInitialize() {

        ArsSounds.registerAll();
        ArsBlocks.registerAll();
        ArsItems.registerAll();
        ArsEffects.registerAll();
        ArsStructures.registerAll();
        LootTableEvent.register();

        FabricDefaultAttributeRegistry.register(UDUG, UdugEntity.createMobAttributes());

        FabricDefaultAttributeRegistry.register(LAMASSU, LamassuEntity.createMobAttributes());

        FabricDefaultAttributeRegistry.register(ANZU, AnzuEntity.createMobAttributes());

        FabricDefaultAttributeRegistry.register(TORMENTEDCREEPER, TormentedCreeperEntity.createAttributes());

        EntityRendererRegistry.INSTANCE.register(ArsTheurgia.UDUG, (dispatcher, context) -> new UdugEntityRenderer(dispatcher));

        EntityRendererRegistry.INSTANCE.register(ArsTheurgia.LAMASSU, (dispatcher, context) -> new LamassuEntityRenderer(dispatcher));

        EntityRendererRegistry.INSTANCE.register(ArsTheurgia.ANZU, (dispatcher, context) -> new AnzuEntityRenderer(dispatcher));

        EntityRendererRegistry.INSTANCE.register(ArsTheurgia.TORMENTEDCREEPER, (dispatcher, context) -> new TormentedCreeperEntityRenderer(dispatcher));

    }
}
