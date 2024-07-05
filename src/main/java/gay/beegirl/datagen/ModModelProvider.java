package gay.beegirl.datagen;

import gay.beegirl.ModBlocks;
import gay.beegirl.ModInit;
import gay.beegirl.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.*;
import net.minecraft.data.client.*;
import net.minecraft.data.client.BlockStateModelGenerator.TintType;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

import static net.minecraft.data.client.BlockStateModelGenerator.createBooleanModelMap;
import static net.minecraft.data.client.BlockStateModelGenerator.createSingletonBlockState;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        registerOreBlock(blockStateModelGenerator, Blocks.COAL_ORE, Blocks.STONE, Identifier.ofVanilla("coal"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.GRANITE_COAL_ORE, Blocks.GRANITE, Identifier.ofVanilla("coal"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DIORITE_COAL_ORE, Blocks.DIORITE, Identifier.ofVanilla("coal"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.ANDESITE_COAL_ORE, Blocks.ANDESITE, Identifier.ofVanilla("coal"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DRIPSTONE_COAL_ORE, Blocks.DRIPSTONE_BLOCK, Identifier.ofVanilla("coal"));
        registerOreBlock(blockStateModelGenerator, Blocks.DEEPSLATE_COAL_ORE, Blocks.DEEPSLATE, Identifier.ofVanilla("coal"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.TUFF_COAL_ORE, Blocks.TUFF, Identifier.ofVanilla("coal"));

        registerOreBlock(blockStateModelGenerator, Blocks.IRON_ORE, Blocks.STONE, Identifier.ofVanilla("iron"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.GRANITE_IRON_ORE, Blocks.GRANITE, Identifier.ofVanilla("iron"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DIORITE_IRON_ORE, Blocks.DIORITE, Identifier.ofVanilla("iron"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.ANDESITE_IRON_ORE, Blocks.ANDESITE, Identifier.ofVanilla("iron"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DRIPSTONE_IRON_ORE, Blocks.DRIPSTONE_BLOCK, Identifier.ofVanilla("iron"));
        registerOreBlock(blockStateModelGenerator, Blocks.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE, Identifier.ofVanilla("iron"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.TUFF_IRON_ORE, Blocks.TUFF, Identifier.ofVanilla("iron"));

        registerOreBlock(blockStateModelGenerator, Blocks.COPPER_ORE, Blocks.STONE, Identifier.ofVanilla("copper"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.GRANITE_COPPER_ORE, Blocks.GRANITE, Identifier.ofVanilla("copper"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DIORITE_COPPER_ORE, Blocks.DIORITE, Identifier.ofVanilla("copper"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.ANDESITE_COPPER_ORE, Blocks.ANDESITE, Identifier.ofVanilla("copper"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DRIPSTONE_COPPER_ORE, Blocks.DRIPSTONE_BLOCK, Identifier.ofVanilla("copper"));
        registerOreBlock(blockStateModelGenerator, Blocks.DEEPSLATE_COPPER_ORE, Blocks.DEEPSLATE, Identifier.ofVanilla("copper"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.TUFF_COPPER_ORE, Blocks.TUFF, Identifier.ofVanilla("copper"));

        registerOreBlock(blockStateModelGenerator, Blocks.GOLD_ORE, Blocks.STONE, Identifier.ofVanilla("gold"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.GRANITE_GOLD_ORE, Blocks.GRANITE, Identifier.ofVanilla("gold"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DIORITE_GOLD_ORE, Blocks.DIORITE, Identifier.ofVanilla("gold"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.ANDESITE_GOLD_ORE, Blocks.ANDESITE, Identifier.ofVanilla("gold"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DRIPSTONE_GOLD_ORE, Blocks.DRIPSTONE_BLOCK, Identifier.ofVanilla("gold"));
        registerOreBlock(blockStateModelGenerator, Blocks.DEEPSLATE_GOLD_ORE, Blocks.DEEPSLATE, Identifier.ofVanilla("gold"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.TUFF_GOLD_ORE, Blocks.TUFF, Identifier.ofVanilla("gold"));

        registerActivatableOreBlock(blockStateModelGenerator, Blocks.REDSTONE_ORE, Blocks.STONE, Identifier.ofVanilla("redstone"));
        registerActivatableOreBlock(blockStateModelGenerator, ModBlocks.GRANITE_REDSTONE_ORE, Blocks.GRANITE, Identifier.ofVanilla("redstone"));
        registerActivatableOreBlock(blockStateModelGenerator, ModBlocks.DIORITE_REDSTONE_ORE, Blocks.DIORITE, Identifier.ofVanilla("redstone"));
        registerActivatableOreBlock(blockStateModelGenerator, ModBlocks.ANDESITE_REDSTONE_ORE, Blocks.ANDESITE, Identifier.ofVanilla("redstone"));
        registerActivatableOreBlock(blockStateModelGenerator, ModBlocks.DRIPSTONE_REDSTONE_ORE, Blocks.DRIPSTONE_BLOCK, Identifier.ofVanilla("redstone"));
        registerActivatableOreBlock(blockStateModelGenerator, Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.DEEPSLATE, Identifier.ofVanilla("redstone"));
        registerActivatableOreBlock(blockStateModelGenerator, ModBlocks.TUFF_REDSTONE_ORE, Blocks.TUFF, Identifier.ofVanilla("redstone"));

        registerOreBlock(blockStateModelGenerator, Blocks.EMERALD_ORE, Blocks.STONE, Identifier.ofVanilla("emerald"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.GRANITE_EMERALD_ORE, Blocks.GRANITE, Identifier.ofVanilla("emerald"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DIORITE_EMERALD_ORE, Blocks.DIORITE, Identifier.ofVanilla("emerald"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.ANDESITE_EMERALD_ORE, Blocks.ANDESITE, Identifier.ofVanilla("emerald"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DRIPSTONE_EMERALD_ORE, Blocks.DRIPSTONE_BLOCK, Identifier.ofVanilla("emerald"));
        registerOreBlock(blockStateModelGenerator, Blocks.DEEPSLATE_EMERALD_ORE, Blocks.DEEPSLATE, Identifier.ofVanilla("emerald"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.TUFF_EMERALD_ORE, Blocks.TUFF, Identifier.ofVanilla("emerald"));

        registerOreBlock(blockStateModelGenerator, Blocks.LAPIS_ORE, Blocks.STONE, Identifier.ofVanilla("lapis"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.GRANITE_LAPIS_ORE, Blocks.GRANITE, Identifier.ofVanilla("lapis"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DIORITE_LAPIS_ORE, Blocks.DIORITE, Identifier.ofVanilla("lapis"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.ANDESITE_LAPIS_ORE, Blocks.ANDESITE, Identifier.ofVanilla("lapis"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DRIPSTONE_LAPIS_ORE, Blocks.DRIPSTONE_BLOCK, Identifier.ofVanilla("lapis"));
        registerOreBlock(blockStateModelGenerator, Blocks.DEEPSLATE_LAPIS_ORE, Blocks.DEEPSLATE, Identifier.ofVanilla("lapis"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.TUFF_LAPIS_ORE, Blocks.TUFF, Identifier.ofVanilla("lapis"));

        registerOreBlock(blockStateModelGenerator, Blocks.DIAMOND_ORE, Blocks.STONE, Identifier.ofVanilla("diamond"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.GRANITE_DIAMOND_ORE, Blocks.GRANITE, Identifier.ofVanilla("diamond"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DIORITE_DIAMOND_ORE, Blocks.DIORITE, Identifier.ofVanilla("diamond"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.ANDESITE_DIAMOND_ORE, Blocks.ANDESITE, Identifier.ofVanilla("diamond"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DRIPSTONE_DIAMOND_ORE, Blocks.DRIPSTONE_BLOCK, Identifier.ofVanilla("diamond"));
        registerOreBlock(blockStateModelGenerator, Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DEEPSLATE, Identifier.ofVanilla("diamond"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.TUFF_DIAMOND_ORE, Blocks.TUFF, Identifier.ofVanilla("diamond"));

        registerOreBlock(blockStateModelGenerator, Blocks.NETHER_GOLD_ORE, Blocks.NETHERRACK, Identifier.ofVanilla("gold_nugget"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.BLACKSTONE_GOLD_ORE, Blocks.BLACKSTONE, Identifier.ofVanilla("gold_nugget"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.BASALT_GOLD_ORE, Blocks.SMOOTH_BASALT, Identifier.ofVanilla("gold_nugget"));
        registerOreBlock(blockStateModelGenerator, Blocks.NETHER_QUARTZ_ORE, Blocks.NETHERRACK, Identifier.ofVanilla("nether_quartz"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.BLACKSTONE_QUARTZ_ORE, Blocks.BLACKSTONE, Identifier.ofVanilla("nether_quartz"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.BASALT_QUARTZ_ORE, Blocks.SMOOTH_BASALT, Identifier.ofVanilla("nether_quartz"));

        registerOreBlock(blockStateModelGenerator, ModBlocks.WHITE_QUARTZ_ORE, Blocks.STONE, Identifier.of(ModInit.MOD_ID, "white_quartz"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.GRANITE_WHITE_QUARTZ_ORE, Blocks.GRANITE, Identifier.of(ModInit.MOD_ID, "white_quartz"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DIORITE_WHITE_QUARTZ_ORE, Blocks.DIORITE, Identifier.of(ModInit.MOD_ID, "white_quartz"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.ANDESITE_WHITE_QUARTZ_ORE, Blocks.ANDESITE, Identifier.of(ModInit.MOD_ID, "white_quartz"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DRIPSTONE_WHITE_QUARTZ_ORE, Blocks.DRIPSTONE_BLOCK, Identifier.of(ModInit.MOD_ID, "white_quartz"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DEEPSLATE_WHITE_QUARTZ_ORE, Blocks.DEEPSLATE, Identifier.of(ModInit.MOD_ID, "white_quartz"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.TUFF_WHITE_QUARTZ_ORE, Blocks.TUFF, Identifier.of(ModInit.MOD_ID, "white_quartz"));

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
        registerOreBlock(blockStateModelGenerator, ModBlocks.RUBY_ORE, Blocks.STONE, Identifier.of(ModInit.MOD_ID, "ruby"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.GRANITE_RUBY_ORE, Blocks.GRANITE, Identifier.of(ModInit.MOD_ID, "ruby"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DIORITE_RUBY_ORE, Blocks.DIORITE, Identifier.of(ModInit.MOD_ID, "ruby"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.ANDESITE_RUBY_ORE, Blocks.ANDESITE, Identifier.of(ModInit.MOD_ID, "ruby"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DRIPSTONE_RUBY_ORE, Blocks.DRIPSTONE_BLOCK, Identifier.of(ModInit.MOD_ID, "ruby"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DEEPSLATE_RUBY_ORE, Blocks.DEEPSLATE, Identifier.of(ModInit.MOD_ID, "ruby"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.TUFF_RUBY_ORE, Blocks.TUFF, Identifier.of(ModInit.MOD_ID, "ruby"));

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK);
        registerOreBlock(blockStateModelGenerator, ModBlocks.SAPPHIRE_ORE, Blocks.STONE, Identifier.of(ModInit.MOD_ID, "sapphire"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.GRANITE_SAPPHIRE_ORE, Blocks.GRANITE, Identifier.of(ModInit.MOD_ID, "sapphire"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DIORITE_SAPPHIRE_ORE, Blocks.DIORITE, Identifier.of(ModInit.MOD_ID, "sapphire"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.ANDESITE_SAPPHIRE_ORE, Blocks.ANDESITE, Identifier.of(ModInit.MOD_ID, "sapphire"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DRIPSTONE_SAPPHIRE_ORE, Blocks.DRIPSTONE_BLOCK, Identifier.of(ModInit.MOD_ID, "sapphire"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DEEPSLATE_SAPPHIRE_ORE, Blocks.DEEPSLATE, Identifier.of(ModInit.MOD_ID, "sapphire"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.TUFF_SAPPHIRE_ORE, Blocks.TUFF, Identifier.of(ModInit.MOD_ID, "sapphire"));

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOPAZ_BLOCK);
        registerOreBlock(blockStateModelGenerator, ModBlocks.TOPAZ_ORE, Blocks.STONE, Identifier.of(ModInit.MOD_ID, "topaz"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.GRANITE_TOPAZ_ORE, Blocks.GRANITE, Identifier.of(ModInit.MOD_ID, "topaz"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DIORITE_TOPAZ_ORE, Blocks.DIORITE, Identifier.of(ModInit.MOD_ID, "topaz"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.ANDESITE_TOPAZ_ORE, Blocks.ANDESITE, Identifier.of(ModInit.MOD_ID, "topaz"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DRIPSTONE_TOPAZ_ORE, Blocks.DRIPSTONE_BLOCK, Identifier.of(ModInit.MOD_ID, "topaz"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DEEPSLATE_TOPAZ_ORE, Blocks.DEEPSLATE, Identifier.of(ModInit.MOD_ID, "topaz"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.TUFF_TOPAZ_ORE, Blocks.TUFF, Identifier.of(ModInit.MOD_ID, "topaz"));

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CITRINE_BLOCK);
        registerOreBlock(blockStateModelGenerator, ModBlocks.CITRINE_ORE, Blocks.STONE, Identifier.of(ModInit.MOD_ID, "citrine"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.GRANITE_CITRINE_ORE, Blocks.GRANITE, Identifier.of(ModInit.MOD_ID, "citrine"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DIORITE_CITRINE_ORE, Blocks.DIORITE, Identifier.of(ModInit.MOD_ID, "citrine"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.ANDESITE_CITRINE_ORE, Blocks.ANDESITE, Identifier.of(ModInit.MOD_ID, "citrine"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DRIPSTONE_CITRINE_ORE, Blocks.DRIPSTONE_BLOCK, Identifier.of(ModInit.MOD_ID, "citrine"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DEEPSLATE_CITRINE_ORE, Blocks.DEEPSLATE, Identifier.of(ModInit.MOD_ID, "citrine"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.TUFF_CITRINE_ORE, Blocks.TUFF, Identifier.of(ModInit.MOD_ID, "citrine"));

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALEXANDRITE_BLOCK);
        registerOreBlock(blockStateModelGenerator, ModBlocks.ALEXANDRITE_ORE, Blocks.STONE, Identifier.of(ModInit.MOD_ID, "alexandrite"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.GRANITE_ALEXANDRITE_ORE, Blocks.GRANITE, Identifier.of(ModInit.MOD_ID, "alexandrite"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DIORITE_ALEXANDRITE_ORE, Blocks.DIORITE, Identifier.of(ModInit.MOD_ID, "alexandrite"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.ANDESITE_ALEXANDRITE_ORE, Blocks.ANDESITE, Identifier.of(ModInit.MOD_ID, "alexandrite"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DRIPSTONE_ALEXANDRITE_ORE, Blocks.DRIPSTONE_BLOCK, Identifier.of(ModInit.MOD_ID, "alexandrite"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DEEPSLATE_ALEXANDRITE_ORE, Blocks.DEEPSLATE, Identifier.of(ModInit.MOD_ID, "alexandrite"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.TUFF_ALEXANDRITE_ORE, Blocks.TUFF, Identifier.of(ModInit.MOD_ID, "alexandrite"));

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPINEL_BLOCK);
        registerOreBlock(blockStateModelGenerator, ModBlocks.SPINEL_ORE, Blocks.STONE, Identifier.of(ModInit.MOD_ID, "spinel"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.GRANITE_SPINEL_ORE, Blocks.GRANITE, Identifier.of(ModInit.MOD_ID, "spinel"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DIORITE_SPINEL_ORE, Blocks.DIORITE, Identifier.of(ModInit.MOD_ID, "spinel"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.ANDESITE_SPINEL_ORE, Blocks.ANDESITE, Identifier.of(ModInit.MOD_ID, "spinel"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DRIPSTONE_SPINEL_ORE, Blocks.DRIPSTONE_BLOCK, Identifier.of(ModInit.MOD_ID, "spinel"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.DEEPSLATE_SPINEL_ORE, Blocks.DEEPSLATE, Identifier.of(ModInit.MOD_ID, "spinel"));
        registerOreBlock(blockStateModelGenerator, ModBlocks.TUFF_SPINEL_ORE, Blocks.TUFF, Identifier.of(ModInit.MOD_ID, "spinel"));

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(Blocks.TORCHFLOWER_CROP, TintType.NOT_TINTED, TorchflowerBlock.AGE, 0,1,2);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.SOUR_BERRY_BUSH, TintType.NOT_TINTED, SweetBerryBushBlock.AGE, 0,1,2,3);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.NIGHTSHADE_CROP, TintType.NOT_TINTED, TorchflowerBlock.AGE, 0,1,2);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.NIGHTSHADE, ModBlocks.POTTED_NIGHTSHADE, TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.CAMELIA_CROP, TintType.NOT_TINTED, TorchflowerBlock.AGE, 0,1,2);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CAMELIA, ModBlocks.POTTED_CAMELIA, TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.LAVENDER_CROP, TintType.NOT_TINTED, TorchflowerBlock.AGE, 0,1,2);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LAVENDER, ModBlocks.POTTED_LAVENDER, TintType.NOT_TINTED);
        blockStateModelGenerator.registerCrop(ModBlocks.VANILLA_CROP, CropBlock.AGE, 0,0,1,1,2,2,2,3);
    }

    @Override
    public void generateItemModels(@NotNull ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModBlocks.SPONGE_CAKE.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.CHOCOLATE_CAKE.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.RED_VELVET_CAKE.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.CARROT_CAKE.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.PUMPKIN_PIE.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.APPLE_PIE.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BERRY_PIE.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.PANCAKES.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.TREACLE_TART.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.FLAN.asItem(), Models.GENERATED);

        itemModelGenerator.register(ModItems.BREADCRUMBS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CUSTARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLESH_JERKY, Models.GENERATED);
        itemModelGenerator.register(ModItems.PUMPKIN_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TUNA, Models.GENERATED);
        itemModelGenerator.register(ModItems.TUNA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.TUNA_SPAWN_EGG, SPAWN_EGG);

        itemModelGenerator.register(ModItems.SWEET_BERRY_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWEET_WINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUR_BERRY_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUR_WINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_BERRY_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_BERRY_WINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VANILLA, Models.GENERATED);

        itemModelGenerator.register(ModItems.WHITE_QUARTZ, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOPAZ, Models.GENERATED);
        itemModelGenerator.register(ModItems.CITRINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ALEXANDRITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPINEL, Models.GENERATED);
    }

    private static final Model SPAWN_EGG = new Model(Optional.of(Identifier.ofVanilla("item/template_spawn_egg")), Optional.empty());

    private void registerOreBlock(@NotNull BlockStateModelGenerator blockStateModelGenerator, Block ore, Block stone, Identifier material){
        Identifier oreModelID = new Model(
                Optional.of(Identifier.of(ModInit.MOD_ID, "block/template_ore")),
                Optional.empty(),
                TextureKey.LAYER0, TextureKey.LAYER1)
                .upload(
                        ore,
                        new TextureMap()
                                .put(TextureKey.LAYER0, TextureMap.getId(stone))
                                .put(TextureKey.LAYER1, material.withPrefixedPath("block/").withSuffixedPath("_ore_overlay")),
                        blockStateModelGenerator.modelCollector
                );

        blockStateModelGenerator.blockStateCollector.accept(createSingletonBlockState(ore, oreModelID));
    }
    private void registerActivatableOreBlock(@NotNull BlockStateModelGenerator blockStateModelGenerator, Block ore, Block stone, Identifier material){
        Identifier oreModelID = new Model(
                Optional.of(Identifier.of(ModInit.MOD_ID, "block/template_ore")),
                Optional.empty(),
                TextureKey.LAYER0, TextureKey.LAYER1)
                .upload(
                        ore,
                        new TextureMap()
                                .put(TextureKey.LAYER0, TextureMap.getId(stone))
                                .put(TextureKey.LAYER1, material.withPrefixedPath("block/").withSuffixedPath("_ore_overlay")),
                        blockStateModelGenerator.modelCollector
                );
        Identifier oreOnModelID = new Model(
                Optional.of(Identifier.of(ModInit.MOD_ID, "block/template_ore")),
                Optional.empty(),
                TextureKey.LAYER0, TextureKey.LAYER1)
                .upload(
                        ore,
                        "_on",
                        new TextureMap()
                                .put(TextureKey.LAYER0, TextureMap.getId(stone))
                                .put(TextureKey.LAYER1, material.withPrefixedPath("block/").withSuffixedPath("_ore_overlay_on")),
                        blockStateModelGenerator.modelCollector
                );

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ore)
                .coordinate(createBooleanModelMap(Properties.LIT, oreOnModelID, oreModelID)));

        blockStateModelGenerator.registerParentedItemModel(ore, oreOnModelID);
    }

    /*private BlockStateProvider registerPlaceableFood(PlaceableFoodBlock block, Property<Integer> ageProperty, int... ageModelIndices){
        if (ageProperty.getValues().size() != ageModelIndices.length) {
            int[] temp = new int[ageProperty.getValues().size()];
            Arrays.fill(temp, block.MAX_BITES);
            System.arraycopy(ageModelIndices, 0, temp, 0, ageModelIndices.length);
            ageModelIndices = temp;
        }
        return MultipartBlockStateSupplier.create(block)
                .with(When.create().set(ageProperty, 0),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, )
                .with(When.create().set(ageProperty, 1),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, )
                .with(When.create().set(ageProperty, 2),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, )
                .with(When.create().set(ageProperty, 3),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, ));
    }*/
}