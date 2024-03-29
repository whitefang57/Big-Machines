package com.whitefang.bigmachines.tileentity;

import com.whitefang.bigmachines.reference.Names;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityBM extends TileEntity {
	protected ForgeDirection orientation;
	protected byte state;
	protected String customName;

	public TileEntityBM() {
		orientation = ForgeDirection.SOUTH;
		state = 0;
		customName = "";
	}

	public ForgeDirection getOrientation() {
		return orientation;
	}

	public void setOrientation(ForgeDirection orientation) {
		this.orientation = orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = ForgeDirection.getOrientation(orientation);
	}

	public short getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);

		if (nbtTagCompound.hasKey(Names.NBT.DIRECTION)) {
			this.orientation = ForgeDirection.getOrientation(nbtTagCompound.getByte(Names.NBT.DIRECTION));
		}

		if (nbtTagCompound.hasKey(Names.NBT.STATE)) {
			this.state = nbtTagCompound.getByte(Names.NBT.STATE);
		}

		if (nbtTagCompound.hasKey(Names.NBT.CUSTOM_NAME)) {
			this.customName = nbtTagCompound.getString(Names.NBT.CUSTOM_NAME);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);

		nbtTagCompound.setByte(Names.NBT.DIRECTION, (byte) orientation.ordinal());
		nbtTagCompound.setByte(Names.NBT.STATE, state);

		if (this.hasCustomName()) {
			nbtTagCompound.setString(Names.NBT.CUSTOM_NAME, customName);
		}
	}

	public boolean hasCustomName() {
		return customName != null && customName.length() > 0;
	}

}
