package com.fynal.item;

import java.util.List;

import com.fynal.lib.Ref;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class bronze_tz_armor extends ItemArmor{

	public bronze_tz_armor(ArmorMaterial par1, int par2, int par3) {
		super(par1, par2, par3);
	}

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(stack.getItem() == ModTools.bronze_tz_helmet || stack.getItem() == ModTools.bronze_tz_chestplate || stack.getItem() == ModTools.bronze_tz_boots){
        	return (Ref.MODID + ":textures/models/armor/bronze_tz_layer_1.png");
        }else if(stack.getItem() == ModTools.bronze_tz_leggings){
        	return (Ref.MODID + ":textures/models/armor/bronze_tz_layer_2.png");
        }else{
        	return null;
        }
    }

public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
par3List.add("Tin-Zinc Alloy");
}

@Override
public void onCreated(ItemStack stack, World world, EntityPlayer player){
	stack.addEnchantment(Enchantment.blastProtection, 1);
	stack.addEnchantment(Enchantment.projectileProtection, 1);
}
}