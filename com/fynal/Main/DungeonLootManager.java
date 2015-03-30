package com.fynal.Main;

import com.fynal.item.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

/* CATEGORIES:
 * MINESHAFT_CORRIDOR (bread, pumpkin seeds, melon seeds, iron ingot, coal, redstone, gold ingot, lapis lazuli, diamond, saddle, rails, iron pickaxe, enchanted book, iron horse armor)
 * PYRAMID_DESERT_CHEST (diamond, iron ingot, gold ingot, emerald, bone, rotten flesh, saddle, iron horse armor, golden horse armor, diamond horse armor, enchanted book)
 * PYRAMID_JUNGLE_CHEST (diamond, iron ingot, gold ingot, emerald, bone, rotten flesh, saddle, iron horse armor, golden horse armor, diamond horse armor, enchanted book)
 * PYRAMID_JUNGLE_DISPENSER (arrows)
 * STRONGHOLD_CORRIDOR (see STRONGHOLD_CROSSING. not sure which is which. this list covers both)
 * STRONGHOLD_LIBRARY (book, paper, empty map, compass, enchanted book)
 * STRONGHOLD_CROSSING (ender pearl, diamond, iron ingot, gold ingot, redstone, bread, apple, iron pickaxe, iron sword, iron chestplate, iron helmet, iron leggings, iron boots, golden apple, saddle, iron horse armor, golden horse armor, diamond horse armor, enchanted book)
 * VILLAGE_BLACKSMITH (bread, apple, iron ingot, iron sword, iron pickaxe, iron helmet, iron chestplate, iron leggings, iron boots, oak sapling, obsidian, gold ingot, diamond, saddle, iron horse armor, gold horse armor, diamond horse armor)
 * BONUS_CHEST (stick, oak wood planks, oak wood, acacia wood, wooden axe, wooden pickaxe, apple, stone axe, stone pickaxe, bread)
 * DUNGEON_CHEST (saddle, iron ingot, bread, wheat, gunpowder, string, bucket, golden apple, redstone, 13 disk, cat disk, name tag, iron horse armor, golden horse armor, diamond horse armor, enchanted book)
 */

public class DungeonLootManager {

