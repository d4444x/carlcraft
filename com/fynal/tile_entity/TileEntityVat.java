package com.fynal.tile_entity;

import com.fynal.block.Vat;
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
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;


public class TileEntityVat extends TileEntity implements ISidedInventory{

	private static final int[] slotsTop = new int[]{0};
	private static final int[] slotsBottom = new int[]{2, 1};
	private static final int[] slotsSides = new int[]{1};
	
	private ItemStack[] vatItemStacks = new ItemStack[3]; //3 slots, 1 for liquid
	//0 is input slot
	//1 is output slot
	//2 is liquid "slot"
	public int vatProcessTime;
	private String vatName;
	
	public void vatName(String string){
		this.vatName = string;
	}
	
	@Override
	public int getSizeInventory() {
		return this.vatItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int par1) {
		return this.vatItemStacks[par1];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if(this.vatItemStacks[par1] != null){
			ItemStack itemstack;
			if(this.vatItemStacks[par1].stackSize <= par2){ //if theres 64 on the right already, don't smelt
				itemstack = this.vatItemStacks[par1];
				this.vatItemStacks[par1] = null;
				return itemstack;
			}else{
				itemstack = this.vatItemStacks[par1].splitStack(par2);
				
				if(this.vatItemStacks[par1].stackSize == 0){
					this.vatItemStacks[par1] = null;
				}
				return itemstack;
			}
		}else{
		return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		if(this.vatItemStacks[par1] != null){
			ItemStack itemstack = this.vatItemStacks[par1];
			this.vatItemStacks[par1] = null;
			return itemstack;
		}else{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack itemstack) {
		this.vatItemStacks[par1] = itemstack;
		
		if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()){
			itemstack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.vatName : "Vat";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.vatName != null && this.vatName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	public void readFromNBT(NBTTagCompound tagCompound){
		super.readFromNBT(tagCompound);
		NBTTagList tagList = tagCompound.getTagList("Items", 10);
		this.vatItemStacks = new ItemStack[this.getSizeInventory()];
		
		for(int i = 0; i < tagList.tagCount(); ++i){
			NBTTagCompound tagCompound1 = tagList.getCompoundTagAt(i);
			byte byte0 = tagCompound1.getByte("Slot");
			
			if(byte0 >= 0 && byte0 < this.vatItemStacks.length){
				this.vatItemStacks[byte0] = ItemStack.loadItemStackFromNBT(tagCompound1);
			}
		}
		
		this.vatProcessTime = tagCompound.getShort("ProcessTime");
		
		if(tagCompound.hasKey("CustomName", 8)){
			this.vatName = tagCompound.getString("CustomName");
		}
	}
	
	public void writeToNBT(NBTTagCompound tagCompound){
		super.writeToNBT(tagCompound);
		
		tagCompound.setShort("ProcessTime", (short) this.vatProcessTime);
		NBTTagList tagList = new NBTTagList();
		
		for(int i = 0; i < this.vatItemStacks.length; ++i){
			if(this.vatItemStacks[i] != null){
				NBTTagCompound tagCompound1 = new NBTTagCompound();
				tagCompound1.setByte("Slot", (byte) i);
				this.vatItemStacks[i].writeToNBT(tagCompound1);
				tagList.appendTag(tagCompound1);
			}
		}
		
		tagCompound.setTag("Items", tagList);
		
		if(this.hasCustomInventoryName()){
			tagCompound.setString("CustomName", this.vatName);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public int getProcessProgressScaled(int par1){
		return this.vatProcessTime * par1 / 600;//TODO MAKE THIS 600?
	}
	
	public boolean isProcessing(){
		return this.vatProcessTime > 0;
	}
	
	public void updateEntity(){
		boolean flag1 = false;
		if(!this.worldObj.isRemote){		
			if(this.canProcess()){
				++this.vatProcessTime;
				if(this.vatProcessTime == 600){//TODO MAKE THIS 600?
					this.vatProcessTime = 0;
					this.processItem();
					flag1 = true;
				}
				if(vatItemStacks[0] != null){
					Item i = this.vatItemStacks[0].getItem();
					if(i == ModItems.wood_bucket_water || i == ModItems.wood_bucket_milk || i == ModItems.steel_bucket_water || i == ModItems.steel_bucket_milk){
						this.vatProcessTime = 0;//adding liquid from a bucket is instant
						this.processItem();
						flag1 = true;
					}
				}
			}else{
				this.vatProcessTime = 0;
			}
		}
		
		if(flag1){
			this.markDirty();
		}
	}
	
	private boolean canProcess(){
		if(this.vatItemStacks[0] == null){
			return false;
		}else{
			ItemStack itemstack = getProcessingResult(vatItemStacks[0]);
			if(itemstack == null){
				return false;
			}
			if(this.vatItemStacks[1] == null){
				return true;
			}
			if(!this.vatItemStacks[1].isItemEqual(itemstack)){
				return false;
			}
			int result = vatItemStacks[1].stackSize + itemstack.stackSize;
			return result <= getInventoryStackLimit() && result <= this.vatItemStacks[1].getMaxStackSize();
		}
	}
	
	public void processItem(){
		if(this.canProcess()){
			ItemStack itemstack = getProcessingResult(this.vatItemStacks[0]);
			
			if(this.vatItemStacks[1] == null){
				this.vatItemStacks[1] = itemstack.copy();
			}else if(this.vatItemStacks[1].getItem() == itemstack.getItem()){
				this.vatItemStacks[1].stackSize += itemstack.stackSize;
				if(this.vatItemStacks[1].stackSize > 64){
					vatItemStacks[1].stackSize = 64;//makes sure that screwing around won't overload stack size
				}
			}
			
			this.vatItemStacks[2] = null;
			
			if(this.vatItemStacks[1].getItem() == ModItems.vat_water){
				this.vatItemStacks[1] = null;
				this.vatItemStacks[2] = new ItemStack(ModItems.vat_water, 1, 0);
			}else if(this.vatItemStacks[1].getItem() == ModItems.vat_milk){
				this.vatItemStacks[1] = null;
				this.vatItemStacks[2] = new ItemStack(ModItems.vat_milk, 1, 0);
			}else if(this.vatItemStacks[1].getItem() == ModItems.vat_tannin){
				this.vatItemStacks[1] = null;
				this.vatItemStacks[2] = new ItemStack(ModItems.vat_tannin, 1, 0);
			}
			
			Item maybebucket = this.vatItemStacks[0].getItem();
			if(maybebucket == ModItems.wood_bucket_water || maybebucket == ModItems.wood_bucket_milk){
				this.vatItemStacks[0] = new ItemStack(ModItems.wood_bucket, 1);
			}else if(maybebucket == ModItems.steel_bucket_water || maybebucket == ModItems.steel_bucket_milk){
				this.vatItemStacks[0] = new ItemStack(ModItems.steel_bucket, 1);
			}else if(Block.getBlockFromItem(maybebucket) == Blocks.log){
				--this.vatItemStacks[0].stackSize;
				if(this.vatItemStacks[0].stackSize <= 0) this.vatItemStacks[0] = null;
			}else this.vatItemStacks[0] = null;
		}
	}
	
	public ItemStack getProcessingResult(ItemStack input){
		ItemStack result = null;
		Item inputitem = input.getItem();
		Item outputitem = null;
		Item vatliquid = null;
		if(vatItemStacks[2] != null) vatliquid = vatItemStacks[2].getItem();

		if(inputitem instanceof ItemBlock && Block.getBlockFromItem(inputitem) != Blocks.air){
			Block inputblock = Block.getBlockFromItem(inputitem);
			ItemStack oaktest = new ItemStack(Blocks.log, 1, 0);
			ItemStack oaktest2 = new ItemStack(inputblock, 1, 0);//TODO make only OAK logs produce tannin
			if(inputblock == Blocks.log && vatliquid == ModItems.vat_water) outputitem = ModItems.vat_tannin;
		}
		
		if(inputitem == ModItems.ashes && vatliquid == ModItems.vat_water) outputitem = ModItems.potash;
		if(inputitem == ModItems.hide && vatliquid == ModItems.vat_tannin) outputitem = Items.leather;
		if((inputitem == ModItems.wood_bucket_water || inputitem == ModItems.steel_bucket_water) && vatliquid == null) outputitem = ModItems.vat_water;
		if((inputitem == ModItems.wood_bucket_milk || inputitem == ModItems.steel_bucket_milk) && vatliquid == null) outputitem = ModItems.vat_milk;
		
		if(outputitem != null){
			result = new ItemStack(outputitem, input.stackSize, 0);
		}
		return result;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {
		
	}

	@Override
	public void closeInventory() {
		
	}

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack itemstack) {
		return par1 == 1 ? false : true;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int par1) {
		return par1 == 0 ? slotsSides : slotsTop;
	}

	@Override
	public boolean canInsertItem(int par1, ItemStack itemstack, int par3) {
		return this.isItemValidForSlot(par1, itemstack);
	}

	@Override
	public boolean canExtractItem(int par1, ItemStack itemstack, int par3) {
		return par3 != 0 || par1 != 1 || itemstack.getItem() == ModItems.wood_bucket || itemstack.getItem() == ModItems.steel_bucket;
	}

}
