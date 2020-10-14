package team.comofas.arstheurgia.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import team.comofas.arstheurgia.blocks.*;
import team.comofas.arstheurgia.blocks.ceramicaltar.CeramicAltarBlock;
import team.comofas.arstheurgia.blocks.ceramicaltar.CeramicAltarBlockEntity;
import team.comofas.arstheurgia.blocks.ritualblocktest.RitualBlock;
import team.comofas.arstheurgia.ArsUtils;
import team.comofas.arstheurgia.blocks.table.TableBlock;
import team.comofas.arstheurgia.blocks.table.TableBlockEntity;


public class ArsBlocks {

    private static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    public static final Block RITUALCENTER = new RitualBlock(FabricBlockSettings.of(Material.METAL).hardness(4.0f));
    public static final Block ASYRIEL_SIGIL = new ChalkBlock(FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static final Block SPRING_SYMBOL = new ChalkBlock(FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static final Block SUMMER_SYMBOL = new ChalkBlock(FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static final Block AUTUMN_SYMBOL = new ChalkBlock(FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static final Block WINTER_SYMBOL = new ChalkBlock(FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static final Block VELINHA = new CandleBlock(FabricBlockSettings.of(Material.METAL).breakInstantly().luminance((state) -> {
        return 12;
    }).sounds(BlockSoundGroup.WOOD), ParticleTypes.FLAME);
    public static final Block FLOUR = new FlourBlock(FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static final Block PAZUZU_FIGURINE = new FlourBlock(FabricBlockSettings.of(Material.METAL).hardness(1.0f));

    public static final Block SMOOTH_MUD_BLOCK_STAIRS = new ATStairsBlock(Blocks.ACACIA_PLANKS.getDefaultState(),FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static final Block MUD_BLOCK_BRICKS_STAIRS = new ATStairsBlock(Blocks.ACACIA_PLANKS.getDefaultState(),FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static final Block MUD_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static final Block SMOOTH_MUD_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static final Block MUD_BLOCK_BRICKS = new Block(FabricBlockSettings.of(Material.METAL).hardness(1.0f));

    public static final Block TABLE = new TableBlock(FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static final Block CERAMIC_ALTAR = new CeramicAltarBlock(FabricBlockSettings.of(Material.METAL).hardness(1.0f));

    public static final Block MUD_BLOCK_BRICKS_SLAB = new SlabBlock(AbstractBlock.Settings.of(Material.STONE, MaterialColor.STONE).requiresTool().strength(2.0F, 6.0F));
    public static final Block MUD_BLOCK_RAW = new FallingArcheologicalBlock(FabricBlockSettings.of(Material.SOIL).hardness(1.0f));

    public static final Block DATE_TREE_LOG = new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block DATE_LEAVES = new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque().suffocates(ArsBlocks::never).blockVision(ArsBlocks::never));



    public static BlockEntityType<RitualBlockEntity> RITUALBLOCK_ENTITY;
    public static BlockEntityType<CeramicAltarBlockEntity> CERAMIC_ALTAR_ENTITY;

    public static BlockEntityType<TableBlockEntity> TABLE_BLOCK_ENTITY;

    public static void registerAll() {
        registerBlock(ASYRIEL_SIGIL, "asyriel_sigil_chalk");
        registerBlock(SPRING_SYMBOL, "spring_symbol_chalk");
        registerBlock(SUMMER_SYMBOL, "summer_symbol_chalk");
        registerBlock(AUTUMN_SYMBOL, "autumn_symbol_chalk");
        registerBlock(WINTER_SYMBOL, "winter_symbol_chalk");
        registerBlock(PAZUZU_FIGURINE, "pazuzu_figurine");
        registerBlock(RITUALCENTER, "ritual_block");
        registerBlock(VELINHA, "velinha");
        registerBlock(FLOUR, "flour");

        registerBlock(TABLE, "table");
        registerBlock(CERAMIC_ALTAR, "ceramic_altar");

        registerBlock(SMOOTH_MUD_BLOCK_STAIRS, "smooth_mud_block_stairs");
        registerBlock(MUD_BLOCK_BRICKS_STAIRS, "mud_block_bricks_stairs");
        registerBlock(MUD_BLOCK, "mud_block");
        registerBlock(SMOOTH_MUD_BLOCK, "smooth_mud_block");
        registerBlock(MUD_BLOCK_BRICKS, "mud_block_bricks");
        registerBlock(MUD_BLOCK_BRICKS_SLAB, "mud_block_bricks_slab");
        registerBlock(MUD_BLOCK_RAW, "mud_block_raw");

        registerBlock(DATE_TREE_LOG, "date_tree_log");
        registerBlock(DATE_LEAVES, "date_leaves");

        RITUALBLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, ArsUtils.getIdentifier("ritualblock"), BlockEntityType.Builder.create(RitualBlockEntity::new, RITUALCENTER).build(null));
        CERAMIC_ALTAR_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, ArsUtils.getIdentifier("ceramic_altar"), BlockEntityType.Builder.create(CeramicAltarBlockEntity::new, CERAMIC_ALTAR).build(null));
        TABLE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, ArsUtils.getIdentifier("table"), BlockEntityType.Builder.create(TableBlockEntity::new, TABLE).build(null));

    }
    public static Block registerBlock(Block block, String name) {
        return Registry.register(Registry.BLOCK, ArsUtils.getIdentifier(name), block);
    }

}