package com.fynal.block;

import java.util.Random;

import com.fynal.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CokeBlock extends Block{

	protected CokeBlock(Material par1) {
		super(par1);
		this.setHardness(3.0f);
		this.setResistance(15.0f);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 0);
	}

	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        return ModItems.Coke;
    }
}
