package cojo.clocks.tileentities;

import net.minecraft.tileentity.TileEntity;

import org.lwjgl.util.Color;
import org.lwjgl.util.ReadableColor;

import cojo.clocks.time.TimeManager;

public class TileEntityDigitalClock extends TileEntity {

	private TimeManager timeManager;
	
	private Color textColor;
	
	public TileEntityDigitalClock() {
		timeManager = new TimeManager();
		textColor = new Color();
	}
	
    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
        super.updateEntity();
    }
    
    public String getCurrentDate() {
    	return timeManager.getCurrentDate();
    }
    
    public String getCurrentTime() {
    	return timeManager.getCurrentTime24();
    }
    
    public void setTextColor(int color) {
    	this.textColor.set(color & 0xff, (color << 8) & 0xff, (color << 16) & 0xff);
    }
    
    public Color getColor() {
    	return this.textColor;
    }
    
    public void setRed(int nRed) {
    	this.textColor.setRed(nRed);
    }
    
    public int getRed() {
    	return this.textColor.getRed();
    }
    
    public void setGreen(int nGreen) {
    	this.textColor.setGreen(nGreen);
    }

    public int getGreen() {
    	return this.textColor.getGreen();
    }
    
    public void setBlue(int nBlue) {
    	this.textColor.setBlue(nBlue);
    }
    
    public int getBlue() {
    	return this.textColor.getBlue();
    }
}
