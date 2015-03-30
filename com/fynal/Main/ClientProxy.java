package com.fynal.Main;

import com.fynal.entity.EntityBullet;
import com.fynal.entity.RenderBullet;
import com.fynal.keybinding.Coilcraft_Input;
import com.fynal.keybinding.Keybindings;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends ServerProxy{
	
	public void registerRenderInfo(){
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
	}
	
	public void registerKeybindings(){
		FMLCommonHandler.instance().bus().register(new Coilcraft_Input());
		Keybindings.initialize();
	}
	
	public int addArmor(String armor){
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}

}
