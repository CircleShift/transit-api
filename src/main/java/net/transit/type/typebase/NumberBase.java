package net.transit.type.typebase;

import net.transit.type.BaseType;

public class NumberBase extends BaseType<Number>
{
    private Number data;

    public static final String TYPE_NAME = "BASE_NUMBER";

    public NumberBase(Number dat)
    {
        data = dat;
    }

    public Number getData()
    {
        return data;
    }
}