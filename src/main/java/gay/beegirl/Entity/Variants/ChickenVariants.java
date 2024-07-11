package gay.beegirl.Entity.Variants;

import gay.beegirl.ModInit;
import gay.beegirl.ModRegistries;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.Objects;
import java.util.Optional;

public class ChickenVariants {
    public static final RegistryKey<ChickenVariant> AMBER = of(Identifier.of(ModInit.MOD_ID, "amber"));
    public static final RegistryKey<ChickenVariant> BRONZED = of(Identifier.of(ModInit.MOD_ID, "bronzed"));
    public static final RegistryKey<ChickenVariant> FANCY = of(Identifier.of(ModInit.MOD_ID, "fancy"));
    public static final RegistryKey<ChickenVariant> GOLD_CRESTED = of(Identifier.of(ModInit.MOD_ID, "gold_crested"));
    public static final RegistryKey<ChickenVariant> MALLARD = of(Identifier.of(ModInit.MOD_ID, "mallard"));
    public static final RegistryKey<ChickenVariant> MIDNIGHT = of(Identifier.of(ModInit.MOD_ID, "midnight"));
    public static final RegistryKey<ChickenVariant> SKEWBALD = of(Identifier.of(ModInit.MOD_ID, "skewbald"));
    public static final RegistryKey<ChickenVariant> STORMY = of(Identifier.of(ModInit.MOD_ID, "stormy"));
    public static final RegistryKey<ChickenVariant> WHITE = of(Identifier.of(ModInit.MOD_ID, "white"));
    public static final RegistryKey<ChickenVariant> DEFAULT;

    private static RegistryKey<ChickenVariant> of(Identifier id) {
        return RegistryKey.of(ModRegistries.CHICKEN_VARIANT_KEY, id);
    }

    static void register(Registerable<ChickenVariant> registry, RegistryKey<ChickenVariant> key, Identifier textureName) {
        registry.register(key, new ChickenVariant(textureName.withPrefixedPath("entity/chicken/")));
    }

    public static RegistryEntry<ChickenVariant> getRandom(DynamicRegistryManager dynamicRegistryManager) {
        Registry<ChickenVariant> registry = dynamicRegistryManager.get(ModRegistries.CHICKEN_VARIANT_KEY);
        Optional<RegistryEntry.Reference<ChickenVariant>> var10000 = registry.streamEntries().findAny();
        Objects.requireNonNull(registry);
        return var10000.or(registry::getDefaultEntry).orElseThrow();
    }

    public static void bootstrap(Registerable<ChickenVariant> registry) {
        register(registry, AMBER, Identifier.of(ModInit.MOD_ID, "chicken_amber"));
        register(registry, BRONZED , Identifier.of(ModInit.MOD_ID, "chicken_bronzed"));
        register(registry, FANCY, Identifier.of(ModInit.MOD_ID, "chicken_fancy"));
        register(registry, GOLD_CRESTED,  Identifier.of(ModInit.MOD_ID, "chicken_gold_crested"));
        register(registry, MALLARD,  Identifier.of(ModInit.MOD_ID, "chicken_mallard"));
        register(registry, MIDNIGHT,  Identifier.of(ModInit.MOD_ID, "chicken_midnight"));
        register(registry, SKEWBALD,  Identifier.of(ModInit.MOD_ID, "chicken_skewbald"));
        register(registry, STORMY, Identifier.of(ModInit.MOD_ID, "chicken_stormy"));
        register(registry, WHITE,  Identifier.ofVanilla("chicken"));
    }

    static {
        DEFAULT = WHITE;
    }
}
