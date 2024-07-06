package gay.beegirl.Item;

import gay.beegirl.Block.ModBlocks;
import gay.beegirl.Entity.ModEntities;
import gay.beegirl.ModInit;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModItems {
    public static void registerModItems(){
        ModInit.LOGGER.info("Registering Items");
    }
    private static Item registerItem(String name, Item item){
        if (item instanceof BlockItem){
            ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
        return Registry.register(
                Registries.ITEM,
                Identifier.tryParse(ModInit.MOD_ID, name),
                item
        );
    }

    public static final Item BREADCRUMBS = registerItem("breadcrumbs", new Item(new Item.Settings()));
    public static final Item CUSTARD = registerItem("custard", new Item(new Item.Settings()));
    public static final Item FLESH_JERKY = registerItem("flesh_jerky", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(2).saturationModifier(0).snack().build())));
    public static final Item PUMPKIN_SLICE = registerItem("pumpkin_slice", new Item(new Item.Settings().food(FoodComponents.MELON_SLICE)));
    public static final Item TUNA = registerItem("tuna", new Item(new Item.Settings()));
    public static final Item TUNA_BUCKET = registerItem("tuna_bucket", new EntityBucketItem(ModEntities.TUNA, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings().maxCount(1).component(DataComponentTypes.BUCKET_ENTITY_DATA, NbtComponent.DEFAULT)));
    public static final Item TUNA_SPAWN_EGG = registerItem("tuna_spawn_egg", new SpawnEggItem(ModEntities.TUNA, 0, 0, new Item.Settings()));

    public static final Item SOUR_BERRIES = registerItem("sour_berries", new AliasedBlockItem(ModBlocks.SOUR_BERRY_BUSH, new Item.Settings().food(FoodComponents.SWEET_BERRIES)));
    public static final Item SWEET_BERRY_JUICE = registerItem("sweet_berry_juice", new Item(new Item.Settings()));
    public static final Item SWEET_WINE = registerItem("sweet_wine", new Item(new Item.Settings()));
    public static final Item SOUR_BERRY_JUICE = registerItem("sour_berry_juice", new Item(new Item.Settings()));
    public static final Item SOUR_WINE = registerItem("sour_wine", new Item(new Item.Settings()));
    public static final Item GLOW_BERRY_JUICE = registerItem("glow_berry_juice", new Item(new Item.Settings()));
    public static final Item GLOW_BERRY_WINE = registerItem("glow_berry_wine", new Item(new Item.Settings()));

    public static final Item NIGHTSHADE_SEEDS = registerItem("nightshade_seeds", new AliasedBlockItem(ModBlocks.NIGHTSHADE_CROP, new Item.Settings()));
    public static final Item CAMELIA_SEEDS = registerItem("camelia_seeds", new AliasedBlockItem(ModBlocks.CAMELIA_CROP, new Item.Settings()));
    public static final Item LAVENDER_SEEDS = registerItem("lavender_seeds", new AliasedBlockItem(ModBlocks.LAVENDER_CROP, new Item.Settings()));
    public static final Item VANILLA = registerItem("vanilla", new Item(new Item.Settings()));
    public static final Item VANILLA_SEEDS = registerItem("vanilla_seeds", new AliasedBlockItem(ModBlocks.VANILLA_CROP, new Item.Settings()));

    public static final Item WHITE_QUARTZ = registerItem("white_quartz", new Item(new Item.Settings()));
    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new Item.Settings()));
    public static final Item TOPAZ = registerItem("topaz", new Item(new Item.Settings()));
    public static final Item CITRINE = registerItem("citrine", new Item(new Item.Settings()));
    public static final Item ALEXANDRITE = registerItem("alexandrite", new Item(new Item.Settings()));
    public static final Item SPINEL = registerItem("spinel", new Item(new Item.Settings()));
}