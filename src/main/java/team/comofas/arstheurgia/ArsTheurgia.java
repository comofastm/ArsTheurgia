package team.comofas.arstheurgia;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import team.comofas.arstheurgia.events.LootTableEvent;
import team.comofas.arstheurgia.registry.ArsItems;

public class ArsTheurgia implements ModInitializer {

    @Override
    public void onInitialize() {
        ArsItems.registerAll();
        LootTableEvent.register();
    }
}
