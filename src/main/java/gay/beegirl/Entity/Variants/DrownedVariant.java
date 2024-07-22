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

public class DrownedVariant extends VariantClass {
    public static final Codec<DrownedVariant> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Identifier.CODEC.fieldOf("wild_texture").forGetter((drownedVariant) -> drownedVariant.wildId))
            .apply(instance, DrownedVariant::new));
    public static final PacketCodec<RegistryByteBuf, DrownedVariant> PACKET_CODEC;
    public static final Codec<RegistryEntry<DrownedVariant>> ENTRY_CODEC;
    public static final PacketCodec<RegistryByteBuf, RegistryEntry<DrownedVariant>> ENTRY_PACKET_CODEC;
    private final Identifier wildId;
    private final Identifier wildTextureId;

    public DrownedVariant(Identifier wildId) {
        this.wildId = wildId;
        this.wildTextureId = getTextureId(wildId);
    }


    public Identifier getWildTextureId() {
        return this.wildTextureId;
    }


    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DrownedVariant drownedVariant)) {
            return false;
        } else {
            return Objects.equals(this.wildId, drownedVariant.wildId);
        }
    }

    public int hashCode() {
        int i = 1;
        i = 31 * i + this.wildId.hashCode();
        return i;
    }

    static {
        PACKET_CODEC = PacketCodec.tuple(Identifier.PACKET_CODEC, DrownedVariant::getWildTextureId, DrownedVariant::new);
        ENTRY_CODEC = RegistryElementCodec.of(ModRegistries.DROWNED_VARIANT_KEY, CODEC);
        ENTRY_PACKET_CODEC = PacketCodecs.registryEntry(ModRegistries.DROWNED_VARIANT_KEY, PACKET_CODEC);
    }

    public static class DrownedData extends PassiveEntity.PassiveData {
        public final RegistryEntry<DrownedVariant> variant;

        public DrownedData(RegistryEntry<DrownedVariant> variant) {
            super(false);
            this.variant = variant;
        }
    }
}
