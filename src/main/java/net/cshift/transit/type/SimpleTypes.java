package net.cshift.transit.type;

public final class SimpleTypes {
	/** Transfers energy.  Energy is stored as a numeric.
	 */
	public static final Type<Number> TransitJoule = new Type<Number>("TJoule", "ENERGY");
	
	/** Transfers mana.  TMana stores mana count and type.
	 */
	public static final Type<TMana> TransitMana = new Type<TMana>("TMana", "MANA");

	/** Transfers items. TItem stores an item and an item count.
	 */
	public static final Type<TItem> TransitItem = new Type<TItem>("TItem", "ITEM");

	/** Transfers fluid. TFluid stores fluid and mB.
	 */
	public static final Type<TFluid> TransitFluid = new Type<TFluid>("TFluid", "FLUID");
}
