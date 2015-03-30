package com.fynal.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class FynalBucket extends Item
{
    private Block isFull;
    private boolean canLava;

    public FynalBucket(Block par1, boolean isMadeOfSteel)
    {
        this.maxStackSize = 1;
        this.isFull = par1;
        this.canLava = isMadeOfSteel;
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
        boolean flag = this.isFull == Blocks.air;
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, flag);

        if (movingobjectposition == null)
        {
            return itemstack;
        }
        else
        {
            FillBucketEvent event = new FillBucketEvent(player, itemstack, world, movingobjectposition);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return itemstack;
            }

            if (event.getResult() == Event.Result.ALLOW)
            {
                if (player.capabilities.isCreativeMode)
                {
                    return itemstack;
                }

                if (--itemstack.stackSize <= 0)
                {
                    return event.result;
                }

                if (!player.inventory.addItemStackToInventory(event.result))
                {
                    player.dropPlayerItemWithRandomChoice(event.result, false);
                }

                return itemstack;
            }
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!world.canMineBlock(player, i, j, k))
                {
                    return itemstack;
                }

                if (flag)
                {
                    if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemstack))
                    {
                        return itemstack;
                    }

                    Material material = world.getBlock(i, j, k).getMaterial();
                    int l = world.getBlockMetadata(i, j, k);

                    if(this.canLava){
                        if (material == Material.water && l == 0)
                        {
                            world.setBlockToAir(i, j, k);
                            return this.func_150910_a(itemstack, player, ModItems.steel_bucket_water);
                        }

                        if (material == Material.lava && l == 0)
                        {
                            world.setBlockToAir(i, j, k);
                            return this.func_150910_a(itemstack, player, ModItems.steel_bucket_lava);
                        }
                    } else {
                        if (material == Material.water && l == 0)
                        {
                            world.setBlockToAir(i, j, k);
                            return this.func_150910_a(itemstack, player, ModItems.wood_bucket_water);
                        }

                        if (material == Material.lava && l == 0)
                        {
                		    world.playSoundAtEntity(player, "random.fizz", 1.0F, 2.0F);  
                		    world.playSoundAtEntity(player, "fire.fire", 1.0F, 0.5F);                        	
                            return new ItemStack(ModItems.ashes);
                        }
                    }
                    
                }
                else
                {
                    if (this.isFull == Blocks.air)
                    {
                    	Item empty = ModItems.wood_bucket;
                    	if(this.canLava) empty = ModItems.steel_bucket;
                        return new ItemStack(empty);
                    }

                    if (movingobjectposition.sideHit == 0)
                    {
                        --j;
                    }

                    if (movingobjectposition.sideHit == 1)
                    {
                        ++j;
                    }

                    if (movingobjectposition.sideHit == 2)
                    {
                        --k;
                    }

                    if (movingobjectposition.sideHit == 3)
                    {
                        ++k;
                    }

                    if (movingobjectposition.sideHit == 4)
                    {
                        --i;
                    }

                    if (movingobjectposition.sideHit == 5)
                    {
                        ++i;
                    }

                    if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemstack))
                    {
                        return itemstack;
                    }

                    if (this.tryPlaceContainedLiquid(world, i, j, k) && !player.capabilities.isCreativeMode)
                    {
                    	Item empty = ModItems.wood_bucket;
                    	if(this.canLava) empty = ModItems.steel_bucket;
                        return new ItemStack(empty);
                    }
                }
            }

            return itemstack;
        }
    }

    private ItemStack func_150910_a(ItemStack itemstack, EntityPlayer player, Item filledbucket)
    {
        if (player.capabilities.isCreativeMode)
        {
            return itemstack;
        }
        else if (--itemstack.stackSize <= 0)
        {
            return new ItemStack(filledbucket);
        }
        else
        {
            if (!player.inventory.addItemStackToInventory(new ItemStack(filledbucket)))
            {
                player.dropPlayerItemWithRandomChoice(new ItemStack(filledbucket, 1, 0), false);
            }

            return itemstack;
        }
    }

    /**
     * Attempts to place the liquid contained inside the bucket.
     */
    public boolean tryPlaceContainedLiquid(World world, int x, int y, int z)
    {
        if (this.isFull == Blocks.air)
        {
            return false;
        }
        else
        {
            Material material = world.getBlock(x, y, z).getMaterial();
            boolean flag = !material.isSolid();

            if (!world.isAirBlock(x, y, z) && !flag)
            {
                return false;
            }
            else
            {
                if (world.provider.isHellWorld && this.isFull == Blocks.flowing_water)
                {
                    world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

                    for (int l = 0; l < 8; ++l)
                    {
                        world.spawnParticle("largesmoke", (double)x + Math.random(), (double)y + Math.random(), (double)z + Math.random(), 0.0D, 0.0D, 0.0D);
                    }
                }
                else
                {
                    if (!world.isRemote && flag && !material.isLiquid() && world.getBlock(x,y,z) != Blocks.fire)
                    {
                        world.func_147480_a(x, y, z, true);
                    }
                    
                    int didSomeWaterEvaporate = 0;
                    
                    if((world.getBlock(x, y, z) == Blocks.fire) && this.isFull == Blocks.flowing_water)
                    {
                        world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "random.fizz", 1.0F, 0.5F );
                        for (int l = 0; l < 8; ++l)
                        {
                            world.spawnParticle("largesmoke", (double)x + Math.random(), (double)y + Math.random(), (double)z + Math.random(), 0.0D, 0.0D, 0.0D);
                        }
                        didSomeWaterEvaporate = 1;
                        this.attemptToCrackStone(world, x+1, y, z);
                        this.attemptToCrackStone(world, x-1, y, z);
                        this.attemptToCrackStone(world, x, y+1, z);
                        this.attemptToCrackStone(world, x, y-1, z);
                        this.attemptToCrackStone(world, x, y, z+1);
                        this.attemptToCrackStone(world, x, y, z-1);
                    }
                    
                    world.setBlock(x, y, z, this.isFull, didSomeWaterEvaporate, 3);
                }

                return true;
            }
        }
    }
    
    private void attemptToCrackStone(World world, int x, int y, int z){
    	if(world.getBlock(x, y, z) == Blocks.cobblestone){
    		world.setBlock(x, y, z, Blocks.air, 0, 3);
    		if(!world.isRemote)
    			{
    			EntityItem rockdrop = new EntityItem(world, x, y, z, new ItemStack(ModItems.rock, Item.itemRand.nextInt(3) + 2, 0));
    			world.spawnEntityInWorld(rockdrop);
    			}
    		}
    	if(world.getBlock(x, y, z) == Blocks.stone){
    		world.setBlock(x, y, z, Blocks.cobblestone, 0, 3);
    	}
    }
}