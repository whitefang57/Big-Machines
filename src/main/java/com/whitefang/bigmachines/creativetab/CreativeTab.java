package com.whitefang.bigmachines.creativetab;

import com.whitefang.bigmachines.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class CreativeTab {
	public static final CreativeTabs BM_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.furnace);
		}
	};
}
