package com.yakasov.strongholdessences.mixin.entity;

import com.yakasov.strongholdessences.item.EssenceItems;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WitherEntity.class)
public class WitherEntityMixin {
    @Inject(
            method = "dropEquipment",
            at = @At("TAIL")
    )
    private void dropWitherEssence(ServerWorld world, DamageSource source, boolean causedByPlayer, CallbackInfo ci) {
        WitherEntity witherEntity = (WitherEntity)(Object)this;

        witherEntity.dropItem(world, EssenceItems.WITHER_ESSENCE);
    }
}
