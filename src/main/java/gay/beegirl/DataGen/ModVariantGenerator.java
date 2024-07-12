package gay.beegirl.DataGen;

import gay.beegirl.ModRegistries;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModVariantGenerator extends FabricDynamicRegistryProvider {
    public ModVariantGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        entries.addAll(registries.getWrapperOrThrow(ModRegistries.CHICKEN_VARIANT_KEY));
        entries.addAll(registries.getWrapperOrThrow(ModRegistries.COW_VARIANT_KEY));
        entries.addAll(registries.getWrapperOrThrow(ModRegistries.DROWNED_VARIANT_KEY));
        entries.addAll(registries.getWrapperOrThrow(ModRegistries.GOAT_VARIANT_KEY));
        entries.addAll(registries.getWrapperOrThrow(ModRegistries.PIG_VARIANT_KEY));
        //entries.addAll(registries.getWrapperOrThrow(ModRegistries.RABBIT_VARIANT_KEY));
        entries.addAll(registries.getWrapperOrThrow(ModRegistries.SHEEP_VARIANT_KEY));
    }

    @Override
    public String getName() {
        return "Variants";
    }
}
