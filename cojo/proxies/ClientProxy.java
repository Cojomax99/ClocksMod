package cojo.proxies;

import cojo.clocks.tileentities.TileEntityDigitalClock;
import cojo.clocks.tileentities.TileEntityDigitalClockRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	public void registerTESRs() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDigitalClock.class, new TileEntityDigitalClockRenderer());
	}
}
