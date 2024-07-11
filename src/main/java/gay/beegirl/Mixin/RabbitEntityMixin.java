package gay.beegirl.Mixin;

import gay.beegirl.Entity.Variants.RabbitVariant;
import gay.beegirl.Entity.Variants.RabbitVariants;
import gay.beegirl.Generics.IVariantMixinEntity;
import gay.beegirl.ModRegistries;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;
import java.util.Optional;

@Mixin(RabbitEntity.class)
abstract public class RabbitEntityMixin extends PassiveEntity implements VariantHolder<RegistryEntry<RabbitVariant>>, IVariantMixinEntity<RabbitVariant> {
    @Unique
    private static TrackedData<RegistryEntry<RabbitVariant>> VARIANT;
    @Shadow
    int moreCarrotTicks;
    @Shadow
    private int ticksUntilJump;
    @Shadow
    private boolean lastOnGround;
    @Shadow
    protected abstract void scheduleJump();
    @Shadow
    protected abstract void lookTowards(double x, double z);
    @Shadow
    public abstract void startJump();
    @Shadow
    protected abstract void enableJump();
    @Final
    @Shadow
    private static Identifier KILLER_BUNNY;
    @Final
    @Shadow
    private static Identifier KILLER_BUNNY_ATTACK_DAMAGE_MODIFIER_ID;

    @Shadow @Final private static TrackedData<Integer> RABBIT_TYPE;

    protected RabbitEntityMixin(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }

    @Unique
    public Identifier getTextureId() {
        RabbitVariant rabbitVariant = this.getVariant().value();
        return rabbitVariant.getWildTextureId();
    }


    @Override
    public void mobTick() {
        if (this.ticksUntilJump > 0) {
            --this.ticksUntilJump;
        }

        if (this.moreCarrotTicks > 0) {
            this.moreCarrotTicks -= this.random.nextInt(3);
            if (this.moreCarrotTicks < 0) {
                this.moreCarrotTicks = 0;
            }
        }

        if (this.isOnGround()) {
            if (!this.lastOnGround) {
                this.setJumping(false);
                this.scheduleJump();
            }

            if (this.getVariant().getKey().equals(RabbitVariants.CAERBANNOG) && this.ticksUntilJump == 0) {
                LivingEntity livingEntity = this.getTarget();
                if (livingEntity != null && this.squaredDistanceTo(livingEntity) < 16.0) {
                    this.lookTowards(livingEntity.getX(), livingEntity.getZ());
                    this.moveControl.moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), this.moveControl.getSpeed());
                    this.startJump();
                    this.lastOnGround = true;
                }
            }

