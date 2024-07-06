package gay.beegirl.Sound;

import gay.beegirl.ModInit;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {
    public static void registerModSoundEvents(){
        Registry.register(Registries.SOUND_EVENT, ENTITY_TUNA_AMBIENT_ID, ENTITY_TUNA_AMBIENT_EVENT);
        Registry.register(Registries.SOUND_EVENT, ENTITY_TUNA_DEATH_ID, ENTITY_TUNA_DEATH_EVENT);
        Registry.register(Registries.SOUND_EVENT, ENTITY_TUNA_FLOP_ID, ENTITY_TUNA_FLOP_EVENT);
        Registry.register(Registries.SOUND_EVENT, ENTITY_TUNA_HURT_ID, ENTITY_TUNA_HURT_EVENT);
    }

    private static final Identifier ENTITY_TUNA_AMBIENT_ID = Identifier.of(ModInit.MOD_ID, "entity.tuna.ambient");
    public static SoundEvent ENTITY_TUNA_AMBIENT_EVENT = SoundEvent.of(ENTITY_TUNA_AMBIENT_ID);
    private static final Identifier ENTITY_TUNA_DEATH_ID = Identifier.of(ModInit.MOD_ID, "entity.tuna.death");
    public static SoundEvent ENTITY_TUNA_DEATH_EVENT = SoundEvent.of(ENTITY_TUNA_DEATH_ID);
    private static final Identifier ENTITY_TUNA_FLOP_ID = Identifier.of(ModInit.MOD_ID, "entity.tuna.flop");
    public static SoundEvent ENTITY_TUNA_FLOP_EVENT = SoundEvent.of(ENTITY_TUNA_FLOP_ID);
    private static final Identifier ENTITY_TUNA_HURT_ID = Identifier.of(ModInit.MOD_ID, "entity.tuna.hurt");
    public static SoundEvent ENTITY_TUNA_HURT_EVENT = SoundEvent.of(ENTITY_TUNA_HURT_ID);
}