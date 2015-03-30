package com.fynal.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Dawn extends ItemFood{

	public Dawn(int hunger, float saturation, boolean isWolfFood) {
		super(hunger, saturation, isWolfFood);
		this.setAlwaysEdible();
	}
	
    public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
        if (!par2World.isRemote)
        { 
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1200, 0));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1200, 0));
        }
    }

}
