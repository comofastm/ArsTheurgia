package team.comofas.arstheurgia.registry;

import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import team.comofas.arstheurgia.ArsUtils;
import team.comofas.arstheurgia.structures.RuinFeature;
import team.comofas.arstheurgia.structures.RuinGenerator;

public class ArsStructures {
    public static final StructurePieceType HOUSE_RUIN = RuinGenerator.HousePiece::new;
    private static final StructureFeature<DefaultFeatureConfig> RUIN_FEATURE = new RuinFeature(DefaultFeatureConfig.CODEC);
    public static final ConfiguredStructureFeature<?, ?> RUIN_FEATURE_CONFIGURED = RUIN_FEATURE.configure(DefaultFeatureConfig.DEFAULT);
    public static final ConfiguredFeature<?, ?> MY_TREE = Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ArsBlocks.DATE_TREE_LOG.getDefaultState()), new SimpleBlockStateProvider(ArsBlocks.DATE_LEAVES.getDefaultState()), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new ForkingTrunkPlacer(5, 2, 2), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build());

    public static void registerAll() {
        Registry.register(Registry.STRUCTURE_PIECE, ArsUtils.getIdentifier("my_piece"), HOUSE_RUIN);
        FabricStructureBuilder.create(ArsUtils.getIdentifier("my_piece"), RUIN_FEATURE)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(32, 8, 12345)
                .adjustsSurface()
                .register();

        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, ArsUtils.getIdentifier("my_piece"),
                RUIN_FEATURE_CONFIGURED);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, ArsUtils.getIdentifier("treetest"), MY_TREE);
    }
}
