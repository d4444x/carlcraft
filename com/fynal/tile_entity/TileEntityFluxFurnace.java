package com.fynal.tile_entity;

import com.fynal.block.FluxFurnace;
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
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFluxFurnace extends TileEntity implements ISidedInventory{

	private static final int[] slotsTop = new int[]{0};
	private static final int[] slotsBottom = new int[]{2, 1};
	private static final int[] slotsSides = new int[]{1};
	
	private ItemStack[] furnaceItemStacks = new ItemStack[6]; //5 slots
	//0 is ore slot
	//1 is fuel slot
	//2 is output slot
	//3 is flux slot
	//4 is ash slot
	//5 stores the last burned piece of fuel
	public int furnaceBurnTime;
	public int currentItemBurnTime;
	public int furnaceCookTime;
	public int bellowsHeatTime;
	private String furnaceName;

	public void furnaceName(String string){
		this.furnaceName = string;
	}
	
	@Override
	public int getSizeInventory() {
		return this.furnaceItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int par1) {
		return this.furnaceItemStacks[par1];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if(this.furnaceItemStacks[par1] != null){
			ItemStack itemstack;
			if(this.furnaceItemStacks[par1].stackSize <= par2){ //if theres 64 on the right already, don't smelt
				itemstack = this.furnaceItemStacks[par1];
				this.furnaceItemStacks[par1] = null;
				return itemstack;
			}else{
				itemstack = this.furnaceItemStacks[par1].splitStack(par2);
				
				if(this.furnaceItemStacks[par1].stackSize == 0){
					this.furnaceItemStacks[par1] = null;
				}
				return itemstack;
			}
		}else{
		return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		if(this.furnaceItemStacks[par1] != null){
			ItemStack itemstack = this.furnaceItemStacks[par1];
			this.furnaceItemStacks[par1] = null;
			return itemstack;
		}else{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack itemstack) {
		this.furnaceItemStacks[par1] = itemstack;
		
		if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()){
			itemstack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.furnaceName : "Flux Furnace";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.furnaceName != null && this.furnaceName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	public void readFromNBT(NBTTagCompound tagCompound){
		super.readFromNBT(tagCompound);
		NBTTagList tagList = tagCompound.getTagList("Items", 10);
		this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];
		
		for(int i = 0; i < tagList.tagCount(); ++i){
			NBTTagCompound tagCompound1 = tagList.getCompoundTagAt(i);
			byte byte0 = tagCompound1.getByte("Slot");
			
			if(byte0 >= 0 && byte0 < this.furnaceItemStacks.length){
				this.furnaceItemStacks[byte0] = ItemStack.loadItemStackFromNBT(tagCompound1);
			}
		}
		
		this.furnaceBurnTime = tagCompound.getShort("BurnTime");
		this.furnaceCookTime = tagCompound.getShort("CookTime");
		this.bellowsHeatTime = tagCompound.getShort("BellowsTime");
		if(this.furnaceItemStacks[5] != null){
		this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[5]);
		}
		else this.currentItemBurnTime = 0;
		
		if(tagCompound.hasKey("CustomName", 8)){
			this.furnaceName = tagCompound.getString("CustomName");
		}
	}
	
	public void writeToNBT(NBTTagCompound tagCompound){
		super.writeToNBT(tagCompound);
		
		tagCompound.setShort("BurnTime", (short) this.furnaceBurnTime);
		tagCompound.setShort("CookTime", (short) this.furnaceCookTime);
		tagCompound.setShort("BellowsTime", (short) this.bellowsHeatTime);
		NBTTagList tagList = new NBTTagList();
		
		for(int i = 0; i < this.furnaceItemStacks.length; ++i){
			if(this.furnaceItemStacks[i] != null){
				NBTTagCompound tagCompound1 = new NBTTagCompound();
				tagCompound1.setByte("Slot", (byte) i);
				this.furnaceItemStacks[i].writeToNBT(tagCompound1);
				tagList.appendTag(tagCompound1);
			}
		}
		
		tagCompound.setTag("Items", tagList);
		
		if(this.hasCustomInventoryName()){
			tagCompound.setString("CustomName", this.furnaceName);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int par1){
		return this.furnaceCookTime * par1 / 200;
	}
	
	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int par1){
		if(this.currentItemBurnTime == 0){//protects vs divide by 0 error
			this.currentItemBurnTime = 200;
		}
		return this.furnaceBurnTime * par1 / this.currentItemBurnTime;
	}
	
	public boolean isBurning(){
		return this.furnaceBurnTime > 0;
	}
	
	public boolean isHotFromBellows(){
		return this.bellowsHeatTime > 0;
	}
	
	public void setBurnedFuel(int fuel){//0 means no fuel or normal fuel. 1 means hot fuel.
		if(fuel == 0) this.furnaceItemStacks[5] = null;
		if(fuel == 1) this.furnaceItemStacks[5] = new ItemStack(ModItems.Coke,1,0);
	}//TODO this may need to be updated if you ever implement more hot fuels
	
	public boolean doesItemBurnHot(ItemStack itemstack){
		Item item = null;
		if(itemstack != null) item = itemstack.getItem();
		if(item == ModItems.Coke)
		{
			return true;
		}
		else return false;
	}
	
	public boolean isHotFromFuel(){
		return doesItemBurnHot(this.furnaceItemStacks[5]);
	}
	
	public void setBellowsHeatTime(int time){
		this.bellowsHeatTime = time;
	}
	
	public int getFurnaceHeat(){//returns 1 normally, 2 if (bellows XOR hot fuel), 4 if (bellows AND hot fuel)
		int result = 1;//if the furnace isn't burning, this function considers what fuel is in the fuel slot
		if(this.isBurning() && this.isHotFromFuel())
		{
			result++; //if it's burning, check if the burned fuel is hot
		}
		if((!this.isBurning()) && this.furnaceItemStacks[1] != null && this.furnaceItemStacks[1].getItem() == ModItems.Coke)
		{
			result++; //if it's not burning, check if the fuel in the fuel slot will burn hot
		}
		if(this.isHotFromBellows()){
			result++;
		}
		if(result==3)
		{
			result++;
		}
		return result;
	}
	
	public void updateEntity(){
		boolean flagIsBurning = this.furnaceBurnTime > 0;
		boolean flag1 = false;
		
		if(this.bellowsHeatTime > 0){
			--this.bellowsHeatTime;
		}
		
		if(this.furnaceBurnTime > 0){
			this.furnaceBurnTime -= this.getFurnaceHeat();
			
			if(this.furnaceBurnTime <= 0){//generate ash and reset fuel heat when fuel burns out
				this.furnaceItemStacks[5] = null;//item is no longer being burned
				if(this.furnaceItemStacks[4] == null){
					furnaceItemStacks[4] = new ItemStack(ModItems.ashes,1,0);
				}else if(this.furnaceItemStacks[4].getItem() != ModItems.ashes){
					furnaceItemStacks[4] = new ItemStack(ModItems.ashes,1,0);
				}else if(this.furnaceItemStacks[4].stackSize < 64){
					++this.furnaceItemStacks[4].stackSize;
				}
			}
		}
		
		if(!this.worldObj.isRemote){
			if(this.furnaceBurnTime <= 0 && this.canSmelt()){
				this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
				this.furnaceItemStacks[5] = this.furnaceItemStacks[1];
				if(this.furnaceBurnTime > 0){
					flag1 = true;
					if(this.furnaceItemStacks[1] != null){
						--this.furnaceItemStacks[1].stackSize;
						
						if(this.furnaceItemStacks[1].stackSize == 0){
							this.furnaceItemStacks[1] = furnaceItemStacks[1].getItem().getContainerItem(this.furnaceItemStacks[1]);
						}
					}
				}
			}
			
			if(this.isBurning() && this.canSmelt()){
				this.furnaceCookTime += (this.getFurnaceHeat() / this.getHeatRequiredToSmelt(furnaceItemStacks[0]));
				if(this.furnaceCookTime >= 200){
					this.furnaceCookTime = 0;
					this.smeltItem();
					flag1 = true;
				}
			}else{
				this.furnaceCookTime = 0;
			}
		}
		
		if(flagIsBurning != this.furnaceBurnTime > 0){
			flag1 = true;
			FluxFurnace.updateBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		}
		
		if(flag1){
			this.markDirty();
		}
	}
	
	public int getHeatRequiredToSmelt(ItemStack itemstack){
		Item item = itemstack.getItem();
		if(item == ModItems.u_brass_z_ingot || item == ModItems.u_brass_zz_ingot || 
		item == ModItems.u_bronze_t_ingot || item == ModItems.u_bronze_tt_ingot || item == ModItems.u_bronze_tz_ingot)
		{
			return 2;
		}else
		if(item == ModItems.u_steel_c_ingot || item == ModItems.u_steel_cc_ingot ||
		item == ModItems.u_steel_n_ingot || item == ModItems.u_steel_nn_ingot ||
		item == ModItems.u_steel_b_ingot || item == ModItems.u_steel_bb_ingot ||
		item == ModItems.u_steel_t_ingot || item == ModItems.u_steel_tt_ingot ||
		item == ModItems.u_steel_cn_ingot || item == ModItems.u_steel_cb_ingot ||
		item == ModItems.u_steel_ct_ingot || item == ModItems.u_steel_nb_ingot ||
		item == ModItems.u_steel_nt_ingot || item == ModItems.u_steel_bt_ingot)
		{
			return 4;
		}else
		return 1;
	}
	
	private boolean canSmelt(){
		int howMuchAsh = 0;
		if(this.furnaceItemStacks[4] != null){//counteracts nullPointerException
			howMuchAsh = this.furnaceItemStacks[4].stackSize;
		}
		if(this.furnaceItemStacks[0] == null){
			return false;
		}else if(howMuchAsh > 63){
			return false;
		}else{
			ItemStack itemstack = getFynalSmeltingResult(this.furnaceItemStacks[0]);
			int requiredheat = getHeatRequiredToSmelt(this.furnaceItemStacks[0]);
			if(itemstack == null){
				return false;
			}
			if(requiredheat > this.getFurnaceHeat()){
				return false;
			}
			if(this.furnaceItemStacks[2] == null){
				return true;
			}
			if(!this.furnaceItemStacks[2].isItemEqual(itemstack)){
				return false;
			}
			int result = furnaceItemStacks[2].stackSize + itemstack.stackSize + getFluxBonus(); //THIS IS WHERE YOU MAKE IT NOT SMELT CUZ TOO MUCH STUFF ON THE RIGHT
			return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[2].getMaxStackSize();
		}
	}
	
	public void smeltItem(){
		if(this.canSmelt()){
			ItemStack itemstack = getFynalSmeltingResult(this.furnaceItemStacks[0]);
			int fluxBonus = getFluxBonus();
			boolean flagFluxUsed = false;
			if(fluxBonus > 0){flagFluxUsed = true;}
			
			if(this.furnaceItemStacks[2] == null){
				this.furnaceItemStacks[2] = itemstack.copy();
				this.furnaceItemStacks[2].stackSize += fluxBonus;
			}else if(this.furnaceItemStacks[2].getItem() == itemstack.getItem()){
				this.furnaceItemStacks[2].stackSize += (itemstack.stackSize + fluxBonus);
				if(this.furnaceItemStacks[2].stackSize > 64){
					furnaceItemStacks[2].stackSize = 64;//makes sure that screwing around with when you put flux into the furnace won't overload stack size
				}
			}
			
			if(flagFluxUsed){
				--this.furnaceItemStacks[3].stackSize;
			}
			--this.furnaceItemStacks[0].stackSize;
			
			if(this.furnaceItemStacks[0].stackSize <= 0){
				this.furnaceItemStacks[0] = null;
			}
			
			if(this.furnaceItemStacks[3] != null){
				if(this.furnaceItemStacks[3].stackSize <= 0){
					this.furnaceItemStacks[3] = null;
				}
			}
		}
	}
	
	public ItemStack getFynalSmeltingResult(ItemStack ore){//TODO HERE IS WHERE YOU GET RID OF VANILLA RECIPES
		ItemStack itemstack = null;
		if(Block.getBlockFromItem(ore.getItem()) == Blocks.iron_ore){
			itemstack = new ItemStack(ModItems.iron_nugget,3,0);
		}else if(Block.getBlockFromItem(ore.getItem()) == Blocks.gold_ore){
			itemstack = new ItemStack(Items.gold_nugget,1,0);
		}else if(Block.getBlockFromItem(ore.getItem()) == Blocks.log || Block.getBlockFromItem(ore.getItem()) == Blocks.log2){
			itemstack = null; //cant smelt wood->charcoal anymore
		}else itemstack = FurnaceRecipes.smelting().getSmeltingResult(ore);
		return itemstack;
	}
	
	public static boolean isItemFlux(ItemStack itemstack){
		if(itemstack.getItem() == ModItems.borax || itemstack.getItem() == ModItems.mixed_flux || itemstack.getItem() == ModItems.nether_flux || itemstack.getItem() == ModItems.potash){
			return true;
		}
		return false;
	}
	
	public int getFluxBonus(){
		if(this.furnaceItemStacks[3] == null){return 0;}//dont bother if flux slot is empty
		boolean flagcharcoal = false;
		Item fluxitem = this.furnaceItemStacks[3].getItem();
		Item smeltresult = getFynalSmeltingResult(this.furnaceItemStacks[0]).getItem();
		if(fluxitem == Items.coal && this.furnaceItemStacks[3].getItemDamage() == 1){
			flagcharcoal = true;
		}

		if(fluxitem == ModItems.borax || fluxitem == ModItems.potash || flagcharcoal){
			if(smeltresult == ModItems.copper_nugget || smeltresult == ModItems.iron_nugget || smeltresult == ModItems.lead_nugget){
				return 1;
			}
		}
		if(fluxitem == ModItems.mixed_flux){
			if(smeltresult == ModItems.copper_nugget || smeltresult == ModItems.iron_nugget || smeltresult == ModItems.lead_nugget){
				return 2;
			}
			if(smeltresult == ModItems.tin_nugget || smeltresult == ModItems.zinc_nugget || smeltresult == Items.gold_nugget){
				return 1;
			}
		}
		if(fluxitem == ModItems.nether_flux){
			if(smeltresult == ModItems.copper_nugget || smeltresult == ModItems.iron_nugget || smeltresult == ModItems.lead_nugget){
				return 3;
			}
			if(smeltresult == ModItems.tin_nugget || smeltresult == ModItems.zinc_nugget || smeltresult == Items.gold_nugget){
				return 2;
			}
			if(smeltresult == ModItems.nickel_nugget || smeltresult == ModItems.cobalt_nugget || smeltresult == ModItems.titanium_nugget){
				return 1;
			}
		}
		return 0;
	}
	
	public static int getItemBurnTime(ItemStack itemstack){
		if(itemstack == null){
			return 0;
		}else{
			Item item = itemstack.getItem();		
            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab)
                {
                    return 150;
                }

                if (block.getMaterial() == Material.wood)
                {
                    return 300;
                }

                if (block == Blocks.coal_block)
                {
                    return 16000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
			return GameRegistry.getFuelValue(itemstack); //This way you don't have to redefine everything
		}
	}
	
	public static boolean isItemFuel(ItemStack itemstack){
		return getItemBurnTime(itemstack) > 0;
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
	public boolean isItemValidForSlot(int par1, ItemStack itemstack) { //TODO HERE IS WHERE YOU MAKE SURE ONLY FLUX GOES IN FLUX SPOT
		return par1 == 2 ? false : (par1 == 1 ? isItemFuel(itemstack) : true);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int par1) {
		return par1 == 0 ? slotsBottom : (par1 == 1 ? slotsTop : slotsSides);
	}

	@Override
	public boolean canInsertItem(int par1, ItemStack itemstack, int par3) {
		return this.isItemValidForSlot(par1, itemstack);
	}

	@Override
	public boolean canExtractItem(int par1, ItemStack itemstack, int par3) {
		return par3 != 0 || par1 != 1 ||itemstack.getItem() == Items.bucket;
	}

}
