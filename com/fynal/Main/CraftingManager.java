package com.fynal.Main;

import com.fynal.block.ModBlocks;
import com.fynal.item.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingManager {

	public static void mainRegistry(){
		addCrafting();
		addSmelting();
	}
	
	public static void addCrafting(){
		//Shaped recipes
		GameRegistry.addRecipe(new ItemStack(ModItems.bronze_tz_barrel, 1), new Object[]{"MMM","   ", "MMM", 'M', new ItemStack(ModItems.bronze_tz_ingot, 1, 0)});	
		GameRegistry.addRecipe(new ItemStack(ModItems.steel_cn_barrel, 1), new Object[]{"MMM","   ", "MMM", 'M', new ItemStack(ModItems.steel_cn_ingot, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(ModItems.steel_nb_barrel, 1), new Object[]{"MMM","   ", "MMM", 'M', new ItemStack(ModItems.steel_nb_ingot, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(ModItems.steel_nt_barrel, 1), new Object[]{"MMM","   ", "MMM", 'M', new ItemStack(ModItems.steel_nt_ingot, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(ModItems.bullet, 2), new Object[]{" L ","LGL", "CGC", 'L', new ItemStack(ModItems.lead_nugget, 1, 0), 'G', Items.gunpowder, 'C', new ItemStack(ModItems.copper_nugget, 1, 0)});		
		//GameRegistry.addRecipe(new ItemStack(ModItems.shotgun_shell, 2), new Object[]{"LLL","LGL", "CGC", 'L', new ItemStack(ModItems.lead_nugget, 1, 0), 'G', Items.gunpowder, 'C', new ItemStack(ModItems.copper_nugget, 1, 0)});		

		GameRegistry.addRecipe(new ItemStack(ModItems.musket, 1), new Object[]{"FBB","IWW", "S  ", 'F', new ItemStack(ModItems.pyrite_firestarter, 1, 0), 'S', Items.stick, 'B', new ItemStack(ModItems.bronze_tz_barrel, 1, 0), 'W', Blocks.planks, 'I', new ItemStack(ModItems.bronze_tz_ingot)});		
		GameRegistry.addRecipe(new ItemStack(ModItems.pistol, 1), new Object[]{"FB","IW", "S ", 'F', new ItemStack(ModItems.pyrite_firestarter, 1, 0), 'S', Items.stick, 'B', new ItemStack(ModItems.bronze_tz_barrel, 1, 0), 'W', Blocks.planks, 'I', new ItemStack(ModItems.bronze_tz_ingot)});		
		GameRegistry.addRecipe(new ItemStack(ModItems.cn_rifle, 1), new Object[]{"FBB","IWW", "S  ", 'F', new ItemStack(ModItems.steel_firestarter, 1, 0), 'S', Items.stick, 'B', new ItemStack(ModItems.steel_cn_barrel, 1, 0), 'W', Blocks.planks, 'I', new ItemStack(ModItems.steel_cn_ingot)});		
		GameRegistry.addRecipe(new ItemStack(ModItems.cn_revolver, 1), new Object[]{"FB","IW", "S ", 'F', new ItemStack(ModItems.steel_firestarter, 1, 0), 'S', Items.stick, 'B', new ItemStack(ModItems.steel_cn_barrel, 1, 0), 'W', Blocks.planks, 'I', new ItemStack(ModItems.steel_cn_ingot)});		
		GameRegistry.addRecipe(new ItemStack(ModItems.nb_rifle, 1), new Object[]{"FBB","IWW", "S  ", 'F', new ItemStack(ModItems.steel_firestarter, 1, 0), 'S', Items.stick, 'B', new ItemStack(ModItems.steel_nb_barrel, 1, 0), 'W', Blocks.planks, 'I', new ItemStack(ModItems.steel_nb_ingot)});		
		GameRegistry.addRecipe(new ItemStack(ModItems.nb_revolver, 1), new Object[]{"FB","IW", "S ", 'F', new ItemStack(ModItems.steel_firestarter, 1, 0), 'S', Items.stick, 'B', new ItemStack(ModItems.steel_nb_barrel, 1, 0), 'W', Blocks.planks, 'I', new ItemStack(ModItems.steel_nb_ingot)});		
		GameRegistry.addRecipe(new ItemStack(ModItems.nt_rifle, 1), new Object[]{"FBB","IWW", "S  ", 'F', new ItemStack(ModItems.steel_firestarter, 1, 0), 'S', Items.stick, 'B', new ItemStack(ModItems.steel_nt_barrel, 1, 0), 'W', Blocks.planks, 'I', new ItemStack(ModItems.steel_nt_ingot)});		
		GameRegistry.addRecipe(new ItemStack(ModItems.nt_revolver, 1), new Object[]{"FB","IW", "S ", 'F', new ItemStack(ModItems.steel_firestarter, 1, 0), 'S', Items.stick, 'B', new ItemStack(ModItems.steel_nt_barrel, 1, 0), 'W', Blocks.planks, 'I', new ItemStack(ModItems.steel_nt_ingot)});		
		
		
		GameRegistry.addRecipe(new ItemStack(ModItems.pyrite_firestarter, 1), new Object[]{"P "," F", 'P', new ItemStack(ModItems.pyrite, 1, 0), 'F', Items.flint});		
		GameRegistry.addRecipe(new ItemStack(ModItems.steel_firestarter, 1), new Object[]{"S "," F", 'S', new ItemStack(ModItems.steel_cc_ingot, 1, 0), 'F', Items.flint});		
	
		GameRegistry.addRecipe(new ItemStack(ModItems.steel_bucket, 1), new Object[]{"S S"," S ", 'S', new ItemStack(ModItems.steel_b_ingot, 1, 0)});	
		GameRegistry.addRecipe(new ItemStack(ModItems.steel_bucket, 1), new Object[]{"S S"," S ", 'S', new ItemStack(ModItems.steel_bb_ingot, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(ModItems.steel_bucket, 1), new Object[]{"S S"," S ", 'S', new ItemStack(ModItems.steel_bt_ingot, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(ModItems.steel_bucket, 1), new Object[]{"S S"," S ", 'S', new ItemStack(ModItems.steel_cb_ingot, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(ModItems.steel_bucket, 1), new Object[]{"S S"," S ", 'S', new ItemStack(ModItems.steel_nb_ingot, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(ModItems.wood_bucket, 1), new Object[]{" S ","W W", " W ", 'S', new ItemStack(Items.stick, 1, 0), 'W', Blocks.planks});		
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.Bellows, 1), new Object[]{" WW","ILL"," WW", 'W', Blocks.planks, 'L', new ItemStack(Items.leather), 'I', new ItemStack(Items.iron_ingot)});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.FluxFurnace, 1), new Object[]{"CCC","C C","CCC", 'C', new ItemStack(Blocks.cobblestone, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.Vat, 1), new Object[]{"SWS","W W","SWS", 'S', new ItemStack(Items.stick, 1, 0), 'W', Blocks.planks});		
		GameRegistry.addRecipe(new ItemStack(Items.furnace_minecart, 1), new Object[]{"F","M",'F', new ItemStack(ModBlocks.FluxFurnace, 1, 0),'M', new ItemStack(Items.minecart, 1, 0)});
		
		GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone, 1), new Object[]{"RR","RR", 'R', ModItems.rock});
		GameRegistry.addRecipe(new ItemStack(ModItems.bandage, 1), new Object[]{" P ","PWP", 'P', Items.paper, 'W', Blocks.wool});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.woodPile, 1), new Object[]{"CCC","CCC","CCC", 'C', new ItemStack(Items.stick, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.CharcoalBlock, 1), new Object[]{"CCC","CCC","CCC", 'C', new ItemStack(Items.coal, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.CoalBlock, 1), new Object[]{"CCC","CCC","CCC", 'C', new ItemStack(Items.coal, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(ModItems.flint_knife, 1), new Object[]{"F","S", 'F', new ItemStack(Items.flint, 1, 0), 'S', new ItemStack(Items.stick, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(Blocks.torch, 2, 0), new Object[]{"A","S", 'A', new ItemStack(ModItems.animal_fat, 1, 0), 'S', new ItemStack(Items.stick, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(ModItems.flint_hatchet, 1), new Object[]{"FS"," S", 'F', new ItemStack(Items.flint, 1, 0), 'S', new ItemStack(Items.stick, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(ModItems.stone_club, 1), new Object[]{" X "," S ", " S ", 'X', new ItemStack(Blocks.cobblestone, 1, 0), 'S', new ItemStack(Items.stick, 1, 0)});		
		
//		TEMPORARY CLUDGES
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.nether_flux, 1, 0), new ItemStack(ModItems.mixed_flux, 1, 0), new ItemStack(Items.nether_wart, 1, 0));

//		prototypes for dax-generated code
//		GameRegistry.addRecipe(new ItemStack(ModTools.copper_pick, 1), new Object[]{"MMM"," S ", " S ", 'M', new ItemStack(ModItems.copper_ingot, 1, 0), 'S', new ItemStack(Items.stick, 1, 0)});
//		GameRegistry.addRecipe(new ItemStack(ModTools.copper_axe, 1), new Object[]{" MM"," SM", " S ", 'M', new ItemStack(ModItems.copper_ingot, 1, 0), 'S', new ItemStack(Items.stick, 1, 0)});
//		GameRegistry.addRecipe(new ItemStack(ModTools.copper_sword, 1), new Object[]{" M "," M ", " S ", 'M', new ItemStack(ModItems.copper_ingot, 1, 0), 'S', new ItemStack(Items.stick, 1, 0)});
//		GameRegistry.addRecipe(new ItemStack(ModTools.copper_hoe, 1), new Object[]{" MM"," S ", " S ", 'M', new ItemStack(ModItems.copper_ingot, 1, 0), 'S', new ItemStack(Items.stick, 1, 0)});
//		GameRegistry.addRecipe(new ItemStack(ModTools.copper_shovel, 1), new Object[]{" M "," S ", " S ", 'M', new ItemStack(ModItems.copper_ingot, 1, 0), 'S', new ItemStack(Items.stick, 1, 0)});

		//Shapeless recipes
		ItemStack leadNug = new ItemStack(ModItems.lead_nugget, 1, 0);
		ItemStack goldNug = new ItemStack(Items.gold_nugget, 1, 0);
		ItemStack copperNug = new ItemStack(ModItems.copper_nugget, 1, 0);
		ItemStack tinNug = new ItemStack(ModItems.tin_nugget, 1, 0);
		ItemStack zincNug = new ItemStack(ModItems.zinc_nugget, 1, 0);
		ItemStack ironNug = new ItemStack(ModItems.iron_nugget, 1, 0);
		ItemStack cokeNug = new ItemStack(ModItems.Coke, 1, 0);
		ItemStack nickelNug = new ItemStack(ModItems.nickel_nugget, 1, 0);
		ItemStack cobaltNug = new ItemStack(ModItems.cobalt_nugget, 1, 0);
		ItemStack titaniumNug = new ItemStack(ModItems.titanium_nugget, 1, 0);	
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.mixed_flux, 1, 0), new ItemStack(ModItems.borax, 1, 0), new ItemStack(ModItems.potash, 1, 0), new ItemStack(Items.coal, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.animal_fat, 3, 0), new ItemStack(Items.beef, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.animal_fat, 3, 0), new ItemStack(Items.porkchop, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.animal_fat, 2, 0), new ItemStack(Items.chicken, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.coal, 9, 1), new ItemStack(ModBlocks.CharcoalBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gunpowder, 4, 0), new ItemStack(ModItems.saltpeter, 1, 0), new ItemStack(ModItems.sulfur, 1, 0), new ItemStack(Items.coal, 1, 1));
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.copper_ingot, 1, 0), copperNug, copperNug, copperNug, copperNug, copperNug, copperNug, copperNug, copperNug, copperNug);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 1, 0),  ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.lead_ingot, 1, 0), leadNug, leadNug, leadNug, leadNug, leadNug, leadNug, leadNug, leadNug, leadNug);
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.copper_nugget, 9, 0), new ItemStack(ModItems.copper_ingot, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.iron_nugget, 9, 0), new ItemStack(Items.iron_ingot, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.lead_nugget, 9, 0), new ItemStack(ModItems.lead_ingot, 1, 0));
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_rose_gold_ingot, 1, 0), copperNug, goldNug, goldNug, goldNug, goldNug, goldNug, goldNug, goldNug, goldNug);
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_brass_z_ingot, 1, 0), copperNug, copperNug, copperNug, copperNug, copperNug, copperNug, copperNug, copperNug, zincNug);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_brass_zz_ingot, 1, 0), copperNug, copperNug, copperNug, copperNug, copperNug, copperNug, copperNug, zincNug, zincNug);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_bronze_t_ingot, 1, 0), copperNug, copperNug, copperNug, copperNug, copperNug, copperNug, copperNug, copperNug, tinNug);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_bronze_tt_ingot, 1, 0), copperNug, copperNug, copperNug, copperNug, copperNug, copperNug, copperNug, tinNug, tinNug);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_bronze_tz_ingot, 1, 0), copperNug, copperNug, copperNug, copperNug, copperNug, copperNug, copperNug, zincNug, tinNug);

		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_steel_c_ingot, 1, 0), ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, cokeNug);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_steel_cc_ingot, 1, 0), ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, cokeNug, cokeNug);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_steel_n_ingot, 1, 0), ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, nickelNug);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_steel_nn_ingot, 1, 0), ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, nickelNug, nickelNug);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_steel_b_ingot, 1, 0), ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, cobaltNug);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_steel_bb_ingot, 1, 0), ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, cobaltNug, cobaltNug);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_steel_t_ingot, 1, 0), ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, titaniumNug);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_steel_tt_ingot, 1, 0), ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, titaniumNug, titaniumNug);

		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_steel_cn_ingot, 1, 0), ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, nickelNug, cokeNug);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_steel_cb_ingot, 1, 0), ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, cobaltNug, cokeNug);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_steel_ct_ingot, 1, 0), ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, titaniumNug, cokeNug);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_steel_nb_ingot, 1, 0), ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, nickelNug, cobaltNug);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_steel_nt_ingot, 1, 0), ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, nickelNug, titaniumNug);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.u_steel_bt_ingot, 1, 0), ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, ironNug, cobaltNug, titaniumNug);

		
	}
	
	public static void addSmelting(){
		//Smelting
		GameRegistry.addSmelting(Items.egg, new ItemStack(ModItems.fried_egg, 1), 0);	
		
		GameRegistry.addSmelting(ModItems.malachite, new ItemStack(ModItems.copper_nugget, 1), 1F);	
		GameRegistry.addSmelting(ModItems.pyrite, new ItemStack(ModItems.iron_nugget, 1), 1F);	
		
		GameRegistry.addSmelting(ModItems.meteorite1, new ItemStack(ModItems.iron_nugget, 5), 15F);	
		GameRegistry.addSmelting(ModItems.meteorite2, new ItemStack(ModItems.iron_nugget, 7), 20F);	
		GameRegistry.addSmelting(ModItems.meteorite3, new ItemStack(ModItems.nickel_nugget, 3), 20F);	
		GameRegistry.addSmelting(ModItems.meteorite4, new ItemStack(ModItems.nickel_nugget, 5), 20F);	
		
		GameRegistry.addSmelting(Blocks.iron_ore, new ItemStack(ModItems.iron_nugget, 3), 0.5F);
		GameRegistry.addSmelting(Blocks.gold_ore, new ItemStack(Items.gold_nugget, 1), 0.5F);
		
		GameRegistry.addSmelting(ModBlocks.CopperOre, new ItemStack(ModItems.copper_nugget, 3), 0.5F);
		GameRegistry.addSmelting(ModBlocks.LeadOre, new ItemStack(ModItems.lead_nugget, 3), 0.5F);
		GameRegistry.addSmelting(ModBlocks.TinOre, new ItemStack(ModItems.tin_nugget, 1), 1);
		GameRegistry.addSmelting(ModBlocks.ZincOre, new ItemStack(ModItems.zinc_nugget, 1), 1);
		GameRegistry.addSmelting(ModBlocks.NickelOre, new ItemStack(ModItems.nickel_nugget, 1), 2);
		GameRegistry.addSmelting(ModBlocks.CobaltOre, new ItemStack(ModItems.cobalt_nugget, 1), 2.5F);
		GameRegistry.addSmelting(ModBlocks.TitaniumOre, new ItemStack(ModItems.titanium_nugget, 1), 3);
		
		GameRegistry.addSmelting(ModItems.u_rose_gold_ingot, new ItemStack(ModItems.rose_gold_ingot, 1), 10);
		
		GameRegistry.addSmelting(ModItems.u_brass_z_ingot, new ItemStack(ModItems.brass_z_ingot, 1), 1);	
		GameRegistry.addSmelting(ModItems.u_brass_zz_ingot, new ItemStack(ModItems.brass_zz_ingot, 1), 2);
		GameRegistry.addSmelting(ModItems.u_bronze_t_ingot, new ItemStack(ModItems.bronze_t_ingot, 1), 1);
		GameRegistry.addSmelting(ModItems.u_bronze_tt_ingot, new ItemStack(ModItems.bronze_tt_ingot, 1), 2);
		GameRegistry.addSmelting(ModItems.u_bronze_tz_ingot, new ItemStack(ModItems.bronze_tz_ingot, 1), 2);
		
		GameRegistry.addSmelting(ModItems.u_steel_c_ingot, new ItemStack(ModItems.steel_c_ingot, 1), 1);
		GameRegistry.addSmelting(ModItems.u_steel_cc_ingot, new ItemStack(ModItems.steel_cc_ingot, 1), 2);
		GameRegistry.addSmelting(ModItems.u_steel_n_ingot, new ItemStack(ModItems.steel_n_ingot, 1), 2);
		GameRegistry.addSmelting(ModItems.u_steel_nn_ingot, new ItemStack(ModItems.steel_nn_ingot, 1), 3);
		GameRegistry.addSmelting(ModItems.u_steel_b_ingot, new ItemStack(ModItems.steel_b_ingot, 1), 2);
		GameRegistry.addSmelting(ModItems.u_steel_bb_ingot, new ItemStack(ModItems.steel_bb_ingot, 1), 3);
		GameRegistry.addSmelting(ModItems.u_steel_t_ingot, new ItemStack(ModItems.steel_t_ingot, 1), 2);
		GameRegistry.addSmelting(ModItems.u_steel_tt_ingot, new ItemStack(ModItems.steel_tt_ingot, 1), 3);
		
		GameRegistry.addSmelting(ModItems.u_steel_cn_ingot, new ItemStack(ModItems.steel_cn_ingot, 1), 2);
		GameRegistry.addSmelting(ModItems.u_steel_cb_ingot, new ItemStack(ModItems.steel_cb_ingot, 1), 2);
		GameRegistry.addSmelting(ModItems.u_steel_ct_ingot, new ItemStack(ModItems.steel_ct_ingot, 1), 2);
		GameRegistry.addSmelting(ModItems.u_steel_nb_ingot, new ItemStack(ModItems.steel_nb_ingot, 1), 3);
		GameRegistry.addSmelting(ModItems.u_steel_nt_ingot, new ItemStack(ModItems.steel_nt_ingot, 1), 3);
		GameRegistry.addSmelting(ModItems.u_steel_bt_ingot, new ItemStack(ModItems.steel_bt_ingot, 1), 3);
	}
}
