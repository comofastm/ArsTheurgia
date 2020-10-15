package team.comofas.arstheurgia.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;
import team.comofas.arstheurgia.player.PlayerComponents;
import team.comofas.arstheurgia.registry.ArsSounds;

public class LamassuEntity extends TameableEntity implements IAnimatedEntity {

    private final EntityAnimationManager manager;
    private final EntityAnimationController controller;


    private <E extends Entity> boolean animationPredicate(AnimationTestEvent<E> event) {
        if (event.isWalking() || !event.getEntity().isOnGround()) {
            this.controller.setAnimation(new AnimationBuilder().addAnimation("moving", true));
            return true;
        } else {
            return false;
        }
    }

    public LamassuEntity(EntityType<LamassuEntity> entityType, World world) {
        super(entityType, world);
        this.setTamed(true);
        this.manager = new EntityAnimationManager();
        this.controller = new EntityAnimationController(this, "walkController", 20, this::animationPredicate);
        this.manager.addAnimationController(controller);
    }

    public EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(ArsSounds.LAMASSU_WINGFLAP, 0.15F, 1.0F);
    }


    public void tickMovement() {
        super.tickMovement();
        this.fallDistance = 0.0F;
        Vec3d vec3d = this.getVelocity();
        if (!this.onGround && vec3d.y < 0.0D) {
            this.setVelocity(vec3d.multiply(1.0D, 0.6D, 1.0D));
        }
    }

    public boolean tryAttack(Entity target) {
        boolean bl = target.damage(DamageSource.mob(this), 3);
        if (bl) {
            this.dealDamage(this, target);
        }
        return bl;
    }

    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new SitGoal(this));
        this.goalSelector.add(3, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(4, new FollowOwnerGoal(this, 0.6D, 10.0F, 2.0F, false));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        this.setSitting(!this.isSitting());
        return ActionResult.SUCCESS;
    }

    public boolean canAttackWithOwner(LivingEntity target, LivingEntity owner) {
        return true;
    }


    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }


    @Override
    public EntityAnimationManager getAnimationManager() {
        return this.manager;
    }
}
