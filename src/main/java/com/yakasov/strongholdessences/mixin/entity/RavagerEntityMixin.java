package com.yakasov.strongholdessences.mixin.entity;

import com.yakasov.strongholdessences.item.EssenceItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RavagerEntity.class)
public class RavagerEntityMixin extends HostileEntity {
    protected RavagerEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void dropEquipment(ServerWorld world, DamageSource source, boolean causedByPlayer) {
        RavagerEntity ravagerEntity = (RavagerEntity)(Object)this;

        ravagerEntity.dropItem(world, EssenceItems.RAID_ESSENCE);
    }
}
