package net.transit.type.group;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.transit.network.packet.IPacket;
import net.transit.type.Type;

/**
 * @author Kyle Gunger
 * @param <B> The base object which all grouped Types should convert between.
 */
public class TypeGroup<B>
{
	/** The list of types. */
	private final ArrayList<Type<?>> TYPES = new ArrayList<Type<?>>(0);
	private final ArrayList<String> TYPEIDS = new ArrayList<String>(0);
	
	/** Logger for events in the group.  Should not be overridden.*/
	private static final Logger LOG = LogManager.getFormatterLogger("Transit|Group");
	
	/**Check if the type is in the group
	 * 
	 * @param type
	 * @return boolean
	 */
	public boolean isInGroup(Type<B> type)
	{
		return TYPES.contains(type);
	}
	
	/**Check if the type is in the group
	 * 
	 * @param type
	 * @return boolean
	 */
	public boolean isInGroup(String type)
	{
		return TYPEIDS.contains(type);
	}
	
	/**Get the type from the group
	 * 
	 * @param type
	 * @return IType<<B>>
	 */
	public Type<B> getType(String type)
	{
		if(isInGroup(type))
		{
			return (Type<B>) TYPES.get(TYPEIDS.indexOf(type));
		}
		
		return null;
	}
	
	//  Type conversion
	/**Convert a packet to a new type
	 * 
	 * @param packet The packet to convert
	 * @param type The type to convert to
	 * @return IPacket<<B>>
	 */
	public IPacket<B> convertPacket(IPacket<B> packet, Type<B> type)
	{
		if(isInGroup(packet.getType()) && isInGroup(type))
		{
			return type.fromBase(packet.getType().toBase(packet));
		}
		
		return null;
	}
	
	public IPacket<B> convertPacket(IPacket<B> packet, String type)
	{
		if(isInGroup(packet.getType()) && isInGroup(type))
		{
			return getType(type).fromBase(packet.getType().toBase(packet));
		}
		
		return null;
	}
	
	//  Type management
	
	public boolean addType(Type<B> type, String typeID)
	{
		if(!isInGroup(type.getType()) && !isInGroup(typeID))
		{
			TYPES.add(type);
			TYPEIDS.add(typeID);
			LOG.info("Added type " + typeID + " to group " + this.getGroup());
			return true;
		}
		
		return false;
	}
	
	
	public boolean removeType(Type<B> type)
	{
		
		if(isInGroup(type) && TYPES.indexOf(type) != -1)
		{
			String id = TYPEIDS.remove(TYPES.indexOf(type));
			TYPES.remove(type);
			LOG.info("Removed type " + id + " from group " + this.getGroup());
			return true;
		}
		LOG.warn("Failed to remove type " + type.getType() + " from group " + this.getGroup() + ".  Are we sure that the type was added to the group first?");
		return false;
	}
	
	public boolean removeType(String typeID)
	{
		if(isInGroup(typeID) && TYPEIDS.indexOf(typeID) != -1)
		{
			TYPES.remove(TYPEIDS.indexOf(typeID));
			TYPEIDS.remove(typeID);
			LOG.info("Removed type " + typeID + " from group " + this.getGroup());
			return true;
		}
		
		LOG.warn("Failed to remove type " + typeID + " from group " + this.getGroup() + ".  Are we sure that the type was added to the group first?");
		return false;
	}
	
	/** The group identifier.  Must be overridden for any class implementing ITypeGroup
	 * @return String
	 */
	public String getGroup()
	{
		return "ITYPEGROUP";
	}
}
