package team.comofas.arstheurgia.sounds;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class ATMovingSound extends MovingSoundInstance {
    private final Entity entity;
    private float distance = 0.0F;

    public ATMovingSound(Entity entity, SoundEvent sound) {
        super(sound, SoundCategory.NEUTRAL);
        this.entity = entity;
        this.repeat = true;
        this.repeatDelay = 0;
        this.volume = 1F;
        this.x = (float)entity.getX();
        this.y = (float)entity.getY();
        this.z = (float)entity.getZ();
    }

    public boolean canPlay() {
        return true;
    }

    public boolean shouldAlwaysPlay() {
        return true;
    }

    public void tick() {
        if (this.entity.removed) {
            this.setDone();
        } else {
            this.x = (float)this.entity.getX();
            this.y = (float)this.entity.getY();
            this.z = (float)this.entity.getZ();
            float f = MathHelper.sqrt(Entity.squaredHorizontalLength(this.entity.getVelocity()));
            if ((double)f >= 0.01D) {
                this.distance = MathHelper.clamp(this.distance + 0.0025F, 0.0F, 1.0F);
                this.volume = MathHelper.lerp(MathHelper.clamp(f, 0.0F, 0.5F), 0.0F, 0.7F);
            } else {
                this.distance = 0.0F;
                this.volume = 0.0F;
            }

        }
    }
}
