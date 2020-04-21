package net.corechg.transit.type.group;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.corechg.transit.type.Type;

public class GroupRegistry {
	private static final ArrayList<TypeGroup<?>> GROUPS = new ArrayList<TypeGroup<?>>(0);
	
	private static final Logger LOG = LogManager.getFormatterLogger("Transit|GroupRegistry");
	
	private GroupRegistry() {}
	
	public static final boolean addGroup(TypeGroup<?> group)
	{
		for(TypeGroup<?> g : GROUPS)
		{
			if(g.getGroup().equals(group.getGroup()))
			{
				LOG.warn("Failed to add group " + group + " to the registry. Did another mod add a group with the same name?");
				return false;
			}
		}
		
		GROUPS.add(group);
		LOG.info("Successfully added group " + group + " to the registry.");
		return true;
	}
	
	public static final TypeGroup<?> groupByID(String groupID)
	{
		for(TypeGroup<?> g : GROUPS)
		{
			if(g.getGroup().equals(groupID)) return g;
		}
		
		return null;
		
	}
	
	public static final Type<?> typeByIdentity(String groupID, String typeID)
	{
		return groupByID(groupID).getType(typeID);
	}
	
}
