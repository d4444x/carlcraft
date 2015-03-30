package com.fynal.item;

import net.minecraft.item.ItemSword;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class BrasszzSword extends ItemSword{

 protected BrasszzSword(ToolMaterial material) {
  super(material);
 }

public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
par3List.add("High-Zinc Alloy");
}
}