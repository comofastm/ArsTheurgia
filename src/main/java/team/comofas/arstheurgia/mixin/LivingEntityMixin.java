package team.comofas.arstheurgia.mixin;

import net.minecraft.entity.Entity;
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
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
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

            Item item = attacker.getStackInHand(Hand.MAIN_HAND).getItem();

            if (!((LivingEntity)(Object)this).world.isClient()) {
                if (item == ArsItems.GEBEL_KNIFE && ((LivingEntity)(Object)this) instanceof AnimalEntity) {
                    ItemStack bottle = new ItemStack(Items.GLASS_BOTTLE);
                    if (attacker.getInventory().contains(bottle)) {
                        for (ItemStack itemStack : attacker.getInventory().main) {
                            if (itemStack.getItem() == Items.GLASS_BOTTLE) {
                                itemStack.decrement(1);
                                ((LivingEntity)(Object)this).world.playSound(attacker, attacker.getX(), attacker.getY(), attacker.getZ(), ArsSounds.COLLECT_BILE, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                                attacker.getInventory().insertStack(new ItemStack(ArsItems.BILE));
                                break;
                            }

                        }
                    }
                }
            }


        }
    }

    @Inject(method = "onDeath", at = @At("HEAD"))
    public void getBabyKill(DamageSource source, CallbackInfo ci) {

        LivingEntity livingEntity = (LivingEntity)(Object)this;

        if (source.getAttacker() instanceof PlayerEntity) {

            if (livingEntity.isBaby() && livingEntity instanceof AnimalEntity) {
                PlayerEntity player = (PlayerEntity)source.getAttacker();

                PlayerComponents.RITUALTIME.get(player).setIntTime("killBaby");
            }

        }
    }

    @Inject(method = "tickStatusEffects", at = @At("TAIL"))
    public void applyBlessingAtNight(CallbackInfo ci) {

        if ((Entity)(Object)this instanceof PlayerEntity) {

            LivingEntity livingEntity = (LivingEntity)(Object)this;

            World world = livingEntity.world;

            PlayerEntity playerEntity = (PlayerEntity) livingEntity;

            if (PlayerComponents.ACTIVE_BLESSING.get(playerEntity).hasBlessing()) {

                if (!world.isDay()) {
                    if (world.getTimeOfDay() % 60 == 0) {
                        StatusEffectInstance pazuzuEffectInstance = new StatusEffectInstance(ArsEffects.PAZUZU_BLESSING, 60, 0, true, false);
                        playerEntity.addStatusEffect(pazuzuEffectInstance);

                    }


                } else {
                    PlayerComponents.ACTIVE_BLESSING.get(playerEntity).setBlessing(false);
                    PlayerComponents.KNOWLEDGE.maybeGet(playerEntity).ifPresent(value -> value.setKnowledge("activeUdug", false));
                }
            } else if (PlayerComponents.KNOWLEDGE.get(playerEntity).hasKnowledge("lamashtuBlessing")) {
                if (!world.isDay()) {
                    if (world.getTimeOfDay() % 60 == 0) {
                        StatusEffectInstance lamashtuEffectInstance = new StatusEffectInstance(ArsEffects.LAMASHTU_BLESSING, 60, 0, true, false);
                        playerEntity.addStatusEffect(lamashtuEffectInstance);

                    }

                } else {
                    PlayerComponents.KNOWLEDGE.get(playerEntity).setKnowledge("lamashtuBlessing", false);
                }
            }

        }



    }


}
