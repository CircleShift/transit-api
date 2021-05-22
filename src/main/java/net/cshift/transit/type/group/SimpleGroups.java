package net.cshift.transit.type.group;

import net.cshift.transit.type.*;

public final class SimpleGroups {
	/** Transfers energy.  Basic unit is TJoule (Transit Joule).
	 */
	public static final TypeGroup<Number> ENERGY = new TypeGroup<Number>(SimpleTypes.TransitJoule);

	/** Transfers mana.  Basic unit is TMana (Transit Mana).
	 */
	public static final TypeGroup<TMana> MANA = new TypeGroup<TMana>(SimpleTypes.TransitMana);

	/** Transfers items. Basic unit is TItem.
	 */
	public static final TypeGroup<TItem> ITEM = new TypeGroup<TItem>(SimpleTypes.TransitItem);

	/** Transfers fluids.  Basic unit is TFluid.
	 */
	public static final TypeGroup<TFluid> FLUID = new TypeGroup<TFluid>(SimpleTypes.TransitFluid);
	
	public static final void init()
	{
		GroupRegistry.addGroup(ENERGY);
		GroupRegistry.addGroup(MANA);
		GroupRegistry.addGroup(ITEM);
		GroupRegistry.addGroup(FLUID);
	}
}
