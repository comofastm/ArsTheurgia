package team.comofas.arstheurgia;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;
import team.comofas.arstheurgia.events.LootTableEvent;
import team.comofas.arstheurgia.registry.ArsBlocks;
import team.comofas.arstheurgia.registry.ArsEffects;
import team.comofas.arstheurgia.registry.ArsItems;
import team.comofas.arstheurgia.registry.ArsSounds;

public class ArsTheurgia implements ModInitializer {

    @Override
    public void onInitialize() {




        ArsSounds.registerAll();
        ArsBlocks.registerAll();
        ArsItems.registerAll();
        ArsEffects.registerAll();
        LootTableEvent.register();


    }
}
