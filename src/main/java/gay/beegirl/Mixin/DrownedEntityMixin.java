package gay.beegirl.Mixin;

import gay.beegirl.Entity.Variants.DrownedVariant;
import gay.beegirl.Entity.Variants.DrownedVariants;
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
import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;
import java.util.Optional;

@Mixin(DrownedEntity.class)
public class DrownedEntityMixin extends ZombieEntity implements VariantHolder<RegistryEntry<DrownedVariant>>, IVariantMixinEntity<DrownedVariant> {
    @Unique
    private static TrackedData<RegistryEntry<DrownedVariant>> VARIANT;

    protected DrownedEntityMixin(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Unique
    public Identifier getTextureId() {
        DrownedVariant drownedVariant = this.getVariant().value();
        return drownedVariant.getWildTextureId();
    }

    @Override
    public void setVariant(RegistryEntry<DrownedVariant> registryEntry) {
        ((DrownedEntity)(Object)this).getDataTracker().set(VARIANT, registryEntry);
    }

    @Override
    public RegistryEntry<DrownedVariant> getVariant() {
        return (RegistryEntry<DrownedVariant>)((DrownedEntity)(Object)this).getDataTracker().get(VARIANT);
    }

    @Unique
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        DynamicRegistryManager dynamicRegistryManager = ((DrownedEntity)(Object)this).getRegistryManager();
        Registry<DrownedVariant> registry = dynamicRegistryManager.get(ModRegistries.DROWNED_VARIANT_KEY);
        Optional var10002 = registry.getEntry(DrownedVariants.DEFAULT);
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
                .of(ModRegistries.DROWNED_VARIANT_KEY, variantId)).flatMap((variantKey) -> this.getRegistryManager()
                .get(ModRegistries.DROWNED_VARIANT_KEY).getEntry(variantKey))
                .ifPresent(this::setVariant);
    }

    @Inject(
            method = "initialize",
            at = @At("RETURN"),
            cancellable = true
    )
    public void initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, CallbackInfoReturnable<EntityData> cir) {
        RegistryEntry<DrownedVariant> variant;
        if (entityData instanceof DrownedVariant.DrownedData drownedData) {
            variant = drownedData.variant;
        } else {
            variant = DrownedVariants.getRandom(this.getRegistryManager(), world);
            entityData = new DrownedVariant.DrownedData(variant);
        }

        this.setVariant(variant);
        cir.setReturnValue(super.initialize(world, difficulty, spawnReason, (EntityData)entityData));
    }

    static {
        ModRegistries.DROWNED_VARIANT_TRACKED = TrackedDataHandler.create(DrownedVariant.ENTRY_PACKET_CODEC);
        TrackedDataHandlerRegistry.register(ModRegistries.DROWNED_VARIANT_TRACKED);
        VARIANT = DataTracker.registerData(DrownedEntityMixin.class, ModRegistries.DROWNED_VARIANT_TRACKED);
    }
}

