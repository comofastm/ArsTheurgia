package team.comofas.arstheurgia.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.EntityTrackingSoundInstance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.comofas.arstheurgia.player.PlayerComponents;
import team.comofas.arstheurgia.registry.ArsItems;
import team.comofas.arstheurgia.registry.ArsSounds;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Shadow private ItemStack selectedItem;

    @Inject(method = "attack", at = @At("HEAD"))
    public void attack(Entity target, CallbackInfo ci) {
        LivingEntity livingtarget = (LivingEntity) target;
        Entity entity = (Entity)(Object)this;
        if (target.isAttackable()) {
            if (PlayerComponents.KNOWLEDGE.get(this).hasKnowledge("activeUdug")) {
                entity.getEntityWorld().playSound(null, entity.getBlockPos(), ArsSounds.CLAWS_ATTACK, SoundCategory.PLAYERS, 1f, 1f);
                livingtarget.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 900, 3, true, true));
            }
        }
    }
    @Inject(method = "tickMovement", at = @At("HEAD"))
    public void tickMovement(CallbackInfo ci) {
        Entity entity = (Entity)(Object)this;
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (this.selectedItem.getItem() == ArsItems.SHARUR) {
            Vec3d vec3d = entity.getVelocity();
            entity.fallDistance = 0.0F;
            if (!(PlayerComponents.KNOWLEDGE.get(player).hasKnowledge("holdingSharur"))) {
                entity.setVelocity(vec3d.multiply(1.0D, 0D, 1.0D));
                PlayerComponents.KNOWLEDGE.get(player).setKnowledge("holdingSharur", true);
            }
            if (!entity.isOnGround() && vec3d.y < 0) {
                entity.setVelocity(vec3d.multiply(1.0D, 0.6D, 1.0D));
            }
            } else {
            if (PlayerComponents.KNOWLEDGE.get(player).hasKnowledge("holdingSharur")) { PlayerComponents.KNOWLEDGE.get(player).setKnowledge("holdingSharur", false); }
        }
    }
}
