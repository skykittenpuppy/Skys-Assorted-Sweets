package gay.beegirl.CustomClasses;

import gay.beegirl.ModInit;
import gay.beegirl.ModClientInit;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class TunaEntityRenderer extends MobEntityRenderer<TunaEntity, TunaEntityModel<TunaEntity>> {
    private static final Identifier TEXTURE = Identifier.tryParse(ModInit.MOD_ID, "textures/entity/fish/tuna.png");

    public TunaEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new TunaEntityModel(context.getPart(ModClientInit.TUNA)), 0.4f);
    }

    public Identifier getTexture(TunaEntity entity) {
        return TEXTURE;
    }

    protected void setupTransforms(TunaEntity tunaEntity, MatrixStack matrixStack, float f, float g, float h, float i) {
        super.setupTransforms(tunaEntity, matrixStack, f, g, h, i);
        float j = 1.0F;
        float k = 1.0F;
        if (!tunaEntity.isTouchingWater()) {
            j = 1.3F;
            k = 1.7F;
        }

        float l = j * 4.3F * MathHelper.sin(k * 0.6F * f);
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(l));
        matrixStack.translate(0.0F, 0.0F, -0.4F);
        if (!tunaEntity.isTouchingWater()) {
            matrixStack.translate(0.2F, 0.1F, 0.0F);
            matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90.0F));
        }
    }
}
