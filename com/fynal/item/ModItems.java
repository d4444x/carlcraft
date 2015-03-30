package com.fynal.item;

import java.awt.List;

import com.fynal.Main.MainRegistry;
import com.fynal.lib.Ref;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {
	
	public static Item dawn;
	
	public static Item bronze_tz_barrel;
	public static Item steel_cn_barrel;
	public static Item steel_nb_barrel;
	public static Item steel_nt_barrel;
	public static Item bullet;
	public static Item shotgun_shell;
	
	public static Item bullet_entity;//just for rendering the bullet, does not exist otherwise
	public static Item pistol;//unloaded
	public static Item pistol_b;//blank, just powder
	public static Item pistol_1;//loaded
	public static Item musket;
	public static Item musket_b;
	public static Item musket_1;
	public static Item cn_rifle;
	public static Item cn_rifle_1;
	public static Item cn_revolver;
	public static Item cn_revolver_1;
	public static Item cn_revolver_2;
	public static Item cn_revolver_3;
	public static Item cn_revolver_4;
	public static Item nb_rifle;
	public static Item nb_rifle_1;
	public static Item nb_revolver;
	public static Item nb_revolver_1;
	public static Item nb_revolver_2;
	public static Item nb_revolver_3;
	public static Item nb_revolver_4;
	public static Item nt_rifle;
	public static Item nt_rifle_1;
	public static Item nt_revolver;
	public static Item nt_revolver_1;
	public static Item nt_revolver_2;
	public static Item nt_revolver_3;
	public static Item nt_revolver_4;
	
	public static Item pyrite_firestarter;
	public static Item steel_firestarter;
	public static Item steel_bucket;
	public static Item steel_bucket_lava;
	public static Item steel_bucket_water;
	public static Item steel_bucket_milk;
	public static Item wood_bucket;
	public static Item wood_bucket_water;
	public static Item wood_bucket_milk;
	
	public static Item vat_tannin;
	public static Item vat_water;
	public static Item vat_milk;
	public static Item flint_knife;
	public static Item flint_hatchet;
	public static Item stone_club;
	public static Item hide;
	public static Item bandage;
	public static Item fried_egg;
	
	public static ToolMaterial coilflint = EnumHelper.addToolMaterial("Flint", 0, 40, 1.5f, -3.0f, 0);
	public static ToolMaterial coilstone = EnumHelper.addToolMaterial("Stone", 0, 60, 1.5f, -3.0f, 0);
	
	public static Item rock;
	public static Item meteorite1;
	public static Item meteorite2;
	public static Item meteorite3;
	public static Item meteorite4;
	
	public static Item animal_fat;
	public static Item Coke;
	public static Item malachite;
	public static Item pyrite;
	public static Item saltpeter;
	public static Item sulfur;
	public static Item ashes;
	public static Item potash;
	public static Item borax;
	public static Item mixed_flux;
	public static Item nether_flux;
	
	public static Item copper_nugget;
	public static Item iron_nugget;
	public static Item lead_nugget;
	public static Item tin_nugget;
	public static Item zinc_nugget;
	public static Item nickel_nugget;
	public static Item cobalt_nugget;
	public static Item titanium_nugget;

	public static Item lead_ingot;
	public static Item rose_gold_ingot;
	
	public static Item copper_ingot;
	public static Item brass_z_ingot;
	public static Item brass_zz_ingot;
	public static Item bronze_t_ingot;
	public static Item bronze_tt_ingot;
	public static Item bronze_tz_ingot;
	
	public static Item steel_c_ingot;
	public static Item steel_cc_ingot;
	public static Item steel_n_ingot;
	public static Item steel_nn_ingot;
	public static Item steel_b_ingot;
	public static Item steel_bb_ingot;
	public static Item steel_t_ingot;
	public static Item steel_tt_ingot;

	public static Item steel_cn_ingot;
	public static Item steel_cb_ingot;
	public static Item steel_ct_ingot;
	public static Item steel_nb_ingot;
	public static Item steel_nt_ingot;
	public static Item steel_bt_ingot;
	
	public static Item u_rose_gold_ingot;
	
	public static Item u_brass_z_ingot;
	public static Item u_brass_zz_ingot;
	public static Item u_bronze_t_ingot;
	public static Item u_bronze_tt_ingot;
	public static Item u_bronze_tz_ingot;
	
	public static Item u_steel_c_ingot;
	public static Item u_steel_cc_ingot;
	public static Item u_steel_n_ingot;
	public static Item u_steel_nn_ingot;
	public static Item u_steel_b_ingot;
	public static Item u_steel_bb_ingot;
	public static Item u_steel_t_ingot;
	public static Item u_steel_tt_ingot;

	public static Item u_steel_cn_ingot;
	public static Item u_steel_cb_ingot;
	public static Item u_steel_ct_ingot;
	public static Item u_steel_nb_ingot;
	public static Item u_steel_nt_ingot;
	public static Item u_steel_bt_ingot;

	public static void mainRegistry(){
		initializeItem();
		registerItem();
	}
	
	public static void initializeItem(){
		
//		prototype for dax-generated files			
//		copper_pick = new CopperPick(copper).setUnlocalizedName("copper_pick").setCreativeTab(CreativeTabs.tabTools).setTextureName(Ref.MODID + ":copper_pick");
//		copper_axe = new CopperAxe(copper).setUnlocalizedName("copper_axe").setCreativeTab(CreativeTabs.tabTools).setTextureName(Ref.MODID + ":copper_axe");
//		copper_shovel = new CopperShovel(copper).setUnlocalizedName("copper_shovel").setCreativeTab(CreativeTabs.tabTools).setTextureName(Ref.MODID + ":copper_shovel");
//		copper_hoe = new CopperHoe(copper).setUnlocalizedName("copper_hoe").setCreativeTab(CreativeTabs.tabTools).setTextureName(Ref.MODID + ":copper_hoe");
//		copper_sword = new CopperSword(copper).setUnlocalizedName("copper_sword").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":copper_sword");
		
		//0 is helmet, 1 is chest, 2 is leggings, 3 is boots
//		copper_helmet = new copper_armor(ArmorMaterial.GOLD, MainRegistry.proxy.addArmor("copper_armor"), 0).setUnlocalizedName("copper_helmet").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":copper_helmet");
//		copper_chestplate = new copper_armor(ArmorMaterial.GOLD, MainRegistry.proxy.addArmor("copper_armor"), 1).setUnlocalizedName("copper_chestplate").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":copper_chestplate");
//		copper_leggings = new copper_armor(ArmorMaterial.GOLD, MainRegistry.proxy.addArmor("copper_armor"), 2).setUnlocalizedName("copper_leggings").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":copper_leggings");
//		copper_boots = new copper_armor(ArmorMaterial.GOLD, MainRegistry.proxy.addArmor("copper_armor"), 3).setUnlocalizedName("copper_boots").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":copper_boots");
		
		dawn = new Dawn(8, 5.0F, false).setUnlocalizedName("dawn").setCreativeTab(CreativeTabs.tabFood).setTextureName(Ref.MODID + ":dawn");
		
		bronze_tz_barrel = new Item().setUnlocalizedName("bronze_tz_barrel").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":bronze_tz_barrel");
		steel_cn_barrel = new Item().setUnlocalizedName("steel_cn_barrel").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":steel_cn_barrel");
		steel_nb_barrel = new Item().setUnlocalizedName("steel_nb_barrel").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":steel_nb_barrel");
		steel_nt_barrel = new Item().setUnlocalizedName("steel_nt_barrel").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":steel_nt_barrel");
		bullet = new Item().setUnlocalizedName("bullet").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":bullet");
		shotgun_shell = new Item().setUnlocalizedName("shotgun_shell").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":shotgun_shell");		
		
		bullet_entity = new Item().setUnlocalizedName("bullet_entity").setTextureName(Ref.MODID + ":bullet_entity");
		pistol = new Firearm(0, 70, "tz").setUnlocalizedName("pistol").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":pistol");
		pistol_b = new Firearm(-1, 70, "tz").setUnlocalizedName("pistol_b").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":pistol");
		pistol_1 = new Firearm(1, 70, "tz").setUnlocalizedName("pistol_1").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":pistol");
		musket = new Firearm(0, 90, "tz").setUnlocalizedName("musket").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":musket");
		musket_b = new Firearm(-1, 90, "tz").setUnlocalizedName("musket_b").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":musket");	
		musket_1 = new Firearm(1, 90, "tz").setUnlocalizedName("musket_1").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":musket");
		cn_rifle = new Firearm(0, 120, "cn").setUnlocalizedName("cn_rifle").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":cn_rifle");
		cn_rifle_1 = new Firearm(1, 120, "cn").setUnlocalizedName("cn_rifle_1").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":cn_rifle");
		nb_rifle = new Firearm(0, 400, "nb").setUnlocalizedName("nb_rifle").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":nb_rifle");
		nb_rifle_1 = new Firearm(1, 400, "nb").setUnlocalizedName("nb_rifle_1").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":nb_rifle");
		nt_rifle = new Firearm(0, 200, "nt").setUnlocalizedName("nt_rifle").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":nt_rifle");
		nt_rifle_1 = new Firearm(1, 200, "nt").setUnlocalizedName("nt_rifle_1").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":nt_rifle");
		cn_revolver = new Firearm(0, 120, "cn").setUnlocalizedName("cn_revolver").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":cn_revolver");
		cn_revolver_1 = new Firearm(1, 120, "cn").setUnlocalizedName("cn_revolver_1").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":cn_revolver");
		cn_revolver_2 = new Firearm(2, 120, "cn").setUnlocalizedName("cn_revolver_2").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":cn_revolver");
		cn_revolver_3 = new Firearm(3, 120, "cn").setUnlocalizedName("cn_revolver_3").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":cn_revolver");
		cn_revolver_4 = new Firearm(4, 120, "cn").setUnlocalizedName("cn_revolver_4").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":cn_revolver");
		nb_revolver = new Firearm(0, 400, "nb").setUnlocalizedName("nb_revolver").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":nb_revolver");
		nb_revolver_1 = new Firearm(1, 400, "nb").setUnlocalizedName("nb_revolver_1").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":nb_revolver");
		nb_revolver_2 = new Firearm(2, 400, "nb").setUnlocalizedName("nb_revolver_2").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":nb_revolver");
		nb_revolver_3 = new Firearm(3, 400, "nb").setUnlocalizedName("nb_revolver_3").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":nb_revolver");
		nb_revolver_4 = new Firearm(4, 400, "nb").setUnlocalizedName("nb_revolver_4").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":nb_revolver");
		nt_revolver = new Firearm(0, 200, "nt").setUnlocalizedName("nt_revolver").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":nt_revolver");
		nt_revolver_1 = new Firearm(1, 200, "nt").setUnlocalizedName("nt_revolver_1").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":nt_revolver");
		nt_revolver_2 = new Firearm(2, 200, "nt").setUnlocalizedName("nt_revolver_2").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":nt_revolver");
		nt_revolver_3 = new Firearm(3, 200, "nt").setUnlocalizedName("nt_revolver_3").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":nt_revolver");
		nt_revolver_4 = new Firearm(4, 200, "nt").setUnlocalizedName("nt_revolver_4").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":nt_revolver");
		
		pyrite_firestarter = new Firestarter(39, 50).setUnlocalizedName("pyrite_firestarter").setCreativeTab(CreativeTabs.tabTools).setTextureName(Ref.MODID + ":pyrite_firestarter");
		steel_firestarter = new Firestarter(219, 100).setUnlocalizedName("steel_firestarter").setCreativeTab(CreativeTabs.tabTools).setTextureName(Ref.MODID + ":steel_firestarter");
		steel_bucket = new FynalBucket(Blocks.air, true).setUnlocalizedName("steel_bucket").setCreativeTab(CreativeTabs.tabMisc).setTextureName(Ref.MODID + ":steel_bucket");
		steel_bucket_lava = new FynalBucket(Blocks.flowing_lava, true).setUnlocalizedName("steel_bucket_lava").setCreativeTab(CreativeTabs.tabMisc).setTextureName(Ref.MODID + ":steel_bucket_lava");
		steel_bucket_water = new FynalBucket(Blocks.flowing_water, true).setUnlocalizedName("steel_bucket_water").setCreativeTab(CreativeTabs.tabMisc).setTextureName(Ref.MODID + ":steel_bucket_water");
		wood_bucket = new FynalBucket(Blocks.air, false).setUnlocalizedName("wood_bucket").setCreativeTab(CreativeTabs.tabMisc).setTextureName(Ref.MODID + ":wood_bucket");
		wood_bucket_water = new FynalBucket(Blocks.flowing_water, false).setUnlocalizedName("wood_bucket_water").setCreativeTab(CreativeTabs.tabMisc).setTextureName(Ref.MODID + ":wood_bucket_water");
		steel_bucket_milk = new FynalBucketMilk().setUnlocalizedName("steel_bucket_milk").setCreativeTab(CreativeTabs.tabMisc).setTextureName(Ref.MODID + ":steel_bucket_milk");		
		wood_bucket_milk = new FynalBucketMilk().setUnlocalizedName("wood_bucket_milk").setCreativeTab(CreativeTabs.tabMisc).setTextureName(Ref.MODID + ":wood_bucket_milk");
		
		rock = new Item().setUnlocalizedName("rock").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":rock");
		meteorite1 = new Item().setUnlocalizedName("meteorite1").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":meteorite_1");
		meteorite2 = new Item().setUnlocalizedName("meteorite2").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":meteorite_2");
		meteorite3 = new Item().setUnlocalizedName("meteorite3").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":meteorite_3");
		meteorite4 = new Item().setUnlocalizedName("meteorite4").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":meteorite_4");
		
		vat_water = new Item().setUnlocalizedName("vat_water").setTextureName(Ref.MODID + ":vat_water");
		vat_milk = new Item().setUnlocalizedName("vat_milk").setTextureName(Ref.MODID + ":vat_milk");
		vat_tannin = new Item().setUnlocalizedName("vat_tannin").setTextureName(Ref.MODID + ":vat_tannin");
		
		flint_knife = new CopperSword(coilflint).setUnlocalizedName("flint_knife").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":flint_knife");
		flint_hatchet = new CopperAxe(coilflint).setUnlocalizedName("flint_hatchet").setCreativeTab(CreativeTabs.tabTools).setTextureName(Ref.MODID + ":flint_hatchet");
		stone_club = new CopperSword(coilstone).setUnlocalizedName("stone_club").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":stone_club");

		bandage = new Bandage(0, 0F, false).setUnlocalizedName("bandage").setCreativeTab(CreativeTabs.tabCombat).setTextureName(Ref.MODID + ":bandage");
					
		fried_egg = new FriedEgg(4, 4.5F, false).setUnlocalizedName("fried_egg").setCreativeTab(CreativeTabs.tabFood).setTextureName(Ref.MODID + ":fried_egg");
		hide = new Item().setUnlocalizedName("hide").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":hide");
		animal_fat = new Item().setUnlocalizedName("animal_fat").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":animal_fat");	
		Coke = new Item().setUnlocalizedName("Coke").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":coke");	
		malachite = new Item().setUnlocalizedName("malachite").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":malachite");
		pyrite = new Item().setUnlocalizedName("pyrite").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":pyrite");
		saltpeter = new Item().setUnlocalizedName("saltpeter").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":saltpeter");
		sulfur = new Item().setUnlocalizedName("sulfer").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":sulfer");
		ashes = new Item().setUnlocalizedName("ashes").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":ashes");
		potash = new Item().setUnlocalizedName("potash").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":potash");
		borax = new Item().setUnlocalizedName("borax").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":borax");
		mixed_flux = new Item().setUnlocalizedName("mixed_flux").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":mixed_flux");
		nether_flux = new Item().setUnlocalizedName("nether_flux").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":nether_flux");
		
		copper_nugget = new Item().setUnlocalizedName("copper_nugget").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":copper_nugget");
		iron_nugget = new Item().setUnlocalizedName("iron_nugget").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":iron_nugget");
		lead_nugget = new Item().setUnlocalizedName("lead_nugget").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":lead_nugget");
		tin_nugget = new Item().setUnlocalizedName("tin_nugget").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":tin_nugget");
		zinc_nugget = new Item().setUnlocalizedName("zinc_nugget").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":zinc_nugget");
		nickel_nugget = new Item().setUnlocalizedName("nickel_nugget").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":nickel_nugget");
		cobalt_nugget = new Item().setUnlocalizedName("cobalt_nugget").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":cobalt_nugget");
		titanium_nugget = new Item().setUnlocalizedName("titanium_nugget").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":titanium_nugget");
		
		lead_ingot = new Item().setUnlocalizedName("lead_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":lead_ingot");
		rose_gold_ingot = new Item().setUnlocalizedName("rose_gold_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":rose_gold_ingot");
		
		copper_ingot = new Item().setUnlocalizedName("copper_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":copper_ingot");
		brass_z_ingot = new alloyingot().setUnlocalizedName("brass_z_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":brass_z_ingot");
		brass_zz_ingot = new alloyingot().setUnlocalizedName("brass_zz_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":brass_zz_ingot");
		bronze_t_ingot = new alloyingot().setUnlocalizedName("bronze_t_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":bronze_t_ingot");
		bronze_tt_ingot = new alloyingot().setUnlocalizedName("bronze_tt_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":bronze_tt_ingot");
		bronze_tz_ingot = new alloyingot().setUnlocalizedName("bronze_tz_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":bronze_tz_ingot");
		
		steel_c_ingot = new alloyingot().setUnlocalizedName("steel_c_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":steel_c_ingot");
		steel_cc_ingot = new alloyingot().setUnlocalizedName("steel_cc_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":steel_cc_ingot");
		steel_n_ingot = new alloyingot().setUnlocalizedName("steel_n_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":steel_n_ingot");
		steel_nn_ingot = new alloyingot().setUnlocalizedName("steel_nn_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":steel_nn_ingot");
		steel_b_ingot = new alloyingot().setUnlocalizedName("steel_b_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":steel_b_ingot");
		steel_bb_ingot = new alloyingot().setUnlocalizedName("steel_bb_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":steel_bb_ingot");
		steel_t_ingot = new alloyingot().setUnlocalizedName("steel_t_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":steel_t_ingot");
		steel_tt_ingot = new alloyingot().setUnlocalizedName("steel_tt_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":steel_tt_ingot");
		
		steel_cn_ingot = new alloyingot().setUnlocalizedName("steel_cn_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":steel_cn_ingot");
		steel_cb_ingot = new alloyingot().setUnlocalizedName("steel_cb_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":steel_cb_ingot");
		steel_ct_ingot = new alloyingot().setUnlocalizedName("steel_ct_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":steel_ct_ingot");
		steel_nb_ingot = new alloyingot().setUnlocalizedName("steel_nb_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":steel_nb_ingot");
		steel_nt_ingot = new alloyingot().setUnlocalizedName("steel_nt_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":steel_nt_ingot");
		steel_bt_ingot = new alloyingot().setUnlocalizedName("steel_bt_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":steel_bt_ingot");		
		
		u_rose_gold_ingot = new Item().setUnlocalizedName("u_rose_gold_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_rose_gold_ingot");
		
		u_brass_z_ingot = new Item().setUnlocalizedName("u_brass_z_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_brass_z_ingot");
		u_brass_zz_ingot = new Item().setUnlocalizedName("u_brass_zz_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_brass_zz_ingot");
		u_bronze_t_ingot = new Item().setUnlocalizedName("u_bronze_t_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_bronze_t_ingot");
		u_bronze_tt_ingot = new Item().setUnlocalizedName("u_bronze_tt_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_bronze_tt_ingot");
		u_bronze_tz_ingot = new Item().setUnlocalizedName("u_bronze_tz_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_bronze_tz_ingot");
		
		u_steel_c_ingot = new Item().setUnlocalizedName("u_steel_c_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_steel_c_ingot");
		u_steel_cc_ingot = new Item().setUnlocalizedName("u_steel_cc_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_steel_cc_ingot");
		u_steel_n_ingot = new Item().setUnlocalizedName("u_steel_n_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_steel_n_ingot");
		u_steel_nn_ingot = new Item().setUnlocalizedName("u_steel_nn_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_steel_nn_ingot");
		u_steel_b_ingot = new Item().setUnlocalizedName("u_steel_b_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_steel_b_ingot");
		u_steel_bb_ingot = new Item().setUnlocalizedName("u_steel_bb_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_steel_bb_ingot");
		u_steel_t_ingot = new Item().setUnlocalizedName("u_steel_t_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_steel_t_ingot");
		u_steel_tt_ingot = new Item().setUnlocalizedName("u_steel_tt_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_steel_tt_ingot");
		
		u_steel_cn_ingot = new Item().setUnlocalizedName("u_steel_cn_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_steel_cn_ingot");
		u_steel_cb_ingot = new Item().setUnlocalizedName("u_steel_cb_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_steel_cb_ingot");
		u_steel_ct_ingot = new Item().setUnlocalizedName("u_steel_ct_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_steel_ct_ingot");
		u_steel_nb_ingot = new Item().setUnlocalizedName("u_steel_nb_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_steel_nb_ingot");
		u_steel_nt_ingot = new Item().setUnlocalizedName("u_steel_nt_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_steel_nt_ingot");
		u_steel_bt_ingot = new Item().setUnlocalizedName("u_steel_bt_ingot").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Ref.MODID + ":u_steel_bt_ingot");		
	}
	
	public static void registerItem(){
//		prototype for dax-generated files
//		GameRegistry.registerItem(copper_pick, copper_pick.getUnlocalizedName());
//		GameRegistry.registerItem(copper_axe, copper_axe.getUnlocalizedName());
//		GameRegistry.registerItem(copper_shovel, copper_shovel.getUnlocalizedName());
//		GameRegistry.registerItem(copper_hoe, copper_hoe.getUnlocalizedName());
//		GameRegistry.registerItem(copper_sword, copper_sword.getUnlocalizedName());	
//		GameRegistry.registerItem(copper_helmet, copper_helmet.getUnlocalizedName());
//		GameRegistry.registerItem(copper_chestplate, copper_chestplate.getUnlocalizedName());
//		GameRegistry.registerItem(copper_leggings, copper_leggings.getUnlocalizedName());
//		GameRegistry.registerItem(copper_boots, copper_boots.getUnlocalizedName());
	
		GameRegistry.registerItem(dawn, dawn.getUnlocalizedName());
		
		GameRegistry.registerItem(bronze_tz_barrel, bronze_tz_barrel.getUnlocalizedName());
		GameRegistry.registerItem(steel_cn_barrel, steel_cn_barrel.getUnlocalizedName());
		GameRegistry.registerItem(steel_nb_barrel, steel_nb_barrel.getUnlocalizedName());
		GameRegistry.registerItem(steel_nt_barrel, steel_nt_barrel.getUnlocalizedName());
		GameRegistry.registerItem(bullet, bullet.getUnlocalizedName());
		GameRegistry.registerItem(shotgun_shell, shotgun_shell.getUnlocalizedName());
		
		GameRegistry.registerItem(bullet_entity, bullet_entity.getUnlocalizedName());
		GameRegistry.registerItem(pistol, pistol.getUnlocalizedName());
		GameRegistry.registerItem(pistol_b, pistol_b.getUnlocalizedName());
		GameRegistry.registerItem(pistol_1, pistol_1.getUnlocalizedName());
		GameRegistry.registerItem(musket, musket.getUnlocalizedName());
		GameRegistry.registerItem(musket_b, musket_b.getUnlocalizedName());
		GameRegistry.registerItem(musket_1, musket_1.getUnlocalizedName());
		GameRegistry.registerItem(cn_rifle, cn_rifle.getUnlocalizedName());
		GameRegistry.registerItem(cn_rifle_1, cn_rifle_1.getUnlocalizedName());
		GameRegistry.registerItem(nb_rifle, nb_rifle.getUnlocalizedName());
		GameRegistry.registerItem(nb_rifle_1, nb_rifle_1.getUnlocalizedName());
		GameRegistry.registerItem(nt_rifle, nt_rifle.getUnlocalizedName());
		GameRegistry.registerItem(nt_rifle_1, nt_rifle_1.getUnlocalizedName());
		GameRegistry.registerItem(cn_revolver, cn_revolver.getUnlocalizedName());
		GameRegistry.registerItem(cn_revolver_1, cn_revolver_1.getUnlocalizedName());
		GameRegistry.registerItem(cn_revolver_2, cn_revolver_2.getUnlocalizedName());
		GameRegistry.registerItem(cn_revolver_3, cn_revolver_3.getUnlocalizedName());
		GameRegistry.registerItem(cn_revolver_4, cn_revolver_4.getUnlocalizedName());
		GameRegistry.registerItem(nb_revolver, nb_revolver.getUnlocalizedName());
		GameRegistry.registerItem(nb_revolver_1, nb_revolver_1.getUnlocalizedName());
		GameRegistry.registerItem(nb_revolver_2, nb_revolver_2.getUnlocalizedName());
		GameRegistry.registerItem(nb_revolver_3, nb_revolver_3.getUnlocalizedName());
		GameRegistry.registerItem(nb_revolver_4, nb_revolver_4.getUnlocalizedName());
		GameRegistry.registerItem(nt_revolver, nt_revolver.getUnlocalizedName());
		GameRegistry.registerItem(nt_revolver_1, nt_revolver_1.getUnlocalizedName());
		GameRegistry.registerItem(nt_revolver_2, nt_revolver_2.getUnlocalizedName());
		GameRegistry.registerItem(nt_revolver_3, nt_revolver_3.getUnlocalizedName());
		GameRegistry.registerItem(nt_revolver_4, nt_revolver_4.getUnlocalizedName());
		
		
		GameRegistry.registerItem(pyrite_firestarter, pyrite_firestarter.getUnlocalizedName());
		GameRegistry.registerItem(steel_firestarter, steel_firestarter.getUnlocalizedName());
		GameRegistry.registerItem(steel_bucket, steel_bucket.getUnlocalizedName());
		GameRegistry.registerItem(steel_bucket_water, steel_bucket_water.getUnlocalizedName());
		GameRegistry.registerItem(steel_bucket_lava, steel_bucket_lava.getUnlocalizedName());
		GameRegistry.registerItem(steel_bucket_milk, steel_bucket_milk.getUnlocalizedName());
		GameRegistry.registerItem(wood_bucket, wood_bucket.getUnlocalizedName());
		GameRegistry.registerItem(wood_bucket_water, wood_bucket_water.getUnlocalizedName());
		GameRegistry.registerItem(wood_bucket_milk, wood_bucket_milk.getUnlocalizedName());
		
		GameRegistry.registerItem(rock, rock.getUnlocalizedName());
		GameRegistry.registerItem(meteorite1, meteorite1.getUnlocalizedName());
		GameRegistry.registerItem(meteorite2, meteorite2.getUnlocalizedName());
		GameRegistry.registerItem(meteorite3, meteorite3.getUnlocalizedName());
		GameRegistry.registerItem(meteorite4, meteorite4.getUnlocalizedName());
		
		GameRegistry.registerItem(bandage, bandage.getUnlocalizedName());
		
		GameRegistry.registerItem(vat_water, vat_water.getUnlocalizedName());
		GameRegistry.registerItem(vat_milk, vat_milk.getUnlocalizedName());
		GameRegistry.registerItem(vat_tannin, vat_tannin.getUnlocalizedName());
		
		GameRegistry.registerItem(flint_knife, flint_knife.getUnlocalizedName());
		GameRegistry.registerItem(flint_hatchet, flint_hatchet.getUnlocalizedName());
		GameRegistry.registerItem(stone_club, stone_club.getUnlocalizedName());
	
		GameRegistry.registerItem(fried_egg, fried_egg.getUnlocalizedName());
		GameRegistry.registerItem(hide, hide.getUnlocalizedName());
		GameRegistry.registerItem(animal_fat, animal_fat.getUnlocalizedName());
		GameRegistry.registerItem(Coke, Coke.getUnlocalizedName());
		GameRegistry.registerItem(malachite, malachite.getUnlocalizedName());
		GameRegistry.registerItem(pyrite, pyrite.getUnlocalizedName());
		GameRegistry.registerItem(saltpeter, saltpeter.getUnlocalizedName());
		GameRegistry.registerItem(sulfur, sulfur.getUnlocalizedName());
		GameRegistry.registerItem(ashes, ashes.getUnlocalizedName());
		GameRegistry.registerItem(potash, potash.getUnlocalizedName());
		GameRegistry.registerItem(borax, borax.getUnlocalizedName());
		GameRegistry.registerItem(mixed_flux, mixed_flux.getUnlocalizedName());
		GameRegistry.registerItem(nether_flux, nether_flux.getUnlocalizedName());
		
		GameRegistry.registerItem(copper_nugget, copper_nugget.getUnlocalizedName());
		GameRegistry.registerItem(iron_nugget, iron_nugget.getUnlocalizedName());
		GameRegistry.registerItem(lead_nugget, lead_nugget.getUnlocalizedName());
		GameRegistry.registerItem(tin_nugget, tin_nugget.getUnlocalizedName());
		GameRegistry.registerItem(zinc_nugget, zinc_nugget.getUnlocalizedName());
		GameRegistry.registerItem(nickel_nugget, nickel_nugget.getUnlocalizedName());
		GameRegistry.registerItem(cobalt_nugget, cobalt_nugget.getUnlocalizedName());
		GameRegistry.registerItem(titanium_nugget, titanium_nugget.getUnlocalizedName());

		GameRegistry.registerItem(lead_ingot, lead_ingot.getUnlocalizedName());
		GameRegistry.registerItem(rose_gold_ingot, rose_gold_ingot.getUnlocalizedName());
		
		GameRegistry.registerItem(copper_ingot, copper_ingot.getUnlocalizedName());
		GameRegistry.registerItem(brass_z_ingot, brass_z_ingot.getUnlocalizedName());
		GameRegistry.registerItem(brass_zz_ingot, brass_zz_ingot.getUnlocalizedName());
		GameRegistry.registerItem(bronze_t_ingot, bronze_t_ingot.getUnlocalizedName());
		GameRegistry.registerItem(bronze_tt_ingot, bronze_tt_ingot.getUnlocalizedName());
		GameRegistry.registerItem(bronze_tz_ingot, bronze_tz_ingot.getUnlocalizedName());

		GameRegistry.registerItem(steel_c_ingot, steel_c_ingot.getUnlocalizedName());
		GameRegistry.registerItem(steel_cc_ingot, steel_cc_ingot.getUnlocalizedName());
		GameRegistry.registerItem(steel_n_ingot, steel_n_ingot.getUnlocalizedName());
		GameRegistry.registerItem(steel_nn_ingot, steel_nn_ingot.getUnlocalizedName());
		GameRegistry.registerItem(steel_b_ingot, steel_b_ingot.getUnlocalizedName());
		GameRegistry.registerItem(steel_bb_ingot, steel_bb_ingot.getUnlocalizedName());
		GameRegistry.registerItem(steel_t_ingot, steel_t_ingot.getUnlocalizedName());
		GameRegistry.registerItem(steel_tt_ingot, steel_tt_ingot.getUnlocalizedName());

		GameRegistry.registerItem(steel_cn_ingot, steel_cn_ingot.getUnlocalizedName());
		GameRegistry.registerItem(steel_cb_ingot, steel_cb_ingot.getUnlocalizedName());
		GameRegistry.registerItem(steel_ct_ingot, steel_ct_ingot.getUnlocalizedName());
		GameRegistry.registerItem(steel_nb_ingot, steel_nb_ingot.getUnlocalizedName());
		GameRegistry.registerItem(steel_nt_ingot, steel_nt_ingot.getUnlocalizedName());
		GameRegistry.registerItem(steel_bt_ingot, steel_bt_ingot.getUnlocalizedName());
		
		GameRegistry.registerItem(u_rose_gold_ingot, u_rose_gold_ingot.getUnlocalizedName());

		GameRegistry.registerItem(u_brass_z_ingot, u_brass_z_ingot.getUnlocalizedName());
		GameRegistry.registerItem(u_brass_zz_ingot, u_brass_zz_ingot.getUnlocalizedName());
		GameRegistry.registerItem(u_bronze_t_ingot, u_bronze_t_ingot.getUnlocalizedName());
		GameRegistry.registerItem(u_bronze_tt_ingot, u_bronze_tt_ingot.getUnlocalizedName());
		GameRegistry.registerItem(u_bronze_tz_ingot, u_bronze_tz_ingot.getUnlocalizedName());

		GameRegistry.registerItem(u_steel_c_ingot, u_steel_c_ingot.getUnlocalizedName());
		GameRegistry.registerItem(u_steel_cc_ingot, u_steel_cc_ingot.getUnlocalizedName());
		GameRegistry.registerItem(u_steel_n_ingot, u_steel_n_ingot.getUnlocalizedName());
		GameRegistry.registerItem(u_steel_nn_ingot, u_steel_nn_ingot.getUnlocalizedName());
		GameRegistry.registerItem(u_steel_b_ingot, u_steel_b_ingot.getUnlocalizedName());
		GameRegistry.registerItem(u_steel_bb_ingot, u_steel_bb_ingot.getUnlocalizedName());
		GameRegistry.registerItem(u_steel_t_ingot, u_steel_t_ingot.getUnlocalizedName());
		GameRegistry.registerItem(u_steel_tt_ingot, u_steel_tt_ingot.getUnlocalizedName());

		GameRegistry.registerItem(u_steel_cn_ingot, u_steel_cn_ingot.getUnlocalizedName());
		GameRegistry.registerItem(u_steel_cb_ingot, u_steel_cb_ingot.getUnlocalizedName());
		GameRegistry.registerItem(u_steel_ct_ingot, u_steel_ct_ingot.getUnlocalizedName());
		GameRegistry.registerItem(u_steel_nb_ingot, u_steel_nb_ingot.getUnlocalizedName());
		GameRegistry.registerItem(u_steel_nt_ingot, u_steel_nt_ingot.getUnlocalizedName());
		GameRegistry.registerItem(u_steel_bt_ingot, u_steel_bt_ingot.getUnlocalizedName());

	}
}
