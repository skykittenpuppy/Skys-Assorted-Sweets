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

public class PigVariants {
    public static final RegistryKey<PigVariant> MOTTLED = of(Identifier.of(ModInit.MOD_ID, "mottled"));
    public static final RegistryKey<PigVariant> MUDDY = of(Identifier.of(ModInit.MOD_ID, "muddy"));
    public static final RegistryKey<PigVariant> PALE = of(Identifier.of(ModInit.MOD_ID, "pale"));
    public static final RegistryKey<PigVariant> PIEBALD = of(Identifier.of(ModInit.MOD_ID, "piebald"));
    public static final RegistryKey<PigVariant> PINK = of(Identifier.of(ModInit.MOD_ID, "pink"));
    public static final RegistryKey<PigVariant> PINK_FOOTED = of(Identifier.of(ModInit.MOD_ID, "pink_footed"));
    public static final RegistryKey<PigVariant> SOOTY = of(Identifier.of(ModInit.MOD_ID, "sooty"));
    public static final RegistryKey<PigVariant> SPOTTED = of(Identifier.of(ModInit.MOD_ID, "spotted"));
    
    public static final RegistryKey<PigVariant> DEFAULT;

    private static RegistryKey<PigVariant> of(Identifier id) {
        return RegistryKey.of(ModRegistries.PIG_VARIANT_KEY, id);
    }

    static void register(Registerable<PigVariant> registry, RegistryKey<PigVariant> key, Identifier textureName) {
        registry.register(key, new PigVariant(textureName.withPrefixedPath("entity/pig/")));
    }

    public static RegistryEntry<PigVariant> getRandom(DynamicRegistryManager dynamicRegistryManager) {
        Registry<PigVariant> registry = dynamicRegistryManager.get(ModRegistries.PIG_VARIANT_KEY);
        Optional<RegistryEntry.Reference<PigVariant>> var10000 = registry.streamEntries().findAny();
        Objects.requireNonNull(registry);
        return var10000.or(registry::getDefaultEntry).orElseThrow();
    }

    public static void bootstrap(Registerable<PigVariant> registry) {
        register(registry, MOTTLED, Identifier.of(ModInit.MOD_ID, "pig_mottled"));
        register(registry, MUDDY , Identifier.of(ModInit.MOD_ID, "pig_muddy"));
        register(registry, PALE, Identifier.of(ModInit.MOD_ID, "pig_pale"));
        register(registry, PIEBALD,  Identifier.of(ModInit.MOD_ID, "pig_piebald"));
        register(registry, PINK_FOOTED,  Identifier.of(ModInit.MOD_ID, "pig_pink_footed"));
        register(registry, SOOTY,  Identifier.of(ModInit.MOD_ID, "pig_sooty"));
        register(registry, SPOTTED, Identifier.of(ModInit.MOD_ID, "pig_spotted"));
        register(registry, PINK,  Identifier.ofVanilla("pig"));
    }

    static {
        DEFAULT = PINK;
    }
}
