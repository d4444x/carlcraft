package com.fynal.Main;

import com.fynal.handler.FynalGuiHandler;
import com.fynal.keybinding.Coilcraft_Input;
import com.fynal.keybinding.Keybindings;
import com.fynal.lib.Ref;
import com.fynal.tile_entity.TileEntityBellows;
import com.fynal.tile_entity.TileEntityFluxFurnace;
import com.fynal.tile_entity.TileEntityVat;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy {

	public void registerRenderInfo(){
		
	}
	
	public void registerKeybindings(){
	}
	
	public int addArmor(String armor){
		return 0;
	}
	
	public void registerNetworkStuff(){
		NetworkRegistry.INSTANCE.registerGuiHandler(MainRegistry.modInstance, new FynalGuiHandler());		
	}
	
	public void registerTileEntities(){
		GameRegistry.registerTileEntity(TileEntityFluxFurnace.class, Ref.MODID + "TileEntityFluxFurnace");
		GameRegistry.registerTileEntity(TileEntityVat.class, Ref.MODID + "TileEntityVat");
		GameRegistry.registerTileEntity(TileEntityBellows.class, Ref.MODID + "TileEntityBellows");
	}
}
