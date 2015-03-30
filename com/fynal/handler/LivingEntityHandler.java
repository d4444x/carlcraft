package com.fynal.handler;

import java.util.Iterator;
import java.util.Random;

import com.fynal.entity.EntityFynalCow;
import com.fynal.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;

public class LivingEntityHandler
{
public static Random random;

/*
	@SubscribeEvent
	public void onEvent(EntityJoinWorldEvent event){
		if(event.entity instanceof EntityCow && !(event.entity instanceof EntityFynalCow)){
			Entity fynalcow = new EntityChicken(event.world);
			fynalcow.posX = event.entity.posX;
			fynalcow.posY = event.entity.posY;
			fynalcow.posZ = event.entity.posZ;
			System.out.printf("COW ALERT\n");
			event.world.spawnEntityInWorld(fynalcow);
			event.isCanceled();
		}
	}
*/
	
	@SubscribeEvent
	public void onEvent(EntityInteractEvent event){
		if(event.target instanceof EntityCow){
			if(event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == ModItems.wood_bucket){
				event.entityPlayer.inventory.mainInventory[event.entityPlayer.inventory.currentItem] = new ItemStack(ModItems.wood_bucket_milk);
			}
			if(event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == ModItems.steel_bucket){
				event.entityPlayer.inventory.mainInventory[event.entityPlayer.inventory.currentItem] = new ItemStack(ModItems.steel_bucket_milk);				
			}
		}
	}

	@SubscribeEvent
	public void onEvent(LivingDropsEvent event)
	{
		random = new Random();

		if(event.entityLiving instanceof EntityCow || event.entityLiving instanceof EntityFynalCow)
		{
			Iterator<EntityItem> remover = event.drops.iterator();
			while(remover.hasNext()){
				EntityItem entityitem = remover.next();
				if( entityitem != null ){
					if(entityitem.getEntityItem().getItem() == Items.leather)
					remover.remove();
				}
			}
	        ItemStack itemStackToDrop = new ItemStack(ModItems.hide, random.nextInt(2) + 1);
	        event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemStackToDrop));
	    }
		
		if(event.entityLiving instanceof EntityHorse)
		{
			Iterator<EntityItem> remover = event.drops.iterator();
			while(remover.hasNext()){
				EntityItem entityitem = remover.next();
				if( entityitem != null ){
					if(entityitem.getEntityItem().getItem() == Items.leather)
					remover.remove();
				}
			}
	        ItemStack itemStackToDrop = new ItemStack(ModItems.hide, random.nextInt(2) + 1);
	        event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemStackToDrop));
		}
		
		if(event.entityLiving instanceof EntityPig)
		{
	        ItemStack itemStackToDrop = new ItemStack(ModItems.hide, random.nextInt(2));
	        event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemStackToDrop));
		}
		
		if(event.entityLiving instanceof EntitySheep)
		{
	        ItemStack itemStackToDrop = new ItemStack(ModItems.hide, random.nextInt(2));
	        event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemStackToDrop));
		}
		
		if(event.entityLiving instanceof EntityPigZombie)
		{
	        event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, new ItemStack(ModItems.dawn)));
		}
		
	}

}