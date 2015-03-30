package com.fynal.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ZincOre extends Block{

	protected ZincOre(Material rock) {
		super(Material.rock);
		this.setHardness(2.5f);
		this.setResistance(15.0f);
	}

}
