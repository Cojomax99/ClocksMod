package cojo.clocks.tileentities;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class TileEntityDigitalClockRenderer extends TileEntitySpecialRenderer {

	public TileEntityDigitalClockRenderer() {

	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,
			double d2, float f) {
		renderDigitalClock((TileEntityDigitalClock)tileentity, d0, d1, d2, f);
	}

	private void renderDigitalClock(TileEntityDigitalClock clock, double x, double y, double z, float par8) {
		/*FontRenderer fontrenderer = this.getFontRenderer();

		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y, (float)z + 0.5F);
		// GL11.glDepthMask(false);

		fontrenderer.drawString("hello !", -fontrenderer.getStringWidth("hello !") / 2, 10 - "hello !".length() * 5, 0);
		//	 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		// GL11.glDepthMask(true);
		GL11.glPushMatrix();*/
		
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5F, (float)y, (float)z + 0.5F);
		Entity entity = new EntityPig(clock.getWorldObj());

		if (entity != null)
		{
			entity.setWorld(clock.getWorldObj());
			float f1 = 0.4375F;
			GL11.glTranslatef(0.0F, 0.4F, 0.0F);
		//	GL11.glRotatef((float)(par0MobSpawnerBaseLogic.field_98284_d + (par0MobSpawnerBaseLogic.field_98287_c - par0MobSpawnerBaseLogic.field_98284_d) * (double)par7) * 10.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-30.0F, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0.0F, -0.4F, 0.0F);
			GL11.glScalef(f1, f1, f1);
			entity.setLocationAndAngles(x, y, z, 0.0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(entity, 0.0D, 0.0D, 0.0D, 0.0F, par8);
		}
		
		GL11.glPopMatrix();
	}

}
