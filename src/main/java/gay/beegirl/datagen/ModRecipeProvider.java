package gay.beegirl.datagen;

import gay.beegirl.ModBlocks;
import gay.beegirl.ModInit;
import gay.beegirl.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.CHOCOLATE_CAKE, 1)
                .pattern("CCC")
                .pattern("SES")
                .pattern("WWW")
                .input('C', Items.COCOA_BEANS)
                .input('S', Items.SUGAR)
                .input('E', Items.EGG)
                .input('W', Items.WHEAT)
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .offerTo(exporter, Identifier.tryParse(getRecipeName(ModBlocks.CHOCOLATE_CAKE)));
    }
}
