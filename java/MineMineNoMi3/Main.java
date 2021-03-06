package MineMineNoMi3;

import java.util.logging.Logger;

import MineMineNoMi3.commands.CommandBelly;
import MineMineNoMi3.commands.CommandBounty;
import MineMineNoMi3.commands.CommandDoriki;
import MineMineNoMi3.commands.CommandExtol;
import MineMineNoMi3.gui.GUIHandler;
import MineMineNoMi3.lists.ID;
import MineMineNoMi3.lists.ListCreativeTabs;
import MineMineNoMi3.lists.ListDevilFruits;
import MineMineNoMi3.lists.ListEffects;
import MineMineNoMi3.lists.ListEntities;
import MineMineNoMi3.lists.ListExtraAttributes;
import MineMineNoMi3.lists.ListForge;
import MineMineNoMi3.lists.ListMisc;
import MineMineNoMi3.lists.ListPackets;
import MineMineNoMi3.lists.ListRecipes;
import MineMineNoMi3.proxy.CommonProxy;
import WyPI.WyPI;
import WyPI.modules.WyDebug;
import WyPI.modules.WyHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ID.PROJECT_ID, name = ID.PROJECT_NAME, version = ID.PROJECT_VERSION)
public class Main 
{

	@Instance(ID.PROJECT_ID)
	private static Main instance;	
	@SidedProxy(clientSide = "MineMineNoMi3.proxy.ClientProxy", serverSide = "MineMineNoMi3.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static Logger logger = Logger.getLogger(ID.PROJECT_ID);
	public static WyPI API;
	public static MainConfig config;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{	   
		this.API = new WyPI(this.getMineMineNoMi(), "E:/Programming/Minecraft Mods/src/main/resources");
		MainConfig.init(event.getSuggestedConfigurationFile());
		
		ListPackets.init();
		ListDevilFruits.init(); 
		ListExtraAttributes.init();
		ListMisc.init();
		ListEntities.init();		
		
		proxy.preInit();
		if(WyDebug.instance().isDebug())
			WyHelper.instance().generateJSONModels(false);
	}  
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{ 
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIHandler());
		GameRegistry.registerWorldGenerator(new MainWorldGen(), 1);	
		
		proxy.init(); 
		
		ListEffects.init();
		ListCreativeTabs.init();
		ListRecipes.init(); 
		ListForge.init(); 
		
		if(WyDebug.instance().isDebug())
			WyHelper.instance().generateLangFiles();
	} 
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {}	
	
	@EventHandler
	public void serverInit(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandDoriki());
		event.registerServerCommand(new CommandBelly());
		event.registerServerCommand(new CommandExtol());
		event.registerServerCommand(new CommandBounty());
	}

	public static Main getMineMineNoMi() {return instance;}
	public String getModId() { return "mineminenomi"; }
}
