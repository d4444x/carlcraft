package com.fynal.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FynalBucketMilk extends Item
{
    public FynalBucketMilk()
    {
        this.setMaxStackSize(1);
    }

    public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player)
    {
        if (!player.capabilities.isCreativeMode)
        {
            --itemstack.stackSize;
        }

        if (!world.isRemote)
        {
            player.curePotionEffects(itemstack);
        }
        
        Item empty = null;
        if(itemstack.getItem()==ModItems.steel_bucket_milk) empty = ModItems.steel_bucket;
        if(itemstack.getItem()==ModItems.wood_bucket_milk) empty = ModItems.wood_bucket;
        
        return itemstack.stackSize <= 0 ? new ItemStack(empty) : itemstack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack itemstack)
    {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.drink;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
        return p_77659_1_;
    }
}