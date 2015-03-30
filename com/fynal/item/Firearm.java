package com.fynal.item;

import java.util.List;

import com.fynal.entity.EntityBullet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Firearm extends Item{

	private int loaded;
	private String material;//"tz" for bronze
	//"cn", "nb", "nt" for steel
	
	public Firearm(int loaded, int durability, String material){
		super();
		this.loaded = loaded;
		this.material = material;
        this.maxStackSize = 1;
		this.setMaxDamage(durability);

	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
		if(this.material == "cn") par3List.add("Nickel/Carbon Alloy");
		if(this.material == "nb") par3List.add("Nickel/Cobalt Alloy");
		if(this.material == "nt") par3List.add("Nickel/Titanium Alloy");
	}
	
	public int getLoaded(){
		return this.loaded;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack itemstack){
		return 72000;
	}
	
	private float inaccuracyFactor(){//returns the range of error for each material
		if(this.material == "tz") return 20.0F;
		if(this.material == "cn") return 5.0F;
		if(this.material == "nb") return 10.0F;
		if(this.material == "nt") return 0.5F;
		return 100.0F;
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
		if(this.loaded > 0){
		    world.playSoundAtEntity(player, "fire.ignite", 0.5F, 0.5F);
		    world.playSoundAtEntity(player, "fireworks.blast", 1.0F, (itemRand.nextFloat()));
		    if (!world.isRemote)
		    {	//y and p are two numbers, each between -1 and 1, which are weighted towards 0
		    	float y = 2*(itemstack.getItem().itemRand.nextFloat() - 0.5F)*(itemstack.getItem().itemRand.nextFloat() - 0.5F);
		    	float p = 2*(itemstack.getItem().itemRand.nextFloat() - 0.5F)*(itemstack.getItem().itemRand.nextFloat() - 0.5F);
		    	player.rotationYaw += (y*this.inaccuracyFactor());
		    	player.rotationPitch += p*this.inaccuracyFactor();
		    	EntityBullet bullet = new EntityBullet(world, player);
		    	bullet.setDamageAndSpeed(itemstack.getItem());
		        world.spawnEntityInWorld(bullet);
		    	player.rotationYaw -= (y*this.inaccuracyFactor());
		    	player.rotationPitch -= p*this.inaccuracyFactor();
		    }
            itemstack.damageItem(1, player);
            int broken = 1; //1 means return 1 firearm, as in the firearm isn't broken
            if(itemstack.getItemDamage() == 0) broken = 0;
            if(itemstack.getItem()==ModItems.pistol_1){
            	return new ItemStack(ModItems.pistol, broken, itemstack.getItemDamage());
            }
            if(itemstack.getItem()==ModItems.musket_1){
            	return new ItemStack(ModItems.musket, broken, itemstack.getItemDamage());
            }
            if(itemstack.getItem()==ModItems.cn_rifle_1){
            	return new ItemStack(ModItems.cn_rifle, broken, itemstack.getItemDamage());
            }
            if(itemstack.getItem()==ModItems.nb_rifle_1){
            	return new ItemStack(ModItems.nb_rifle, broken, itemstack.getItemDamage());
            }
            if(itemstack.getItem()==ModItems.nt_rifle_1){
            	return new ItemStack(ModItems.nt_rifle, broken, itemstack.getItemDamage());
            }
            if(itemstack.getItem()==ModItems.cn_revolver_1){
            	return new ItemStack(ModItems.cn_revolver, broken, itemstack.getItemDamage());
            }
            if(itemstack.getItem()==ModItems.cn_revolver_2){
            	return new ItemStack(ModItems.cn_revolver_1, broken, itemstack.getItemDamage());
            }
            if(itemstack.getItem()==ModItems.cn_revolver_3){
            	return new ItemStack(ModItems.cn_revolver_2, broken, itemstack.getItemDamage());
            }
            if(itemstack.getItem()==ModItems.cn_revolver_4){
            	return new ItemStack(ModItems.cn_revolver_3, broken, itemstack.getItemDamage());
            }
            if(itemstack.getItem()==ModItems.nb_revolver_1){
            	return new ItemStack(ModItems.nb_revolver, broken, itemstack.getItemDamage());
            }
            if(itemstack.getItem()==ModItems.nb_revolver_2){
            	return new ItemStack(ModItems.nb_revolver_1, broken, itemstack.getItemDamage());
            }
            if(itemstack.getItem()==ModItems.nb_revolver_3){
            	return new ItemStack(ModItems.nb_revolver_2, broken, itemstack.getItemDamage());
            }
            if(itemstack.getItem()==ModItems.nb_revolver_4){
            	return new ItemStack(ModItems.nb_revolver_3, broken, itemstack.getItemDamage());
            }
            if(itemstack.getItem()==ModItems.nt_revolver_1){
            	return new ItemStack(ModItems.nt_revolver, broken, itemstack.getItemDamage());
            }
            if(itemstack.getItem()==ModItems.nt_revolver_2){
            	return new ItemStack(ModItems.nt_revolver_1, broken, itemstack.getItemDamage());
            }
            if(itemstack.getItem()==ModItems.nt_revolver_3){
            	return new ItemStack(ModItems.nt_revolver_2, broken, itemstack.getItemDamage());
            }
            if(itemstack.getItem()==ModItems.nt_revolver_4){
            	return new ItemStack(ModItems.nt_revolver_3, broken, itemstack.getItemDamage());
            }
        } else {
            if (player.capabilities.isCreativeMode 
            		|| (player.inventory.hasItem(Items.gunpowder) && this.material == "tz" && this.loaded == 0)
            		|| (player.inventory.hasItem(ModItems.lead_nugget) && this.material == "tz" && this.loaded == -1)
        			|| (player.inventory.hasItem(ModItems.bullet) && (this.material == "cn" || this.material == "nb" || this.material == "nt") && this.loaded == 0))
            {
            	if(this.material == "tz" && this.loaded == 0) world.playSoundAtEntity(player, "coilcraft:gunpowder", 1.0F, 0.9F);
            	if(this.material == "tz" && this.loaded == -1) world.playSoundAtEntity(player, "coilcraft:leadnugget", 1.0F, 1.0F);
            	if(this.material == "cn" || this.material == "nb" || this.material == "nt") world.playSoundAtEntity(player, "coilcraft:reload", 1.0F, 0.6F);
            	player.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
            }
        }
			
		return itemstack;
	}
	
    public void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityPlayer player, int itemUseCountdown)
    {
    	int isSteel = 0;
    	if(this.material == "cn" || this.material == "nb" || this.material == "nt") isSteel = 5;
        if((this.getMaxItemUseDuration(itemstack) - itemUseCountdown) > (30 - isSteel) || player.capabilities.isCreativeMode){
    		if(this.loaded == -1){ //loading the lead nugget
                if(this.material == "tz" && !player.capabilities.isCreativeMode){
                	player.inventory.consumeInventoryItem(ModItems.lead_nugget);
                }
    		    world.playSoundAtEntity(player, "fire.ignite", 0.5F, 0.5F);
    	        if(itemstack.getItem()==ModItems.pistol_b){
    	        	this.setItemInHand(player, new ItemStack(ModItems.pistol_1, 1, itemstack.getItemDamage()));
    	        }
    	        if(itemstack.getItem()==ModItems.musket_b){
    	        	this.setItemInHand(player, new ItemStack(ModItems.musket_1, 1, itemstack.getItemDamage()));
    	        }
    		}
    		if(this.loaded == 0){ //loading the gunpowder(bronze)/bullet(steel)
    		    world.playSoundAtEntity(player, "fire.ignite", 0.5F, 0.5F);
                if(this.material == "tz" && !player.capabilities.isCreativeMode){
                	player.inventory.consumeInventoryItem(Items.gunpowder);
                }
    	        if(itemstack.getItem()==ModItems.pistol){
    			    this.setItemInHand(player, new ItemStack(ModItems.pistol_b, 1, itemstack.getItemDamage()));
    	        }
    	        if(itemstack.getItem()==ModItems.musket){
    	        	this.setItemInHand(player, new ItemStack(ModItems.musket_b, 1, itemstack.getItemDamage()));
    	        }
                if((this.material == "cn" || this.material == "nb" || this.material == "nt") && !player.capabilities.isCreativeMode){
                	player.inventory.consumeInventoryItem(ModItems.bullet);
                }
    	        if(itemstack.getItem()==ModItems.cn_rifle){
    	        	this.setItemInHand(player, new ItemStack(ModItems.cn_rifle_1, 1, itemstack.getItemDamage()));
    	        }
    	        if(itemstack.getItem()==ModItems.nb_rifle){
    	        	this.setItemInHand(player, new ItemStack(ModItems.nb_rifle_1, 1, itemstack.getItemDamage()));
    	        }
    	        if(itemstack.getItem()==ModItems.nt_rifle){
    	        	this.setItemInHand(player, new ItemStack(ModItems.nt_rifle_1, 1, itemstack.getItemDamage()));
    	        }
    	        int b;
    	        if(player.capabilities.isCreativeMode){
    	        	b = 4;
    	        }else{
        	        for(b = 1; player.inventory.hasItem(ModItems.bullet) && b<4; b++){
                    	player.inventory.consumeInventoryItem(ModItems.bullet);
        	        }
    	        }
    	        if(itemstack.getItem()==ModItems.cn_revolver){
    	        	if(b==1) this.setItemInHand(player, new ItemStack(ModItems.cn_revolver_1, 1, itemstack.getItemDamage()));
    	        	if(b==2) this.setItemInHand(player, new ItemStack(ModItems.cn_revolver_2, 1, itemstack.getItemDamage()));
    	        	if(b==3) this.setItemInHand(player, new ItemStack(ModItems.cn_revolver_3, 1, itemstack.getItemDamage()));
    	        	if(b==4) this.setItemInHand(player, new ItemStack(ModItems.cn_revolver_4, 1, itemstack.getItemDamage()));
    	        }
    	        if(itemstack.getItem()==ModItems.nb_revolver){
    	        	if(b==1) this.setItemInHand(player, new ItemStack(ModItems.nb_revolver_1, 1, itemstack.getItemDamage()));
    	        	if(b==2) this.setItemInHand(player, new ItemStack(ModItems.nb_revolver_2, 1, itemstack.getItemDamage()));
    	        	if(b==3) this.setItemInHand(player, new ItemStack(ModItems.nb_revolver_3, 1, itemstack.getItemDamage()));
    	        	if(b==4) this.setItemInHand(player, new ItemStack(ModItems.nb_revolver_4, 1, itemstack.getItemDamage()));
    	        }
    	        if(itemstack.getItem()==ModItems.nt_revolver){
    	        	if(b==1) this.setItemInHand(player, new ItemStack(ModItems.nt_revolver_1, 1, itemstack.getItemDamage()));
    	        	if(b==2) this.setItemInHand(player, new ItemStack(ModItems.nt_revolver_2, 1, itemstack.getItemDamage()));
    	        	if(b==3) this.setItemInHand(player, new ItemStack(ModItems.nt_revolver_3, 1, itemstack.getItemDamage()));
    	        	if(b==4) this.setItemInHand(player, new ItemStack(ModItems.nt_revolver_4, 1, itemstack.getItemDamage()));
    	        }
    	        
    		}
        }
    }
    
    private void setItemInHand(EntityPlayer player, ItemStack itemstack){
		player.inventory.mainInventory[player.inventory.currentItem] = itemstack;
    }
    
    public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player)
    {
        return itemstack;
    }
	
    public EnumAction getItemUseAction(ItemStack itemstack)
    {
    	return EnumAction.block;
    }
}
