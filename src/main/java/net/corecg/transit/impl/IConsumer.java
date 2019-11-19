package net.corecg.transit.impl;

import net.corecg.transit.type.IType;

public interface IConsumer<T extends IType<?, ?>> extends IAcceptor<T>
{
    public boolean canConsume();

    
}