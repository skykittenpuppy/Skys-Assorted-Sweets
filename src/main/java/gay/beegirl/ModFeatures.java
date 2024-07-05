package gay.beegirl;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.world.gen.feature.*;

import java.util.ArrayList;

public class ModFeatures {
    public static void registerModBlocks(){
        ModInit.LOGGER.info("Registering Configured Features");
    }

    public static final ConfiguredFeature<OreFeatureConfig, OreFeature> ORE_FEATURE_CONFIGURED = new ConfiguredFeature<OreFeatureConfig, OreFeature>(
            (OreFeature) Feature.ORE,
            new OreFeatureConfig(new ArrayList<>(), 17, 0.0f)
    );
    //OreConfiguredFeatures.ORE_NETHER_GOLD
}
