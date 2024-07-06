package gay.beegirl.DataGen;

import gay.beegirl.Item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.FISHES).add(ModItems.TUNA);
        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS).add(ModItems.WHITE_QUARTZ);
        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS).add(ModItems.RUBY);
        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS).add(ModItems.SAPPHIRE);
        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS).add(ModItems.TOPAZ);
        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS).add(ModItems.CITRINE);
        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS).add(ModItems.ALEXANDRITE);
        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS).add(ModItems.SPINEL);
        getOrCreateTagBuilder(ItemTags.VILLAGER_PLANTABLE_SEEDS).add(ModItems.NIGHTSHADE_SEEDS);
        getOrCreateTagBuilder(ItemTags.VILLAGER_PLANTABLE_SEEDS).add(ModItems.CAMELIA_SEEDS);
        getOrCreateTagBuilder(ItemTags.VILLAGER_PLANTABLE_SEEDS).add(ModItems.LAVENDER_SEEDS);
        getOrCreateTagBuilder(ItemTags.VILLAGER_PLANTABLE_SEEDS).add(ModItems.VANILLA_SEEDS);
    }
}
