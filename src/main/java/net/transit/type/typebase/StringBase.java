package net.transit.type.typebase;

import net.transit.type.BaseType;

public class StringBase extends BaseType<String>
{
    private String data;

    public static final String TYPE_NAME = "BASE_STRING";

    public StringBase(String dat)
    {
        data = dat;
    }

    public String getData()
    {
        return data;
    }
}