package com.fynal.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class CharcoalBlock extends Block{

	protected CharcoalBlock(Material par1) {
		super(par1);
		this.setHardness(5.0f);
		this.setResistance(30.0f);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 0);
	}
	
    public void onBlockAdded(World world, int x, int y, int z) {
    	this.onNeighborBlockChange(world, x, y, z, Blocks.air);
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor) {
    	if(     world.getBlock(x+1, y, z) == Blocks.fire || 
    			world.getBlock(x-1, y, z) == Blocks.fire || 
    			world.getBlock(x, y+1, z) == Blocks.fire || 
    			world.getBlock(x, y-1, z) == Blocks.fire ||
    			world.getBlock(x, y, z+1) == Blocks.fire || 
    			world.getBlock(x, y, z-1) == Blocks.fire   			
    			)
    	{
    		if(this == ModBlocks.CharcoalBlock) {
    			world.setBlock(x, y, z, ModBlocks.CharcoalBlockActive);
    	    	world.scheduleBlockUpdate(x, y, z, ModBlocks.CharcoalBlockActive, 100);
    		} else if(this == ModBlocks.CoalBlock){
    			world.setBlock(x, y, z, ModBlocks.CoalBlockActive);
    	    	world.scheduleBlockUpdate(x, y, z, ModBlocks.CoalBlockActive, 100);
    		}
    	}
    }

}
