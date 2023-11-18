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

package net.cshift.transit.type;

public final class SimpleTypes {
	/** Transfers energy.  Energy is stored as a numeric.
	 */
	public static final Type<Long> TransitJoule = new Type<Long>("Joule", "ENERGY", Long.class);
	
	/** Transfers mana.  TMana stores mana count and type.
	 */
	public static final Type<TMana> TransitMana = new Type<TMana>("TMana", "MANA", TMana.class);

	/** Transfers items. TItem stores an item and an item count.
	 */
	public static final Type<TItem> TransitItem = new Type<TItem>("TItem", "ITEM", TItem.class);

	/** Transfers fluid. TFluid stores fluid and mB.
	 */
	public static final Type<TFluid> TransitFluid = new Type<TFluid>("TFluid", "FLUID", TFluid.class);
}
