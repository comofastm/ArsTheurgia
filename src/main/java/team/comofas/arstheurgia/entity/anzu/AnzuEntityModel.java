// Made with Blockbench 3.6.2
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package team.comofas.arstheurgia.entity.anzu;

import software.bernie.geckolib.forgetofabric.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;
import team.comofas.arstheurgia.entity.AnzuEntity;

public class AnzuEntityModel extends AnimatedEntityModel<AnzuEntity> {

    private final AnimatedModelRenderer main;
	private final AnimatedModelRenderer grouplegs;
	private final AnimatedModelRenderer rightlegsgp;
	private final AnimatedModelRenderer rightleg2;
	private final AnimatedModelRenderer rightfoot;
	private final AnimatedModelRenderer leftlegsgp;
	private final AnimatedModelRenderer leftfoot;
	private final AnimatedModelRenderer leftleg2;
	private final AnimatedModelRenderer wings;
	private final AnimatedModelRenderer rightwings;
	private final AnimatedModelRenderer rwings1;
	private final AnimatedModelRenderer rwings2;
	private final AnimatedModelRenderer rwings3;
	private final AnimatedModelRenderer leftwings;
	private final AnimatedModelRenderer leftwings1;
	private final AnimatedModelRenderer lwings2;
	private final AnimatedModelRenderer lwings3;
	private final AnimatedModelRenderer body;
	private final AnimatedModelRenderer body2;
	private final AnimatedModelRenderer tailgp;
	private final AnimatedModelRenderer tail2;
	private final AnimatedModelRenderer tail3;
	private final AnimatedModelRenderer tail4;
	private final AnimatedModelRenderer tail5;
	private final AnimatedModelRenderer tail1;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer nose1;
	private final AnimatedModelRenderer nose2;
	private final AnimatedModelRenderer head2;
	private final AnimatedModelRenderer head3;
	private final AnimatedModelRenderer grouparms;
	private final AnimatedModelRenderer rightarm;
	private final AnimatedModelRenderer righthand;
	private final AnimatedModelRenderer leftarm;
	private final AnimatedModelRenderer lefthand;

