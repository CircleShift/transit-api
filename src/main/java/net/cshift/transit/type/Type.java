package net.cshift.transit.type;

import net.cshift.transit.network.packet.*;

/**@author Kyle Gunger
 * 
 * @param T The type of object transfered by packets of this type
 */
public class Type<T>
{
	protected final String typeID;
	protected final String groupID;
	
	public Type(String tID, String gID)
	{
		typeID = tID;
		groupID = gID;
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
	public T toBase(T data, String group)
	{
		return data;
	}

	/** Return the data formatted in the default group's base type.
	 * 
	 * @param data The data (of this type)
	 * @return The data in the group's base type
	 */
	public final T toBase(T data)
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
		return this.toBase(packet.getData(), group);
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
	 * @return The packet's data in the group's base type
	 */
	public T fromBase(T data, String group)
	{
		return data;
	}

	/** Convert data from the default group's base type to this type.
	 * 
	 * @param data The base data
	 * @return The packet's data in the group's base type
	 */
	public final T fromBase(T data)
	{
		return fromBase(data, this.groupID);
	}

	/** Create a packet from data formatted in the given group's base type.
	 * 
	 * @param data The base data
	 * @param group The group asking for the conversion
	 * @return The packet's data in the group's base type
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
	public T convertFrom(Type<T> from, String group, T data) {
		return this.fromBase(from.toBase(data, group), group);
	}

	/** Convert data from another type to this type in the default group.
	 * 
	 * @param from The type to convert from
	 * @param data The data to convert
	 * @return The data formatted in this type
	 */
	public final T convertFrom(Type<T> from, T data) {
		return convertFrom(from, from.groupID, data);
	}

	/** Convert a packet using another type to a packet using this type within the given group.
	 * 
	 * @param packet The packet to convert
	 * @param group The group to convert within
	 * @return The new packet formatted in this type
	 */
	public final IStaticPacket<T> convertFrom(IStaticPacket<T> packet, String group) {
		return new StaticPacket<T>(convertFrom(packet.getType(), group, packet.getData()), this);
	}

	/** Convert a packet using another type to a packet using this type within the default group.
	 * 
	 * @param packet The packet to convert
	 * @return The new packet formatted in this type
	 */
	public final IStaticPacket<T> convertFrom(IStaticPacket<T> packet) {
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
	public final T convertTo(Type<T> to, String group, T data) {
		return to.convertFrom(this, group, data);
	}

	/** Convert data from this type to another type in the default group.
	 * 
	 * @param from The type to convert from
	 * @param data The data to convert
	 * @return The data formatted in this type
	 */
	public final T convertTo(Type<T> to, T data) {
		return to.convertFrom(this, groupID, data);
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
		return to.convertFrom(packet, groupID);
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

	@Override
	public final String toString() {
		return groupID + ":" + typeID;
	}
}
