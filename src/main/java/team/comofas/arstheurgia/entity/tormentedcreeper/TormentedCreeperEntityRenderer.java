package team.comofas.arstheurgia.entity.tormentedcreeper;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;
import team.comofas.arstheurgia.entity.LamassuEntity;
import team.comofas.arstheurgia.entity.TormentedCreeperEntity;

public class TormentedCreeperEntityRenderer extends GeoEntityRenderer<TormentedCreeperEntity> {

    public TormentedCreeperEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new TormentedCreeperEntityModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public Identifier getTexture(TormentedCreeperEntity entity) {
        return new Identifier("arstheurgia", "textures/entity/tormentedcreeper.png");
    }
}