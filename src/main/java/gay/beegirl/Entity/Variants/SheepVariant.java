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

public class SheepVariant extends VariantClass {
    public static final Codec<SheepVariant> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Identifier.CODEC.fieldOf("wild_texture").forGetter((sheepVariant) -> sheepVariant.wildId),
            Identifier.CODEC.fieldOf("dyed_texture").forGetter((sheepVariant) -> sheepVariant.dyedId)
    ).apply(instance, SheepVariant::new));
    public static final PacketCodec<RegistryByteBuf, SheepVariant> PACKET_CODEC;
    public static final Codec<RegistryEntry<SheepVariant>> ENTRY_CODEC;
    public static final PacketCodec<RegistryByteBuf, RegistryEntry<SheepVariant>> ENTRY_PACKET_CODEC;
    private final Identifier wildId;
    private final Identifier dyedId;
    private final Identifier wildTextureId;
    private final Identifier dyedTextureId;

    public SheepVariant(Identifier wildId, Identifier dyedId) {
        this.wildId = wildId;
        this.wildTextureId = getTextureId(wildId);
        this.dyedId = dyedId;
        this.dyedTextureId = getDyedTextureId(dyedId);
    }

    protected static Identifier getTextureId(Identifier id) {
        return id.withPath((oldPath) -> "textures/" + oldPath + ".png");
    }
    protected static Identifier getDyedTextureId(Identifier id) {
        return id.withPath((oldPath) -> "textures/" + oldPath + ".png");
    }

    public Identifier getWildTextureId() {
        return this.wildTextureId;
    }

    public Identifier getDyedTextureId() {
        return this.dyedTextureId;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SheepVariant sheepVariant)) {
            return false;
        } else {
            return Objects.equals(this.wildId, sheepVariant.wildId) && Objects.equals(this.dyedId, sheepVariant.dyedId);
        }
    }

    public int hashCode() {
        int i = 1;
        i = 31 * i + this.wildId.hashCode();
        i = 31 * i + this.dyedId.hashCode();
        return i;
    }

    static {
        PACKET_CODEC = PacketCodec.tuple(Identifier.PACKET_CODEC, SheepVariant::getWildTextureId, Identifier.PACKET_CODEC, SheepVariant::getDyedTextureId, SheepVariant::new);
        ENTRY_CODEC = RegistryElementCodec.of(ModRegistries.SHEEP_VARIANT_KEY, CODEC);
        ENTRY_PACKET_CODEC = PacketCodecs.registryEntry(ModRegistries.SHEEP_VARIANT_KEY, PACKET_CODEC);
    }

    public static class SheepData extends PassiveEntity.PassiveData {
        public final RegistryEntry<SheepVariant> variant;

        public SheepData(RegistryEntry<SheepVariant> variant) {
            super(false);
            this.variant = variant;
        }
    }
}
