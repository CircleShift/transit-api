package net.corechg.transit.type.simple;

import net.minecraft.item.ItemStack;
import net.corechg.transit.type.*;

public final class SimpleTypes {
	/** Transfers energy.  Energy is stored as a numeric, base value is TJoule (TransitJoule)
	 */
	public static final Type<Number> TransitJoule = new Type<Number>("TJoule", "ENERGY");
	
	/** Transfers mana.  TMana stores mana count and type.
	 */
	public static final Type<TMana> TransitMana = new Type<TMana>("TMana", "MANA");

	/** Transfers items in a itemstack.
	 */
	public static final Type<ItemStack> Item = new Type<ItemStack>("Item", "ITEM");

	/** Transfers fluid. TFluid stores fluid and mB.
	 */
	public static final Type<TFluid> Fluid = new Type<TFluid>("Fluid", "FLUID");
}
