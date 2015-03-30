package com.fynal.item;

import java.util.List;

import com.fynal.lib.Ref;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class rose_gold_armor extends ItemArmor{

	public rose_gold_armor(ArmorMaterial par1, int par2, int par3) {
		super(par1, par2, par3);
	}

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(stack.getItem() == ModTools.rose_gold_helmet || stack.getItem() == ModTools.rose_gold_chestplate || stack.getItem() == ModTools.rose_gold_boots){
        	return (Ref.MODID + ":textures/models/armor/rose_gold_layer_1.png");
        }else if(stack.getItem() == ModTools.rose_gold_leggings){
        	return (Ref.MODID + ":textures/models/armor/rose_gold_layer_2.png");
        }else{
        	return null;
        }
    }

}