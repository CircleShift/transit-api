package net.corecg.transit.type.typebase;

import net.corecg.transit.type.IBaseType;

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