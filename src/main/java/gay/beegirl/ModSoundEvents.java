package gay.beegirl;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {
    public static final SoundEvent ENTITY_TUNA_AMBIENT = register("entity.tuna.ambient");
    public static final SoundEvent ENTITY_TUNA_DEATH = register("entity.tuna.death");
    public static final SoundEvent ENTITY_TUNA_FLOP = register("entity.tuna.flop");
    public static final SoundEvent ENTITY_TUNA_HURT = register("entity.tuna.hurt");

    private static SoundEvent register(String name) {
        return Registry.register(Registries.SOUND_EVENT, Identifier.tryParse(ModInit.MOD_ID, name), SoundEvent.of(Identifier.tryParse(ModInit.MOD_ID, name)));
    }
}
