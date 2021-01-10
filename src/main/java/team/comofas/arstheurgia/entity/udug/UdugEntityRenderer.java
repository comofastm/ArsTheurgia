package team.comofas.arstheurgia.entity.udug;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;
import team.comofas.arstheurgia.entity.UdugEntity;

public class UdugEntityRenderer extends GeoEntityRenderer<UdugEntity> {

    public UdugEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new UdugEntityModel());
        this.shadowRadius = 0.5f;

    }

    @Override
    public Identifier getTexture(UdugEntity entity) {
        return new Identifier("arstheurgia", "textures/entity/udug.png");
    }
}