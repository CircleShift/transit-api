package net.corecg.transit.impl;

import net.corecg.transit.type.IType;

public interface IGenerator<T extends IType<?, ?>> extends IProvider<T>
{
    public boolean canGenerate();

    
}