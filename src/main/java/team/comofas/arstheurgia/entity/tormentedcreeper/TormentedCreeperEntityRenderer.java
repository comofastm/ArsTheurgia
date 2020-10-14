package team.comofas.arstheurgia.entity.tormentedcreeper;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import team.comofas.arstheurgia.entity.LamassuEntity;
import team.comofas.arstheurgia.entity.TormentedCreeperEntity;

public class TormentedCreeperEntityRenderer extends MobEntityRenderer<TormentedCreeperEntity, TormentedCreeperEntityModel> {

    public TormentedCreeperEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new TormentedCreeperEntityModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(TormentedCreeperEntity entity) {
        return new Identifier("arstheurgia", "textures/entity/tormentedcreeper.png");
    }
}