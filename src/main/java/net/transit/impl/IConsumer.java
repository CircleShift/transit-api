package net.transit.impl;

import net.transit.type.IType;

public interface IConsumer<T extends IType<?, ?>> extends IAcceptor<T>
{
    public boolean canConsume();

    
}