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

package net.cshift.api.transit.type;

import net.cshift.api.transit.network.packet.*;

/**@author Kyle Gunger
 * 
 * @param <T> The type of object transfered by packets of this type
 */
public class Type<T>
{
	protected final String typeID;
	protected final String groupID;
	private final Class<?> underlying;
	
	// Should not override, but you can if you must
	public Type(String tID, String gID, Class<?> underlying)
	{
		typeID = tID;
		groupID = gID;
		this.underlying = underlying;
	}
	


	// ##########################################
	// # Converting from this type to base type #
	// ##########################################

	/** Return the data formatted in the given group's base type.
	 *  If creating a new type, override this function if required.
	 * 
	 * @param data The data (of this type)
	 * @param group The group asking for the conversion
	 * @return The data in the group's base type
	 */
	@SuppressWarnings("unchecked")
	public T toBase(Object data, String group)
	{
		// Assume the underlying is the same as T for this very simple case
		if (data.getClass().equals(this.getUnderlying()))
			return (T) data;
		return null;
	}

	/** Return the data formatted in the default group's base type.
	 * 
	 * @param data The data (of this type)
	 * @return The data in the group's base type
	 */
	public final T toBase(Object data)
	{
		return this.toBase(data, this.groupID);
	}

	/** Return the packet's data formatted in the given group's base type.
	 * 
	 * @param packet The packet (of this type)
	 * @param group The group asking for the conversion
	 * @return The packet's data in the group's base type
	 */
	public final T toBase(IStaticPacket<T> packet, String group)
	{
		if(packet.getType().equals(this))
			return this.toBase(packet.getData(), group);
		return null;
	}

	/** Return the packet's data formatted in the default group's base type.
	 * 
	 * @param packet The packet (of this type)
	 * @return The packet's data in the group's base type
	 */
	public final T toBase(IStaticPacket<T> packet)
	{
		return this.toBase(packet, this.groupID);
	}



	// ##########################################
	// # Converting from base type to this type #
	// ##########################################

	/** Convert data from the given group's base type to this type.
	 *  If creating a new type, override this function if required.
	 * 
	 * @param data The base data
	 * @param group The group asking for the conversion
	 * @return The converted data, in the Type's underlying
	 */
	public Object fromBase(T data, String group)
	{
		// Assume T is the same as the underlying
		return data;
	}

	/** Convert data from the default group's base type to this type.
	 * 
	 * @param data The base data
	 * @return The converted data, in the Type's underlying
	 */
	public final Object fromBase(T data)
	{
		return fromBase(data, this.groupID);
	}

	/** Create a packet from data formatted in the given group's base type.
	 * 
	 * @param data The base data
	 * @param group The group asking for the conversion
	 * @return A packet containing the converted data in the Type's underlying
	 */
	public final IStaticPacket<T> packetFromBase(T data, String group)
	{
		return new StaticPacket<T>(this.fromBase(data, group), this);
	}

	/** Create a packet from data formatted in the default group's base type.
	 * 
	 * @param data The base data
	 * @return The packet's data in the group's base type
	 */
	public final IStaticPacket<T> packetFromBase(T data)
	{
		return packetFromBase(data, this.groupID);
	}



	// ###########################################
	// # Converting from other type to this type #
	// ###########################################

	/** Convert data from another type to this type in the given group.
	 *  If creating a new type, override this function if required.
	 * 
	 * @param from The type to convert from
	 * @param group The group we are converting within
	 * @param data The data to convert
	 * @return The data formatted in this type
	 */
	public Object convertFrom(Type<T> from, Object data, String group) {
		return this.fromBase(from.toBase(data, group), group);
	}

	/** Convert data from another type to this type in the default group.
	 * 
	 * @param from The type to convert from
	 * @param data The data to convert
	 * @return The data formatted in this type
	 */
	public final Object convertFrom(Type<T> from, Object data) {
		return convertFrom(from, data, from.groupID);
	}

	/** Convert a packet using another type to a packet using this type within the given group.
	 * 
	 * @param packet The packet to convert
	 * @param group The group to convert within
	 * @return The new packet formatted in this type
	 */
	public final IStaticPacket<T> convertFrom(IStaticPacket<T> packet, String group) {
		return new StaticPacket<T>(convertFrom(packet.getType(), packet.getData(), group), this);
	}

	/** Convert a packet using another type to a packet using this type within the default group.
	 * 
	 * @param packet The packet to convert
	 * @return The new packet formatted in this type
	 */
	public final IStaticPacket<T> convertFrom(IStaticPacket<T> packet) throws ClassCastException {
		return this.convertFrom(packet, packet.getType().groupID);
	}



	// ###########################################
	// # Converting from other type to this type #
	// ###########################################

	/** Convert data from this type to another type in the given group.
	 * 
	 * @param from The type to convert from
	 * @param group The group we are converting within
	 * @param data The data to convert
	 * @return The data formatted in this type
	 */
	public final Object convertTo(Type<T> to, Object data, String group) {
		return to.convertFrom(this, data, group);
	}

	/** Convert data from this type to another type in the default group.
	 * 
	 * @param from The type to convert from
	 * @param data The data to convert
	 * @return The data formatted in this type
	 */
	public final Object convertTo(Type<T> to, Object data) {
		return to.convertFrom(this, data, this.groupID);
	}

	/** Convert a packet using this type to a packet using another type within the given group.
	 * 
	 * @param packet The packet to convert
	 * @param group The group to convert within
	 * @return The new packet formatted in this type
	 */
	public final IStaticPacket<T> convertTo(Type<T> to, IStaticPacket<T> packet, String group) {
		return to.convertFrom(packet, group);
	}

	/** Convert a packet using this type to a packet using another type within the default group.
	 * 
	 * @param packet The packet to convert
	 * @return The new packet formatted in this type
	 */
	public final IStaticPacket<T> convertTo(Type<T> to, IStaticPacket<T> packet) {
		return to.convertFrom(packet, this.groupID);
	}



	// ##############################
	// # Utility and info functions #
	// ##############################
	
	/** The type identifier.  Gives the normal type identity of the type.
	 * 
	 * @return String
	 */
	public final String getType()
	{
		return typeID;
	}
	
	/** The group identifier.  Gives the normal group identity of the type.
	 * 
	 * @return String
	 */
	public final String getGroup()
	{
		return groupID;
	}
	
	/** The underlying class which this Type uses to implement functionality within the mod
	 * 
	 * @return Class<?>
	 */
	public final Class<?> getUnderlying()
	{
		return underlying;
	}
	
	@Override
	public final String toString() {
		return groupID + ":" + typeID;
	}
}
