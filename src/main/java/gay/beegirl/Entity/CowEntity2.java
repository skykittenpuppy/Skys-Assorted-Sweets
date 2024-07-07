package gay.beegirl.Entity;

import gay.beegirl.ModRegistries;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

public class CowEntity2 extends AnimalEntity implements VariantHolder<RegistryEntry<CowVariant>> {
    private static final TrackedData<RegistryEntry<CowVariant>> VARIANT;
    private static final EntityDimensions BABY_BASE_DIMENSIONS;

    public CowEntity2(EntityType<? extends CowEntity2> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 2.0));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(3, new TemptGoal(this, 1.25, (stack) -> {
            return stack.isIn(ItemTags.COW_FOOD);
        }, false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.25));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    public boolean isBreedingItem(ItemStack stack) {
        return stack.isIn(ItemTags.COW_FOOD);
    }

    public static DefaultAttributeContainer.Builder createCowAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20000000298023224);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_COW_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_COW_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_COW_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.BUCKET) && !this.isBaby()) {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, player, Items.MILK_BUCKET.getDefaultStack());
            player.setStackInHand(hand, itemStack2);
            return ActionResult.success(this.getWorld().isClient);
        } else {
            return super.interactMob(player, hand);
        }
    }

    @Nullable
    public CowEntity2 createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        CowEntity2 cowEntity = ModEntities.COW.create(serverWorld);
        if (cowEntity != null && passiveEntity instanceof CowEntity2 cowEntity2) {
            if (this.random.nextBoolean()) {
                cowEntity.setVariant(this.getVariant());
            } else {
                cowEntity.setVariant(cowEntity2.getVariant());
            }
        }
        return cowEntity;
    }

    public EntityDimensions getBaseDimensions(EntityPose pose) {
        return this.isBaby() ? BABY_BASE_DIMENSIONS : super.getBaseDimensions(pose);
    }

    static {
        BABY_BASE_DIMENSIONS = EntityType.COW.getDimensions().scaled(0.5F).withEyeHeight(0.665F);
    }

    public Identifier getTextureId() {
        return this.getVariant().value().getWildTextureId();
    }

    @Override
    public void setVariant(RegistryEntry<CowVariant> variant) {
        this.dataTracker.set(VARIANT, variant);
    }

    @Override
    public RegistryEntry<CowVariant> getVariant() {
        return this.dataTracker.get(VARIANT);
    }
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        DynamicRegistryManager dynamicRegistryManager = this.getRegistryManager();
        Registry<CowVariant> registry = dynamicRegistryManager.get(ModRegistries.COW_VARIANT_KEY);
        Optional var10002 = registry.getEntry(CowVariants.DEFAULT);
        Objects.requireNonNull(registry);
        builder.add(VARIANT, (RegistryEntry)var10002.or(registry::getDefaultEntry).orElseThrow());
    }
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        this.getVariant().getKey().ifPresent((registryKey) -> {
            nbt.putString("variant", registryKey.getValue().toString());
        });
    }
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        Optional.ofNullable(Identifier.tryParse(nbt.getString("variant"))).map((variantId) -> RegistryKey
                        .of(ModRegistries.COW_VARIANT_KEY, variantId)).flatMap((variantKey) -> this.getRegistryManager()
                        .get(ModRegistries.COW_VARIANT_KEY).getEntry(variantKey))
                .ifPresent(this::setVariant);
    }
    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        RegistryEntry<Biome> registryEntry = world.getBiome(this.getBlockPos());
        RegistryEntry registryEntry2;
        if (entityData instanceof CowData cowData) {
            registryEntry2 = cowData.variant;
        } else {
            registryEntry2 = CowVariants.fromBiome(this.getRegistryManager(), registryEntry);
            entityData = new CowData(registryEntry2);
        }

        this.setVariant(registryEntry2);
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    static {
        VARIANT = DataTracker.registerData(CowEntity2.class, ModRegistries.COW_VARIANT_TRACKED);
    }

    public static class CowData extends PassiveEntity.PassiveData {
        public final RegistryEntry<CowVariant> variant;

        public CowData(RegistryEntry<CowVariant> variant) {
            super(false);
            this.variant = variant;
        }
    }
}
