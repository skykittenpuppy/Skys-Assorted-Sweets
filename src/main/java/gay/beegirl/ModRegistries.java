package gay.beegirl;

import gay.beegirl.Entity.Variants.*;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModRegistries {
    public static RegistryKey<Registry<ChickenVariant>> CHICKEN_VARIANT_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("chicken_variant"));
    public static RegistryKey<Registry<CowVariant>> COW_VARIANT_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("cow_variant"));
    public static RegistryKey<Registry<DrownedVariant>> DROWNED_VARIANT_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("drowned_variant"));
    public static RegistryKey<Registry<GoatVariant>> GOAT_VARIANT_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("goat_variant"));
    public static RegistryKey<Registry<PigVariant>> PIG_VARIANT_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("pig_variant"));
    public static RegistryKey<Registry<RabbitVariant>> RABBIT_VARIANT_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("rabbit_variant"));
    public static RegistryKey<Registry<SheepVariant>> SHEEP_VARIANT_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("sheep_variant"));
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
}
