package gay.beegirl.datagen;

import gay.beegirl.CustomClasses.BerryBushBlock;
import gay.beegirl.CustomClasses.FlowerCropBlock;
import gay.beegirl.ModBlocks;
import gay.beegirl.ModInit;
import gay.beegirl.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.data.client.*;
import net.minecraft.data.client.BlockStateModelGenerator.TintType;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
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
        registerOreBlock(blockStateModelGenerator, Blocks.COAL_ORE, Blocks.STONE, "coal");
        registerOreBlock(blockStateModelGenerator, Blocks.DEEPSLATE_COAL_ORE, Blocks.DEEPSLATE, "coal");
        registerOreBlock(blockStateModelGenerator, Blocks.IRON_ORE, Blocks.STONE, "iron");
        registerOreBlock(blockStateModelGenerator, Blocks.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE, "iron");
        registerOreBlock(blockStateModelGenerator, Blocks.COPPER_ORE, Blocks.STONE, "copper");
        registerOreBlock(blockStateModelGenerator, Blocks.DEEPSLATE_COPPER_ORE, Blocks.DEEPSLATE, "copper");
        registerOreBlock(blockStateModelGenerator, Blocks.GOLD_ORE, Blocks.STONE, "gold");
        registerOreBlock(blockStateModelGenerator, Blocks.DEEPSLATE_GOLD_ORE, Blocks.DEEPSLATE, "gold");
        registerActivatableOreBlock(blockStateModelGenerator, Blocks.REDSTONE_ORE, Blocks.STONE, "redstone");
        registerActivatableOreBlock(blockStateModelGenerator, Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.DEEPSLATE, "redstone");
        registerOreBlock(blockStateModelGenerator, Blocks.EMERALD_ORE, Blocks.STONE, "emerald");
        registerOreBlock(blockStateModelGenerator, Blocks.DEEPSLATE_EMERALD_ORE, Blocks.DEEPSLATE, "emerald");
        registerOreBlock(blockStateModelGenerator, Blocks.LAPIS_ORE, Blocks.STONE, "lapis");
        registerOreBlock(blockStateModelGenerator, Blocks.DEEPSLATE_LAPIS_ORE, Blocks.DEEPSLATE, "lapis");
        registerOreBlock(blockStateModelGenerator, Blocks.DIAMOND_ORE, Blocks.STONE, "diamond");
        registerOreBlock(blockStateModelGenerator, Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DEEPSLATE, "diamond");
        registerOreBlock(blockStateModelGenerator, Blocks.NETHER_GOLD_ORE, Blocks.NETHERRACK, "gold_nugget");
        registerOreBlock(blockStateModelGenerator, Blocks.NETHER_QUARTZ_ORE, Blocks.NETHERRACK, "nether_quartz");

        registerOreBlock(blockStateModelGenerator, ModBlocks.RUBY_ORE, Blocks.STONE, "ruby");
        registerOreBlock(blockStateModelGenerator, ModBlocks.DEEPSLATE_RUBY_ORE, Blocks.DEEPSLATE, "ruby");

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.SOUR_BERRY_BUSH, TintType.NOT_TINTED, BerryBushBlock.AGE, 0,1,2,3);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.NIGHTSHADE_CROP, TintType.NOT_TINTED, FlowerCropBlock.AGE, 0,1,2);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.NIGHTSHADE, ModBlocks.POTTED_NIGHTSHADE, TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.CAMELIA_CROP, TintType.NOT_TINTED, FlowerCropBlock.AGE, 0,1,2);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CAMELIA, ModBlocks.POTTED_CAMELIA, TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.LAVENDER_CROP, TintType.NOT_TINTED, FlowerCropBlock.AGE, 0,1,2);
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
        itemModelGenerator.register(ModItems.SWEET_BERRY_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWEET_WINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUR_BERRY_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUR_WINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_BERRY_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_BERRY_WINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TUNA, Models.GENERATED);
        itemModelGenerator.register(ModItems.TUNA_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.TUNA_SPAWN_EGG, SPAWN_EGG);
        itemModelGenerator.register(ModItems.VANILLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
    }

    private static final Model SPAWN_EGG = new Model(Optional.of(Identifier.ofVanilla("item/template_spawn_egg")), Optional.empty());

    private void registerOreBlock(@NotNull BlockStateModelGenerator blockStateModelGenerator, Block ore, Block stone, String material){
        Identifier oreModelID = new Model(
                Optional.of(Identifier.of(ModInit.MOD_ID, "block/template_ore")),
                Optional.empty(),
                TextureKey.LAYER0, TextureKey.LAYER1)
                .upload(
                        ore,
                        new TextureMap()
                                .put(TextureKey.LAYER0, TextureMap.getId(stone))
                                .put(TextureKey.LAYER1, Identifier.of(Registries.BLOCK.getEntry(ore).getIdAsString().split(":")[0], "block/"+material+"_ore_overlay")),
                        blockStateModelGenerator.modelCollector
                );

        blockStateModelGenerator.blockStateCollector.accept(createSingletonBlockState(ore, oreModelID));
    }
    private void registerActivatableOreBlock(@NotNull BlockStateModelGenerator blockStateModelGenerator, Block ore, Block stone, String material){
        Identifier oreModelID = new Model(
                Optional.of(Identifier.of(ModInit.MOD_ID, "block/template_ore")),
                Optional.empty(),
                TextureKey.LAYER0, TextureKey.LAYER1)
                .upload(
                        ore,
                        new TextureMap()
                                .put(TextureKey.LAYER0, TextureMap.getId(stone))
                                .put(TextureKey.LAYER1, Identifier.of(Registries.BLOCK.getEntry(ore).getIdAsString().split(":")[0], "block/"+material+"_ore_overlay")),
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
                                .put(TextureKey.LAYER1, Identifier.of(Registries.BLOCK.getEntry(ore).getIdAsString().split(":")[0], "block/"+material+"_ore_overlay_on")),
                        blockStateModelGenerator.modelCollector
                );

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ore)
                .coordinate(createBooleanModelMap(Properties.LIT, oreOnModelID, oreModelID)));
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
