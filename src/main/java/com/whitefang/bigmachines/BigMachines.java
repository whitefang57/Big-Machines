package com.whitefang.bigmachines;

import com.whitefang.bigmachines.handler.ConfigurationHandler;
import com.whitefang.bigmachines.init.ModBlocks;
import com.whitefang.bigmachines.init.ModItems;
import com.whitefang.bigmachines.proxy.IProxy;
import com.whitefang.bigmachines.reference.Reference;
import com.whitefang.bigmachines.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION,
		guiFactory = Reference.GUI_FACTORY_CLASS)
public class BigMachines {
	@Mod.Instance(Reference.MOD_ID)
	public static BigMachines instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		ModItems.init();
		ModBlocks.init();
		LogHelper.info("Pre Initialization Complete!");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		LogHelper.info("Initialization Complete!");
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		LogHelper.info("Post Initialization Complete!");
	}
}