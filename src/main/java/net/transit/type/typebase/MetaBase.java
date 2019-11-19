package net.transit.type.typebase;

import net.transit.type.BaseType;

public class MetaBase<T extends BaseType<?>> extends BaseType<T>
{
    private T data;
    private String metaData;

    public static final String TYPE_NAME = "BASE_META";

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