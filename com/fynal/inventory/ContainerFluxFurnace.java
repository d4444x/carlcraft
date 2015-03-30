package com.fynal.inventory;

import com.fynal.item.ModItems;
import com.fynal.tile_entity.TileEntityFluxFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class ContainerFluxFurnace extends Container{
	
	private TileEntityFluxFurnace tileFurnace;
	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;
	private int lastBellowsHeatTime;
	private boolean lastFuelHeat;
	
	public ContainerFluxFurnace(InventoryPlayer player, TileEntityFluxFurnace tileEntityFurnace){
		this.tileFurnace = tileEntityFurnace;
		this.addSlotToContainer(new Slot(tileEntityFurnace, 0, 56, 17));//ore slot
		this.addSlotToContainer(new Slot(tileEntityFurnace, 1, 56, 53));//fuel slot
		this.addSlotToContainer(new Slot(tileEntityFurnace, 3, 31, 17));//flux slot
		this.addSlotToContainer(new SlotCoilcraftOutput(tileEntityFurnace, 4, 31, 53));//ash slot
		this.addSlotToContainer(new SlotFurnace(player.player, tileEntityFurnace, 2, 116, 35));//output slot
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
		craft.sendProgressBarUpdate(this, 0, this.tileFurnace.furnaceCookTime);
		craft.sendProgressBarUpdate(this, 1, this.tileFurnace.furnaceBurnTime);
		craft.sendProgressBarUpdate(this, 2, this.tileFurnace.currentItemBurnTime);
		craft.sendProgressBarUpdate(this, 3, this.tileFurnace.bellowsHeatTime);
		craft.sendProgressBarUpdate(this, 4, this.tileFurnace.doesItemBurnHot(this.tileFurnace.getStackInSlot(5)) ? 1 : 0);
	}
	
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for(int i = 0; i <this.crafters.size(); ++i){
			ICrafting craft = (ICrafting) this.crafters.get(i);
			if(this.lastCookTime != this.tileFurnace.furnaceCookTime){
				craft.sendProgressBarUpdate(this, 0, this.tileFurnace.furnaceCookTime);
			}
			if(this.lastBurnTime != this.tileFurnace.furnaceBurnTime){
				craft.sendProgressBarUpdate(this, 1, this.tileFurnace.furnaceBurnTime);
			}
			if(this.lastItemBurnTime != this.tileFurnace.currentItemBurnTime){
				craft.sendProgressBarUpdate(this, 2, this.tileFurnace.currentItemBurnTime);
			}
			if(this.lastBellowsHeatTime != this.tileFurnace.bellowsHeatTime){
				craft.sendProgressBarUpdate(this, 3, this.tileFurnace.bellowsHeatTime);
			}
			if(this.lastFuelHeat != this.tileFurnace.isHotFromFuel()){
				craft.sendProgressBarUpdate(this, 4, this.tileFurnace.doesItemBurnHot(this.tileFurnace.getStackInSlot(5)) ? 1 : 0);
			}
		}
		
		this.lastBurnTime = this.tileFurnace.furnaceBurnTime;
		this.lastCookTime = this.tileFurnace.furnaceCookTime;
		this.lastItemBurnTime = this.tileFurnace.currentItemBurnTime;	
		this.lastBellowsHeatTime = this.tileFurnace.bellowsHeatTime;
		this.lastFuelHeat = this.tileFurnace.isHotFromFuel();
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2){
		if(par1 == 0){
			this.tileFurnace.furnaceCookTime = par2;
		}
		if(par1 == 1){
			this.tileFurnace.furnaceBurnTime = par2;
		}
		if(par1 == 2){
			this.tileFurnace.currentItemBurnTime = par2;
		}
		if(par1 == 3){
			this.tileFurnace.bellowsHeatTime = par2;
		}
		if(par1 == 4){
			this.tileFurnace.setBurnedFuel(par2);
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.tileFurnace.isUseableByPlayer(player);
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int par2)
	{
		int offset = 2;
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);
		if(slot != null && slot.getHasStack()){
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if(par2 == 2)
			{
				if(!this.mergeItemStack(itemstack1, 3+offset, 39+offset, true))
				{
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
			}
			else if(par2 != 1 && par2 != 0 && par2 != 3 && par2 != 4)//added !=3, !=4
			{
				if(this.tileFurnace.getFynalSmeltingResult(itemstack1) != null)
				{
					if(!this.mergeItemStack(itemstack1, 0, 1, false))
					{
						return null;
					}
				}else if(TileEntityFluxFurnace.isItemFuel(itemstack1))
				{
					if(!this.mergeItemStack(itemstack1, 1, 2, false))
					{
						return null;
					}
				}else if(TileEntityFluxFurnace.isItemFlux(itemstack1))
				{
					if(!this.mergeItemStack(itemstack1, 2, 3, false))
					{
						return null;
					}
				}else if(par2 >= 3+offset && par2 < 30+offset){
					if(!this.mergeItemStack(itemstack1, 30+offset, 39+offset, false))
					{
						return null;
					}
				}else if(par2 >= 30+offset && par2 < 39+offset && !this.mergeItemStack(itemstack1, 3+offset, 30+offset, false))
				{
					return null;
				}
			}
			else if(!this.mergeItemStack(itemstack1, 3+offset, 39+offset, false))
			{
				return null;
			}
			
			if(itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack)null);
			}
			else
			{
				slot.onSlotChanged();
			}
			
			if(itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}
			
			slot.onPickupFromSlot(player, itemstack1);
		}
		
		return itemstack;
	}
}