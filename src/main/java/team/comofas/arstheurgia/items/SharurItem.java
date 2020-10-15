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
        if (world.getTime()-PlayerComponents.RITUALTIME.get(user).getInt("lastSharur") >= 100) {
            int sharurCount = PlayerComponents.RITUALTIME.get(user).getInt("usedSharur");
            if ((sharurCount)<8) {
                PlayerComponents.RITUALTIME.get(user).setInt("usedSharur", sharurCount+1);
                user.getEntityWorld().playSound(null, user.getBlockPos(), ArsSounds.MACE_PULL, SoundCategory.PLAYERS, 1f, 1f);
                if (world.isClient()) {
                    double x = user.getRotationVector().x;
                    double y = user.getRotationVector().y;
                    double z = user.getRotationVector().z;
                    user.addVelocity(1 * x, 1 * y, 1 * z);
                    return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
                }
            } else {
                PlayerComponents.RITUALTIME.get(user).setIntTime("lastSharur");
                user.getEntityWorld().playSound(null, user.getBlockPos(), ArsSounds.RITUAL_FAIL, SoundCategory.PLAYERS, 1f, 1f);
            }
        } else {
            PlayerComponents.RITUALTIME.get(user).setInt("usedSharur", 0);
            user.getEntityWorld().playSound(null, user.getBlockPos(), ArsSounds.RITUAL_FAIL, SoundCategory.PLAYERS, 1f, 1f);
        }
        return new TypedActionResult<>(ActionResult.FAIL, user.getStackInHand(hand));
    }
}
