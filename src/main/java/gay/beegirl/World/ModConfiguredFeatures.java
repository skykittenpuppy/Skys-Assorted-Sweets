package gay.beegirl.World;

import gay.beegirl.Block.ModBlocks;
import gay.beegirl.ModInit;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static RegistryKey<ConfiguredFeature<?,?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ModInit.MOD_ID, name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?,?>> context, RegistryKey<ConfiguredFeature<?,?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context) {
        modOres(context);
        //vanillaOres(context);
    }

    public static void vanillaOres(Registerable<ConfiguredFeature<?,?>> context) {
        List<OreFeatureConfig.Target> coalOres =
                List.of(OreFeatureConfig.createTarget(stoneRuleTest, Blocks.COAL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(graniteRuleTest, ModBlocks.GRANITE_COAL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dioriteRuleTest, ModBlocks.DIORITE_COAL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(andesiteRuleTest, ModBlocks.ANDESITE_COAL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dripstoneRuleTest, ModBlocks.DRIPSTONE_COAL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateRuleTest, Blocks.DEEPSLATE_COAL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(tuffRuleTest, ModBlocks.TUFF_COAL_ORE.getDefaultState())
                );
        List<OreFeatureConfig.Target> ironOres =
                List.of(OreFeatureConfig.createTarget(stoneRuleTest, Blocks.IRON_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(graniteRuleTest, ModBlocks.GRANITE_IRON_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dioriteRuleTest, ModBlocks.DIORITE_IRON_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(andesiteRuleTest, ModBlocks.ANDESITE_IRON_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dripstoneRuleTest, ModBlocks.DRIPSTONE_IRON_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateRuleTest, Blocks.DEEPSLATE_IRON_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(tuffRuleTest, ModBlocks.TUFF_IRON_ORE.getDefaultState())
                );
        List<OreFeatureConfig.Target> copperOres =
                List.of(OreFeatureConfig.createTarget(stoneRuleTest, Blocks.COPPER_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(graniteRuleTest, ModBlocks.GRANITE_COPPER_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dioriteRuleTest, ModBlocks.DIORITE_COPPER_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(andesiteRuleTest, ModBlocks.ANDESITE_COPPER_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dripstoneRuleTest, ModBlocks.DRIPSTONE_COPPER_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateRuleTest, Blocks.DEEPSLATE_COPPER_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(tuffRuleTest, ModBlocks.TUFF_COPPER_ORE.getDefaultState())
                );
        List<OreFeatureConfig.Target> goldOres =
                List.of(OreFeatureConfig.createTarget(stoneRuleTest, Blocks.GOLD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(graniteRuleTest, ModBlocks.GRANITE_GOLD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dioriteRuleTest, ModBlocks.DIORITE_GOLD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(andesiteRuleTest, ModBlocks.ANDESITE_GOLD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dripstoneRuleTest, ModBlocks.DRIPSTONE_GOLD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateRuleTest, Blocks.DEEPSLATE_GOLD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(tuffRuleTest, ModBlocks.TUFF_GOLD_ORE.getDefaultState())
                );
        List<OreFeatureConfig.Target> redstoneOres =
                List.of(OreFeatureConfig.createTarget(stoneRuleTest, Blocks.REDSTONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(graniteRuleTest, ModBlocks.GRANITE_REDSTONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dioriteRuleTest, ModBlocks.DIORITE_REDSTONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(andesiteRuleTest, ModBlocks.ANDESITE_REDSTONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dripstoneRuleTest, ModBlocks.DRIPSTONE_REDSTONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateRuleTest, Blocks.DEEPSLATE_REDSTONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(tuffRuleTest, ModBlocks.TUFF_REDSTONE_ORE.getDefaultState())
                );
        List<OreFeatureConfig.Target> emeraldOres =
                List.of(OreFeatureConfig.createTarget(stoneRuleTest, Blocks.EMERALD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(graniteRuleTest, ModBlocks.GRANITE_EMERALD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dioriteRuleTest, ModBlocks.DIORITE_EMERALD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(andesiteRuleTest, ModBlocks.ANDESITE_EMERALD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dripstoneRuleTest, ModBlocks.DRIPSTONE_EMERALD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateRuleTest, Blocks.DEEPSLATE_EMERALD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(tuffRuleTest, ModBlocks.TUFF_EMERALD_ORE.getDefaultState())
                );
        List<OreFeatureConfig.Target> lapisOres =
                List.of(OreFeatureConfig.createTarget(stoneRuleTest, Blocks.LAPIS_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(graniteRuleTest, ModBlocks.GRANITE_LAPIS_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dioriteRuleTest, ModBlocks.DIORITE_LAPIS_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(andesiteRuleTest, ModBlocks.ANDESITE_LAPIS_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dripstoneRuleTest, ModBlocks.DRIPSTONE_LAPIS_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateRuleTest, Blocks.DEEPSLATE_LAPIS_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(tuffRuleTest, ModBlocks.TUFF_LAPIS_ORE.getDefaultState())
                );
        List<OreFeatureConfig.Target> diamondOres =
                List.of(OreFeatureConfig.createTarget(stoneRuleTest, Blocks.DIAMOND_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(graniteRuleTest, ModBlocks.GRANITE_DIAMOND_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dioriteRuleTest, ModBlocks.DIORITE_DIAMOND_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(andesiteRuleTest, ModBlocks.ANDESITE_DIAMOND_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dripstoneRuleTest, ModBlocks.DRIPSTONE_DIAMOND_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateRuleTest, Blocks.DEEPSLATE_DIAMOND_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(tuffRuleTest, ModBlocks.TUFF_DIAMOND_ORE.getDefaultState())
                );
        List<OreFeatureConfig.Target> netherGoldOres =
                List.of(OreFeatureConfig.createTarget(netherrackRuleTest, Blocks.NETHER_GOLD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(blackstoneRuleTest, ModBlocks.BLACKSTONE_GOLD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(basaltRuleTest, ModBlocks.BASALT_GOLD_ORE.getDefaultState())
                );
        List<OreFeatureConfig.Target> netherQuartzOres =
                List.of(OreFeatureConfig.createTarget(netherrackRuleTest, Blocks.NETHER_QUARTZ_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(blackstoneRuleTest, ModBlocks.BLACKSTONE_QUARTZ_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(basaltRuleTest, ModBlocks.BASALT_QUARTZ_ORE.getDefaultState())
                );

        register(context, OreConfiguredFeatures.ORE_COAL, Feature.ORE, new OreFeatureConfig(coalOres, 17));
        register(context, OreConfiguredFeatures.ORE_COAL_BURIED, Feature.ORE, new OreFeatureConfig(coalOres, 17, 0.5f));
        register(context, OreConfiguredFeatures.ORE_IRON, Feature.ORE, new OreFeatureConfig(ironOres, 9));
        register(context, OreConfiguredFeatures.ORE_IRON_SMALL, Feature.ORE, new OreFeatureConfig(ironOres, 4));
        register(context, OreConfiguredFeatures.ORE_COPPER_SMALL, Feature.ORE, new OreFeatureConfig(copperOres, 10));
        register(context, OreConfiguredFeatures.ORE_COPPER_LARGE, Feature.ORE, new OreFeatureConfig(copperOres, 20));
        register(context, OreConfiguredFeatures.ORE_GOLD, Feature.ORE, new OreFeatureConfig(goldOres, 9));
        register(context, OreConfiguredFeatures.ORE_GOLD_BURIED, Feature.ORE, new OreFeatureConfig(goldOres, 9, 0.5f));
        register(context, OreConfiguredFeatures.ORE_REDSTONE, Feature.ORE, new OreFeatureConfig(redstoneOres, 8));
        register(context, OreConfiguredFeatures.ORE_EMERALD, Feature.ORE, new OreFeatureConfig(emeraldOres, 3));
        register(context, OreConfiguredFeatures.ORE_LAPIS, Feature.ORE, new OreFeatureConfig(lapisOres, 7));
        register(context, OreConfiguredFeatures.ORE_LAPIS_BURIED, Feature.ORE, new OreFeatureConfig(lapisOres, 7, 1.0f));
        register(context, OreConfiguredFeatures.ORE_DIAMOND_SMALL, Feature.ORE, new OreFeatureConfig(diamondOres, 4, 0.5f));
        register(context, OreConfiguredFeatures.ORE_DIAMOND_MEDIUM, Feature.ORE, new OreFeatureConfig(diamondOres, 8, 0.5f));
        register(context, OreConfiguredFeatures.ORE_DIAMOND_LARGE, Feature.ORE, new OreFeatureConfig(diamondOres, 12, 0.7f));
        register(context, OreConfiguredFeatures.ORE_DIAMOND_BURIED, Feature.ORE, new OreFeatureConfig(diamondOres, 8, 1.0f));
        register(context, OreConfiguredFeatures.ORE_NETHER_GOLD, Feature.ORE, new OreFeatureConfig(netherGoldOres, 10));
        register(context, OreConfiguredFeatures.ORE_QUARTZ, Feature.ORE, new OreFeatureConfig(netherQuartzOres, 14));
    }

    public static void modOres(Registerable<ConfiguredFeature<?,?>> context) {
        List<OreFeatureConfig.Target> rubyOres =
                List.of(OreFeatureConfig.createTarget(stoneRuleTest, ModBlocks.RUBY_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(graniteRuleTest, ModBlocks.GRANITE_RUBY_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dioriteRuleTest, ModBlocks.DIORITE_RUBY_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(andesiteRuleTest, ModBlocks.ANDESITE_RUBY_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dripstoneRuleTest, ModBlocks.DRIPSTONE_RUBY_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateRuleTest, ModBlocks.DEEPSLATE_RUBY_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(tuffRuleTest, ModBlocks.TUFF_RUBY_ORE.getDefaultState())
                );
        List<OreFeatureConfig.Target> sapphireOres =
                List.of(OreFeatureConfig.createTarget(stoneRuleTest, ModBlocks.SAPPHIRE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(graniteRuleTest, ModBlocks.GRANITE_SAPPHIRE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dioriteRuleTest, ModBlocks.DIORITE_SAPPHIRE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(andesiteRuleTest, ModBlocks.ANDESITE_SAPPHIRE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dripstoneRuleTest, ModBlocks.DRIPSTONE_SAPPHIRE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateRuleTest, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(tuffRuleTest, ModBlocks.TUFF_SAPPHIRE_ORE.getDefaultState())
                );
        List<OreFeatureConfig.Target> topazOres =
                List.of(OreFeatureConfig.createTarget(stoneRuleTest, ModBlocks.TOPAZ_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(graniteRuleTest, ModBlocks.GRANITE_TOPAZ_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dioriteRuleTest, ModBlocks.DIORITE_TOPAZ_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(andesiteRuleTest, ModBlocks.ANDESITE_TOPAZ_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dripstoneRuleTest, ModBlocks.DRIPSTONE_TOPAZ_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateRuleTest, ModBlocks.DEEPSLATE_TOPAZ_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(tuffRuleTest, ModBlocks.TUFF_TOPAZ_ORE.getDefaultState())
                );
        List<OreFeatureConfig.Target> citrineOres =
                List.of(OreFeatureConfig.createTarget(stoneRuleTest, ModBlocks.CITRINE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(graniteRuleTest, ModBlocks.GRANITE_CITRINE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dioriteRuleTest, ModBlocks.DIORITE_CITRINE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(andesiteRuleTest, ModBlocks.ANDESITE_CITRINE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dripstoneRuleTest, ModBlocks.DRIPSTONE_CITRINE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateRuleTest, ModBlocks.DEEPSLATE_CITRINE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(tuffRuleTest, ModBlocks.TUFF_CITRINE_ORE.getDefaultState())
                );
        List<OreFeatureConfig.Target> alexandriteOres =
                List.of(OreFeatureConfig.createTarget(stoneRuleTest, ModBlocks.ALEXANDRITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(graniteRuleTest, ModBlocks.GRANITE_ALEXANDRITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dioriteRuleTest, ModBlocks.DIORITE_ALEXANDRITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(andesiteRuleTest, ModBlocks.ANDESITE_ALEXANDRITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dripstoneRuleTest, ModBlocks.DRIPSTONE_ALEXANDRITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateRuleTest, ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(tuffRuleTest, ModBlocks.TUFF_ALEXANDRITE_ORE.getDefaultState())
                );
        List<OreFeatureConfig.Target> spinelOres =
                List.of(OreFeatureConfig.createTarget(stoneRuleTest, ModBlocks.SPINEL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(graniteRuleTest, ModBlocks.GRANITE_SPINEL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dioriteRuleTest, ModBlocks.DIORITE_SPINEL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(andesiteRuleTest, ModBlocks.ANDESITE_SPINEL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dripstoneRuleTest, ModBlocks.DRIPSTONE_SPINEL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateRuleTest, ModBlocks.DEEPSLATE_SPINEL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(tuffRuleTest, ModBlocks.TUFF_SPINEL_ORE.getDefaultState())
                );
        List<OreFeatureConfig.Target> whiteQuartzOres =
                List.of(OreFeatureConfig.createTarget(stoneRuleTest, ModBlocks.WHITE_QUARTZ_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(graniteRuleTest, ModBlocks.GRANITE_WHITE_QUARTZ_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dioriteRuleTest, ModBlocks.DIORITE_WHITE_QUARTZ_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(andesiteRuleTest, ModBlocks.ANDESITE_WHITE_QUARTZ_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(dripstoneRuleTest, ModBlocks.DRIPSTONE_WHITE_QUARTZ_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateRuleTest, ModBlocks.DEEPSLATE_WHITE_QUARTZ_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(tuffRuleTest, ModBlocks.TUFF_WHITE_QUARTZ_ORE.getDefaultState())
                );

        register(context, RUBY_ORE_KEY, Feature.ORE, new OreFeatureConfig(rubyOres, 3));
        register(context, SAPPHIRE_ORE_KEY, Feature.ORE, new OreFeatureConfig(sapphireOres, 3));
        register(context, TOPAZ_ORE_KEY, Feature.ORE, new OreFeatureConfig(topazOres, 3));
        register(context, CITRINE_ORE_KEY, Feature.ORE, new OreFeatureConfig(citrineOres, 3));
        register(context, ALEXANDRITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(alexandriteOres, 3));
        register(context, SPINEL_ORE_KEY, Feature.ORE, new OreFeatureConfig(spinelOres, 3));
        register(context, WHITE_QUARTZ_ORE_KEY, Feature.ORE, new OreFeatureConfig(whiteQuartzOres, 14));
    }

    public static final RuleTest stoneRuleTest = new BlockMatchRuleTest(Blocks.STONE);
    public static final RuleTest graniteRuleTest = new BlockMatchRuleTest(Blocks.GRANITE);
    public static final RuleTest dioriteRuleTest = new BlockMatchRuleTest(Blocks.DIORITE);
    public static final RuleTest andesiteRuleTest = new BlockMatchRuleTest(Blocks.ANDESITE);
    public static final RuleTest dripstoneRuleTest = new BlockMatchRuleTest(Blocks.DRIPSTONE_BLOCK);
    public static final RuleTest deepslateRuleTest = new BlockMatchRuleTest(Blocks.DEEPSLATE);
    public static final RuleTest tuffRuleTest = new BlockMatchRuleTest(Blocks.TUFF);
    public static final RuleTest netherrackRuleTest = new BlockMatchRuleTest(Blocks.NETHERRACK);
    public static final RuleTest blackstoneRuleTest = new BlockMatchRuleTest(Blocks.BLACKSTONE);
    public static final RuleTest basaltRuleTest = new BlockMatchRuleTest(Blocks.BASALT);

    public static final RegistryKey<ConfiguredFeature<?,?>> RUBY_ORE_KEY = registerKey("ore_ruby");
    public static final RegistryKey<ConfiguredFeature<?,?>> SAPPHIRE_ORE_KEY = registerKey("ore_sapphire");
    public static final RegistryKey<ConfiguredFeature<?,?>> TOPAZ_ORE_KEY = registerKey("ore_topaz");
    public static final RegistryKey<ConfiguredFeature<?,?>> CITRINE_ORE_KEY = registerKey("ore_citrine");
    public static final RegistryKey<ConfiguredFeature<?,?>> ALEXANDRITE_ORE_KEY = registerKey("ore_alexandrite");
    public static final RegistryKey<ConfiguredFeature<?,?>> SPINEL_ORE_KEY = registerKey("ore_spinel");
    public static final RegistryKey<ConfiguredFeature<?,?>> WHITE_QUARTZ_ORE_KEY = registerKey("ore_white_quartz");
}
