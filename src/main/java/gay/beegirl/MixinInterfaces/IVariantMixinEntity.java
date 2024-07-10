package gay.beegirl.MixinInterfaces;

import gay.beegirl.Entity.CowVariant;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public interface IVariantMixinEntity {
    RegistryEntry<CowVariant> getVariant();
    void setVariant(RegistryEntry<CowVariant> registryEntry);
    Identifier getTextureId();
}
