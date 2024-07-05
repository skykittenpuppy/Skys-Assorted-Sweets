package gay.beegirl.mixin;

import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CropBlock.class)
public class CropBlockMixin {
    @Inject(
            method = "getSeedsItem",
            at = @At("HEAD"),
            cancellable = true
    )
    protected void getSeedsItem(CallbackInfoReturnable<ItemConvertible> cir) {
        cir.setReturnValue(
                ((CropBlock)(Object)this).asItem()
        );
    }
}
