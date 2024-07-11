package gay.beegirl.Generics;

import net.minecraft.util.Identifier;

public class VariantClass {
    protected static Identifier getTextureId(Identifier id) {
        return id.withPath((oldPath) -> "textures/" + oldPath + ".png");
    }
}
