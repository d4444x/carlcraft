package com.fynal.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class LeadOre extends Block{

	protected LeadOre(Material rock) {
		super(Material.rock);
		this.setHardness(2.5f);
		this.setResistance(15.0f);
		this.setHarvestLevel("pickaxe", 2);
	}

}
