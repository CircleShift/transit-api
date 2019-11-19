package net.corecg.transit.type.typebase;

import net.corecg.transit.type.IBaseType;

public class MetaBase<T extends IBaseType<?>> implements IBaseType<T>
{
    private T data;
    private String metaData;

    public MetaBase(T dat, String meta)
    {
        data = dat;
        metaData = meta;
    }

    public T getData()
    {
        return data;
    }

    public String getMetaData()
    {
        return metaData;
    }

}