package gay.beegirl.Entity.Variants;

import gay.beegirl.ModInit;
import gay.beegirl.Registries.ModRegistries;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.ServerWorldAccess;

import java.util.List;

public class RabbitVariants {
    public static final RegistryKey<RabbitVariant> BLACK = of(Identifier.of(ModInit.MOD_ID, "black"));
    public static final RegistryKey<RabbitVariant> BOLD_STRIPED = of(Identifier.of(ModInit.MOD_ID, "bold_striped"));
    public static final RegistryKey<RabbitVariant> BROWN = of(Identifier.of(ModInit.MOD_ID, "brown"));
    public static final RegistryKey<RabbitVariant> FRECKLED = of(Identifier.of(ModInit.MOD_ID, "freckled"));
    public static final RegistryKey<RabbitVariant> GOLD = of(Identifier.of(ModInit.MOD_ID, "gold"));
    public static final RegistryKey<RabbitVariant> HARLEQUIN = of(Identifier.of(ModInit.MOD_ID, "harlequin"));
    public static final RegistryKey<RabbitVariant> MUDDY_FOOT = of(Identifier.of(ModInit.MOD_ID, "muddy_foot"));
    public static final RegistryKey<RabbitVariant> SALT = of(Identifier.of(ModInit.MOD_ID, "salt"));
    public static final RegistryKey<RabbitVariant> VESTED = of(Identifier.of(ModInit.MOD_ID, "vested"));
    public static final RegistryKey<RabbitVariant> WHITE_SPLOTCHED = of(Identifier.of(ModInit.MOD_ID, "white_splotched"));
    public static final RegistryKey<RabbitVariant> WHITE = of(Identifier.of(ModInit.MOD_ID, "white"));
    public static final RegistryKey<RabbitVariant> CAERBANNOG = of(Identifier.of(ModInit.MOD_ID, "caerbannog"));
    public static final RegistryKey<RabbitVariant> DEFAULT;

    private static RegistryKey<RabbitVariant> of(Identifier id) {
        return RegistryKey.of(ModRegistries.RABBIT_VARIANT_KEY, id);
    }

    static void register(Registerable<RabbitVariant> registry, RegistryKey<RabbitVariant> key, Identifier textureName) {
        registry.register(key, new RabbitVariant(textureName.withPrefixedPath("entity/rabbit/")));
    }

    public static RegistryEntry<RabbitVariant> getRandom(DynamicRegistryManager dynamicRegistryManager, ServerWorldAccess world) {
        Registry<RabbitVariant> registry = dynamicRegistryManager.get(ModRegistries.RABBIT_VARIANT_KEY);
        List<RegistryEntry.Reference<RabbitVariant>> filtered = registry.streamEntries()
                .filter((entry) -> !entry.registryKey().equals(CAERBANNOG))
                .toList();
        return filtered.get(world.getRandom().nextInt(filtered.size()));

    }

    public static void bootstrap(Registerable<RabbitVariant> registry) {
        register(registry, BOLD_STRIPED , Identifier.of(ModInit.MOD_ID, "rabbit_bold_striped"));
        register(registry, FRECKLED,  Identifier.of(ModInit.MOD_ID, "rabbit_freckled"));
        register(registry, HARLEQUIN,  Identifier.of(ModInit.MOD_ID, "rabbit_harlequin"));
        register(registry, MUDDY_FOOT,  Identifier.of(ModInit.MOD_ID, "rabbit_muddy_foot"));
        register(registry, VESTED,  Identifier.of(ModInit.MOD_ID, "rabbit_vested"));
        register(registry, BLACK,  Identifier.ofVanilla("rabbit_black"));
        register(registry, BROWN,  Identifier.ofVanilla("rabbit_brown"));
        register(registry, GOLD,  Identifier.ofVanilla("rabbit_gold"));
        register(registry, SALT,  Identifier.ofVanilla("rabbit_salt"));
        register(registry, WHITE_SPLOTCHED,  Identifier.ofVanilla("rabbit_white_splotched"));
        register(registry, WHITE,  Identifier.ofVanilla("rabbit_white"));
        register(registry, CAERBANNOG,  Identifier.ofVanilla("rabbit_caerbannog"));
    }

    static {
        DEFAULT = SALT;
    }
}
