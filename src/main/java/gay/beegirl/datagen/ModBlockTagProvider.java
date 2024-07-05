package gay.beegirl.datagen;

import gay.beegirl.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.CROPS).add(ModBlocks.VANILLA_CROP);
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(ModBlocks.RUBY_BLOCK);
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(ModBlocks.SAPPHIRE_BLOCK);
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(ModBlocks.TOPAZ_BLOCK);
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(ModBlocks.CITRINE_BLOCK);
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(ModBlocks.ALEXANDRITE_BLOCK);
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(ModBlocks.SPINEL_BLOCK);
        getOrCreateTagBuilder(BlockTags.BEE_GROWABLES).add(ModBlocks.SOUR_BERRY_BUSH);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(ModBlocks.POTTED_NIGHTSHADE);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(ModBlocks.POTTED_CAMELIA);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(ModBlocks.POTTED_LAVENDER);
        getOrCreateTagBuilder(BlockTags.MAINTAINS_FARMLAND).add(ModBlocks.NIGHTSHADE_CROP);
        getOrCreateTagBuilder(BlockTags.MAINTAINS_FARMLAND).add(ModBlocks.NIGHTSHADE);
        getOrCreateTagBuilder(BlockTags.MAINTAINS_FARMLAND).add(ModBlocks.CAMELIA_CROP);
        getOrCreateTagBuilder(BlockTags.MAINTAINS_FARMLAND).add(ModBlocks.CAMELIA);
        getOrCreateTagBuilder(BlockTags.MAINTAINS_FARMLAND).add(ModBlocks.LAVENDER_CROP);
        getOrCreateTagBuilder(BlockTags.MAINTAINS_FARMLAND).add(ModBlocks.LAVENDER);
        getOrCreateTagBuilder(BlockTags.MAINTAINS_FARMLAND).add(ModBlocks.VANILLA_CROP);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(ModBlocks.NIGHTSHADE);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(ModBlocks.CAMELIA);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(ModBlocks.LAVENDER);

        getOrCreateTagBuilder(BlockTags.COAL_ORES).add(ModBlocks.GRANITE_COAL_ORE);
        getOrCreateTagBuilder(BlockTags.COAL_ORES).add(ModBlocks.DIORITE_COAL_ORE);
        getOrCreateTagBuilder(BlockTags.COAL_ORES).add(ModBlocks.ANDESITE_COAL_ORE);
        getOrCreateTagBuilder(BlockTags.COAL_ORES).add(ModBlocks.DRIPSTONE_COAL_ORE);
        getOrCreateTagBuilder(BlockTags.COAL_ORES).add(ModBlocks.TUFF_COAL_ORE);
        getOrCreateTagBuilder(BlockTags.IRON_ORES).add(ModBlocks.GRANITE_IRON_ORE);
        getOrCreateTagBuilder(BlockTags.IRON_ORES).add(ModBlocks.DIORITE_IRON_ORE);
        getOrCreateTagBuilder(BlockTags.IRON_ORES).add(ModBlocks.ANDESITE_IRON_ORE);
        getOrCreateTagBuilder(BlockTags.IRON_ORES).add(ModBlocks.DRIPSTONE_IRON_ORE);
        getOrCreateTagBuilder(BlockTags.IRON_ORES).add(ModBlocks.TUFF_IRON_ORE);
        getOrCreateTagBuilder(BlockTags.COPPER_ORES).add(ModBlocks.GRANITE_COPPER_ORE);
        getOrCreateTagBuilder(BlockTags.COPPER_ORES).add(ModBlocks.DIORITE_COPPER_ORE);
        getOrCreateTagBuilder(BlockTags.COPPER_ORES).add(ModBlocks.ANDESITE_COPPER_ORE);
        getOrCreateTagBuilder(BlockTags.COPPER_ORES).add(ModBlocks.DRIPSTONE_COPPER_ORE);
        getOrCreateTagBuilder(BlockTags.COPPER_ORES).add(ModBlocks.TUFF_COPPER_ORE);
        getOrCreateTagBuilder(BlockTags.GOLD_ORES).add(ModBlocks.GRANITE_GOLD_ORE);
        getOrCreateTagBuilder(BlockTags.GOLD_ORES).add(ModBlocks.DIORITE_GOLD_ORE);
        getOrCreateTagBuilder(BlockTags.GOLD_ORES).add(ModBlocks.ANDESITE_GOLD_ORE);
        getOrCreateTagBuilder(BlockTags.GOLD_ORES).add(ModBlocks.DRIPSTONE_GOLD_ORE);
        getOrCreateTagBuilder(BlockTags.GOLD_ORES).add(ModBlocks.TUFF_GOLD_ORE);
        getOrCreateTagBuilder(BlockTags.GOLD_ORES).add(ModBlocks.BLACKSTONE_GOLD_ORE);
        getOrCreateTagBuilder(BlockTags.GOLD_ORES).add(ModBlocks.BASALT_GOLD_ORE);
        getOrCreateTagBuilder(BlockTags.REDSTONE_ORES).add(ModBlocks.GRANITE_REDSTONE_ORE);
        getOrCreateTagBuilder(BlockTags.REDSTONE_ORES).add(ModBlocks.DIORITE_REDSTONE_ORE);
        getOrCreateTagBuilder(BlockTags.REDSTONE_ORES).add(ModBlocks.ANDESITE_REDSTONE_ORE);
        getOrCreateTagBuilder(BlockTags.REDSTONE_ORES).add(ModBlocks.DRIPSTONE_REDSTONE_ORE);
        getOrCreateTagBuilder(BlockTags.REDSTONE_ORES).add(ModBlocks.TUFF_REDSTONE_ORE);
        getOrCreateTagBuilder(BlockTags.EMERALD_ORES).add(ModBlocks.GRANITE_EMERALD_ORE);
        getOrCreateTagBuilder(BlockTags.EMERALD_ORES).add(ModBlocks.DIORITE_EMERALD_ORE);
        getOrCreateTagBuilder(BlockTags.EMERALD_ORES).add(ModBlocks.ANDESITE_EMERALD_ORE);
        getOrCreateTagBuilder(BlockTags.EMERALD_ORES).add(ModBlocks.DRIPSTONE_EMERALD_ORE);
        getOrCreateTagBuilder(BlockTags.EMERALD_ORES).add(ModBlocks.TUFF_EMERALD_ORE);
        getOrCreateTagBuilder(BlockTags.LAPIS_ORES).add(ModBlocks.GRANITE_LAPIS_ORE);
        getOrCreateTagBuilder(BlockTags.LAPIS_ORES).add(ModBlocks.DIORITE_LAPIS_ORE);
        getOrCreateTagBuilder(BlockTags.LAPIS_ORES).add(ModBlocks.ANDESITE_LAPIS_ORE);
        getOrCreateTagBuilder(BlockTags.LAPIS_ORES).add(ModBlocks.DRIPSTONE_LAPIS_ORE);
        getOrCreateTagBuilder(BlockTags.LAPIS_ORES).add(ModBlocks.TUFF_LAPIS_ORE);
        getOrCreateTagBuilder(BlockTags.DIAMOND_ORES).add(ModBlocks.GRANITE_DIAMOND_ORE);
        getOrCreateTagBuilder(BlockTags.DIAMOND_ORES).add(ModBlocks.DIORITE_DIAMOND_ORE);
        getOrCreateTagBuilder(BlockTags.DIAMOND_ORES).add(ModBlocks.ANDESITE_DIAMOND_ORE);
        getOrCreateTagBuilder(BlockTags.DIAMOND_ORES).add(ModBlocks.DRIPSTONE_DIAMOND_ORE);
        getOrCreateTagBuilder(BlockTags.DIAMOND_ORES).add(ModBlocks.TUFF_DIAMOND_ORE);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.GRANITE_COAL_ORE);
    }
}
