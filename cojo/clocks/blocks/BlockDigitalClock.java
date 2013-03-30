package cojo.clocks.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cojo.clocks.gui.GuiDigitalClock;
import cojo.clocks.tileentities.TileEntityDigitalClock;
import cpw.mods.fml.common.FMLCommonHandler;

public class BlockDigitalClock extends BlockClockContainer {

	public BlockDigitalClock(int id) {
		super(id, Material.circuits);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
    /**
     * Called upon block activation (right click on the block.)
     */
	@Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		TileEntity te = par1World.getBlockTileEntity(par2, par3, par4);
		
		if (te == null) return false;
		
		TileEntityDigitalClock clock = (TileEntityDigitalClock)te;
		
		if (clock == null) return false;
		
		FMLCommonHandler.instance().showGuiScreen(new GuiDigitalClock());
		
        return false;
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
