package net.transit.type;

public interface IType<T, B> extends IBaseType<B>
{
    public String getTypeName();

    public IBaseType<B> convertToBase();

    public IType<T, B> convertFromBase(IBaseType<B> base);
}