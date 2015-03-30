package com.fynal.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Peat extends Block{

	protected Peat(Material ground) {
		super(Material.grass);
		this.setHardness(0.8f);
		this.setResistance(3.0f);
		this.setStepSound(soundTypeGravel);
	}

}
