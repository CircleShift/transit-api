package net.transit.type;

import net.transit.packet.IPacket;

public abstract class Type<T, B> extends BaseType<T>
{
    public static final String TYPE_NAME = "TYPE";

    public B convertToBase()
    {
        return null;
    }

    public IPacket<T> convertFromBase(B base)
    {
        return null;
    }
}