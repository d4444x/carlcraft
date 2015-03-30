package com.fynal.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WoodPileCharred extends Block{

	protected WoodPileCharred(Material par1) {
		super(par1);
		this.setHardness(2.0f);
		this.setResistance(10.0f);
		this.setStepSound(soundTypeWood);
		this.setHarvestLevel("axe", 0);
	}

	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_){
        return Items.coal;
    }
	
	public int damageDropped(int par1){
		return 1;
	}
}
