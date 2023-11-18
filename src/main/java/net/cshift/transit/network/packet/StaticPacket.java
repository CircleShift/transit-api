package net.cshift.transit.network.packet;

import net.cshift.transit.type.*;

/** Simple packet which stores an unchanging value.
 * @author Kyle Gunger
 *
 * @param <D> The data type (Object) that the packet transfers.
 */
public class StaticPacket<D> implements IStaticPacket<D>
{
    private Object data;
    private Type<D> type;

    /** Constructor. Stores the given data and uses the given type.
     * 
     * @param dat The packet's data
     * @param t The packet's type
     */
    public StaticPacket(Object dat, Type<D> t)
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
	public Type<D> getType() {
		return type;
	}
}
