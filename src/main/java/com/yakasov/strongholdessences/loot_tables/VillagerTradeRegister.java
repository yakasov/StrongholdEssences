package com.yakasov.strongholdessences.loot_tables;

import com.yakasov.strongholdessences.item.EssenceItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class VillagerTradeRegister {
    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 48),
                            new ItemStack(EssenceItems.CLERIC_ESSENCE, 1),
                            1, 10, 1F
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 48),
                            new ItemStack(EssenceItems.LIBRARIAN_ESSENCE, 1),
                            1, 10, 1F
                    ));
                });
    }
}
