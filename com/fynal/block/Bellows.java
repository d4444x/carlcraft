package com.fynal.block;

import java.util.Random;

import com.fynal.Main.MainRegistry;
import com.fynal.lib.Ref;
import com.fynal.tile_entity.TileEntityBellows;
import com.fynal.tile_entity.TileEntityFluxFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Bellows extends BlockContainer {

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon front;
	
	private final Random random = new Random();
	
	protected Bellows(Material material) {
		super(Material.wood);
		this.setHardness(2.0f);
		this.setResistance(8.0f);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister){
		this.blockIcon = iconregister.registerIcon(Ref.MODID + ":BellowsSide");
		this.front = iconregister.registerIcon(Ref.MODID + ":BellowsFront");
		this.top = iconregister.registerIcon(Ref.MODID + ":BellowsTop");
	}
	
	public IIcon getIcon(int side, int meta){
		if(side == 1){
			return top;
		}else if(side == 0){
			return top;
		}else if(side == meta){
			return front;
		}else{
			return this.blockIcon;
		}
	}
	
	public void activateBellows(World world, int x, int y, int z)
	{
		TileEntityBellows tileBellows = (TileEntityBellows) world.getTileEntity(x, y, z);
		int meta = tileBellows.direction;//block metadata, extracted in a way that doesn't cause a horrible server index out of bounds crash
		if(!tileBellows.isCooldown()){
			world.playSoundEffect((double)x+0.5, (double)y+0.5, (double)z+0.5, "random.wood_click", 2.0F, 0.5F);
			world.playSoundEffect((double)x+0.5, (double)y+0.5, (double)z+0.5, "mob.enderdragon.wings", 2.0F, 0.5F);
			tileBellows.cooldownTime = 50;//2.5 seconds
			TileEntityFluxFurnace tileFurnace;
			int xoff = 0;
			int zoff = 0;
			if(meta == 3) zoff = 1;
			if(meta == 2) zoff = -1;
			if(meta == 5) xoff = 1;
			if(meta == 4) xoff = -1;
			if(world.getBlock(x+xoff, y, z+zoff) == ModBlocks.FluxFurnace || world.getBlock(x+xoff, y, z+zoff) == ModBlocks.FluxFurnaceActive){
				tileFurnace = (TileEntityFluxFurnace) world.getTileEntity(x+xoff, y, z+zoff);
				tileFurnace.setBellowsHeatTime(40);//2 seconds
				if(tileFurnace.isBurning()){
					world.playSoundEffect((double)x+xoff+0.5, (double)y+0.5, (double)z+zoff+0.5, "fire.fire", 2.0F, 0.1F);
				}
			}
		}
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int clickmeta, float par7, float par8, float par9){
		if(!world.isRemote){
			activateBellows(world, x, y, z);
		}
		return true;
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
		if(!world.isRemote){
			if(world.isBlockIndirectlyGettingPowered(x, y, z)){
				activateBellows(world, x, y, z);
			}
		}
	}
	
	public Item getItemDropped(int par1, Random random, int par3){
		return Item.getItemFromBlock(ModBlocks.Bellows);
	}
	
	public Item getItem(World world, int par2, int par3, int par4){
		return Item.getItemFromBlock(ModBlocks.Bellows);
	}
	
	public TileEntity createNewTileEntity(World world, int par2){
		return new TileEntityBellows();
	}
	
	@SideOnly(Side.CLIENT)
	public void onBlockAdded(World world, int x, int y, int z){
		super.onBlockAdded(world, x, y, z);
		this.direction(world, x, y, z);
	}

	private void direction(World world, int x, int y, int z) {
		if(!world.isRemote){
			Block direction0 = world.getBlock(x, y, z-1);
			Block direction1 = world.getBlock(x, y, z+1);
			Block direction2 = world.getBlock(x-1, y, z);
			Block direction3 = world.getBlock(x+1, y, z);
			byte directionByte = 3;
			
			if(direction0.func_149730_j() && !direction1.func_149730_j()){
				directionByte = 3;
			}
			if(direction1.func_149730_j() && !direction0.func_149730_j()){
				directionByte = 2;
			}
			if(direction2.func_149730_j() && !direction3.func_149730_j()){
				directionByte = 5;
			}
			if(direction3.func_149730_j() && !direction2.func_149730_j()){
				directionByte = 4;
			}
			
			setBellowsBlockMetadataWithNotify(x, y, z, directionByte, 2, world);
		}
	}
	
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemstack)
    {
    	if(world.getBlock(x+1, y, z) == ModBlocks.FluxFurnace || world.getBlock(x+1, y, z) == ModBlocks.FluxFurnaceActive){
            setBellowsBlockMetadataWithNotify(x, y, z, 5, 2, world);
    	}else
        if(world.getBlock(x-1, y, z) == ModBlocks.FluxFurnace || world.getBlock(x-1, y, z) == ModBlocks.FluxFurnaceActive){
            setBellowsBlockMetadataWithNotify(x, y, z, 4, 2, world);
        }else
        if(world.getBlock(x, y, z+1) == ModBlocks.FluxFurnace || world.getBlock(x, y, z+1) == ModBlocks.FluxFurnaceActive){
            setBellowsBlockMetadataWithNotify(x, y, z, 3, 2, world);
       	}else
        if(world.getBlock(x, y, z-1) == ModBlocks.FluxFurnace || world.getBlock(x, y, z-1) == ModBlocks.FluxFurnaceActive){
            setBellowsBlockMetadataWithNotify(x, y, z, 2, 2, world);
        }else{
    	
        	int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        	if (l == 0)
        	{
        		setBellowsBlockMetadataWithNotify(x, y, z, 2, 2, world);
        	}

        	if (l == 1)
        	{
        		setBellowsBlockMetadataWithNotify(x, y, z, 5, 2, world);
        	}

        	if (l == 2)
        	{
        		setBellowsBlockMetadataWithNotify(x, y, z, 3, 2, world);
        	}
        	
        	if (l == 3)
        	{
        		setBellowsBlockMetadataWithNotify(x, y, z, 4, 2, world);
        	}
        }
    }
    
    public void setBellowsBlockMetadataWithNotify(int x, int y, int z, int metadata, int par5, World world){
    	TileEntityBellows tileBellows = (TileEntityBellows) world.getTileEntity(x, y, z);
    	tileBellows.direction = metadata;
		world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
    }
	
	public static void updateBlockState(World world, int x, int y, int z){
//if needed
	}
	
//TODO sound effect
}
