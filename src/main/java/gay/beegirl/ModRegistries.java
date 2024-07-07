package gay.beegirl;

import gay.beegirl.Entity.CowVariant;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModRegistries {
    public static final RegistryKey<Registry<CowVariant>> COW_VARIANT_KEY = RegistryKey.ofRegistry(Identifier.of(ModInit.MOD_ID, "cow_variant"));
    public static final TrackedDataHandler<RegistryEntry<CowVariant>> COW_VARIANT_TRACKED;
    static {
        COW_VARIANT_TRACKED = TrackedDataHandler.create(CowVariant.ENTRY_PACKET_CODEC);
        TrackedDataHandlerRegistry.register(COW_VARIANT_TRACKED);

    }
    public static final Registry<CowVariant> COW_VARIANT_REGISTRY = FabricRegistryBuilder
            .createSimple(COW_VARIANT_KEY)
            .attribute(RegistryAttribute.SYNCED)
            .buildAndRegister();
}
