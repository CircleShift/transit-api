package net.transit.network.packet;

import net.transit.type.Type;

public class MetaPacket<D, M> implements IPacket<D>
{
	
	private D data;
	private M metaData;
	private Type<D> type;

    public MetaPacket(D dat, Type<D> t, M meta)
    {
        data = dat;
        type = t;
        metaData = meta;
    }

    public D getData()
    {
        return data;
    }
    
    public M getMetaData()
    {
    	return metaData;
    }
    
    @Override
	public Type<D> getType() {
		return type;
	}
}
