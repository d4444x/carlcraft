package com.fynal.item;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Firestarter extends Item
{
    private static final String __OBFID = "CL_00000035";
	private int successChance;

    public Firestarter(int durability, int successChance)
    {
        this.maxStackSize = 1;
        this.setMaxDamage(durability);
        this.successChance = successChance;
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int direction, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (direction == 0)
        {
            --y;
        }

        if (direction == 1)
        {
            ++y;
        }

        if (direction == 2)
        {
            --z;
        }

        if (direction == 3)
        {
            ++z;
        }

        if (direction == 4)
        {
            --x;
        }

        if (direction == 5)
        {
            ++x;
        }

        if (!player.canPlayerEdit(x, y, z, direction, itemstack))
        {
            return false;
        }
        else
        {
            if (world.isAirBlock(x, y, z))
            {
                world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                if(Item.itemRand.nextInt(100) < this.successChance){
                    world.setBlock(x, y, z, Blocks.fire);
                }
            }

            itemstack.damageItem(1, player);
            return true;
        }
    }
}
