package com.fynal.entity;

import com.fynal.item.ModItems;

import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

//THIS CLASS IS NOT IN USE RIGHT NOW
public class EntityFynalCow extends EntityCow{

	public EntityFynalCow(World world) {
		super(world);
        this.setSize(0.9F, 1.3F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.wheat, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
	}

	@Override
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();

        if (itemstack != null && itemstack.getItem() == ModItems.wood_bucket && !player.capabilities.isCreativeMode)
        {
            if (itemstack.stackSize-- == 1)
            {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(ModItems.wood_bucket_milk));
            }
            else if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.wood_bucket_milk)))
            {
                player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.wood_bucket_milk, 1, 0), false);
            }

            return true;
        } else
        if (itemstack != null && itemstack.getItem() == ModItems.steel_bucket && !player.capabilities.isCreativeMode)
        {
            if (itemstack.stackSize-- == 1)
            {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(ModItems.steel_bucket_milk));
            }
            else if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.steel_bucket_milk)))
            {
                player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.steel_bucket_milk, 1, 0), false);
            }

            return true;
        }
        else
        {
            return super.interact(player);
        }
    }
	
}
