package net.transit.impl;

public interface IConsumer<T> extends IAcceptor<T>
{
    public boolean canConsume();

    
}