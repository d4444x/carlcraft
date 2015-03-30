package com.fynal.gui;

import org.lwjgl.opengl.GL11;

import com.fynal.inventory.ContainerVat;
import com.fynal.lib.Ref;
import com.fynal.tile_entity.TileEntityVat;

import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GUIVat extends GuiContainer{
	
	private static final ResourceLocation vatGuiTextures = new ResourceLocation(Ref.MODID+":textures/gui/container/vat.png");
	private TileEntityVat tileVat;
	
	public GUIVat(InventoryPlayer invPlayer, TileEntityVat tile) {
		super(new ContainerVat(invPlayer, tile));
		this.tileVat = tile;
		
	}
	
	protected void drawGuiContainerForegroundLayer(int par1, int par2){
		String string = this.tileVat.hasCustomInventoryName() ? this.tileVat.getInventoryName() : I18n.format(this.tileVat.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(string, this.xSize / 2 - this.fontRendererObj.getStringWidth(string) / 2, 6, 4210752);//product of grovsey maths
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 94, 4210752);//product of grovsey maths
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(vatGuiTextures);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		if(this.tileVat.isProcessing()){
            int i1 = this.tileVat.getProcessProgressScaled(24);
            this.drawTexturedModalRect(k + 76, l + 26, 176, 14, i1 + 1, 16);
		}
	}

}
