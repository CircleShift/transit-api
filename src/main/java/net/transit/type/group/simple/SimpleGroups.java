package net.transit.type.group.simple;

import net.minecraft.block.FluidBlock;
import net.minecraft.item.Item;
import net.transit.type.group.GroupRegistry;
import net.transit.type.group.TypeGroup;
import net.transit.type.simple.SimpleTypes;

public final class SimpleGroups {
	public static final TypeGroup<Number> ENERGY_GROUP = new TypeGroup<Number>(SimpleTypes.ENERGY);
	public static final TypeGroup<Number> MANA_GROUP = new TypeGroup<Number>(SimpleTypes.MANA);
	public static final TypeGroup<Item> ITEM_GROUP = new TypeGroup<Item>(SimpleTypes.ITEM);
	public static final TypeGroup<FluidBlock> FLUID_GROUP = new TypeGroup<FluidBlock>(SimpleTypes.FLUID);
	
	public static final void init()
	{
		GroupRegistry.addGroup(ENERGY_GROUP);
		GroupRegistry.addGroup(MANA_GROUP);
		GroupRegistry.addGroup(ITEM_GROUP);
		GroupRegistry.addGroup(FLUID_GROUP);
	}
}
