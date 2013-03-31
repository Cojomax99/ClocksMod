package cojo.clocks.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.lwjgl.input.Keyboard;

import cojo.clocks.tileentities.TileEntityDigitalClock;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

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
		this.buttonList.add(this.rLeft = new GuiButton(0, this.width / 2 - 180, this.height / 4 + 96 - 96, 20, 20, "<"));
		this.buttonList.add(this.rRight = new GuiButton(1, this.width / 2 - 110, this.height / 4 + 96 - 96, 20, 20, ">"));
		this.buttonList.add(this.gLeft = new GuiButton(2, this.width / 2 - 180, this.height / 4 + 96 - 46, 20, 20, "<"));
		this.buttonList.add(this.gRight = new GuiButton(3, this.width / 2 - 110, this.height / 4 + 96 - 46, 20, 20, ">"));
		this.buttonList.add(this.bLeft = new GuiButton(4, this.width / 2 - 180, this.height / 4 + 96 + 6, 20, 20, "<"));
		this.buttonList.add(this.bRight = new GuiButton(5, this.width / 2 - 110, this.height / 4 + 96 + 6, 20, 20, ">"));
		//x y width height
		this.colorTextFieldR = new GuiTextField(this.fontRenderer, this.width / 2 - 150, this.height / 4 + 96 - 96, 30, 20);
		this.colorTextFieldR.setMaxStringLength(32767);
		this.colorTextFieldR.setFocused(true);
		this.colorTextFieldR.setText(this.clock.getRed() + "");

		this.colorTextFieldG = new GuiTextField(this.fontRenderer, this.width / 2 - 150, this.height / 4 + 96 - 46, 30, 20);
		this.colorTextFieldG.setMaxStringLength(32767);
		this.colorTextFieldG.setText(this.clock.getGreen() + "");

		this.colorTextFieldB = new GuiTextField(this.fontRenderer, this.width / 2 - 150, this.height / 4 + 96 + 6, 30, 20);
		this.colorTextFieldB.setMaxStringLength(32767);
		this.colorTextFieldB.setText(this.clock.getBlue() + "");
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	public void drawScreen(int par1, int par2, float par3)
	{
		this.drawGradientRect(0, 0, this.width, this.height, 0x000000aa, -0x000000aa);
		this.drawString(this.fontRenderer, "Red", this.width / 2 - 145, this.height / 4 + 96 - 110, 0xff0000);
		this.colorTextFieldR.drawTextBox();
		this.drawString(this.fontRenderer, "Green", this.width / 2 - 149, this.height / 4 + 96 - 60, 0x00ff00);
		this.colorTextFieldG.drawTextBox();
		this.drawString(this.fontRenderer, "Blue", this.width / 2 - 145, this.height / 4 + 96 - 10, 0x0000ff);
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

	/**
	 * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
	 */
	protected void actionPerformed(GuiButton btn)
	{
		if (btn.enabled)
		{
			if (btn.id == 0) {
				if (clock.getRed() > 0)
					this.clock.setRed(clock.getRed() - 1);
			} else
				if (btn.id == 1) {
					if (clock.getRed() < 255)
						this.clock.setRed(clock.getRed() + 1);
				} else
					if (btn.id == 2) {
						if (clock.getGreen() > 0)
							this.clock.setGreen(clock.getGreen() - 1);
					} else
						if (btn.id == 3) {
							if (clock.getGreen() < 255)
								this.clock.setGreen(clock.getGreen() + 1);
						} else
							if (btn.id == 4) {
								if (clock.getBlue() > 0)
									this.clock.setBlue(clock.getBlue() - 1);
							} else
								if (btn.id == 5) {
									if (clock.getBlue() < 255)
										this.clock.setBlue(clock.getBlue() + 1);
								}
			this.colorTextFieldR.setText(this.clock.getRed() + "");
			this.colorTextFieldG.setText(this.clock.getGreen() + "");
			this.colorTextFieldB.setText(this.clock.getBlue() + "");
		}
	}

}
