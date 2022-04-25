package team.comofas.arstheurgia.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.comofas.arstheurgia.ArsUtils;
import team.comofas.arstheurgia.effects.ATEffect;

public class ArsEffects {
    public static final ATEffect PAZUZU_BLESSING = new ATEffect(StatusEffectCategory.NEUTRAL, 0xFFFFFF);
    public static final ATEffect LAMASHTU_BLESSING = new ATEffect(StatusEffectCategory.NEUTRAL, 0xFFFFFF);

    private static ATEffect register(String id, StatusEffect entry) {
        return (ATEffect) Registry.register(Registry.STATUS_EFFECT, ArsUtils.getIdentifier(id), entry);
    }

    public static void registerAll() {
        register("pazuzu_blessing", PAZUZU_BLESSING);
        register("lamashtu_blessing", LAMASHTU_BLESSING);
    }
}