	public static void removeLoot(){
		//MINESHAFT
		ChestGenHooks.removeItem("mineshaftCorridor", new ItemStack(Items.iron_ingot, 1, -1));
		ChestGenHooks.removeItem("mineshaftCorridor", new ItemStack(Items.gold_ingot, 1, -1));
		ChestGenHooks.removeItem("mineshaftCorridor", new ItemStack(Items.diamond, 1, -1));
		ChestGenHooks.removeItem("mineshaftCorridor", new ItemStack(Items.iron_pickaxe, 1, -1));
		ChestGenHooks.removeItem("mineshaftCorridor", new ItemStack(Items.enchanted_book, 1, -1));
		
		//DESERT PYRAMID
		ChestGenHooks.removeItem("pyramidDesertyChest", new ItemStack(Items.iron_ingot, 1, -1));
		ChestGenHooks.removeItem("pyramidDesertyChest", new ItemStack(Items.gold_ingot, 1, -1));
		ChestGenHooks.removeItem("pyramidDesertyChest", new ItemStack(Items.diamond, 1, -1));
		ChestGenHooks.removeItem("pyramidDesertyChest", new ItemStack(Items.iron_pickaxe, 1, -1));
		ChestGenHooks.removeItem("pyramidDesertyChest", new ItemStack(Items.enchanted_book, 1, -1));
		
		//JUNGLE TEMPLE
		ChestGenHooks.removeItem("pyramidJungleChest", new ItemStack(Items.iron_ingot, 1, -1));
		ChestGenHooks.removeItem("pyramidJungleChest", new ItemStack(Items.gold_ingot, 1, -1));
		ChestGenHooks.removeItem("pyramidJungleChest", new ItemStack(Items.diamond, 1, -1));
		ChestGenHooks.removeItem("pyramidJungleChest", new ItemStack(Items.iron_pickaxe, 1, -1));
		ChestGenHooks.removeItem("pyramidJungleChest", new ItemStack(Items.enchanted_book, 1, -1));
		
		//STRONGHOLD
		ChestGenHooks.removeItem("strongholdCorridor", new ItemStack(Items.iron_ingot, 1, -1));
		ChestGenHooks.removeItem("strongholdCorridor", new ItemStack(Items.gold_ingot, 1, -1));
		ChestGenHooks.removeItem("strongholdCorridor", new ItemStack(Items.diamond, 1, -1));
		ChestGenHooks.removeItem("strongholdCorridor", new ItemStack(Items.iron_pickaxe, 1, -1));
		ChestGenHooks.removeItem("strongholdCorridor", new ItemStack(Items.enchanted_book, 1, -1));
		ChestGenHooks.removeItem("strongholdCorridor", new ItemStack(Items.iron_chestplate, 1, -1));
		ChestGenHooks.removeItem("strongholdCorridor", new ItemStack(Items.iron_leggings, 1, -1));
		ChestGenHooks.removeItem("strongholdCorridor", new ItemStack(Items.iron_boots, 1, -1));
		ChestGenHooks.removeItem("strongholdCorridor", new ItemStack(Items.iron_helmet, 1, -1));
		ChestGenHooks.removeItem("strongholdCorridor", new ItemStack(Items.iron_sword, 1, -1));
		ChestGenHooks.removeItem("strongholdCorridor", new ItemStack(Items.iron_pickaxe, 1, -1));
		
		ChestGenHooks.removeItem("strongholdCrossing", new ItemStack(Items.iron_ingot, 1, -1));
		ChestGenHooks.removeItem("strongholdCrossing", new ItemStack(Items.gold_ingot, 1, -1));
		ChestGenHooks.removeItem("strongholdCrossing", new ItemStack(Items.diamond, 1, -1));
		ChestGenHooks.removeItem("strongholdCrossing", new ItemStack(Items.iron_pickaxe, 1, -1));
		ChestGenHooks.removeItem("strongholdCrossing", new ItemStack(Items.enchanted_book, 1, -1));
		ChestGenHooks.removeItem("strongholdCrossing", new ItemStack(Items.iron_chestplate, 1, -1));
		ChestGenHooks.removeItem("strongholdCrossing", new ItemStack(Items.iron_leggings, 1, -1));
		ChestGenHooks.removeItem("strongholdCrossing", new ItemStack(Items.iron_boots, 1, -1));
		ChestGenHooks.removeItem("strongholdCrossing", new ItemStack(Items.iron_helmet, 1, -1));
		ChestGenHooks.removeItem("strongholdCrossing", new ItemStack(Items.iron_sword, 1, -1));
		ChestGenHooks.removeItem("strongholdCrossing", new ItemStack(Items.iron_pickaxe, 1, -1));
		
		//VILLAGE BLACKSMITH
		ChestGenHooks.removeItem("villageBlacksmith", new ItemStack(Items.iron_ingot, 1, -1));
		ChestGenHooks.removeItem("villageBlacksmith", new ItemStack(Items.gold_ingot, 1, -1));
		ChestGenHooks.removeItem("villageBlacksmith", new ItemStack(Items.diamond, 1, -1));
		ChestGenHooks.removeItem("villageBlacksmith", new ItemStack(Items.iron_pickaxe, 1, -1));
		ChestGenHooks.removeItem("villageBlacksmith", new ItemStack(Items.enchanted_book, 1, -1));
		ChestGenHooks.removeItem("villageBlacksmith", new ItemStack(Items.iron_chestplate, 1, -1));
		ChestGenHooks.removeItem("villageBlacksmith", new ItemStack(Items.iron_leggings, 1, -1));
		ChestGenHooks.removeItem("villageBlacksmith", new ItemStack(Items.iron_boots, 1, -1));
		ChestGenHooks.removeItem("villageBlacksmith", new ItemStack(Items.iron_helmet, 1, -1));
		ChestGenHooks.removeItem("villageBlacksmith", new ItemStack(Items.iron_sword, 1, -1));
		ChestGenHooks.removeItem("villageBlacksmith", new ItemStack(Items.iron_pickaxe, 1, -1));
	
		ChestGenHooks.removeItem("villageBlacksmith", new ItemStack(Blocks.obsidian, 1, -1));
		
		//BONUS CHEST
		ChestGenHooks.removeItem("bonusChest", new ItemStack(Items.wooden_axe, 1, -1));
		ChestGenHooks.removeItem("bonusChest", new ItemStack(Items.wooden_pickaxe, 1, -1));
		ChestGenHooks.removeItem("bonusChest", new ItemStack(Items.stone_axe, 1, -1));
		ChestGenHooks.removeItem("bonusChest", new ItemStack(Items.stone_pickaxe, 1, -1));
		
		//DUNGEON
		ChestGenHooks.removeItem("dungeonChest", new ItemStack(Items.iron_ingot, 1, -1));
		ChestGenHooks.removeItem("dungeonChest", new ItemStack(Items.gold_ingot, 1, -1));
		ChestGenHooks.removeItem("dungeonChest", new ItemStack(Items.diamond, 1, -1));
		ChestGenHooks.removeItem("dungeonChest", new ItemStack(Items.iron_pickaxe, 1, -1));
		ChestGenHooks.removeItem("dungeonChest", new ItemStack(Items.enchanted_book, 1, -1));
		ChestGenHooks.removeItem("dungeonChest", new ItemStack(Items.bucket, 1, -1));
	}
	
