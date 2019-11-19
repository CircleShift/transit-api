package net.transit.type.typebase;

import net.transit.type.IBaseType;

public class StringBase implements IBaseType<String>
{
    private String data;

    public StringBase(String dat)
    {
        data = dat;
    }

    public String getData()
    {
        return data;
    }
}