package team.comofas.arstheurgia.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;
import team.comofas.arstheurgia.ArsUtils;

public class ArsSounds {
    public static SoundEvent CHALK = new SoundEvent(ArsUtils.getIdentifier("chalk"));
    public static SoundEvent RITUAL_FAIL = new SoundEvent(ArsUtils.getIdentifier("ritual_fail"));
    public static SoundEvent RITUAL_CHIME = new SoundEvent(ArsUtils.getIdentifier("ritual_chime"));
    public static SoundEvent UDUG_DISAPPEAR = new SoundEvent(ArsUtils.getIdentifier("udug_disappear"));
    public static SoundEvent UDUG_AMBIENT = new SoundEvent(ArsUtils.getIdentifier("udug_ambient"));
    public static SoundEvent UDUG_WALKING = new SoundEvent(ArsUtils.getIdentifier("udug_walking"));
    public static SoundEvent COLLECT_BILE = new SoundEvent(ArsUtils.getIdentifier("collect_bile"));
    public static SoundEvent LAMASSU_WINGFLAP = new SoundEvent(ArsUtils.getIdentifier("lamassu_wingflap"));
    public static SoundEvent CLAWS_ATTACK = new SoundEvent(ArsUtils.getIdentifier("claws_attack"));
    public static SoundEvent LAMASSU_AMBIENT = new SoundEvent(ArsUtils.getIdentifier("lamassu_ambient"));
    public static SoundEvent ANZU_WINGFLAP = new SoundEvent(ArsUtils.getIdentifier("anzu_wingflap"));
    public static SoundEvent CLAWS_GROW = new SoundEvent(ArsUtils.getIdentifier("claws_grow"));
    public static SoundEvent MACE_PULL = new SoundEvent(ArsUtils.getIdentifier("mace_pull"));
    public static SoundEvent MACE_SPIN = new SoundEvent(ArsUtils.getIdentifier("mace_spin"));
    public static SoundEvent IMHULLU_WIND = new SoundEvent(ArsUtils.getIdentifier("imhullu_wind"));


    public static void registerAll() {
        registerSound(CHALK);
        registerSound(RITUAL_FAIL);
        registerSound(RITUAL_CHIME);
        registerSound(UDUG_AMBIENT);
        registerSound(UDUG_DISAPPEAR);
        registerSound(UDUG_WALKING);
        registerSound(COLLECT_BILE);
        registerSound(LAMASSU_WINGFLAP);
        registerSound(LAMASSU_AMBIENT);
        registerSound(ANZU_WINGFLAP);
        registerSound(CLAWS_ATTACK);
        registerSound(CLAWS_GROW);
        registerSound(MACE_PULL);
        registerSound(MACE_SPIN);
        registerSound(IMHULLU_WIND);
    }

    public static SoundEvent registerSound(SoundEvent sound) {
        return Registry.register(Registry.SOUND_EVENT, sound.getId(), sound);
    }
}
