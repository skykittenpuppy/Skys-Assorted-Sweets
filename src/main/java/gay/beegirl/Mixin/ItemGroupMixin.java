package gay.beegirl.Mixin;

import gay.beegirl.Generics.IToggleableItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.resource.featuretoggle.ToggleableFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ItemGroup.class)
public class ItemGroupMixin implements ToggleableFeature, IToggleableItemGroup {
    @Unique
    public FeatureSet requiredFeatures = FeatureFlags.VANILLA_FEATURES;

    @Override
    public FeatureSet getRequiredFeatures() {
        return this.requiredFeatures;
    }

    @Override
    public void setRequiredFeatures(FeatureFlag... features) {
        this.requiredFeatures = FeatureFlags.FEATURE_MANAGER.featureSetOf(features);
    }
}
