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

public class GoatVariant extends VariantClass {
    public static final Codec<GoatVariant> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Identifier.CODEC.fieldOf("wild_texture").forGetter((goatVariant) -> goatVariant.wildId))
            .apply(instance, GoatVariant::new));
    public static final PacketCodec<RegistryByteBuf, GoatVariant> PACKET_CODEC;
    public static final Codec<RegistryEntry<GoatVariant>> ENTRY_CODEC;
    public static final PacketCodec<RegistryByteBuf, RegistryEntry<GoatVariant>> ENTRY_PACKET_CODEC;
    private final Identifier wildId;
    private final Identifier wildTextureId;

    public GoatVariant(Identifier wildId) {
        this.wildId = wildId;
        this.wildTextureId = getTextureId(wildId);
    }


    public Identifier getWildTextureId() {
        return this.wildTextureId;
    }


    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof GoatVariant goatVariant)) {
            return false;
        } else {
            return Objects.equals(this.wildId, goatVariant.wildId);
        }
    }

    public int hashCode() {
        int i = 1;
        i = 31 * i + this.wildId.hashCode();
        return i;
    }

    static {
        PACKET_CODEC = PacketCodec.tuple(Identifier.PACKET_CODEC, GoatVariant::getWildTextureId, GoatVariant::new);
        ENTRY_CODEC = RegistryElementCodec.of(ModRegistries.GOAT_VARIANT_KEY, CODEC);
        ENTRY_PACKET_CODEC = PacketCodecs.registryEntry(ModRegistries.GOAT_VARIANT_KEY, PACKET_CODEC);
    }

    public static class GoatData extends PassiveEntity.PassiveData {
        public final RegistryEntry<GoatVariant> variant;

        public GoatData(RegistryEntry<GoatVariant> variant) {
            super(false);
            this.variant = variant;
        }
    }
}
