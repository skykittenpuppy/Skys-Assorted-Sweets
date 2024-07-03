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
        //addDrop(ModBlocks.VANILLA_CROP, (block) -> cropDrops(block, ModItems.VANILLA, ModItems.VANILLA_SEEDS, grownVanillaBuilder));
    }
}
