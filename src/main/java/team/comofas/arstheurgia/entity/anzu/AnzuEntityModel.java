// Made with Blockbench 3.6.2
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package team.comofas.arstheurgia.entity.anzu;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import team.comofas.arstheurgia.ArsUtils;
import team.comofas.arstheurgia.entity.AnzuEntity;
import team.comofas.arstheurgia.player.PlayerComponents;

public class AnzuEntityModel extends AnimatedGeoModel<AnzuEntity> {

	@Override
	public Identifier getModelLocation(AnzuEntity anzuEntity) {
		return ArsUtils.getIdentifier("geo/anzu.geo.json");
	}

	@Override
	public Identifier getTextureLocation(AnzuEntity anzuEntity) {
		float maxdry = 8;
		float statenum = 2;
		int state = (int) Math.floor((statenum/maxdry)* ((float) PlayerComponents.DRY.get(anzuEntity).getDry()));
		if (state == 0) {
			return ArsUtils.getIdentifier("textures/entity/anzu3.png");
		} else if (state == 1) {
			return ArsUtils.getIdentifier("textures/entity/anzu2.png");
		} else {
			return ArsUtils.getIdentifier("textures/entity/anzu.png");
		}
	}

	@Override
	public Identifier getAnimationFileLocation(AnzuEntity anzuEntity) {
		return ArsUtils.getIdentifier("animations/anzu.json");
	}
}