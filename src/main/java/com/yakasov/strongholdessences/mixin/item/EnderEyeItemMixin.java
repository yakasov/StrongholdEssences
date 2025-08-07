package com.yakasov.strongholdessences.mixin.item;

import net.minecraft.advancement.AdvancementProgress;
import net.minecraft.advancement.PlayerAdvancementTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnderEyeItem;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnderEyeItem.class)
public class EnderEyeItemMixin {
    @Inject(
            method = "use",
            at = @At("HEAD"),
            cancellable = true
    )
    private void rejectUse(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        MinecraftServer server = user.getServer();

        if (server != null) {
            ServerPlayerEntity serverPlayerEntity = server
                    .getPlayerManager()
                    .getPlayer(user.getUuid());

            if (serverPlayerEntity != null) {
                PlayerAdvancementTracker playerAdvancementTracker = serverPlayerEntity.getAdvancementTracker();
                AdvancementProgress advancementProgress = playerAdvancementTracker.getProgress(
                        server.getAdvancementLoader().get(
                                Identifier.ofVanilla("story/follow_ender_eye")
                        ));

                if (!advancementProgress.isDone()) {
                    cir.cancel();
                }
            }
        }
    }
}
