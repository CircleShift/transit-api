package net.corechg.transit.type;

import net.corechg.transit.network.packet.IStaticPacket;
import net.corechg.transit.network.packet.StaticPacket;

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
	 *  If creating a new type, extend this class and override this function.
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
	 *  If creating a new type, extend this class and override this function.
	 * 
	 * @param base The base data
	 * @param group The group that the data comes from
	 * @return IPacket<<T>> The packet
	 */
	public IStaticPacket<T> fromBase(T base, String group)
	{
		return new StaticPacket<T>(base, this);
	}
	
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
}
