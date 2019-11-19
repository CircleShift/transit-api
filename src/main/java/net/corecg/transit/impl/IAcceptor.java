package net.corecg.transit.impl;

import net.corecg.transit.type.IType;
import net.minecraft.util.math.Direction;

public interface IAcceptor<T extends IType<?, ?>>
{
    //  Direction given if acceptor is a block
    public boolean canAccept(Direction d);

    //  Accept (or not) a provided T (should trigger ITransferEvent)
    public boolean accept(T provided);
}