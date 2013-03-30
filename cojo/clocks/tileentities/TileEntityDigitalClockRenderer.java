package cojo.clocks.tileentities;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDigitalClockRenderer extends TileEntitySpecialRenderer {

	public TileEntityDigitalClockRenderer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,
			double d2, float f) {
		renderDigitalClock((TileEntityDigitalClock)tileentity, d0, d1, d2, f);
	}
	
	private void renderDigitalClock(TileEntityDigitalClock clock, double x, double y, double z, float tick) {
		FontRenderer fontrenderer = this.getFontRenderer();
	}

}
