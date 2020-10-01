package team.comofas.arstheurgia;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import team.comofas.arstheurgia.registry.ArsBlocks;

public class ArsUtils {

    public static Identifier getIdentifier(String name) {
        return new Identifier("arstheurgia", name);
    }

}
