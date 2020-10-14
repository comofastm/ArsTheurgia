package team.comofas.arstheurgia.entity.anzu;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import team.comofas.arstheurgia.entity.AnzuEntity;
import team.comofas.arstheurgia.entity.LamassuEntity;

public class AnzuEntityRenderer extends MobEntityRenderer<AnzuEntity, AnzuEntityModel> {

    public AnzuEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new AnzuEntityModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(AnzuEntity entity) {
        return new Identifier("arstheurgia", "textures/entity/udug.png");
    }
}