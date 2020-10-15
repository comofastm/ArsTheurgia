package team.comofas.arstheurgia.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;
import team.comofas.arstheurgia.ArsUtils;
import team.comofas.arstheurgia.items.*;
import team.comofas.arstheurgia.ritual.rituals.*;

public class ArsItems {

    public static final Item CLAY_TABLET = new Item(new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item DICTIONARY = new Item(new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item RITUAL_CENTER_ITEM = new BlockItem(ArsBlocks.RITUALCENTER, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));

    public static final Item SMOOTH_MUD_BLOCK_STAIRS = new BlockItem(ArsBlocks.SMOOTH_MUD_BLOCK_STAIRS, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item MUD_BLOCK_BRICKS_STAIRS = new BlockItem(ArsBlocks.MUD_BLOCK_BRICKS_STAIRS, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item MUD_BLOCK = new BlockItem(ArsBlocks.MUD_BLOCK, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item SMOOTH_MUD_BLOCK = new BlockItem(ArsBlocks.SMOOTH_MUD_BLOCK, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item SMOOTH_MUD_BLOCK_SLAB = new BlockItem(ArsBlocks.SMOOTH_MUD_BLOCK_SLAB, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item MUD_BLOCK_BRICKS = new BlockItem(ArsBlocks.MUD_BLOCK_BRICKS, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item MUD_BLOCK_BRICKS_SLAB = new BlockItem(ArsBlocks.MUD_BLOCK_BRICKS_SLAB, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item MUD_BLOCK_RAW = new BlockItem(ArsBlocks.MUD_BLOCK_RAW, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));

    public static final Item TABLE = new BlockItem(ArsBlocks.TABLE, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item CERAMIC_ALTAR = new BlockItem(ArsBlocks.CERAMIC_ALTAR, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));

    public static final ChalkItem CHALK_ITEM = new ChalkItem(new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP).maxDamage(70));

    public static final Item GEBEL_KNIFE = new SwordItem(ToolMaterials.STONE, 3, -2.4F, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP).maxDamage(59));
    public static final Item MACE = new SwordItem(ToolMaterials.IRON, 9, -3.2F, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP).maxDamage(59));
    public static final Item TROWEL = new SpadeItem(ToolMaterials.IRON, 3, -2.4F, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP).maxDamage(250));
    public static final Item FLOUR = new BlockItem(ArsBlocks.FLOUR, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item BILE = new BileBottleItem(new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP).recipeRemainder(Items.GLASS_BOTTLE));

    public static final Item SHARUR = new SharurItem(new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP).maxDamage(59));
    public static final Item IMHULLU = new ImhulluItem(new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP).maxDamage(59));
    public static final Item DATES = new Item(new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP).food(FoodComponents.APPLE));

    public static final Item PAZUZU_FIGURINE = new BlockItem(ArsBlocks.PAZUZU_FIGURINE, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item PAZUZU_AMULET = new ArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.CHEST, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));

    public static final Item WATERSKIN = new WaterskinItem(new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item WATERSKIN_FILLED = new FilledWaterskinItem(new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));

    public static final Item SAMAS_FIGURINE = new BlockItem(ArsBlocks.SAMAS_FIGURINE, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item MIRSU_BOWL = new BlockItem(ArsBlocks.MIRSU_BOWL, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));

    public static final Item DATE_TREE_LOG = new BlockItem(ArsBlocks.DATE_TREE_LOG, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item DATE_LEAVES = new BlockItem(ArsBlocks.DATE_LEAVES, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));


    public static void registerAll() {
        registerItem(CLAY_TABLET, "clay_tablet");
        registerItem(DICTIONARY, "dictionary");
        registerItem(RITUAL_CENTER_ITEM,"ritual_block");

        registerItem(CHALK_ITEM, "chalk");
        registerItem(GEBEL_KNIFE, "gebel_knife");
        registerItem(TROWEL, "trowel");

        registerItem(FLOUR, "flour");
        registerItem(BILE, "bile");

        registerItem(TABLE, "table");
        registerItem(CERAMIC_ALTAR, "ceramic_altar");

        registerItem(PAZUZU_FIGURINE, "pazuzu_figurine");
        registerItem(PAZUZU_AMULET, "pazuzu_amulet");

        registerItem(SMOOTH_MUD_BLOCK_STAIRS, "smooth_mud_block_stairs");
        registerItem(MUD_BLOCK_BRICKS_STAIRS, "mud_block_bricks_stairs");
        registerItem(MUD_BLOCK, "mud_block");
        registerItem(SMOOTH_MUD_BLOCK, "smooth_mud_block");
        registerItem(SMOOTH_MUD_BLOCK_SLAB, "smooth_mud_block_slab");
        registerItem(MUD_BLOCK_BRICKS, "mud_block_bricks");
        registerItem(MUD_BLOCK_BRICKS_SLAB, "mud_block_bricks_slab");
        registerItem(MUD_BLOCK_RAW, "mud_block_raw");

        registerItem(MACE, "mace");
        registerItem(SHARUR, "sharur");
        registerItem(IMHULLU, "imhullu");

        registerItem(DATES, "dates");

        registerItem(WATERSKIN, "waterskin");
        registerItem(WATERSKIN_FILLED, "filled_waterskin");

        registerItem(SAMAS_FIGURINE, "shamash");
        registerItem(MIRSU_BOWL, "mirsu_bowl");
        
        CreeperSummon.INSTANCE.registerItems();
        PazuzuBlessing.INSTANCE.registerItems();
        SamasPurification.INSTANCE.registerItems();
        UdugSummon.INSTANCE.registerItems();
        SharurRitual.INSTANCE.registerItems();


    }

    public static Item registerItem(Item item, String name) {
        return Registry.register(Registry.ITEM, ArsUtils.getIdentifier(name), item);
    }
}
