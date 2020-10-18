package team.comofas.arstheurgia.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.comofas.arstheurgia.ArsUtils;

public class ArsSounds {
    public static SoundEvent CHALK = registerSound("chalk");
    public static SoundEvent RITUAL_FAIL = registerSound("ritual_fail");
    public static SoundEvent RITUAL_CHIME = registerSound("ritual_chime");
    public static SoundEvent UDUG_DISAPPEAR = registerSound("udug_disappear");
    public static SoundEvent UDUG_AMBIENT = registerSound("udug_ambient");
    public static SoundEvent UDUG_WALKING = registerSound("udug_walking");
    public static SoundEvent COLLECT_BILE = registerSound("collect_bile");
    public static SoundEvent LAMASSU_WINGFLAP = registerSound("lamassu_wingflap");
    public static SoundEvent CLAWS_ATTACK = registerSound("claws_attack");
    public static SoundEvent LAMASSU_AMBIENT = registerSound("lamassu_ambient");
    public static SoundEvent ANZU_WINGFLAP = registerSound("anzu_wingflap");
    public static SoundEvent CLAWS_GROW = registerSound("claws_grow");
    public static SoundEvent MACE_PULL = registerSound("mace_pull");
    public static SoundEvent MACE_SPIN = registerSound("mace_spin");
    public static SoundEvent IMHULLU_WIND = registerSound("imhullu_wind");

    public static void init() {
        // NO-OP, forces static fields to load
    }

    public static SoundEvent registerSound(String name) {
        Identifier id = ArsUtils.getIdentifier(name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}
