package net.transit.packet;

public class StaticPacket<D> implements IPacket<D>
{
    private D data;

    public StaticPacket(D dat)
    {
        data = dat;
    }

    public D getData()
    {
        return data;
    }
}