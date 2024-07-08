package gay.beegirl.Mixin;

import net.minecraft.item.Item;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.item.trim.ArmorTrim;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ArmorTrim.class)
public class ArmorTrimMixin {
    @Final
    @Shadow
    private boolean showInTooltip;

    /* Based heavily off Better-Trim-Tooltips https://modrinth.com/mod/better-trim-tooltips */
    @Inject(method = "appendTooltip", at = @At("HEAD"), cancellable = true)
    private void appendTooltip(Item.TooltipContext context, Consumer<Text> tooltip, TooltipType type, CallbackInfo ci) {
        if (this.showInTooltip) {
            ArmorTrim armorTrim = (ArmorTrim) (Object) this;
            tooltip.accept(Text.literal("")
                    .append(armorTrim.getMaterial().value().description())
                    .append(ScreenTexts.space())
                    .append(armorTrim.getPattern().value().getDescription(armorTrim.getMaterial())));
            ci.cancel();
        }

        //Vanilla Tooltip
        //tooltip.accept(UPGRADE_TEXT);
        //tooltip.accept(ScreenTexts.space().append(((ArmorTrimPattern)this.pattern.value()).getDescription(this.material)));
        //tooltip.accept(ScreenTexts.space().append(((ArmorTrimMaterial)this.material.value()).description()));
    }
}
