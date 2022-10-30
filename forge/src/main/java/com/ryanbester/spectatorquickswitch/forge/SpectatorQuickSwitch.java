package com.ryanbester.spectatorquickswitch.forge;

import com.ryanbester.spectatorquickswitch.SpectatorSwitcher;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.awt.event.KeyEvent;


@Mod("spectatorquickswitch")
public class SpectatorQuickSwitch
{
    public static final KeyMapping spectatorKey = new KeyMapping("spectatorquickswitch.toggle_spectator", KeyEvent.VK_G, "spectatorquickswitch.spectator_category");

    public SpectatorQuickSwitch()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::initClient);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void initClient(final FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(spectatorKey);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (SpectatorQuickSwitch.spectatorKey.isDown()) {
            SpectatorSwitcher.switchGameMode();
        }
    }
}
