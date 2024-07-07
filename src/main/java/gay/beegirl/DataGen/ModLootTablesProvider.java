package gay.beegirl.DataGen;

//public class ModLootTablesProvider extends SimpleFabricLootTableProvider {
//    public ModLootTablesProvider(FabricDataOutput output) {
//        super(output, LootContextTypes.ENTITY);
//    }
//    public static RegistryKey<LootTable> registerKey(String name) {
//        return RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(ModInit.MOD_ID, name));
//    }
//
//    public static final RegistryKey<LootTable> TUNA = registerKey("entities/tuna");
//    @Override
//    public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> lootTableBiConsumer) {
//        lootTableBiConsumer.accept(TUNA, LootTable.builder()
//                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f))
//                        .with(ItemEntry.builder(ModItems.TUNA)
//                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f))))));
//    }
//}
