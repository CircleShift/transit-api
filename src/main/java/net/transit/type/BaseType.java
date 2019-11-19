package net.transit.type;

public abstract class BaseType<T>
{

    public static final String TYPE_NAME = "BASE";

    private T data;

    public T getData()
    {
        return data;
    }
}