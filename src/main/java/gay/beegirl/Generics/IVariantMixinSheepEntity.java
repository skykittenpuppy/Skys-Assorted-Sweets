package gay.beegirl.Generics;

import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public interface IVariantMixinSheepEntity<T extends VariantClass> {
    RegistryEntry<T> getVariant();
    void setVariant(RegistryEntry<T> registryEntry);
    Identifier getTextureId();
    Identifier getDyedTextureId();
    DyeColor getChildColor(AnimalEntity firstParent, AnimalEntity secondParent);
}
