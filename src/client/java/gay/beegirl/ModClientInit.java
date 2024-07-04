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
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.COAL_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DEEPSLATE_COAL_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.IRON_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DEEPSLATE_IRON_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.COPPER_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DEEPSLATE_COPPER_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.GOLD_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DEEPSLATE_GOLD_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.REDSTONE_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DEEPSLATE_REDSTONE_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.EMERALD_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DEEPSLATE_EMERALD_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.LAPIS_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DEEPSLATE_LAPIS_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DIAMOND_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DEEPSLATE_DIAMOND_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.NETHER_GOLD_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.NETHER_QUARTZ_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_ORE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEEPSLATE_RUBY_ORE, RenderLayer.getCutout());

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