package team.comofas.arstheurgia.entity.anzu;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;
import team.comofas.arstheurgia.entity.AnzuEntity;
import team.comofas.arstheurgia.entity.LamassuEntity;
import team.comofas.arstheurgia.player.PlayerComponents;

public class AnzuEntityRenderer extends GeoEntityRenderer<AnzuEntity> {

    public AnzuEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new AnzuEntityModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public Identifier getTexture(AnzuEntity entity) {
        float maxdry = 8;
        float statenum = 2;
        int state = (int) Math.floor((statenum/maxdry)* ((float) PlayerComponents.DRY.get(entity).getDry()));
        if (state == 0) {
            return new Identifier("arstheurgia", "textures/entity/anzu3.png");
        } else if (state == 1) {
            return new Identifier("arstheurgia", "textures/entity/anzu2.png");
        } else {
            return new Identifier("arstheurgia", "textures/entity/anzu.png");
        }
    }
}