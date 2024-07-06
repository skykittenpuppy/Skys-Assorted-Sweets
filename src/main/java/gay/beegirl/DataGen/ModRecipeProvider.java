package gay.beegirl.DataGen;

import com.google.common.collect.ImmutableList;
import gay.beegirl.Block.ModBlocks;
import gay.beegirl.Item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.SPONGE_CAKE, 1)
                .pattern("SSS")
                .pattern("EME")
                .pattern("WWW")
                .input('S', Items.SUGAR)
                .input('E', Items.EGG)
                .input('M', Items.MILK_BUCKET)
                .input('W', Items.WHEAT)
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .offerTo(exporter, Identifier.tryParse(getRecipeName(ModBlocks.SPONGE_CAKE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.CHOCOLATE_CAKE, 1)
                .pattern("CSC")
                .pattern("EME")
                .pattern("WCW")
                .input('C', Items.COCOA_BEANS)
                .input('S', Items.SUGAR)
                .input('E', Items.EGG)
                .input('M', Items.MILK_BUCKET)
                .input('W', Items.WHEAT)
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .offerTo(exporter, Identifier.tryParse(getRecipeName(ModBlocks.CHOCOLATE_CAKE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.RED_VELVET_CAKE, 1)
                .pattern("SBS")
                .pattern("EME")
                .pattern("WCW")
                .input('S', Items.SUGAR)
                .input('B', Items.BEETROOT)
                .input('E', Items.EGG)
                .input('M', Items.MILK_BUCKET)
                .input('W', Items.WHEAT)
                .input('C', Items.COCOA_BEANS)
                .criterion(hasItem(Items.BEETROOT), conditionsFromItem(Items.BEETROOT))
                .offerTo(exporter, Identifier.tryParse(getRecipeName(ModBlocks.RED_VELVET_CAKE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.CARROT_CAKE, 1)
                .pattern("SSS")
                .pattern("EME")
                .pattern("CWC")
                .input('S', Items.SUGAR)
                .input('E', Items.EGG)
                .input('M', Items.MILK_BUCKET)
                .input('C', Items.CARROT)
                .input('W', Items.WHEAT)
                .criterion(hasItem(Items.CARROT), conditionsFromItem(Items.CARROT))
                .offerTo(exporter, Identifier.tryParse(getRecipeName(ModBlocks.CARROT_CAKE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PURPLE_DYE, 1)
                .input(ModBlocks.NIGHTSHADE)
                .criterion(hasItem(ModBlocks.NIGHTSHADE), conditionsFromItem(ModBlocks.NIGHTSHADE))
                .offerTo(exporter, Identifier.tryParse(getRecipeName(ModBlocks.NIGHTSHADE)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MAGENTA_DYE, 1)
                .input(ModBlocks.CAMELIA)
                .criterion(hasItem(ModBlocks.CAMELIA), conditionsFromItem(ModBlocks.CAMELIA))
                .offerTo(exporter, Identifier.tryParse(getRecipeName(ModBlocks.CAMELIA)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PURPLE_DYE, 1)
                .input(ModBlocks.LAVENDER)
                .criterion(hasItem(ModBlocks.LAVENDER), conditionsFromItem(ModBlocks.LAVENDER))
                .offerTo(exporter, Identifier.tryParse(getRecipeName(ModBlocks.LAVENDER)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PITCHER_POD, 1)
                .input(Items.PITCHER_PLANT)
                .input(Items.WHEAT_SEEDS)
                .criterion(hasItem(Items.PITCHER_PLANT), conditionsFromItem(Items.PITCHER_PLANT))
                .criterion(hasItem(Items.PITCHER_POD), conditionsFromItem(Items.PITCHER_POD))
                .offerTo(exporter, Identifier.tryParse(getRecipeName(Items.PITCHER_POD)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.TORCHFLOWER_SEEDS, 1)
                .input(Items.TORCHFLOWER)
                .input(Items.WHEAT_SEEDS)
                .criterion(hasItem(Items.TORCHFLOWER), conditionsFromItem(Items.TORCHFLOWER))
                .criterion(hasItem(Items.TORCHFLOWER_SEEDS), conditionsFromItem(Items.TORCHFLOWER_SEEDS))
                .offerTo(exporter, Identifier.tryParse(getRecipeName(Items.TORCHFLOWER_SEEDS)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NIGHTSHADE_SEEDS, 1)
                .input(ModBlocks.NIGHTSHADE)
                .input(Items.WHEAT_SEEDS)
                .criterion(hasItem(ModBlocks.NIGHTSHADE), conditionsFromItem(ModBlocks.NIGHTSHADE))
                .criterion(hasItem(ModItems.NIGHTSHADE_SEEDS), conditionsFromItem(ModItems.NIGHTSHADE_SEEDS))
                .offerTo(exporter, Identifier.tryParse(getRecipeName(ModItems.NIGHTSHADE_SEEDS)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CAMELIA_SEEDS, 1)
                .input(ModBlocks.CAMELIA)
                .input(Items.WHEAT_SEEDS)
                .criterion(hasItem(ModBlocks.CAMELIA), conditionsFromItem(ModBlocks.CAMELIA))
                .criterion(hasItem(ModItems.CAMELIA_SEEDS), conditionsFromItem(ModItems.CAMELIA_SEEDS))
                .offerTo(exporter, Identifier.tryParse(getRecipeName(ModItems.CAMELIA_SEEDS)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAVENDER_SEEDS, 1)
                .input(ModBlocks.LAVENDER)
                .input(Items.WHEAT_SEEDS)
                .criterion(hasItem(ModBlocks.LAVENDER), conditionsFromItem(ModBlocks.LAVENDER))
                .criterion(hasItem(ModItems.LAVENDER_SEEDS), conditionsFromItem(ModItems.LAVENDER_SEEDS))
                .offerTo(exporter, Identifier.tryParse(getRecipeName(ModItems.LAVENDER_SEEDS)));

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RUBY, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SAPPHIRE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.TOPAZ, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOPAZ_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.CITRINE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CITRINE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.ALEXANDRITE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALEXANDRITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SPINEL, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPINEL_BLOCK);

        ImmutableList<ItemConvertible> COAL_ORES = ImmutableList.of(Blocks.COAL_ORE, ModBlocks.GRANITE_COAL_ORE, ModBlocks.DIORITE_COAL_ORE, ModBlocks.ANDESITE_COAL_ORE, ModBlocks.DRIPSTONE_COAL_ORE, Blocks.DEEPSLATE_COAL_ORE, ModBlocks.TUFF_COAL_ORE);
        ImmutableList<ItemConvertible> IRON_ORES = ImmutableList.of(Blocks.IRON_ORE, ModBlocks.GRANITE_IRON_ORE, ModBlocks.DIORITE_IRON_ORE, ModBlocks.ANDESITE_IRON_ORE, ModBlocks.DRIPSTONE_IRON_ORE, Blocks.DEEPSLATE_IRON_ORE, ModBlocks.TUFF_IRON_ORE, Items.RAW_IRON);
        ImmutableList<ItemConvertible> COPPER_ORES = ImmutableList.of(Blocks.COPPER_ORE, ModBlocks.GRANITE_COPPER_ORE, ModBlocks.DIORITE_COPPER_ORE, ModBlocks.ANDESITE_COPPER_ORE, ModBlocks.DRIPSTONE_COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE, ModBlocks.TUFF_COPPER_ORE, Items.RAW_COPPER);
        ImmutableList<ItemConvertible> GOLD_ORES = ImmutableList.of(Blocks.GOLD_ORE, ModBlocks.GRANITE_GOLD_ORE, ModBlocks.DIORITE_GOLD_ORE, ModBlocks.ANDESITE_GOLD_ORE, ModBlocks.DRIPSTONE_GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE, ModBlocks.TUFF_GOLD_ORE, Blocks.NETHER_GOLD_ORE, ModBlocks.BLACKSTONE_GOLD_ORE, ModBlocks.BASALT_GOLD_ORE, Items.RAW_GOLD);
        ImmutableList<ItemConvertible> DIAMOND_ORES = ImmutableList.of(Blocks.DIAMOND_ORE, ModBlocks.GRANITE_DIAMOND_ORE, ModBlocks.DIORITE_DIAMOND_ORE, ModBlocks.ANDESITE_DIAMOND_ORE, ModBlocks.DRIPSTONE_DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE, ModBlocks.TUFF_DIAMOND_ORE);
        ImmutableList<ItemConvertible> LAPIS_ORES = ImmutableList.of(Blocks.LAPIS_ORE, ModBlocks.GRANITE_LAPIS_ORE, ModBlocks.DIORITE_LAPIS_ORE, ModBlocks.ANDESITE_LAPIS_ORE, ModBlocks.DRIPSTONE_LAPIS_ORE, Blocks.DEEPSLATE_LAPIS_ORE, ModBlocks.TUFF_LAPIS_ORE);
        ImmutableList<ItemConvertible> REDSTONE_ORES = ImmutableList.of(Blocks.REDSTONE_ORE, ModBlocks.GRANITE_REDSTONE_ORE, ModBlocks.DIORITE_REDSTONE_ORE, ModBlocks.ANDESITE_REDSTONE_ORE, ModBlocks.DRIPSTONE_REDSTONE_ORE, Blocks.DEEPSLATE_REDSTONE_ORE, ModBlocks.TUFF_REDSTONE_ORE);
        ImmutableList<ItemConvertible> EMERALD_ORES = ImmutableList.of(Blocks.EMERALD_ORE, ModBlocks.GRANITE_EMERALD_ORE, ModBlocks.DIORITE_EMERALD_ORE, ModBlocks.ANDESITE_EMERALD_ORE, ModBlocks.DRIPSTONE_EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE, ModBlocks.TUFF_EMERALD_ORE);
        ImmutableList<ItemConvertible> NETHER_QUARTZ_ORES = ImmutableList.of(Blocks.NETHER_QUARTZ_ORE, ModBlocks.BLACKSTONE_QUARTZ_ORE, ModBlocks.BASALT_QUARTZ_ORE);

        ImmutableList<ItemConvertible> WHITE_QUARTZ_ORES = ImmutableList.of(ModBlocks.WHITE_QUARTZ_ORE, ModBlocks.GRANITE_WHITE_QUARTZ_ORE, ModBlocks.DIORITE_WHITE_QUARTZ_ORE, ModBlocks.ANDESITE_WHITE_QUARTZ_ORE, ModBlocks.DRIPSTONE_WHITE_QUARTZ_ORE, ModBlocks.DEEPSLATE_WHITE_QUARTZ_ORE, ModBlocks.TUFF_WHITE_QUARTZ_ORE);
        ImmutableList<ItemConvertible> RUBY_ORES = ImmutableList.of(ModBlocks.RUBY_ORE, ModBlocks.GRANITE_RUBY_ORE, ModBlocks.DIORITE_RUBY_ORE, ModBlocks.ANDESITE_RUBY_ORE, ModBlocks.DRIPSTONE_RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.TUFF_RUBY_ORE);
        ImmutableList<ItemConvertible> SAPPHIRE_ORES = ImmutableList.of(ModBlocks.SAPPHIRE_ORE, ModBlocks.GRANITE_SAPPHIRE_ORE, ModBlocks.DIORITE_SAPPHIRE_ORE, ModBlocks.ANDESITE_SAPPHIRE_ORE, ModBlocks.DRIPSTONE_SAPPHIRE_ORE, ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModBlocks.TUFF_SAPPHIRE_ORE);
        ImmutableList<ItemConvertible> TOPAZ_ORES = ImmutableList.of(ModBlocks.TOPAZ_ORE, ModBlocks.GRANITE_TOPAZ_ORE, ModBlocks.DIORITE_TOPAZ_ORE, ModBlocks.ANDESITE_TOPAZ_ORE, ModBlocks.DRIPSTONE_TOPAZ_ORE, ModBlocks.DEEPSLATE_TOPAZ_ORE, ModBlocks.TUFF_TOPAZ_ORE);
        ImmutableList<ItemConvertible> CITRINE_ORES = ImmutableList.of(ModBlocks.CITRINE_ORE, ModBlocks.GRANITE_CITRINE_ORE, ModBlocks.DIORITE_CITRINE_ORE, ModBlocks.ANDESITE_CITRINE_ORE, ModBlocks.DRIPSTONE_CITRINE_ORE, ModBlocks.DEEPSLATE_CITRINE_ORE, ModBlocks.TUFF_CITRINE_ORE);
        ImmutableList<ItemConvertible> ALEXANDRITE_ORES = ImmutableList.of(ModBlocks.ALEXANDRITE_ORE, ModBlocks.GRANITE_ALEXANDRITE_ORE, ModBlocks.DIORITE_ALEXANDRITE_ORE, ModBlocks.ANDESITE_ALEXANDRITE_ORE, ModBlocks.DRIPSTONE_ALEXANDRITE_ORE, ModBlocks.DEEPSLATE_ALEXANDRITE_ORE, ModBlocks.TUFF_ALEXANDRITE_ORE);
        ImmutableList<ItemConvertible> SPINEL_ORES = ImmutableList.of(ModBlocks.SPINEL_ORE, ModBlocks.GRANITE_SPINEL_ORE, ModBlocks.DIORITE_SPINEL_ORE, ModBlocks.ANDESITE_SPINEL_ORE, ModBlocks.DRIPSTONE_SPINEL_ORE, ModBlocks.DEEPSLATE_SPINEL_ORE, ModBlocks.TUFF_SPINEL_ORE);

        offerSmelting(exporter, COAL_ORES, RecipeCategory.MISC, Items.COAL, 0.1F, 200, "coal");
        offerBlasting(exporter, COAL_ORES, RecipeCategory.MISC, Items.COAL, 0.1F, 100, "coal");
        offerSmelting(exporter, IRON_ORES, RecipeCategory.MISC, Items.IRON_INGOT, 0.7F, 200, "iron_ingot");
        offerBlasting(exporter, IRON_ORES, RecipeCategory.MISC, Items.IRON_INGOT, 0.7F, 100, "iron_ingot");
        offerSmelting(exporter, COPPER_ORES, RecipeCategory.MISC, Items.COPPER_INGOT, 0.7F, 200, "copper_ingot");
        offerBlasting(exporter, COPPER_ORES, RecipeCategory.MISC, Items.COPPER_INGOT, 0.7F, 100, "copper_ingot");
        offerSmelting(exporter, GOLD_ORES, RecipeCategory.MISC, Items.GOLD_INGOT, 1.0F, 200, "gold_ingot");
        offerBlasting(exporter, GOLD_ORES, RecipeCategory.MISC, Items.GOLD_INGOT, 1.0F, 100, "gold_ingot");
        offerSmelting(exporter, DIAMOND_ORES, RecipeCategory.MISC, Items.DIAMOND, 1.0F, 200, "diamond");
        offerBlasting(exporter, DIAMOND_ORES, RecipeCategory.MISC, Items.DIAMOND, 1.0F, 100, "diamond");
        offerSmelting(exporter, LAPIS_ORES, RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2F, 200, "lapis_lazuli");
        offerBlasting(exporter, LAPIS_ORES, RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2F, 100, "lapis_lazuli");
        offerSmelting(exporter, REDSTONE_ORES, RecipeCategory.REDSTONE, Items.REDSTONE, 0.7F, 200, "redstone");
        offerBlasting(exporter, REDSTONE_ORES, RecipeCategory.REDSTONE, Items.REDSTONE, 0.7F, 100, "redstone");
        offerSmelting(exporter, EMERALD_ORES, RecipeCategory.MISC, Items.EMERALD, 1.0F, 200, "emerald");
        offerBlasting(exporter, EMERALD_ORES, RecipeCategory.MISC, Items.EMERALD, 1.0F, 100, "emerald");
        offerSmelting(exporter, NETHER_QUARTZ_ORES, RecipeCategory.MISC, Items.QUARTZ, 0.2F, 200, "quartz");
        offerBlasting(exporter, NETHER_QUARTZ_ORES, RecipeCategory.MISC, Items.QUARTZ, 0.2F, 100, "quartz");

        offerSmelting(exporter, WHITE_QUARTZ_ORES, RecipeCategory.MISC, ModItems.WHITE_QUARTZ, 0.2F, 200, "white_quartz");
        offerBlasting(exporter, WHITE_QUARTZ_ORES, RecipeCategory.MISC, ModItems.WHITE_QUARTZ, 0.2F, 100, "white_quartz");
        offerSmelting(exporter, RUBY_ORES, RecipeCategory.MISC, ModItems.RUBY, 1.0F, 200, "ruby");
        offerBlasting(exporter, RUBY_ORES, RecipeCategory.MISC, ModItems.RUBY, 1.0F, 100, "ruby");
        offerSmelting(exporter, SAPPHIRE_ORES, RecipeCategory.MISC, ModItems.SAPPHIRE, 1.0F, 200, "sapphire");
        offerBlasting(exporter, SAPPHIRE_ORES, RecipeCategory.MISC, ModItems.SAPPHIRE, 1.0F, 100, "sapphire");
        offerSmelting(exporter, TOPAZ_ORES, RecipeCategory.MISC, ModItems.TOPAZ, 1.0F, 200, "topaz");
        offerBlasting(exporter, TOPAZ_ORES, RecipeCategory.MISC, ModItems.TOPAZ, 1.0F, 100, "topaz");
        offerSmelting(exporter, CITRINE_ORES, RecipeCategory.MISC, ModItems.CITRINE, 1.0F, 200, "citrine");
        offerBlasting(exporter, CITRINE_ORES, RecipeCategory.MISC, ModItems.CITRINE, 1.0F, 100, "citrine");
        offerSmelting(exporter, ALEXANDRITE_ORES, RecipeCategory.MISC, ModItems.ALEXANDRITE, 1.0F, 200, "alexandrite");
        offerBlasting(exporter, ALEXANDRITE_ORES, RecipeCategory.MISC, ModItems.ALEXANDRITE, 1.0F, 100, "alexandrite");
        offerSmelting(exporter, SPINEL_ORES, RecipeCategory.MISC, ModItems.SPINEL, 1.0F, 200, "spinel");
        offerBlasting(exporter, SPINEL_ORES, RecipeCategory.MISC, ModItems.SPINEL, 1.0F, 100, "spinel");
    }
}
