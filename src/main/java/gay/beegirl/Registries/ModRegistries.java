package gay.beegirl.Registries;

import gay.beegirl.Block.ModBlocks;
import gay.beegirl.Entity.Variants.*;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModRegistries {
    public static RegistryKey<Registry<ChickenVariant>> CHICKEN_VARIANT_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("variant/chicken"));
    public static RegistryKey<Registry<CowVariant>> COW_VARIANT_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("variant/cow"));
    public static RegistryKey<Registry<DrownedVariant>> DROWNED_VARIANT_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("variant/drowned"));
    public static RegistryKey<Registry<GoatVariant>> GOAT_VARIANT_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("variant/goat"));
    public static RegistryKey<Registry<PigVariant>> PIG_VARIANT_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("variant/pig"));
    public static RegistryKey<Registry<RabbitVariant>> RABBIT_VARIANT_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("variant/rabbit"));
    public static RegistryKey<Registry<SheepVariant>> SHEEP_VARIANT_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("variant/sheep"));
    public static TrackedDataHandler<RegistryEntry<ChickenVariant>> CHICKEN_VARIANT_TRACKED;
    public static TrackedDataHandler<RegistryEntry<CowVariant>> COW_VARIANT_TRACKED;
    public static TrackedDataHandler<RegistryEntry<DrownedVariant>> DROWNED_VARIANT_TRACKED;
    public static TrackedDataHandler<RegistryEntry<GoatVariant>> GOAT_VARIANT_TRACKED;
    public static TrackedDataHandler<RegistryEntry<PigVariant>> PIG_VARIANT_TRACKED;
    public static TrackedDataHandler<RegistryEntry<RabbitVariant>> RABBIT_VARIANT_TRACKED;
    public static TrackedDataHandler<RegistryEntry<SheepVariant>> SHEEP_VARIANT_TRACKED;
    static{
        DynamicRegistries.registerSynced(CHICKEN_VARIANT_KEY, ChickenVariant.CODEC);
        DynamicRegistries.registerSynced(COW_VARIANT_KEY, CowVariant.CODEC);
        DynamicRegistries.registerSynced(DROWNED_VARIANT_KEY, DrownedVariant.CODEC);
        DynamicRegistries.registerSynced(GOAT_VARIANT_KEY, GoatVariant.CODEC);
        DynamicRegistries.registerSynced(PIG_VARIANT_KEY, PigVariant.CODEC);
        DynamicRegistries.registerSynced(RABBIT_VARIANT_KEY, RabbitVariant.CODEC);
        DynamicRegistries.registerSynced(SHEEP_VARIANT_KEY, SheepVariant.CODEC);
    }

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.EDGEHANGER_LOG, ModBlocks.EDGEHANGER_LOG_STRIPPED);
        StrippableBlockRegistry.register(ModBlocks.HARMONIC_LOG, ModBlocks.HARMONIC_LOG_STRIPPED);
    }
}
