package gay.beegirl.Mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(AbstractZombieModel.class)
abstract class AbstractZombieModelMixin extends BipedEntityModelMixin {
    @Inject(
            method = "setAngles(Lnet/minecraft/entity/Entity;FFFFF)V",
            at = @At("TAIL")
    )
    public void setAngles(Entity entity, float f, float g, float h, float i, float j, CallbackInfo ci){
        this.jacket.copyTransform(this.body);
        this.rightSleeve.copyTransform(this.rightArm);
        this.leftSleeve.copyTransform(this.leftArm);
        this.rightPants.copyTransform(this.rightLeg);
        this.leftPants.copyTransform(this.leftLeg);
    }
}

@Mixin(BoggedEntityModel.class)
abstract class BoggedEntityModelMixin {
    @Inject(
            method = "getTexturedModelData",
            at = @At("RETURN"),
            locals = LocalCapture.CAPTURE_FAILHARD,
            cancellable = true
    )
    private static void getTexturedModelData(CallbackInfoReturnable<TexturedModelData> cir, ModelData modelData, ModelPartData modelPartData){
        ModelPartData modelPartData2 = modelPartData.getChild("head").addChild("mushrooms", ModelPartBuilder.create(), ModelTransform.NONE);
        modelPartData2.addChild("red_mushroom_1", ModelPartBuilder.create().uv(24, 0).cuboid(-3.0F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F), ModelTransform.of(3.0F, -8.0F, 3.0F, 0.0F, 0.7853982F, 0.0F));
        modelPartData2.addChild("red_mushroom_2", ModelPartBuilder.create().uv(24, 0).cuboid(-3.0F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F), ModelTransform.of(3.0F, -8.0F, 3.0F, 0.0F, 2.3561945F, 0.0F));
        modelPartData2.addChild("brown_mushroom_1", ModelPartBuilder.create().uv(24, 4).cuboid(-3.0F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F), ModelTransform.of(-3.0F, -8.0F, -3.0F, 0.0F, 0.7853982F, 0.0F));
        modelPartData2.addChild("brown_mushroom_2", ModelPartBuilder.create().uv(24, 4).cuboid(-3.0F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F), ModelTransform.of(-3.0F, -8.0F, -3.0F, 0.0F, 2.3561945F, 0.0F));
        modelPartData2.addChild("brown_mushroom_3", ModelPartBuilder.create().uv(56, 0).cuboid(-3.0F, -4.0F, 0.0F, 6.0F, 4.0F, 0.0F), ModelTransform.of(-2.0F, -1.0F, 4.0F, -1.5707964F, 0.0F, 0.7853982F));
        modelPartData2.addChild("brown_mushroom_4", ModelPartBuilder.create().uv(56, 0).cuboid(-3.0F, -4.0F, 0.0F, 6.0F, 4.0F, 0.0F), ModelTransform.of(-2.0F, -1.0F, 4.0F, -1.5707964F, 0.0F, 2.3561945F));
        cir.setReturnValue(
                TexturedModelData.of(modelData, 64, 64)
        );
    }
}

@Mixin(ChickenEntityModel.class)
abstract class ChickenEntityModelMixin extends AnimalModel {
    @Final
    @Shadow
    private ModelPart head;
    @Final
    @Shadow
    private ModelPart body;
    @Unique
    public ModelPart comb;
    @Unique
    public ModelPart tail;

    @Inject(
            method = "<init>",
            at = @At("RETURN")
    )
    private void init(ModelPart root, CallbackInfo ci){
        this.comb = this.head.getChild("comb");
        this.tail = this.body.getChild("tail");
    }

    @Inject(
            method = "getTexturedModelData",
            at = @At("RETURN"),
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private static void getTexturedModelData(CallbackInfoReturnable<TexturedModelData> cir, ModelData modelData, ModelPartData modelPartData, int i, ModelPartBuilder modelPartBuilder) {
        modelPartData.getChild("head").addChild("comb", ModelPartBuilder.create().uv(40, 0).cuboid(-6.0F, -10.0F, 0.0F, 8.0F, 8.0F, 0.0F), ModelTransform.rotation(0.0F, -(float)Math.PI/2, 0.0F));
        modelPartData.getChild("body").addChild("tail", ModelPartBuilder.create().uv(40, 8).cuboid(-12.0F, -13.0F, 0.0F, 8.0F, 16.0F, 0.0F), ModelTransform.rotation(-(float)Math.PI/2, 0, -(float)Math.PI/2));
    }
}

@Mixin(CowEntityModel.class)
abstract class CowEntityModelMixin extends QuadrupedEntityModel{
    @Unique
    public ModelPart rightHorn;
    @Unique
    public ModelPart leftHorn;
    @Unique
    public ModelPart udder;
    @Unique
    public ModelPart fluff;

