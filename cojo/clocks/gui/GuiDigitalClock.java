package cojo.clocks.gui;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

public class GuiDigitalClock extends GuiScreen {

	private GuiButton butt1;
	
	public GuiDigitalClock() {
		
	}
	
    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
    	this.buttonList.clear();
        this.buttonList.add(this.butt1 = new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, ": )"));
    }
	
    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        super.drawScreen(par1, par2, par3);
    }

}
