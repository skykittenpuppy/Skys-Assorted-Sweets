package gay.beegirl;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static void registerModItems(){
        ExampleMod.LOGGER.info("Registering Items");
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(
                Registries.ITEM,
                Identifier.tryParse(ExampleMod.MOD_ID+":"+name),
                item
        );
    }

    public static final Item BREADCRUMBS = registerItem("breadcrumbs", new Item(new Item.Settings()));
}
