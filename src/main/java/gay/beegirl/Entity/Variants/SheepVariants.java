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

public class SheepVariants {
    public static final RegistryKey<SheepVariant> FLECKED = of(Identifier.of(ModInit.MOD_ID, "flecked"));
    public static final RegistryKey<SheepVariant> FUZZY = of(Identifier.of(ModInit.MOD_ID, "fuzzy"));
    public static final RegistryKey<SheepVariant> INKY = of(Identifier.of(ModInit.MOD_ID, "inky"));
    public static final RegistryKey<SheepVariant> LONG_NOSED = of(Identifier.of(ModInit.MOD_ID, "long_nosed"));
    public static final RegistryKey<SheepVariant> PALE = of(Identifier.of(ModInit.MOD_ID, "pale"));
    public static final RegistryKey<SheepVariant> PATCHED = of(Identifier.of(ModInit.MOD_ID, "patched"));
    public static final RegistryKey<SheepVariant> ROCKY = of(Identifier.of(ModInit.MOD_ID, "rocky"));
    public static final RegistryKey<SheepVariant> DEFAULT;

    private static RegistryKey<SheepVariant> of(Identifier id) {
        return RegistryKey.of(ModRegistries.SHEEP_VARIANT_KEY, id);
    }

    static void register(Registerable<SheepVariant> registry, RegistryKey<SheepVariant> key, Identifier textureName) {
        textureName = textureName.withPrefixedPath("entity/sheep/");
        registry.register(key, new SheepVariant(textureName.withSuffixedPath("_main"), textureName.withSuffixedPath("_dyed")));
    }

    public static RegistryEntry<SheepVariant> getRandom(DynamicRegistryManager dynamicRegistryManager) {
        Registry<SheepVariant> registry = dynamicRegistryManager.get(ModRegistries.SHEEP_VARIANT_KEY);
        Optional<RegistryEntry.Reference<SheepVariant>> var10000 = registry.streamEntries().findAny();
        Objects.requireNonNull(registry);
        return var10000.or(registry::getDefaultEntry).orElseThrow();
    }

    public static void bootstrap(Registerable<SheepVariant> registry) {
        register(registry, FLECKED, Identifier.of(ModInit.MOD_ID, "sheep_flecked"));
        register(registry, FUZZY , Identifier.of(ModInit.MOD_ID, "sheep_fuzzy"));
        register(registry, INKY, Identifier.of(ModInit.MOD_ID, "sheep_inky"));
        register(registry, LONG_NOSED,  Identifier.of(ModInit.MOD_ID, "sheep_long_nosed"));
        register(registry, PATCHED,  Identifier.of(ModInit.MOD_ID, "sheep_patched"));
        register(registry, ROCKY,  Identifier.of(ModInit.MOD_ID, "sheep_rocky"));
        register(registry, PALE,  Identifier.ofVanilla("sheep"));
    }

    static {
        DEFAULT = PALE;
    }
}
