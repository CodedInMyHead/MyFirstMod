package micha.michadidthis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import micha.michadidthis.lists.ArmourMaterialList;
import micha.michadidthis.lists.BlockList;
import micha.michadidthis.lists.ItemList;
import micha.michadidthis.lists.ToolMaterialList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("michadidthis")
public class MichaDidThis {
	
	public static MichaDidThis instance;
	public static final String MODID = "michadidthis";
	private static final Logger logger = LogManager.getLogger(MODID);
	
	public static final ItemGroup myGroup = new MichaItemGroup();
	
	public MichaDidThis() {
		
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		logger.info("Setup Method registered!");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) {
		logger.info("clientRegistries Method registered!");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents{
		
		@SubscribeEvent
		public static  void registerItems(final RegistryEvent.Register<Item> event) {
			
			event.getRegistry().registerAll(
				ItemList.diamond_cutter = new Item(new Item.Properties().group(myGroup)).setRegistryName(location("diamond_cutter")),
				ItemList.charged_gunpowder = new Item(new Item.Properties().group(myGroup)).setRegistryName(location("charged_gunpowder")),
				ItemList.thunder_ingot = new Item(new Item.Properties().group(myGroup)).setRegistryName(location("thunder_ingot")),
				
				ItemList.example_axe = new AxeItem(ToolMaterialList.test_tool, -1.0f, 6.0f, new Item.Properties().group(myGroup)).setRegistryName(location("example_axe")),
				ItemList.example_hoe = new HoeItem(ToolMaterialList.test_tool, 6.0f, new Item.Properties().group(myGroup)).setRegistryName(location("example_hoe")),
				ItemList.example_shovel = new ShovelItem(ToolMaterialList.test_tool, -3.0f, 6.0f, new Item.Properties().group(myGroup)).setRegistryName(location("example_shovel")),
				ItemList.example_pickaxe = new PickaxeItem(ToolMaterialList.test_tool, -2, 6.0f, new Item.Properties().group(myGroup)).setRegistryName(location("example_pickaxe")),
				ItemList.example_sword = new SwordItem(ToolMaterialList.test_tool, 0, 6.0f, new Item.Properties().group(myGroup)).setRegistryName(location("example_sword")),
				ItemList.bloody_sword = new SwordItem(ToolMaterialList.fallen_warrior, 0, 6.0f, new Item.Properties().group(myGroup)).setRegistryName(location("bloody_sword")),
				ItemList.ice_sword = new SwordItem(ToolMaterialList.ice_tools, 0, 6.0f, new Item.Properties().group(myGroup)).setRegistryName(location("ice_sword")),
														
				ItemList.rich_helmet = new ArmorItem(ArmourMaterialList.rich_material, EquipmentSlotType.HEAD, new Item.Properties().group(myGroup)).setRegistryName(location("rich_helmet")),
				ItemList.rich_chestplate = new ArmorItem(ArmourMaterialList.rich_material, EquipmentSlotType.CHEST, new Item.Properties().group(myGroup)).setRegistryName(location("rich_chestplate")),
				ItemList.rich_leggings = new ArmorItem(ArmourMaterialList.rich_material, EquipmentSlotType.LEGS, new Item.Properties().group(myGroup)).setRegistryName(location("rich_leggings")),
				ItemList.rich_boots = new ArmorItem(ArmourMaterialList.rich_material, EquipmentSlotType.FEET, new Item.Properties().group(myGroup)).setRegistryName(location("rich_boots")),
				
				ItemList.example_block = new BlockItem(BlockList.example_block, new Item.Properties().group(myGroup)).setRegistryName(BlockList.example_block.getRegistryName())
			);			
			
			logger.info("Items registered");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			
			event.getRegistry().registerAll(
					BlockList.example_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(8).sound(SoundType.METAL)).setRegistryName(location("example_block"))
			);			
			
			logger.info("Blocks registered");
		}
	}
	
	private static ResourceLocation location(String name) {
		return new ResourceLocation(MODID, name);
	}
}






























