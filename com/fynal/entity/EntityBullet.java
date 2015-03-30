package com.fynal.entity;

import com.fynal.item.ModItems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBullet extends EntityThrowable
{
	private float damage;
	
    public EntityBullet(World world)
    {
        super(world);
    }
    public EntityBullet(World world, EntityLivingBase EntityLivingBase)
    {
        super(world, EntityLivingBase);
    }
    public void setDamageAndSpeed(Item gun)
    {
    	if(gun==ModItems.pistol_1){
    		this.damage = 15;
        	this.motionX *= 1.3;
        	this.motionY *= 1.3;
        	this.motionZ *= 1.3;
    	}
        if(gun==ModItems.musket_1){
        	this.damage = 25;	
        	this.motionX *= 1.6;
        	this.motionY *= 1.6;
        	this.motionZ *= 1.6;
        }
        if(gun==ModItems.cn_rifle_1){
        	this.damage = 40;	
        	this.motionX *= 2.0;
        	this.motionY *= 2.0;
        	this.motionZ *= 2.0;
        }
        if(gun==ModItems.nb_rifle_1){
        	this.damage = 40;	
        	this.motionX *= 1.8;
        	this.motionY *= 1.8;
        	this.motionZ *= 1.8;
        }
        if(gun==ModItems.nt_rifle_1){
        	this.damage = 40;	
        	this.motionX *= 2.5;//don't increace speeds any more than this. math gets inaccurate, propogation errors trash accuracy.
        	this.motionY *= 2.5;
        	this.motionZ *= 2.5;
        }
        if(gun==ModItems.cn_revolver_1 || gun==ModItems.cn_revolver_2 || gun==ModItems.cn_revolver_3 || gun==ModItems.cn_revolver_4){
        	this.damage = 15;	
        	this.motionX *= 1.8;
        	this.motionY *= 1.8;
        	this.motionZ *= 1.8;
        }
        if(gun==ModItems.nb_revolver_1 || gun==ModItems.nb_revolver_2 || gun==ModItems.nb_revolver_3 || gun==ModItems.nb_revolver_4){
        	this.damage = 15;	
        	this.motionX *= 1.6;
        	this.motionY *= 1.6;
        	this.motionZ *= 1.6;
        }
        if(gun==ModItems.nt_revolver_1 || gun==ModItems.nt_revolver_2 || gun==ModItems.nt_revolver_3 || gun==ModItems.nt_revolver_4){
        	this.damage = 15;	
        	this.motionX *= 2.1;
        	this.motionY *= 2.1;
        	this.motionZ *= 2.1;
        }
    }
    public EntityBullet(World world, double par2, double par4, double par6)
    {
        super(world, par2, par4, par6);
    }
    @Override
    protected void onImpact(MovingObjectPosition par1){
        if (par1.entityHit != null)
        {
            par1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}