package gay.beegirl.Entity.Variants;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import gay.beegirl.Generics.VariantClass;
import gay.beegirl.ModRegistries;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.entry.RegistryElementCodec;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class CowVariant extends VariantClass {
    public static final Codec<CowVariant> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Identifier.CODEC.fieldOf("wild_texture").forGetter((cowVariant) -> cowVariant.wildId))
            .apply(instance, CowVariant::new));
    public static final PacketCodec<RegistryByteBuf, CowVariant> PACKET_CODEC;
    public static final Codec<RegistryEntry<CowVariant>> ENTRY_CODEC;
    public static final PacketCodec<RegistryByteBuf, RegistryEntry<CowVariant>> ENTRY_PACKET_CODEC;
    private final Identifier wildId;
    private final Identifier wildTextureId;

    public CowVariant(Identifier wildId) {
        this.wildId = wildId;
        this.wildTextureId = getTextureId(wildId);
    }


    public Identifier getWildTextureId() {
        return this.wildTextureId;
    }


    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CowVariant cowVariant)) {
            return false;
        } else {
            return Objects.equals(this.wildId, cowVariant.wildId);
        }
    }

    public int hashCode() {
        int i = 1;
        i = 31 * i + this.wildId.hashCode();
        return i;
    }

    static {
        PACKET_CODEC = PacketCodec.tuple(Identifier.PACKET_CODEC, CowVariant::getWildTextureId, CowVariant::new);
        ENTRY_CODEC = RegistryElementCodec.of(ModRegistries.COW_VARIANT_KEY, CODEC);
        ENTRY_PACKET_CODEC = PacketCodecs.registryEntry(ModRegistries.COW_VARIANT_KEY, PACKET_CODEC);
    }

    public static class CowData extends PassiveEntity.PassiveData {
        public final RegistryEntry<CowVariant> variant;

        public CowData(RegistryEntry<CowVariant> variant) {
            super(false);
            this.variant = variant;
        }
    }
}
