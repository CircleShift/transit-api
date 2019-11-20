package net.transit.type.simple;

import net.minecraft.block.FluidBlock;
import net.minecraft.item.Item;
import net.transit.type.Type;
import net.transit.type.group.simple.SimpleGroups;

/**
 * @author Kyle Gunger
 *
 * @apiNote Simple types which work as the base types for the simple groups.
 */
public class SimpleTypes
{
	public static final Type<Number> ENERGY_TYPE = new EnergyType();
	public static final Type<Number> MANA_TYPE = new ManaType();
	public static final Type<Item> ITEM_TYPE = new ItemType();
	public static final Type<FluidBlock> FLUID_TYPE = new FluidType();
	public static void initTypes()
	{
		SimpleGroups.ENERGY_GROUP.addType(ENERGY_TYPE, "ENERGY");
		SimpleGroups.MANA_GROUP.addType(MANA_TYPE, "MANA");
		SimpleGroups.ITEM_GROUP.addType(ITEM_TYPE, "ITEM");
		SimpleGroups.FLUID_GROUP.addType(FLUID_TYPE, "FLUID");
		System.out.println(SimpleGroups.ENERGY_GROUP.isInGroup("ENERGY"));
	}
}
