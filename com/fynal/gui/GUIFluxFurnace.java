package com.fynal.gui;

import org.lwjgl.opengl.GL11;

import com.fynal.inventory.ContainerFluxFurnace;
import com.fynal.lib.Ref;
import com.fynal.tile_entity.TileEntityFluxFurnace;

import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GUIFluxFurnace extends GuiContainer{
	
	private static final ResourceLocation fluxFurnaceGuiTextures = new ResourceLocation(Ref.MODID+":textures/gui/container/fluxfurnace.png");
	private TileEntityFluxFurnace tileFurnace;
	
	public GUIFluxFurnace(InventoryPlayer invPlayer, TileEntityFluxFurnace tile) {
		super(new ContainerFluxFurnace(invPlayer, tile));
		this.tileFurnace = tile;
		
	}
	
	protected void drawGuiContainerForegroundLayer(int par1, int par2){
		String string = this.tileFurnace.hasCustomInventoryName() ? this.tileFurnace.getInventoryName() : I18n.format(this.tileFurnace.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(string, this.xSize / 2 - this.fontRendererObj.getStringWidth(string) / 2, 6, 4210752);//product of grovsey maths
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 94, 4210752);//product of grovsey maths
			
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(fluxFurnaceGuiTextures);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		if(this.tileFurnace.isBurning()){
            int i1 = this.tileFurnace.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
            i1 = this.tileFurnace.getCookProgressScaled(24);
            this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
            
            boolean isHot = false;
            if(this.tileFurnace.doesItemBurnHot(this.tileFurnace.getStackInSlot(5))){
            	isHot = true;
            }
            
            boolean isBellows = false;
            if(this.tileFurnace.isHotFromBellows()){
            	isBellows = true;
            }
            
            if(!isHot && !isBellows){
            	this.drawTexturedModalRect(k + 79 +62, l + 34 +13, 10, 0, 9, 1);
            }else
            if(isHot && isBellows){
            	this.drawTexturedModalRect(k + 79 +62, l + 34 -4, 10, 0, 9, 1);
            }
            else{
            	this.drawTexturedModalRect(k + 79 +62, l + 34 +5, 10, 0, 9, 1);
            }//TODO refuses to display any temp warmer than 1
		}else{
			this.drawTexturedModalRect(k + 79 +62, l + 34 +21, 10, 0, 9, 1);
		}
	}

}
