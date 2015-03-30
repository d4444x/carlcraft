package com.fynal.Main;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;

public class RecipeRemover {

	public static void removeRecipe(){
		/*//SMELTING REMOVER
		FurnaceRecipes.smelting().getSmeltingList().remove(Blocks.iron_ore);//NOPE DOESNT WORK
		FurnaceRecipes.smelting().getSmeltingList().remove(Blocks.gold_ore);
		FurnaceRecipes.smelting().getSmeltingList().remove(Items.iron_ingot);//THIS SYNTAX SEEMED TO WORK ONCE
		FurnaceRecipes.smelting().getSmeltingList().remove(Items.gold_ingot);*/
		
		//CRAFTING REMOVER
		List<IRecipe> recipes = net.minecraft.item.crafting.CraftingManager.getInstance().getRecipeList();
	
		Iterator<IRecipe> remover = recipes.iterator();
	
			while(remover.hasNext()){
				ItemStack itemstack = remover.next().getRecipeOutput();
				if( itemstack != null ){
					Block checkblock = Block.getBlockFromItem(itemstack.getItem());
					if( itemstack.getItem() == Items.stone_sword
						|| itemstack.getItem() == Items.stone_axe 
						|| itemstack.getItem() == Items.stone_hoe 
						|| itemstack.getItem() == Items.stone_shovel 
						|| itemstack.getItem() == Items.stone_pickaxe 
						|| itemstack.getItem() == Items.wooden_sword 
						|| itemstack.getItem() == Items.wooden_axe 
						|| itemstack.getItem() == Items.wooden_hoe 
						|| itemstack.getItem() == Items.wooden_shovel 
						|| itemstack.getItem() == Items.wooden_pickaxe 
						|| itemstack.getItem() == Items.diamond_sword 
						|| itemstack.getItem() == Items.diamond_axe 
						|| itemstack.getItem() == Items.diamond_hoe 
						|| itemstack.getItem() == Items.diamond_shovel 
						|| itemstack.getItem() == Items.diamond_pickaxe 
						|| itemstack.getItem() == Items.iron_sword 
						|| itemstack.getItem() == Items.iron_axe 
						|| itemstack.getItem() == Items.iron_shovel 
						|| itemstack.getItem() == Items.iron_pickaxe 
						|| itemstack.getItem() == Items.iron_hoe
						|| itemstack.getItem() == Items.iron_helmet 
						|| itemstack.getItem() == Items.iron_chestplate
						|| itemstack.getItem() == Items.iron_leggings 
						|| itemstack.getItem() == Items.iron_boots 
						|| itemstack.getItem() == Items.flint_and_steel 
						|| itemstack.getItem() == Items.bucket 
						|| checkblock == Blocks.coal_block
						|| checkblock == Blocks.enchanting_table
						|| checkblock == Blocks.furnace )
					remover.remove();
				}
			}
		}
}
