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

package net.cshift.api.transit.type.group;

import java.security.InvalidKeyException;
import java.util.HashMap;

import org.slf4j.*;

import net.cshift.api.transit.type.Type;

public final class GroupRegistry {
	private static final HashMap<String, TypeGroup<?>> GROUPS = new HashMap<String, TypeGroup<?>>();
	
	private static final Logger LOGGER = LoggerFactory.getLogger("Transit API/Group Registry");
	
	private GroupRegistry() {}
	
	public static final boolean addGroup(TypeGroup<?> group) {
		if (GROUPS.containsKey(group.getGroup())) {
			LOGGER.warn("Failed to add group " + group + " to the registry. Did another mod add a group with the same name?");
			return false;
		}
		
		GROUPS.put(group.getGroup(), group);
		LOGGER.info("Successfully added group " + group + " to the registry.");
		
		return true;
	}
	
	/** Get the requested type group via ID
	 * 
	 * @param <B> The base type of the type group
	 * @param groupID 
	 * @param baseClass
	 * @throws ClassCastException if the group is not of the provided class type
	 * @return The group (properly casted) if it exists, or null otherwise
	 */
	@SuppressWarnings("unchecked")
	public static final <B> TypeGroup<B> groupByID(String groupID, Class<B> baseClass) throws ClassCastException {
		if (GROUPS.containsKey(groupID)) {
			TypeGroup<?> g = GROUPS.get(groupID);
			if (g.getBaseClass().equals(baseClass)) {
				return (TypeGroup<B>) g;
			} else {
				throw new ClassCastException(
						"Group " + g.getGroup() + " was requested as TypeGroup<" +
						baseClass.getName() + ">, but the group is actually TypeGroup<" +
						g.getBaseClass().getName() + ">"
				);
			}
		}
		
		return null;
	}
	
	/** Get the wildcard generic TypeGroup via the groupID
	 * 
	 * @param groupID The ID of the group to get
	 * @return The group if it exists, or null otherwise
	 */
	public static final TypeGroup<?> groupByID(String groupID) {
		if (GROUPS.containsKey(groupID)) {
			return GROUPS.get(groupID);
		}
		
		return null;
	}
	
	/** Get the requested type via 
	 * 
	 * @param <B>
	 * @param groupID
	 * @param typeID
	 * @param baseClass
	 * @return
	 * @throws ClassCastException
	 */
	public static final <B> Type<B> typeByIdentity(String groupID, String typeID, Class<B> baseClass) throws ClassCastException {
		TypeGroup<B> group = GroupRegistry.<B>groupByID(groupID, baseClass);
		
		if(group != null && group.isInGroup(typeID)) {
			try {
				return group.getType(typeID);
			} catch (InvalidKeyException e) {
				// Should never happen, since we just checked that the type is in the group
				LOGGER.error("Unreachable in typeByIdentity: trying to get type '" + groupID + ":" + typeID + "'");
				e.printStackTrace();
			}
		}

		return null;
	}
}
