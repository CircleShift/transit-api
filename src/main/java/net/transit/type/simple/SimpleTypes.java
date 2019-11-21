package net.transit.type.simple;

import net.minecraft.block.FluidBlock;
import net.minecraft.item.Item;
import net.transit.type.Type;

public final class SimpleTypes {
	public static final Type<Number> ENERGY = new Type<Number>("ENERGY", "ENERGY");
	public static final Type<Number> MANA = new Type<Number>("MANA", "MANA");
	public static final Type<Item> ITEM = new Type<Item>("ITEM", "ITEM");
	public static final Type<FluidBlock> FLUID = new Type<FluidBlock>("FLUID", "FLUID");
}
