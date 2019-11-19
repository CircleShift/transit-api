package net.transit.type.typegroup;

import java.util.ArrayList;

import net.transit.type.Type;

public final class TypeRegister
{
    private TypeRegister(){}

    //  Hold all the groups
    private static ArrayList<TypeGroup<?>> groups = new ArrayList<TypeGroup<?>>(0);

    private static ArrayList<Class> caster = new ArrayList<Class>(0);

    //  Add a group
    public static void addTypeGroup(TypeGroup<?> g)
    {
        if(getTypeGroup(g.getGroupName()) != null) return;

        groups.add(g);
    }

    //  Get a group by it's identifier
    public static TypeGroup<?> getTypeGroup(String name)
    {
        for(TypeGroup<?> g : groups)
        {
            if(g.getGroupName().toUpperCase() == name.toUpperCase()) return g;
        }

        return null;
    }

    public static String groupOf(Type<?, ?> t)
    {
        for(TypeGroup<?> g : groups)
        {
            if(g.hasType(t)) return g.getGroupName();
        }

        return null;
    }
}