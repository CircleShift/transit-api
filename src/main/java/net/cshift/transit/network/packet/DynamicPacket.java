package net.cshift.transit.network.packet;

import net.cshift.transit.type.Type;

/**
 * Simple packet which stores a value which can change.
 *
 * @param <D> The type parameter of the Type being transported
 * @author Kyle Gunger
 * 
 */
public class DynamicPacket<D> implements IDynamicPacket<D> {
    private Object data;
    private Type<D> type;

    /** Constructor. Stores the given data and uses the given type.
     *
     * @param dat The packet's data
     * @param t The packet's type
     */
    public DynamicPacket(Object dat, Type<D> t)
    {
        data = dat;
        type = t;
    }

    @Override
    public Object getData()
    {
        return data;
    }

    @Override
    public void setData(Object dat)
    {
        data = dat;
    }

	@Override
	public Type<D> getType() {
		return type;
	}
}
