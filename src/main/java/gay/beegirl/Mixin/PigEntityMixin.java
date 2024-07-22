package gay.beegirl.Mixin;

import gay.beegirl.Entity.Variants.PigVariant;
import gay.beegirl.Entity.Variants.PigVariants;
import gay.beegirl.Generics.IVariantMixinEntity;
import gay.beegirl.Registries.ModRegistries;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.VariantHolder;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.PigEntity;
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

@Mixin(PigEntity.class)
public class PigEntityMixin extends PassiveEntity implements VariantHolder<RegistryEntry<PigVariant>>, IVariantMixinEntity<PigVariant> {
    @Unique
    private static TrackedData<RegistryEntry<PigVariant>> VARIANT;

    protected PigEntityMixin(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }

    @Unique
    public Identifier getTextureId() {
        PigVariant pigVariant = this.getVariant().value();
        return pigVariant.getWildTextureId();
    }

    @Override
    public void setVariant(RegistryEntry<PigVariant> registryEntry) {
        ((PigEntity)(Object)this).getDataTracker().set(VARIANT, registryEntry);
    }

    @Override
    public RegistryEntry<PigVariant> getVariant() {
        return (RegistryEntry<PigVariant>)((PigEntity)(Object)this).getDataTracker().get(VARIANT);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        PigEntity pigEntity = EntityType.PIG.create(world);
        if (pigEntity != null && entity instanceof PigEntity pigEntity2) {
            if (this.random.nextBoolean()) {
                ((IVariantMixinEntity)(Object)pigEntity).setVariant(this.getVariant());
            } else {
                ((IVariantMixinEntity)(Object)pigEntity).setVariant(((IVariantMixinEntity)(Object)pigEntity2).getVariant());
            }
        }
        return pigEntity;
    }

    @Inject(
            method = "initDataTracker",
            at = @At("TAIL")
    )
    protected void initDataTracker(DataTracker.Builder builder, CallbackInfo ci) {
        DynamicRegistryManager dynamicRegistryManager = ((PigEntity)(Object)this).getRegistryManager();
        Registry<PigVariant> registry = dynamicRegistryManager.get(ModRegistries.PIG_VARIANT_KEY);
        Optional var10002 = registry.getEntry(PigVariants.DEFAULT);
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
                .of(ModRegistries.PIG_VARIANT_KEY, variantId)).flatMap((variantKey) -> this.getRegistryManager()
                .get(ModRegistries.PIG_VARIANT_KEY).getEntry(variantKey))
                .ifPresent(this::setVariant);
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        RegistryEntry<PigVariant> variant;
        if (entityData instanceof PigVariant.PigData pigData) {
            variant = pigData.variant;
        } else {
            variant = PigVariants.getRandom(this.getRegistryManager(), world);
            entityData = new PigVariant.PigData(variant);
        }

        this.setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, (EntityData)entityData);
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injected(CallbackInfo ci) {
        ModRegistries.PIG_VARIANT_TRACKED = TrackedDataHandler.create(PigVariant.ENTRY_PACKET_CODEC);
        TrackedDataHandlerRegistry.register(ModRegistries.PIG_VARIANT_TRACKED);
        VARIANT = DataTracker.registerData(PigEntityMixin.class, ModRegistries.PIG_VARIANT_TRACKED);
    }
}

