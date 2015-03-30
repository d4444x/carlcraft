package com.fynal.inventory;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.MathHelper;

public class SlotCoilcraftOutput extends Slot //COPY-PASTED AND MODIFIED FROM SlotFurnace.class (net.minecraft.inventory)
{
    private int field_75228_b;
    private static final String __OBFID = "CL_00001749";

    public SlotCoilcraftOutput(IInventory p_i1813_2_, int p_i1813_3_, int p_i1813_4_, int p_i1813_5_)
    {
        super(p_i1813_2_, p_i1813_3_, p_i1813_4_, p_i1813_5_);
    }
    
    public boolean isItemValid(ItemStack itemstack)
    {
        return false;
    }
    
    public void onPickupFromSlot(EntityPlayer p_82870_1_, ItemStack p_82870_2_)
    {
        this.onCrafting(p_82870_2_);
        super.onPickupFromSlot(p_82870_1_, p_82870_2_);
    }
}