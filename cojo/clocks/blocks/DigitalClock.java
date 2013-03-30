package cojo.clocks.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class DigitalClock extends ClockBlockContainer {

	public DigitalClock(int id) {
		super(id, Material.circuits);
	}

	@Override
	public String getImageName() {
		return "digiclock";
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}

}
