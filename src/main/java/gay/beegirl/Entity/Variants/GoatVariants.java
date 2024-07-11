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

public class GoatVariants {
    public static final RegistryKey<GoatVariant> BLACK = of(Identifier.of(ModInit.MOD_ID, "black"));
    public static final RegistryKey<GoatVariant> WHITE = of(Identifier.of(ModInit.MOD_ID, "white"));
    public static final RegistryKey<GoatVariant> DEFAULT;

    private static RegistryKey<GoatVariant> of(Identifier id) {
        return RegistryKey.of(ModRegistries.GOAT_VARIANT_KEY, id);
    }

    static void register(Registerable<GoatVariant> registry, RegistryKey<GoatVariant> key, Identifier textureName) {
        registry.register(key, new GoatVariant(textureName.withPrefixedPath("entity/goat/")));
    }

    public static RegistryEntry<GoatVariant> getRandom(DynamicRegistryManager dynamicRegistryManager) {
        Registry<GoatVariant> registry = dynamicRegistryManager.get(ModRegistries.GOAT_VARIANT_KEY);
        Optional<RegistryEntry.Reference<GoatVariant>> var10000 = registry.streamEntries().findAny();
        Objects.requireNonNull(registry);
        return var10000.or(registry::getDefaultEntry).orElseThrow();
    }

    public static void bootstrap(Registerable<GoatVariant> registry) {
        register(registry, BLACK, Identifier.of(ModInit.MOD_ID, "goat_black"));
        register(registry, WHITE,  Identifier.ofVanilla("goat"));
    }

    static {
        DEFAULT = WHITE;
    }
}
