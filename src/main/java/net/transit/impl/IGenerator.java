package net.transit.impl;

public interface IGenerator<T> extends IProvider<T>
{
    public boolean canGenerate();

    
}