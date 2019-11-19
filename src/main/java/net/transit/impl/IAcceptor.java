package net.transit.impl;

import net.transit.packet.IPacket;
import net.minecraft.util.math.Direction;

public interface IAcceptor<T>
{
    //  Direction given if acceptor is a block
    public boolean canAccept(Direction d);

    //  Accept (or not) a provided T (should trigger ITransferEvent)
    public boolean accept(IPacket<T> provided);
}