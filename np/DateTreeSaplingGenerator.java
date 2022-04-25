package team.comofas.arstheurgia.structures;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;
import team.comofas.arstheurgia.registry.ArsStructures;

import java.util.Random;

public class DateTreeSaplingGenerator extends SaplingGenerator {
    public DateTreeSaplingGenerator() {
    }

    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean bl) {
        return ArsStructures.DATE_TREE;
    }
}
