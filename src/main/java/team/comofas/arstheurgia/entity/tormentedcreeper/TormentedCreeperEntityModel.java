// Made with Blockbench 3.6.2
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package team.comofas.arstheurgia.entity.tormentedcreeper;

import software.bernie.geckolib.forgetofabric.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;
import team.comofas.arstheurgia.entity.TormentedCreeperEntity;

public class TormentedCreeperEntityModel extends AnimatedEntityModel<TormentedCreeperEntity> {

    private final AnimatedModelRenderer Everything;
	private final AnimatedModelRenderer neck;
	private final AnimatedModelRenderer bone8;
	private final AnimatedModelRenderer bone6;
	private final AnimatedModelRenderer bone5;
	private final AnimatedModelRenderer bone4;
	private final AnimatedModelRenderer bone3;
	private final AnimatedModelRenderer bone2;
	private final AnimatedModelRenderer bone;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer boneshead;
	private final AnimatedModelRenderer boneeye;
	private final AnimatedModelRenderer mouth;
	private final AnimatedModelRenderer legs;
	private final AnimatedModelRenderer flegs;
	private final AnimatedModelRenderer rightlegs;
	private final AnimatedModelRenderer bonefeet2;
	private final AnimatedModelRenderer realfoot4;
	private final AnimatedModelRenderer leftlegs;
	private final AnimatedModelRenderer bonefeet;
	private final AnimatedModelRenderer realfoot3;
	private final AnimatedModelRenderer blegs;
	private final AnimatedModelRenderer rightlegsb;
	private final AnimatedModelRenderer bonefeet4;
	private final AnimatedModelRenderer realfoot2;
	private final AnimatedModelRenderer leftlegsb;
	private final AnimatedModelRenderer bonefeet3;
	private final AnimatedModelRenderer realfoot;

    public TormentedCreeperEntityModel()
    {
        textureWidth = 128;
    textureHeight = 128;
    Everything = new AnimatedModelRenderer(this);
		Everything.setRotationPoint(0.0F, 24.0F, 0.0F);
		Everything.setTextureOffset(0, 0).addBox(-6.5F, -10.9F, -9.5F, 14.0F, 3.0F, 16.0F, 0.0F, false);
		Everything.setModelRendererName("Everything");
		this.registerModelRenderer(Everything);

		neck = new AnimatedModelRenderer(this);
		neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		Everything.addChild(neck);
		
		neck.setModelRendererName("neck");
		this.registerModelRenderer(neck);

		bone8 = new AnimatedModelRenderer(this);
		bone8.setRotationPoint(-1.5F, -10.0F, -2.6F);
		neck.addChild(bone8);
		setRotationAngle(bone8, -0.0873F, 0.0F, 0.0F);
		bone8.setTextureOffset(0, 19).addBox(-4.0F, -6.2242F, -5.7606F, 12.0F, 7.0F, 13.0F, 0.0F, false);
		bone8.setModelRendererName("bone8");
		this.registerModelRenderer(bone8);

		bone6 = new AnimatedModelRenderer(this);
		bone6.setRotationPoint(0.0F, -29.2F, -5.3F);
		neck.addChild(bone6);
		setRotationAngle(bone6, -0.0436F, 0.0F, 0.0F);
		bone6.setTextureOffset(72, 33).addBox(-3.5F, -11.2423F, -10.109F, 8.0F, 6.0F, 6.0F, 0.0F, false);
		bone6.setModelRendererName("bone6");
		this.registerModelRenderer(bone6);

		bone5 = new AnimatedModelRenderer(this);
		bone5.setRotationPoint(1.0F, -8.8F, 20.8F);
		neck.addChild(bone5);
		setRotationAngle(bone5, 1.0036F, 0.0F, 0.0F);
		bone5.setTextureOffset(32, 57).addBox(-4.5F, -42.2799F, 4.0983F, 8.0F, 6.0F, 7.0F, 0.0F, false);
		bone5.setModelRendererName("bone5");
		this.registerModelRenderer(bone5);

		bone4 = new AnimatedModelRenderer(this);
		bone4.setRotationPoint(0.0F, -1.0F, 8.5F);
		neck.addChild(bone4);
		setRotationAngle(bone4, 0.6632F, 0.0F, 0.0F);
		bone4.setTextureOffset(0, 55).addBox(-3.5F, -36.6319F, 5.143F, 8.0F, 6.0F, 8.0F, 0.0F, false);
		bone4.setModelRendererName("bone4");
		this.registerModelRenderer(bone4);

		bone3 = new AnimatedModelRenderer(this);
		bone3.setRotationPoint(0.0F, 0.2F, 4.9F);
		neck.addChild(bone3);
		setRotationAngle(bone3, 0.3054F, 0.0F, 0.0F);
		bone3.setTextureOffset(44, 0).addBox(-3.5F, -33.4707F, -2.4918F, 8.0F, 7.0F, 8.0F, 0.0F, false);
		bone3.setModelRendererName("bone3");
		this.registerModelRenderer(bone3);

		bone2 = new AnimatedModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.3F, 1.3F);
		neck.addChild(bone2);
		setRotationAngle(bone2, 0.1745F, 0.0F, 0.0F);
		bone2.setTextureOffset(0, 39).addBox(-4.0F, -27.1196F, -3.5373F, 9.0F, 6.0F, 10.0F, 0.0F, false);
		bone2.setModelRendererName("bone2");
		this.registerModelRenderer(bone2);

