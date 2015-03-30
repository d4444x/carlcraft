package com.fynal.item;

import java.util.List;

import com.fynal.lib.Ref;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class brass_zz_armor extends ItemArmor{

	public brass_zz_armor(ArmorMaterial par1, int par2, int par3) {
		super(par1, par2, par3);
	}

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(stack.getItem() == ModTools.brass_zz_helmet || stack.getItem() == ModTools.brass_zz_chestplate || stack.getItem() == ModTools.brass_zz_boots){
        	return (Ref.MODID + ":textures/models/armor/brass_zz_layer_1.png");
        }else if(stack.getItem() == ModTools.brass_zz_leggings){
        	return (Ref.MODID + ":textures/models/armor/brass_zz_layer_2.png");
        }else{
        	return null;
        }
    }

public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
par3List.add("High-Zinc Alloy");
}

@Override
public void onCreated(ItemStack stack, World world, EntityPlayer player){
	stack.addEnchantment(Enchantment.blastProtection, 2);
}
}