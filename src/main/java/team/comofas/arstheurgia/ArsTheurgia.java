package team.comofas.arstheurgia;

import net.fabricmc.api.ModInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;
import team.comofas.arstheurgia.events.LootTableEvent;
import team.comofas.arstheurgia.registry.ArsBlocks;
import team.comofas.arstheurgia.registry.ArsEffects;
import team.comofas.arstheurgia.registry.ArsItems;

public class ArsTheurgia implements ModInitializer {
    public static SoundEvent CHALK = new SoundEvent(ArsUtils.getIdentifier("chalk"));

    @Override
    public void onInitialize() {
        Registry.register(Registry.SOUND_EVENT, ArsUtils.getIdentifier("chalk"), CHALK);
        ArsBlocks.registerAll();
        ArsItems.registerAll();
        ArsEffects.registerAll();
        LootTableEvent.register();
    }
}