		bone = new AnimatedModelRenderer(this);
		bone.setRotationPoint(-2.0F, -9.0F, -2.9F);
		neck.addChild(bone);
		setRotationAngle(bone, -0.0436F, 0.0F, 0.0F);
		bone.setTextureOffset(38, 38).addBox(-3.0F, -12.8114F, -4.7635F, 11.0F, 7.0F, 12.0F, 0.0F, false);
		bone.setModelRendererName("bone");
		this.registerModelRenderer(bone);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.5F, -38.6F, -14.3F);
		neck.addChild(head);
		
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		boneshead = new AnimatedModelRenderer(this);
		boneshead.setRotationPoint(-0.5F, 8.5F, 10.0F);
		head.addChild(boneshead);
		setRotationAngle(boneshead, 0.1309F, 0.0F, 0.0F);
		boneshead.setTextureOffset(50, 19).addBox(-3.5F, -12.8714F, -16.8733F, 8.0F, 6.0F, 8.0F, 0.0F, false);
		boneshead.setTextureOffset(50, 33).addBox(-3.5F, -7.1288F, -16.9233F, 8.0F, 1.0F, 4.0F, 0.0F, false);
		boneshead.setTextureOffset(37, 19).addBox(-3.5F, -7.1288F, -13.9233F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		boneshead.setModelRendererName("boneshead");
		this.registerModelRenderer(boneshead);

		boneeye = new AnimatedModelRenderer(this);
		boneeye.setRotationPoint(-0.5F, 38.6F, 14.3F);
		head.addChild(boneeye);
		setRotationAngle(boneeye, 0.1309F, 0.0F, 0.0F);
		boneeye.setTextureOffset(0, 0).addBox(-3.9F, -41.2816F, -17.4005F, 3.0F, 3.0F, 0.0F, 0.0F, false);
		boneeye.setTextureOffset(0, 0).addBox(1.8F, -41.2816F, -17.4005F, 3.0F, 3.0F, 0.0F, 0.0F, false);
		boneeye.setModelRendererName("boneeye");
		this.registerModelRenderer(boneeye);

		mouth = new AnimatedModelRenderer(this);
		mouth.setRotationPoint(-0.5F, 4.3F, -3.7F);
		head.addChild(mouth);
		setRotationAngle(mouth, 0.1309F, 0.0F, 0.0F);
		mouth.setTextureOffset(68, 0).addBox(-3.5F, -0.2288F, -3.9233F, 8.0F, 2.0F, 4.0F, 0.0F, false);
		mouth.setModelRendererName("mouth");
		this.registerModelRenderer(mouth);

		legs = new AnimatedModelRenderer(this);
		legs.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		legs.setModelRendererName("legs");
		this.registerModelRenderer(legs);

		flegs = new AnimatedModelRenderer(this);
		flegs.setRotationPoint(0.0F, -8.0F, -8.0F);
		legs.addChild(flegs);
		
		flegs.setModelRendererName("flegs");
		this.registerModelRenderer(flegs);

		rightlegs = new AnimatedModelRenderer(this);
		rightlegs.setRotationPoint(-2.0F, 0.0F, 1.0F);
		flegs.addChild(rightlegs);
		
		rightlegs.setModelRendererName("rightlegs");
		this.registerModelRenderer(rightlegs);

		bonefeet2 = new AnimatedModelRenderer(this);
		bonefeet2.setRotationPoint(2.0F, 9.1F, 6.7F);
		rightlegs.addChild(bonefeet2);
		setRotationAngle(bonefeet2, -0.1309F, 0.0F, 0.0873F);
		bonefeet2.setTextureOffset(76, 57).addBox(-8.0F, -8.0F, -10.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
		bonefeet2.setModelRendererName("bonefeet2");
		this.registerModelRenderer(bonefeet2);

		realfoot4 = new AnimatedModelRenderer(this);
		realfoot4.setRotationPoint(2.0F, 8.0F, 7.0F);
		rightlegs.addChild(realfoot4);
		realfoot4.setTextureOffset(30, 70).addBox(-10.0F, -4.0F, -12.8F, 7.0F, 3.0F, 8.0F, 0.0F, false);
		realfoot4.setModelRendererName("realfoot4");
		this.registerModelRenderer(realfoot4);

		leftlegs = new AnimatedModelRenderer(this);
		leftlegs.setRotationPoint(3.0F, 0.0F, 1.0F);
		flegs.addChild(leftlegs);
		
		leftlegs.setModelRendererName("leftlegs");
		this.registerModelRenderer(leftlegs);

		bonefeet = new AnimatedModelRenderer(this);
		bonefeet.setRotationPoint(-3.0F, 8.0F, 7.0F);
		leftlegs.addChild(bonefeet);
		setRotationAngle(bonefeet, -0.1745F, 0.0F, -0.0873F);
		bonefeet.setTextureOffset(75, 78).addBox(3.8606F, -6.3087F, -10.4126F, 5.0F, 5.0F, 5.0F, 0.0F, false);
		bonefeet.setModelRendererName("bonefeet");
		this.registerModelRenderer(bonefeet);

		realfoot3 = new AnimatedModelRenderer(this);
		realfoot3.setRotationPoint(-3.0F, 8.0F, 7.0F);
		leftlegs.addChild(realfoot3);
		realfoot3.setTextureOffset(68, 7).addBox(4.0F, -4.0F, -13.0F, 7.0F, 3.0F, 8.0F, 0.0F, false);
		realfoot3.setModelRendererName("realfoot3");
		this.registerModelRenderer(realfoot3);

		blegs = new AnimatedModelRenderer(this);
		blegs.setRotationPoint(0.0F, 0.0F, 0.0F);
		legs.addChild(blegs);
		
		blegs.setModelRendererName("blegs");
		this.registerModelRenderer(blegs);

		rightlegsb = new AnimatedModelRenderer(this);
		rightlegsb.setRotationPoint(-2.8F, -8.0F, 5.0F);
		blegs.addChild(rightlegsb);
		
		rightlegsb.setModelRendererName("rightlegsb");
		this.registerModelRenderer(rightlegsb);

		bonefeet4 = new AnimatedModelRenderer(this);
		bonefeet4.setRotationPoint(1.3F, -2.0F, -7.2F);
		rightlegsb.addChild(bonefeet4);
		setRotationAngle(bonefeet4, 0.0873F, 0.0F, 0.0F);
		bonefeet4.setTextureOffset(28, 39).addBox(-6.3F, 2.1594F, 4.5799F, 5.0F, 5.0F, 5.0F, 0.0F, false);
		bonefeet4.setModelRendererName("bonefeet4");
		this.registerModelRenderer(bonefeet4);

		realfoot2 = new AnimatedModelRenderer(this);
		realfoot2.setRotationPoint(2.8F, 8.0F, -5.0F);
		rightlegsb.addChild(realfoot2);
		realfoot2.setTextureOffset(54, 62).addBox(-11.0F, -4.0F, 2.9F, 7.0F, 3.0F, 8.0F, 0.0F, false);
		realfoot2.setModelRendererName("realfoot2");
		this.registerModelRenderer(realfoot2);

		leftlegsb = new AnimatedModelRenderer(this);
		leftlegsb.setRotationPoint(4.0F, -8.0F, 5.0F);
		blegs.addChild(leftlegsb);
		
		leftlegsb.setModelRendererName("leftlegsb");
		this.registerModelRenderer(leftlegsb);

		bonefeet3 = new AnimatedModelRenderer(this);
		bonefeet3.setRotationPoint(-4.0F, 8.0F, -5.0F);
		leftlegsb.addChild(bonefeet3);
		setRotationAngle(bonefeet3, 0.0873F, 0.0F, 0.0F);
		bonefeet3.setTextureOffset(60, 73).addBox(4.0F, -8.0F, 3.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
		bonefeet3.setModelRendererName("bonefeet3");
		this.registerModelRenderer(bonefeet3);

		realfoot = new AnimatedModelRenderer(this);
		realfoot.setRotationPoint(-4.0F, 8.0F, -5.0F);
		leftlegsb.addChild(realfoot);
		realfoot.setTextureOffset(0, 69).addBox(5.0F, -4.0F, 2.6F, 7.0F, 3.0F, 8.0F, 0.0F, false);
		realfoot.setModelRendererName("realfoot");
		this.registerModelRenderer(realfoot);

    this.rootBones.add(Everything);
		this.rootBones.add(legs);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
		return new ResourceLocation("arstheurgia", "animations/tormentedcreeper.json");
    }
}