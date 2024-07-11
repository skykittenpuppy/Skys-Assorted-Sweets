package gay.beegirl.Mixin;

import gay.beegirl.Entity.Variants.GoatVariant;
import gay.beegirl.Entity.Variants.GoatVariants;
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
import net.minecraft.entity.passive.GoatEntity;
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
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;
import java.util.Optional;

@Mixin(GoatEntity.class)
public abstract class GoatEntityMixin extends PassiveEntity implements VariantHolder<RegistryEntry<GoatVariant>>, IVariantMixinEntity<GoatVariant> {
    @Shadow public abstract boolean isScreaming();

    @Unique
    private static TrackedData<RegistryEntry<GoatVariant>> VARIANT;

    protected GoatEntityMixin(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }

    @Unique
    public Identifier getTextureId() {
        GoatVariant goatVariant = this.getVariant().value();
        return goatVariant.getWildTextureId();
    }

    @Override
    public void setVariant(RegistryEntry<GoatVariant> registryEntry) {
        ((GoatEntity)(Object)this).getDataTracker().set(VARIANT, registryEntry);
    }

    @Override
    public RegistryEntry<GoatVariant> getVariant() {
        return (RegistryEntry<GoatVariant>)((GoatEntity)(Object)this).getDataTracker().get(VARIANT);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        GoatEntity goatEntity = EntityType.GOAT.create(world);
        if (goatEntity != null && entity instanceof GoatEntity goatEntity2) {
            if (this.random.nextBoolean()) {
                ((IVariantMixinEntity)(Object)goatEntity).setVariant(this.getVariant());
                goatEntity.setScreaming(this.isScreaming() || world.getRandom().nextDouble() < 0.02);
            } else {
                ((IVariantMixinEntity)(Object)goatEntity).setVariant(((IVariantMixinEntity)(Object)goatEntity2).getVariant());
                goatEntity.setScreaming(goatEntity2.isScreaming() || world.getRandom().nextDouble() < 0.02);
            }
        }
        return goatEntity;
    }

    @Inject(
            method = "initDataTracker",
            at = @At("TAIL")
    )
    protected void initDataTracker(DataTracker.Builder builder, CallbackInfo ci) {
        DynamicRegistryManager dynamicRegistryManager = ((GoatEntity)(Object)this).getRegistryManager();
        Registry<GoatVariant> registry = dynamicRegistryManager.get(ModRegistries.GOAT_VARIANT_KEY);
        Optional var10002 = registry.getEntry(GoatVariants.DEFAULT);
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
                .of(ModRegistries.GOAT_VARIANT_KEY, variantId)).flatMap((variantKey) -> this.getRegistryManager()
                .get(ModRegistries.GOAT_VARIANT_KEY).getEntry(variantKey))
                .ifPresent(this::setVariant);
    }

    @Inject(
            method = "initialize",
            at = @At("RETURN"),
            cancellable = true
    )
    public void initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, CallbackInfoReturnable<EntityData> cir) {
        RegistryEntry<GoatVariant> variant;
        if (entityData instanceof GoatVariant.GoatData goatData) {
            variant = goatData.variant;
        } else {
            variant = GoatVariants.getRandom(this.getRegistryManager(), world);
            entityData = new GoatVariant.GoatData(variant);
        }

        this.setVariant(variant);
        cir.setReturnValue(super.initialize(world, difficulty, spawnReason, (EntityData)entityData));
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injected(CallbackInfo ci) {
        ModRegistries.GOAT_VARIANT_TRACKED = TrackedDataHandler.create(GoatVariant.ENTRY_PACKET_CODEC);
        TrackedDataHandlerRegistry.register(ModRegistries.GOAT_VARIANT_TRACKED);
        VARIANT = DataTracker.registerData(GoatEntityMixin.class, ModRegistries.GOAT_VARIANT_TRACKED);
    }
}

