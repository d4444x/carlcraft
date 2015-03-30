package com.fynal.block;

import java.util.Random;

import com.fynal.Main.MainRegistry;
import com.fynal.lib.Ref;
import com.fynal.tile_entity.TileEntityFluxFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFurnace;
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
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class FluxFurnace extends BlockContainer {

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon front;
	
	private static boolean flag1;
	private final boolean flag2;
	private final Random random = new Random();
	
	protected FluxFurnace(boolean isActive) {
		super(Material.rock);
		flag2 = isActive;
		this.setHardness(3.5f);
		this.setResistance(17.5f);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister){
		this.blockIcon = iconregister.registerIcon(Ref.MODID + ":FluxFurnaceSide");
		this.front = iconregister.registerIcon(this.flag2 ? Ref.MODID + ":FluxFurnaceActive" : Ref.MODID + ":FluxFurnaceInactive");
		this.top = iconregister.registerIcon(Ref.MODID + ":FluxFurnaceTop");
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
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
		player.openGui(MainRegistry.modInstance, 0, world, x, y, z);
		return true;
	}
	
	public Item getItemDropped(int par1, Random random, int par3){
		return Item.getItemFromBlock(ModBlocks.FluxFurnace);
	}
	
	public Item getItem(World world, int par2, int par3, int par4){
		return Item.getItemFromBlock(ModBlocks.FluxFurnace);
	}
	
	public TileEntity createNewTileEntity(World world, int par2){
		return new TileEntityFluxFurnace();
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
			
			world.setBlockMetadataWithNotify(x, y, z, directionByte, 2);
		}
	}
	
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemstack)
    {
        int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (l == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (l == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (l == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

        if (itemstack.hasDisplayName())
        {
            ((TileEntityFluxFurnace)world.getTileEntity(x, y, z)).furnaceName(itemstack.getDisplayName());
        }
    }
	
	public static void updateBlockState(boolean burning, World world, int x, int y, int z){
		int direction = world.getBlockMetadata(x, y, z);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		flag1 = true;
		
		if(burning){
			world.setBlock(x, y, z, ModBlocks.FluxFurnaceActive);
		}else{
			world.setBlock(x, y, z, ModBlocks.FluxFurnace);
		}
		
		flag1 = false;
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);
		
		if(tileentity != null){
			tileentity.validate();
			world.setTileEntity(x, y, z, tileentity);
		}
	}
	
	public void breakBlock(World world, int x, int y, int z, Block block, int meta){
		if(!flag1){
			TileEntityFluxFurnace tileentityfluxfurnace = (TileEntityFluxFurnace)world.getTileEntity(x, y, z);
			
			if(tileentityfluxfurnace != null){
				for(int i = 0; i < tileentityfluxfurnace.getSizeInventory(); ++i){
					ItemStack itemstack = tileentityfluxfurnace.getStackInSlot(i);
				
					if(itemstack != null){
						float f = this.random.nextFloat() * 0.6F + 0.1F;
						float f1 = this.random.nextFloat() * 0.6F + 0.1F;
						float f2 = this.random.nextFloat() * 0.6F + 0.1F;
						
						int j = 0;
						
						while(itemstack.stackSize > 0){
							j = this.random.nextInt(21) + 10;
							
							if(j > itemstack.stackSize){
								j = itemstack.stackSize;
							}
							
							itemstack.stackSize -= j;
							EntityItem entityitem = new EntityItem(world, (double)((float) x + f), (double)((float) y + f1), (double)((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));
						
							if(itemstack.hasTagCompound()){
								entityitem.getEntityItem().setTagCompound(((NBTTagCompound)itemstack.getTagCompound().copy()));
							}
							
							float f3 = 0.025F;
							entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
							entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.1F);
							entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
							world.spawnEntityInWorld(entityitem);
							
						}
					}
				}
				world.func_147453_f(x, y, z, block);
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random){
		if(this.flag2){
			int direction = world.getBlockMetadata(x, y, z);
			float xx = (float) x + 0.5F;
			float yy = (float) y + random.nextFloat() * 6.0F / 16.0F;
			float zz = (float) z + 0.5F;
			float f3 = 0.52F;
			float f4 = random.nextFloat() * 0.6F - 0.3F;
			
			if(direction == 4){
				world.spawnParticle("smoke", (double) (xx - f3), (double) yy, (double) (zz + f4), 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", (double) (xx - f3), (double) yy, (double) (zz + f4), 0.0F, 0.0F, 0.0F);
			}else if(direction == 5){
				world.spawnParticle("smoke", (double) (xx + f3), (double) yy, (double) (zz + f4), 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", (double) (xx + f3), (double) yy, (double) (zz + f4), 0.0F, 0.0F, 0.0F);
			}else if(direction == 2){
				world.spawnParticle("smoke", (double) (xx + f4), (double) yy, (double) (zz - f3), 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", (double) (xx + f4), (double) yy, (double) (zz - f3), 0.0F, 0.0F, 0.0F);
			}else if(direction == 3){
				world.spawnParticle("smoke", (double) (xx + f4), (double) yy, (double) (zz + f3), 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", (double) (xx + f4), (double) yy, (double) (zz + f3), 0.0F, 0.0F, 0.0F);
			}
		}
	}
}
