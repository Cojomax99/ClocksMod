package cojo.clocks.tileentities;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDigitalClockRenderer extends TileEntitySpecialRenderer {

	public TileEntityDigitalClockRenderer() {

	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,
			double d2, float f) {
		renderDigitalClock((TileEntityDigitalClock)tileentity, d0, d1, d2, f);
	}

	private void renderDigitalClock(TileEntityDigitalClock clock, double x, double y, double z, float tick) {
		FontRenderer fontrenderer = this.getFontRenderer();

		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y, (float)z + 0.5F);
		// GL11.glDepthMask(false);

		fontrenderer.drawString("hello !", -fontrenderer.getStringWidth("hello !") / 2, 10 - "hello !".length() * 5, 0);
		//	 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		// GL11.glDepthMask(true);
		GL11.glPushMatrix();
	}

}
