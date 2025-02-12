package com.bunny.eschatAddons.features;

import com.bunny.eschatAddons.GUI.GuiEschat;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class KeybindHandler {
    public KeybindHandler() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (Keyboard.isKeyDown(Keyboard.KEY_EQUALS)) {
            System.out.println("Keybind pressed! Opening GUI...");
            Minecraft.getMinecraft().displayGuiScreen(new GuiEschat());
        }
    }
}
