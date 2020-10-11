package team.comofas.arstheurgia.registry;

import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import team.comofas.arstheurgia.ArsUtils;
import team.comofas.arstheurgia.structures.RuinFeature;
import team.comofas.arstheurgia.structures.RuinGenerator;

public class ArsStructures {
    public static final StructurePieceType HOUSE_RUIN = RuinGenerator.MyPiece::new;
    private static final StructureFeature<DefaultFeatureConfig> RUIN_FEATURE = new RuinFeature(DefaultFeatureConfig.CODEC);
    public static final ConfiguredStructureFeature<?, ?> RUIN_FEATURE_CONFIGURED = RUIN_FEATURE.configure(DefaultFeatureConfig.DEFAULT);

    public static void registerAll() {
        Registry.register(Registry.STRUCTURE_PIECE, ArsUtils.getIdentifier("my_piece"), HOUSE_RUIN);
        FabricStructureBuilder.create(ArsUtils.getIdentifier("my_piece"), RUIN_FEATURE)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(32, 8, 12345)
                .adjustsSurface()
                .register();

        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, ArsUtils.getIdentifier("my_piece"),
                RUIN_FEATURE_CONFIGURED);
    }
}
