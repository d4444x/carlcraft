package com.fynal.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CobaltOre extends Block{

	protected CobaltOre(Material rock) {
		super(Material.rock);
		this.setHardness(4.0f);
		this.setResistance(30.0f);
		this.setHarvestLevel("pickaxe", 3);
	}

}
