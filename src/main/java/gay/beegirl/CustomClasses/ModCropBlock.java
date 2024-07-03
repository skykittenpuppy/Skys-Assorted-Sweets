package gay.beegirl.CustomClasses;

import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class ModCropBlock extends CropBlock {
    public ModCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return this.asItem();
    }
}
