package gay.beegirl;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

public class PlaceableFoodBlock extends Block {
    public static final IntProperty SLICES = IntProperty.of("slices", 1, 32);
    protected VoxelShape[] BITES_TO_SHAPE;
    public int MAX_BITES;

    public PlaceableFoodBlock(AbstractBlock.Settings settings, int MAX_BITES, VoxelShape[] BITES_TO_SHAPE) {
        super(settings);
        this.MAX_BITES = MAX_BITES;
        this.BITES_TO_SHAPE = BITES_TO_SHAPE;
        this.setDefaultState((this.stateManager.getDefaultState()).with(SLICES, MAX_BITES));
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BITES_TO_SHAPE[Math.min(state.get(SLICES), MAX_BITES)-1];
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Item item = stack.getItem();
        if (stack.isIn(ItemTags.CANDLES) && state.get(SLICES) == MAX_BITES) {
            Block var10 = Block.getBlockFromItem(item);
            if (var10 instanceof CandleBlock) {
                CandleBlock candleBlock = (CandleBlock)var10;
                stack.decrementUnlessCreative(1, player);
                world.playSound(null, pos, SoundEvents.BLOCK_CAKE_ADD_CANDLE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.setBlockState(pos, CandleCakeBlock.getCandleCakeFromCandle(candleBlock));
                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                return ItemActionResult.SUCCESS;
            }
        }

        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            if (tryEat(world, pos, state, player).isAccepted()) {
                return ActionResult.SUCCESS;
            }

            if (player.getStackInHand(Hand.MAIN_HAND).isEmpty()) {
                return ActionResult.CONSUME;
            }
        }

        return tryEat(world, pos, state, player);
    }

    protected ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canConsume(false)) {
            return ActionResult.PASS;
        } else {
            player.incrementStat(Stats.EAT_CAKE_SLICE);
            player.getHungerManager().add(2, 0.1F);
            int i = state.get(SLICES);
            world.emitGameEvent(player, GameEvent.EAT, pos);
            if (i-1 > 0) {
                world.setBlockState(pos, (BlockState)state.with(SLICES, i - 1), 3);
            } else {
                world.removeBlock(pos, false);
                world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }

            return ActionResult.SUCCESS;
        }
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolid();
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SLICES);
    }

    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return state.get(SLICES);
    }

    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }
}
