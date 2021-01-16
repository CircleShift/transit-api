package net.cshift.transit.network.packet.dynamic;

import net.cshift.transit.type.Type;

/**
 * Simple packet which stores a fluid value.
 *
 * @author Kyle Gunger
 *
 * @param <D> The data type (Object) that the packet transfers
 */
public class DynamicPacket<D> implements IDynamicPacket<D> {
    private D data;
    private Type<D> type;

    /** Constructor. Stores the given data and uses the given type.
     *
     * @param dat The packet's data
     * @param t The packet's type
     */
    public DynamicPacket(D dat, Type<D> t)
    {
        data = dat;
        type = t;
    }

    @Override
    public D getData()
    {
        return data;
    }

    @Override
    public void setData(D dat)
    {
        data = dat;
    }

	@Override
	public Type<D> getType() {
		return type;
	}
}
