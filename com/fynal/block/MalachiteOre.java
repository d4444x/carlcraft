package com.fynal.block;

import java.util.Random;

import com.fynal.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class MalachiteOre extends Block{

	protected MalachiteOre(Material ground) {
		super(Material.ground);
		this.setHardness(1.0f);
		this.setResistance(4.0f);
		this.setStepSound(soundTypeGravel);
	}
	
	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        return ModItems.malachite;
    }

}
