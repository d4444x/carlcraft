package com.fynal.entity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.fynal.item.ModItems;
import com.fynal.lib.Ref;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPotion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

public class RenderBullet extends Render{

	@Override
	public void doRender(Entity entity, double par2, double par4, double par6, float par8, float par9) {

		IIcon iicon = ModItems.bullet_entity.getIconFromDamage(0);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        this.bindEntityTexture(entity);
        Tessellator tessellator = Tessellator.instance;
        float f = 0.0F;//minecraft draws item textures from one giant texture, 
        float f1 = 1.0F;//so these values are tiny in vanilla. however, here, we need
        float f2 = 1.0F;//to render the entire 16x16 texture, not one tiny bit of the
        float f3 = 0.0F;//512x512 'atlas' texture. hence values of f, f1, f2, f3
        float f4 = 1.0F;
        float f5 = 0.5F;
        float f6 = 0.25F;
        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV((double)(0.0F - f5), (double)(0.0F - f6), 0.0D, (double)f, (double)f3);
        tessellator.addVertexWithUV((double)(f4 - f5), (double)(0.0F - f6), 0.0D, (double)f1, (double)f3);
        tessellator.addVertexWithUV((double)(f4 - f5), (double)(f4 - f6), 0.0D, (double)f1, (double)f2);
        tessellator.addVertexWithUV((double)(0.0F - f5), (double)(f4 - f6), 0.0D, (double)f, (double)f2);
        tessellator.draw();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation(Ref.MODID, "textures/items/bullet_entity.png");
	} 

}
