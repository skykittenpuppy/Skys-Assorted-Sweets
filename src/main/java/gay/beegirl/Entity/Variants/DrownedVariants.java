package gay.beegirl.Entity.Variants;

import gay.beegirl.ModInit;
import gay.beegirl.ModRegistries;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.ServerWorldAccess;

public class DrownedVariants {
    public static final RegistryKey<DrownedVariant> CHAIN  = of(Identifier.of(ModInit.MOD_ID, "chain"));
    public static final RegistryKey<DrownedVariant> DARK = of(Identifier.of(ModInit.MOD_ID, "dark"));
    public static final RegistryKey<DrownedVariant> STANDARD = of(Identifier.of(ModInit.MOD_ID, "standard"));
    public static final RegistryKey<DrownedVariant> DEFAULT;

    private static RegistryKey<DrownedVariant> of(Identifier id) {
        return RegistryKey.of(ModRegistries.DROWNED_VARIANT_KEY, id);
    }

    static void register(Registerable<DrownedVariant> registry, RegistryKey<DrownedVariant> key, Identifier textureName) {
        registry.register(key, new DrownedVariant(textureName.withPrefixedPath("entity/zombie/")));
    }

    public static RegistryEntry<DrownedVariant> getRandom(DynamicRegistryManager dynamicRegistryManager, ServerWorldAccess world) {
        Registry<DrownedVariant> registry = dynamicRegistryManager.get(ModRegistries.DROWNED_VARIANT_KEY);
        return registry.getRandom(world.getRandom()).or(registry::getDefaultEntry).orElseThrow();
    }

    public static void bootstrap(Registerable<DrownedVariant> registry) {
        register(registry, CHAIN, Identifier.of(ModInit.MOD_ID, "drowned_chain"));
        register(registry, DARK,  Identifier.of(ModInit.MOD_ID, "drowned_dark"));
        register(registry, STANDARD,  Identifier.ofVanilla("drowned"));
    }

    static {
        DEFAULT = STANDARD;
    }
}
