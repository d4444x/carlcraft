package com.fynal.block;

import java.util.Random;

import com.fynal.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BoraxOre extends Block{

	protected BoraxOre(Material rock) {
		super(Material.rock);
		this.setHardness(2.0f);
		this.setResistance(15.0f);
	}

	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        return ModItems.borax;
    }
}
