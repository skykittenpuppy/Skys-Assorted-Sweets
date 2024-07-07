package gay.beegirl.DataGen;

import gay.beegirl.Item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class VanillaNamespaceRecipeProvider extends FabricRecipeProvider {
    public VanillaNamespaceRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CAKE)
                .criterion(hasItem(Items.AIR), conditionsFromItem(Items.AIR))
                .offerTo(exporter, Identifier.tryParse(getRecipeName(Blocks.CAKE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PUMPKIN_PIE)
                .criterion(hasItem(Items.AIR), conditionsFromItem(Items.AIR))
                .offerTo(exporter, Identifier.tryParse(getRecipeName(Items.PUMPKIN_PIE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PUMPKIN_SEEDS)
                .input(ModItems.PUMPKIN_SLICE)
                .criterion("has_pumpkin", conditionsFromItem(ModItems.PUMPKIN_SLICE))
                .offerTo(exporter, Identifier.tryParse(getRecipeName(Items.PUMPKIN_SEEDS)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.PUMPKIN)
                .input(ModItems.PUMPKIN_SLICE, 9)
                .criterion("has_pumpkin", conditionsFromItem(ModItems.PUMPKIN_SLICE))
                .offerTo(exporter, Identifier.tryParse(getRecipeName(Blocks.PUMPKIN)));
    }

    @Override
    protected Identifier getRecipeIdentifier(Identifier identifier) {
        return Identifier.ofVanilla(identifier.getPath());
    }
}
