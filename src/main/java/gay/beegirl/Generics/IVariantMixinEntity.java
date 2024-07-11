package gay.beegirl.Generics;

import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public interface IVariantMixinEntity<T extends VariantClass> {
    RegistryEntry<T> getVariant();
    void setVariant(RegistryEntry<T> registryEntry);
    Identifier getTextureId();
}
