package gay.beegirl.datagen;

import gay.beegirl.CustomClasses.BerryBushBlock;
import gay.beegirl.ModBlocks;
import gay.beegirl.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.CropBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
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
        RegistryWrapper.Impl<Enchantment> impl = registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        BlockStatePropertyLootCondition.Builder grownVanillaBuilder = BlockStatePropertyLootCondition.builder(ModBlocks.VANILLA_CROP)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(CropBlock.AGE, 7));
        BlockStatePropertyLootCondition.Builder partGrownSourBerryBuilder = BlockStatePropertyLootCondition.builder(ModBlocks.SOUR_BERRY_BUSH)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(BerryBushBlock.AGE, 2));
        BlockStatePropertyLootCondition.Builder grownSourBerryBuilder = BlockStatePropertyLootCondition.builder(ModBlocks.SOUR_BERRY_BUSH)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(BerryBushBlock.AGE, 3));

        addDrop(ModBlocks.NIGHTSHADE);
        addDrop(ModBlocks.NIGHTSHADE_CROP, (block) -> applyExplosionDecay(block,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .with(ItemEntry.builder(ModItems.NIGHTSHADE_SEEDS)))));
        addPottedPlantDrops(ModBlocks.POTTED_NIGHTSHADE);

        addDrop(ModBlocks.CAMELIA);
        addDrop(ModBlocks.CAMELIA_CROP, (block) -> applyExplosionDecay(block,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .with(ItemEntry.builder(ModItems.CAMELIA_SEEDS)))));
        addPottedPlantDrops(ModBlocks.POTTED_CAMELIA);

        addDrop(ModBlocks.LAVENDER);
        addDrop(ModBlocks.LAVENDER_CROP, (block) -> applyExplosionDecay(block,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .with(ItemEntry.builder(ModItems.LAVENDER_SEEDS)))));
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
                                .with(ItemEntry.builder(Items.CARROT)))
                        .pool(LootPool.builder()
                                .conditionally(grownVanillaBuilder)
                                .with(ItemEntry.builder(Items.CARROT)
                                        .apply(ApplyBonusLootFunction.binomialWithBonusCount(impl.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3))))));
        addDrop(ModBlocks.VANILLA_CROP, (block) -> cropDrops(block, ModItems.VANILLA, ModItems.VANILLA_SEEDS, grownVanillaBuilder));
    }
}
