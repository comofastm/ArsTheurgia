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


    public static void registerAll() {
        registerSound(CHALK);
        registerSound(RITUAL_FAIL);
        registerSound(RITUAL_CHIME);
        registerSound(UDUG_AMBIENT);
        registerSound(UDUG_DISAPPEAR);
        registerSound(UDUG_WALKING);
        registerSound(COLLECT_BILE);
    }

    public static SoundEvent registerSound(SoundEvent sound) {
        return Registry.register(Registry.SOUND_EVENT, sound.getId(), sound);
    }
}
