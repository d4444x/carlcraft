package com.fynal.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class NickelOre extends Block{

	protected NickelOre(Material rock) {
		super(Material.rock);
		this.setHardness(3.5f);
		this.setResistance(15.0f);
		this.setHarvestLevel("pickaxe", 2);
	}

}
