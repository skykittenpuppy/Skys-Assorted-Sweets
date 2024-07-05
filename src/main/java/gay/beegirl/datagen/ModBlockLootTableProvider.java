package gay.beegirl.datagen;

import gay.beegirl.CustomClasses.BerryBushBlock;
import gay.beegirl.CustomClasses.FlowerCropBlock;
import gay.beegirl.ModBlocks;
import gay.beegirl.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.block.PitcherCropBlock;
import net.minecraft.block.TorchflowerBlock;
import net.minecraft.data.server.loottable.vanilla.VanillaBlockLootTableGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        float extinctCropSeedChance = 1/1024f;
        RegistryWrapper.Impl<Enchantment> impl = registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        BlockStatePropertyLootCondition.Builder grownPitcherCropBuilder = BlockStatePropertyLootCondition.builder(Blocks.PITCHER_CROP)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(PitcherCropBlock.AGE, 4));
        BlockStatePropertyLootCondition.Builder grownTorchflowerBuilder = BlockStatePropertyLootCondition.builder(Blocks.TORCHFLOWER_CROP)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(TorchflowerBlock.AGE, 2));
        BlockStatePropertyLootCondition.Builder grownNightshadeBuilder = BlockStatePropertyLootCondition.builder(ModBlocks.NIGHTSHADE_CROP)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(FlowerCropBlock.AGE, 2));
        BlockStatePropertyLootCondition.Builder grownCameliaBuilder = BlockStatePropertyLootCondition.builder(ModBlocks.CAMELIA_CROP)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(FlowerCropBlock.AGE, 2));
        BlockStatePropertyLootCondition.Builder grownLavenderBuilder = BlockStatePropertyLootCondition.builder(ModBlocks.LAVENDER_CROP)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(FlowerCropBlock.AGE, 2));
        BlockStatePropertyLootCondition.Builder grownVanillaBuilder = BlockStatePropertyLootCondition.builder(ModBlocks.VANILLA_CROP)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(CropBlock.AGE, 7));
        BlockStatePropertyLootCondition.Builder partGrownSourBerryBuilder = BlockStatePropertyLootCondition.builder(ModBlocks.SOUR_BERRY_BUSH)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(BerryBushBlock.AGE, 2));
        BlockStatePropertyLootCondition.Builder grownSourBerryBuilder = BlockStatePropertyLootCondition.builder(ModBlocks.SOUR_BERRY_BUSH)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(BerryBushBlock.AGE, 3));

        addDrop(Blocks.PITCHER_CROP, (block) -> applyExplosionDecay(block,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .conditionally(grownPitcherCropBuilder)
                                .conditionally(RandomChanceLootCondition.builder(extinctCropSeedChance))
                                .with(ItemEntry.builder(Items.PITCHER_POD)))));

        addDrop(Blocks.TORCHFLOWER_CROP, (block) -> applyExplosionDecay(block,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .conditionally(grownTorchflowerBuilder.invert())
                                .with(ItemEntry.builder(Items.TORCHFLOWER_SEEDS)))
                        .pool(LootPool.builder()
                                .conditionally(grownTorchflowerBuilder)
                                .conditionally(RandomChanceLootCondition.builder(extinctCropSeedChance))
                                .with(ItemEntry.builder(Items.TORCHFLOWER_SEEDS)))
                        .pool(LootPool.builder()
                                .conditionally(grownTorchflowerBuilder)
                                .with(ItemEntry.builder(Blocks.TORCHFLOWER)))));

        addDrop(ModBlocks.NIGHTSHADE);
        addDrop(ModBlocks.NIGHTSHADE_CROP, (block) -> applyExplosionDecay(block,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .conditionally(grownNightshadeBuilder.invert())
                                .with(ItemEntry.builder(ModItems.NIGHTSHADE_SEEDS)))
                        .pool(LootPool.builder()
                                .conditionally(grownNightshadeBuilder)
                                .conditionally(RandomChanceLootCondition.builder(extinctCropSeedChance))
                                .with(ItemEntry.builder(ModItems.NIGHTSHADE_SEEDS)))
                        .pool(LootPool.builder()
                                .conditionally(grownNightshadeBuilder)
                                .with(ItemEntry.builder(ModBlocks.NIGHTSHADE)))));
        addPottedPlantDrops(ModBlocks.POTTED_NIGHTSHADE);

        addDrop(ModBlocks.CAMELIA);
        addDrop(ModBlocks.CAMELIA_CROP, (block) -> applyExplosionDecay(block,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .conditionally(grownCameliaBuilder.invert())
                                .with(ItemEntry.builder(ModItems.CAMELIA_SEEDS)))
                        .pool(LootPool.builder()
                                .conditionally(grownCameliaBuilder)
                                .conditionally(RandomChanceLootCondition.builder(extinctCropSeedChance))
                                .with(ItemEntry.builder(ModItems.CAMELIA_SEEDS)))
                        .pool(LootPool.builder()
                                .conditionally(grownCameliaBuilder)
                                .with(ItemEntry.builder(ModBlocks.CAMELIA)))));
        addPottedPlantDrops(ModBlocks.POTTED_CAMELIA);

        addDrop(ModBlocks.LAVENDER);
        addDrop(ModBlocks.LAVENDER_CROP, (block) -> applyExplosionDecay(block,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .conditionally(grownLavenderBuilder.invert())
                                .with(ItemEntry.builder(ModItems.LAVENDER_SEEDS)))
                        .pool(LootPool.builder()
                                .conditionally(grownLavenderBuilder)
                                .conditionally(RandomChanceLootCondition.builder(extinctCropSeedChance))
                                .with(ItemEntry.builder(ModItems.LAVENDER_SEEDS)))
                        .pool(LootPool.builder()
                                .conditionally(grownLavenderBuilder)
                                .with(ItemEntry.builder(ModBlocks.LAVENDER)))));
        addPottedPlantDrops(ModBlocks.POTTED_LAVENDER);

        addDrop(ModBlocks.SOUR_BERRY_BUSH, (block) -> applyExplosionDecay(block,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .conditionally(grownSourBerryBuilder)
                                .with(ItemEntry.builder(ModItems.SOUR_BERRIES))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))
                        .pool(LootPool.builder()
                                .conditionally(partGrownSourBerryBuilder)
                                .with(ItemEntry.builder(ModItems.SOUR_BERRIES))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));

        addDrop(ModBlocks.VANILLA_CROP, (block) -> applyExplosionDecay(block,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .with(ItemEntry.builder(ModItems.VANILLA_SEEDS)))
                        .pool(LootPool.builder()
                                .conditionally(grownVanillaBuilder)
                                .conditionally(RandomChanceLootCondition.builder(extinctCropSeedChance))
                                .with(ItemEntry.builder(ModItems.VANILLA_SEEDS)))
                        .pool(LootPool.builder()
                                .conditionally(grownVanillaBuilder)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F)))
                                .with(ItemEntry.builder(ModItems.VANILLA)))));

        addDrop(Blocks.COAL_ORE, (block) -> oreDrops(block, Items.COAL));
        addDrop(ModBlocks.GRANITE_COAL_ORE, (block) -> oreDrops(block, Items.COAL));
        addDrop(ModBlocks.DIORITE_COAL_ORE, (block) -> oreDrops(block, Items.COAL));
        addDrop(ModBlocks.ANDESITE_COAL_ORE, (block) -> oreDrops(block, Items.COAL));
        addDrop(ModBlocks.DRIPSTONE_COAL_ORE, (block) -> oreDrops(block, Items.COAL));
        addDrop(Blocks.DEEPSLATE_COAL_ORE, (block) -> oreDrops(block, Items.COAL));
        addDrop(ModBlocks.TUFF_COAL_ORE, (block) -> oreDrops(block, Items.COAL));

        addDrop(Blocks.IRON_ORE, (block) -> oreDrops(block, Items.RAW_IRON));
        addDrop(ModBlocks.GRANITE_IRON_ORE, (block) -> oreDrops(block, Items.RAW_IRON));
        addDrop(ModBlocks.DIORITE_IRON_ORE, (block) -> oreDrops(block, Items.RAW_IRON));
        addDrop(ModBlocks.ANDESITE_IRON_ORE, (block) -> oreDrops(block, Items.RAW_IRON));
        addDrop(ModBlocks.DRIPSTONE_IRON_ORE, (block) -> oreDrops(block, Items.RAW_IRON));
        addDrop(Blocks.DEEPSLATE_IRON_ORE, (block) -> oreDrops(block, Items.RAW_IRON));
        addDrop(ModBlocks.TUFF_IRON_ORE, (block) -> oreDrops(block, Items.RAW_IRON));

        addDrop(Blocks.COPPER_ORE, this::copperOreDrops);
        addDrop(ModBlocks.GRANITE_COPPER_ORE, this::copperOreDrops);
        addDrop(ModBlocks.DIORITE_COPPER_ORE, this::copperOreDrops);
        addDrop(ModBlocks.ANDESITE_COPPER_ORE, this::copperOreDrops);
        addDrop(ModBlocks.DRIPSTONE_COPPER_ORE, this::copperOreDrops);
        addDrop(Blocks.DEEPSLATE_COPPER_ORE, this::copperOreDrops);
        addDrop(ModBlocks.TUFF_COPPER_ORE, this::copperOreDrops);

        addDrop(Blocks.GOLD_ORE, (block) -> oreDrops(block, Items.RAW_GOLD));
        addDrop(ModBlocks.GRANITE_GOLD_ORE, (block) -> oreDrops(block, Items.RAW_GOLD));
        addDrop(ModBlocks.DIORITE_GOLD_ORE, (block) -> oreDrops(block, Items.RAW_GOLD));
        addDrop(ModBlocks.ANDESITE_GOLD_ORE, (block) -> oreDrops(block, Items.RAW_GOLD));
        addDrop(ModBlocks.DRIPSTONE_GOLD_ORE, (block) -> oreDrops(block, Items.RAW_GOLD));
        addDrop(Blocks.DEEPSLATE_GOLD_ORE, (block) -> oreDrops(block, Items.RAW_GOLD));
        addDrop(ModBlocks.TUFF_GOLD_ORE, (block) -> oreDrops(block, Items.RAW_GOLD));

        addDrop(Blocks.REDSTONE_ORE, (block) -> oreDrops(block, Items.REDSTONE));
        addDrop(ModBlocks.GRANITE_REDSTONE_ORE, (block) -> oreDrops(block, Items.REDSTONE));
        addDrop(ModBlocks.DIORITE_REDSTONE_ORE, (block) -> oreDrops(block, Items.REDSTONE));
        addDrop(ModBlocks.ANDESITE_REDSTONE_ORE, (block) -> oreDrops(block, Items.REDSTONE));
        addDrop(ModBlocks.DRIPSTONE_REDSTONE_ORE, (block) -> oreDrops(block, Items.REDSTONE));
        addDrop(Blocks.DEEPSLATE_REDSTONE_ORE, (block) -> oreDrops(block, Items.REDSTONE));
        addDrop(ModBlocks.TUFF_REDSTONE_ORE, (block) -> oreDrops(block, Items.REDSTONE));

        addDrop(Blocks.EMERALD_ORE, (block) -> oreDrops(block, Items.EMERALD));
        addDrop(ModBlocks.GRANITE_EMERALD_ORE, (block) -> oreDrops(block, Items.EMERALD));
        addDrop(ModBlocks.DIORITE_EMERALD_ORE, (block) -> oreDrops(block, Items.EMERALD));
        addDrop(ModBlocks.ANDESITE_EMERALD_ORE, (block) -> oreDrops(block, Items.EMERALD));
        addDrop(ModBlocks.DRIPSTONE_EMERALD_ORE, (block) -> oreDrops(block, Items.EMERALD));
        addDrop(Blocks.DEEPSLATE_EMERALD_ORE, (block) -> oreDrops(block, Items.EMERALD));
        addDrop(ModBlocks.TUFF_EMERALD_ORE, (block) -> oreDrops(block, Items.EMERALD));

        addDrop(Blocks.LAPIS_ORE, this::lapisOreDrops);
        addDrop(ModBlocks.GRANITE_LAPIS_ORE, this::lapisOreDrops);
        addDrop(ModBlocks.DIORITE_LAPIS_ORE, this::lapisOreDrops);
        addDrop(ModBlocks.ANDESITE_LAPIS_ORE, this::lapisOreDrops);
        addDrop(ModBlocks.DRIPSTONE_LAPIS_ORE, this::lapisOreDrops);
        addDrop(Blocks.DEEPSLATE_LAPIS_ORE, this::lapisOreDrops);
        addDrop(ModBlocks.TUFF_LAPIS_ORE, this::lapisOreDrops);

        addDrop(Blocks.DIAMOND_ORE, (block) -> oreDrops(block, Items.DIAMOND));
        addDrop(ModBlocks.GRANITE_DIAMOND_ORE, (block) -> oreDrops(block, Items.DIAMOND));
        addDrop(ModBlocks.DIORITE_DIAMOND_ORE, (block) -> oreDrops(block, Items.DIAMOND));
        addDrop(ModBlocks.ANDESITE_DIAMOND_ORE, (block) -> oreDrops(block, Items.DIAMOND));
        addDrop(ModBlocks.DRIPSTONE_DIAMOND_ORE, (block) -> oreDrops(block, Items.DIAMOND));
        addDrop(Blocks.DEEPSLATE_DIAMOND_ORE, (block) -> oreDrops(block, Items.DIAMOND));
        addDrop(ModBlocks.TUFF_DIAMOND_ORE, (block) -> oreDrops(block, Items.DIAMOND));

        addDrop(Blocks.NETHER_GOLD_ORE, (block) -> dropsWithSilkTouch(block, applyExplosionDecay(block, ItemEntry.builder(Items.GOLD_NUGGET).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 6.0F))).apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE))))));
        addDrop(ModBlocks.BLACKSTONE_GOLD_ORE, (block) -> dropsWithSilkTouch(block, applyExplosionDecay(block, ItemEntry.builder(Items.GOLD_NUGGET).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 6.0F))).apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE))))));
        addDrop(ModBlocks.BASALT_GOLD_ORE, (block) -> dropsWithSilkTouch(block, applyExplosionDecay(block, ItemEntry.builder(Items.GOLD_NUGGET).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 6.0F))).apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE))))));

        addDrop(Blocks.NETHER_QUARTZ_ORE, (block) -> oreDrops(block, Items.QUARTZ));
        addDrop(ModBlocks.BLACKSTONE_QUARTZ_ORE, (block) -> oreDrops(block, Items.QUARTZ));
        addDrop(ModBlocks.BASALT_QUARTZ_ORE, (block) -> oreDrops(block, Items.QUARTZ));

        addDrop(ModBlocks.WHITE_QUARTZ_ORE, (block) -> oreDrops(block, ModItems.WHITE_QUARTZ));
        addDrop(ModBlocks.GRANITE_WHITE_QUARTZ_ORE, (block) -> oreDrops(block, ModItems.WHITE_QUARTZ));
        addDrop(ModBlocks.DIORITE_WHITE_QUARTZ_ORE, (block) -> oreDrops(block, ModItems.WHITE_QUARTZ));
        addDrop(ModBlocks.ANDESITE_WHITE_QUARTZ_ORE, (block) -> oreDrops(block, ModItems.WHITE_QUARTZ));
        addDrop(ModBlocks.DRIPSTONE_WHITE_QUARTZ_ORE, (block) -> oreDrops(block, ModItems.WHITE_QUARTZ));
        addDrop(ModBlocks.DEEPSLATE_WHITE_QUARTZ_ORE, (block) -> oreDrops(block, ModItems.WHITE_QUARTZ));
        addDrop(ModBlocks.TUFF_WHITE_QUARTZ_ORE, (block) -> oreDrops(block, ModItems.WHITE_QUARTZ));

        addDrop(ModBlocks.RUBY_ORE, (block) -> oreDrops(block, ModItems.RUBY));
        addDrop(ModBlocks.GRANITE_RUBY_ORE, (block) -> oreDrops(block, ModItems.RUBY));
        addDrop(ModBlocks.DIORITE_RUBY_ORE, (block) -> oreDrops(block, ModItems.RUBY));
        addDrop(ModBlocks.ANDESITE_RUBY_ORE, (block) -> oreDrops(block, ModItems.RUBY));
        addDrop(ModBlocks.DRIPSTONE_RUBY_ORE, (block) -> oreDrops(block, ModItems.RUBY));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, (block) -> oreDrops(block, ModItems.RUBY));
        addDrop(ModBlocks.TUFF_RUBY_ORE, (block) -> oreDrops(block, ModItems.RUBY));

        addDrop(ModBlocks.SAPPHIRE_ORE, (block) -> oreDrops(block, ModItems.SAPPHIRE));
        addDrop(ModBlocks.GRANITE_SAPPHIRE_ORE, (block) -> oreDrops(block, ModItems.SAPPHIRE));
        addDrop(ModBlocks.DIORITE_SAPPHIRE_ORE, (block) -> oreDrops(block, ModItems.SAPPHIRE));
        addDrop(ModBlocks.ANDESITE_SAPPHIRE_ORE, (block) -> oreDrops(block, ModItems.SAPPHIRE));
        addDrop(ModBlocks.DRIPSTONE_SAPPHIRE_ORE, (block) -> oreDrops(block, ModItems.SAPPHIRE));
        addDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, (block) -> oreDrops(block, ModItems.SAPPHIRE));
        addDrop(ModBlocks.TUFF_SAPPHIRE_ORE, (block) -> oreDrops(block, ModItems.SAPPHIRE));

        addDrop(ModBlocks.TOPAZ_ORE, (block) -> oreDrops(block, ModItems.TOPAZ));
        addDrop(ModBlocks.GRANITE_TOPAZ_ORE, (block) -> oreDrops(block, ModItems.TOPAZ));
        addDrop(ModBlocks.DIORITE_TOPAZ_ORE, (block) -> oreDrops(block, ModItems.TOPAZ));
        addDrop(ModBlocks.ANDESITE_TOPAZ_ORE, (block) -> oreDrops(block, ModItems.TOPAZ));
        addDrop(ModBlocks.DRIPSTONE_TOPAZ_ORE, (block) -> oreDrops(block, ModItems.TOPAZ));
        addDrop(ModBlocks.DEEPSLATE_TOPAZ_ORE, (block) -> oreDrops(block, ModItems.TOPAZ));
        addDrop(ModBlocks.TUFF_TOPAZ_ORE, (block) -> oreDrops(block, ModItems.TOPAZ));

        addDrop(ModBlocks.CITRINE_ORE, (block) -> oreDrops(block, ModItems.CITRINE));
        addDrop(ModBlocks.GRANITE_CITRINE_ORE, (block) -> oreDrops(block, ModItems.CITRINE));
        addDrop(ModBlocks.DIORITE_CITRINE_ORE, (block) -> oreDrops(block, ModItems.CITRINE));
        addDrop(ModBlocks.ANDESITE_CITRINE_ORE, (block) -> oreDrops(block, ModItems.CITRINE));
        addDrop(ModBlocks.DRIPSTONE_CITRINE_ORE, (block) -> oreDrops(block, ModItems.CITRINE));
        addDrop(ModBlocks.DEEPSLATE_CITRINE_ORE, (block) -> oreDrops(block, ModItems.CITRINE));
        addDrop(ModBlocks.TUFF_CITRINE_ORE, (block) -> oreDrops(block, ModItems.CITRINE));

        addDrop(ModBlocks.ALEXANDRITE_ORE, (block) -> oreDrops(block, ModItems.ALEXANDRITE));
        addDrop(ModBlocks.GRANITE_ALEXANDRITE_ORE, (block) -> oreDrops(block, ModItems.ALEXANDRITE));
        addDrop(ModBlocks.DIORITE_ALEXANDRITE_ORE, (block) -> oreDrops(block, ModItems.ALEXANDRITE));
        addDrop(ModBlocks.ANDESITE_ALEXANDRITE_ORE, (block) -> oreDrops(block, ModItems.ALEXANDRITE));
        addDrop(ModBlocks.DRIPSTONE_ALEXANDRITE_ORE, (block) -> oreDrops(block, ModItems.ALEXANDRITE));
        addDrop(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE, (block) -> oreDrops(block, ModItems.ALEXANDRITE));
        addDrop(ModBlocks.TUFF_ALEXANDRITE_ORE, (block) -> oreDrops(block, ModItems.ALEXANDRITE));

        addDrop(ModBlocks.SPINEL_ORE, (block) -> oreDrops(block, ModItems.SPINEL));
        addDrop(ModBlocks.GRANITE_SPINEL_ORE, (block) -> oreDrops(block, ModItems.SPINEL));
        addDrop(ModBlocks.DIORITE_SPINEL_ORE, (block) -> oreDrops(block, ModItems.SPINEL));
        addDrop(ModBlocks.ANDESITE_SPINEL_ORE, (block) -> oreDrops(block, ModItems.SPINEL));
        addDrop(ModBlocks.DRIPSTONE_SPINEL_ORE, (block) -> oreDrops(block, ModItems.SPINEL));
        addDrop(ModBlocks.DEEPSLATE_SPINEL_ORE, (block) -> oreDrops(block, ModItems.SPINEL));
        addDrop(ModBlocks.TUFF_SPINEL_ORE, (block) -> oreDrops(block, ModItems.SPINEL));
    }
}
