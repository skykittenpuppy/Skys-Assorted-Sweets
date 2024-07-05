package gay.beegirl;

import gay.beegirl.CustomClasses.TunaEntityModel;
import gay.beegirl.CustomClasses.TunaEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModClientInit implements ClientModInitializer {
	public static final EntityModelLayer TUNA = new EntityModelLayer(Identifier.tryParse(ModInit.MOD_ID,"tuna"), "main");

	@Override
	public void onInitializeClient() {
		ModInit.LOGGER.info("Setting Block Render Settings");
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.COAL_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRANITE_COAL_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIORITE_COAL_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANDESITE_COAL_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIPSTONE_COAL_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DEEPSLATE_COAL_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUFF_COAL_ORE, RenderLayer.getTranslucent());

		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.IRON_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRANITE_IRON_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIORITE_IRON_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANDESITE_IRON_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIPSTONE_IRON_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DEEPSLATE_IRON_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUFF_IRON_ORE, RenderLayer.getTranslucent());

		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.COPPER_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRANITE_COPPER_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIORITE_COPPER_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANDESITE_COPPER_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIPSTONE_COPPER_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DEEPSLATE_COPPER_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUFF_COPPER_ORE, RenderLayer.getTranslucent());

		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.GOLD_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRANITE_GOLD_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIORITE_GOLD_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANDESITE_GOLD_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIPSTONE_GOLD_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DEEPSLATE_GOLD_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUFF_GOLD_ORE, RenderLayer.getTranslucent());

		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.REDSTONE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRANITE_REDSTONE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIORITE_REDSTONE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANDESITE_REDSTONE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIPSTONE_REDSTONE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DEEPSLATE_REDSTONE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUFF_REDSTONE_ORE, RenderLayer.getTranslucent());

		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.EMERALD_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRANITE_EMERALD_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIORITE_EMERALD_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANDESITE_EMERALD_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIPSTONE_EMERALD_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DEEPSLATE_EMERALD_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUFF_EMERALD_ORE, RenderLayer.getTranslucent());

		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.LAPIS_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRANITE_LAPIS_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIORITE_LAPIS_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANDESITE_LAPIS_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIPSTONE_LAPIS_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DEEPSLATE_LAPIS_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUFF_LAPIS_ORE, RenderLayer.getTranslucent());

		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DIAMOND_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRANITE_DIAMOND_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIORITE_DIAMOND_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANDESITE_DIAMOND_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIPSTONE_DIAMOND_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DEEPSLATE_DIAMOND_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUFF_DIAMOND_ORE, RenderLayer.getTranslucent());

		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.NETHER_GOLD_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACKSTONE_GOLD_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BASALT_GOLD_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.NETHER_QUARTZ_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACKSTONE_QUARTZ_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BASALT_QUARTZ_ORE, RenderLayer.getTranslucent());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_QUARTZ_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRANITE_WHITE_QUARTZ_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIORITE_WHITE_QUARTZ_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANDESITE_WHITE_QUARTZ_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIPSTONE_WHITE_QUARTZ_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEEPSLATE_WHITE_QUARTZ_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUFF_WHITE_QUARTZ_ORE, RenderLayer.getTranslucent());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRANITE_RUBY_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIORITE_RUBY_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANDESITE_RUBY_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIPSTONE_RUBY_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEEPSLATE_RUBY_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUFF_RUBY_ORE, RenderLayer.getTranslucent());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SAPPHIRE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRANITE_SAPPHIRE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIORITE_SAPPHIRE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANDESITE_SAPPHIRE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIPSTONE_SAPPHIRE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUFF_SAPPHIRE_ORE, RenderLayer.getTranslucent());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOPAZ_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRANITE_TOPAZ_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIORITE_TOPAZ_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANDESITE_TOPAZ_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIPSTONE_TOPAZ_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEEPSLATE_TOPAZ_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUFF_TOPAZ_ORE, RenderLayer.getTranslucent());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CITRINE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRANITE_CITRINE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIORITE_CITRINE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANDESITE_CITRINE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIPSTONE_CITRINE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEEPSLATE_CITRINE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUFF_CITRINE_ORE, RenderLayer.getTranslucent());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ALEXANDRITE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRANITE_ALEXANDRITE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIORITE_ALEXANDRITE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANDESITE_ALEXANDRITE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIPSTONE_ALEXANDRITE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUFF_ALEXANDRITE_ORE, RenderLayer.getTranslucent());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPINEL_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRANITE_SPINEL_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIORITE_SPINEL_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANDESITE_SPINEL_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIPSTONE_SPINEL_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEEPSLATE_SPINEL_ORE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUFF_SPINEL_ORE, RenderLayer.getTranslucent());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SOUR_BERRY_BUSH, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NIGHTSHADE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NIGHTSHADE_CROP, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_NIGHTSHADE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAMELIA, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAMELIA_CROP, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_CAMELIA, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LAVENDER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LAVENDER_CROP, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_LAVENDER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VANILLA_CROP, RenderLayer.getCutout());

		ModInit.LOGGER.info("Setting Entity Render Settings");
		EntityRendererRegistry.register(ModEntities.TUNA, TunaEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(TUNA, TunaEntityModel::getTexturedModelData);
	}
}