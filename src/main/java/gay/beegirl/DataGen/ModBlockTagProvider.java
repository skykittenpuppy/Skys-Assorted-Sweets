package gay.beegirl.DataGen;

import gay.beegirl.Block.ModBlocks;
import gay.beegirl.ModInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    private static final TagKey<Block> NETHER_QUARTZ_ORES = TagKey.of(RegistryKeys.BLOCK, Identifier.ofVanilla("nether_quartz_ores"));
    private static final TagKey<Block> RUBY_ORES = TagKey.of(RegistryKeys.BLOCK, Identifier.of(ModInit.MOD_ID, "ruby_ores"));
    private static final TagKey<Block> SAPPHIRE_ORES = TagKey.of(RegistryKeys.BLOCK, Identifier.of(ModInit.MOD_ID, "sapphire_ores"));
    private static final TagKey<Block> TOPAZ_ORES = TagKey.of(RegistryKeys.BLOCK, Identifier.of(ModInit.MOD_ID, "topaz_ores"));
    private static final TagKey<Block> CITRINE_ORES = TagKey.of(RegistryKeys.BLOCK, Identifier.of(ModInit.MOD_ID, "citrine_ores"));
    private static final TagKey<Block> ALEXANDRITE_ORES = TagKey.of(RegistryKeys.BLOCK, Identifier.of(ModInit.MOD_ID, "alexandrite_ores"));
    private static final TagKey<Block> SPINEL_ORES = TagKey.of(RegistryKeys.BLOCK, Identifier.of(ModInit.MOD_ID, "spinel_ores"));
    private static final TagKey<Block> WHITE_QUARTZ_ORES = TagKey.of(RegistryKeys.BLOCK, Identifier.of(ModInit.MOD_ID, "white_quartz_ores"));

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
        getOrCreateTagBuilder(NETHER_QUARTZ_ORES).add(Blocks.NETHER_QUARTZ_ORE);
        getOrCreateTagBuilder(NETHER_QUARTZ_ORES).add(ModBlocks.BLACKSTONE_QUARTZ_ORE);
        getOrCreateTagBuilder(NETHER_QUARTZ_ORES).add(ModBlocks.BASALT_QUARTZ_ORE);
        getOrCreateTagBuilder(RUBY_ORES).add(ModBlocks.RUBY_ORE);
        getOrCreateTagBuilder(RUBY_ORES).add(ModBlocks.GRANITE_RUBY_ORE);
        getOrCreateTagBuilder(RUBY_ORES).add(ModBlocks.DIORITE_RUBY_ORE);
        getOrCreateTagBuilder(RUBY_ORES).add(ModBlocks.ANDESITE_RUBY_ORE);
        getOrCreateTagBuilder(RUBY_ORES).add(ModBlocks.DRIPSTONE_RUBY_ORE);
        getOrCreateTagBuilder(RUBY_ORES).add(ModBlocks.DEEPSLATE_RUBY_ORE);
        getOrCreateTagBuilder(RUBY_ORES).add(ModBlocks.TUFF_RUBY_ORE);
        getOrCreateTagBuilder(SAPPHIRE_ORES).add(ModBlocks.SAPPHIRE_ORE);
        getOrCreateTagBuilder(SAPPHIRE_ORES).add(ModBlocks.GRANITE_SAPPHIRE_ORE);
        getOrCreateTagBuilder(SAPPHIRE_ORES).add(ModBlocks.DIORITE_SAPPHIRE_ORE);
        getOrCreateTagBuilder(SAPPHIRE_ORES).add(ModBlocks.ANDESITE_SAPPHIRE_ORE);
        getOrCreateTagBuilder(SAPPHIRE_ORES).add(ModBlocks.DRIPSTONE_SAPPHIRE_ORE);
        getOrCreateTagBuilder(SAPPHIRE_ORES).add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        getOrCreateTagBuilder(SAPPHIRE_ORES).add(ModBlocks.TUFF_SAPPHIRE_ORE);
        getOrCreateTagBuilder(TOPAZ_ORES).add(ModBlocks.TOPAZ_ORE);
        getOrCreateTagBuilder(TOPAZ_ORES).add(ModBlocks.GRANITE_TOPAZ_ORE);
        getOrCreateTagBuilder(TOPAZ_ORES).add(ModBlocks.DIORITE_TOPAZ_ORE);
        getOrCreateTagBuilder(TOPAZ_ORES).add(ModBlocks.ANDESITE_TOPAZ_ORE);
        getOrCreateTagBuilder(TOPAZ_ORES).add(ModBlocks.DRIPSTONE_TOPAZ_ORE);
        getOrCreateTagBuilder(TOPAZ_ORES).add(ModBlocks.DEEPSLATE_TOPAZ_ORE);
        getOrCreateTagBuilder(TOPAZ_ORES).add(ModBlocks.TUFF_TOPAZ_ORE);
        getOrCreateTagBuilder(CITRINE_ORES).add(ModBlocks.CITRINE_ORE);
        getOrCreateTagBuilder(CITRINE_ORES).add(ModBlocks.GRANITE_CITRINE_ORE);
        getOrCreateTagBuilder(CITRINE_ORES).add(ModBlocks.DIORITE_CITRINE_ORE);
        getOrCreateTagBuilder(CITRINE_ORES).add(ModBlocks.ANDESITE_CITRINE_ORE);
        getOrCreateTagBuilder(CITRINE_ORES).add(ModBlocks.DRIPSTONE_CITRINE_ORE);
        getOrCreateTagBuilder(CITRINE_ORES).add(ModBlocks.DEEPSLATE_CITRINE_ORE);
        getOrCreateTagBuilder(CITRINE_ORES).add(ModBlocks.TUFF_CITRINE_ORE);
        getOrCreateTagBuilder(ALEXANDRITE_ORES).add(ModBlocks.ALEXANDRITE_ORE);
        getOrCreateTagBuilder(ALEXANDRITE_ORES).add(ModBlocks.GRANITE_ALEXANDRITE_ORE);
        getOrCreateTagBuilder(ALEXANDRITE_ORES).add(ModBlocks.DIORITE_ALEXANDRITE_ORE);
        getOrCreateTagBuilder(ALEXANDRITE_ORES).add(ModBlocks.ANDESITE_ALEXANDRITE_ORE);
        getOrCreateTagBuilder(ALEXANDRITE_ORES).add(ModBlocks.DRIPSTONE_ALEXANDRITE_ORE);
        getOrCreateTagBuilder(ALEXANDRITE_ORES).add(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE);
        getOrCreateTagBuilder(ALEXANDRITE_ORES).add(ModBlocks.TUFF_ALEXANDRITE_ORE);
        getOrCreateTagBuilder(SPINEL_ORES).add(ModBlocks.SPINEL_ORE);
        getOrCreateTagBuilder(SPINEL_ORES).add(ModBlocks.GRANITE_SPINEL_ORE);
        getOrCreateTagBuilder(SPINEL_ORES).add(ModBlocks.DIORITE_SPINEL_ORE);
        getOrCreateTagBuilder(SPINEL_ORES).add(ModBlocks.ANDESITE_SPINEL_ORE);
        getOrCreateTagBuilder(SPINEL_ORES).add(ModBlocks.DRIPSTONE_SPINEL_ORE);
        getOrCreateTagBuilder(SPINEL_ORES).add(ModBlocks.DEEPSLATE_SPINEL_ORE);
        getOrCreateTagBuilder(SPINEL_ORES).add(ModBlocks.TUFF_SPINEL_ORE);
        getOrCreateTagBuilder(WHITE_QUARTZ_ORES).add(ModBlocks.WHITE_QUARTZ_ORE);
        getOrCreateTagBuilder(WHITE_QUARTZ_ORES).add(ModBlocks.GRANITE_WHITE_QUARTZ_ORE);
        getOrCreateTagBuilder(WHITE_QUARTZ_ORES).add(ModBlocks.DIORITE_WHITE_QUARTZ_ORE);
        getOrCreateTagBuilder(WHITE_QUARTZ_ORES).add(ModBlocks.ANDESITE_WHITE_QUARTZ_ORE);
        getOrCreateTagBuilder(WHITE_QUARTZ_ORES).add(ModBlocks.DRIPSTONE_WHITE_QUARTZ_ORE);
        getOrCreateTagBuilder(WHITE_QUARTZ_ORES).add(ModBlocks.DEEPSLATE_WHITE_QUARTZ_ORE);
        getOrCreateTagBuilder(WHITE_QUARTZ_ORES).add(ModBlocks.TUFF_WHITE_QUARTZ_ORE);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).addTag(BlockTags.COAL_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).addTag(BlockTags.IRON_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).addTag(BlockTags.COPPER_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).addTag(BlockTags.GOLD_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).addTag(BlockTags.REDSTONE_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).addTag(BlockTags.EMERALD_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).addTag(BlockTags.LAPIS_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).addTag(BlockTags.DIAMOND_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).addTag(NETHER_QUARTZ_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).addTag(RUBY_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).addTag(SAPPHIRE_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).addTag(TOPAZ_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).addTag(CITRINE_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).addTag(ALEXANDRITE_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).addTag(SPINEL_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).addTag(WHITE_QUARTZ_ORES);
    }
}
