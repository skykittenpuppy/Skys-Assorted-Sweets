package gay.beegirl.CustomClasses;

import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class FlowerCropBlock extends CropBlock {
    public static final IntProperty AGE;
    private static final VoxelShape[] SHAPES;
    public Block result;
    public Item seedItem;

    public FlowerCropBlock(AbstractBlock.Settings settings, Block result, Item seedItem) {
        super(settings);
        this.result = result;
        this.seedItem = seedItem; //Why are you null????
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES[this.getAge(state)];
    }

    protected IntProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 2;
    }

    protected ItemConvertible getSeedsItem() {
        return seedItem;
    }

    public BlockState withAge(int age) {
        return age == 2 ? result.getDefaultState() : super.withAge(age);
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(3) != 0) {
            super.randomTick(state, world, pos, random);
        }

    }

    protected int getGrowthAmount(World world) {
        return 1;
    }

    static {
        AGE = Properties.AGE_1;
        SHAPES = new VoxelShape[]{Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 6.0, 11.0), Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 10.0, 11.0)};
    }
}
