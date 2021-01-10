// Made with Blockbench 3.6.2
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package team.comofas.arstheurgia.entity.udug;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import team.comofas.arstheurgia.ArsUtils;
import team.comofas.arstheurgia.entity.UdugEntity;

public class UdugEntityModel extends AnimatedGeoModel<UdugEntity> {

	@Override
	public Identifier getModelLocation(UdugEntity udugEntity) {
		return ArsUtils.getIdentifier("geo/udug.geo.json");
	}

	@Override
	public Identifier getTextureLocation(UdugEntity udugEntity) {
		return ArsUtils.getIdentifier("textures/entity/udug.png");
	}

	@Override
	public Identifier getAnimationFileLocation(UdugEntity udugEntity) {
		return ArsUtils.getIdentifier("animations/udug.json");
	}
}