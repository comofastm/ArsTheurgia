package team.comofas.arstheurgia.items;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import team.comofas.arstheurgia.gui.OpenTabletScreen;

public class OpenableTablet extends Item {
    public OpenableTablet(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (user instanceof ClientPlayerEntity) {
            MinecraftClient.getInstance().openScreen(new OpenTabletScreen());
        }

        return TypedActionResult.method_29237(itemStack, world.isClient());

    }
}