    public AnzuEntityModel()
    {
        textureWidth = 128;
    textureHeight = 128;
    main = new AnimatedModelRenderer(this);
		main.setRotationPoint(-0.4F, 32.0F, -5.0F);
		
		main.setModelRendererName("main");
		this.registerModelRenderer(main);

		grouplegs = new AnimatedModelRenderer(this);
		grouplegs.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(grouplegs);
		
		grouplegs.setModelRendererName("grouplegs");
		this.registerModelRenderer(grouplegs);

		rightlegsgp = new AnimatedModelRenderer(this);
		rightlegsgp.setRotationPoint(-4.0F, -19.5F, 12.6F);
		grouplegs.addChild(rightlegsgp);
		rightlegsgp.setTextureOffset(13, 48).addBox(-2.1F, -0.6F, -2.3F, 4.0F, 7.0F, 5.0F, 0.0F, false);
		rightlegsgp.setModelRendererName("rightlegsgp");
		this.registerModelRenderer(rightlegsgp);

		rightleg2 = new AnimatedModelRenderer(this);
		rightleg2.setRotationPoint(4.0F, 21.0F, -12.4F);
		rightlegsgp.addChild(rightleg2);
		setRotationAngle(rightleg2, 0.1309F, 0.0F, 0.0F);
		rightleg2.setTextureOffset(21, 60).addBox(-5.6F, -13.0086F, 13.294F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		rightleg2.setModelRendererName("rightleg2");
		this.registerModelRenderer(rightleg2);

		rightfoot = new AnimatedModelRenderer(this);
		rightfoot.setRotationPoint(4.0F, 19.5F, -12.6F);
		rightlegsgp.addChild(rightfoot);
		rightfoot.setTextureOffset(57, 59).addBox(-5.6F, -8.5F, 10.2F, 3.0F, 1.0F, 5.0F, 0.0F, false);
		rightfoot.setTextureOffset(42, 26).addBox(-4.6F, -8.5F, 14.6F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		rightfoot.setTextureOffset(30, 31).addBox(-3.2F, -8.5F, 8.4F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		rightfoot.setTextureOffset(30, 30).addBox(-4.2F, -8.5F, 8.4F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		rightfoot.setTextureOffset(4, 5).addBox(-5.1F, -8.5F, 8.4F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		rightfoot.setTextureOffset(34, 6).addBox(-4.1F, -8.5F, 16.4F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		rightfoot.setModelRendererName("rightfoot");
		this.registerModelRenderer(rightfoot);

		leftlegsgp = new AnimatedModelRenderer(this);
		leftlegsgp.setRotationPoint(5.0F, -19.5F, 12.6F);
		grouplegs.addChild(leftlegsgp);
		leftlegsgp.setTextureOffset(42, 0).addBox(-2.1F, -0.6F, -2.3F, 4.0F, 7.0F, 5.0F, 0.0F, false);
		leftlegsgp.setModelRendererName("leftlegsgp");
		this.registerModelRenderer(leftlegsgp);

		leftfoot = new AnimatedModelRenderer(this);
		leftfoot.setRotationPoint(-5.0F, 19.5F, -12.6F);
		leftlegsgp.addChild(leftfoot);
		leftfoot.setTextureOffset(54, 43).addBox(3.4F, -8.5F, 10.2F, 3.0F, 1.0F, 5.0F, 0.0F, false);
		leftfoot.setTextureOffset(36, 26).addBox(4.4F, -8.5F, 14.6F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		leftfoot.setTextureOffset(34, 31).addBox(4.9F, -8.5F, 16.4F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		leftfoot.setTextureOffset(0, 4).addBox(3.9F, -8.5F, 8.4F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		leftfoot.setTextureOffset(4, 4).addBox(4.8F, -8.5F, 8.4F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		leftfoot.setTextureOffset(0, 5).addBox(5.8F, -8.5F, 8.4F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		leftfoot.setModelRendererName("leftfoot");
		this.registerModelRenderer(leftfoot);

		leftleg2 = new AnimatedModelRenderer(this);
		leftleg2.setRotationPoint(-5.0F, 19.5F, -12.6F);
		leftlegsgp.addChild(leftleg2);
		setRotationAngle(leftleg2, 0.1309F, 0.0F, 0.0F);
		leftleg2.setTextureOffset(9, 60).addBox(3.4F, -11.5478F, 13.1966F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		leftleg2.setModelRendererName("leftleg2");
		this.registerModelRenderer(leftleg2);

		wings = new AnimatedModelRenderer(this);
		wings.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(wings);
		
		wings.setModelRendererName("wings");
		this.registerModelRenderer(wings);

		rightwings = new AnimatedModelRenderer(this);
		rightwings.setRotationPoint(-5.0F, -23.0F, 4.0F);
		wings.addChild(rightwings);
		
		rightwings.setModelRendererName("rightwings");
		this.registerModelRenderer(rightwings);

		rwings1 = new AnimatedModelRenderer(this);
		rwings1.setRotationPoint(0.0F, 0.0F, 0.5F);
		rightwings.addChild(rwings1);
		rwings1.setTextureOffset(0, 23).addBox(-0.1F, -5.0F, -3.8F, 0.0F, 5.0F, 9.0F, 0.0F, false);
		rwings1.setTextureOffset(66, 10).addBox(-0.7F, -5.0F, -4.7F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		rwings1.setModelRendererName("rwings1");
		this.registerModelRenderer(rwings1);

		rwings2 = new AnimatedModelRenderer(this);
		rwings2.setRotationPoint(0.0F, -5.0F, 1.5F);
		rightwings.addChild(rwings2);
		rwings2.setTextureOffset(0, 33).addBox(-0.1F, -5.0F, -4.4F, 0.0F, 5.0F, 9.0F, 0.0F, false);
		rwings2.setTextureOffset(62, 10).addBox(-0.7F, -5.0F, -5.4F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		rwings2.setModelRendererName("rwings2");
		this.registerModelRenderer(rwings2);

		rwings3 = new AnimatedModelRenderer(this);
		rwings3.setRotationPoint(0.0F, -10.0F, 1.5F);
		rightwings.addChild(rwings3);
		rwings3.setTextureOffset(0, 28).addBox(-0.1F, -5.0F, -3.8F, 0.0F, 5.0F, 9.0F, 0.0F, false);
		rwings3.setTextureOffset(31, 48).addBox(-0.7F, -5.0F, -4.8F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		rwings3.setModelRendererName("rwings3");
		this.registerModelRenderer(rwings3);

		leftwings = new AnimatedModelRenderer(this);
		leftwings.setRotationPoint(5.9F, -23.0F, 4.0F);
		wings.addChild(leftwings);
		
		leftwings.setModelRendererName("leftwings");
		this.registerModelRenderer(leftwings);

		leftwings1 = new AnimatedModelRenderer(this);
		leftwings1.setRotationPoint(0.1F, 0.0F, 0.5F);
		leftwings.addChild(leftwings1);
		leftwings1.setTextureOffset(0, 38).addBox(-0.1F, -5.0F, -3.8F, 0.0F, 5.0F, 9.0F, 0.0F, false);
		leftwings1.setTextureOffset(0, 0).addBox(-0.5F, -5.0F, -4.7F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		leftwings1.setModelRendererName("leftwings1");
		this.registerModelRenderer(leftwings1);

		lwings2 = new AnimatedModelRenderer(this);
		lwings2.setRotationPoint(0.1F, -5.0F, 1.5F);
		leftwings.addChild(lwings2);
		lwings2.setTextureOffset(18, 34).addBox(-0.1F, -5.0F, -4.4F, 0.0F, 5.0F, 9.0F, 0.0F, false);
		lwings2.setTextureOffset(34, 0).addBox(-0.5F, -5.0F, -5.4F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		lwings2.setModelRendererName("lwings2");
		this.registerModelRenderer(lwings2);

		lwings3 = new AnimatedModelRenderer(this);
		lwings3.setRotationPoint(0.1F, -10.0F, 1.5F);
		leftwings.addChild(lwings3);
		lwings3.setTextureOffset(36, 36).addBox(-0.1F, -5.0F, -3.8F, 0.0F, 5.0F, 9.0F, 0.0F, false);
		lwings3.setTextureOffset(4, 0).addBox(-0.5F, -5.0F, -4.8F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		lwings3.setModelRendererName("lwings3");
		this.registerModelRenderer(lwings3);

		body = new AnimatedModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(body);
		body.setTextureOffset(0, 0).addBox(-5.1F, -23.0F, -1.0F, 11.0F, 8.0F, 8.0F, 0.0F, false);
		body.setModelRendererName("body");
		this.registerModelRenderer(body);

		body2 = new AnimatedModelRenderer(this);
		body2.setRotationPoint(0.0F, -0.6F, -1.0F);
		body.addChild(body2);
		setRotationAngle(body2, -0.0436F, 0.0F, 0.0F);
		body2.setTextureOffset(29, 29).addBox(-5.1F, -22.0436F, 6.999F, 11.0F, 7.0F, 7.0F, 0.0F, false);
		body2.setModelRendererName("body2");
		this.registerModelRenderer(body2);

		tailgp = new AnimatedModelRenderer(this);
		tailgp.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(tailgp);
		
		tailgp.setModelRendererName("tailgp");
		this.registerModelRenderer(tailgp);

		tail2 = new AnimatedModelRenderer(this);
		tail2.setRotationPoint(0.5F, -23.0F, 14.1F);
		tailgp.addChild(tail2);
		setRotationAngle(tail2, -0.3054F, 0.0F, 0.0F);
		tail2.setTextureOffset(22, 0).addBox(-1.1F, 0.0F, 0.0F, 2.0F, 0.0F, 8.0F, 0.0F, false);
		tail2.setModelRendererName("tail2");
		this.registerModelRenderer(tail2);

		tail3 = new AnimatedModelRenderer(this);
		tail3.setRotationPoint(0.5F, -23.0F, 14.1F);
		tailgp.addChild(tail3);
		setRotationAngle(tail3, 0.2182F, 0.0F, 0.0F);
		tail3.setTextureOffset(13, 32).addBox(-1.1F, 0.0F, 0.0F, 2.0F, 0.0F, 9.0F, 0.0F, false);
		tail3.setModelRendererName("tail3");
		this.registerModelRenderer(tail3);

		tail4 = new AnimatedModelRenderer(this);
		tail4.setRotationPoint(0.5F, -23.0F, 14.1F);
		tailgp.addChild(tail4);
		setRotationAngle(tail4, 0.2182F, -0.6109F, 0.0F);
		tail4.setTextureOffset(9, 32).addBox(-1.1F, 0.0F, 0.0F, 2.0F, 0.0F, 9.0F, 0.0F, false);
		tail4.setModelRendererName("tail4");
		this.registerModelRenderer(tail4);

		tail5 = new AnimatedModelRenderer(this);
		tail5.setRotationPoint(0.5F, -23.0F, 14.1F);
		tailgp.addChild(tail5);
		setRotationAngle(tail5, 0.2182F, 0.6109F, 0.0F);
		tail5.setTextureOffset(29, 0).addBox(-1.1F, 0.0F, 0.0F, 2.0F, 0.0F, 9.0F, 0.0F, false);
		tail5.setModelRendererName("tail5");
		this.registerModelRenderer(tail5);

		tail1 = new AnimatedModelRenderer(this);
		tail1.setRotationPoint(0.0F, -12.0F, -11.0F);
		body.addChild(tail1);
		setRotationAngle(tail1, -0.6981F, 0.0F, 0.0F);
		tail1.setTextureOffset(26, 32).addBox(-0.1F, -24.7883F, 11.563F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		tail1.setModelRendererName("tail1");
		this.registerModelRenderer(tail1);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.4F, -21.0F, -1.0F);
		main.addChild(head);
		head.setTextureOffset(48, 26).addBox(3.5F, -6.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(44, 50).addBox(-5.5F, -6.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 16).addBox(-7.5F, -6.0F, -2.6F, 15.0F, 13.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(36, 12).addBox(-5.5F, -4.0F, -6.0F, 11.0F, 10.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(58, 26).addBox(-2.5F, 0.0F, -10.0F, 5.0F, 5.0F, 4.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		nose1 = new AnimatedModelRenderer(this);
		nose1.setRotationPoint(-2.8F, 5.0F, -2.1F);
		head.addChild(nose1);
		setRotationAngle(nose1, 0.0F, -0.3491F, 0.0F);
		nose1.setTextureOffset(31, 50).addBox(-2.4941F, -5.1F, -7.5778F, 4.0F, 5.0F, 5.0F, 0.0F, false);
		nose1.setModelRendererName("nose1");
		this.registerModelRenderer(nose1);

		nose2 = new AnimatedModelRenderer(this);
		nose2.setRotationPoint(-3.8F, 5.0F, 1.9F);
		head.addChild(nose2);
		setRotationAngle(nose2, 0.0F, 0.3491F, 0.0F);
		nose2.setTextureOffset(49, 49).addBox(6.0529F, -5.1F, -8.9459F, 4.0F, 5.0F, 5.0F, 0.0F, false);
		nose2.setModelRendererName("nose2");
		this.registerModelRenderer(nose2);

		head2 = new AnimatedModelRenderer(this);
		head2.setRotationPoint(-1.4F, 21.0F, 1.4F);
		head.addChild(head2);
		setRotationAngle(head2, 0.0F, -0.1309F, 0.0F);
		head2.setTextureOffset(65, 35).addBox(-5.0921F, -22.0F, -6.7792F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		head2.setModelRendererName("head2");
		this.registerModelRenderer(head2);

		head3 = new AnimatedModelRenderer(this);
		head3.setRotationPoint(14.6F, 21.0F, 1.4F);
		head.addChild(head3);
		setRotationAngle(head3, 0.0F, 0.1309F, 0.0F);
		head3.setTextureOffset(57, 65).addBox(-9.0004F, -22.0F, -8.5041F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		head3.setModelRendererName("head3");
		this.registerModelRenderer(head3);

		grouparms = new AnimatedModelRenderer(this);
		grouparms.setRotationPoint(-0.4F, 32.0F, -5.0F);
		
		grouparms.setModelRendererName("grouparms");
		this.registerModelRenderer(grouparms);

		rightarm = new AnimatedModelRenderer(this);
		rightarm.setRotationPoint(-5.1F, -20.0F, 2.0F);
		grouparms.addChild(rightarm);
		rightarm.setTextureOffset(45, 59).addBox(-2.0F, -0.1F, -1.7F, 2.0F, 7.0F, 4.0F, 0.0F, false);
		rightarm.setTextureOffset(0, 65).addBox(-2.2F, 6.9F, -0.7F, 2.0F, 5.0F, 3.0F, 0.0F, false);
		rightarm.setModelRendererName("rightarm");
		this.registerModelRenderer(rightarm);

		righthand = new AnimatedModelRenderer(this);
		righthand.setRotationPoint(5.1F, 20.0F, -2.0F);
		rightarm.addChild(righthand);
		righthand.setTextureOffset(60, 5).addBox(-7.9F, -9.0F, 0.5F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		righthand.setTextureOffset(32, 33).addBox(-7.4F, -8.7F, -1.1F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		righthand.setTextureOffset(34, 5).addBox(-7.4F, -9.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		righthand.setTextureOffset(34, 34).addBox(-6.4F, -9.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		righthand.setTextureOffset(26, 31).addBox(-6.4F, -8.7F, -1.1F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		righthand.setTextureOffset(26, 32).addBox(-5.4F, -8.7F, -1.1F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		righthand.setTextureOffset(32, 34).addBox(-5.4F, -9.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		righthand.setModelRendererName("righthand");
		this.registerModelRenderer(righthand);

		leftarm = new AnimatedModelRenderer(this);
		leftarm.setRotationPoint(6.0F, -20.0F, 2.0F);
		grouparms.addChild(leftarm);
		leftarm.setTextureOffset(0, 52).addBox(-0.1F, -0.1F, -1.7F, 2.0F, 7.0F, 4.0F, 0.0F, false);
		leftarm.setTextureOffset(33, 60).addBox(0.1F, 6.9F, -0.7F, 2.0F, 5.0F, 3.0F, 0.0F, false);
		leftarm.setModelRendererName("leftarm");
		this.registerModelRenderer(leftarm);

		lefthand = new AnimatedModelRenderer(this);
		lefthand.setRotationPoint(-6.0F, 20.0F, -2.0F);
		leftarm.addChild(lefthand);
		lefthand.setTextureOffset(55, 0).addBox(5.7F, -9.0F, 0.5F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		lefthand.setTextureOffset(33, 15).addBox(7.1F, -9.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		lefthand.setTextureOffset(33, 16).addBox(6.1F, -9.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		lefthand.setTextureOffset(0, 17).addBox(6.1F, -8.7F, -1.1F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		lefthand.setTextureOffset(0, 15).addBox(7.1F, -8.7F, -1.1F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		lefthand.setTextureOffset(0, 16).addBox(8.1F, -8.7F, -1.1F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		lefthand.setTextureOffset(33, 17).addBox(8.1F, -9.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		lefthand.setModelRendererName("lefthand");
		this.registerModelRenderer(lefthand);

    this.rootBones.add(main);
		this.rootBones.add(grouparms);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("arstheurgia", "animations/anzu.json");
    }
}