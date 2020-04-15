package net.transit.type.group.simple;

import net.minecraft.item.ItemStack;
import net.transit.type.group.GroupRegistry;
import net.transit.type.group.TypeGroup;
import net.transit.type.simple.SimpleTypes;
import net.transit.type.*;

public final class SimpleGroups {
	/** Transfers energy.  Basic unit is TJoule (Transit Joule).
	 */
	public static final TypeGroup<Number> ENERGY_GROUP = new TypeGroup<Number>(SimpleTypes.TransitJoule);

	/** Transfers mana.  Basic unit is TMana (Transit Mana).
	 */
	public static final TypeGroup<TMana> MANA_GROUP = new TypeGroup<TMana>(SimpleTypes.TransitMana);

	/** Transfers items. Basic type is ItemStack.
	 */
	public static final TypeGroup<ItemStack> ITEM_GROUP = new TypeGroup<ItemStack>(SimpleTypes.Item);

	/** Transfers fluids.  Basic unit is TFluid.
	 */
	public static final TypeGroup<TFluid> FLUID_GROUP = new TypeGroup<TFluid>(SimpleTypes.Fluid);
	
	public static final void init()
	{
		GroupRegistry.addGroup(ENERGY_GROUP);
		GroupRegistry.addGroup(MANA_GROUP);
		GroupRegistry.addGroup(ITEM_GROUP);
		GroupRegistry.addGroup(FLUID_GROUP);
	}
}
