package com.yakasov.strongholdessences.mixin.village;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.village.raid.Raid;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Objects;

@Mixin(Raid.class)
public class RaidMixin {
    @Redirect(
            method = "spawnNextWave",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/EntityType;create(Lnet/minecraft/world/World;Lnet/minecraft/entity/SpawnReason;)Lnet/minecraft/entity/Entity;"
            )
    )
    private Entity spawnPillagerOverEvoker(EntityType instance, World world, SpawnReason reason) {
        if (Objects.equals(instance.toString(), "entity.minecraft.evoker")) {
            return EntityType.VINDICATOR.create(world, reason);
        }

        return instance.create(world, reason);
    }
}
