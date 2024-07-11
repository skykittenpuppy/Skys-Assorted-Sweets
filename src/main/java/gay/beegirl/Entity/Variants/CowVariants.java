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

public class CowVariants {
    public static final RegistryKey<CowVariant> ALBINO = of(Identifier.of(ModInit.MOD_ID, "albino"));
    public static final RegistryKey<CowVariant> ASHEN  = of(Identifier.of(ModInit.MOD_ID, "ashen"));
    public static final RegistryKey<CowVariant> BROWN  = of(Identifier.of(ModInit.MOD_ID, "brown"));
    public static final RegistryKey<CowVariant> COOKIE = of(Identifier.of(ModInit.MOD_ID, "cookie"));
    public static final RegistryKey<CowVariant> CREAM  = of(Identifier.of(ModInit.MOD_ID, "cream"));
    public static final RegistryKey<CowVariant> DAIRY  = of(Identifier.of(ModInit.MOD_ID, "dairy"));
    public static final RegistryKey<CowVariant> PINTO  = of(Identifier.of(ModInit.MOD_ID, "pinto"));
    public static final RegistryKey<CowVariant> SUNSET = of(Identifier.of(ModInit.MOD_ID, "sunset"));
    public static final RegistryKey<CowVariant> UMBRA  = of(Identifier.of(ModInit.MOD_ID, "umbra"));
    public static final RegistryKey<CowVariant> WOOLY  = of(Identifier.of(ModInit.MOD_ID, "wooly"));
    public static final RegistryKey<CowVariant> DEFAULT;

    private static RegistryKey<CowVariant> of(Identifier id) {
        return RegistryKey.of(ModRegistries.COW_VARIANT_KEY, id);
    }

    static void register(Registerable<CowVariant> registry, RegistryKey<CowVariant> key, Identifier textureName) {
        registry.register(key, new CowVariant(textureName.withPrefixedPath("entity/cow/")));
    }

    public static RegistryEntry<CowVariant> getRandom(DynamicRegistryManager dynamicRegistryManager, ServerWorldAccess world) {
        Registry<CowVariant> registry = dynamicRegistryManager.get(ModRegistries.COW_VARIANT_KEY);
        return registry.getRandom(world.getRandom()).or(registry::getDefaultEntry).orElseThrow();
    }

    public static void bootstrap(Registerable<CowVariant> registry) {
        register(registry, ALBINO, Identifier.of(ModInit.MOD_ID, "cow_albino"));
        register(registry, ASHEN , Identifier.of(ModInit.MOD_ID, "cow_ashen"));
        register(registry, COOKIE, Identifier.of(ModInit.MOD_ID, "cow_cookie"));
        register(registry, CREAM,  Identifier.of(ModInit.MOD_ID, "cow_cream"));
        register(registry, DAIRY,  Identifier.of(ModInit.MOD_ID, "cow_dairy"));
        register(registry, PINTO,  Identifier.of(ModInit.MOD_ID, "cow_pinto"));
        register(registry, SUNSET, Identifier.of(ModInit.MOD_ID, "cow_sunset"));
        register(registry, UMBRA,  Identifier.of(ModInit.MOD_ID, "cow_umbra"));
        register(registry, WOOLY,  Identifier.of(ModInit.MOD_ID, "cow_wooly"));
        register(registry, BROWN,  Identifier.ofVanilla("cow"));
    }

    static {
        DEFAULT = BROWN;
    }
}
