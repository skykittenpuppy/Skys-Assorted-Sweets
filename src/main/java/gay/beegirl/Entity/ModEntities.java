package gay.beegirl.Entity;

import gay.beegirl.ModInit;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static void registerModEntities(){
        ModInit.LOGGER.info("Registering Entities");
        registerEntityAttributes();
    }
    private static <T extends Entity> EntityType<T> registerEntity(String name, EntityType.Builder<T> type) {
        return Registry.register(
                Registries.ENTITY_TYPE,
                Identifier.tryParse(ModInit.MOD_ID, name),
                type.build(name)
        );
    }

    private static void registerEntityAttributes(){
        FabricDefaultAttributeRegistry.register(TUNA, TunaEntity.createFishAttributes());
    }

    public static final EntityType<TunaEntity> TUNA = registerEntity("tuna",EntityType.Builder.create(TunaEntity::new, SpawnGroup.WATER_AMBIENT).dimensions(0.8F, 0.5F).eyeHeight(0.26F).maxTrackingRange(4));
    public static final EntityType<CowEntity2> COW = registerEntity("cow",EntityType.Builder.create(CowEntity2::new, SpawnGroup.CREATURE).dimensions(0.9F, 1.4F).eyeHeight(1.3F).passengerAttachments(1.36875F).maxTrackingRange(10));

}
