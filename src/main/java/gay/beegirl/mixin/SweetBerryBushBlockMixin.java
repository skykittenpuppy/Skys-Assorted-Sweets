package gay.beegirl.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SweetBerryBushBlock.class)
public class SweetBerryBushBlockMixin {
    @Inject(
            method = "getPickStack",
            at = @At("HEAD"),
            cancellable = true
    )
    protected void getPickStack(CallbackInfoReturnable<ItemStack> cir) {
        cir.setReturnValue(
                new ItemStack(((SweetBerryBushBlock)(Object)this).asItem())
        );
    }

    @Inject(
            method = "onEntityCollision",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"
            ),
            cancellable = true
    )
    protected void allowCarefulSteps(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo ci) {
        if (entity.isSneaking()) {
            ci.cancel();
        }
    }

    @ModifyArg(
            method = "onUse",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/ItemStack;<init>(Lnet/minecraft/item/ItemConvertible;I)V"
            ),
            index = 0
    )
    private ItemConvertible inject(ItemConvertible item){
        return ((SweetBerryBushBlock)(Object)this).asItem();
    }
}
