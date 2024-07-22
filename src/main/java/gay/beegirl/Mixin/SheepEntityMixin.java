package gay.beegirl.Mixin;

import gay.beegirl.Entity.Variants.SheepVariant;
import gay.beegirl.Entity.Variants.SheepVariants;
import gay.beegirl.Generics.IVariantMixinSheepEntity;
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
import net.minecraft.entity.passive.SheepEntity;
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
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;
import java.util.Optional;

@Mixin(SheepEntity.class)
abstract public class SheepEntityMixin extends PassiveEntity implements VariantHolder<RegistryEntry<SheepVariant>>, IVariantMixinSheepEntity<SheepVariant> {
    @Unique
    private static TrackedData<RegistryEntry<SheepVariant>> VARIANT;

    protected SheepEntityMixin(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }

    @Unique
    public Identifier getTextureId() {
        SheepVariant sheepVariant = this.getVariant().value();
        return sheepVariant.getWildTextureId();
    }
    @Unique
    public Identifier getDyedTextureId() {
        SheepVariant sheepVariant = this.getVariant().value();
        return sheepVariant.getDyedTextureId();
    }

    @Override
    public void setVariant(RegistryEntry<SheepVariant> registryEntry) {
        ((SheepEntity)(Object)this).getDataTracker().set(VARIANT, registryEntry);
    }

    @Override
    public RegistryEntry<SheepVariant> getVariant() {
        return (RegistryEntry<SheepVariant>)((SheepEntity)(Object)this).getDataTracker().get(VARIANT);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        SheepEntity sheepEntity = EntityType.SHEEP.create(world);
        if (sheepEntity != null && entity instanceof SheepEntity sheepEntity2) {
            if (this.random.nextBoolean()) {
                ((IVariantMixinSheepEntity)(Object)sheepEntity).setVariant(this.getVariant());
            } else {
                ((IVariantMixinSheepEntity)(Object)sheepEntity).setVariant(((IVariantMixinSheepEntity)(Object)sheepEntity2).getVariant());
            }
            sheepEntity.setColor(this.getChildColor(((SheepEntity)(Object)this), sheepEntity2));
        }
        return sheepEntity;
    }

    @Inject(
            method = "initDataTracker",
            at = @At("TAIL")
    )
    protected void initDataTracker(DataTracker.Builder builder, CallbackInfo ci) {
        DynamicRegistryManager dynamicRegistryManager = ((SheepEntity)(Object)this).getRegistryManager();
        Registry<SheepVariant> registry = dynamicRegistryManager.get(ModRegistries.SHEEP_VARIANT_KEY);
        Optional var10002 = registry.getEntry(SheepVariants.DEFAULT);
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
                .of(ModRegistries.SHEEP_VARIANT_KEY, variantId)).flatMap((variantKey) -> this.getRegistryManager()
                .get(ModRegistries.SHEEP_VARIANT_KEY).getEntry(variantKey))
                .ifPresent(this::setVariant);
    }

    @Inject(
            method = "initialize",
            at = @At("RETURN"),
            cancellable = true
    )
    public void initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, CallbackInfoReturnable<EntityData> cir) {
        RegistryEntry<SheepVariant> variant;
        if (entityData instanceof SheepVariant.SheepData sheepData) {
            variant = sheepData.variant;
        } else {
            variant = SheepVariants.getRandom(this.getRegistryManager(), world);
            entityData = new SheepVariant.SheepData(variant);
        }

        this.setVariant(variant);
        cir.setReturnValue(super.initialize(world, difficulty, spawnReason, (EntityData)entityData));
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injected(CallbackInfo ci) {
        ModRegistries.SHEEP_VARIANT_TRACKED = TrackedDataHandler.create(SheepVariant.ENTRY_PACKET_CODEC);
        TrackedDataHandlerRegistry.register(ModRegistries.SHEEP_VARIANT_TRACKED);
        VARIANT = DataTracker.registerData(SheepEntityMixin.class, ModRegistries.SHEEP_VARIANT_TRACKED);
    }
}

