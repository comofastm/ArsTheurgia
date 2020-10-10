package team.comofas.arstheurgia.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import team.comofas.arstheurgia.ArsUtils;

public class ArsItemGroup {
    public static ItemGroup ARS_ITEM_GROUP = FabricItemGroupBuilder.build(
            ArsUtils.getIdentifier("items"),
            () -> new ItemStack(ArsItems.GEBEL_KNIFE));
}
