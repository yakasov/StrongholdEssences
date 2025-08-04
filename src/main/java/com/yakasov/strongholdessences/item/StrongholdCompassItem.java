package com.yakasov.strongholdessences.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LodestoneTrackerComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.StructureTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.GlobalPos;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class StrongholdCompassItem extends Item {
    private BlockPos strongholdPos = null;

    public StrongholdCompassItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (!(entity instanceof PlayerEntity player)) return;

        if (strongholdPos == null) {
            strongholdPos = world.locateStructure(
                    StructureTags.EYE_OF_ENDER_LOCATED,
                    player.getBlockPos(),
                    250,
                    false
            );

            GlobalPos globalPos = GlobalPos.create(world.getRegistryKey(), strongholdPos);
            LodestoneTrackerComponent lodestoneTracker = new LodestoneTrackerComponent(
                    Optional.of(globalPos),
                    true
            );
            stack.set(DataComponentTypes.LODESTONE_TRACKER, lodestoneTracker);
        }
    }
}
