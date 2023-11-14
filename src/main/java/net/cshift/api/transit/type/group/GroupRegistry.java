package net.cshift.api.transit.type.group;

import java.security.InvalidKeyException;
import java.util.HashMap;

import org.slf4j.*;

import net.cshift.api.transit.type.Type;

public final class GroupRegistry {
	private static final HashMap<String, TypeGroup<?>> GROUPS = new HashMap<String, TypeGroup<?>>();
	
	private static final Logger LOGGER = LoggerFactory.getLogger("Transit API/Group Registry");
	
	private GroupRegistry() {}
	
	public static final boolean addGroup(TypeGroup<?> group)
	{
		if (GROUPS.containsKey(group.getGroup())) {
			LOGGER.warn("Failed to add group " + group + " to the registry. Did another mod add a group with the same name?");
			return false;
		}
		
		GROUPS.put(group.getGroup(), group);
		LOGGER.info("Successfully added group " + group + " to the registry.");
		
		return true;
	}
	
	public static final <T> TypeGroup<T> groupByID(String groupID)
	{
		if (GROUPS.containsKey(groupID)) {
			TypeGroup<?> g = GROUPS.get(groupID);
			return (TypeGroup<T>) g;
		}
		
		return null;
	}
	
	public static final <T> Type<T> typeByIdentity(String groupID, String typeID) throws InvalidKeyException
	{
		TypeGroup<T> group = GroupRegistry.<T>groupByID(groupID);
		
		if(group != null)
			return group.getType(typeID);

		return null;
	}
	
}
