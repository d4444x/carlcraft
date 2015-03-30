package com.fynal.tile_entity;

import com.fynal.block.Bellows;
import com.fynal.block.ModBlocks;
import com.fynal.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBellows extends TileEntity{

	public int cooldownTime;
	public int direction;//equal to metadata

	public void readFromNBT(NBTTagCompound tagCompound){
		super.readFromNBT(tagCompound);
		this.cooldownTime = tagCompound.getShort("cooldown");
		this.direction = tagCompound.getShort("direction");
	}
	
	public void writeToNBT(NBTTagCompound tagCompound){
		super.writeToNBT(tagCompound);
		tagCompound.setShort("cooldown", (short) this.cooldownTime);
		tagCompound.setShort("direction", (short) this.direction);
	}
	
	@SideOnly(Side.CLIENT)
	public int getCooldownScaled(int par1){
		return this.cooldownTime * par1 / 200;
	}//TODO maybe this will be useful
	
	public boolean isCooldown(){
		return this.cooldownTime > 0;
	}
		
	public void updateEntity(){
		if(this.cooldownTime > 0){
			--this.cooldownTime;
		}
	}
	
	public boolean canInteractWith(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
	}
	
	public boolean isUsableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
	}
}