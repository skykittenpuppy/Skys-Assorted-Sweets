package gay.beegirl.Entity;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import gay.beegirl.ModRegistries;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.RegistryCodecs;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryElementCodec;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

import java.util.Objects;

public class CowVariant {
    public static final Codec<CowVariant> CODEC = RecordCodecBuilder
            .create((instance) ->
                    instance.group(Identifier.CODEC.fieldOf("wild_texture")
                                            .forGetter((wolfVariant) -> wolfVariant.wildId),
                                    RegistryCodecs.entryList(RegistryKeys.BIOME)
                                            .fieldOf("biomes")
                                            .forGetter(CowVariant::getBiomes))
                            .apply(instance, CowVariant::new));
    public static final PacketCodec<RegistryByteBuf, CowVariant> PACKET_CODEC;
    public static final Codec<RegistryEntry<CowVariant>> ENTRY_CODEC;
    public static final PacketCodec<RegistryByteBuf, RegistryEntry<CowVariant>> ENTRY_PACKET_CODEC;
    private final Identifier wildId;
    private final Identifier wildTextureId;
    private final RegistryEntryList<Biome> biomes;

    public CowVariant(Identifier wildId, RegistryEntryList<Biome> biomes) {
        this.wildId = wildId;
        this.wildTextureId = getTextureId(wildId);
        this.biomes = biomes;
    }

    private static Identifier getTextureId(Identifier id) {
        return id.withPath((oldPath) -> "textures/" + oldPath + ".png");
    }

    public Identifier getWildTextureId() {
        return this.wildTextureId;
    }

    public RegistryEntryList<Biome> getBiomes() {
        return this.biomes;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CowVariant cowVariant)) {
            return false;
        } else {
            return Objects.equals(this.wildId, cowVariant.wildId) && Objects.equals(this.biomes, cowVariant.biomes);
        }
    }

    public int hashCode() {
        int i = 1;
        i = 31 * i + this.wildId.hashCode();
        i = 31 * i + this.biomes.hashCode();
        return i;
    }

    static {
        PACKET_CODEC = PacketCodec.tuple(Identifier.PACKET_CODEC, CowVariant::getWildTextureId, PacketCodecs.registryEntryList(RegistryKeys.BIOME), CowVariant::getBiomes, CowVariant::new);
        ENTRY_CODEC = RegistryElementCodec.of(ModRegistries.COW_VARIANT_KEY, CODEC);
        ENTRY_PACKET_CODEC = PacketCodecs.registryEntry(ModRegistries.COW_VARIANT_KEY, PACKET_CODEC);
    }
}
