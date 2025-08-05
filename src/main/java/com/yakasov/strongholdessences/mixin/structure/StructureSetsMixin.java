package com.yakasov.strongholdessences.mixin.structure;

import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.structure.StructureSets;
import net.minecraft.world.gen.chunk.placement.ConcentricRingsStructurePlacement;
import net.minecraft.world.gen.chunk.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.gen.chunk.placement.SpreadType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(
        value = StructureSets.class,
        remap = false
)
public interface StructureSetsMixin {
    /*
     * Okay, here's the thing with this one. I _did_ try a better approach.
     * But I could not get it to compile, complaining about generic types.
     * The nature of trying to mixin to (and redirect) Registerable<StructureSet>.register() is
     * a nightmare.
     *
     * public net.minecraft.registry.entry.RegistryEntry.Reference<T> register(
     *      net.minecraft.registry.RegistryKey<T> key,
     *      T value
     * )
     *
     * See those Ts? Try redirecting successfully with that method and those types.
     *
     * Otherwise, this approach works for now but just sucks
     */
    @Redirect(
            method = "bootstrap",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/world/gen/chunk/placement/RandomSpreadStructurePlacement;"
            )
    )
    private static RandomSpreadStructurePlacement modifyMansionPlacement(
            int spacing,
            int separation,
            SpreadType spreadType,
            int salt
    ) {
        // new RandomSpreadStructurePlacement(80, 20, SpreadType.TRIANGULAR, 10387319)
        if (spacing == 80 && separation == 20 && spreadType == SpreadType.TRIANGULAR) {
            return new RandomSpreadStructurePlacement(20, 25, SpreadType.TRIANGULAR, salt);
        }
        return new RandomSpreadStructurePlacement(spacing, separation, spreadType, salt);
    }

    @Redirect(
            method = "bootstrap",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/world/gen/chunk/placement/ConcentricRingsStructurePlacement;"
            )
    )
    private static ConcentricRingsStructurePlacement modifyStrongholdPlacement(
            int distance,
            int spread,
            int structureCount,
            RegistryEntryList preferredBiomes
    ) {
        // new ConcentricRingsStructurePlacement(32, 3, 128, registryEntryLookup2.getOrThrow(BiomeTags.STRONGHOLD_BIASED_TO))
        if (distance == 32 && spread == 3 && structureCount == 128) {
            return new ConcentricRingsStructurePlacement(48, spread, structureCount, preferredBiomes);
        }
        return new ConcentricRingsStructurePlacement(distance, spread, structureCount, preferredBiomes);
    }
}
