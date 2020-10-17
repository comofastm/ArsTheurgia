package team.comofas.arstheurgia.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;
import team.comofas.arstheurgia.player.PlayerComponents;
import team.comofas.arstheurgia.registry.ArsSounds;

public class UdugEntity extends TameableEntity implements IAnimatedEntity {

    private final EntityAnimationManager manager;
    private final EntityAnimationController controller;

    private <E extends Entity> boolean animationPredicate(AnimationTestEvent<E> event) {
        if (event.isWalking()) {
            this.controller.setAnimation(new AnimationBuilder().addAnimation("walk", true));
            return true;
        } else {
            return false;
        }
    }

    public UdugEntity(EntityType<UdugEntity> entityType, World world) {
        super(entityType, world);
        this.setTamed(true);
        this.setInvulnerable(true);
        this.manager = new EntityAnimationManager();
        this.controller = new EntityAnimationController(this, "walkController", 20, this::animationPredicate);
        this.manager.addAnimationController(controller);
    }

    public EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
    }

    public boolean damage(DamageSource source, float amount) {
        this.playSound(ArsSounds.UDUG_AMBIENT, 0.15F, 1.0F);
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            return super.damage(source, amount);
        }
    }

    public void baseTick() {
        super.baseTick();

        if (!this.world.isClient()) {
            if (this.world.getAmbientDarkness() < 4) {
                if (this.isAlive()) {
                    if (world.getTimeOfDay() % 60 == 0) {
                        PlayerComponents.KNOWLEDGE.maybeGet((PlayerEntity) this.getOwner()).ifPresent(value -> {
                            value.setKnowledge("activeUdug", false);
                        });
                        this.playSound(ArsSounds.UDUG_DISAPPEAR, 0.5F, 1.0F);
                        this.remove();
                    }
                }
            }
        }
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

    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new FollowOwnerGoal(this, 0.6D, 10.0F, 2.0F, false));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));

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
