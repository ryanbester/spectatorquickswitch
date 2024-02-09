package com.ryanbester.spectatorquickswitch.fabric;

import com.ryanbester.spectatorquickswitch.fabriclike.SpectatorQuickSwitchFabricLike;
import net.fabricmc.api.ClientModInitializer;

public class SpectatorQuickSwitch implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        SpectatorQuickSwitchFabricLike.init();
    }
}
