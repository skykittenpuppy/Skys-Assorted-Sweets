package gay.beegirl.Fluid;

import gay.beegirl.ModInit;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static final FlowableFluid FLOWING_VOID = register("flowing_void", new VoidFluid.Flowing());
    public static final FlowableFluid VOID = register("void", new VoidFluid.Still());

    private static <T extends Fluid> T register(String name, T fluid) {
        return Registry.register(Registries.FLUID, Identifier.of(ModInit.MOD_ID, name), fluid);
    }
}
