package com.fynal.block;

import com.fynal.lib.Ref;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.registry.ExistingSubstitutionException;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block groundRock;
	public static Block groundStick;
	public static Block groundFlint;
	public static Block groundCopperNugget;
	public static Block groundGoldNugget;
	public static Block groundMeteorite1;
	public static Block groundMeteorite2;
	public static Block groundMeteorite3;
	public static Block groundMeteorite4;
	public static Block groundSulfur;
	
	public static Block woodPile;
	public static Block woodPileActive;
	public static Block woodPileCharred;
	public static Block CoalBlock;
	public static Block CoalBlockActive;
	public static Block CharcoalBlock;
	public static Block CharcoalBlockActive;
	public static Block CokeBlock;
	
	public static Block FluxFurnace;
	public static Block FluxFurnaceActive;
	public static Block Vat;
	public static Block Bellows;
	
	public static Block DesertLapisOre;
	public static Block MalachiteOre;
	public static Block PyriteOre;
	public static Block Peat;
	public static Block FossilOre;
	public static Block CopperOre;
	public static Block LeadOre;
	public static Block TinOre;
	public static Block ZincOre;
	public static Block NickelOre;
	public static Block CobaltOre;
	public static Block TitaniumOre;
	public static Block SaltpeterOre;
	public static Block CopperBlock;
	public static Block LeadBlock;
	public static Block BoraxOre;
	
	public static void mainRegistry() {		
		initializeBlock();
		registerBlock();
		initializeFire();
	}

	public static void initializeBlock(){	
/*		try {
			GameRegistry.addSubstitutionAlias("minecraft:fire", GameRegistry.Type.BLOCK, (new coilfire()).setHardness(0.0F).setLightLevel(0.0F).setStepSound(Block.soundTypeWood).setBlockName("fire").setBlockTextureName("fire"));
			GameRegistry.addSubstitutionAlias("minecraft:fire", GameRegistry.Type.ITEM, (new ItemBlock(Blocks.fire)));
		} catch (ExistingSubstitutionException e) {
			e.printStackTrace();
		}
*/		
//		Block.blockRegistry.addObject(51, "fire", (new coilfire()).setHardness(0.0F).setLightLevel(0.0F).setStepSound(Block.soundTypeWood).setBlockName("fire").setBlockTextureName("fire"));
//		Block fire = new coilfire().setHardness(0.0F).setLightLevel(1.0F).setStepSound(Block.soundTypeWood).setBlockName("fire").setBlockTextureName("fire");
				
		groundRock = new groundSpawn(Material.plants).setBlockName("groundRock").setCreativeTab(CreativeTabs.tabDecorations).setBlockTextureName(Ref.MODID + ":ground_rock");
		groundStick = new groundSpawn(Material.plants).setBlockName("groundStick").setCreativeTab(CreativeTabs.tabDecorations).setBlockTextureName(Ref.MODID + ":ground_stick");
		groundFlint = new groundSpawn(Material.plants).setBlockName("groundFlint").setCreativeTab(CreativeTabs.tabDecorations).setBlockTextureName(Ref.MODID + ":ground_flint");
		groundCopperNugget = new groundSpawn(Material.plants).setBlockName("groundCopperNugget").setCreativeTab(CreativeTabs.tabDecorations).setBlockTextureName(Ref.MODID + ":ground_copper_nugget");
		groundGoldNugget = new groundSpawn(Material.plants).setBlockName("groundGoldNugget").setCreativeTab(CreativeTabs.tabDecorations).setBlockTextureName(Ref.MODID + ":ground_gold_nugget");
		groundMeteorite1 = new groundSpawn(Material.plants).setBlockName("groundMeteorite1").setCreativeTab(CreativeTabs.tabDecorations).setBlockTextureName(Ref.MODID + ":ground_meteorite_1");
		groundMeteorite2 = new groundSpawn(Material.plants).setBlockName("groundMeteorite2").setCreativeTab(CreativeTabs.tabDecorations).setBlockTextureName(Ref.MODID + ":ground_meteorite_2");
		groundMeteorite3 = new groundSpawn(Material.plants).setBlockName("groundMeteorite3").setCreativeTab(CreativeTabs.tabDecorations).setBlockTextureName(Ref.MODID + ":ground_meteorite_3");
		groundMeteorite4 = new groundSpawn(Material.plants).setBlockName("groundMeteorite4").setCreativeTab(CreativeTabs.tabDecorations).setBlockTextureName(Ref.MODID + ":ground_meteorite_4");
		groundSulfur = new groundSpawn(Material.plants).setBlockName("groundSulfur").setCreativeTab(CreativeTabs.tabDecorations).setBlockTextureName(Ref.MODID + ":ground_sulfur");

		FluxFurnace = new FluxFurnace(false).setBlockName("FluxFurnace").setCreativeTab(CreativeTabs.tabDecorations);
		FluxFurnaceActive = new FluxFurnace(true).setBlockName("FluxFurnaceActive").setLightLevel(0.866F);
		Vat = new Vat(Material.wood).setBlockName("Vat").setCreativeTab(CreativeTabs.tabDecorations);
		Bellows = new Bellows(Material.wood).setBlockName("Bellows").setCreativeTab(CreativeTabs.tabDecorations);
		
		CharcoalBlock = new CharcoalBlock(Material.rock).setBlockName("CharcoalBlock").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":charcoal_block");
		CharcoalBlockActive = new CharcoalBlockActive(Material.rock).setBlockName("CharcoalBlockActive").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":charcoal_block_active");
		CoalBlock = new CharcoalBlock(Material.rock).setBlockName("CoalBlock").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":coal_block");
		CoalBlockActive = new CharcoalBlockActive(Material.rock).setBlockName("CoalBlockActive").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":coal_block_active");		
		CokeBlock = new CokeBlock(Material.rock).setBlockName("CokeBlock").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":coke_block");
		woodPile = new WoodPile(Material.wood).setBlockName("woodPile").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":wood_pile");
		woodPileActive = new WoodPileActive(Material.wood).setBlockName("woodPileActive").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":wood_pile_active");
		woodPileCharred = new WoodPileCharred(Material.wood).setBlockName("woodPileCharred").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":wood_pile_charred");
		
		DesertLapisOre = new DesertLapisOre(Material.rock).setBlockName("DesertLapisOre").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":desert_lapis_ore");
		BoraxOre = new BoraxOre(Material.rock).setBlockName("BoraxOre").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":borax_ore");
		MalachiteOre = new MalachiteOre(Material.rock).setBlockName("MalachiteOre").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":malachite_ore");
		PyriteOre = new PyriteOre(Material.rock).setBlockName("PyriteOre").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":pyrite_ore");
		Peat = new Peat(Material.rock).setBlockName("Peat").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":peat");
		FossilOre = new FossilOre(Material.rock).setBlockName("FossilOre").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":fossil_ore");
		CopperOre = new CopperBlock(Material.rock).setBlockName("CopperOre").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":copper_ore");
		LeadOre = new LeadOre(Material.rock).setBlockName("LeadOre").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":lead_ore");
		TinOre = new TinOre(Material.rock).setBlockName("TinOre").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":tin_ore");
		ZincOre = new ZincOre(Material.rock).setBlockName("ZincOre").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":zinc_ore");
		NickelOre = new NickelOre(Material.rock).setBlockName("NickelOre").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":nickel_ore");
		CobaltOre = new CobaltOre(Material.rock).setBlockName("CobaltOre").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":cobalt_ore");
		TitaniumOre = new TitaniumOre(Material.rock).setBlockName("TitaniumOre").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":titanium_ore");
		SaltpeterOre = new SaltpeterOre(Material.rock).setBlockName("SaltpeterOre").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":saltpeter_ore");
		CopperBlock = new CopperBlock(Material.rock).setBlockName("CopperBlock").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":copper_block");
		LeadBlock = new LeadBlock(Material.rock).setBlockName("LeadBlock").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(Ref.MODID + ":lead_block");
	}
	
	public static void registerBlock(){
		GameRegistry.registerBlock(groundRock, groundRock.getUnlocalizedName());
		GameRegistry.registerBlock(groundStick, groundStick.getUnlocalizedName());
		GameRegistry.registerBlock(groundFlint, groundFlint.getUnlocalizedName());
		GameRegistry.registerBlock(groundCopperNugget, groundCopperNugget.getUnlocalizedName());
		GameRegistry.registerBlock(groundGoldNugget, groundGoldNugget.getUnlocalizedName());
		GameRegistry.registerBlock(groundMeteorite1, groundMeteorite1.getUnlocalizedName());
		GameRegistry.registerBlock(groundMeteorite2, groundMeteorite2.getUnlocalizedName());
		GameRegistry.registerBlock(groundMeteorite3, groundMeteorite3.getUnlocalizedName());
		GameRegistry.registerBlock(groundMeteorite4, groundMeteorite4.getUnlocalizedName());
		GameRegistry.registerBlock(groundSulfur, groundSulfur.getUnlocalizedName());
		
		GameRegistry.registerBlock(FluxFurnace, FluxFurnace.getUnlocalizedName());	
		GameRegistry.registerBlock(FluxFurnaceActive, FluxFurnaceActive.getUnlocalizedName());
		GameRegistry.registerBlock(Vat, Vat.getUnlocalizedName());
		GameRegistry.registerBlock(Bellows, Bellows.getUnlocalizedName());

		GameRegistry.registerBlock(CharcoalBlock, CharcoalBlock.getUnlocalizedName());
		GameRegistry.registerBlock(CharcoalBlockActive, CharcoalBlockActive.getUnlocalizedName());
		GameRegistry.registerBlock(CoalBlock, CoalBlock.getUnlocalizedName());
		GameRegistry.registerBlock(CoalBlockActive, CoalBlockActive.getUnlocalizedName());
		GameRegistry.registerBlock(CokeBlock, CokeBlock.getUnlocalizedName());
		GameRegistry.registerBlock(woodPile, woodPile.getUnlocalizedName());
		GameRegistry.registerBlock(woodPileActive, woodPileActive.getUnlocalizedName());
		GameRegistry.registerBlock(woodPileCharred, woodPileCharred.getUnlocalizedName());
		
		GameRegistry.registerBlock(DesertLapisOre, DesertLapisOre.getUnlocalizedName());
		GameRegistry.registerBlock(BoraxOre, BoraxOre.getUnlocalizedName());		
		GameRegistry.registerBlock(MalachiteOre, MalachiteOre.getUnlocalizedName());
		GameRegistry.registerBlock(PyriteOre, PyriteOre.getUnlocalizedName());
		GameRegistry.registerBlock(Peat, Peat.getUnlocalizedName());
		GameRegistry.registerBlock(FossilOre, FossilOre.getUnlocalizedName());
		GameRegistry.registerBlock(CopperOre, CopperOre.getUnlocalizedName());
		GameRegistry.registerBlock(LeadOre, LeadOre.getUnlocalizedName());
		GameRegistry.registerBlock(TinOre, TinOre.getUnlocalizedName());
		GameRegistry.registerBlock(ZincOre, ZincOre.getUnlocalizedName());
		GameRegistry.registerBlock(NickelOre, NickelOre.getUnlocalizedName());
		GameRegistry.registerBlock(CobaltOre, CobaltOre.getUnlocalizedName());
		GameRegistry.registerBlock(TitaniumOre, TitaniumOre.getUnlocalizedName());
		GameRegistry.registerBlock(SaltpeterOre, SaltpeterOre.getUnlocalizedName());
		GameRegistry.registerBlock(CopperBlock, CopperBlock.getUnlocalizedName());
		GameRegistry.registerBlock(LeadBlock, LeadBlock.getUnlocalizedName());

	}
	
	public static void initializeFire(){
		Blocks.fire.setFireInfo(ModBlocks.Peat, 5, 5);		
		Blocks.fire.setFireInfo(ModBlocks.CharcoalBlock, 5, 5);
		Blocks.fire.setFireInfo(ModBlocks.CharcoalBlockActive, 5, 5);
		Blocks.fire.setFireInfo(ModBlocks.CoalBlock, 5, 5);
		Blocks.fire.setFireInfo(ModBlocks.CoalBlockActive, 5, 5);
		Blocks.fire.setFireInfo(ModBlocks.woodPile, 10, 10);
		Blocks.fire.setFireInfo(ModBlocks.woodPileActive, 10, 10);
	}
}
