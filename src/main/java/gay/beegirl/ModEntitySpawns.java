package gay.beegirl;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.world.Heightmap;

public class ModEntitySpawns {
    public static void registerModEntitySpawns(){
        ModInit.LOGGER.info("Registering Entity Spawns");

        BiomeModifications.addSpawn(BiomeSelectors.tag(ConventionalBiomeTags.IS_AQUATIC), SpawnGroup.WATER_AMBIENT,
                ModEntities.TUNA,
                15,
                1,
                5);
        SpawnRestriction.register(ModEntities.TUNA,
                SpawnLocationTypes.IN_WATER,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                WaterCreatureEntity::canSpawn);
    }
}