            RabbitEntity.RabbitJumpControl rabbitJumpControl = (RabbitEntity.RabbitJumpControl)this.jumpControl;
            if (!rabbitJumpControl.isActive()) {
                if (this.moveControl.isMoving() && this.ticksUntilJump == 0) {
                    Path path = this.navigation.getCurrentPath();
                    Vec3d vec3d = new Vec3d(this.moveControl.getTargetX(), this.moveControl.getTargetY(), this.moveControl.getTargetZ());
                    if (path != null && !path.isFinished()) {
                        vec3d = path.getNodePosition(this);
                    }

                    this.lookTowards(vec3d.x, vec3d.z);
                    this.startJump();
                }
            } else if (!rabbitJumpControl.canJump()) {
                this.enableJump();
            }
        }

        this.lastOnGround = this.isOnGround();
    }

    public void playAttackSound() {
        if (this.getVariant().getKey().equals(RabbitVariants.CAERBANNOG)) {
            this.playSound(SoundEvents.ENTITY_RABBIT_ATTACK, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
        }

    }

    public SoundCategory getSoundCategory() {
        return this.getVariant().getKey().equals(RabbitVariants.CAERBANNOG) ? SoundCategory.HOSTILE : SoundCategory.NEUTRAL;
    }

    @Override
    public void setVariant(RegistryEntry<RabbitVariant> registryEntry) {
        if (registryEntry.getKey().equals(RabbitVariants.CAERBANNOG)) {
            this.getAttributeInstance(EntityAttributes.GENERIC_ARMOR).setBaseValue(8.0);
            this.goalSelector.add(4, new MeleeAttackGoal(this, 1.4, true));
            this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(new Class[0]));
            this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, true));
            this.targetSelector.add(2, new ActiveTargetGoal(this, WolfEntity.class, true));
            this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).updateModifier(new EntityAttributeModifier(KILLER_BUNNY_ATTACK_DAMAGE_MODIFIER_ID, 5.0, EntityAttributeModifier.Operation.ADD_VALUE));
            if (!this.hasCustomName()) {
                this.setCustomName(Text.translatable(Util.createTranslationKey("entity", KILLER_BUNNY)));
            }
        } else {
            this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).removeModifier(KILLER_BUNNY_ATTACK_DAMAGE_MODIFIER_ID);
        }
        ((RabbitEntity)(Object)this).getDataTracker().set(VARIANT, registryEntry);
    }

    @Unique
    public RegistryEntry<RabbitVariant> getVariant() {
        return (RegistryEntry<RabbitVariant>)((RabbitEntity)(Object)this).getDataTracker().get(VARIANT);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        RabbitEntity rabbitEntity = EntityType.RABBIT.create(world);
        if (rabbitEntity != null && entity instanceof RabbitEntity rabbitEntity2) {
            if (this.random.nextBoolean()) {
                ((IVariantMixinEntity)(Object)rabbitEntity).setVariant(this.getVariant());
            } else {
                ((IVariantMixinEntity)(Object)rabbitEntity).setVariant(((IVariantMixinEntity)(Object)rabbitEntity2).getVariant());
            }
        }
        return rabbitEntity;
    }

    @Override
    public void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        DynamicRegistryManager dynamicRegistryManager = ((RabbitEntity)(Object)this).getRegistryManager();
        Registry<RabbitVariant> registry = dynamicRegistryManager.get(ModRegistries.RABBIT_VARIANT_KEY);
        Optional var10002 = registry.getEntry(RabbitVariants.DEFAULT);
        Objects.requireNonNull(registry);
        builder.add(VARIANT, (RegistryEntry)var10002.or(registry::getDefaultEntry).orElseThrow());
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        this.getVariant().getKey().ifPresent((registryKey) -> {
            nbt.putString("variant", registryKey.getValue().toString());
        });
        nbt.putInt("MoreCarrotTicks", this.moreCarrotTicks);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        Optional.ofNullable(Identifier.tryParse(nbt.getString("variant"))).map((variantId) -> RegistryKey
                .of(ModRegistries.RABBIT_VARIANT_KEY, variantId)).flatMap((variantKey) -> this.getRegistryManager()
                .get(ModRegistries.RABBIT_VARIANT_KEY).getEntry(variantKey))
                .ifPresent(this::setVariant);
        this.moreCarrotTicks = nbt.getInt("MoreCarrotTicks");
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        RegistryEntry<RabbitVariant> variant;
        if (entityData instanceof RabbitVariant.RabbitData rabbitData) {
            variant = rabbitData.variant;
        } else {
            variant = RabbitVariants.getRandom(this.getRegistryManager(), world);
            entityData = new RabbitVariant.RabbitData(variant);
        }

        this.setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, (EntityData)entityData);
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injected(CallbackInfo ci) {
        ModRegistries.RABBIT_VARIANT_TRACKED = TrackedDataHandler.create(RabbitVariant.ENTRY_PACKET_CODEC);
        TrackedDataHandlerRegistry.register(ModRegistries.RABBIT_VARIANT_TRACKED);
        VARIANT = DataTracker.registerData(RabbitEntityMixin.class, ModRegistries.RABBIT_VARIANT_TRACKED);
    }
}

@Mixin(targets = "net.minecraft.entity.passive.RabbitEntity$FleeGoal")
class FleeGoalMixin<T extends LivingEntity> extends FleeEntityGoal<T> {
    @Final
    @Shadow
    private RabbitEntity rabbit;

    public FleeGoalMixin(PathAwareEntity mob, Class<T> fleeFromType, float distance, double slowSpeed, double fastSpeed) {
        super(mob, fleeFromType, distance, slowSpeed, fastSpeed);
    }

    @Override
    public boolean canStart() {
        return !((IVariantMixinEntity<RabbitVariant>)this.rabbit).getVariant().getKey().equals(RabbitVariants.CAERBANNOG) && super.canStart();
    }
}