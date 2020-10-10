package team.comofas.arstheurgia;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import team.comofas.arstheurgia.blocks.RitualBlockEntityRenderer;
import team.comofas.arstheurgia.registry.ArsBlocks;

public class ArsTheurgiaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(ArsBlocks.RITUALBLOCK_ENTITY, RitualBlockEntityRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ArsBlocks.ASYRIEL_SIGIL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArsBlocks.AUTUMN_SYMBOL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArsBlocks.SPRING_SYMBOL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArsBlocks.SUMMER_SYMBOL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArsBlocks.WINTER_SYMBOL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArsBlocks.FLOUR, RenderLayer.getCutout());
    }
}
