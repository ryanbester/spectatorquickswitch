package com.ryanbester.spectatorquickswitch.forge;

import com.ryanbester.spectatorquickswitch.SpectatorSwitcher;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.awt.event.KeyEvent;


@Mod("spectatorquickswitch")
public class SpectatorQuickSwitch {
    public static final KeyMapping spectatorKey = new KeyMapping("spectatorquickswitch.toggle_spectator", KeyEvent.VK_G, "spectatorquickswitch.spectator_category");

    public SpectatorQuickSwitch() {
        MinecraftForge.EVENT_BUS.register(this);

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> (DistExecutor.SafeRunnable) () -> modEventBus.addListener(SpectatorQuickSwitch.this::registerKeys));
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.Key event) {
        if (SpectatorQuickSwitch.spectatorKey.isDown()) {
            SpectatorSwitcher.switchGameMode();
        }
    }

    @SubscribeEvent
    public void registerKeys(RegisterKeyMappingsEvent event) {
        event.register(spectatorKey);
    }
}
