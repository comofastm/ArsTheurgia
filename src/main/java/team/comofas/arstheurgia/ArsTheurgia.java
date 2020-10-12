package team.comofas.arstheurgia;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import team.comofas.arstheurgia.events.LootTableEvent;
import team.comofas.arstheurgia.registry.*;
import team.comofas.arstheurgia.structures.RuinFeature;
import team.comofas.arstheurgia.structures.RuinGenerator;

public class ArsTheurgia implements ModInitializer {

    public static final Identifier CONSUME_ITEM_PARTICLE = ArsUtils.getIdentifier("consume_item");

    @Override
    public void onInitialize() {



        ArsSounds.registerAll();
        ArsBlocks.registerAll();
        ArsItems.registerAll();
        ArsEffects.registerAll();
        ArsStructures.registerAll();
        LootTableEvent.register();

    }
}
