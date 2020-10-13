// Made with Blockbench 3.6.2
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package team.comofas.arstheurgia.entity.lamassu;

import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;
import software.bernie.geckolib.forgetofabric.ResourceLocation;
import team.comofas.arstheurgia.entity.LamassuEntity;
import team.comofas.arstheurgia.entity.UdugEntity;

public class LamassuEntityModel extends AnimatedEntityModel<LamassuEntity> {

    private final AnimatedModelRenderer MAIN;
	private final AnimatedModelRenderer upperbody;
	private final AnimatedModelRenderer body1;
	private final AnimatedModelRenderer belly;
	private final AnimatedModelRenderer arms;
	private final AnimatedModelRenderer arm1;
	private final AnimatedModelRenderer rightarm;
	private final AnimatedModelRenderer righthand;
	private final AnimatedModelRenderer arm2;
	private final AnimatedModelRenderer leftarm;
	private final AnimatedModelRenderer lefthand;
	private final AnimatedModelRenderer belly2;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer rightleg;
	private final AnimatedModelRenderer thigh2;
	private final AnimatedModelRenderer leftleg;
	private final AnimatedModelRenderer thigh;

    public LamassuEntityModel()
    {
        textureWidth = 64;
    	textureHeight = 64;
    	MAIN = new AnimatedModelRenderer(this);
		MAIN.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		MAIN.setModelRendererName("MAIN");
		this.registerModelRenderer(MAIN);

		upperbody = new AnimatedModelRenderer(this);
		upperbody.setRotationPoint(-0.5F, -17.8F, -5.0F);
		MAIN.addChild(upperbody);
		setRotationAngle(upperbody, 0.0436F, 0.0F, 0.0F);
		
		upperbody.setModelRendererName("upperbody");
		this.registerModelRenderer(upperbody);

		body1 = new AnimatedModelRenderer(this);
		body1.setRotationPoint(0.0F, 0.0F, 0.0F);
		upperbody.addChild(body1);
		body1.setTextureOffset(0, 16).addBox(-4.0F, -5.0F, 1.0F, 9.0F, 5.0F, 6.0F, 0.0F, false);
		body1.setModelRendererName("body1");
		this.registerModelRenderer(body1);

		belly = new AnimatedModelRenderer(this);
		belly.setRotationPoint(-2.3F, 5.8F, 4.6F);
		upperbody.addChild(belly);
		setRotationAngle(belly, 0.3491F, 0.0F, 0.0F);
		belly.setTextureOffset(46, 38).addBox(3.5F, -1.0F, -4.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);
		belly.setTextureOffset(12, 34).addBox(-1.0F, -1.0F, -4.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);
		belly.setModelRendererName("belly");
		this.registerModelRenderer(belly);

		arms = new AnimatedModelRenderer(this);
		arms.setRotationPoint(0.5F, 17.8F, 5.0F);
		upperbody.addChild(arms);
		
		arms.setModelRendererName("arms");
		this.registerModelRenderer(arms);

		arm1 = new AnimatedModelRenderer(this);
		arm1.setRotationPoint(-4.0F, -21.9641F, -1.0269F);
		arms.addChild(arm1);
		
		arm1.setModelRendererName("arm1");
		this.registerModelRenderer(arm1);

		rightarm = new AnimatedModelRenderer(this);
		rightarm.setRotationPoint(-1.5F, 2.0F, 0.0F);
		arm1.addChild(rightarm);
		setRotationAngle(rightarm, 0.2793F, 0.0F, 0.2443F);
		rightarm.setTextureOffset(16, 42).addBox(-2.7754F, -2.9122F, -2.04F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		rightarm.setModelRendererName("rightarm");
		this.registerModelRenderer(rightarm);

		righthand = new AnimatedModelRenderer(this);
		righthand.setRotationPoint(-2.8F, 7.2F, 0.4F);
		arm1.addChild(righthand);
		setRotationAngle(righthand, -0.0873F, 0.0F, 0.0F);
		righthand.setTextureOffset(0, 27).addBox(-2.1F, -3.5F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		righthand.setTextureOffset(0, 16).addBox(-2.2F, 2.7782F, 0.9005F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		righthand.setTextureOffset(3, 3).addBox(-2.2F, 2.7782F, -0.4995F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		righthand.setTextureOffset(0, 0).addBox(-2.2F, 2.7782F, -1.8995F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		righthand.setModelRendererName("righthand");
		this.registerModelRenderer(righthand);

		arm2 = new AnimatedModelRenderer(this);
		arm2.setRotationPoint(4.0F, -21.7789F, -1.1521F);
		arms.addChild(arm2);
		
		arm2.setModelRendererName("arm2");
		this.registerModelRenderer(arm2);

		leftarm = new AnimatedModelRenderer(this);
		leftarm.setRotationPoint(2.5F, 2.0F, 0.0F);
		arm2.addChild(leftarm);
		setRotationAngle(leftarm, 0.2956F, 0.0779F, -0.2502F);
		leftarm.setTextureOffset(32, 42).addBox(-2.1932F, -3.0518F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		leftarm.setModelRendererName("leftarm");
		this.registerModelRenderer(leftarm);

		lefthand = new AnimatedModelRenderer(this);
		lefthand.setRotationPoint(-1.8F, 7.2F, 0.4F);
		arm2.addChild(lefthand);
		setRotationAngle(lefthand, -0.0873F, 0.0F, 0.0F);
		lefthand.setTextureOffset(30, 12).addBox(2.7F, -3.5F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		lefthand.setTextureOffset(24, 0).addBox(5.8F, 3.0779F, 0.8874F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		lefthand.setTextureOffset(24, 4).addBox(5.8F, 3.0779F, -0.5126F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		lefthand.setTextureOffset(24, 16).addBox(5.8F, 3.0779F, -1.9126F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		lefthand.setModelRendererName("lefthand");
		this.registerModelRenderer(lefthand);

		belly2 = new AnimatedModelRenderer(this);
		belly2.setRotationPoint(4.5F, 6.8F, 1.4F);
		upperbody.addChild(belly2);
		setRotationAngle(belly2, -0.0873F, 0.0F, 0.0F);
		belly2.setTextureOffset(26, 26).addBox(-8.0F, -12.0F, 0.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		belly2.setTextureOffset(16, 27).addBox(-6.0F, -6.0F, -0.6F, 4.0F, 6.0F, 1.0F, 0.0F, false);
		belly2.setModelRendererName("belly2");
		this.registerModelRenderer(belly2);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.5F, -9.2F, 3.0F);
		upperbody.addChild(head);
		setRotationAngle(head, 0.1309F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -3.8486F, -3.6165F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		rightleg = new AnimatedModelRenderer(this);
		rightleg.setRotationPoint(-3.0F, -10.7F, -2.7F);
		MAIN.addChild(rightleg);
		rightleg.setTextureOffset(46, 16).addBox(-2.0F, 5.7F, 0.6F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		rightleg.setModelRendererName("rightleg");
		this.registerModelRenderer(rightleg);

		thigh2 = new AnimatedModelRenderer(this);
		thigh2.setRotationPoint(-1.0F, 5.7F, 4.7F);
		rightleg.addChild(thigh2);
		setRotationAngle(thigh2, 0.3491F, 0.0F, 0.0F);
		thigh2.setTextureOffset(32, 0).addBox(-1.0F, -6.7182F, -3.9734F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		thigh2.setModelRendererName("thigh2");
		this.registerModelRenderer(thigh2);

		leftleg = new AnimatedModelRenderer(this);
		leftleg.setRotationPoint(3.0F, -10.7F, -2.7F);
		MAIN.addChild(leftleg);
		leftleg.setTextureOffset(44, 7).addBox(-2.0F, 5.7F, 0.8F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		leftleg.setModelRendererName("leftleg");
		this.registerModelRenderer(leftleg);

		thigh = new AnimatedModelRenderer(this);
		thigh.setRotationPoint(0.0F, 5.7F, 4.7F);
		leftleg.addChild(thigh);
		setRotationAngle(thigh, 0.3491F, 0.0F, 0.0F);
		thigh.setTextureOffset(0, 38).addBox(-2.0F, -6.6498F, -3.7854F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		thigh.setModelRendererName("thigh");
		this.registerModelRenderer(thigh);

    this.rootBones.add(MAIN);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("arstheurgia", "animations/udug.json");
    }
}