package com.fynal.block;

import java.util.Random;

import com.fynal.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FossilOre extends Block{

	protected FossilOre(Material ground) {
		super(Material.ground);
		this.setHardness(1.0f);
		this.setResistance(4.0f);
		this.setStepSound(soundTypeGravel);
	}
	
	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        return Items.bone;
    }
	
	public int quantityDropped(int i, int j, Random random){
		int q = 1 + random.nextInt(2);
		return q;
	}

}
