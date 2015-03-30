package com.fynal.item;

import net.minecraft.item.ItemAxe;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class SteelccAxe extends ItemAxe{

 protected SteelccAxe(ToolMaterial material) {
  super(material);
 }

public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
par3List.add("High-Carbon Alloy");
}
}