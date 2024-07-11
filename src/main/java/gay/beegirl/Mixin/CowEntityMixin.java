package gay.beegirl.Mixin;

import gay.beegirl.Entity.Variants.CowVariant;
import gay.beegirl.Entity.Variants.CowVariants;
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
import net.minecraft.entity.passive.CowEntity;
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

@Mixin(CowEntity.class)
public class CowEntityMixin extends PassiveEntity implements VariantHolder<RegistryEntry<CowVariant>>, IVariantMixinEntity<CowVariant> {
    @Unique
    private static TrackedData<RegistryEntry<CowVariant>> VARIANT;

    protected CowEntityMixin(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }

    @Unique
    public Identifier getTextureId() {
        CowVariant cowVariant = this.getVariant().value();
        return cowVariant.getWildTextureId();
    }

    @Override
    public void setVariant(RegistryEntry<CowVariant> registryEntry) {
        ((CowEntity)(Object)this).getDataTracker().set(VARIANT, registryEntry);
    }

    @Override
    public RegistryEntry<CowVariant> getVariant() {
        return (RegistryEntry<CowVariant>)((CowEntity)(Object)this).getDataTracker().get(VARIANT);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        CowEntity cowEntity = EntityType.COW.create(world);
        if (cowEntity != null && entity instanceof CowEntity cowEntity2) {
            if (this.random.nextBoolean()) {
                ((IVariantMixinEntity)(Object)cowEntity).setVariant(this.getVariant());
            } else {
                ((IVariantMixinEntity)(Object)cowEntity).setVariant(((IVariantMixinEntity)(Object)cowEntity2).getVariant());
            }
        }
        return cowEntity;
    }

    @Unique
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        DynamicRegistryManager dynamicRegistryManager = ((CowEntity)(Object)this).getRegistryManager();
        Registry<CowVariant> registry = dynamicRegistryManager.get(ModRegistries.COW_VARIANT_KEY);
        Optional var10002 = registry.getEntry(CowVariants.DEFAULT);
        Objects.requireNonNull(registry);
        builder.add(VARIANT, (RegistryEntry)var10002.or(registry::getDefaultEntry).orElseThrow());
    }

    @Unique
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        this.getVariant().getKey().ifPresent((registryKey) -> {
            nbt.putString("variant", registryKey.getValue().toString());
        });
    }

    @Unique
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        Optional.ofNullable(Identifier.tryParse(nbt.getString("variant"))).map((variantId) -> RegistryKey
                .of(ModRegistries.COW_VARIANT_KEY, variantId)).flatMap((variantKey) -> this.getRegistryManager()
                .get(ModRegistries.COW_VARIANT_KEY).getEntry(variantKey))
                .ifPresent(this::setVariant);
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        RegistryEntry<CowVariant> variant;
        if (entityData instanceof CowVariant.CowData cowData) {
            variant = cowData.variant;
        } else {
            variant = CowVariants.getRandom(this.getRegistryManager(), world);
            entityData = new CowVariant.CowData(variant);
        }

        this.setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, (EntityData)entityData);
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injected(CallbackInfo ci) {
        ModRegistries.COW_VARIANT_TRACKED = TrackedDataHandler.create(CowVariant.ENTRY_PACKET_CODEC);
        TrackedDataHandlerRegistry.register(ModRegistries.COW_VARIANT_TRACKED);
        VARIANT = DataTracker.registerData(CowEntityMixin.class, ModRegistries.COW_VARIANT_TRACKED);
    }
}

