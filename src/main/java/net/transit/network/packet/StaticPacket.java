package net.transit.network.packet;

import net.transit.type.Type;

public class StaticPacket<D> implements IPacket<D>
{
    private D data;
    private Type<D> type;

    public StaticPacket(D dat, Type<D> t)
    {
        data = dat;
        type = t;
    }

    public D getData()
    {
        return data;
    }

	@Override
	public Type<D> getType() {
		return type;
	}
}