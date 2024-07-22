package gay.beegirl.Entity.Variants;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import gay.beegirl.Generics.VariantClass;
import gay.beegirl.Registries.ModRegistries;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.entry.RegistryElementCodec;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class ChickenVariant extends VariantClass {
    public static final Codec<ChickenVariant> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Identifier.CODEC.fieldOf("wild_texture").forGetter((chickenVariant) -> chickenVariant.wildId))
            .apply(instance, ChickenVariant::new));
    public static final PacketCodec<RegistryByteBuf, ChickenVariant> PACKET_CODEC;
    public static final Codec<RegistryEntry<ChickenVariant>> ENTRY_CODEC;
    public static final PacketCodec<RegistryByteBuf, RegistryEntry<ChickenVariant>> ENTRY_PACKET_CODEC;
    private final Identifier wildId;
    private final Identifier wildTextureId;

    public ChickenVariant(Identifier wildId) {
        this.wildId = wildId;
        this.wildTextureId = getTextureId(wildId);
    }

    public Identifier getWildTextureId() {
        return this.wildTextureId;
    }


    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ChickenVariant chickenVariant)) {
            return false;
        } else {
            return Objects.equals(this.wildId, chickenVariant.wildId);
        }
    }

    public int hashCode() {
        int i = 1;
        i = 31 * i + this.wildId.hashCode();
        return i;
    }

    static {
        PACKET_CODEC = PacketCodec.tuple(Identifier.PACKET_CODEC, ChickenVariant::getWildTextureId, ChickenVariant::new);
        ENTRY_CODEC = RegistryElementCodec.of(ModRegistries.CHICKEN_VARIANT_KEY, CODEC);
        ENTRY_PACKET_CODEC = PacketCodecs.registryEntry(ModRegistries.CHICKEN_VARIANT_KEY, PACKET_CODEC);
    }

    public static class ChickenData extends PassiveEntity.PassiveData {
        public final RegistryEntry<ChickenVariant> variant;

        public ChickenData(RegistryEntry<ChickenVariant> variant) {
            super(false);
            this.variant = variant;
        }
    }
}
