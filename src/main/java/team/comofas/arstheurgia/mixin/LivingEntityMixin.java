package team.comofas.arstheurgia.mixin;

import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.comofas.arstheurgia.registry.ArsItems;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "dropLoot", at = @At("HEAD"))
    public void dropBile(DamageSource source, boolean causedByPlayer, CallbackInfo ci) {
        if (source.getAttacker() instanceof PlayerEntity) {
            PlayerEntity attacker = (PlayerEntity) source.getAttacker();
            Item item = attacker.inventory.getMainHandStack().getItem();

            if (!((LivingEntity)(Object)this).world.isClient()) {
                if (item == ArsItems.GEBEL_KNIFE && ((LivingEntity)(Object)this) instanceof AnimalEntity) {
                    ItemStack bottle = new ItemStack(Items.GLASS_BOTTLE);
                    if (attacker.inventory.contains(bottle)) {
                        attacker.inventory.getStack(attacker.inventory.getSlotWithStack(bottle)).decrement(1);

                        attacker.inventory.insertStack(new ItemStack(ArsItems.BILE));
                    }
                }
            }


        }
    }

}
