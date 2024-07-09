package gay.beegirl.Mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.client.render.entity.BoggedEntityRenderer;
import net.minecraft.client.render.entity.ChickenEntityRenderer;
import net.minecraft.client.render.entity.DrownedEntityRenderer;
import net.minecraft.client.render.entity.StrayEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BoggedEntityRenderer.class)
class BoggedEntityRendererMixin {
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
class ChickenEntityRendererMixin {
    @Shadow
    private static final Identifier TEXTURE = Identifier.ofVanilla("textures/entity/chicken/chicken.png");
}
@Mixin(DrownedEntityRenderer.class)
class DrownedEntityRendererMixin {
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
@Mixin(StrayEntityRenderer.class)
class StrayEntityRendererMixin {
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
