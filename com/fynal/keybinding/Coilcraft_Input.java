package com.fynal.keybinding;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class Coilcraft_Input {
		
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if(Keybindings.Reload.isPressed()){
			//you must send packets to get something server-side to happen
			//printing "MURICA" from here worked
		}
	}
}
