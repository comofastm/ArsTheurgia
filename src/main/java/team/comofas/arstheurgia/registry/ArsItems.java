package team.comofas.arstheurgia.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;
import team.comofas.arstheurgia.ArsUtils;
import team.comofas.arstheurgia.ritual.rituals.CreeperSummon;

public class ArsItems {

    public static final Item CLAY_TABLET = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item RITUAL_CENTER_ITEM = new BlockItem(ArsBlocks.RITUALCENTER, new FabricItemSettings().group(ItemGroup.MISC));

    public static void registerAll() {
        registerItem(CLAY_TABLET, "clay_tablet");
        registerItem(RITUAL_CENTER_ITEM,"ritual_block");
        CreeperSummon.INSTANCE.registerItems("creeper");
    }

    public static Item registerItem(Item item, String name) {
        return Registry.register(Registry.ITEM, ArsUtils.getIdentifier(name), item);
    }
}
