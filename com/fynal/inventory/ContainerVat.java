package com.fynal.inventory;

import com.fynal.tile_entity.TileEntityVat;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerVat extends Container{
	
	private TileEntityVat tileVat;
	private int lastProcessTime;
	
	public ContainerVat(InventoryPlayer player, TileEntityVat tileEntityVat){
		this.tileVat = tileEntityVat;
		this.addSlotToContainer(new Slot(tileEntityVat, 0, 53, 26));//input slot
		this.addSlotToContainer(new SlotCoilcraftOutput(tileEntityVat, 1, 107, 26));//output slot
		this.addSlotToContainer(new SlotCoilcraftOutput(tileEntityVat, 2, 80, 53));//liquid slot
		int i = 0;
		for(i = 0; i < 3; ++i){//refers to inventory rows!
			for(int j = 0; j < 9; ++j){
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(i = 0; i < 9; ++i){
			this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
		}
	}
	
	public void addCraftingToCrafters(ICrafting craft){
		super.addCraftingToCrafters(craft);
		craft.sendProgressBarUpdate(this, 0, this.tileVat.vatProcessTime);
	}
	
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for(int i = 0; i <this.crafters.size(); ++i){
			ICrafting craft = (ICrafting) this.crafters.get(i);
			if(this.lastProcessTime != this.tileVat.vatProcessTime){
				craft.sendProgressBarUpdate(this, 0, this.tileVat.vatProcessTime);
			}
		}
		
		this.lastProcessTime = this.tileVat.vatProcessTime;	
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2){
		if(par1 == 0){
			this.tileVat.vatProcessTime = par2;
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.tileVat.isUseableByPlayer(player);
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int par2){
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);
		if(slot != null && slot.getHasStack()){
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if(par2 == 2){
				if(!this.mergeItemStack(itemstack1, 3, 39, true)){
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
			}else if(par2 != 1 && par2 != 0){
				if(par2 >= 3 && par2 < 30){//TODO MAY NEED TO EDIT to make shift-clicking work
					if(this.mergeItemStack(itemstack1, 30, 39, false)){
						return null;
					}
				}else if(par2 >= 30 && par2 < 39 && this.mergeItemStack(itemstack1, 3, 30, false)){
					return null;
				}
			}else if(!this.mergeItemStack(itemstack1, 3, 39, false)){
				return null;
			}
			if(itemstack1.stackSize == 0){
				slot.putStack((ItemStack) null);
			}else{
				slot.onSlotChanged();
			}
			if(itemstack1.stackSize == itemstack.stackSize){
				return null;
			}
			slot.onPickupFromSlot(player, itemstack1);
		}
		return itemstack;
	}
	
}
