package com.yakasov.strongholdessences.loot_tables;

import com.yakasov.strongholdessences.item.EssenceItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

import java.util.Optional;

public class LootTableModifier {
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((registryKey, builder, lootTableSource, wrapperLookup) -> {
            if (lootTableSource.isBuiltin()) {
                /*
                 * Monument Essence
                 *
                 * Every other entity uses dropEquipment for guaranteed single drops but
                 * Ocean Guardians should have a chance for the Essence rather than guaranteed
                 * so we can just edit the drop table here
                 */
                if (EntityType.GUARDIAN.getLootTableKey().equals(Optional.of(registryKey))) {
                    builder.modifyPools(poolBuilder -> {
                        poolBuilder.with(ItemEntry.builder(EssenceItems.MONUMENT_ESSENCE)
                                .apply(SetCountLootFunction.builder(
                                        BinomialLootNumberProvider.create(1, 0.50F)
                                ))
                        );
                    });
                }

                // Trial Essence
                if (LootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_RARE_CHEST.equals(registryKey)) {
                    builder.modifyPools(poolBuilder -> {
                        poolBuilder.with(ItemEntry.builder(EssenceItems.TRIAL_ESSENCE)
                                .weight(3)
                                .apply(SetCountLootFunction.builder(
                                        UniformLootNumberProvider.create(1.0F, 1.0F)
                                ))
                        );
                    });
                }

                // Bastion Essence
                if (LootTables.BASTION_TREASURE_CHEST.equals(registryKey)) {
                    builder.modifyPools(poolBuilder -> {
                        poolBuilder.with(ItemEntry.builder(EssenceItems.BASTION_ESSENCE)
                                .weight(3)
                                .apply(SetCountLootFunction.builder(
                                        UniformLootNumberProvider.create(1.0F, 1.0F)
                                ))
                        );
                    });
                }

                // Ancient Essence
                if (LootTables.ANCIENT_CITY_CHEST.equals(registryKey)) {
                    builder.modifyPools(poolBuilder -> {
                        poolBuilder.with(ItemEntry.builder(EssenceItems.ANCIENT_ESSENCE)
                                .weight(2)
                                .apply(SetCountLootFunction.builder(
                                        UniformLootNumberProvider.create(1.0F, 1.0F)
                                ))
                        );
                    });
                }

                // Trail Essence
                if (LootTables.TRAIL_RUINS_RARE_ARCHAEOLOGY.equals(registryKey)) {
                    builder.modifyPools(poolBuilder -> {
                        poolBuilder.with(ItemEntry.builder(EssenceItems.TRAIL_ESSENCE)
                                .apply(SetCountLootFunction.builder(
                                        UniformLootNumberProvider.create(1.0F, 1.0F)
                                ))
                        );
                    });
                }

                // Buried Essence
                if (LootTables.BURIED_TREASURE_CHEST.equals(registryKey)) {
                    builder.modifyPools(poolBuilder -> {
                        poolBuilder.with(ItemEntry.builder(EssenceItems.BURIED_ESSENCE)
                                .weight(3)
                                .apply(SetCountLootFunction.builder(
                                        UniformLootNumberProvider.create(1.0F, 1.0F)
                                ))
                        );
                    });
                }

                // Igloo Essence
                if (LootTables.IGLOO_CHEST_CHEST.equals(registryKey)) {
                    builder.modifyPools(poolBuilder -> {
                        poolBuilder.with(ItemEntry.builder(EssenceItems.IGLOO_ESSENCE)
                                .weight(5)
                                .apply(SetCountLootFunction.builder(
                                        UniformLootNumberProvider.create(1.0F, 1.0F)
                                ))
                        );
                    });
                }
            }
        }));
    }
}
