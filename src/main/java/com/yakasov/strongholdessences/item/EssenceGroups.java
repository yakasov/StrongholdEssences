package com.yakasov.strongholdessences.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public final class EssenceGroups {
    public static final ItemGroup ESSENCE_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(EssenceItems.STRONGHOLD_COMPASS))
            .displayName(Text.translatable("itemGroup.strongholdessences.essence_group"))
            .entries((context, entries) -> {
                entries.add(EssenceItems.ANCIENT_ESSENCE);
                entries.add(EssenceItems.BASTION_ESSENCE);
                entries.add(EssenceItems.BURIED_ESSENCE);
                entries.add(EssenceItems.CLERIC_ESSENCE);
                entries.add(EssenceItems.COLOURFUL_ESSENCE);
                entries.add(EssenceItems.IGLOO_ESSENCE);
                entries.add(EssenceItems.LIBRARIAN_ESSENCE);
                entries.add(EssenceItems.LUCKY_ESSENCE);
                entries.add(EssenceItems.MONUMENT_ESSENCE);
                entries.add(EssenceItems.RAID_ESSENCE);
                entries.add(EssenceItems.SATURATING_ESSENCE);
                entries.add(EssenceItems.TRAIL_ESSENCE);
                entries.add(EssenceItems.TRIAL_ESSENCE);
                entries.add(EssenceItems.WARDEN_ESSENCE);
                entries.add(EssenceItems.WITHER_ESSENCE);
                entries.add(EssenceItems.WOODLAND_ESSENCE);
                entries.add(EssenceItems.HOSTILE_ESSENCE);
                entries.add(EssenceItems.PASSIVE_ESSENCE);
                entries.add(EssenceItems.STRONGHOLD_COMPASS);
            })
            .build();

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, Identifier.of("strongholdessences", "essence_group"), ESSENCE_GROUP);
    }
}
