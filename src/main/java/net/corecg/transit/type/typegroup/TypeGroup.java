package net.corecg.transit.type.typegroup;

import java.util.ArrayList;

import net.corecg.transit.type.IType;
import net.corecg.transit.type.IBaseType;

public class TypeGroup<B>
{
    private IBaseType<B> baseType;

    private String groupName;

    private ArrayList<IType<?, B>> types;
    
    /**Create a new TypeGroup
     * 
     * @param base The base type of the group.
     * @param name The identifier of the group.  Should be in all caps.
    */
    public TypeGroup(IBaseType<B> base, String name)
    {
        baseType = base;
        types = new ArrayList<IType<?, B>>(0);
        groupName = name;
    }

    //  Return the base type
    public IBaseType<B> getBaseType()
    {
        return baseType;
    }

    //  Returns if the type is supported by the group
    public boolean hasType(IType t)
    {

        for(IType gtype : types)
        {
            
            if(t.getTypeName() == gtype.getTypeName()) return true;
        }

        return false;
    }

    //  Group name/identifier
    public String getGroupName()
    {

        return groupName;
    }
}