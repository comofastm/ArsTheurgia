package team.comofas.arstheurgia.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import team.comofas.arstheurgia.player.PlayerComponents;

public class SharurItem extends Item {
    public SharurItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            if (user.isSneaking()) {
                double x = user.getRotationVector().x;
                double y = user.getRotationVector().y;
                double z = user.getRotationVector().z;
                user.addVelocity(1 * x, 1 * y, 1 * z);
                return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
            } else if (!user.isOnGround()) {
                if (PlayerComponents.KNOWLEDGE.get(user).hasKnowledge("isFalling")) {
                    PlayerComponents.KNOWLEDGE.get(user).setKnowledge("isFalling", false);
                } else {
                    PlayerComponents.KNOWLEDGE.get(user).setKnowledge("isFalling", true);
                }
                return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
            } else {
                return new TypedActionResult<>(ActionResult.FAIL, user.getStackInHand(hand));
            }
        } else {
            return new TypedActionResult<>(ActionResult.FAIL, user.getStackInHand(hand));
        }
    }
}
