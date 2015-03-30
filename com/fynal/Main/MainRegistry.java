package com.fynal.Main;

import java.lang.reflect.Field;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.MinecraftForge;

import com.fynal.block.ModBlocks;
import com.fynal.entity.EntityInitializer;
import com.fynal.handler.LivingEntityHandler;
import com.fynal.handler.OreGenSuppressor;
import com.fynal.handler.fuelhandler;
import com.fynal.item.ModItems;
import com.fynal.item.ModTools;
import com.fynal.lib.Ref;
import com.fynal.world.ModWorld;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.ExistingSubstitutionException;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Ref.MODID , name = Ref.NAME , version = Ref.VERSION)
public class MainRegistry {

	@SidedProxy(clientSide = Ref.CLIENTSIDE, serverSide = Ref.SERVERSIDE)
	public static ServerProxy proxy;
	
	@EventHandler
	public static void preLoad(FMLPreInitializationEvent PreEvent){
		proxy.registerRenderInfo();
		proxy.registerTileEntities();
		proxy.registerKeybindings();
		ModItems.mainRegistry();
		ModBlocks.mainRegistry();
		ModTools.mainRegistry();
		EntityInitializer.mainRegistry();
		CraftingManager.mainRegistry();
		ToolCraftingManager.mainRegistry();
		ModWorld.mainRegistry();
		GameRegistry.registerFuelHandler(new fuelhandler());
		RecipeRemover.removeRecipe();
		DungeonLootManager.removeLoot();
		DungeonLootManager.addLoot();
	}
	@EventHandler
	public static void load(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new LivingEntityHandler());
		MinecraftForge.ORE_GEN_BUS.register(new OreGenSuppressor());
		proxy.registerNetworkStuff();
	}
	@EventHandler
	public static void PostLoad(FMLPostInitializationEvent PostEvent){

	}
	
	@Instance(Ref.MODID)
	public static MainRegistry modInstance;
}
