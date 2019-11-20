package net.transit.type.group.simple;

import net.minecraft.block.FluidBlock;
import net.minecraft.item.Item;
import net.transit.type.group.GroupRegistry;
import net.transit.type.group.TypeGroup;

/**
 * @author Kyle Gunger
 *
 * @apiNote Basic default groups which all mods are welcome to add themselves to.
 */
public class SimpleGroups
{
	public static final TypeGroup<Number> ENERGY_GROUP = new EnergyGroup();
	public static final TypeGroup<Number> MANA_GROUP = new ManaGroup();
	public static final TypeGroup<Item> ITEM_GROUP = new ItemGroup();
	public static final TypeGroup<FluidBlock> FLUID_GROUP = new FluidGroup();
	public static void initGroups()
	{
		GroupRegistry.addGroup(ENERGY_GROUP, "ENERGY");
		GroupRegistry.addGroup(MANA_GROUP, "MANA");
		GroupRegistry.addGroup(ITEM_GROUP, "ITEM");
		GroupRegistry.addGroup(FLUID_GROUP, "FLUID");
	}
}
