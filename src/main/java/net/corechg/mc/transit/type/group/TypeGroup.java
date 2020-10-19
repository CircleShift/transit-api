package net.corechg.mc.transit.type.group;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.corechg.mc.transit.network.packet.*;
import net.corechg.mc.transit.type.Type;

/**
 * @author Kyle Gunger
 * @param <B> The base object which all grouped Types should convert between.
 */
public class TypeGroup<B>
{
	// The base Type (provides the group's identifier)
	private Type<B> baseType;
	
	// The list of types.
	private final ArrayList<Type<B>> TYPES = new ArrayList<Type<B>>(0);
	
	// Logger for events in the TypeGroup.
	private static final Logger LOG = LogManager.getFormatterLogger("Transit|Group");
	
	
	public TypeGroup(Type<B> base)
	{
		baseType = base;
		addType(base);
	}
	
	
	// Type management
	
	/** Add a Type to the TypeGroup.
	 *  The Type must have a group-type combo not already found in this TypeGroup.
	 *  Returns {@code true} if the group was added.
	 *  
	 * @param type The Type to add
	 * @return
	 */
	public boolean addType(Type<B> type)
	{
		if(!isInGroup(type))
		{
			TYPES.add(type);
			LOG.info("Added type " + type + " to group " + getGroup());
			return true;
		}

		LOG.info("Failed to add type " + type + " to group " + getGroup() + ".  Was the type already added?");
		return false;
	}
	
	/** Remove a Type from the TypeGroup.
	 * 
	 * @param type The Type to remove
	 * @return
	 */
	public boolean removeType(Type<B> type)
	{
		if(type.equals(baseType)) {
			LOG.warn("[WARN] Failed to remove type " + type + " from group " + getGroup() + ".  This is the base type and can not be removed.");
			return false;
		}
		
		if(TYPES.indexOf(type) != -1)
		{
			LOG.info("Removed type " + TYPES.remove(TYPES.indexOf(type)) + " from group " + getGroup());
			return true;
		}
		
		LOG.warn("[WARN] Failed to remove type " + type + " from group " + getGroup() + ".  Are we sure that the type was added to the group first?");
		return false;
	}
	
	/** Remove a type from the group based on it's group-type identifier.
	 * 
	 * @param type
	 * @return
	 */
	public boolean removeType(String groupID, String typeID)
	{
		if(baseType.toString() == groupID + ":" + typeID) {
			LOG.warn("[WARN] Failed to remove type " + baseType + " from group " + getGroup() + ".  This is the base type and can not be removed.");
			return false;
		}

		for(Type<?> type : TYPES)
		{
			if(type.toString() == groupID + ":" + typeID)
			{
				LOG.info("Removed type " + TYPES.remove(TYPES.indexOf(type)) + " from group " + getGroup());
				return true;
			}
		}
		
		LOG.warn("[WARN] Failed to remove type " + groupID + ":" + typeID + " from group " + getGroup() + ".  Are we sure that the type was added to the group first?");
		return false;
	}
	
	/** Remove a type from the group based on it's group-type identifier.
	 * 
	 * @param type
	 * @return
	 */
	public boolean removeType(String typeID)
	{
		return removeType(getGroup(), typeID);
	}
	
	
	// Check if a type is in the group
	
	/**Check if the type is in the group
	 * 
	 * @param type
	 * @return boolean
	 */
	public boolean isInGroup(Type<B> type)
	{
		for(Type<B> t : TYPES)
		{
			if(t.equals(type)) return true;
		}
		return false;
	}
	
	/**Check if the type is in the group
	 * 
	 * @param groupID
	 * @param typeID
	 * @return boolean
	 */
	public boolean isInGroup(String groupID, String typeID)
	{
		for(Type<B> t : TYPES)
		{
			if(t.toString() == groupID + ":" + typeID) return true;
		}
		return false;
	}
	
	/**Check if the type is in the group
	 * 
	 * @param typeID
	 * @return boolean
	 */
	public boolean isInGroup(String typeID)
	{
		return isInGroup(getGroup(), typeID);
	}
	
	// Get a type in the group
	
	/**Get the type from the group
	 * 
	 * @param groupID The ID of the group the type is originally from
	 * @param typeID The ID of the type
	 * @return Type
	 */
	public Type<B> getType(String groupID, String typeID)
	{
		for(Type<B> t : TYPES)
		{
			if(t.toString() == groupID + ":" + typeID) return t;
		}
		
		return null;
	}
	
	/**Get the type from the group
	 * 
	 * @param typeID The ID of the type
	 * @return Type
	 */
	public Type<B> getType(String typeID)
	{
		return getType(getGroup(), typeID);
	}
	
	
	//  Type conversion
	
	/** Actually convert the packet
	 * 
	 * @param packet
	 * @param type
	 * @return
	 */
	protected IStaticPacket<B> convertPacketRaw(IStaticPacket<B> packet, Type<B> type)
	{
		return type.fromBase(packet.getType().toBase(packet, getGroup()), getGroup());
	}
	
	/**Convert a packet to a new type  Returns null if the type isn't in the group.
	 * 
	 * @param packet The packet to convert
	 * @param type The type to convert to
	 * @return Packet
	 */
	public IStaticPacket<B> convertPacket(IStaticPacket<B> packet, Type<B> type)
	{
		if(isInGroup(packet.getType()) && isInGroup(type))
		{
			return convertPacketRaw(packet, type);
		}
		
		return null;
	}
	
	/**Convert a packet to a new type  Returns null if the type isn't found.
	 * 
	 * @param packet The packet to convert
	 * @param groupID The groupID of the Type to convert to
	 * @param typeID The typeID of the Type to convert to
	 * @return Packet
	 */
	public IStaticPacket<B> convertPacket(IStaticPacket<B> packet, String groupID, String typeID)
	{
		Type<B> toType = getType(groupID, typeID);
		if(toType != null)
		{
			return convertPacketRaw(packet, toType);
		}
		
		return null;
	}

	/**Convert a packet to a new type.  Returns null if the type isn't found.
	 * 
	 * @param packet The packet to convert
	 * @param typeID The typeID of the Type to convert to
	 * @return Packet
	 */
	public IStaticPacket<B> convertPacket(IStaticPacket<B> packet, String typeID)
	{
		Type<B> toType = getType(typeID);
		if(toType != null)
		{
			return convertPacketRaw(packet, toType);
		}
		
		return null;
	}
	
	/** The group identifier.  Given by the Base Group
	 * @return String
	 */
	public final String getGroup()
	{
		return baseType.getGroup();
	}

	/** The base group type
	 * 	@return Type
	 */
	public final Type<B> getBase() {
		return baseType;
	}

	@Override
	public final String toString() {
		return this.getGroup();
	}
}
