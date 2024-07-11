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

public class PigVariant extends VariantClass {
    public static final Codec<PigVariant> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Identifier.CODEC.fieldOf("wild_texture").forGetter((pigVariant) -> pigVariant.wildId))
            .apply(instance, PigVariant::new));
    public static final PacketCodec<RegistryByteBuf, PigVariant> PACKET_CODEC;
    public static final Codec<RegistryEntry<PigVariant>> ENTRY_CODEC;
    public static final PacketCodec<RegistryByteBuf, RegistryEntry<PigVariant>> ENTRY_PACKET_CODEC;
    private final Identifier wildId;
    private final Identifier wildTextureId;

    public PigVariant(Identifier wildId) {
        this.wildId = wildId;
        this.wildTextureId = getTextureId(wildId);
    }


    public Identifier getWildTextureId() {
        return this.wildTextureId;
    }


    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PigVariant pigVariant)) {
            return false;
        } else {
            return Objects.equals(this.wildId, pigVariant.wildId);
        }
    }

    public int hashCode() {
        int i = 1;
        i = 31 * i + this.wildId.hashCode();
        return i;
    }

    static {
        PACKET_CODEC = PacketCodec.tuple(Identifier.PACKET_CODEC, PigVariant::getWildTextureId, PigVariant::new);
        ENTRY_CODEC = RegistryElementCodec.of(ModRegistries.PIG_VARIANT_KEY, CODEC);
        ENTRY_PACKET_CODEC = PacketCodecs.registryEntry(ModRegistries.PIG_VARIANT_KEY, PACKET_CODEC);
    }

    public static class PigData extends PassiveEntity.PassiveData {
        public final RegistryEntry<PigVariant> variant;

        public PigData(RegistryEntry<PigVariant> variant) {
            super(false);
            this.variant = variant;
        }
    }
}
