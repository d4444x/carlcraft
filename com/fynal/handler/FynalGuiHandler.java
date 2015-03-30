package com.fynal.handler;

import com.fynal.gui.GUIFluxFurnace;
import com.fynal.gui.GUIVat;
import com.fynal.inventory.ContainerFluxFurnace;
import com.fynal.inventory.ContainerVat;
import com.fynal.tile_entity.TileEntityFluxFurnace;
import com.fynal.tile_entity.TileEntityVat;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class FynalGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if(ID == 0){//inactive flux furnace has ID 0
			TileEntityFluxFurnace fluxfurnace = (TileEntityFluxFurnace) world.getTileEntity(x, y, z);
			return new ContainerFluxFurnace(player.inventory, fluxfurnace);
		}
		if(ID == 1){//vat has ID 1
			TileEntityVat vat = (TileEntityVat) world.getTileEntity(x, y, z);
			return new ContainerVat(player.inventory, vat);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if(ID == 0){
			TileEntityFluxFurnace fluxfurnace = (TileEntityFluxFurnace) world.getTileEntity(x, y, z);
			return new GUIFluxFurnace(player.inventory, fluxfurnace);
		}
		if(ID == 1){
			TileEntityVat vat = (TileEntityVat) world.getTileEntity(x, y, z);
			return new GUIVat(player.inventory, vat);
		}
		return null;
	}

}
