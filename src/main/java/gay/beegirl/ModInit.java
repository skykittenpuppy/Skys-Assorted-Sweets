package gay.beegirl;

import gay.beegirl.Block.ModBlocks;
import gay.beegirl.Entity.ModEntities;
import gay.beegirl.Entity.ModEntityGeneration;
import gay.beegirl.Item.ModItemGroups;
import gay.beegirl.Item.ModItems;
import gay.beegirl.Registries.ModRegistries;
import gay.beegirl.Sound.ModSoundEvents;
import gay.beegirl.World.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModInit implements ModInitializer {
	public static final String MOD_ID = "assortedsweets";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();
		ModItemGroups.registerModItemGroups();
		ModSoundEvents.registerModSoundEvents();
		ModWorldGeneration.registerModWorldGeneration();
		ModEntityGeneration.registerModEntityGeneration();

		ModRegistries.registerStrippables();
	}
}