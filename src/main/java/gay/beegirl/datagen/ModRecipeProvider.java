package gay.beegirl.datagen;

import gay.beegirl.ModBlocks;
import gay.beegirl.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.recipe.v1.ingredient.CustomIngredient;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.VanillaRecipeProvider;
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
    }
}