	public static void addLoot(){
		
		//MINESHAFT
		ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.copper_nugget),1,10,100));
		ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.iron_nugget),1,10,100));
		ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.tin_nugget),1,5,40));
		ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.zinc_nugget),1,5,40));
		ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.nickel_nugget),1,3,10));
		ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.Coke),1,2,10));
		ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.hide),1,4,70));
		ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.sulfur),1,7,10));
		ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.ashes),1,10,10));
		ChestGenHooks.addItem("mineshaftCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.borax),1,7,10));
	
		//DESERT PYRAMID
		ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(new ItemStack(ModItems.copper_nugget),1,10,100));
		ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(new ItemStack(ModItems.iron_nugget),1,10,100));
		ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(new ItemStack(ModItems.tin_nugget),1,5,40));
		ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(new ItemStack(ModItems.zinc_nugget),1,5,40));
		ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(new ItemStack(ModItems.nickel_nugget),1,3,10));
		ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(new ItemStack(ModItems.Coke),1,2,10));
		ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(new ItemStack(ModItems.hide),1,4,70));
		ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(new ItemStack(ModItems.sulfur),1,7,10));
		ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(new ItemStack(ModItems.ashes),1,10,10));
		ChestGenHooks.addItem("pyramidDesertyChest", new WeightedRandomChestContent(new ItemStack(ModItems.borax),1,7,10));
		
		//JUNGLE TEMPLE
		ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(new ItemStack(ModItems.copper_nugget),1,10,100));
		ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(new ItemStack(ModItems.iron_nugget),1,10,100));
		ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(new ItemStack(ModItems.tin_nugget),1,5,40));
		ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(new ItemStack(ModItems.zinc_nugget),1,5,40));
		ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(new ItemStack(ModItems.nickel_nugget),1,3,10));
		ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(new ItemStack(ModItems.Coke),1,2,10));
		ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(new ItemStack(ModItems.hide),1,4,70));
		ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(new ItemStack(ModItems.sulfur),1,7,10));
		ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(new ItemStack(ModItems.ashes),1,10,10));
		ChestGenHooks.addItem("pyramidJungleChest", new WeightedRandomChestContent(new ItemStack(ModItems.borax),1,7,10));

		//STRONGHOLD
		ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.copper_nugget),1,10,100));
		ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.iron_nugget),1,10,100));
		ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.tin_nugget),1,5,40));
		ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.zinc_nugget),1,5,40));
		ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.nickel_nugget),1,3,10));
		ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.Coke),1,2,10));
		ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.hide),1,4,70));
		ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.sulfur),1,7,10));
		ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.ashes),1,10,10));
		ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(new ItemStack(ModItems.borax),1,7,10));
		ChestGenHooks.addItem("strongholdCorridor", new WeightedRandomChestContent(new ItemStack(Items.gold_nugget),1,5,40));

		ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(new ItemStack(ModItems.copper_nugget),1,10,100));
		ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(new ItemStack(ModItems.iron_nugget),1,10,100));
		ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(new ItemStack(ModItems.tin_nugget),1,5,40));
		ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(new ItemStack(ModItems.zinc_nugget),1,5,40));
		ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(new ItemStack(ModItems.nickel_nugget),1,3,10));
		ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(new ItemStack(ModItems.Coke),1,2,10));
		ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(new ItemStack(ModItems.hide),1,4,70));
		ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(new ItemStack(ModItems.sulfur),1,7,10));
		ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(new ItemStack(ModItems.ashes),1,10,10));
		ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(new ItemStack(ModItems.borax),1,7,10));
		ChestGenHooks.addItem("strongholdCrossing", new WeightedRandomChestContent(new ItemStack(Items.gold_nugget),1,5,40));
		
		//VILLAGE BLACKSMITH
		ChestGenHooks.addItem("villageBlacksmith", new WeightedRandomChestContent(new ItemStack(ModItems.copper_nugget),1,10,100));
		ChestGenHooks.addItem("villageBlacksmith", new WeightedRandomChestContent(new ItemStack(ModItems.iron_nugget),1,10,100));
		ChestGenHooks.addItem("villageBlacksmith", new WeightedRandomChestContent(new ItemStack(ModItems.tin_nugget),1,5,40));
		ChestGenHooks.addItem("villageBlacksmith", new WeightedRandomChestContent(new ItemStack(ModItems.zinc_nugget),1,5,40));
		ChestGenHooks.addItem("villageBlacksmith", new WeightedRandomChestContent(new ItemStack(ModItems.nickel_nugget),1,3,10));
		ChestGenHooks.addItem("villageBlacksmith", new WeightedRandomChestContent(new ItemStack(ModItems.Coke),1,2,10));
		ChestGenHooks.addItem("villageBlacksmith", new WeightedRandomChestContent(new ItemStack(ModItems.hide),1,4,70));
		ChestGenHooks.addItem("villageBlacksmith", new WeightedRandomChestContent(new ItemStack(ModItems.sulfur),1,7,10));
		ChestGenHooks.addItem("villageBlacksmith", new WeightedRandomChestContent(new ItemStack(ModItems.ashes),1,10,10));
		ChestGenHooks.addItem("villageBlacksmith", new WeightedRandomChestContent(new ItemStack(ModItems.borax),1,7,10));

		//BONUS CHEST
		ChestGenHooks.addItem("bonusChest", new WeightedRandomChestContent(new ItemStack(ModItems.copper_nugget),5,10,50));
		ChestGenHooks.addItem("bonusChest", new WeightedRandomChestContent(new ItemStack(ModItems.malachite),4,7,50));
		ChestGenHooks.addItem("bonusChest", new WeightedRandomChestContent(new ItemStack(Blocks.cobblestone),2,4,50));
		ChestGenHooks.addItem("bonusChest", new WeightedRandomChestContent(new ItemStack(Items.flint),2,3,50));
		
		//DUNGEON
		ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.copper_nugget),1,10,100));
		ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.iron_nugget),1,10,100));
		ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.tin_nugget),1,5,40));
		ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.zinc_nugget),1,5,40));
		ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.nickel_nugget),1,3,10));
		ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.Coke),1,2,10));
		ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.hide),1,4,70));
		ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.sulfur),1,7,10));
		ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.ashes),1,10,10));
		ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.borax),1,7,10));
		ChestGenHooks.addItem("dungeonChest", new WeightedRandomChestContent(new ItemStack(ModItems.wood_bucket),1,2,100));
	}
}
