package com.fynal.item;

import java.util.List;

import com.fynal.lib.Ref;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class copper_armor extends ItemArmor{

	public copper_armor(ArmorMaterial par1, int par2, int par3) {
		super(par1, par2, par3);
	}

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(stack.getItem() == ModTools.copper_helmet || stack.getItem() == ModTools.copper_chestplate || stack.getItem() == ModTools.copper_boots){
        	return (Ref.MODID + ":textures/models/armor/copper_layer_1.png");
        }else if(stack.getItem() == ModTools.copper_leggings){
        	return (Ref.MODID + ":textures/models/armor/copper_layer_2.png");
        }else{
        	return null;
        }
    }

}