package net.corechg.mc.transit.network.packet.dynamic;

import net.corechg.mc.transit.network.packet.IStaticPacket;

/** Interface describing a fluid packet.
 * @author Kyle Gunger
 *
 * @param <D> The data type (Object) that the packet transfers
 */
public interface IDynamicPacket<D> extends IStaticPacket<D>{
    /**Set the packet's data.
	 * 
	 * @return <D> The packet's data
	 */
    public void setData(D dat);
}