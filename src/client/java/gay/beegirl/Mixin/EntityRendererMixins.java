package gay.beegirl.Mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import gay.beegirl.Generics.IVariantMixinEntity;
import gay.beegirl.Generics.IVariantMixinSheepEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.*;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoggedEntityRenderer.class)
abstract class BoggedEntityRendererMixin {
    @WrapWithCondition(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/BoggedEntityRenderer;addFeature(Lnet/minecraft/client/render/entity/feature/FeatureRenderer;)Z"
            )
    )
    private boolean cancelOverlayFeature(BoggedEntityRenderer instance, FeatureRenderer featureRenderer) {
        return false;
    }
}

@Mixin(ChickenEntityRenderer.class)
abstract class ChickenEntityRendererMixin {
    @Inject(
            method = "getTexture(Lnet/minecraft/entity/passive/ChickenEntity;)Lnet/minecraft/util/Identifier;",
            at = @At("RETURN"),
            cancellable = true
    )
    public void getTexture(ChickenEntity chickenEntity, CallbackInfoReturnable<Identifier> cir){
        cir.setReturnValue(((IVariantMixinEntity)(Object)chickenEntity).getTextureId());
    }
}

@Mixin(CowEntityRenderer.class)
abstract class CowEntityRendererMixin {
    @Inject(
            method = "getTexture(Lnet/minecraft/entity/passive/CowEntity;)Lnet/minecraft/util/Identifier;",
            at = @At("RETURN"),
            cancellable = true
    )
    public void getTexture(CowEntity cowEntity, CallbackInfoReturnable<Identifier> cir){
        cir.setReturnValue(((IVariantMixinEntity)(Object)cowEntity).getTextureId());
    }
}

@Mixin(DrownedEntityRenderer.class)
abstract class DrownedEntityRendererMixin {
    @WrapWithCondition(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/DrownedEntityRenderer;addFeature(Lnet/minecraft/client/render/entity/feature/FeatureRenderer;)Z"
            )
    )
    private boolean cancelOverlayFeature(DrownedEntityRenderer instance, FeatureRenderer featureRenderer) {
        return false;
    }

    @Inject(
            method = "getTexture",
            at = @At("RETURN"),
            cancellable = true
    )
    public void getTexture(ZombieEntity zombieEntity, CallbackInfoReturnable<Identifier> cir){
        cir.setReturnValue(((IVariantMixinEntity)(Object)zombieEntity).getTextureId());
    }
}

@Mixin(GoatEntityRenderer.class)
abstract class GoatEntityRendererMixin {
    @Inject(
            method = "getTexture(Lnet/minecraft/entity/passive/GoatEntity;)Lnet/minecraft/util/Identifier;",
            at = @At("RETURN"),
            cancellable = true
    )
    public void getTexture(GoatEntity goatEntity, CallbackInfoReturnable<Identifier> cir){
        cir.setReturnValue(((IVariantMixinEntity)(Object)goatEntity).getTextureId());
    }
}

@Mixin(PigEntityRenderer.class)
abstract class PigEntityRendererMixin {
    @Inject(
            method = "getTexture(Lnet/minecraft/entity/passive/PigEntity;)Lnet/minecraft/util/Identifier;",
            at = @At("RETURN"),
            cancellable = true
    )
    public void getTexture(PigEntity pigEntity, CallbackInfoReturnable<Identifier> cir){
        cir.setReturnValue(((IVariantMixinEntity)(Object)pigEntity).getTextureId());
    }
}

@Mixin(RabbitEntityRenderer.class)
abstract class RabbitEntityRendererMixin {
    @Inject(
            method = "getTexture(Lnet/minecraft/entity/passive/RabbitEntity;)Lnet/minecraft/util/Identifier;",
            at = @At("HEAD"),
            cancellable = true
    )
    public void getTexture(RabbitEntity rabbitEntity, CallbackInfoReturnable<Identifier> cir){
        if (Formatting.strip(rabbitEntity.getName().getString()).equals("Toast")) {
            cir.setReturnValue(Identifier.ofVanilla("entity/rabbit/rabbit_toast"));
        } else {
            cir.setReturnValue(((IVariantMixinEntity)(Object)rabbitEntity).getTextureId());
        }
    }
}

@Mixin(SheepEntityRenderer.class)
abstract class SheepEntityRendererMixin<T extends LivingEntity, M extends EntityModel<T>> extends MobEntityRenderer{
    @Shadow
    private static final Identifier TEXTURE = Identifier.ofVanilla("textures/entity/sheep/sheep_main.png");
    @Unique
    private static final Identifier DYE_TEXTURE = Identifier.ofVanilla("textures/entity/sheep/sheep_dyed.png");

    public SheepEntityRendererMixin(EntityRendererFactory.Context context, EntityModel entityModel, float f) {
        super(context, entityModel, f);
    }

    @WrapWithCondition(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/SheepEntityRenderer;addFeature(Lnet/minecraft/client/render/entity/feature/FeatureRenderer;)Z"
            )
    )
    private boolean cancelOverlayFeature(SheepEntityRenderer instance, FeatureRenderer featureRenderer) {
        return false;
    }

    @Inject(
            method = "getTexture(Lnet/minecraft/entity/passive/SheepEntity;)Lnet/minecraft/util/Identifier;",
            at = @At("RETURN"),
            cancellable = true
    )
    public void getTexture(SheepEntity sheepEntity, CallbackInfoReturnable<Identifier> cir){
        cir.setReturnValue(((IVariantMixinSheepEntity)(Object)sheepEntity).getTextureId());
    }

    @Unique
    public Identifier getDyedTexture(SheepEntity sheepEntity) {
        return ((IVariantMixinSheepEntity)(Object)sheepEntity).getDyedTextureId();
    }

//    @Override
//    public void render(LivingEntity entity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
//        // Uhoh
//    }

    @Unique
    protected RenderLayer getRenderLayer(Identifier identifier, boolean showBody, boolean translucent, boolean showOutline) {
        if (translucent) {
            return RenderLayer.getItemEntityTranslucentCull(identifier);
        } else if (showBody) {
            return this.model.getLayer(identifier);
        } else {
            return showOutline ? RenderLayer.getOutline(identifier) : null;
        }
    }
}

@Mixin(StrayEntityRenderer.class)
abstract class StrayEntityRendererMixin {
    @WrapWithCondition(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/StrayEntityRenderer;addFeature(Lnet/minecraft/client/render/entity/feature/FeatureRenderer;)Z"
            )
    )
    private boolean cancelOverlayFeature(StrayEntityRenderer instance, FeatureRenderer featureRenderer) {
        return false;
    }
}
