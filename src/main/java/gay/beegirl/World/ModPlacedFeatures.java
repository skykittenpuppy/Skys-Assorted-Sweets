package gay.beegirl.World;

import gay.beegirl.ModInit;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(ModInit.MOD_ID, name));
    }
    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?,?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(context, RUBY_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RUBY_ORE_KEY),
                modifiersWithCount(100, HeightRangePlacementModifier.trapezoid(
                        YOffset.fixed(-16),
                        YOffset.fixed(480))));
        register(context, SAPPHIRE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAPPHIRE_ORE_KEY),
                modifiersWithCount(100, HeightRangePlacementModifier.trapezoid(
                        YOffset.fixed(-16),
                        YOffset.fixed(480))));
        register(context, TOPAZ_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TOPAZ_ORE_KEY),
                modifiersWithCount(100, HeightRangePlacementModifier.trapezoid(
                        YOffset.fixed(-16),
                        YOffset.fixed(480))));
        register(context, CITRINE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CITRINE_ORE_KEY),
                modifiersWithCount(100, HeightRangePlacementModifier.trapezoid(
                        YOffset.fixed(-16),
                        YOffset.fixed(480))));
        register(context, ALEXANDRITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ALEXANDRITE_ORE_KEY),
                modifiersWithCount(100, HeightRangePlacementModifier.trapezoid(
                        YOffset.fixed(-16),
                        YOffset.fixed(480))));
        register(context, SPINEL_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SPINEL_ORE_KEY),
                modifiersWithCount(100, HeightRangePlacementModifier.trapezoid(
                        YOffset.fixed(-16),
                        YOffset.fixed(480))));
        register(context, WHITE_QUARTZ_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WHITE_QUARTZ_ORE_KEY),
                modifiersWithCount(16, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));
    }
    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    public static final RegistryKey<PlacedFeature> RUBY_ORE_PLACED_KEY = registerKey("ore_ruby");
    public static final RegistryKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY = registerKey("ore_sapphire");
    public static final RegistryKey<PlacedFeature> TOPAZ_ORE_PLACED_KEY = registerKey("ore_topaz");
    public static final RegistryKey<PlacedFeature> CITRINE_ORE_PLACED_KEY = registerKey("ore_citrine");
    public static final RegistryKey<PlacedFeature> ALEXANDRITE_ORE_PLACED_KEY = registerKey("ore_alexandrite");
    public static final RegistryKey<PlacedFeature> SPINEL_ORE_PLACED_KEY = registerKey("ore_spinel");
    public static final RegistryKey<PlacedFeature> WHITE_QUARTZ_ORE_PLACED_KEY = registerKey("ore_white_quartz");
}
