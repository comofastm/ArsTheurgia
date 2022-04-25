package team.comofas.arstheurgia.items;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import team.comofas.arstheurgia.registry.ArsItems;

import java.util.List;

public class WaterskinItem extends Item {
    public WaterskinItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack itemStack = user.getStackInHand(hand);

        BlockHitResult hitResult = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);
        if (hitResult.getType() != HitResult.Type.MISS) {
            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos blockPos = hitResult.getBlockPos();
                if (!world.canPlayerModifyAt(user, blockPos)) {
                    return TypedActionResult.pass(itemStack);
                }

                if (world.getFluidState(blockPos).isIn(FluidTags.WATER)) {
                    world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                    return TypedActionResult.success(this.fill(user, itemStack, new ItemStack(ArsItems.WATERSKIN_FILLED)), world.isClient());
                }
            }

        }
        return TypedActionResult.pass(itemStack);
    }

    public ItemStack fill(PlayerEntity playerEntity, ItemStack itemToFill, ItemStack filledItem) {
        boolean isCreative = playerEntity.getAbilities().creativeMode;
        if (isCreative) {
            if (!playerEntity.getInventory().contains(filledItem)) {
                playerEntity.getInventory().insertStack(filledItem);
            }

            return itemToFill;
        } else {
            itemToFill.decrement(1);

            if (itemToFill.isEmpty()) {
                return filledItem;
            } else {
                if (!playerEntity.getInventory().insertStack(filledItem)) {
                    playerEntity.dropItem(filledItem, false);
                }

                return itemToFill;
            }
        }
    }

}
