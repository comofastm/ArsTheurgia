package team.comofas.arstheurgia.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.util.registry.Registry;
import team.comofas.arstheurgia.ArsUtils;
import team.comofas.arstheurgia.items.BileBottleItem;
import team.comofas.arstheurgia.items.ChalkItem;
import team.comofas.arstheurgia.ritual.rituals.CreeperSummon;

public class ArsItems {


    public static final Item CLAY_TABLET = new Item(new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item DICTIONARY = new Item(new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item RITUAL_CENTER_ITEM = new BlockItem(ArsBlocks.RITUALCENTER, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));

    public static final Item SMOOTH_MUD_BLOCK_STAIRS = new BlockItem(ArsBlocks.SMOOTH_MUD_BLOCK_STAIRS, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item MUD_BLOCK_BRICKS_STAIRS = new BlockItem(ArsBlocks.MUD_BLOCK_BRICKS_STAIRS, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item MUD_BLOCK = new BlockItem(ArsBlocks.MUD_BLOCK, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item SMOOTH_MUD_BLOCK = new BlockItem(ArsBlocks.SMOOTH_MUD_BLOCK, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item MUD_BLOCK_BRICKS = new BlockItem(ArsBlocks.MUD_BLOCK_BRICKS, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));

    public static final ChalkItem CHALK_ITEM = new ChalkItem(new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP).maxDamage(70));

    public static final Item GEBEL_KNIFE = new SwordItem(ToolMaterials.STONE, 3, -2.4F, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item FLOUR = new BlockItem(ArsBlocks.FLOUR, new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP));
    public static final Item BILE = new BileBottleItem(new FabricItemSettings().group(ArsItemGroup.ARS_ITEM_GROUP).recipeRemainder(Items.GLASS_BOTTLE));



    public static void registerAll() {



        registerItem(CLAY_TABLET, "clay_tablet");
        registerItem(DICTIONARY, "dictionary");
        registerItem(RITUAL_CENTER_ITEM,"ritual_block");
        registerItem(CHALK_ITEM, "chalk");
        registerItem(GEBEL_KNIFE, "gebel_knife");
        registerItem(FLOUR, "flour");
        registerItem(BILE, "bile");

        registerItem(SMOOTH_MUD_BLOCK_STAIRS, "smooth_mud_block_stairs");
        registerItem(MUD_BLOCK_BRICKS_STAIRS, "mud_block_bricks_stairs");
        registerItem(MUD_BLOCK, "mud_block");
        registerItem(SMOOTH_MUD_BLOCK, "smooth_mud_block");
        registerItem(MUD_BLOCK_BRICKS, "mud_block_bricks");
        
        CreeperSummon.INSTANCE.registerItems();



    }

    public static Item registerItem(Item item, String name) {
        return Registry.register(Registry.ITEM, ArsUtils.getIdentifier(name), item);
    }
}
