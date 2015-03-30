package com.fynal.handler;

import com.fynal.block.ModBlocks;
import com.fynal.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class fuelhandler implements IFuelHandler{

	@Override
	public int getBurnTime(ItemStack fuel) {

		if(fuel.getItem() == ModItems.Coke){
			return 1600;
		}
		
		if(fuel.getItem() == ModItems.animal_fat){
			return 200;
		}
		
        if (fuel.getItem() instanceof ItemBlock && Block.getBlockFromItem(fuel.getItem()) != Blocks.air)
        {
            Block block = Block.getBlockFromItem(fuel.getItem());

            if (block == ModBlocks.Peat)
            {
                return 600;
            }
            if (block == ModBlocks.CharcoalBlock)
            {
                return 16000;
            }
        }
		
		return 0;
	}

}
