package net.transit.type.typegroup;

import java.util.ArrayList;

import net.transit.type.Type;
import net.transit.type.BaseType;

public class TypeGroup<B>
{
    private BaseType<B> baseType;

    private String groupName;

    private ArrayList<Type<?, B>> types;
    
    /**Create a new TypeGroup
     * 
     * @param base The base type of the group.
     * @param name The identifier of the group.  Should be in all caps.
    */
    public TypeGroup(BaseType<B> base, String name)
    {
        baseType = base;
        types = new ArrayList<Type<?, B>>(0);
        groupName = name;
    }

    //  Return the base type
    public BaseType<B> getBaseType()
    {
        return baseType;
    }

    //  Returns if the type is supported by the group
    public boolean hasType(Type<?, ?> t)
    {

        for(Type<?, B> gtype : types)
        {
            
            if(t.TYPE_NAME == gtype.TYPE_NAME) return true;
        }

        return false;
    }

    //  Group name/identifier
    public String getGroupName()
    {

        return groupName;
    }
}