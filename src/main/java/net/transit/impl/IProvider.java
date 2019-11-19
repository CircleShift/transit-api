package net.transit.impl;

import net.transit.type.IType;
import net.minecraft.util.math.Direction;

public interface IProvider<T extends IType<?, ?>>
{

    //  Direction given if provider is a block
    public boolean canProvide(Direction d);

    //  Provide the next T (should trigger ITransferEvent)
    public T provide();

    //  Retain the rejected T if the acceptor did not accept it (should trigger ITransferEvent)
    public void accept(T rejected);
}