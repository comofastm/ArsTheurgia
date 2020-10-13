package team.comofas.arstheurgia.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.comofas.arstheurgia.player.PlayerComponents;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Inject(method = "attack", at = @At("HEAD"))
    public void attack(Entity target, CallbackInfo ci) {
        LivingEntity livingtarget = (LivingEntity) target;
        if (target.isAttackable()) {
            if (PlayerComponents.KNOWLEDGE.get(this).hasKnowledge("activeUdug")) {
                livingtarget.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 900, 3, true, true));
            }
        }
    }
}
