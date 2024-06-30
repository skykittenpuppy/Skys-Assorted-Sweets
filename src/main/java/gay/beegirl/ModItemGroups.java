package gay.beegirl;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static void registerModItemGroups(){
        ExampleMod.LOGGER.info("Registering Item Groups");
    }
    private static ItemGroup registerItemGroup(String name, Item icon, ItemGroup.EntryCollector entries){
        return Registry.register(
                Registries.ITEM_GROUP,
                Identifier.tryParse(ExampleMod.MOD_ID+":"+name),
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemGroup."+ExampleMod.MOD_ID+"."+name))
                        .icon(() -> new ItemStack(icon))
                        .entries(entries)
                        .build()
        );
    }

    public static final ItemGroup FOODS = registerItemGroup("foods", ModBlocks.CHOCOLATE_CAKE.asItem(), (displayContext, entries) -> {
        entries.add(ModBlocks.SPONGE_CAKE);
        entries.add(ModBlocks.CHOCOLATE_CAKE);
        entries.add(ModBlocks.CARROT_CAKE);
        entries.add(ModBlocks.PUMPKIN_PIE);
        entries.add(ModBlocks.APPLE_PIE);
        entries.add(ModBlocks.BERRY_PIE);
        entries.add(ModBlocks.PANCAKES);
        entries.add(ModBlocks.TREACLE_TART);
    });
    public static final ItemGroup INGREDIENTS = registerItemGroup("ingredients", ModItems.BREADCRUMBS, (displayContext, entries) -> {
        entries.add(ModItems.BREADCRUMBS);
    });
}
