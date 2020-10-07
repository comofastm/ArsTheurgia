package team.comofas.arstheurgia.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import team.comofas.arstheurgia.gui.GuiUtils;

public class OpenableTablet extends Item {

    public String ritualName;

    public OpenableTablet(Settings settings, String ritualName) {
        super(settings);
        this.ritualName = ritualName;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (world.isClient) {
            GuiUtils.openTabletScreen(itemStack);
        }

        return TypedActionResult.method_29237(itemStack, world.isClient());

    }
}

