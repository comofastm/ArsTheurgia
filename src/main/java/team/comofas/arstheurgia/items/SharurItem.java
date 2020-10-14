package team.comofas.arstheurgia.items;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.AmbientSoundPlayer;
import net.minecraft.client.sound.EntityTrackingSoundInstance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import team.comofas.arstheurgia.player.PlayerComponents;
import team.comofas.arstheurgia.registry.ArsSounds;

public class SharurItem extends Item {
    public SharurItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient()) {
            double x = user.getRotationVector().x;
            double y = user.getRotationVector().y;
            double z = user.getRotationVector().z;
            user.addVelocity(1 * x, 1 * y, 1 * z);
            user.getEntityWorld().playSound(null, user.getBlockPos(), ArsSounds.MACE_PULL, SoundCategory.PLAYERS, 1f, 1f);
            return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
        } else {
            return new TypedActionResult<>(ActionResult.FAIL, user.getStackInHand(hand));
        }
    }
}
