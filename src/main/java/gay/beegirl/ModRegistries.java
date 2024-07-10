package gay.beegirl;

import gay.beegirl.Entity.CowVariant;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModRegistries {
    public static RegistryKey<Registry<CowVariant>> COW_VARIANT_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("cow_variant"));
    public static TrackedDataHandler<RegistryEntry<CowVariant>> COW_VARIANT_TRACKED;
    static{
        DynamicRegistries.registerSynced(COW_VARIANT_KEY, CowVariant.CODEC);
    }
}
