package gay.beegirl.CustomClasses;

import gay.beegirl.ModItems;
import gay.beegirl.ModSoundEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class TunaEntity extends SchoolingFishEntity {
    public TunaEntity(EntityType<? extends TunaEntity> entityType, World world) {
        super(entityType, world);
    }

    public int getMaxGroupSize() {
        return 5;
    }

    public ItemStack getBucketItem() {
        return new ItemStack(ModItems.TUNA_BUCKET);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SALMON_AMBIENT;
        //return ModSoundEvents.ENTITY_TUNA_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SALMON_DEATH;
        //return ModSoundEvents.ENTITY_TUNA_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SALMON_HURT;
        //return ModSoundEvents.ENTITY_TUNA_HURT;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_SALMON_FLOP;
        //return ModSoundEvents.ENTITY_TUNA_FLOP;
    }
}
