package com.fynal.entity;

import net.minecraft.entity.EntityList;

import com.fynal.Main.MainRegistry;

import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityInitializer {

	public static void mainRegistry(){
		registerEntity();
	}
	
	public static void registerEntity(){
		EntityRegistry.registerModEntity(EntityBullet.class, "Bullet", 1, MainRegistry.modInstance, 120, 3, true );
		
		//no longer needed
		//createEntity(EntityFynalCow.class, "fynalCow", 0x0, 0x0);
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor){
		int randomId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, MainRegistry.modInstance, 10, 1, true);
		//EntityRegistry.addSpawn(entityClass, weightedProb, min, max, typeOfCreature, biomes);
		CreateEgg(randomId, solidColor, spotColor);
	}
	
	private static void CreateEgg(int randomId, int solidColor, int spotColor){
		//see youtube video watch?v=cMzrvQSyIY8 ~8:40
	}
	
}










