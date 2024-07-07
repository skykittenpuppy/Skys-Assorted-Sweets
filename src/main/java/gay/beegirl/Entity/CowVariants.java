package gay.beegirl.Entity;

import gay.beegirl.ModRegistries;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

import java.util.Objects;
import java.util.Optional;

public class CowVariants {
    //public static final RegistryKey<CowVariant> ALBINO = of(Identifier.of(ModInit.MOD_ID, "albino"));
    //public static final RegistryKey<CowVariant> ASHEN  = of(Identifier.of(ModInit.MOD_ID, "ashen"));
    //public static final RegistryKey<CowVariant> COOKIE = of(Identifier.of(ModInit.MOD_ID, "cookie"));
    public static final RegistryKey<CowVariant> BROWN  = of(Identifier.ofVanilla("brown"));
//    public static final RegistryKey<CowVariant> CREAM  = of(Identifier.of(ModInit.MOD_ID, "cream"));
//    public static final RegistryKey<CowVariant> DAIRY  = of(Identifier.of(ModInit.MOD_ID, "dairy"));
//    public static final RegistryKey<CowVariant> PINTO  = of(Identifier.of(ModInit.MOD_ID, "pinto"));
//    public static final RegistryKey<CowVariant> SUNSET = of(Identifier.of(ModInit.MOD_ID, "sunset"));
//    public static final RegistryKey<CowVariant> UMBRA  = of(Identifier.of(ModInit.MOD_ID, "umbra"));
//    public static final RegistryKey<CowVariant> WOOLY  = of(Identifier.of(ModInit.MOD_ID, "wooly"));
    public static final RegistryKey<CowVariant> DEFAULT;

    private static RegistryKey<CowVariant> of(Identifier id) {
        return RegistryKey.of(ModRegistries.COW_VARIANT_KEY, id);
    }

    static void register(Registerable<CowVariant> registry, RegistryKey<CowVariant> key, String textureName, RegistryKey<Biome> biome) {
        register(registry, key, textureName, RegistryEntryList.of(registry.getRegistryLookup(RegistryKeys.BIOME).getOrThrow(biome)));
    }

    static void register(Registerable<CowVariant> registry, RegistryKey<CowVariant> key, String textureName, TagKey<Biome> biomeTag) {
        register(registry, key, textureName, registry.getRegistryLookup(RegistryKeys.BIOME).getOrThrow(biomeTag));
    }

    static void register(Registerable<CowVariant> registry, RegistryKey<CowVariant> key, String textureName, RegistryEntryList<Biome> biomes) {
        Identifier identifier = Identifier.ofVanilla("entity/cow/" + textureName);
        registry.register(key, new CowVariant(identifier, biomes));
    }

    public static RegistryEntry<CowVariant> fromBiome(DynamicRegistryManager dynamicRegistryManager, RegistryEntry<Biome> biome) {
        Registry<CowVariant> registry = dynamicRegistryManager.get(ModRegistries.COW_VARIANT_KEY);
        Optional<RegistryEntry.Reference<CowVariant>> var10000 = registry.streamEntries().filter(
                (entry) -> entry.value().getBiomes().contains(biome)).findFirst()
                .or(() -> registry.getEntry(DEFAULT));
        Objects.requireNonNull(registry);
        return var10000.or(registry::getDefaultEntry).orElseThrow();
    }

    public static void bootstrap(Registerable<CowVariant> registry) {
//        register(registry, ALBINO, "cow", BiomeTags.IS_OVERWORLD);
//        register(registry, ASHEN , "cow", BiomeTags.IS_OVERWORLD);
//        register(registry, COOKIE, "cow", BiomeTags.IS_OVERWORLD);
        register(registry, BROWN,  "cow", BiomeTags.IS_OVERWORLD);
//        register(registry, CREAM,  "cow", BiomeTags.IS_OVERWORLD);
//        register(registry, DAIRY,  "cow", BiomeTags.IS_OVERWORLD);
//        register(registry, PINTO,  "cow", BiomeTags.IS_OVERWORLD);
//        register(registry, SUNSET, "cow", BiomeTags.IS_OVERWORLD);
//        register(registry, UMBRA,  "cow", BiomeTags.IS_OVERWORLD);
//        register(registry, WOOLY,  "cow", BiomeTags.IS_OVERWORLD);
    }

    static {
        DEFAULT = BROWN;
    }
}
