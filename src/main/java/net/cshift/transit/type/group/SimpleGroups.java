/*
	MIT License

	Copyright (c) 2023 Kyle Gunger
	
	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:
	
	The above copyright notice and this permission notice shall be included in all
	copies or substantial portions of the Software.
	
	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
	SOFTWARE.
*/

package net.cshift.transit.type.group;

import org.slf4j.*;

import net.cshift.transit.type.*;

public final class SimpleGroups {
	/** Transfers energy.  Basic unit is TJoule (Transit Joule).
	 */
	public static final TypeGroup<Long> ENERGY = new TypeGroup<Long>(SimpleTypes.TransitJoule, Long.class);

	/** Transfers mana.  Basic unit is TMana (Transit Mana).
	 */
	public static final TypeGroup<TMana> MANA = new TypeGroup<TMana>(SimpleTypes.TransitMana, TMana.class);

	/** Transfers items. Basic unit is TItem.
	 */
	public static final TypeGroup<TItem> ITEM = new TypeGroup<TItem>(SimpleTypes.TransitItem, TItem.class);

	/** Transfers fluids.  Basic unit is TFluid.
	 */
	public static final TypeGroup<TFluid> FLUID = new TypeGroup<TFluid>(SimpleTypes.TransitFluid, TFluid.class);
	
	private static final Logger LOGGER = LoggerFactory.getLogger("Transit API/Simple Groups");
	
	public static final void init()
	{
		LOGGER.info("Initializing simple groups");
		GroupRegistry.addGroup(ENERGY);
		GroupRegistry.addGroup(MANA);
		GroupRegistry.addGroup(ITEM);
		GroupRegistry.addGroup(FLUID);
	}
}
