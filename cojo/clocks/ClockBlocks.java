package cojo.clocks;

import net.minecraft.block.Block;
import cojo.clocks.blocks.DigitalClock;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ClockBlocks {
	
	public static Block clock;
	
	public static void init() {
		clock = new DigitalClock(ModIds.BLOCK_DIGITAL_CLOCK).setUnlocalizedName("digitalClock");
	}
	
	private static void registerBlock(Block block, String name) {
		LanguageRegistry.addName(block, name);
		GameRegistry.registerBlock(block, name);
	}
}
