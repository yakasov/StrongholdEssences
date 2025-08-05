package com.yakasov.strongholdessences.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DamageResistantComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.spongepowered.include.com.google.common.base.Function;

public class EssenceItems {
    public static final Item.Settings BASE_SETTINGS = new Item.Settings()
            .rarity(Rarity.UNCOMMON)
            .fireproof()
            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
            .component(DataComponentTypes.DAMAGE_RESISTANT, new DamageResistantComponent(DamageTypeTags.IS_EXPLOSION));
    public static Item essenceRegister(String name) {
        return register(name, settings -> settings != null ? new Item(settings) : null, BASE_SETTINGS);
    }

    public static final Item WARDEN_ESSENCE = essenceRegister("warden_essence");
    public static final Item WITHER_ESSENCE = essenceRegister("wither_essence");
    public static final Item WOODLAND_ESSENCE = essenceRegister("woodland_essence");
    public static final Item MONUMENT_ESSENCE = essenceRegister("monument_essence");
    public static final Item TRIAL_ESSENCE = essenceRegister("trial_essence");
    public static final Item BASTION_ESSENCE = essenceRegister("bastion_essence");
    public static final Item ANCIENT_ESSENCE = essenceRegister("ancient_essence");
    public static final Item RAID_ESSENCE = essenceRegister("raid_essence");

    public static final Item CLERIC_ESSENCE = essenceRegister("cleric_essence");
    public static final Item LIBRARIAN_ESSENCE = essenceRegister("librarian_essence");
    public static final Item TRAIL_ESSENCE = essenceRegister("trail_essence");
    public static final Item BURIED_ESSENCE = essenceRegister("buried_essence");
    public static final Item IGLOO_ESSENCE = essenceRegister("igloo_essence");
    public static final Item COLOURFUL_ESSENCE = essenceRegister("colourful_essence");
    public static final Item LUCKY_ESSENCE = essenceRegister("lucky_essence");
    public static final Item SATURATING_ESSENCE = essenceRegister("saturating_essence");

    public static final Item HOSTILE_ESSENCE = register("hostile_essence", settings -> settings != null ? new Item(settings) : null, BASE_SETTINGS.rarity(Rarity.RARE));
    public static final Item PASSIVE_ESSENCE = register("passive_essence", settings -> settings != null ? new Item(settings) : null, BASE_SETTINGS.rarity(Rarity.RARE));
    public static final Item STRONGHOLD_COMPASS = register("stronghold_compass", settings -> settings != null ? new StrongholdCompassItem(settings) : null, BASE_SETTINGS.rarity(Rarity.EPIC));

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("strongholdessences", name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    public static void initialize() {
    }
}
