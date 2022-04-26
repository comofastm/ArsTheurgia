package team.comofas.arstheurgia.entity.udug;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import team.comofas.arstheurgia.entity.UdugEntity;

public class UdugEntityRenderer extends GeoEntityRenderer<UdugEntity> {

    public UdugEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new UdugEntityModel());
        this.shadowRadius = 0.5f;

    }

    @Override
    public Identifier getTexture(UdugEntity entity) {
        return new Identifier("arstheurgia", "textures/entity/udug.png");
    }
}