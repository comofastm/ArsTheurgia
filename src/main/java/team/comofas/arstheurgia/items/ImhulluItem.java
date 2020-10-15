package team.comofas.arstheurgia.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import team.comofas.arstheurgia.player.PlayerComponents;
import team.comofas.arstheurgia.registry.ArsSounds;

import java.util.Iterator;
import java.util.List;

public class ImhulluItem extends Item {
    public ImhulluItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            if (world.getTime()- PlayerComponents.RITUALTIME.get(user).getInt("imhulluCooldown") >= 100) {
                ServerWorld server = (ServerWorld) world;
                PlayerComponents.RITUALTIME.get(user).setIntTime("imhulluCooldown");
                Box box = new Box(
                        user.getX() - 10,
                        user.getY(),
                        user.getZ() - 10,

                        user.getX() + 10,
                        user.getY() + 10,
                        user.getZ() + 10
                );
                List<LivingEntity> list = server.getEntitiesByClass(LivingEntity.class, box, (entity) -> entity != null && entity.isAlive());
                list.stream().filter(entity -> user.distanceTo(entity) <= 5);
                Iterator iterator = list.iterator();
                double x = user.getRotationVector().x;
                double y = user.getRotationVector().y;
                double z = user.getRotationVector().z;
                user.getEntityWorld().playSound(null, user.getBlockPos(), ArsSounds.IMHULLU_WIND, SoundCategory.PLAYERS, 1f, 1f);
                while (iterator.hasNext()) {
                    Entity entity = (Entity) iterator.next();
                    entity.addVelocity(x*0.3, 1+y, z*0.3
                    );
                }
                return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
            } else {
                user.getEntityWorld().playSound(null, user.getBlockPos(), ArsSounds.RITUAL_FAIL, SoundCategory.PLAYERS, 1f, 1f);
                return new TypedActionResult<>(ActionResult.FAIL, user.getStackInHand(hand));
            }
        } else {
            return new TypedActionResult<>(ActionResult.FAIL, user.getStackInHand(hand));
        }
    }
}