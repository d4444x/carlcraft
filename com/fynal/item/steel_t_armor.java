package com.fynal.item;

import java.util.List;

import com.fynal.lib.Ref;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class steel_t_armor extends ItemArmor{

	public steel_t_armor(ArmorMaterial par1, int par2, int par3) {
		super(par1, par2, par3);
	}

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(stack.getItem() == ModTools.steel_t_helmet || stack.getItem() == ModTools.steel_t_chestplate || stack.getItem() == ModTools.steel_t_boots){
        	return (Ref.MODID + ":textures/models/armor/steel_t_layer_1.png");
        }else if(stack.getItem() == ModTools.steel_t_leggings){
        	return (Ref.MODID + ":textures/models/armor/steel_t_layer_2.png");
        }else{
        	return null;
        }
    }

public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
par3List.add("Titanium Alloy");
}
@Override
public void onCreated(ItemStack stack, World world, EntityPlayer player){
	stack.addEnchantment(Enchantment.protection, 2);
}
}