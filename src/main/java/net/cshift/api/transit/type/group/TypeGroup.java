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

/**
 * @author Kyle Gunger
 * @param <B> The base object which all grouped Types should convert between.
 */
public final class TypeGroup<B>
{
	// The basic class of the base type which is being transferred
	private Class<B> baseClass;
	
	// The base Type (provides the group's identifier)
	private Type<B> baseType;

	// The list of types.
	private final HashMap<String, Type<B>> TYPES;

	// Logger for events in the TypeGroup.
	private static final Logger LOGGER = LoggerFactory.getLogger("Transit API/Type Group");


	public TypeGroup(Type<B> base, Class<B> baseClass)
	{
		TYPES = new HashMap<String, Type<B>>();
		baseType = base;
		this.baseClass = baseClass;
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
		if(TYPES.containsKey(type.getType()))
		{
			LOGGER.info("Failed to add type " + type + " to group " + getGroup() + ".  Was the type already added?");
			return false;
		}
		
		TYPES.put(type.toString(), type);
		LOGGER.info("Added type " + type + " to group " + getGroup());
		return true;
		
	}

	/** Remove a Type from the TypeGroup.
	 *
	 * @param type The Type to remove
	 * @return
	 */
	public boolean removeType(Type<B> type)
	{
		if(type.toString().equals(baseType.toString())) {
			LOGGER.warn("Failed to remove type " + type + " from group " + getGroup() + ".  This is the base type and can not be removed.");
			return false;
		}

		if(TYPES.containsKey(type.toString()))
		{
			LOGGER.info("Removed type " + TYPES.remove(type.toString()) + " from group " + getGroup());
			return true;
		}

		LOGGER.warn("Failed to remove type " + type + " from group " + getGroup() + ".  Are we sure that the type was added to the group first?");
		return false;
	}

	/** Remove a type from the group based on it's group-type identifier.
	 *
	 * @param type
	 * @return
	 */
	public boolean removeType(String groupID, String typeID)
	{
		String typeString = groupID + ":" + typeID;
		
		if(baseType.toString().equals(typeString)) {
			LOGGER.warn("Failed to remove type " + baseType + " from group " + getGroup() + ".  This is the base type and can not be removed.");
			return false;
		}
		
		if(TYPES.containsKey(typeString))
		{
			LOGGER.info("Removed type " + TYPES.remove(typeString) + " from group " + getGroup());
			return true;
		}

		LOGGER.warn("Failed to remove type " + typeString + " from group " + getGroup() + ".  Are we sure that the type was added to the group first?");
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
		return TYPES.containsKey(type.toString()) && TYPES.get(type.toString()) == type;
	}

	/**Check if the type is in the group
	 *
	 * @param groupID
	 * @param typeID
	 * @return boolean
	 */
	public boolean isInGroup(String groupID, String typeID)
	{
		return TYPES.containsKey(groupID + ":" + typeID);
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
	public Type<B> getType(String groupID, String typeID) throws InvalidKeyException
	{
		String typeString = groupID + ":" + typeID;
		if (!TYPES.containsKey(typeString))
			throw new InvalidKeyException("Invalid key in getType (" + typeString + "is not in group" + getGroup() + ")");
		return TYPES.get(typeString);
	}

	/**Get the type from the group
	 *
	 * @param typeID The ID of the type
	 * @return Type
	 */
	public Type<B> getType(String typeID) throws InvalidKeyException
	{
		return getType(getGroup(), typeID);
	}


	// DO ALL TYPE CONVERSION USING TYPES.

	/** The group identifier.  Given by the Base Group
	 * @return String
	 */
	public final String getGroup()
	{
		return baseType.getGroup();
	}

	/** The base group type
	 * 	@return Type<B>
	 */
	public final Type<B> getBase() {
		return baseType;
	}
	
	/** A Class object which represents the type that the base type uses to transfer data
	 * @return Class<B>
	 */
	public final Class<B> getBaseClass() {
		return baseClass;
	}

	@Override
	public final String toString() {
		return this.getGroup();
	}
}
