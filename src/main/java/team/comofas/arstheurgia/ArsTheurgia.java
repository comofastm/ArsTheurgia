package team.comofas.arstheurgia;

import net.fabricmc.api.ModInitializer;
import team.comofas.arstheurgia.events.LootTableEvent;
import team.comofas.arstheurgia.registry.ArsBlocks;
import team.comofas.arstheurgia.registry.ArsItems;

public class ArsTheurgia implements ModInitializer {

    @Override
    public void onInitialize() {
        ArsBlocks.registerAll();
        ArsItems.registerAll();
        LootTableEvent.register();
    }
}
