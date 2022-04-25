package team.comofas.arstheurgia.mixin;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.comofas.arstheurgia.registry.ArsStructures;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeaturesMixin {
    @Inject(method = "addDesertFeatures(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V", at = @At("TAIL"))
    private static void addDesertFeatures(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.structureFeature(ArsStructures.CONFIGURED_HOUSE_FEATURE);
        builder.structureFeature(ArsStructures.CONFIGURED_FRAGMENTED_RUIN);
        builder.structureFeature(ArsStructures.CONFIGURED_DATE_RUIN);
        builder.structureFeature(ArsStructures.CONFIGURED_ONE_FLOOR_RUIN);
        builder.structureFeature(ArsStructures.CONFIGURED_TABLE_RUIN);
        builder.structureFeature(ArsStructures.CONFIGURED_TWO_FLOOR_RUIN);
        builder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, ArsStructures.DATE_TREE);
    }
}