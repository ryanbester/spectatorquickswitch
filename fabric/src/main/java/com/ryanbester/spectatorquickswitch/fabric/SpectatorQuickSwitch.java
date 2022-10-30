package com.ryanbester.spectatorquickswitch.fabric;

import com.ryanbester.spectatorquickswitch.SpectatorSwitcher;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.KeyEvent;

public class SpectatorQuickSwitch implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("spectatorquickswitch");

    public static KeyMapping spectatorKey;

    @Override
    public void onInitializeClient() {
        spectatorKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "spectatorquickswitch.toggle_spectator",
                KeyEvent.VK_G,
                "spectatorquickswitch.spectator_category"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (spectatorKey.consumeClick()) {
                SpectatorSwitcher.switchGameMode();
            }
        });
    }
}
