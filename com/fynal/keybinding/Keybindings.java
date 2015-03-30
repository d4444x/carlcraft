package com.fynal.keybinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class Keybindings {
	public static KeyBinding Reload;

    public static void initialize() {
    	Reload = new KeyBinding("key.reload", Keyboard.KEY_R, "key.categories.coilcraft");//82 is code for R

        ClientRegistry.registerKeyBinding(Reload);
    }
}