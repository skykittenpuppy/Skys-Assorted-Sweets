package gay.beegirl;

import gay.beegirl.CustomClasses.TunaEntityModel;
import gay.beegirl.CustomClasses.TunaEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModClientInit implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModInit.LOGGER.info("Setting Render Layers");

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SOUR_BERRY_BUSH, RenderLayer.getCutout());

		ModInit.LOGGER.info("Setting Entity Renderers");

		EntityRendererRegistry.register(ModEntities.TUNA, TunaEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(TUNA, TunaEntityModel::getTexturedModelData);
	}

	public static final EntityModelLayer TUNA = new EntityModelLayer(Identifier.tryParse(ModInit.MOD_ID,"tuna"), "main");
}