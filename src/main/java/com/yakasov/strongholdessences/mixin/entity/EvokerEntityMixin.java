package com.yakasov.strongholdessences.mixin.entity;

import com.yakasov.strongholdessences.item.EssenceItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.EvokerEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EvokerEntity.class)
public class EvokerEntityMixin extends HostileEntity {
    protected EvokerEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void dropEquipment(ServerWorld world, DamageSource source, boolean causedByPlayer) {
        EvokerEntity evokerEntity = (EvokerEntity)(Object)this;

        evokerEntity.dropItem(world, EssenceItems.WOODLAND_ESSENCE);
    }
}
