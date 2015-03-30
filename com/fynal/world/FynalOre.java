package com.fynal.world;

import java.util.Random;

import com.fynal.block.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class FynalOre implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1:
			generateNether(random, chunkX*16, chunkZ*16, world);
			break;
		case 0:
			generateOverworld(random, chunkX*16, chunkZ*16, world);
			break;
		case 1:
			generateEnd(random, chunkX*16, chunkZ*16, world);
			break;
			
		}

	}
	
	private void addOre(Block block, Block blockspawn, Random random, World world, int posX, int posZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int spawnAttempts, int spawnPercentChance, int veinStyle){
	
		if(random.nextInt(100) < spawnPercentChance){
			
		for(int i = 0; i < spawnAttempts; i++){
			
			int xPos = posX + random.nextInt(16);
			int zPos = posZ + random.nextInt(16);
			int yPos = minY + random.nextInt(maxY - minY);			
			
			if(veinStyle==0){		
//			vanilla generator below. ew. who needs 15 cosines to generate a 3 block vein?			
//			new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), blockspawn).generate(world, random, xPos, yPos, zPos);
			generateCoilcraftVein(block, blockspawn, world, random, minVeinSize + random.nextInt(maxVeinSize - minVeinSize), xPos, yPos, zPos);
			}
			
			if(veinStyle==1){
				generatePeatVein(block, blockspawn, world, random, minVeinSize + random.nextInt(maxVeinSize - minVeinSize), xPos, yPos, zPos);
			}
			
			if(veinStyle==2){
//			vanilla generator below. ew. who needs 15 cosines to generate a 3-5 block vein?			
			new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), blockspawn).generate(world, random, xPos, yPos, zPos);
			}
			
			if(veinStyle==3){
//			for spawning sticks, rocks, etc on the ground
				generateGroundSpawn(world, random, xPos, yPos, zPos);
			}
			
			if(veinStyle==4){
//				for spawning sulfur in the nether
					generateNetherSulfur(world, random, xPos, yPos, zPos);
				}

		}
			
		}
		
	}
	
	private Block getRareGroundSpawn(int i){
		return(i==0 ? ModBlocks.groundGoldNugget : (i==1 ? ModBlocks.groundMeteorite1 : (i==2 ? ModBlocks.groundMeteorite2 : (i==3 ? ModBlocks.groundMeteorite3 : (i==4 ? ModBlocks.groundMeteorite4 : ModBlocks.groundRock)))));
	}
	
	private void generateGroundSpawn(World world, Random random, int x, int y, int z) {
		if((world.getBlock(x, y+1, z) == Blocks.air || world.getBlock(x, y+1, z) == Blocks.tallgrass) && world.getBlock(x, y, z).isOpaqueCube() && !world.getBlock(x, y, z).isLeaves(world, x, y, z)){
			Block ontopof = world.getBlock(x , y, z);
			Block result;
			int chance = random.nextInt(31);
			int rarechance = random.nextInt(5);
			if(ontopof==Blocks.stone){
				result = (chance < 20 ? ModBlocks.groundRock : (chance < 23 ? ModBlocks.groundStick : (chance < 26 ? ModBlocks.groundFlint : (chance < 30 ? ModBlocks.groundCopperNugget : this.getRareGroundSpawn(rarechance)))));
			}else{
				result = (chance < 16 ? ModBlocks.groundRock : (chance < 25 ? ModBlocks.groundStick : (chance < 27 ? ModBlocks.groundFlint : (chance < 30 ? ModBlocks.groundCopperNugget : this.getRareGroundSpawn(rarechance)))));
			}
			world.setBlock(x, y+1, z, result);
		}
	}
	
	private void generateNetherSulfur(World world, Random random, int x, int y, int z) {
		if(world.getBlock(x, y+1, z) == Blocks.air && world.getBlock(x, y, z) == Blocks.netherrack){
			world.setBlock(x, y+1, z, ModBlocks.groundSulfur);
		}
	}

	private void generateCoilcraftVein(Block oreBlock, Block inBlock, World world, Random random, int sizeLimit, int xi, int yi, int zi){
	
	//	MAX VEIN SIZE 8, more efficient/simple/straightforward than built-in MC generator	
		int[] d = {0,0,0, 0,1,0, 1,1,0, 1,0,0, 0,0,1, 0,1,1, 1,1,1, 1,0,1};
	//	this order is designed to generate continuous veins or veins separated diagonally in xz (but not xy, zy, xzy)
		
		int index = 3*(random.nextInt(7));
		int dx = 0;
		int dy = 0;
		int dz = 0;
		
		for(int attempt = 0; attempt < sizeLimit; attempt++){
		dx = d[index];
		dy = d[index+1];
		dz = d[index+2];
		
		if(world.getBlock(xi+dx, yi+dy, zi+dz)==inBlock){
			world.setBlock(xi+dx, yi+dy, zi+dz, oreBlock);
		}
		
		index = index + 3;
		if(index > 21){index = 0;}
		}

	}
	
	private void generatePeatVein(Block oreBlock, Block inBlock, World world, Random random, int sizeLimit, int xi, int yi, int zi){
		
		if(world.getBlock(xi, yi, zi)!=inBlock){
			return;
		}	
		
		int dy = 0;
		int dx = 0;
		int dz = 0;
		int style = random.nextInt(3);
		int index = 16*style; //possible index starts: 0, 16, 32, 48
		int breakpoint = 16*(style+1); //possible breakpoints 16, 32, 48, 64
		int[] d = {
				0,0, 1,0, 0,1, -1,0, 0,-1, 1,1, -1,-1, 0,0,
				0,0, -1,0, 0,1, 0,-1, 1,0, -1,1, 1,-1, 0,0,
				0,0, 0,1, 1,0, 0,-1, -1,0, 1,1, 1,-1, 2,0,
				0,0, 0,-1, 1,0, -1,0, 0,1, -1,-1, 1,-1, 0,-2
		};
		
		for(int spawnCounter = 0; spawnCounter < sizeLimit; spawnCounter++){
			
			dx = d[index];
			dz = d[index+1];
			
			if(world.getBlock(xi+dx, yi+dy, zi+dz)==inBlock){
				world.setBlock(xi+dx, yi+dy, zi+dz, oreBlock);
				
			index = index + 2;
			
			if(index==breakpoint){
				style = random.nextInt(3);
				index = 16*style;
				breakpoint = 16*(style+1);
				dy--;
			}

			}
	
			
			
		}
		
	}

	private void generateEnd(Random random, int chunkX, int chunkZ, World world) {
		// TODO Auto-generated method stub
		
	}

	private void generateOverworld(Random random, int chunkX, int chunkZ, World world) {
	//addOre(ModBlocks.ORE, Blocks.stone/dirt, random, world, chunkX, chunkZ, MIN_HEIGHT, MAX_HEIGHT, MIN_VEIN, MAX_VEIN, SPAWN_ATTEMPTS, %CHANCE_PER_CHUNK, VEINTYPE);
	
	//ground spawn. only takes a few parameters (location, min/max height, and # of attempts)
	addOre(Blocks.air, Blocks.air, random, world, chunkX, chunkZ, 50, 100, -1, -1, 60, 100, 3);
	
	//dirt ores
	addOre(ModBlocks.MalachiteOre, Blocks.dirt, random, world, chunkX, chunkZ, 45, 90, 2, 4, 55, 100, 0);
	addOre(ModBlocks.Peat, Blocks.dirt, random, world, chunkX, chunkZ, 50, 90, 10, 25, 50, 100, 1);
	addOre(ModBlocks.FossilOre, Blocks.dirt, random, world, chunkX, chunkZ, 45, 90, 1, 3, 10, 100, 0);
	addOre(ModBlocks.PyriteOre, Blocks.dirt, random, world, chunkX, chunkZ, 45, 90, 1, 2, 15, 100, 0);
	
	//sandstone ores
	addOre(ModBlocks.DesertLapisOre, Blocks.sandstone, random, world, chunkX, chunkZ, 55, 80, 1, 8, 15, 100, 0);
	
	//common stone ores
	addOre(ModBlocks.CopperOre, Blocks.stone, random, world, chunkX, chunkZ, 20, 90, 3, 8, 22, 100, 0);
	addOre(ModBlocks.BoraxOre, Blocks.stone, random, world, chunkX, chunkZ, 7, 90, 15, 25, 1, 50, 2);
	addOre(ModBlocks.BoraxOre, Blocks.stone, random, world, chunkX, chunkZ, 40, 90, 15, 25, 1, 50, 2);
	addOre(ModBlocks.BoraxOre, Blocks.stone, random, world, chunkX, chunkZ, 60, 90, 15, 25, 1, 50, 2);
	addOre(ModBlocks.SaltpeterOre, Blocks.stone, random, world, chunkX, chunkZ, 7, 90, 3, 15, 3, 100, 2);
	addOre(ModBlocks.LeadOre, Blocks.stone, random, world, chunkX, chunkZ, 7, 40, 2, 6, 8, 100, 0);
	
	//rare stone ores
	addOre(ModBlocks.TinOre, Blocks.stone, random, world, chunkX, chunkZ, 35, 90, 2, 6, 12, 12, 0);
	addOre(ModBlocks.ZincOre, Blocks.stone, random, world, chunkX, chunkZ, 35, 90, 2, 6, 12, 12, 0);
	addOre(ModBlocks.NickelOre, Blocks.stone, random, world, chunkX, chunkZ, 7, 40, 2, 6, 8, 22, 0);
	addOre(ModBlocks.CobaltOre, Blocks.stone, random, world, chunkX, chunkZ, 7, 30, 2, 4, 7, 10, 0);
	addOre(ModBlocks.TitaniumOre, Blocks.stone, random, world, chunkX, chunkZ, 7, 25, 2, 4, 6, 10, 0);

	}

	private void generateNether(Random random, int chunkX, int chunkZ, World world) {
		addOre(Blocks.air, Blocks.air, random, world, chunkX, chunkZ, 20, 110, -1, -1, 80, 100, 4);		
	}

}
