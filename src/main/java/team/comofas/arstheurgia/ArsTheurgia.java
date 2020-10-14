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
import team.comofas.arstheurgia.entity.LamassuEntity;
import team.comofas.arstheurgia.entity.UdugEntity;
import team.comofas.arstheurgia.entity.lamassu.LamassuEntityRenderer;
import team.comofas.arstheurgia.entity.udug.UdugEntityRenderer;
import team.comofas.arstheurgia.events.LootTableEvent;
import team.comofas.arstheurgia.registry.*;

public class ArsTheurgia implements ModInitializer {

    public static final EntityType<UdugEntity> CUBE = Registry.register(
            Registry.ENTITY_TYPE,
            ArsUtils.getIdentifier("udug"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, UdugEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityType<LamassuEntity> LAMASSU = Registry.register(
            Registry.ENTITY_TYPE,
            ArsUtils.getIdentifier("lamassu"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, LamassuEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
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

        FabricDefaultAttributeRegistry.register(CUBE, UdugEntity.createMobAttributes());

        FabricDefaultAttributeRegistry.register(LAMASSU, LamassuEntity.createMobAttributes());

        EntityRendererRegistry.INSTANCE.register(ArsTheurgia.CUBE, (dispatcher, context) -> {
            return new UdugEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(ArsTheurgia.LAMASSU, (dispatcher, context) -> {
            return new LamassuEntityRenderer(dispatcher);
        });

    }
}
