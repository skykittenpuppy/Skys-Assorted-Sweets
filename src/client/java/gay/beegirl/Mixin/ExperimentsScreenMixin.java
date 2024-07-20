package gay.beegirl.Mixin;

import it.unimi.dsi.fastutil.objects.Object2BooleanMap;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.ExperimentsScreen;
import net.minecraft.resource.ResourcePackManager;
import net.minecraft.resource.ResourcePackProfile;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ExperimentsScreen.class)
public class ExperimentsScreenMixin {
    @Final
    @Shadow
    private Object2BooleanMap<ResourcePackProfile> experiments;

    @Inject(
            method = "<init>",
            at = @At("TAIL")
    )
    private void injected(Screen parent, ResourcePackManager resourcePackManager, Consumer applier, CallbackInfo ci) {
        //experiments.put()
    }
}