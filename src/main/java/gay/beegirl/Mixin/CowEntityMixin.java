package gay.beegirl.Mixin;

import net.minecraft.entity.passive.CowEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CowEntity.class)
public class CowEntityMixin {}
//@Mixin(CowEntity.class)
//public class CowEntityMixin extends PassiveEntity implements VariantHolder<RegistryEntry<CowVariant>> {
//    @Unique
//    private static final TrackedData<RegistryEntry<CowVariant>> VARIANT = DataTracker.registerData(CowEntityMixin.class, ModRegistryKeys.COW_VARIANT_TRACKED);;
//
//    protected CowEntityMixin(EntityType<? extends PassiveEntity> entityType, World world) {
//        super(entityType, world);
//    }
//
//    public Identifier getTextureId() {
//        CowVariant cowVariant = this.getVariant().value();
//        return cowVariant.getWildTextureId();
//    }
//
//    @Override
//    public void setVariant(RegistryEntry<CowVariant> registryEntry) {
//        ((CowEntity)(Object)this).getDataTracker().set(VARIANT, registryEntry);
//    }
//
//    @Override
//    public RegistryEntry<CowVariant> getVariant() {
//        return (RegistryEntry<CowVariant>)((CowEntity)(Object)this).getDataTracker().get(VARIANT);
//    }
//
//
//    @Nullable
//    @Override
//    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
//        CowEntity cowEntity = EntityType.COW.create(world);
//        if (cowEntity != null && entity instanceof CowEntity cowEntity2) {
//            if (this.random.nextBoolean()) {
//                cowEntity.setVariant(this.getVariant());
//            } else {
//                cowEntity.setVariant(cowEntity2.getVariant());
//            }
//        }
//        return cowEntity;
//    }
//
//    protected void initDataTracker(DataTracker.Builder builder) {
//        super.initDataTracker(builder);
//        DynamicRegistryManager dynamicRegistryManager = ((CowEntity)(Object)this).getRegistryManager();
//        Registry<CowVariant> registry = dynamicRegistryManager.get(ModRegistryKeys.COW_VARIANT);
//        Optional var10002 = registry.getEntry(CowVariants.DEFAULT);
//        Objects.requireNonNull(registry);
//        builder.add(VARIANT, (RegistryEntry)var10002.or(registry::getDefaultEntry).orElseThrow());
//    }
//    public void writeCustomDataToNbt(NbtCompound nbt) {
//        super.writeCustomDataToNbt(nbt);
//        this.getVariant().getKey().ifPresent((registryKey) -> {
//            nbt.putString("variant", registryKey.getValue().toString());
//        });
//    }
//    public void readCustomDataFromNbt(NbtCompound nbt) {
//        super.readCustomDataFromNbt(nbt);
//        Optional.ofNullable(Identifier.tryParse(nbt.getString("variant"))).map((variantId) -> RegistryKey
//                .of(ModRegistryKeys.COW_VARIANT, variantId)).flatMap((variantKey) -> this.getRegistryManager()
//                .get(ModRegistryKeys.COW_VARIANT).getEntry(variantKey))
//                .ifPresent(this::setVariant);
//    }
//
//    @Nullable
//    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
//        RegistryEntry<Biome> registryEntry = world.getBiome(this.getBlockPos());
//        RegistryEntry registryEntry2;
//        if (entityData instanceof CowVariant.CowData cowData) {
//            registryEntry2 = cowData.variant;
//        } else {
//            registryEntry2 = CowVariants.fromBiome(this.getRegistryManager(), registryEntry);
//            entityData = new CowVariant.CowData(registryEntry2);
//        }
//
//        this.setVariant(registryEntry2);
//        return super.initialize(world, difficulty, spawnReason, (EntityData)entityData);
//    }
//}
