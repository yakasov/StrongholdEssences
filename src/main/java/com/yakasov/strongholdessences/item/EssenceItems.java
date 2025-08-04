package com.yakasov.strongholdessences.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.spongepowered.include.com.google.common.base.Function;

public class EssenceItems {
    public static final Item WARDEN_ESSENCE = register("warden_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item WITHER_ESSENCE = register("wither_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item WOODLAND_ESSENCE = register("woodland_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item MONUMENT_ESSENCE = register("monument_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item TRIAL_ESSENCE = register("trial_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item BASTION_ESSENCE = register("bastion_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item ANCIENT_ESSENCE = register("ancient_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item RAID_ESSENCE = register("raid_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.UNCOMMON));

    public static final Item CLERIC_ESSENCE = register("cleric_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item LIBRARIAN_ESSENCE = register("librarian_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item TRAIL_ESSENCE = register("trail_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item BURIED_ESSENCE = register("buried_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item IGLOO_ESSENCE = register("igloo_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item COLOURFUL_ESSENCE = register("colourful_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item LUCKY_ESSENCE = register("lucky_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item SATURATING_ESSENCE = register("saturating_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.UNCOMMON));

    public static final Item HOSTILE_ESSENCE = register("hostile_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.RARE));
    public static final Item PASSIVE_ESSENCE = register("passive_essence", settings -> settings != null ? new Item(settings) : null, new Item.Settings().rarity(Rarity.RARE));
    public static final Item STRONGHOLD_COMPASS = register("stronghold_compass", settings -> settings != null ? new StrongholdCompassItem(settings) : null, new Item.Settings().rarity(Rarity.EPIC));

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("strongholdessences", name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    public static void initialize() {
    }
}
