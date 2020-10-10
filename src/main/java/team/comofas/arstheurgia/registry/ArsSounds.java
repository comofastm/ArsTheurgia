package team.comofas.arstheurgia.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;
import team.comofas.arstheurgia.ArsUtils;

public class ArsSounds {
    public static SoundEvent CHALK = new SoundEvent(ArsUtils.getIdentifier("chalk"));
    public static SoundEvent RITUAL_FAIL = new SoundEvent(ArsUtils.getIdentifier("ritual_fail"));
    public static SoundEvent RITUAL_CHIME = new SoundEvent(ArsUtils.getIdentifier("ritual_chime"));

    public static void registerAll() {
        registerSound(CHALK);
        registerSound(RITUAL_FAIL);
        registerSound(RITUAL_CHIME);
    }

    public static SoundEvent registerSound(SoundEvent sound) {
        return Registry.register(Registry.SOUND_EVENT, sound.getId(), sound);
    }
}
