package net.cshift.api.transit.network.packet;

/** Interface describing a packet where the data can change as it's transferred.
 * 
 * @param <D> The type parameter of the Type being transported
 * @author Kyle Gunger
 */
public interface IDynamicPacket<D> extends IStaticPacket<D>{
    /** Set the packet's data. */
    public void setData(Object dat);
}
