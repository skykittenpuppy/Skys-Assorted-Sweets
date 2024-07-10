package gay.beegirl.Mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import gay.beegirl.MixinInterfaces.IVariantMixinEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.*;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.SheepEntity;
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
    @Shadow
    private static final Identifier TEXTURE = Identifier.ofVanilla("textures/entity/chicken/chicken.png");
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

    @Shadow
    public abstract Identifier getTexture(SheepEntity sheepEntity);

    @Unique
    public Identifier getDyedTexture(SheepEntity sheepEntity) {
        return DYE_TEXTURE;
    }

    @Override
    public void render(LivingEntity entity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        // Uhoh
    }

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
