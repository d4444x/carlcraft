package com.fynal.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Bandage extends ItemFood{

	public Bandage(int hunger, float saturation, boolean isWolfFood) {
		super(hunger, saturation, isWolfFood);
		this.setAlwaysEdible();
	}
	
    public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
        if (!par2World.isRemote)
        { 
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
        }
    }
    
    @Override
    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        --p_77654_1_.stackSize;
        p_77654_3_.getFoodStats().func_151686_a(this, p_77654_1_);
        p_77654_2_.playSoundAtEntity(p_77654_3_, "dig.cloth", 2.0F, 0.5F);
        this.onFoodEaten(p_77654_1_, p_77654_2_, p_77654_3_);
        return p_77654_1_;
    }
    
}
