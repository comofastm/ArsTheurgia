package team.comofas.arstheurgia.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import team.comofas.arstheurgia.blocks.RitualBlock;
import team.comofas.arstheurgia.ArsUtils;


public class ArsBlocks {

    public static final Block RITUALCENTER = new RitualBlock(FabricBlockSettings.of(Material.METAL).hardness(4.0f));

    public static void registerAll() {
        registerBlock(RITUALCENTER, "ritual_block");
    }
    public static Block registerBlock(Block block, String name) {
        return Registry.register(Registry.BLOCK, ArsUtils.getIdentifier(name), block);
    }
}