    protected CowEntityModelMixin(ModelPart root, boolean headScaled, float childHeadYOffset, float childHeadZOffset, float invertedChildHeadScale, float invertedChildBodyScale, int childBodyYOffset) {
        super(root, headScaled, childHeadYOffset, childHeadZOffset, invertedChildHeadScale, invertedChildBodyScale, childBodyYOffset);
    }

    @Inject(
            method = "<init>",
            at = @At("RETURN")
    )
    private void init(ModelPart root, CallbackInfo ci){
        this.rightHorn = this.head.getChild("right_horn");
        this.leftHorn = this.head.getChild("left_horn");
        this.udder = this.body.getChild("udder");
        this.fluff = this.body.getChild("fluff");
    }

    @Inject(
            method = "getTexturedModelData",
            at = @At("RETURN"),
            cancellable = true,
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private static void getTexturedModelData(CallbackInfoReturnable<TexturedModelData> cir, ModelData modelData, ModelPartData modelPartData, int i, ModelPartBuilder modelPartBuilder) {
        modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F), ModelTransform.pivot(0.0F, 4.0F, -8.0F));
        modelPartData.getChild("head").addChild("right_horn", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F), ModelTransform.NONE);
        modelPartData.getChild("head").addChild("left_horn", ModelPartBuilder.create().uv(22, 0).cuboid(4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F), ModelTransform.NONE);

