package com.fynal.block;

import java.util.Random;

import com.fynal.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DesertLapisOre extends Block{

	protected DesertLapisOre(Material rock) {
		super(Material.rock);
		this.setHardness(1.5f);
		this.setResistance(7.5f);
	}

	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        return Items.dye;
    }
	
    public int damageDropped(int p_149692_1_)
    {
        return 4;
    }
}
