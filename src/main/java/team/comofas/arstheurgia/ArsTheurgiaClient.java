package team.comofas.arstheurgia;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import team.comofas.arstheurgia.blocks.ceramicaltar.CeramicAltarBlockEntityRenderer;
import team.comofas.arstheurgia.blocks.RitualBlockEntityRenderer;
import team.comofas.arstheurgia.blocks.table.TableBlockEntity;
import team.comofas.arstheurgia.blocks.table.TableBlockEntityRenderer;
import team.comofas.arstheurgia.registry.ArsBlocks;

public class ArsTheurgiaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(ArsBlocks.RITUALBLOCK_ENTITY, RitualBlockEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ArsBlocks.CERAMIC_ALTAR_ENTITY, CeramicAltarBlockEntityRenderer::new);

        BlockEntityRendererRegistry.INSTANCE.register(ArsBlocks.TABLE_BLOCK_ENTITY, TableBlockEntityRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ArsBlocks.ASYRIEL_SIGIL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArsBlocks.AUTUMN_SYMBOL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArsBlocks.SPRING_SYMBOL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArsBlocks.SUMMER_SYMBOL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArsBlocks.WINTER_SYMBOL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArsBlocks.FLOUR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArsBlocks.MIRSU_BOWL, RenderLayer.getCutout());

        ClientSidePacketRegistry.INSTANCE.register(ArsTheurgia.CONSUME_ITEM_PARTICLE,
                (packetContext, attachedData) -> {
                    BlockPos pos = attachedData.readBlockPos();
                    packetContext.getTaskQueue().execute(() -> {
    
                        MinecraftClient.getInstance().particleManager.addParticle(
                                ParticleTypes.EXPLOSION_EMITTER, pos.getX(), pos.getY(), pos.getZ(),
                                0, 0, 0
                        );


                    });
                });


    }
}
