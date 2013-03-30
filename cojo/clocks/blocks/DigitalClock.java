package cojo.clocks.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cojo.clocks.tileentities.TileEntityDigitalClock;

public class DigitalClock extends ClockBlockContainer {

	public DigitalClock(int id) {
		super(id, Material.circuits);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public String getImageName() {
		return "digiclock";
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityDigitalClock();
	}

}
