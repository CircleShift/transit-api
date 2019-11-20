package net.transit.type;

import net.transit.network.packet.IPacket;
import net.transit.network.packet.StaticPacket;

/**@author Kyle Gunger
 * 
 * @param <T> The type of object transfered by packets of this type
 */
public abstract class Type<T>
{
	
	/**Return the packet's data formatted in the group's base type.
	 * 
	 * @param packet The packet (of this type)
	 * @return <T> The packet's data in the default type
	 */
	public T toBase(IPacket<T> packet)
	{
		return packet.getData();
	}
	
	/**Create a packet which has the current type from the data in the base type.
	 * 
	 * @param base The base data
	 * @return IPacket<<T>> The packet
	 */
	public IPacket<T> fromBase(T base)
	{
		return new StaticPacket<T>(base, this);
	}
	
	/** The type identifier.  Must be overridden for any class implementing IType
	 * 
	 * @return String
	 */
	public String getType()
	{
		return "ITYPE";
	}
}
