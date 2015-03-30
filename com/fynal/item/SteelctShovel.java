package com.fynal.item;

import net.minecraft.item.ItemSpade;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class SteelctShovel extends ItemSpade{

 protected SteelctShovel(ToolMaterial material) {
  super(material);
 }

public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
par3List.add("Titanium-Carbon Alloy");
}
}