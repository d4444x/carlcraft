package com.fynal.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class CharcoalBlockActive extends Block{

	protected CharcoalBlockActive(Material par1) {
		super(par1);
		this.setHardness(5.0f);
		this.setResistance(30.0f);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 0);
		this.setTickRandomly(false);
	}

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        if(this==ModBlocks.CharcoalBlockActive) return Item.getItemFromBlock(ModBlocks.CharcoalBlock);
        if(this==ModBlocks.CoalBlockActive) return Item.getItemFromBlock(ModBlocks.CoalBlock);
        return null;
    }
    
    public int tickRate(World world)
    {
        return 0; 
    }
    
    private void tryToIgnite(World world, int x, int y, int z){
    	Block block = world.getBlock(x, y, z);
    	if(block == Blocks.air) world.setBlock(x, y, z, Blocks.fire);
    	if(block == ModBlocks.woodPile) world.setBlock(x, y, z, ModBlocks.woodPileActive);
    	world.scheduleBlockUpdate(x, y, z, ModBlocks.woodPileActive, 100);
    	if(block == ModBlocks.CharcoalBlock) world.setBlock(x, y, z, ModBlocks.CharcoalBlockActive);
    	world.scheduleBlockUpdate(x, y, z, ModBlocks.CharcoalBlockActive, 100);
    	if(block == ModBlocks.CoalBlock) world.setBlock(x, y, z, ModBlocks.CoalBlockActive);
    	world.scheduleBlockUpdate(x, y, z, ModBlocks.CoalBlockActive, 100);
    }
    
    public void updateTick(World world, int x, int y, int z, Random random){
    	int meta = world.getBlockMetadata(x, y, z);
    	if(meta < 15){
        	world.scheduleBlockUpdate(x, y, z, this, 150 + random.nextInt(50));
    		world.setBlockMetadataWithNotify(x, y, z, meta+1, 0);
    		this.tryToIgnite(world, x+1, y, z);
    		this.tryToIgnite(world, x-1, y, z);
    		this.tryToIgnite(world, x, y+1, z);
    		this.tryToIgnite(world, x, y-1, z);
    		this.tryToIgnite(world, x, y, z+1);
    		this.tryToIgnite(world, x, y, z-1);
    	} else {
    		world.setBlock(x, y, z, ModBlocks.CokeBlock);
    	}
    }

    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        if (random.nextInt(24) == 0)
        {
            world.playSound((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "fire.fire", 1.0F + random.nextFloat(), 0.5F, false);
        }
        float f0 = random.nextFloat() * 0.9F + 0.05F;
        float f1 = random.nextFloat() * 0.9F + 0.05F;
        float fs = ((float) random.nextInt(2)) * 1.04F - 0.02F;
        int axis = random.nextInt(3);
        
        if(axis == 0){
            world.spawnParticle("smoke", (double)(x + fs), (double)(y + f0), (double)(z + f1), 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", (double)(x + fs), (double)(y + f0), (double)(z + f1), 0.0D, 0.0D, 0.0D);
        }
        if(axis == 1){
            world.spawnParticle("smoke", (double)(x + f0), (double)(y + fs), (double)(z + f1), 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", (double)(x + f0), (double)(y + fs), (double)(z + f1), 0.0D, 0.0D, 0.0D);
        }
        if(axis == 2){
            world.spawnParticle("smoke", (double)(x + f0), (double)(y + f1), (double)(z + fs), 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", (double)(x + f0), (double)(y + f1), (double)(z + fs), 0.0D, 0.0D, 0.0D);
        }
    }
	
}
