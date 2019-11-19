package net.transit.impl;

import net.transit.type.IType;

public interface IGenerator<T extends IType<?, ?>> extends IProvider<T>
{
    public boolean canGenerate();

    
}