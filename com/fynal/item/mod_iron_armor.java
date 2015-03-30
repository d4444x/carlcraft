package com.fynal.item;

import java.util.List;

import com.fynal.lib.Ref;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class mod_iron_armor extends ItemArmor{

	public mod_iron_armor(ArmorMaterial par1, int par2, int par3) {
		super(par1, par2, par3);
	}

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(stack.getItem() == ModTools.mod_iron_helmet || stack.getItem() == ModTools.mod_iron_chestplate || stack.getItem() == ModTools.mod_iron_boots){
        	return (Ref.MODID + ":textures/models/armor/mod_iron_layer_1.png");
        }else if(stack.getItem() == ModTools.mod_iron_leggings){
        	return (Ref.MODID + ":textures/models/armor/mod_iron_layer_2.png");
        }else{
        	return null;
        }
    }

}