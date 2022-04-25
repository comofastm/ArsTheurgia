package team.comofas.arstheurgia.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Fertilizable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import team.comofas.arstheurgia.player.PlayerComponents;
import team.comofas.arstheurgia.registry.ArsSounds;

public class AnzuEntity extends TameableEntity implements IAnimatable {

    private long cooldown = 100;
    private final AnimationFactory animationFactory;

    private <E extends IAnimatable> PlayState animationPredicate(AnimationEvent<E> event) {
        if (event.isMoving() || !((Entity)event.getAnimatable()).isOnGround()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("moving", true));
        } else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        }
        return PlayState.CONTINUE;
    }

    public AnzuEntity(EntityType<AnzuEntity> entityType, World world) {
        super(entityType, world);
        this.setTamed(true);
        this.animationFactory = new AnimationFactory(this);

    }

    public EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
    }

    public void baseTick() {
        super.baseTick();
        BlockPos pos = new BlockPos.Mutable(this.getX(), this.getY(), this.getZ());
        BlockState blockState = world.getBlockState(pos);


        if (blockState.getBlock() instanceof Fertilizable) {
            int dry = PlayerComponents.DRY.get(this).getDry();
            if (dry > 0) {
                Fertilizable fertilizable = (Fertilizable) blockState.getBlock();
                if (fertilizable.isFertilizable(world, pos, blockState, world.isClient)) {
                    if (world instanceof ServerWorld) {
                        if (fertilizable.canGrow(world, world.random, pos, blockState)) {
                            this.getEntityWorld().playSound(null, this.getBlockPos(), ArsSounds.RITUAL_FAIL, SoundCategory.PLAYERS, 1f, 1f);
                            PlayerComponents.DRY.get(this).removeDry();
                            fertilizable.grow((ServerWorld) world, world.random, pos, blockState);
                        }
                    }
                }
            }
        }

        if (blockState.getBlock() == Blocks.WATER) {
            long lastUsage = PlayerComponents.RITUALTIME.get(this).getInt("lastWater");
            if (world.getTime() - lastUsage >= cooldown) {
                PlayerComponents.DRY.get(this).addDry();
                PlayerComponents.RITUALTIME.get(this).setIntTime("lastWater");
            }
        }
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(ArsSounds.ANZU_WINGFLAP, 0.15F, 1.0F);
    }


    public void tickMovement() {
        super.tickMovement();

        Vec3d vec3d = this.getVelocity();

        if (!this.onGround && vec3d.y < 0.0D) {
            this.setVelocity(vec3d.multiply(1.0D, 0.6D, 1.0D));
        }

    }

    public boolean tryAttack(Entity target) {
        boolean bl = target.damage(DamageSource.mob(this), 3);
        if (bl) {
            this.applyDamageEffects(this, target);
        }

        return bl;
    }

    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(3, new FollowOwnerGoal(this, 0.6D, 10.0F, 2.0F, false));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
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
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<>(this, "walkController", 20, this::animationPredicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.animationFactory;
    }
}
