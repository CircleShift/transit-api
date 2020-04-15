package net.transit.type.simple;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.transit.type.Type;

public final class SimpleTypes {
	public static final Type<Number> TransitJoule = new Type<Number>("TJoule", "ENERGY");
	public static final Type<Number> TransitMana = new Type<Number>("TMana", "MANA");
	public static final Type<Item> Item = new Type<Item>("Item", "ITEM");
	public static final Type<Fluid> Fluid = new Type<Fluid>("Fluid", "FLUID");
}
