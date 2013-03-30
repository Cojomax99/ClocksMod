package cojo.clocks.tileentities;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;

public class TileEntityDigitalClockRenderer extends TileEntitySpecialRenderer {

	public TileEntityDigitalClockRenderer() {

	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,
			double d2, float f) {
		renderDigitalClock((TileEntityDigitalClock)tileentity, d0, d1, d2, f);
	}

	private void renderDigitalClock(TileEntityDigitalClock clock, double x, double y, double z, float par8) {
		renderLivingLabel(clock, clock.getCurrentDate(), x, y, z, 2);		
	}
	
	 /**
     * Draws the debug or playername text above a living
     */
    protected void renderLivingLabel(TileEntityDigitalClock clock, String displayText, double x, double y, double z, int par9)
    {
        double d3 = 1.0;

        if (d3 <= (double)(par9 * par9))
        {
            FontRenderer fontrenderer = this.getFontRenderer();
            float f = 1.6F;
            float f1 = 0.016666668F * f;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)x + 0.5F, (float)y + 0.5F, (float)z);
            GL11.glNormal3f(0.0F, 1.0F, 0.0F);
            //TODO: determine direction based on face of clock
         //   GL11.glRotatef(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
       //     GL11.glRotatef(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
            GL11.glScalef(-f1, -f1, f1);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDepthMask(false);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            Tessellator tessellator = Tessellator.instance;
            byte b0 = 0;

            GL11.glDisable(GL11.GL_TEXTURE_2D);
            tessellator.startDrawingQuads();
            int j = fontrenderer.getStringWidth(displayText) / 2;
            tessellator.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.25F);
            tessellator.addVertex((double)(-j - 1), (double)(-1 + b0), 0.0D);
            tessellator.addVertex((double)(-j - 1), (double)(8 + b0), 0.0D);
            tessellator.addVertex((double)(j + 1), (double)(8 + b0), 0.0D);
            tessellator.addVertex((double)(j + 1), (double)(-1 + b0), 0.0D);
            tessellator.draw();
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            /**
             * Draws the specified string. Args: string, x, y, color, dropShadow
             */
            fontrenderer.drawString(displayText, -fontrenderer.getStringWidth(displayText) / 2, b0, 553648127);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glDepthMask(true);
            fontrenderer.drawString(displayText, -fontrenderer.getStringWidth(displayText) / 2, b0, -1);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
        }
    }

}
