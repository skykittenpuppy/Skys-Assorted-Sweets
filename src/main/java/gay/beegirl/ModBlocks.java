package gay.beegirl;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class ModBlocks {
    public static void registerModBlocks(){
        ExampleMod.LOGGER.info("Registering Blocks");
    }
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.tryParse(ExampleMod.MOD_ID+":"+name), block);
    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, Identifier.tryParse(ExampleMod.MOD_ID+":"+name), new BlockItem(block, new Item.Settings()));
    }

    public static final Block DEBUG = registerBlock("debug", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));

    public static final Block SPONGE_CAKE = registerBlock("sponge_cake", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            7,
            new VoxelShape[]{
                    Block.createCuboidShape(13.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(11.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(09.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(07.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(05.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(03.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(01.0, 00.0, 01.0, 15.0, 08.0, 15.0),
            }
    ));
    public static final Block CHOCOLATE_CAKE = registerBlock("chocolate_cake", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            7,
            new VoxelShape[]{
                    Block.createCuboidShape(13.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(11.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(09.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(07.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(05.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(03.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(01.0, 00.0, 01.0, 15.0, 08.0, 15.0),
            }
    ));
    public static final Block CARROT_CAKE = registerBlock("carrot_cake", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            7,
            new VoxelShape[]{
                    Block.createCuboidShape(13.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(11.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(09.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(07.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(05.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(03.0, 00.0, 01.0, 15.0, 08.0, 15.0),
                    Block.createCuboidShape(01.0, 00.0, 01.0, 15.0, 08.0, 15.0),
            }
    ));
    public static final Block PUMPKIN_PIE = registerBlock("pumpkin_pie", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            4,
            new VoxelShape[]{
                    Block.createCuboidShape(08.0, 00.0, 08.0, 12.0, 04.0, 12.0),
                    Block.createCuboidShape(08.0, 00.0, 04.0, 12.0, 04.0, 12.0),
                    VoxelShapes.union(
                        Block.createCuboidShape(08.0, 00.0, 04.0, 12.0, 04.0, 12.0),
                        Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 04.0, 8.0)),
                    Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 04.0, 12.0),
            }
    ));
    public static final Block APPLE_PIE = registerBlock("apple_pie", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            4,
            new VoxelShape[]{
                    Block.createCuboidShape(08.0, 00.0, 08.0, 12.0, 04.0, 12.0),
                    Block.createCuboidShape(08.0, 00.0, 04.0, 12.0, 04.0, 12.0),
                    VoxelShapes.union(
                            Block.createCuboidShape(08.0, 00.0, 04.0, 12.0, 04.0, 12.0),
                            Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 04.0, 8.0)),
                    Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 04.0, 12.0),
            }
    ));
    public static final Block BERRY_PIE = registerBlock("berry_pie", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            4,
            new VoxelShape[]{
                    Block.createCuboidShape(08.0, 00.0, 08.0, 12.0, 04.0, 12.0),
                    Block.createCuboidShape(08.0, 00.0, 04.0, 12.0, 04.0, 12.0),
                    VoxelShapes.union(
                            Block.createCuboidShape(08.0, 00.0, 04.0, 12.0, 04.0, 12.0),
                            Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 04.0, 8.0)),
                    Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 04.0, 12.0),
            }
    ));
    public static final Block PANCAKES = registerBlock("pancakes", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            5,
            new VoxelShape[]{
                    Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 02.0, 12.0),
                    Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 03.0, 12.0),
                    Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 04.0, 12.0),
                    Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 05.0, 12.0),
                    Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 06.0, 12.0),
            }
    ));
    public static final Block TREACLE_TART = registerBlock("treacle_tart", new PlaceableFoodBlock(
            AbstractBlock.Settings.copy(Blocks.CAKE),
            2,
            new VoxelShape[]{
                    Block.createCuboidShape(08.0, 00.0, 04.0, 12.0, 04.0, 12.0),
                    Block.createCuboidShape(04.0, 00.0, 04.0, 12.0, 04.0, 12.0),
            }
    ));
}
