package team.comofas.arstheurgia.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;
import team.comofas.arstheurgia.registry.ArsSounds;

public class TormentedCreeperEntity extends HostileEntity implements IAnimatedEntity {
    private final EntityAnimationManager manager;
    private final EntityAnimationController controller;

    private <E extends Entity> boolean animationPredicate(AnimationTestEvent<E> event) {
        if (this.isAttacking()) {
            System.out.println("o jogo");
            this.controller.setAnimation(new AnimationBuilder().addAnimation("attack", true));
            return true;
        } else {
            if (event.isWalking()) {
                this.controller.setAnimation(new AnimationBuilder().addAnimation("walk", true));
                return true;
            } else {
                this.controller.setAnimation(new AnimationBuilder().addAnimation("idle", true));
                return true;
            }
        }
    }

    protected void initGoals() {
        this.targetSelector.add(1, new FollowTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new FollowTargetGoal(this, IronGolemEntity.class, true));
        this.goalSelector.add(3, new MeleeAttackGoal(this, 1D, false));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.8D));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));

    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D).add(EntityAttributes.GENERIC_MAX_HEALTH, 200).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7425);
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(ArsSounds.UDUG_WALKING, 0.15F, 1.0F);
    }

    protected SoundEvent getAmbientSound() {
        if (this.random.nextInt(3) == 0) {
            return ArsSounds.UDUG_AMBIENT;
        } else {
            return null;
        }
    }

    protected SoundEvent getDeathSound() {
        return ArsSounds.UDUG_DISAPPEAR;
    }

    public boolean tryAttack(Entity target) {
        boolean bl = target.damage(DamageSource.mob(this), 3);
        if (bl) {
            this.dealDamage(this, target);
        }
        return bl;
    }

    public TormentedCreeperEntity(EntityType<TormentedCreeperEntity> entityType, World world) {
        super(entityType, world);
        this.manager = new EntityAnimationManager();
        this.controller = new EntityAnimationController(this, "walkController", 20, this::animationPredicate);
        this.manager.addAnimationController(controller);
    }

    @Override
    public EntityAnimationManager getAnimationManager() {
        return this.manager;
    }
}
