package com.yakasov.strongholdessences;

import com.yakasov.strongholdessences.item.EssenceGroups;
import com.yakasov.strongholdessences.item.EssenceItems;
import com.yakasov.strongholdessences.loot_tables.LootTableModifier;
import com.yakasov.strongholdessences.loot_tables.VillagerTradeRegister;
import net.fabricmc.api.ModInitializer;

public class StrongholdEssences implements ModInitializer {

    @Override
    public void onInitialize() {
        EssenceItems.initialize();
        EssenceGroups.initialize();
        LootTableModifier.modifyLootTables();
        VillagerTradeRegister.registerTrades();
    }
}
