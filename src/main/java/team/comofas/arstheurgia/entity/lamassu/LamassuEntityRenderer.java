package team.comofas.arstheurgia.entity.lamassu;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;
import team.comofas.arstheurgia.entity.LamassuEntity;
import team.comofas.arstheurgia.entity.UdugEntity;

public class LamassuEntityRenderer extends GeoEntityRenderer<LamassuEntity> {

    public LamassuEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new LamassuEntityModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public Identifier getTexture(LamassuEntity entity) {
        return new Identifier("arstheurgia", "textures/entity/lamassu.png");
    }
}