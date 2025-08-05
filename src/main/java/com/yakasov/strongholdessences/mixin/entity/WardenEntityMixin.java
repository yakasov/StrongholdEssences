package com.yakasov.strongholdessences.mixin.entity;

import com.yakasov.strongholdessences.item.EssenceItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(WardenEntity.class)
public class WardenEntityMixin extends HostileEntity {
    protected WardenEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void dropEquipment(ServerWorld world, DamageSource source, boolean causedByPlayer) {
        WardenEntity wardenEntity = (WardenEntity)(Object)this;

        wardenEntity.dropItem(world, EssenceItems.WARDEN_ESSENCE);
    }
}
