package team.comofas.arstheurgia.blocks.ceramicaltar;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

public class CeramicAltarBlockEntityRenderer<T extends BlockEntity> implements BlockEntityRenderer<CeramicAltarBlockEntity> {
    public CeramicAltarBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public void render(CeramicAltarBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

        if (entity.getPlacedItem() != null) {
            matrices.push();

            double offset = MathHelper.sin((float) ((entity.getWorld().getTime() + tickDelta) / 8.0)) / 8.0;

            matrices.translate(0.5, 0.75 + offset, 0.5);

            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((entity.getWorld().getTime() + tickDelta) * 2));

            int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
            MinecraftClient.getInstance().getItemRenderer().renderItem(entity.getPlacedItem(), ModelTransformation.Mode.GROUND, light, overlay, matrices, vertexConsumers, 0);;
            matrices.pop();
        }

    }

}