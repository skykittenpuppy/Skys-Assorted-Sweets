package gay.beegirl.Mixin;

import gay.beegirl.Entity.Variants.ChickenVariant;
import gay.beegirl.Entity.Variants.ChickenVariants;
import gay.beegirl.Generics.IVariantMixinEntity;
import gay.beegirl.ModRegistries;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.VariantHolder;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;
import java.util.Optional;

@Mixin(ChickenEntity.class)
public class ChickenEntityMixin extends PassiveEntity implements VariantHolder<RegistryEntry<ChickenVariant>>, IVariantMixinEntity<ChickenVariant> {
    @Unique
    private static TrackedData<RegistryEntry<ChickenVariant>> VARIANT;

    protected ChickenEntityMixin(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }

    @Unique
    public Identifier getTextureId() {
        ChickenVariant chickenVariant = this.getVariant().value();
        return chickenVariant.getWildTextureId();
    }

    @Override
    public void setVariant(RegistryEntry<ChickenVariant> registryEntry) {
        ((ChickenEntity)(Object)this).getDataTracker().set(VARIANT, registryEntry);
    }

    @Override
    public RegistryEntry<ChickenVariant> getVariant() {
        return (RegistryEntry<ChickenVariant>)((ChickenEntity)(Object)this).getDataTracker().get(VARIANT);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        ChickenEntity chickenEntity = EntityType.CHICKEN.create(world);
        if (chickenEntity != null && entity instanceof ChickenEntity chickenEntity2) {
            if (this.random.nextBoolean()) {
                ((IVariantMixinEntity)(Object)chickenEntity).setVariant(this.getVariant());
            } else {
                ((IVariantMixinEntity)(Object)chickenEntity).setVariant(((IVariantMixinEntity)(Object)chickenEntity2).getVariant());
            }
        }
        return chickenEntity;
    }

    @Unique
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        DynamicRegistryManager dynamicRegistryManager = ((ChickenEntity)(Object)this).getRegistryManager();
        Registry<ChickenVariant> registry = dynamicRegistryManager.get(ModRegistries.CHICKEN_VARIANT_KEY);
        Optional var10002 = registry.getEntry(ChickenVariants.DEFAULT);
        Objects.requireNonNull(registry);
        builder.add(VARIANT, (RegistryEntry)var10002.or(registry::getDefaultEntry).orElseThrow());
    }

    @Inject(
            method = "writeCustomDataToNbt",
            at = @At("TAIL")
    )
    public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        this.getVariant().getKey().ifPresent((registryKey) -> {
            nbt.putString("variant", registryKey.getValue().toString());
        });
    }

    @Inject(
            method = "readCustomDataFromNbt",
            at = @At("TAIL")
    )
    public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        Optional.ofNullable(Identifier.tryParse(nbt.getString("variant"))).map((variantId) -> RegistryKey
                .of(ModRegistries.CHICKEN_VARIANT_KEY, variantId)).flatMap((variantKey) -> this.getRegistryManager()
                .get(ModRegistries.CHICKEN_VARIANT_KEY).getEntry(variantKey))
                .ifPresent(this::setVariant);
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        RegistryEntry variant;
        if (entityData instanceof ChickenVariant.ChickenData chickenData) {
            variant = chickenData.variant;
        } else {
            variant = ChickenVariants.getRandom(this.getRegistryManager());
            entityData = new ChickenVariant.ChickenData(variant);
        }

        this.setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, (EntityData)entityData);
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injected(CallbackInfo ci) {
        ModRegistries.CHICKEN_VARIANT_TRACKED = TrackedDataHandler.create(ChickenVariant.ENTRY_PACKET_CODEC);
        TrackedDataHandlerRegistry.register(ModRegistries.CHICKEN_VARIANT_TRACKED);
        VARIANT = DataTracker.registerData(ChickenEntityMixin.class, ModRegistries.CHICKEN_VARIANT_TRACKED);
    }
}

