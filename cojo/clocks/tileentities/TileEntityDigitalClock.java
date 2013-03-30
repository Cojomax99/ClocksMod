package cojo.clocks.tileentities;

import net.minecraft.tileentity.TileEntity;
import cojo.clocks.time.TimeManager;

public class TileEntityDigitalClock extends TileEntity {

	private TimeManager timeManager;
	
	private int textColor;
	
	public TileEntityDigitalClock() {
		timeManager = new TimeManager();
		textColor = 0;		//black by default
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
    	this.textColor = color;
    }
    
    public int getColor() {
    	return this.textColor;
    }

}
