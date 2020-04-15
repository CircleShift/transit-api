package net.transit.type;

import net.transit.network.packet.IStaticPacket;
import net.transit.network.packet.StaticPacket;

/**@author Kyle Gunger
 * 
 * @param <T> The type of object transfered by packets of this type
 */
public class Type<T>
{
	protected String typeID;
	protected String groupID;
	
	public Type(String tID, String gID)
	{
		typeID = tID;
		groupID = gID;
	}
	
	/** Return the packet's data formatted in the group's base type.
	 * 
	 * @param packet The packet (of this type)
	 * @param group The group asking for the conversion
	 * @return <T> The packet's data in the default type
	 */
	public T toBase(IStaticPacket<T> packet, String group)
	{
		return packet.getData();
	}
	
	/** Create a packet which has the current type from the data in the base type.
	 * 
	 * @param base The base data
	 * @param group The group that the data comes from
	 * @return IPacket<<T>> The packet
	 */
	public IStaticPacket<T> fromBase(T base, String group)
	{
		return new StaticPacket<T>(base, this);
	}
	
	/** The type identifier.  Must be overridden for any class implementing IType.
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
}
