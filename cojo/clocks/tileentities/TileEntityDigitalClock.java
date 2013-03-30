package cojo.clocks.tileentities;

import net.minecraft.tileentity.TileEntity;
import cojo.clocks.time.TimeManager;

public class TileEntityDigitalClock extends TileEntity {

	private TimeManager timeManager;
	
	public TileEntityDigitalClock() {
		timeManager = new TimeManager();
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

}
