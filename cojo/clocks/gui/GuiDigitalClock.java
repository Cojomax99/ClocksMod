package cojo.clocks.gui;

import org.lwjgl.input.Keyboard;

import cojo.clocks.tileentities.TileEntityDigitalClock;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

public class GuiDigitalClock extends GuiScreen {

	private GuiButton rLeft;
	private GuiButton rRight;
	private GuiButton gLeft;
	private GuiButton gRight;
	private GuiButton bLeft;
	private GuiButton bRight;
	
    /** Text field containing the clock's red text color. */
    private GuiTextField colorTextFieldR;
    
    /** Text field containing the clock's green text color. */
    private GuiTextField colorTextFieldG;
    
    /** Text field containing the clock's blue text color. */
    private GuiTextField colorTextFieldB;
    
    private TileEntityDigitalClock clock;
	
	public GuiDigitalClock(TileEntityDigitalClock clock) {
		this.clock = clock;
	}
	
    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        this.colorTextFieldR.updateCursorCounter();
        this.colorTextFieldG.updateCursorCounter();
        this.colorTextFieldB.updateCursorCounter();
    }
	
    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
    	this.buttonList.clear();
    	//id x y width height text
        this.buttonList.add(this.rLeft = new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, 20, 20, "<"));
        this.buttonList.add(this.rRight = new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, 20, 20, ">"));
        this.buttonList.add(this.gLeft = new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, 20, 20, "<"));
        this.buttonList.add(this.gRight = new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, 20, 20, ">"));
        this.buttonList.add(this.bLeft = new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, 20, 20, "<"));
        this.buttonList.add(this.bRight = new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, 20, 20, ">"));
        //x y width height
        this.colorTextFieldR = new GuiTextField(this.fontRenderer, this.width / 2 - 150, 60, 40, 20);
        this.colorTextFieldR.setMaxStringLength(32767);
        this.colorTextFieldR.setFocused(true);
        this.colorTextFieldR.setText(this.clock.getRed() + "");
        
        this.colorTextFieldG = new GuiTextField(this.fontRenderer, this.width / 2 - 150, 90, 40, 20);
        this.colorTextFieldG.setMaxStringLength(32767);
        this.colorTextFieldG.setText(this.clock.getGreen() + "");
        
        this.colorTextFieldB = new GuiTextField(this.fontRenderer, this.width / 2 - 150, 120, 40, 20);
        this.colorTextFieldB.setMaxStringLength(32767);
        this.colorTextFieldB.setText(this.clock.getBlue() + "");
    }
	
    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
    	this.colorTextFieldR.drawTextBox();
    	this.colorTextFieldG.drawTextBox();
    	this.colorTextFieldB.drawTextBox();
        super.drawScreen(par1, par2, par3);
    }
    
    /**
     * Called when the mouse is clicked.
     */
    protected void mouseClicked(int par1, int par2, int par3)
    {
        super.mouseClicked(par1, par2, par3);
        this.colorTextFieldR.mouseClicked(par1, par2, par3);
        this.colorTextFieldG.mouseClicked(par1, par2, par3);
        this.colorTextFieldB.mouseClicked(par1, par2, par3);
    }
    
    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char par1, int par2)
    {
        this.colorTextFieldR.textboxKeyTyped(par1, par2);
        this.colorTextFieldG.textboxKeyTyped(par1, par2);
        this.colorTextFieldB.textboxKeyTyped(par1, par2);
    	super.keyTyped(par1, par2);

    }

}
