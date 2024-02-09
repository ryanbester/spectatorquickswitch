package com.ryanbester.spectatorquickswitch.quilt;

import com.ryanbester.spectatorquickswitch.fabriclike.SpectatorQuickSwitchFabricLike;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class SpectatorQuickSwitch implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        SpectatorQuickSwitchFabricLike.init();
    }
}
