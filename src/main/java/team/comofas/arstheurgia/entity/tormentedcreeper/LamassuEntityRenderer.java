package team.comofas.arstheurgia.entity.tormentedcreeper;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import team.comofas.arstheurgia.entity.LamassuEntity;

public class LamassuEntityRenderer extends MobEntityRenderer<LamassuEntity, LamassuEntityModel> {

    public LamassuEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new LamassuEntityModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(LamassuEntity entity) {
        return new Identifier("arstheurgia", "textures/entity/udug.png");
    }
}