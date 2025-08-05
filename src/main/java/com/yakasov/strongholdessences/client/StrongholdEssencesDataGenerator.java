package com.yakasov.strongholdessences.client;

import com.yakasov.strongholdessences.item.EssenceItems;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class StrongholdEssencesDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(AdvancementsProvider::new);
    }

    static class AdvancementsProvider extends FabricAdvancementProvider {
        private static final Identifier back = Identifier.of("block/sculk");

        protected AdvancementsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(output, registryLookup);
        }

        @Override
        public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
            AdvancementEntry rootAdvancement = Advancement.Builder.create()
                    .display(
                            Items.ENDER_EYE,
                            Text.literal("Where's The Stronghold?"),
                            Text.literal("Find 16 Essences to create a Stronghold Compass!"),
                            back,
                            AdvancementFrame.TASK,
                            true,
                            true,
                            false
                    )
                    .criterion("install_essences", TickCriterion.Conditions.createTick())
                    .build(consumer, "strongholdessences/root");

            AdvancementEntry hostileEssenceAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                    .display(
                            EssenceItems.HOSTILE_ESSENCE,
                            Text.literal("Obtain Hostile Essence"),
                            Text.literal("Combine all the semi-hostile essences"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_hostile_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.HOSTILE_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_hostile_essence");

            AdvancementEntry strongholdCompassAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                    .display(
                            EssenceItems.STRONGHOLD_COMPASS,
                            Text.literal("Off To The Stronghold"),
                            Text.literal("Create the Stronghold Compass"),
                            null,
                            AdvancementFrame.CHALLENGE,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_stronghold_compass", InventoryChangedCriterion.Conditions.items(EssenceItems.STRONGHOLD_COMPASS))
                    .build(consumer, "strongholdessences/obtained_stronghold_compass");

            AdvancementEntry passiveEssenceAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                    .display(
                            EssenceItems.PASSIVE_ESSENCE,
                            Text.literal("Obtain Passive Essence"),
                            Text.literal("Combine all the somewhat passive essences"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_passive_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.PASSIVE_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_passive_essence");

            AdvancementEntry wardenEssenceAdvancement = Advancement.Builder.create().parent(hostileEssenceAdvancement)
                    .display(
                            EssenceItems.WARDEN_ESSENCE,
                            Text.literal("Obtain Warden Essence"),
                            Text.literal("Send a Warden back underground for good"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_warden_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.WARDEN_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_warden_essence");

            AdvancementEntry witherEssenceAdvancement = Advancement.Builder.create().parent(hostileEssenceAdvancement)
                    .display(
                            EssenceItems.WITHER_ESSENCE,
                            Text.literal("Obtain Wither Essence"),
                            Text.literal("Destroy the Wither"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_wither_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.WITHER_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_wither_essence");

            AdvancementEntry woodlandEssenceAdvancement = Advancement.Builder.create().parent(hostileEssenceAdvancement)
                    .display(
                            EssenceItems.WOODLAND_ESSENCE,
                            Text.literal("Obtain Woodland Essence"),
                            Text.literal("Best an Invoker"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_woodland_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.WOODLAND_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_woodland_essence");

            AdvancementEntry monumentEssenceAdvancement = Advancement.Builder.create().parent(hostileEssenceAdvancement)
                    .display(
                            EssenceItems.MONUMENT_ESSENCE,
                            Text.literal("Obtain Monument Essence"),
                            Text.literal("Fell an Elder Guardian"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_monument_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.MONUMENT_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_monument_essence");

            AdvancementEntry trialEssenceAdvancement = Advancement.Builder.create().parent(hostileEssenceAdvancement)
                    .display(
                            EssenceItems.TRIAL_ESSENCE,
                            Text.literal("Obtain Trial Essence"),
                            Text.literal("Conquer a Trial"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_trial_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.TRIAL_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_trial_essence");

            AdvancementEntry bastionEssenceAdvancement = Advancement.Builder.create().parent(hostileEssenceAdvancement)
                    .display(
                            EssenceItems.WARDEN_ESSENCE,
                            Text.literal("Obtain Bastion Essence"),
                            Text.literal("Explore a Bastion"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_bastion_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.BASTION_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_bastion_essence");

            AdvancementEntry ancientEssenceAdvancement = Advancement.Builder.create().parent(hostileEssenceAdvancement)
                    .display(
                            EssenceItems.ANCIENT_ESSENCE,
                            Text.literal("Obtain Ancient Essence"),
                            Text.literal("Delve into an Ancient City"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_ancient_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.ANCIENT_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_ancient_essence");

            AdvancementEntry raidEssenceAdvancement = Advancement.Builder.create().parent(hostileEssenceAdvancement)
                    .display(
                            EssenceItems.RAID_ESSENCE,
                            Text.literal("Obtain Raid Essence"),
                            Text.literal("Stop the destroyer of villages"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_raid_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.RAID_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_raid_essence");

            AdvancementEntry clericEssenceAdvancement = Advancement.Builder.create().parent(passiveEssenceAdvancement)
                    .display(
                            EssenceItems.WARDEN_ESSENCE,
                            Text.literal("Obtain Cleric Essence"),
                            Text.literal("Fully befriend a Cleric"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_cleric_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.CLERIC_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_cleric_essence");

            AdvancementEntry librarianEssenceAdvancement = Advancement.Builder.create().parent(passiveEssenceAdvancement)
                    .display(
                            EssenceItems.LIBRARIAN_ESSENCE,
                            Text.literal("Obtain Librarian Essence"),
                            Text.literal("Impress a Librarian"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_librarian_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.LIBRARIAN_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_librarian_essence");

            AdvancementEntry trailEssenceAdvancement = Advancement.Builder.create().parent(passiveEssenceAdvancement)
                    .display(
                            EssenceItems.TRAIL_ESSENCE,
                            Text.literal("Obtain Trail Essence"),
                            Text.literal("Sift through suspicious blocks"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_trail_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.TRAIL_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_trail_essence");

            AdvancementEntry buriedEssenceAdvancement = Advancement.Builder.create().parent(passiveEssenceAdvancement)
                    .display(
                            EssenceItems.BURIED_ESSENCE,
                            Text.literal("Obtain Buried Essence"),
                            Text.literal("Follow a Treasure Map"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_buried_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.BURIED_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_buried_essence");

            AdvancementEntry iglooEssenceAdvancement = Advancement.Builder.create().parent(passiveEssenceAdvancement)
                    .display(
                            EssenceItems.IGLOO_ESSENCE,
                            Text.literal("Obtain Igloo Essence"),
                            Text.literal("Find refuge in the snow"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_igloo_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.IGLOO_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_igloo_essence");

            AdvancementEntry colourfulEssenceAdvancement = Advancement.Builder.create().parent(passiveEssenceAdvancement)
                    .display(
                            EssenceItems.COLOURFUL_ESSENCE,
                            Text.literal("Obtain Colorful Essence"),
                            Text.literal("Surround cake in a rainbow of wool"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_colourful_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.COLOURFUL_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_colourful_essence");

            AdvancementEntry luckyEssenceAdvancement = Advancement.Builder.create().parent(passiveEssenceAdvancement)
                    .display(
                            EssenceItems.LUCKY_ESSENCE,
                            Text.literal("Obtain Lucky Essence"),
                            Text.literal("Collect and combine many rare things"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_lucky_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.LUCKY_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_lucky_essence");

            AdvancementEntry saturatingEssenceAdvancement = Advancement.Builder.create().parent(passiveEssenceAdvancement)
                    .display(
                            EssenceItems.SATURATING_ESSENCE,
                            Text.literal("Obtain Saturating Essence"),
                            Text.literal("Collect and combine many exotic foods"),
                            null,
                            AdvancementFrame.GOAL,
                            true,
                            true,
                            false
                    )
                    .criterion("obtained_saturating_essence", InventoryChangedCriterion.Conditions.items(EssenceItems.SATURATING_ESSENCE))
                    .build(consumer, "strongholdessences/obtained_saturating_essence");
        }
    }
}
