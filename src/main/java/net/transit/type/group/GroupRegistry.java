package net.transit.type.group;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class GroupRegistry {
	private static final ArrayList<TypeGroup<?>> GROUPS = new ArrayList<TypeGroup<?>>(0);
	private static final ArrayList<String> GROUPIDS = new ArrayList<String>(0);
	
	private static final Logger LOG = LogManager.getFormatterLogger("Transit|GroupRegistry");
	
	public static final boolean addGroup(TypeGroup<?> group, String groupID)
	{
		for(String s : GROUPIDS)
		{
			if(s.equals(groupID))
			{
				LOG.warn("Failed to add group " + group.getGroup() + " to the registry. Did another mod add a group with the same name?");
				return false;
			}
		}
		
		for(TypeGroup<?> g : GROUPS)
		{
			if(g.equals(group))
			{
				LOG.warn("Failed to add group " + group.getGroup() + " to the registry. Was the group alreay added?");
				return false;
			}
		}
		
		GROUPS.add(group);
		GROUPIDS.add(groupID);
		LOG.info("Successfully added group " + group.getGroup() + " to the registry.");
		return true;
	}
	
	public static final TypeGroup<?> groupByID(String groupID)
	{
		for(String s : GROUPIDS)
		{
			if(s.equals(groupID)) return GROUPS.get(GROUPIDS.indexOf(s));
		}
		
		return null;
		
	}
	
}
