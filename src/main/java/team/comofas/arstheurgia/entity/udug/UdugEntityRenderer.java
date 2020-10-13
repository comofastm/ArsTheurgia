package team.comofas.arstheurgia.entity.udug;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import team.comofas.arstheurgia.entity.UdugEntity;

public class UdugEntityRenderer extends MobEntityRenderer<UdugEntity, UdugEntityModel> {

    public UdugEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new UdugEntityModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(UdugEntity entity) {
        return new Identifier("arstheurgia", "textures/entity/udug.png");
    }
}