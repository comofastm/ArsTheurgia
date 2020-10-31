package team.comofas.arstheurgia.registry;

import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
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

import java.util.HashMap;

public class ArsStructures {
    public static HashMap<Identifier, StructurePieceType> StructureList = new HashMap<Identifier, StructurePieceType>();

    public static final StructureFeature<DefaultFeatureConfig> HOUSE_FEATURE = new RuinFeature(DefaultFeatureConfig.CODEC, ArsUtils.getIdentifier("house"));
    public static final StructurePieceType HOUSE_RUIN = RuinGenerator.RuinPiece::new;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_HOUSE_FEATURE = HOUSE_FEATURE.configure(DefaultFeatureConfig.DEFAULT);

    public static final StructureFeature<DefaultFeatureConfig> DATE_RUIN_FEATURE = new RuinFeature(DefaultFeatureConfig.CODEC, ArsUtils.getIdentifier("date_ruin"));
    public static final StructurePieceType DATE_RUIN = RuinGenerator.RuinPiece::new;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_DATE_RUIN = DATE_RUIN_FEATURE.configure(DefaultFeatureConfig.DEFAULT);

    public static final StructureFeature<DefaultFeatureConfig> FRAGMENTED_RUIN_FEATURE = new RuinFeature(DefaultFeatureConfig.CODEC, ArsUtils.getIdentifier("fragmented_ruin"));
    public static final StructurePieceType FRAGMENTED_RUIN = RuinGenerator.RuinPiece::new;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_FRAGMENTED_RUIN = FRAGMENTED_RUIN_FEATURE.configure(DefaultFeatureConfig.DEFAULT);

    public static final StructureFeature<DefaultFeatureConfig> ONE_FLOOR_RUIN_FEATURE = new RuinFeature(DefaultFeatureConfig.CODEC, ArsUtils.getIdentifier("one_floor_ruin"));
    public static final StructurePieceType ONE_FLOOR_RUIN = RuinGenerator.RuinPiece::new;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_ONE_FLOOR_RUIN = ONE_FLOOR_RUIN_FEATURE.configure(DefaultFeatureConfig.DEFAULT);

    public static final StructureFeature<DefaultFeatureConfig> TABLE_RUIN_FEATURE = new RuinFeature(DefaultFeatureConfig.CODEC, ArsUtils.getIdentifier("table_ruin"));
    public static final StructurePieceType TABLE_RUIN = RuinGenerator.RuinPiece::new;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_TABLE_RUIN = TABLE_RUIN_FEATURE.configure(DefaultFeatureConfig.DEFAULT);

    public static final StructureFeature<DefaultFeatureConfig> TWO_FLOOR_RUIN_FEATURE = new RuinFeature(DefaultFeatureConfig.CODEC, ArsUtils.getIdentifier("two_floor_ruin"));
    public static final StructurePieceType TWO_FLOOR_RUIN = RuinGenerator.RuinPiece::new;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_TWO_FLOOR_RUIN = TWO_FLOOR_RUIN_FEATURE.configure(DefaultFeatureConfig.DEFAULT);

    public static final ConfiguredFeature<TreeFeatureConfig, ?> DATE_TREE = Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ArsBlocks.DATE_TREE_LOG.getDefaultState()), new SimpleBlockStateProvider(ArsBlocks.DATE_LEAVES.getDefaultState()), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new ForkingTrunkPlacer(5, 2, 2), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build());

    public static void registerAll() {

        registerRuin(CONFIGURED_HOUSE_FEATURE, HOUSE_RUIN, HOUSE_FEATURE, ArsUtils.getIdentifier("house"), 961930557);
        registerRuin(CONFIGURED_DATE_RUIN, DATE_RUIN, DATE_RUIN_FEATURE,ArsUtils.getIdentifier("date_ruin"), 1331434842);
        registerRuin(CONFIGURED_FRAGMENTED_RUIN, FRAGMENTED_RUIN, FRAGMENTED_RUIN_FEATURE,ArsUtils.getIdentifier("fragmented_ruin"), 550983542);
        registerRuin(CONFIGURED_ONE_FLOOR_RUIN, ONE_FLOOR_RUIN, ONE_FLOOR_RUIN_FEATURE,ArsUtils.getIdentifier("one_floor_ruin"), 420429610);
        registerRuin(CONFIGURED_TABLE_RUIN, TABLE_RUIN, TABLE_RUIN_FEATURE,ArsUtils.getIdentifier("table_ruin"), 1553391102);
        registerRuin(CONFIGURED_TWO_FLOOR_RUIN, TWO_FLOOR_RUIN, TWO_FLOOR_RUIN_FEATURE,ArsUtils.getIdentifier("two_floor_ruin"), 1481440594);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, ArsUtils.getIdentifier("date_tree"), DATE_TREE);
    }

    private static void registerRuin(ConfiguredStructureFeature<?, ?> CONFIGURED_FEATURE, StructurePieceType PIECE, StructureFeature<DefaultFeatureConfig> FEATURE, Identifier name, int salt) {
        StructureList.put(name, PIECE);

        Registry.register(Registry.STRUCTURE_PIECE, name, PIECE);
        FabricStructureBuilder.create(name, FEATURE)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(32, 8, salt)
                .adjustsSurface()
                .register();
        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, name,
                CONFIGURED_FEATURE);
    }
}
