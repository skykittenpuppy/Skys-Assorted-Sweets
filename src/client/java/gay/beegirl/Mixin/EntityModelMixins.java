package gay.beegirl.Mixin;

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
class BoggedEntityModelMixin {
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