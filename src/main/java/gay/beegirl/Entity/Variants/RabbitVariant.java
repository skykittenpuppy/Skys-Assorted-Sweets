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

public class RabbitVariant extends VariantClass {
    public static final Codec<RabbitVariant> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Identifier.CODEC.fieldOf("wild_texture").forGetter((rabbitVariant) -> rabbitVariant.wildId))
            .apply(instance, RabbitVariant::new));
    public static final PacketCodec<RegistryByteBuf, RabbitVariant> PACKET_CODEC;
    public static final Codec<RegistryEntry<RabbitVariant>> ENTRY_CODEC;
    public static final PacketCodec<RegistryByteBuf, RegistryEntry<RabbitVariant>> ENTRY_PACKET_CODEC;
    private final Identifier wildId;
    private final Identifier wildTextureId;

    public RabbitVariant(Identifier wildId) {
        this.wildId = wildId;
        this.wildTextureId = getTextureId(wildId);
    }


    public Identifier getWildTextureId() {
        return this.wildTextureId;
    }


    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof RabbitVariant rabbitVariant)) {
            return false;
        } else {
            return Objects.equals(this.wildId, rabbitVariant.wildId);
        }
    }

    public int hashCode() {
        int i = 1;
        i = 31 * i + this.wildId.hashCode();
        return i;
    }

    static {
        PACKET_CODEC = PacketCodec.tuple(Identifier.PACKET_CODEC, RabbitVariant::getWildTextureId, RabbitVariant::new);
        ENTRY_CODEC = RegistryElementCodec.of(ModRegistries.RABBIT_VARIANT_KEY, CODEC);
        ENTRY_PACKET_CODEC = PacketCodecs.registryEntry(ModRegistries.RABBIT_VARIANT_KEY, PACKET_CODEC);
    }

    public static class RabbitData extends PassiveEntity.PassiveData {
        public final RegistryEntry<RabbitVariant> variant;

        public RabbitData(RegistryEntry<RabbitVariant> variant) {
            super(false);
            this.variant = variant;
        }
    }
}
