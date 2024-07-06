package gay.beegirl.Entity;

import gay.beegirl.Item.ModItems;
import gay.beegirl.Sound.ModSoundEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
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
        return ModSoundEvents.ENTITY_TUNA_AMBIENT_EVENT;
    }

    protected SoundEvent getDeathSound() {
        return ModSoundEvents.ENTITY_TUNA_DEATH_EVENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSoundEvents.ENTITY_TUNA_HURT_EVENT;
    }

    protected SoundEvent getFlopSound() {
        return ModSoundEvents.ENTITY_TUNA_FLOP_EVENT;
    }
}
