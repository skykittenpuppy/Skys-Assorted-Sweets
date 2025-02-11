package gay.beegirl.Block;

import gay.beegirl.Fluid.ModFluids;
import gay.beegirl.ModFeatureFlags;
import gay.beegirl.ModInit;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;

import java.util.concurrent.atomic.AtomicBoolean;

public class ModBlocks {
    public static void registerModBlocks(){
        ModInit.LOGGER.info("Registering Blocks");
        UseBlockCallback.EVENT.register(ModBlocks::harvestCrop);
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

    /* Copied from Cropped https://modrinth.com/mod/cropped */
    private static ActionResult harvestCrop (PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        if (player.isSneaking() || player.isSpectator()) {
            return ActionResult.PASS;
        }

        var blockState = world.getBlockState(hitResult.getBlockPos());
        var block = blockState.getBlock();
        var handStack = player.getStackInHand(hand);

        if (!(block instanceof TorchflowerBlock) && block instanceof CropBlock cropBlock) {
            if (cropBlock.isMature(blockState)) {
                //cropBlock.onUse(blockState, world, hitResult.getBlockPos(), player, hand, hitResult);

                if (!world.isClient())
                {
                    world.setBlockState(hitResult.getBlockPos(), cropBlock.withAge(0));
                    Item seed = cropBlock.getPickStack(world, hitResult.getBlockPos(), blockState).getItem();
                    AtomicBoolean removedSeed = new AtomicBoolean(false);

                    Block.getDroppedStacks(blockState, (ServerWorld) world, hitResult.getBlockPos(), null, player, handStack).forEach(stack -> {
                        if (!removedSeed.get() && stack.getItem() == seed) {
                            // It's PROBABLY a seed, so take one away
                            removedSeed.set(true);
                            stack.decrement(1);
                        }
                        Block.dropStack(world, hitResult.getBlockPos(), stack);
                    });
                }

                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.PASS;
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

    public static final Block SOUR_BERRY_BUSH = registerBlock("sour_berry_bush", new SweetBerryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)), false);
    public static final Block NIGHTSHADE = registerBlock("nightshade", new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F,AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)), true);
    public static final Block NIGHTSHADE_CROP = registerBlock("nightshade_crop", new TorchflowerBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)), false);
    public static final Block POTTED_NIGHTSHADE = registerBlock("potted_nightshade", new FlowerPotBlock(NIGHTSHADE, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)), false);
    public static final Block CAMELIA = registerBlock("camelia", new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F,AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)), true);
    public static final Block CAMELIA_CROP = registerBlock("camelia_crop", new TorchflowerBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)), false);
    public static final Block POTTED_CAMELIA = registerBlock("potted_camelia", new FlowerPotBlock(CAMELIA, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)), false);
    public static final Block LAVENDER = registerBlock("lavender", new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F,AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)), true);
    public static final Block LAVENDER_CROP = registerBlock("lavender_crop", new TorchflowerBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)), false);
    public static final Block POTTED_LAVENDER = registerBlock("potted_lavender", new FlowerPotBlock(LAVENDER, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)), false);
    public static final Block VANILLA_CROP = registerBlock("vanilla_crop", new CropBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)), false);

    public static final Block GRANITE_COAL_ORE = registerBlock("granite_coal_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DIORITE_COAL_ORE = registerBlock("diorite_coal_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block ANDESITE_COAL_ORE = registerBlock("andesite_coal_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DRIPSTONE_COAL_ORE = registerBlock("dripstone_coal_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block TUFF_COAL_ORE = registerBlock("tuff_coal_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);

    public static final Block GRANITE_IRON_ORE = registerBlock("granite_iron_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DIORITE_IRON_ORE = registerBlock("diorite_iron_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block ANDESITE_IRON_ORE = registerBlock("andesite_iron_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DRIPSTONE_IRON_ORE = registerBlock("dripstone_iron_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block TUFF_IRON_ORE = registerBlock("tuff_iron_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);

    public static final Block GRANITE_COPPER_ORE = registerBlock("granite_copper_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DIORITE_COPPER_ORE = registerBlock("diorite_copper_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block ANDESITE_COPPER_ORE = registerBlock("andesite_copper_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DRIPSTONE_COPPER_ORE = registerBlock("dripstone_copper_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block TUFF_COPPER_ORE = registerBlock("tuff_copper_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);

    public static final Block GRANITE_GOLD_ORE = registerBlock("granite_gold_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DIORITE_GOLD_ORE = registerBlock("diorite_gold_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block ANDESITE_GOLD_ORE = registerBlock("andesite_gold_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DRIPSTONE_GOLD_ORE = registerBlock("dripstone_gold_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block TUFF_GOLD_ORE = registerBlock("tuff_gold_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);

    public static final Block GRANITE_REDSTONE_ORE = registerBlock("granite_redstone_ore", new RedstoneOreBlock(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DIORITE_REDSTONE_ORE = registerBlock("diorite_redstone_ore", new RedstoneOreBlock(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block ANDESITE_REDSTONE_ORE = registerBlock("andesite_redstone_ore", new RedstoneOreBlock(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DRIPSTONE_REDSTONE_ORE = registerBlock("dripstone_redstone_ore", new RedstoneOreBlock(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block TUFF_REDSTONE_ORE = registerBlock("tuff_redstone_ore", new RedstoneOreBlock(AbstractBlock.Settings.copy(Blocks.TUFF)), true);

    public static final Block GRANITE_EMERALD_ORE = registerBlock("granite_emerald_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DIORITE_EMERALD_ORE = registerBlock("diorite_emerald_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block ANDESITE_EMERALD_ORE = registerBlock("andesite_emerald_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DRIPSTONE_EMERALD_ORE = registerBlock("dripstone_emerald_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block TUFF_EMERALD_ORE = registerBlock("tuff_emerald_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);

    public static final Block GRANITE_LAPIS_ORE = registerBlock("granite_lapis_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DIORITE_LAPIS_ORE = registerBlock("diorite_lapis_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block ANDESITE_LAPIS_ORE = registerBlock("andesite_lapis_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DRIPSTONE_LAPIS_ORE = registerBlock("dripstone_lapis_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block TUFF_LAPIS_ORE = registerBlock("tuff_lapis_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);

    public static final Block GRANITE_DIAMOND_ORE = registerBlock("granite_diamond_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DIORITE_DIAMOND_ORE = registerBlock("diorite_diamond_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block ANDESITE_DIAMOND_ORE = registerBlock("andesite_diamond_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DRIPSTONE_DIAMOND_ORE = registerBlock("dripstone_diamond_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block TUFF_DIAMOND_ORE = registerBlock("tuff_diamond_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);

    public static final Block BLACKSTONE_GOLD_ORE = registerBlock("blackstone_gold_ore", new Block(AbstractBlock.Settings.copy(Blocks.STONE)), true);
    public static final Block BASALT_GOLD_ORE = registerBlock("basalt_gold_ore", new Block(AbstractBlock.Settings.copy(Blocks.STONE)), true);
    public static final Block BLACKSTONE_QUARTZ_ORE = registerBlock("blackstone_quartz_ore", new Block(AbstractBlock.Settings.copy(Blocks.STONE)), true);
    public static final Block BASALT_QUARTZ_ORE = registerBlock("basalt_quartz_ore", new Block(AbstractBlock.Settings.copy(Blocks.STONE)), true);

    public static final Block WHITE_QUARTZ_ORE = registerBlock("white_quartz_ore", new Block(AbstractBlock.Settings.copy(Blocks.STONE)), true);
    public static final Block GRANITE_WHITE_QUARTZ_ORE = registerBlock("granite_white_quartz_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DIORITE_WHITE_QUARTZ_ORE = registerBlock("diorite_white_quartz_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block ANDESITE_WHITE_QUARTZ_ORE = registerBlock("andesite_white_quartz_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DRIPSTONE_WHITE_QUARTZ_ORE = registerBlock("dripstone_white_quartz_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DEEPSLATE_WHITE_QUARTZ_ORE = registerBlock("deepslate_white_quartz_ore", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE)), true);
    public static final Block TUFF_WHITE_QUARTZ_ORE = registerBlock("tuff_white_quartz_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);

    public static final Block RUBY_BLOCK = registerBlock("ruby_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK)), true);
    public static final Block RUBY_ORE = registerBlock("ruby_ore", new Block(AbstractBlock.Settings.copy(Blocks.STONE)), true);
    public static final Block GRANITE_RUBY_ORE = registerBlock("granite_ruby_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DIORITE_RUBY_ORE = registerBlock("diorite_ruby_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block ANDESITE_RUBY_ORE = registerBlock("andesite_ruby_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DRIPSTONE_RUBY_ORE = registerBlock("dripstone_ruby_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE)), true);
    public static final Block TUFF_RUBY_ORE = registerBlock("tuff_ruby_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);

    public static final Block SAPPHIRE_BLOCK = registerBlock("sapphire_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK)), true);
    public static final Block SAPPHIRE_ORE = registerBlock("sapphire_ore", new Block(AbstractBlock.Settings.copy(Blocks.STONE)), true);
    public static final Block GRANITE_SAPPHIRE_ORE = registerBlock("granite_sapphire_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DIORITE_SAPPHIRE_ORE = registerBlock("diorite_sapphire_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block ANDESITE_SAPPHIRE_ORE = registerBlock("andesite_sapphire_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DRIPSTONE_SAPPHIRE_ORE = registerBlock("dripstone_sapphire_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE)), true);
    public static final Block TUFF_SAPPHIRE_ORE = registerBlock("tuff_sapphire_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);

    public static final Block TOPAZ_BLOCK = registerBlock("topaz_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK)), true);
    public static final Block TOPAZ_ORE = registerBlock("topaz_ore", new Block(AbstractBlock.Settings.copy(Blocks.STONE)), true);
    public static final Block GRANITE_TOPAZ_ORE = registerBlock("granite_topaz_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DIORITE_TOPAZ_ORE = registerBlock("diorite_topaz_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block ANDESITE_TOPAZ_ORE = registerBlock("andesite_topaz_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DRIPSTONE_TOPAZ_ORE = registerBlock("dripstone_topaz_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DEEPSLATE_TOPAZ_ORE = registerBlock("deepslate_topaz_ore", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE)), true);
    public static final Block TUFF_TOPAZ_ORE = registerBlock("tuff_topaz_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);

    public static final Block CITRINE_BLOCK = registerBlock("citrine_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK)), true);
    public static final Block CITRINE_ORE = registerBlock("citrine_ore", new Block(AbstractBlock.Settings.copy(Blocks.STONE)), true);
    public static final Block GRANITE_CITRINE_ORE = registerBlock("granite_citrine_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DIORITE_CITRINE_ORE = registerBlock("diorite_citrine_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block ANDESITE_CITRINE_ORE = registerBlock("andesite_citrine_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DRIPSTONE_CITRINE_ORE = registerBlock("dripstone_citrine_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DEEPSLATE_CITRINE_ORE = registerBlock("deepslate_citrine_ore", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE)), true);
    public static final Block TUFF_CITRINE_ORE = registerBlock("tuff_citrine_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);

    public static final Block ALEXANDRITE_BLOCK = registerBlock("alexandrite_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK)), true);
    public static final Block ALEXANDRITE_ORE = registerBlock("alexandrite_ore", new Block(AbstractBlock.Settings.copy(Blocks.STONE)), true);
    public static final Block GRANITE_ALEXANDRITE_ORE = registerBlock("granite_alexandrite_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DIORITE_ALEXANDRITE_ORE = registerBlock("diorite_alexandrite_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block ANDESITE_ALEXANDRITE_ORE = registerBlock("andesite_alexandrite_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DRIPSTONE_ALEXANDRITE_ORE = registerBlock("dripstone_alexandrite_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DEEPSLATE_ALEXANDRITE_ORE = registerBlock("deepslate_alexandrite_ore", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE)), true);
    public static final Block TUFF_ALEXANDRITE_ORE = registerBlock("tuff_alexandrite_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);

    public static final Block SPINEL_BLOCK = registerBlock("spinel_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK)), true);
    public static final Block SPINEL_ORE = registerBlock("spinel_ore", new Block(AbstractBlock.Settings.copy(Blocks.STONE)), true);
    public static final Block GRANITE_SPINEL_ORE = registerBlock("granite_spinel_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DIORITE_SPINEL_ORE = registerBlock("diorite_spinel_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block ANDESITE_SPINEL_ORE = registerBlock("andesite_spinel_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DRIPSTONE_SPINEL_ORE = registerBlock("dripstone_spinel_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);
    public static final Block DEEPSLATE_SPINEL_ORE = registerBlock("deepslate_spinel_ore", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE)), true);
    public static final Block TUFF_SPINEL_ORE = registerBlock("tuff_spinel_ore", new Block(AbstractBlock.Settings.copy(Blocks.TUFF)), true);

    public static final Block ABYSSALT = registerBlock("abyssalt",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.BASALT).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block ABYSSALT_BRICKS = registerBlock("abyssalt_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.BASALT).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block ABYSSALT_EDGEHANGER_FRAME = registerBlock("abyssalt_edgehanger_frame",
            new Block(AbstractBlock.Settings.copy(Blocks.BASALT).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block ABYSSALT_HARMONIC_FRAME = registerBlock("abyssalt_harmonic_frame",
            new Block(AbstractBlock.Settings.copy(Blocks.BASALT).requires(ModFeatureFlags.ECHOING_VOID)), true);

    public static final Block EDGEHANGER_LEAVES = registerBlock("edgehanger_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.AZALEA_LEAVES).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block EDGEHANGER_LOG = registerBlock("edgehanger_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LOG).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block EDGEHANGER_LOG_STRIPPED = registerBlock("edgehanger_log_stripped",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LOG).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block EDGEHANGER_PLANKS = registerBlock("edgehanger_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block EDGEHANGER_SAPLING = registerBlock("edgehanger_sapling",
            new SaplingBlock(SaplingGenerator.OAK, AbstractBlock.Settings.copy(Blocks.SPRUCE_SAPLING).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block POTTED_EDGEHANGER_SAPLING = registerBlock("potted_edgehanger_sapling", new FlowerPotBlock(EDGEHANGER_SAPLING, AbstractBlock.Settings.create().requires(ModFeatureFlags.ECHOING_VOID).breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)), false);
    public static final Block EDGEHANGER_FENCE = registerBlock("edgehanger_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_FENCE).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block EDGEHANGER_FENCE_GATE = registerBlock("edgehanger_fence_gate",
            new FenceGateBlock(WoodType.SPRUCE, AbstractBlock.Settings.copy(Blocks.SPRUCE_FENCE_GATE).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block EDGEHANGER_DOOR = registerBlock("edgehanger_door",
            new DoorBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.copy(Blocks.SPRUCE_DOOR).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);

    public static final Block END_STONE_BRICKS_CRACKED = registerBlock("end_stone_bricks_cracked",
            new Block(AbstractBlock.Settings.copy(Blocks.END_STONE_BRICKS).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block END_STONE_CHISELED = registerBlock("end_stone_chiseled",
            new Block(AbstractBlock.Settings.copy(Blocks.END_STONE_BRICKS).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block END_STONE_PILLAR = registerBlock("end_stone_pillar",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.END_STONE_BRICKS).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block END_STONE_SMOOTH = registerBlock("end_stone_smooth",
            new Block(AbstractBlock.Settings.copy(Blocks.END_STONE).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block END_STONE_TILES = registerBlock("end_stone_tiles",
            new Block(AbstractBlock.Settings.copy(Blocks.END_STONE_BRICKS).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block END_STONE_TILES_CRACKED = registerBlock("end_stone_tiles_cracked",
            new Block(AbstractBlock.Settings.copy(Blocks.END_STONE_BRICKS).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block END_STONE_EDGEHANGER_PILLAR = registerBlock("end_stone_edgehanger_pillar",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.END_STONE_BRICKS).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block END_STONE_HARMONIC_PILLAR = registerBlock("end_stone_harmonic_pillar",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.END_STONE_BRICKS).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block END_STONE_EDGEHANGER_FRAME = registerBlock("end_stone_edgehanger_frame",
            new Block(AbstractBlock.Settings.copy(Blocks.END_STONE_BRICKS).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block END_STONE_HARMONIC_FRAME = registerBlock("end_stone_harmonic_frame",
            new Block(AbstractBlock.Settings.copy(Blocks.END_STONE_BRICKS).requires(ModFeatureFlags.ECHOING_VOID)), true);

    public static final Block ENDSLATE = registerBlock("endslate",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block ENDSLATE_EDGEHANGER_FRAME = registerBlock("endslate_edgehanger_frame",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block ENDSLATE_HARMONIC_FRAME = registerBlock("endslate_harmonic_frame",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).requires(ModFeatureFlags.ECHOING_VOID)), true);

    public static final Block HARMONIC_LEAVES = registerBlock("harmonic_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.AZALEA_LEAVES).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block HARMONIC_LOG = registerBlock("harmonic_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LOG).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block HARMONIC_LOG_STRIPPED = registerBlock("harmonic_log_stripped",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LOG).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block HARMONIC_PLANKS = registerBlock("harmonic_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block HARMONIC_SAPLING = registerBlock("harmonic_sapling",
            new SaplingBlock(SaplingGenerator.OAK, AbstractBlock.Settings.copy(Blocks.SPRUCE_SAPLING).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block POTTED_HARMONIC_SAPLING = registerBlock("potted_harmonic_sapling", new FlowerPotBlock(HARMONIC_SAPLING, AbstractBlock.Settings.create().requires(ModFeatureFlags.ECHOING_VOID).breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)), false);
    public static final Block HARMONIC_LATTICE = registerBlock("harmonic_lattice",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_FENCE).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block HARMONIC_DOOR = registerBlock("harmonic_door",
            new DoorBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.copy(Blocks.SPRUCE_DOOR).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);

    public static final Block PRASINE_BLOCK = registerBlock("prasine_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block PRASINE_ENGRAVED = registerBlock("prasine_engraved",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block PRASINE_END_STONE_PILLAR = registerBlock("prasine_end_stone_pillar",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).requires(ModFeatureFlags.ECHOING_VOID)), true);

    public static final Block PURPUR_MOSAIC = registerBlock("purpur_mosaic",
            new Block(AbstractBlock.Settings.copy(Blocks.PURPUR_BLOCK).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block PURPUR_TILES = registerBlock("purpur_tiles",
            new Block(AbstractBlock.Settings.copy(Blocks.PURPUR_BLOCK).requires(ModFeatureFlags.ECHOING_VOID)), true);

    public static final Block VIRIDACITE = registerBlock("viridacite",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.CALCITE).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block VIRIDACITE_PILLAR = registerBlock("viridacite_pillar",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.CALCITE).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block VIRIDACITE_EDGEHANGER_FRAME = registerBlock("viridacite_edgehanger_frame",
            new Block(AbstractBlock.Settings.copy(Blocks.CALCITE).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block VIRIDACITE_HARMONIC_FRAME = registerBlock("viridacite_harmonic_frame",
            new Block(AbstractBlock.Settings.copy(Blocks.CALCITE).requires(ModFeatureFlags.ECHOING_VOID)), true);

    public static final Block FLAXEN_EPHYTA = registerBlock("flaxen_ephyta",
            new EphytaBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_NYLIUM).requires(ModFeatureFlags.ECHOING_VOID)), true);
    public static final Block LURID_EPHYTA = registerBlock("lurid_ephyta",
            new EphytaBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_NYLIUM).requires(ModFeatureFlags.ECHOING_VOID)), true);

    public static final Block AMBER_SHRUB = registerBlock("amber_shrub",
            new FlowerBlock(StatusEffects.LUCK, 0, AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block AMBER_VINE = registerBlock("amber_vine",
            new VineBlock(AbstractBlock.Settings.copy(Blocks.VINE).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block BEIGE_GRASS = registerBlock("beige_grass",
            new FlowerBlock(StatusEffects.LUCK, 0, AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block BLOSSOMING_RHYTHM = registerBlock("blossoming_rhythm",
            new TallFlowerBlock(AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block BULBOUS_MELODY_SHORT = registerBlock("bulbous_melody_short",
            new FlowerBlock(StatusEffects.LUCK, 0, AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block BULBOUS_MELODY_TALL = registerBlock("bulbous_melody_tall",
            new TallFlowerBlock(AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block FLAXEN_FUNNELS_SHORT = registerBlock("flaxen_funnels_short",
            new FlowerBlock(StatusEffects.LUCK, 0, AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block FLAXEN_FUNNELS_TALL = registerBlock("flaxen_funnels_tall",
            new TallFlowerBlock(AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block FLOWERING_VOID = registerBlock("flowering_void",
            new FlowerBlock(StatusEffects.LUCK, 0, AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block TAWNY_FERN_SHORT = registerBlock("tawny_fern_short",
            new FlowerBlock(StatusEffects.LUCK, 0, AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block TAWNY_FERN_TALL = registerBlock("tawny_fern_tall",
            new TallFlowerBlock(AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);
    public static final Block VOID_STALKS = registerBlock("void_stalks",
            new TallFlowerBlock(AbstractBlock.Settings.copy(Blocks.ROSE_BUSH).requires(ModFeatureFlags.ECHOING_VOID).nonOpaque()), true);

    public static final Block VOID = registerBlock("void", new FluidBlock(ModFluids.VOID, AbstractBlock.Settings.create().replaceable().noCollision().strength(100.0F).pistonBehavior(PistonBehavior.DESTROY).dropsNothing().liquid().sounds(BlockSoundGroup.INTENTIONALLY_EMPTY)), false);
}
