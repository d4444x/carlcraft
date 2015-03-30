package com.fynal.block;

import java.util.Random;

import com.fynal.Main.MainRegistry;
import com.fynal.lib.Ref;
import com.fynal.tile_entity.TileEntityVat;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class Vat extends BlockContainer{

	protected Vat(Material wood) {
		super(Material.wood);
		this.setHardness(2.5f);
		this.setResistance(15.0f);
	}
	
	private final Random random = new Random();

	@SideOnly(Side.CLIENT)
	private IIcon top;
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister){
		this.blockIcon = iconregister.registerIcon(Ref.MODID + ":VatSide");
		this.top = iconregister.registerIcon(Ref.MODID + ":VatTop");
	}
	
	public IIcon getIcon(int side, int meta){
		if(side == 1){
			return top;
		}else if(side == 0){
			return top;
		}else{
			return this.blockIcon;
		}
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
		player.openGui(MainRegistry.modInstance, 1, world, x, y, z);
		return true;
	}
	
	public Item getItemDropped(int par1, Random random, int par3){
		return Item.getItemFromBlock(ModBlocks.Vat);
	}
	
	public Item getItem(World world, int par2, int par3, int par4){
		return Item.getItemFromBlock(ModBlocks.Vat);
	}
	
	public TileEntity createNewTileEntity(World world, int par2){
		return new TileEntityVat();
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta){
		TileEntityVat tileentityvat = (TileEntityVat)world.getTileEntity(x, y, z);
			
		if(tileentityvat != null){
			for(int i = 0; i < tileentityvat.getSizeInventory(); ++i){
				ItemStack itemstack = tileentityvat.getStackInSlot(i);
				
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
		super.breakBlock(world, x, y, z, block, meta);
	}
}
