package com.yakasov.strongholdessences.mixin.structure;

import net.minecraft.structure.StructureSets;
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
}
