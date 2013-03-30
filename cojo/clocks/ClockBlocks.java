package cojo.clocks;

import net.minecraft.block.Block;
import cojo.clocks.blocks.BlockDigitalClock;
import cojo.clocks.tileentities.TileEntityDigitalClock;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ClockBlocks {
	
	public static Block digiClock;
	
	public static void init() {
		digiClock = new BlockDigitalClock(ModIds.BLOCK_DIGITAL_CLOCK).setUnlocalizedName("digitalClock");
		
		registerBlock(digiClock, "Digital Clock");
		
		GameRegistry.registerTileEntity(TileEntityDigitalClock.class, "DigitalClock");
	}
	
	private static void registerBlock(Block block, String name) {
		LanguageRegistry.addName(block, name);
		GameRegistry.registerBlock(block, name);
	}
}
