package cojo.clocks.gui;

import org.lwjgl.input.Keyboard;

import cojo.clocks.tileentities.TileEntityDigitalClock;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

public class GuiDigitalClock extends GuiScreen {

	private GuiButton butt1;
	
    /** Text field containing the clock's text color. */
    private GuiTextField colorTextField;
    
    private TileEntityDigitalClock clock;
	
	public GuiDigitalClock(TileEntityDigitalClock clock) {
		this.clock = clock;
	}
	
    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        this.colorTextField.updateCursorCounter();
    }
	
    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
    	this.buttonList.clear();
        this.buttonList.add(this.butt1 = new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, ": )"));
        this.colorTextField = new GuiTextField(this.fontRenderer, this.width / 2 - 150, 60, 300, 20);
        this.colorTextField.setMaxStringLength(32767);
        this.colorTextField.setFocused(true);
        this.colorTextField.setText(this.clock.getColor() + "");
    }
	
    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
    	this.colorTextField.drawTextBox();
        super.drawScreen(par1, par2, par3);
    }
    
    /**
     * Called when the mouse is clicked.
     */
    protected void mouseClicked(int par1, int par2, int par3)
    {
        super.mouseClicked(par1, par2, par3);
        this.colorTextField.mouseClicked(par1, par2, par3);
    }
    
    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char par1, int par2)
    {
        this.colorTextField.textboxKeyTyped(par1, par2);
    }

}
