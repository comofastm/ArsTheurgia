package team.comofas.arstheurgia.mixin;

import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.comofas.arstheurgia.effects.ATEffect;
import team.comofas.arstheurgia.player.PlayerComponents;
import team.comofas.arstheurgia.registry.ArsEffects;
import team.comofas.arstheurgia.registry.ArsItems;
import team.comofas.arstheurgia.registry.ArsSounds;
import team.comofas.arstheurgia.ritual.rituals.PazuzuBlessing;

import java.util.Iterator;
import java.util.Map;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow @Final private Map<StatusEffect, StatusEffectInstance> activeStatusEffects;

    @Shadow protected abstract void onStatusEffectRemoved(StatusEffectInstance effect);

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
                        ((LivingEntity)(Object)this).world.playSound(attacker, attacker.getX(), attacker.getY(), attacker.getZ(), ArsSounds.COLLECT_BILE, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                        attacker.inventory.insertStack(new ItemStack(ArsItems.BILE));
                    }
                }
            }


        }
    }

    @Inject(method = "tickStatusEffects", at = @At("TAIL"))
    public void removeBlessingAtNight(CallbackInfo ci) {

        LivingEntity livingEntity = (LivingEntity)(Object)this;

        World world = livingEntity.world;

        if (livingEntity instanceof PlayerEntity) {

            PlayerEntity playerEntity = (PlayerEntity) livingEntity;

            if (PlayerComponents.ACTIVE_BLESSING.get(playerEntity).hasBlessing()) {

                if (!world.isDay()) {
                    if (world.getTimeOfDay() % 60 == 0) {
                        StatusEffectInstance pazuzuEffectInstance = new StatusEffectInstance(ArsEffects.PAZUZU_BLESSING, 60, 0, true, false);
                        playerEntity.addStatusEffect(pazuzuEffectInstance);
                    }


                } else {
                    PlayerComponents.ACTIVE_BLESSING.get(playerEntity).setBlessing(false);
                }
            }

        }



    }


}
