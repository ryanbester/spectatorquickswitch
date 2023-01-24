package com.ryanbester.spectatorquickswitch;

import com.google.common.base.MoreObjects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.GameType;

public class SpectatorSwitcher {
    public static void switchGameMode() {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player != null) {
            if (!player.hasPermissions(2)) {
                player.displayClientMessage(Component.translatable("debug.creative_spectator.error"), false);
            } else if (!player.isSpectator()) {
                player.connection.sendUnsignedCommand("gamemode spectator");
            } else {
                if (Minecraft.getInstance().gameMode != null) {
                    GameType gameMode = Minecraft.getInstance().gameMode.getPreviousPlayerMode();
                    player.connection.sendUnsignedCommand("gamemode " + MoreObjects.firstNonNull(gameMode, GameType.CREATIVE).getName());
                }
            }
        }
    }
}
