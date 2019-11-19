package net.corecg.transit.type.typebase;

import net.corecg.transit.type.IBaseType;

public class NumberBase implements IBaseType<Number>
{
    private Number data;

    public NumberBase(Number dat)
    {
        data = dat;
    }

    public Number getData()
    {
        return data;
    }
}