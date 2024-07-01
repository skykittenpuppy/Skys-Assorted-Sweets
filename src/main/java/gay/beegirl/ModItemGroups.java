package gay.beegirl;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static void registerModItemGroups(){
        ModInit.LOGGER.info("Registering Item Groups");
        addItemsToVanillaGroups();
    }
    private static ItemGroup registerItemGroup(String name, Item icon, ItemGroup.EntryCollector entries){
        return Registry.register(
                Registries.ITEM_GROUP,
                Identifier.tryParse(ModInit.MOD_ID, name),
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemGroup."+ ModInit.MOD_ID+"."+name))
                        .icon(() -> new ItemStack(icon))
                        .entries(entries)
                        .build()
        );
    }

    private static void addItemsToVanillaGroups(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.SALMON_BUCKET, ModItems.TUNA_BUCKET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> {
            content.addBefore(Items.TURTLE_SPAWN_EGG, ModItems.TUNA_SPAWN_EGG);
        });
    }

    public static final ItemGroup FOODS = registerItemGroup("foods", ModBlocks.SPONGE_CAKE.asItem(), (displayContext, entries) -> {
        entries.add(ModBlocks.SPONGE_CAKE);
        entries.add(ModBlocks.CHOCOLATE_CAKE);
        entries.add(ModBlocks.RED_VELVET_CAKE);
        entries.add(ModBlocks.CARROT_CAKE);
        entries.add(ModBlocks.PUMPKIN_PIE);
        entries.add(ModBlocks.APPLE_PIE);
        entries.add(ModBlocks.BERRY_PIE);
        entries.add(ModBlocks.PANCAKES);
        entries.add(ModBlocks.TREACLE_TART);
        entries.add(ModBlocks.FLAN);
        entries.add(ModItems.FLESH_JERKY);
    });
    public static final ItemGroup DRINKS = registerItemGroup("drinks", ModItems.SWEET_BERRY_JUICE, (displayContext, entries) -> {
        entries.add(ModItems.SWEET_BERRY_JUICE);
        entries.add(ModItems.SWEET_WINE);
        entries.add(ModItems.SOUR_BERRY_JUICE);
        entries.add(ModItems.SOUR_WINE);
        entries.add(ModItems.GLOW_BERRY_JUICE);
        entries.add(ModItems.GLOW_BERRY_WINE);
    });
    public static final ItemGroup INGREDIENTS = registerItemGroup("ingredients", ModItems.SOUR_BERRIES, (displayContext, entries) -> {
        entries.add(ModItems.SOUR_BERRIES);
        entries.add(ModItems.BREADCRUMBS);
        entries.add(ModItems.CUSTARD);
    });
    public static final ItemGroup CROPS = registerItemGroup("crops", ModBlocks.TORCHFLOWER.asItem(), (displayContext, entries) -> {
        entries.add(ModBlocks.TORCHFLOWER);
        entries.add(ModItems.TORCHFLOWER_SEEDS);
        entries.add(ModItems.SOUR_BERRIES);
    });
}
