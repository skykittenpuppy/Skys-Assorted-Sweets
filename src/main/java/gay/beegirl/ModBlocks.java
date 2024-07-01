package gay.beegirl;

import gay.beegirl.CustomClasses.FlowerCropBlock;
import gay.beegirl.CustomClasses.PlaceableFoodBlock;
import gay.beegirl.CustomClasses.SourBerryBushBlock;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class ModBlocks {
    public static void registerModBlocks(){
        ModInit.LOGGER.info("Registering Blocks");
    }
    private static Block registerBlock(String name, Block block, boolean hasBlockItem){
        if (hasBlockItem) {
            Registry.register(
                Registries.ITEM,
                Identifier.tryParse(ModInit.MOD_ID, name),
                new BlockItem(block, new Item.Settings())
            );
        }
        return Registry.register(
                Registries.BLOCK,
                Identifier.tryParse(ModInit.MOD_ID, name),
                block
        );
    }

    public static final Block SPONGE_CAKE = registerBlock("sponge_cake", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            7, 2, 0.1F,
            new VoxelShape[]{
                    Block.createCuboidShape(13.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(11.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(09.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(07.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(05.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(03.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(01.0, 00.0, 01.0, 15.0, 08.0, 15.0),
            }
    ), true);
    public static final Block CHOCOLATE_CAKE = registerBlock("chocolate_cake", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            7, 2, 0.1F,
            new VoxelShape[]{
                    Block.createCuboidShape(13.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(11.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(09.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(07.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(05.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(03.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(01.0, 00.0, 01.0, 15.0, 08.0, 15.0),
            }
    ), true);
    public static final Block RED_VELVET_CAKE = registerBlock("red_velvet_cake", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            7, 2, 0.1F,
            new VoxelShape[]{
                    Block.createCuboidShape(13.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(11.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(09.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(07.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(05.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(03.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(01.0, 00.0, 01.0, 15.0, 08.0, 15.0),
            }
    ), true);
    public static final Block CARROT_CAKE = registerBlock("carrot_cake", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            7, 2, 0.1F,
            new VoxelShape[]{
                    Block.createCuboidShape(13.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(11.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(09.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(07.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(05.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(03.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(01.0, 00.0, 01.0, 15.0, 08.0, 15.0),
            }
    ), true);
    public static final Block PUMPKIN_PIE = registerBlock("pumpkin_pie", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            4, 2, 0.1F,
            new VoxelShape[]{
                    Block.createCuboidShape(08.0, 00.0, 08.0, 13.0, 04.0, 13.0),
                    Block.createCuboidShape(08.0, 00.0, 03.0, 13.0, 04.0, 13.0),
                    VoxelShapes.union(
                        Block.createCuboidShape(08.0, 00.0, 03.0, 13.0, 04.0, 13.0),
                        Block.createCuboidShape(03.0, 00.0, 03.0, 13.0, 04.0, 8.0)),
                    Block.createCuboidShape(03.0, 00.0, 03.0, 13.0, 04.0, 13.0),
            }
    ), true);
    public static final Block APPLE_PIE = registerBlock("apple_pie", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            4, 2, 0.1F,
            new VoxelShape[]{
                    Block.createCuboidShape(08.0, 00.0, 08.0, 13.0, 04.0, 13.0),
                    Block.createCuboidShape(08.0, 00.0, 03.0, 13.0, 04.0, 13.0),
                    VoxelShapes.union(
                            Block.createCuboidShape(08.0, 00.0, 03.0, 13.0, 04.0, 13.0),
                            Block.createCuboidShape(03.0, 00.0, 03.0, 13.0, 04.0, 8.0)),
                    Block.createCuboidShape(03.0, 00.0, 03.0, 13.0, 04.0, 13.0),
            }
    ), true);
    public static final Block BERRY_PIE = registerBlock("berry_pie", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            4, 2, 0.1F,
            new VoxelShape[]{
                    Block.createCuboidShape(08.0, 00.0, 08.0, 13.0, 04.0, 13.0),
                    Block.createCuboidShape(08.0, 00.0, 03.0, 13.0, 04.0, 13.0),
                    VoxelShapes.union(
                            Block.createCuboidShape(08.0, 00.0, 03.0, 13.0, 04.0, 13.0),
                            Block.createCuboidShape(03.0, 00.0, 03.0, 13.0, 04.0, 8.0)),
                    Block.createCuboidShape(03.0, 00.0, 03.0, 13.0, 04.0, 13.0),
            }
    ), true);
    public static final Block PANCAKES = registerBlock("pancakes", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            5, 2, 0.1F,
            new VoxelShape[]{
                    Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 02.0, 12.0),
                    Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 03.0, 12.0),
                    Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 04.0, 12.0),
                    Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 05.0, 12.0),
                    Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 06.0, 12.0),
            }
    ), true);
    public static final Block TREACLE_TART = registerBlock("treacle_tart", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            2, 2, 0.1F,
            new VoxelShape[]{
                    Block.createCuboidShape(08.0, 00.0, 04.0, 12.0, 04.0, 12.0),
                    Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 04.0, 12.0),
            }
    ), true);
    // TEMP: Copy of tart
    public static final Block FLAN = registerBlock("flan", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            2, 2, 0.1F,
            new VoxelShape[]{
                    Block.createCuboidShape(08.0, 00.0, 04.0, 12.0, 04.0, 12.0),
                    Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 04.0, 12.0),
            }
    ), true);

    public static final Block SOUR_BERRY_BUSH = registerBlock("sour_berry_bush", new SourBerryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)), false);
    public static final Block TORCHFLOWER = registerBlock("torchflower", new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F,AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)), true);
    public static final Block POTTED_TORCHFLOWER = registerBlock("potted_torchflower", new FlowerPotBlock(TORCHFLOWER, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)), false);
    public static final Block TORCHFLOWER_CROP = registerBlock("torchflower_crop", new FlowerCropBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY), TORCHFLOWER, ModItems.TORCHFLOWER_SEEDS), false);
}
