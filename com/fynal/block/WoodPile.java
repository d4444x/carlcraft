package com.fynal.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class WoodPile extends Block{

	protected WoodPile(Material par1) {
		super(par1);
		this.setHardness(2.0f);
		this.setResistance(10.0f);
		this.setStepSound(soundTypeWood);
		this.setHarvestLevel("axe", 0);
	}

    public void onBlockAdded(World world, int x, int y, int z) {
    	this.onNeighborBlockChange(world, x, y, z, Blocks.air);
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor) {
    	if(world.getBlock(x+1, y, z) == Blocks.fire || world.getBlock(x-1, y, z) == Blocks.fire || world.getBlock(x, y+1, z) == Blocks.fire || world.getBlock(x, y-1, z) == Blocks.fire || world.getBlock(x, y, z+1) == Blocks.fire || world.getBlock(x, y, z-1) == Blocks.fire){
    		if(this == ModBlocks.woodPile) {
    			world.setBlock(x, y, z, ModBlocks.woodPileActive);
    	    	world.scheduleBlockUpdate(x, y, z, ModBlocks.woodPileActive, 100);
    		}
    	}
    }
    
	public Item getItemDropped(int par1, Random random, int par3){
        return Items.stick;
    }
	
    public int quantityDropped(Random par1)
    {
        return 9;
    }
	
}
