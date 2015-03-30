package com.fynal.block;

import java.util.Random;

import com.fynal.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class groundSpawn extends Block{

	public groundSpawn(Material plants) {
		super(Material.plants);
        float f = 0.2F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}
	
    public Item getItemDropped(int par1, Random random, int par2){
    	return( this == ModBlocks.groundStick ? Items.stick : (this == ModBlocks.groundRock ? ModItems.rock : (this == ModBlocks.groundFlint ? Items.flint : (this == ModBlocks.groundCopperNugget ? ModItems.copper_nugget : (this == ModBlocks.groundGoldNugget ? Items.gold_nugget : (this == ModBlocks.groundSulfur ? ModItems.sulfur : (this == ModBlocks.groundMeteorite1 ? ModItems.meteorite1 : (this == ModBlocks.groundMeteorite2 ? ModItems.meteorite2 : (this == ModBlocks.groundMeteorite3 ? ModItems.meteorite3 : (this == ModBlocks.groundMeteorite4 ? ModItems.meteorite4 : null))))))))));
    }
	
    public boolean canPlaceBlockAt(World par1, int par2, int par3, int par4)
    {
        return super.canPlaceBlockAt(par1, par2, par3, par4) && this.canBlockStay(par1, par2, par3, par4);
    }
    
    public void onNeighborBlockChange(World world, int x, int y, int z, Block par5)
    {
        super.onNeighborBlockChange(world, x, y, z, par5);
        this.checkAndDropBlock(world, x, y, z);
    }
	
    protected void checkAndDropBlock(World world, int x, int y, int z)
    {
        if (!this.canBlockStay(world, x, y, z))
        {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlock(x, y, z, getBlockById(0), 0, 2);
        }
    }
    
    public boolean canBlockStay(World world, int x, int y, int z)
    {
        return  world.getBlock(x, y - 1, z).isOpaqueCube();
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public int getRenderType()
    {
        return 1;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }
}
