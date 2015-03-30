package com.fynal.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class alloyingot extends Item{

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
		Item ingot = par1ItemStack.getItem();
		if(ingot == ModItems.brass_z_ingot)	par3List.add("Zinc Alloy");
		if(ingot == ModItems.brass_zz_ingot)	par3List.add("High-Zinc Alloy");
		if(ingot == ModItems.bronze_t_ingot)	par3List.add("Tin Alloy");
		if(ingot == ModItems.bronze_tt_ingot)	par3List.add("High-Tin Alloy");
		if(ingot == ModItems.bronze_tz_ingot)	par3List.add("Tin-Zinc Alloy");

		if(ingot == ModItems.steel_c_ingot)	par3List.add("Carbon Alloy");
		if(ingot == ModItems.steel_cc_ingot)	par3List.add("High-Carbon Alloy");
		if(ingot == ModItems.steel_n_ingot)	par3List.add("Nickel Alloy");
		if(ingot == ModItems.steel_nn_ingot)	par3List.add("High-Nickel Alloy");
		if(ingot == ModItems.steel_b_ingot)	par3List.add("Cobalt Alloy");
		if(ingot == ModItems.steel_bb_ingot)	par3List.add("High-Cobalt Alloy");
		if(ingot == ModItems.steel_t_ingot)	par3List.add("Titanium Alloy");
		if(ingot == ModItems.steel_tt_ingot)	par3List.add("High-Titanium Alloy");
		
		if(ingot == ModItems.steel_cn_ingot)	par3List.add("Nickel-Carbon Alloy");
		if(ingot == ModItems.steel_cb_ingot)	par3List.add("Cobalt-Carbon Alloy");
		if(ingot == ModItems.steel_ct_ingot)	par3List.add("Titanium-Carbon Alloy");
		if(ingot == ModItems.steel_nb_ingot)	par3List.add("Nickel-Cobalt Alloy");
		if(ingot == ModItems.steel_nt_ingot)	par3List.add("Nickel-Titanium Alloy");
		if(ingot == ModItems.steel_bt_ingot)	par3List.add("Titanium-Cobalt Alloy");
		}
}
