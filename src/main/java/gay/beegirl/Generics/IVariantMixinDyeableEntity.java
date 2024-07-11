package gay.beegirl.Generics;

import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public interface IVariantMixinDyeableEntity<T extends VariantClass> {
    RegistryEntry<T> getVariant();
    void setVariant(RegistryEntry<T> registryEntry);
    Identifier getTextureId();
    Identifier getDyedTextureId();
}
