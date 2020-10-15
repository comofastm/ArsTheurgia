// Made with Blockbench 3.6.2
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package team.comofas.arstheurgia.entity.lamassu;

import software.bernie.geckolib.forgetofabric.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;
import team.comofas.arstheurgia.entity.LamassuEntity;

public class LamassuEntityModel extends AnimatedEntityModel<LamassuEntity> {

    private final AnimatedModelRenderer main;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer body;
	private final AnimatedModelRenderer rightleg;
	private final AnimatedModelRenderer leftleg;
	private final AnimatedModelRenderer leftarm;
	private final AnimatedModelRenderer rightarm;
	private final AnimatedModelRenderer gpwingl;
	private final AnimatedModelRenderer leftwing;
	private final AnimatedModelRenderer leftwing2;
	private final AnimatedModelRenderer gpwingr;
	private final AnimatedModelRenderer rightwing2;
	private final AnimatedModelRenderer rightwing1;

    public LamassuEntityModel()
    {
        textureWidth = 128;
    textureHeight = 128;
    main = new AnimatedModelRenderer(this);
		main.setRotationPoint(0.0F, 23.0F, 0.0F);
		setRotationAngle(main, 0.0F, -1.5708F, 0.0F);
		
		main.setModelRendererName("main");
		this.registerModelRenderer(main);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(-6.0F, -18.2F, 0.0F);
		main.addChild(head);
		head.setTextureOffset(46, 44).addBox(-3.9F, 0.2F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(35, 0).addBox(-1.5F, -2.8F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(43, 18).addBox(-3.5F, -8.8F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(0, 15).addBox(-4.5F, -7.3F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(6, 34).addBox(-4.2F, -3.8F, -2.5F, 2.0F, 4.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(29, 66).addBox(-3.5F, -12.8F, -3.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(9, 27).addBox(-3.5F, -13.9F, -1.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(0, 24).addBox(-4.0F, -9.8F, -3.3F, 7.0F, 1.0F, 7.0F, 0.0F, false);
		head.setTextureOffset(0, 24).addBox(-4.0F, -11.8F, -3.3F, 7.0F, 1.0F, 7.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		body = new AnimatedModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(body);
		body.setTextureOffset(0, 51).addBox(-7.0F, -18.0F, -4.0F, 14.0F, 7.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(0, 19).addBox(-7.0F, -11.4F, -2.0F, 10.0F, 1.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(34, 5).addBox(-7.7F, -18.0F, -3.0F, 1.0F, 7.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(28, 35).addBox(8.1F, -17.0F, -1.5F, 1.0F, 11.0F, 3.0F, 0.0F, false);
		body.setTextureOffset(7, 66).addBox(7.0F, -13.5F, -4.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(28, 56).addBox(6.1F, -17.9F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		body.setModelRendererName("body");
		this.registerModelRenderer(body);

		rightleg = new AnimatedModelRenderer(this);
		rightleg.setRotationPoint(6.0F, -10.5F, 3.0F);
		main.addChild(rightleg);
		rightleg.setTextureOffset(31, 25).addBox(-1.5F, 2.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		rightleg.setTextureOffset(31, 25).addBox(-1.5F, 7.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		rightleg.setTextureOffset(7, 77).addBox(-1.5F, 10.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		rightleg.setTextureOffset(58, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		rightleg.setModelRendererName("rightleg");
		this.registerModelRenderer(rightleg);

		leftleg = new AnimatedModelRenderer(this);
		leftleg.setRotationPoint(6.0F, -10.5F, -3.0F);
		main.addChild(leftleg);
		leftleg.setTextureOffset(58, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		leftleg.setTextureOffset(31, 25).addBox(-1.5F, 2.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		leftleg.setTextureOffset(31, 25).addBox(-1.5F, 7.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		leftleg.setTextureOffset(7, 77).addBox(-1.5F, 10.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		leftleg.setModelRendererName("leftleg");
		this.registerModelRenderer(leftleg);

		leftarm = new AnimatedModelRenderer(this);
		leftarm.setRotationPoint(-5.0F, -10.5F, -3.0F);
		main.addChild(leftarm);
		leftarm.setTextureOffset(31, 25).addBox(-1.5F, 2.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		leftarm.setTextureOffset(58, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		leftarm.setTextureOffset(31, 25).addBox(-1.5F, 7.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		leftarm.setTextureOffset(7, 77).addBox(-1.5F, 10.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		leftarm.setModelRendererName("leftarm");
		this.registerModelRenderer(leftarm);

		rightarm = new AnimatedModelRenderer(this);
		rightarm.setRotationPoint(-5.0F, -10.5F, 3.0F);
		main.addChild(rightarm);
		rightarm.setTextureOffset(31, 25).addBox(-1.5F, 2.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		rightarm.setTextureOffset(31, 25).addBox(-1.5F, 7.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		rightarm.setTextureOffset(7, 77).addBox(-1.5F, 10.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		rightarm.setTextureOffset(58, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		rightarm.setModelRendererName("rightarm");
		this.registerModelRenderer(rightarm);

		gpwingl = new AnimatedModelRenderer(this);
		gpwingl.setRotationPoint(-1.4F, -17.0F, -4.0F);
		main.addChild(gpwingl);
		
		gpwingl.setModelRendererName("gpwingl");
		this.registerModelRenderer(gpwingl);

		leftwing = new AnimatedModelRenderer(this);
		leftwing.setRotationPoint(-2.6F, -1.0F, 0.0F);
		gpwingl.addChild(leftwing);
		setRotationAngle(leftwing, 0.0F, 0.0F, 0.48F);
		leftwing.setTextureOffset(0, 0).addBox(-1.0F, -8.0F, -1.1F, 7.0F, 8.0F, 1.0F, 0.0F, false);
		leftwing.setModelRendererName("leftwing");
		this.registerModelRenderer(leftwing);

		leftwing2 = new AnimatedModelRenderer(this);
		leftwing2.setRotationPoint(1.4F, 17.0F, 4.0F);
		gpwingl.addChild(leftwing2);
		setRotationAngle(leftwing2, 0.0F, 0.0F, 1.1083F);
		leftwing2.setTextureOffset(51, 34).addBox(-23.429F, -24.354F, -5.0F, 8.0F, 14.0F, 1.0F, 0.0F, false);
		leftwing2.setModelRendererName("leftwing2");
		this.registerModelRenderer(leftwing2);

		gpwingr = new AnimatedModelRenderer(this);
		gpwingr.setRotationPoint(-1.4F, -17.0F, 4.0F);
		main.addChild(gpwingr);
		
		gpwingr.setModelRendererName("gpwingr");
		this.registerModelRenderer(gpwingr);

		rightwing2 = new AnimatedModelRenderer(this);
		rightwing2.setRotationPoint(0.6F, -7.6F, -0.9F);
		gpwingr.addChild(rightwing2);
		setRotationAngle(rightwing2, 0.0F, 0.0F, 1.0908F);
		rightwing2.setTextureOffset(51, 34).addBox(-1.0F, -14.0F, 0.8F, 8.0F, 14.0F, 1.0F, 0.0F, false);
		rightwing2.setModelRendererName("rightwing2");
		this.registerModelRenderer(rightwing2);

		rightwing1 = new AnimatedModelRenderer(this);
		rightwing1.setRotationPoint(-2.6F, -1.0F, 0.0F);
		gpwingr.addChild(rightwing1);
		setRotationAngle(rightwing1, 0.0F, 0.0F, 0.48F);
		rightwing1.setTextureOffset(0, 0).addBox(-1.0F, -8.0F, 0.0F, 7.0F, 8.0F, 1.0F, 0.0F, false);
		rightwing1.setModelRendererName("rightwing1");
		this.registerModelRenderer(rightwing1);

    this.rootBones.add(main);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("arstheurgia", "animations/lamassu.json");
    }
}