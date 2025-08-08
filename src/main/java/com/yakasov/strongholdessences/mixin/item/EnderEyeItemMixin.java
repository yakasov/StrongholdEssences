package com.yakasov.strongholdessences.mixin.item;

import net.minecraft.advancement.AdvancementProgress;
import net.minecraft.advancement.PlayerAdvancementTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnderEyeItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnderEyeItem.class)
public class EnderEyeItemMixin {
    @Unique
    private boolean missingAdvancement(PlayerEntity user, Identifier advancementIdentifier) {
        MinecraftServer server = user.getServer();

        if (server != null) {
            ServerPlayerEntity serverPlayerEntity = server
                    .getPlayerManager()
                    .getPlayer(user.getUuid());

            if (serverPlayerEntity != null) {
                PlayerAdvancementTracker playerAdvancementTracker = serverPlayerEntity.getAdvancementTracker();
                AdvancementProgress advancementProgress = playerAdvancementTracker.getProgress(
                        server.getAdvancementLoader().get(
                                advancementIdentifier
                        ));

                return !advancementProgress.isDone();
            }
        }

        return true;
    }

    @Inject(
            method = "use",
            at = @At("HEAD"),
            cancellable = true
    )
    private void rejectUse(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        if (missingAdvancement(user, Identifier.ofVanilla("story/follow_ender_eye"))) {
            cir.cancel();
        }
    }

    @Inject(
            method = "useOnBlock",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/BlockState;with(Lnet/minecraft/state/property/Property;Ljava/lang/Comparable;)Ljava/lang/Object;"
            ),
            cancellable = true
    )
    private void rejectUseOnBlockIfNoCompass(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        if (context.getPlayer() != null &&
                missingAdvancement(context.getPlayer(), Identifier.of("strongholdessences/obtained_stronghold_compass"))
        ) {
            context.getPlayer().sendMessage(Text.of("You do not have a Stronghold Compass yet!"), true);
            cir.setReturnValue(ActionResult.PASS);
        }
    }
}
