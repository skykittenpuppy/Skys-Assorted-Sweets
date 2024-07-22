package gay.beegirl.Generics;

import net.minecraft.resource.featuretoggle.FeatureFlag;

public interface IToggleableItemGroup {
    void setRequiredFeatures(FeatureFlag... features);
}
