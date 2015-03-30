package com.fynal.block;

import java.util.Random;

import com.fynal.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class SaltpeterOre extends Block{

	protected SaltpeterOre(Material rock) {
		super(Material.rock);
		this.setHardness(2.5f);
		this.setResistance(10.0f);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 0);
	}
	
	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        return ModItems.saltpeter;
    }
}
