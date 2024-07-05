package gay.beegirl;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    private static int sortOrder = 0;

    public static void registerModItemGroups(){
        ModInit.LOGGER.info("Registering Item Groups");
        addItemsToVanillaGroups();
    }
    private static ItemGroup registerItemGroup(String name, Item icon, ItemGroup.EntryCollector entries){
        return Registry.register(
                Registries.ITEM_GROUP,
                Identifier.tryParse(ModInit.MOD_ID, sortOrder++ + name),
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemGroup."+ ModInit.MOD_ID+"."+name))
                        .icon(() -> new ItemStack(icon))
                        .entries(entries)
                        .build()
        );
    }

    private static void addItemsToVanillaGroups(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.SMOOTH_QUARTZ_SLAB, ModBlocks.RUBY_BLOCK);
            content.addAfter(ModBlocks.RUBY_BLOCK, ModBlocks.SAPPHIRE_BLOCK);
            content.addAfter(ModBlocks.SAPPHIRE_BLOCK, ModBlocks.TOPAZ_BLOCK);
            content.addAfter(ModBlocks.TOPAZ_BLOCK, ModBlocks.CITRINE_BLOCK);
            content.addAfter(ModBlocks.CITRINE_BLOCK, ModBlocks.ALEXANDRITE_BLOCK);
            content.addAfter(ModBlocks.ALEXANDRITE_BLOCK, ModBlocks.SPINEL_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Blocks.COAL_ORE, ModBlocks.GRANITE_COAL_ORE);
            content.addAfter(ModBlocks.GRANITE_COAL_ORE, ModBlocks.DIORITE_COAL_ORE);
            content.addAfter(ModBlocks.DIORITE_COAL_ORE, ModBlocks.ANDESITE_COAL_ORE);
            content.addAfter(ModBlocks.ANDESITE_COAL_ORE, ModBlocks.DRIPSTONE_COAL_ORE);
            content.addAfter(Blocks.DEEPSLATE_COAL_ORE, ModBlocks.TUFF_COAL_ORE);

            content.addAfter(Blocks.IRON_ORE, ModBlocks.GRANITE_IRON_ORE);
            content.addAfter(ModBlocks.GRANITE_IRON_ORE, ModBlocks.DIORITE_IRON_ORE);
            content.addAfter(ModBlocks.DIORITE_IRON_ORE, ModBlocks.ANDESITE_IRON_ORE);
            content.addAfter(ModBlocks.ANDESITE_IRON_ORE, ModBlocks.DRIPSTONE_IRON_ORE);
            content.addAfter(Blocks.DEEPSLATE_IRON_ORE, ModBlocks.TUFF_IRON_ORE);

            content.addAfter(Blocks.COPPER_ORE, ModBlocks.GRANITE_COPPER_ORE);
            content.addAfter(ModBlocks.GRANITE_COPPER_ORE, ModBlocks.DIORITE_COPPER_ORE);
            content.addAfter(ModBlocks.DIORITE_COPPER_ORE, ModBlocks.ANDESITE_COPPER_ORE);
            content.addAfter(ModBlocks.ANDESITE_COPPER_ORE, ModBlocks.DRIPSTONE_COPPER_ORE);
            content.addAfter(Blocks.DEEPSLATE_COPPER_ORE, ModBlocks.TUFF_COPPER_ORE);
            
            content.addAfter(Blocks.GOLD_ORE, ModBlocks.GRANITE_GOLD_ORE);
            content.addAfter(ModBlocks.GRANITE_GOLD_ORE, ModBlocks.DIORITE_GOLD_ORE);
            content.addAfter(ModBlocks.DIORITE_GOLD_ORE, ModBlocks.ANDESITE_GOLD_ORE);
            content.addAfter(ModBlocks.ANDESITE_GOLD_ORE, ModBlocks.DRIPSTONE_GOLD_ORE);
            content.addAfter(Blocks.DEEPSLATE_GOLD_ORE, ModBlocks.TUFF_GOLD_ORE);

            content.addAfter(Blocks.REDSTONE_ORE, ModBlocks.GRANITE_REDSTONE_ORE);
            content.addAfter(ModBlocks.GRANITE_REDSTONE_ORE, ModBlocks.DIORITE_REDSTONE_ORE);
            content.addAfter(ModBlocks.DIORITE_REDSTONE_ORE, ModBlocks.ANDESITE_REDSTONE_ORE);
            content.addAfter(ModBlocks.ANDESITE_REDSTONE_ORE, ModBlocks.DRIPSTONE_REDSTONE_ORE);
            content.addAfter(Blocks.DEEPSLATE_REDSTONE_ORE, ModBlocks.TUFF_REDSTONE_ORE);

            content.addAfter(Blocks.EMERALD_ORE, ModBlocks.GRANITE_EMERALD_ORE);
            content.addAfter(ModBlocks.GRANITE_EMERALD_ORE, ModBlocks.DIORITE_EMERALD_ORE);
            content.addAfter(ModBlocks.DIORITE_EMERALD_ORE, ModBlocks.ANDESITE_EMERALD_ORE);
            content.addAfter(ModBlocks.ANDESITE_EMERALD_ORE, ModBlocks.DRIPSTONE_EMERALD_ORE);
            content.addAfter(Blocks.DEEPSLATE_EMERALD_ORE, ModBlocks.TUFF_EMERALD_ORE);

            content.addAfter(Blocks.LAPIS_ORE, ModBlocks.GRANITE_LAPIS_ORE);
            content.addAfter(ModBlocks.GRANITE_LAPIS_ORE, ModBlocks.DIORITE_LAPIS_ORE);
            content.addAfter(ModBlocks.DIORITE_LAPIS_ORE, ModBlocks.ANDESITE_LAPIS_ORE);
            content.addAfter(ModBlocks.ANDESITE_LAPIS_ORE, ModBlocks.DRIPSTONE_LAPIS_ORE);
            content.addAfter(Blocks.DEEPSLATE_LAPIS_ORE, ModBlocks.TUFF_LAPIS_ORE);

            content.addAfter(Blocks.DIAMOND_ORE, ModBlocks.GRANITE_DIAMOND_ORE);
            content.addAfter(ModBlocks.GRANITE_DIAMOND_ORE, ModBlocks.DIORITE_DIAMOND_ORE);
            content.addAfter(ModBlocks.DIORITE_DIAMOND_ORE, ModBlocks.ANDESITE_DIAMOND_ORE);
            content.addAfter(ModBlocks.ANDESITE_DIAMOND_ORE, ModBlocks.DRIPSTONE_DIAMOND_ORE);
            content.addAfter(Blocks.DEEPSLATE_DIAMOND_ORE, ModBlocks.TUFF_DIAMOND_ORE);

            content.addAfter(ModBlocks.TUFF_DIAMOND_ORE, ModBlocks.RUBY_ORE);
            content.addAfter(ModBlocks.RUBY_ORE, ModBlocks.GRANITE_RUBY_ORE);
            content.addAfter(ModBlocks.GRANITE_RUBY_ORE, ModBlocks.DIORITE_RUBY_ORE);
            content.addAfter(ModBlocks.DIORITE_RUBY_ORE, ModBlocks.ANDESITE_RUBY_ORE);
            content.addAfter(ModBlocks.ANDESITE_RUBY_ORE, ModBlocks.DRIPSTONE_RUBY_ORE);
            content.addAfter(ModBlocks.DRIPSTONE_RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE);
            content.addAfter(ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.TUFF_RUBY_ORE);

            content.addAfter(ModBlocks.TUFF_RUBY_ORE, ModBlocks.SAPPHIRE_ORE);
            content.addAfter(ModBlocks.SAPPHIRE_ORE, ModBlocks.GRANITE_SAPPHIRE_ORE);
            content.addAfter(ModBlocks.GRANITE_SAPPHIRE_ORE, ModBlocks.DIORITE_SAPPHIRE_ORE);
            content.addAfter(ModBlocks.DIORITE_SAPPHIRE_ORE, ModBlocks.ANDESITE_SAPPHIRE_ORE);
            content.addAfter(ModBlocks.ANDESITE_SAPPHIRE_ORE, ModBlocks.DRIPSTONE_SAPPHIRE_ORE);
            content.addAfter(ModBlocks.DRIPSTONE_SAPPHIRE_ORE, ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
            content.addAfter(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModBlocks.TUFF_SAPPHIRE_ORE);

            content.addAfter(ModBlocks.TUFF_SAPPHIRE_ORE, ModBlocks.TOPAZ_ORE);
            content.addAfter(ModBlocks.TOPAZ_ORE, ModBlocks.GRANITE_TOPAZ_ORE);
            content.addAfter(ModBlocks.GRANITE_TOPAZ_ORE, ModBlocks.DIORITE_TOPAZ_ORE);
            content.addAfter(ModBlocks.DIORITE_TOPAZ_ORE, ModBlocks.ANDESITE_TOPAZ_ORE);
            content.addAfter(ModBlocks.ANDESITE_TOPAZ_ORE, ModBlocks.DRIPSTONE_TOPAZ_ORE);
            content.addAfter(ModBlocks.DRIPSTONE_TOPAZ_ORE, ModBlocks.DEEPSLATE_TOPAZ_ORE);
            content.addAfter(ModBlocks.DEEPSLATE_TOPAZ_ORE, ModBlocks.TUFF_TOPAZ_ORE);

            content.addAfter(ModBlocks.TUFF_TOPAZ_ORE, ModBlocks.CITRINE_ORE);
            content.addAfter(ModBlocks.CITRINE_ORE, ModBlocks.GRANITE_CITRINE_ORE);
            content.addAfter(ModBlocks.GRANITE_CITRINE_ORE, ModBlocks.DIORITE_CITRINE_ORE);
            content.addAfter(ModBlocks.DIORITE_CITRINE_ORE, ModBlocks.ANDESITE_CITRINE_ORE);
            content.addAfter(ModBlocks.ANDESITE_CITRINE_ORE, ModBlocks.DRIPSTONE_CITRINE_ORE);
            content.addAfter(ModBlocks.DRIPSTONE_CITRINE_ORE, ModBlocks.DEEPSLATE_CITRINE_ORE);
            content.addAfter(ModBlocks.DEEPSLATE_CITRINE_ORE, ModBlocks.TUFF_CITRINE_ORE);

            content.addAfter(ModBlocks.TUFF_CITRINE_ORE, ModBlocks.ALEXANDRITE_ORE);
            content.addAfter(ModBlocks.ALEXANDRITE_ORE, ModBlocks.GRANITE_ALEXANDRITE_ORE);
            content.addAfter(ModBlocks.GRANITE_ALEXANDRITE_ORE, ModBlocks.DIORITE_ALEXANDRITE_ORE);
            content.addAfter(ModBlocks.DIORITE_ALEXANDRITE_ORE, ModBlocks.ANDESITE_ALEXANDRITE_ORE);
            content.addAfter(ModBlocks.ANDESITE_ALEXANDRITE_ORE, ModBlocks.DRIPSTONE_ALEXANDRITE_ORE);
            content.addAfter(ModBlocks.DRIPSTONE_ALEXANDRITE_ORE, ModBlocks.DEEPSLATE_ALEXANDRITE_ORE);
            content.addAfter(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE, ModBlocks.TUFF_ALEXANDRITE_ORE);

            content.addAfter(ModBlocks.TUFF_ALEXANDRITE_ORE, ModBlocks.SPINEL_ORE);
            content.addAfter(ModBlocks.SPINEL_ORE, ModBlocks.GRANITE_SPINEL_ORE);
            content.addAfter(ModBlocks.GRANITE_SPINEL_ORE, ModBlocks.DIORITE_SPINEL_ORE);
            content.addAfter(ModBlocks.DIORITE_SPINEL_ORE, ModBlocks.ANDESITE_SPINEL_ORE);
            content.addAfter(ModBlocks.ANDESITE_SPINEL_ORE, ModBlocks.DRIPSTONE_SPINEL_ORE);
            content.addAfter(ModBlocks.DRIPSTONE_SPINEL_ORE, ModBlocks.DEEPSLATE_SPINEL_ORE);
            content.addAfter(ModBlocks.DEEPSLATE_SPINEL_ORE, ModBlocks.TUFF_SPINEL_ORE);

            content.addAfter(ModBlocks.TUFF_SPINEL_ORE, ModBlocks.WHITE_QUARTZ_ORE);
            content.addAfter(ModBlocks.WHITE_QUARTZ_ORE, ModBlocks.GRANITE_WHITE_QUARTZ_ORE);
            content.addAfter(ModBlocks.GRANITE_WHITE_QUARTZ_ORE, ModBlocks.DIORITE_WHITE_QUARTZ_ORE);
            content.addAfter(ModBlocks.DIORITE_WHITE_QUARTZ_ORE, ModBlocks.ANDESITE_WHITE_QUARTZ_ORE);
            content.addAfter(ModBlocks.ANDESITE_WHITE_QUARTZ_ORE, ModBlocks.DRIPSTONE_WHITE_QUARTZ_ORE);
            content.addAfter(ModBlocks.DRIPSTONE_WHITE_QUARTZ_ORE, ModBlocks.DEEPSLATE_WHITE_QUARTZ_ORE);
            content.addAfter(ModBlocks.DEEPSLATE_WHITE_QUARTZ_ORE, ModBlocks.TUFF_WHITE_QUARTZ_ORE);

            content.addAfter(Blocks.NETHER_GOLD_ORE, ModBlocks.BLACKSTONE_GOLD_ORE);
            content.addAfter(ModBlocks.BLACKSTONE_GOLD_ORE, ModBlocks.BASALT_GOLD_ORE);

            content.addAfter(Blocks.NETHER_QUARTZ_ORE, ModBlocks.BLACKSTONE_QUARTZ_ORE);
            content.addAfter(ModBlocks.BLACKSTONE_QUARTZ_ORE, ModBlocks.BASALT_QUARTZ_ORE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.SALMON_BUCKET, ModItems.TUNA_BUCKET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.QUARTZ, ModItems.WHITE_QUARTZ);
            content.addAfter(ModItems.WHITE_QUARTZ, ModItems.RUBY);
            content.addAfter(ModItems.RUBY, ModItems.SAPPHIRE);
            content.addAfter(ModItems.SAPPHIRE, ModItems.TOPAZ);
            content.addAfter(ModItems.TOPAZ, ModItems.CITRINE);
            content.addAfter(ModItems.CITRINE, ModItems.ALEXANDRITE);
            content.addAfter(ModItems.ALEXANDRITE, ModItems.SPINEL);
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
        entries.add(ModItems.VANILLA);
        entries.add(ModItems.PUMPKIN_SLICE);
        entries.add(ModItems.TUNA);
    });
    public static final ItemGroup CROPS = registerItemGroup("crops", ModBlocks.NIGHTSHADE.asItem(), (displayContext, entries) -> {
        entries.add(ModBlocks.NIGHTSHADE);
        entries.add(ModItems.NIGHTSHADE_SEEDS);
        entries.add(ModBlocks.CAMELIA);
        entries.add(ModItems.CAMELIA_SEEDS);
        entries.add(ModBlocks.LAVENDER);
        entries.add(ModItems.LAVENDER_SEEDS);
        entries.add(ModItems.VANILLA);
        entries.add(ModItems.VANILLA_SEEDS);
        entries.add(ModItems.SOUR_BERRIES);
    });
    public static final ItemGroup GEMS = registerItemGroup("gems", ModItems.RUBY, (displayContext, entries) -> {
        entries.add(ModItems.RUBY);
        entries.add(ModBlocks.RUBY_BLOCK);
        entries.add(ModBlocks.RUBY_ORE);
        entries.add(ModBlocks.GRANITE_RUBY_ORE);
        entries.add(ModBlocks.DIORITE_RUBY_ORE);
        entries.add(ModBlocks.ANDESITE_RUBY_ORE);
        entries.add(ModBlocks.DRIPSTONE_RUBY_ORE);
        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
        entries.add(ModBlocks.TUFF_RUBY_ORE);

        entries.add(ModItems.SAPPHIRE);
        entries.add(ModBlocks.SAPPHIRE_BLOCK);
        entries.add(ModBlocks.SAPPHIRE_ORE);
        entries.add(ModBlocks.GRANITE_SAPPHIRE_ORE);
        entries.add(ModBlocks.DIORITE_SAPPHIRE_ORE);
        entries.add(ModBlocks.ANDESITE_SAPPHIRE_ORE);
        entries.add(ModBlocks.DRIPSTONE_SAPPHIRE_ORE);
        entries.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        entries.add(ModBlocks.TUFF_SAPPHIRE_ORE);

        entries.add(ModItems.TOPAZ);
        entries.add(ModBlocks.TOPAZ_BLOCK);
        entries.add(ModBlocks.TOPAZ_ORE);
        entries.add(ModBlocks.GRANITE_TOPAZ_ORE);
        entries.add(ModBlocks.DIORITE_TOPAZ_ORE);
        entries.add(ModBlocks.ANDESITE_TOPAZ_ORE);
        entries.add(ModBlocks.DRIPSTONE_TOPAZ_ORE);
        entries.add(ModBlocks.DEEPSLATE_TOPAZ_ORE);
        entries.add(ModBlocks.TUFF_TOPAZ_ORE);

        entries.add(ModItems.CITRINE);
        entries.add(ModBlocks.CITRINE_BLOCK);
        entries.add(ModBlocks.CITRINE_ORE);
        entries.add(ModBlocks.GRANITE_CITRINE_ORE);
        entries.add(ModBlocks.DIORITE_CITRINE_ORE);
        entries.add(ModBlocks.ANDESITE_CITRINE_ORE);
        entries.add(ModBlocks.DRIPSTONE_CITRINE_ORE);
        entries.add(ModBlocks.DEEPSLATE_CITRINE_ORE);
        entries.add(ModBlocks.TUFF_CITRINE_ORE);

        entries.add(ModItems.ALEXANDRITE);
        entries.add(ModBlocks.ALEXANDRITE_BLOCK);
        entries.add(ModBlocks.ALEXANDRITE_ORE);
        entries.add(ModBlocks.GRANITE_ALEXANDRITE_ORE);
        entries.add(ModBlocks.DIORITE_ALEXANDRITE_ORE);
        entries.add(ModBlocks.ANDESITE_ALEXANDRITE_ORE);
        entries.add(ModBlocks.DRIPSTONE_ALEXANDRITE_ORE);
        entries.add(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE);
        entries.add(ModBlocks.TUFF_ALEXANDRITE_ORE);

        entries.add(ModItems.SPINEL);
        entries.add(ModBlocks.SPINEL_BLOCK);
        entries.add(ModBlocks.SPINEL_ORE);
        entries.add(ModBlocks.GRANITE_SPINEL_ORE);
        entries.add(ModBlocks.DIORITE_SPINEL_ORE);
        entries.add(ModBlocks.ANDESITE_SPINEL_ORE);
        entries.add(ModBlocks.DRIPSTONE_SPINEL_ORE);
        entries.add(ModBlocks.DEEPSLATE_SPINEL_ORE);
        entries.add(ModBlocks.TUFF_SPINEL_ORE);

        entries.add(ModItems.WHITE_QUARTZ);
        entries.add(ModBlocks.WHITE_QUARTZ_ORE);
        entries.add(ModBlocks.GRANITE_WHITE_QUARTZ_ORE);
        entries.add(ModBlocks.DIORITE_WHITE_QUARTZ_ORE);
        entries.add(ModBlocks.ANDESITE_WHITE_QUARTZ_ORE);
        entries.add(ModBlocks.DRIPSTONE_WHITE_QUARTZ_ORE);
        entries.add(ModBlocks.DEEPSLATE_WHITE_QUARTZ_ORE);
        entries.add(ModBlocks.TUFF_WHITE_QUARTZ_ORE);
    });
}