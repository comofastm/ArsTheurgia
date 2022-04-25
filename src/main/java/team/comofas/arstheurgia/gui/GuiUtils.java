package team.comofas.arstheurgia.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;

public class GuiUtils {

    public static void openTabletScreen(ItemStack itemStack) {
        MinecraftClient.getInstance().setScreen(new OpenTabletScreen(itemStack));
    }

}
