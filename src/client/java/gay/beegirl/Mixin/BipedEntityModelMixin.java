package gay.beegirl.Mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.function.Function;

@Mixin(BipedEntityModel.class)
public abstract class BipedEntityModelMixin extends AnimalModel {
    @Final
    @Shadow
    public ModelPart head;
    @Final
    @Shadow
    public ModelPart hat;
    @Final
    @Shadow
    public ModelPart body;
    @Unique
    public ModelPart jacket;
    @Final
    @Shadow
    public ModelPart rightArm;
    @Unique
    public ModelPart rightSleeve;
    @Final
    @Shadow
    public ModelPart leftArm;
    @Unique
    public ModelPart leftSleeve;
    @Final
    @Shadow
    public ModelPart rightLeg;
    @Unique
    public ModelPart rightPants;
    @Final
    @Shadow
    public ModelPart leftLeg;
    @Unique
    public ModelPart leftPants;

    @Inject(
            method = "<init>(Lnet/minecraft/client/model/ModelPart;Ljava/util/function/Function;)V",
            at = @At("RETURN")
    )
    private void init(ModelPart root, Function<Identifier, RenderLayer> renderLayerFactory, CallbackInfo ci){
        this.jacket = root.getChild("jacket");
        this.rightSleeve = root.getChild("right_sleeve");
        this.leftSleeve = root.getChild("left_sleeve");
        this.rightPants = root.getChild("right_pants");
        this.leftPants = root.getChild("left_pants");
    }

    @Inject(
            method = "getModelData",
            at = @At("RETURN"),
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private static void getModelData(Dilation dilation, float pivotOffsetY, CallbackInfoReturnable<ModelData> cir, ModelData modelData, ModelPartData modelPartData) {
        modelPartData.addChild("jacket", ModelPartBuilder.create().uv(16, 32).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, dilation.add(0.25F)), ModelTransform.NONE);
        modelPartData.addChild("right_sleeve", ModelPartBuilder.create().uv(40, 32).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation.add(0.25F)), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));
        modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(32, 48).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation), ModelTransform.pivot(5.0F, 2.0F, 0.0F));
        modelPartData.addChild("left_sleeve", ModelPartBuilder.create().uv(48, 48).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation.add(0.25F)), ModelTransform.pivot(5.0F, 2.0F, 0.0F));
        modelPartData.addChild("right_pants", ModelPartBuilder.create().uv(0, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation.add(0.25F)), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));
        modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(16, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation), ModelTransform.pivot(1.9F, 12.0F, 0.0F));
        modelPartData.addChild("left_pants", ModelPartBuilder.create().uv(0, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation.add(0.25F)), ModelTransform.pivot(1.9F, 12.0F, 0.0F));
    }

    @Override
    public Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of(this.head, this.hat);
    }
    @Override
    public Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of(this.body, this.rightArm, this.leftArm, this.rightLeg, this.leftLeg, this.jacket, this.rightSleeve, this.leftSleeve, this.rightPants, this.leftPants);
    }

    @Inject(
            method = "setAngles(Lnet/minecraft/entity/Entity;FFFFF)V",
            at = @At("TAIL")
    )
    public void setAngles(Entity entity, float f, float g, float h, float i, float j, CallbackInfo ci) {
        this.jacket.copyTransform(this.body);
        this.rightSleeve.copyTransform(this.rightArm);
        this.leftSleeve.copyTransform(this.leftArm);
        this.rightPants.copyTransform(this.rightLeg);
        this.leftPants.copyTransform(this.leftLeg);
    }

    @Inject(
            method = "setVisible",
            at = @At("TAIL")
    )
    private void setVisible(boolean visible, CallbackInfo ci) {
        this.jacket.visible = visible;
        this.rightSleeve.visible = visible;
        this.leftSleeve.visible = visible;
        this.rightPants.visible = visible;
        this.leftPants.visible = visible;
    }
}
