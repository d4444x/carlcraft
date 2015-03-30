package com.fynal.handler;

import net.minecraft.init.Blocks;
import net.minecraftforge.event.terraingen.OreGenEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class OreGenSuppressor {

	@SubscribeEvent(priority=EventPriority.HIGHEST, receiveCanceled=true)
	public void onEvent(OreGenEvent.GenerateMinable event)
	{
		if(event.type == event.type.DIAMOND)
		event.setResult(Result.DENY);
		if(event.type == event.type.LAPIS)
		event.setResult(Result.DENY);
	}
	
}