        modelPartData.addChild("body", ModelPartBuilder.create().uv(20, 36).cuboid(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, new Dilation(0.01F)), ModelTransform.of(0.0F, 5.0F, 2.0F, 1.5707964F, 0.0F, 0.0F));
        modelPartData.getChild("body").addChild("udder", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 2.0F, -8.0F, 4.0F, 6.0F, 1.0F), ModelTransform.NONE);
        modelPartData.getChild("body").addChild("fluff", ModelPartBuilder.create().uv(0, 24).cuboid(-6.0F, -10.0F, -10.0F, 12.0F, 18.0F, 3.0F, new Dilation(0.01F)), ModelTransform.NONE);

        modelPartData.addChild("right_hind_leg", ModelPartBuilder.create().uv(32, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(-4.0F, 12.0F, 7.0F));
        modelPartData.addChild("left_hind_leg", ModelPartBuilder.create().uv(48, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(4.0F, 12.0F, 7.0F));
        modelPartData.addChild("right_front_leg", ModelPartBuilder.create().uv(32, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(-4.0F, 12.0F, -5.0F));
        modelPartData.addChild("left_front_leg", ModelPartBuilder.create().uv(48, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(4.0F, 12.0F, -5.0F));

        cir.setReturnValue(TexturedModelData.of(modelData, 64, 64));
    }
}

@Mixin(DrownedEntityModel.class)
abstract class DrownedEntityModelMixin extends BipedEntityModelMixin{
    @Inject(
            method = "setAngles(Lnet/minecraft/entity/Entity;FFFFF)V",
            at = @At("TAIL")
    )
    public void setAngles(Entity entity, float f, float g, float h, float i, float j, CallbackInfo ci){
        this.jacket.copyTransform(this.body);
        this.rightSleeve.copyTransform(this.rightArm);
        this.leftSleeve.copyTransform(this.leftArm);
        this.rightPants.copyTransform(this.rightLeg);
        this.leftPants.copyTransform(this.leftLeg);
    }
}

@Mixin(PigEntityModel.class)
abstract class PigEntityModelMixin extends QuadrupedEntityModel {
    @Unique
    public ModelPart dirt;
    @Unique
    public ModelPart tulip;

    protected PigEntityModelMixin(ModelPart root, boolean headScaled, float childHeadYOffset, float childHeadZOffset, float invertedChildHeadScale, float invertedChildBodyScale, int childBodyYOffset) {
        super(root, headScaled, childHeadYOffset, childHeadZOffset, invertedChildHeadScale, invertedChildBodyScale, childBodyYOffset);
    }

    @Inject(
            method = "<init>",
            at = @At("RETURN")
    )
    private void init(ModelPart root, CallbackInfo ci){
        this.dirt = this.head.getChild("dirt");
        this.tulip = this.head.getChild("tulip");
    }

    @Inject(
            method = "getTexturedModelData",
            at = @At("RETURN"),
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private static void getTexturedModelData(Dilation dilation, CallbackInfoReturnable<TexturedModelData> cir, ModelData modelData, ModelPartData modelPartData) {
        modelPartData.getChild("head").addChild("dirt", ModelPartBuilder.create().uv(28, 3).cuboid(-1.0F, -5.0F, -7.0F, 4.0F, 1.0F, 4.0F), ModelTransform.NONE);
        modelPartData.getChild("head").addChild("tulip", ModelPartBuilder.create().uv(44, 0).cuboid(-1.0F, -13.0F, -5.0F, 6.0F, 8.0F, 0.0F), ModelTransform.NONE);
    }
}

@Mixin(SheepEntityModel.class)
abstract class SheepEntityModelMixin extends QuadrupedEntityModel {
    @Unique
    public ModelPart headWool;
    @Unique
    public ModelPart headDyed;
    @Unique
    public ModelPart bodyWool;
    @Unique
    public ModelPart bodyDyed;
    @Unique
    public ModelPart rightHindLegWool;
    @Unique
    public ModelPart rightHindLegDyed;
    @Unique
    public ModelPart leftHindLegWool;
    @Unique
    public ModelPart leftHindLegDyed;
    @Unique
    public ModelPart rightFrontLegWool;
    @Unique
    public ModelPart rightFrontLegDyed;
    @Unique
    public ModelPart leftFrontLegWool;
    @Unique
    public ModelPart leftFrontLegDyed;

    protected SheepEntityModelMixin(ModelPart root, boolean headScaled, float childHeadYOffset, float childHeadZOffset, float invertedChildHeadScale, float invertedChildBodyScale, int childBodyYOffset) {
        super(root, headScaled, childHeadYOffset, childHeadZOffset, invertedChildHeadScale, invertedChildBodyScale, childBodyYOffset);
    }

    @Inject(
            method = "<init>",
            at = @At("RETURN")
    )
    private void init(ModelPart root, CallbackInfo ci){
        this.headDyed = this.head.getChild("head_dyed");
        this.headWool = this.head.getChild("head_wool");
        this.bodyDyed = this.body.getChild("body_dyed");
        this.bodyWool = this.body.getChild("body_wool");
        this.rightHindLegDyed = this.rightHindLeg.getChild("right_hind_leg_dyed");
        this.rightHindLegWool = this.rightHindLeg.getChild("right_hind_leg_wool");
        this.leftHindLegDyed = this.leftHindLeg.getChild("left_hind_leg_dyed");
        this.leftHindLegWool = this.leftHindLeg.getChild("left_hind_leg_wool");
        this.rightFrontLegDyed = this.rightFrontLeg.getChild("right_front_leg_dyed");
        this.rightFrontLegWool = this.rightFrontLeg.getChild("right_front_leg_wool");
        this.leftFrontLegDyed = this.leftFrontLeg.getChild("left_front_leg_dyed");
        this.leftFrontLegWool = this.leftFrontLeg.getChild("left_front_leg_wool");
    }

    @Inject(
            method = "getTexturedModelData",
            at = @At("RETURN"),
            cancellable = true,
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private static void getTexturedModelData(CallbackInfoReturnable<TexturedModelData> cir, ModelData modelData, ModelPartData modelPartData) {
        modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -4.0F, -6.0F, 6.0F, 6.0F, 8.0F), ModelTransform.pivot(0.0F, 6.0F, -8.0F));
        modelPartData.getChild("head").addChild("head_dyed", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -4.0F, -6.0F, 6.0F, 6.0F, 8.0F), ModelTransform.NONE);
        modelPartData.getChild("head").addChild("head_wool", ModelPartBuilder.create().uv(0, 16).cuboid(-3.0F, -4.0F, -4.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.6F)), ModelTransform.NONE);

        modelPartData.addChild("body", ModelPartBuilder.create().uv(36, 20).cuboid(-4.0F, -10.0F, -7.0F, 8.0F, 16.0F, 6.0F), ModelTransform.of(0.0F, 5.0F, 2.0F, 1.5707964F, 0.0F, 0.0F));
        modelPartData.getChild("body").addChild("body_dyed", ModelPartBuilder.create().uv(36, 20).cuboid(-4.0F, -10.0F, -7.0F, 8.0F, 16.0F, 6.0F), ModelTransform.NONE);
        modelPartData.getChild("body").addChild("body_wool", ModelPartBuilder.create().uv(36, 42).cuboid(-4.0F, -10.0F, -7.0F, 8.0F, 16.0F, 6.0F, new Dilation(1.75F)), ModelTransform.NONE);

        modelPartData.addChild("right_hind_leg", ModelPartBuilder.create().uv(17, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(-3.0F, 12.0F, 7.0F));
        modelPartData.getChild("right_hind_leg").addChild("right_hind_leg_dyed", ModelPartBuilder.create().uv(17, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.NONE);
        modelPartData.getChild("right_hind_leg").addChild("right_hind_leg_wool", ModelPartBuilder.create().uv(47, 10).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.5F)), ModelTransform.NONE);

        modelPartData.addChild("left_hind_leg", ModelPartBuilder.create().uv(0, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(3.0F, 12.0F, 7.0F));
        modelPartData.getChild("left_hind_leg").addChild("left_hind_leg_dyed", ModelPartBuilder.create().uv(0, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.NONE);
        modelPartData.getChild("left_hind_leg").addChild("left_hind_leg_wool", ModelPartBuilder.create().uv(30, 10).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.5F)), ModelTransform.NONE);

        modelPartData.addChild("right_front_leg", ModelPartBuilder.create().uv(17, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(-3.0F, 12.0F, -5.0F));
        modelPartData.getChild("right_front_leg").addChild("right_front_leg_dyed", ModelPartBuilder.create().uv(17, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.NONE);
        modelPartData.getChild("right_front_leg").addChild("right_front_leg_wool", ModelPartBuilder.create().uv(47, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.5F)), ModelTransform.NONE);

        modelPartData.addChild("left_front_leg", ModelPartBuilder.create().uv(0, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(3.0F, 12.0F, -5.0F));
        modelPartData.getChild("left_front_leg").addChild("left_front_leg_dyed", ModelPartBuilder.create().uv(0, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.NONE);
        modelPartData.getChild("left_front_leg").addChild("left_front_leg_wool", ModelPartBuilder.create().uv(30, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.5F)), ModelTransform.NONE);
        cir.setReturnValue(TexturedModelData.of(modelData, 64, 64));
    }
    @Unique
    protected Iterable<ModelPart> getDyedParts() {
        return ImmutableList.of(this.headDyed, this.headWool,
                this.bodyDyed, this.bodyWool,
                this.rightHindLegDyed, this.rightHindLegWool,
                this.leftHindLegDyed, this.leftHindLegWool,
                this.rightFrontLegDyed, this.rightFrontLegWool,
                this.leftFrontLegDyed, this.leftFrontLegWool);
    }
    @Unique
    protected Iterable<ModelPart> getWoolParts() {
        return ImmutableList.of(this.headWool, this.bodyWool, this.rightHindLegWool, this.leftHindLegWool, this.rightFrontLegWool, this.leftFrontLegWool);
    }
}

@Mixin(SkeletonEntityModel.class)
abstract class SkeletonEntityModelMixin extends BipedEntityModelMixin{
    @Inject(
            method = "getTexturedModelData",
            at = @At("RETURN"),
            locals = LocalCapture.CAPTURE_FAILHARD,
            cancellable = true
    )
    private static void getTexturedModelData(CallbackInfoReturnable<TexturedModelData> cir, ModelData modelData, ModelPartData modelPartData){
        cir.setReturnValue(
                TexturedModelData.of(modelData, 64, 64)
        );
    }
    @Inject(
            method = "addLimbs",
            at = @At("TAIL")
    )
    private static void addLimbs(ModelPartData data, CallbackInfo ci) {
        data.addChild("left_arm", ModelPartBuilder.create().uv(32, 48).mirrored().cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F), ModelTransform.pivot(5.0F, 2.0F, 0.0F));
        data.addChild("left_leg", ModelPartBuilder.create().uv(16, 48).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), ModelTransform.pivot(2.0F, 12.0F, 0.0F));
    }
    @Inject(
            method = "setAngles(Lnet/minecraft/entity/Entity;FFFFF)V",
            at = @At("TAIL")
    )
    public void setAngles(Entity entity, float f, float g, float h, float i, float j, CallbackInfo ci){
        this.jacket.copyTransform(this.body);
        this.rightSleeve.copyTransform(this.rightArm);
        this.leftSleeve.copyTransform(this.leftArm);
        this.rightPants.copyTransform(this.rightLeg);
        this.leftPants.copyTransform(this.leftLeg);
    }
}
