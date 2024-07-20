package gay.beegirl.Mixin;

import gay.beegirl.ModFeatureFlags;
import gay.beegirl.ModInit;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureManager;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(FeatureFlags.class)
public class FeatureFlagsMixin {
    @Inject(
            method = "<clinit>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/resource/featuretoggle/FeatureManager$Builder;build()Lnet/minecraft/resource/featuretoggle/FeatureManager;",
                    shift = At.Shift.BEFORE
            ),
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private static void injected(CallbackInfo ci, FeatureManager.Builder builder) {
        ModFeatureFlags.ECHOING_VOID = builder.addFlag(Identifier.of(ModInit.MOD_ID, "echoing_void"));
    }
}