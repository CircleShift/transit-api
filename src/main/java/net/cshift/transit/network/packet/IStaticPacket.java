package net.cshift.transit.network.packet;

import net.cshift.transit.type.*;

/** Interface describing an unchanging packet.
 *
 * @param <D> The type parameter of the Type being transported
 * @author Kyle Gunger
 */
public interface IStaticPacket<D>
{
	/**Get the packet's data.
	 * 
	 * @return The packet's data
	 */
    public Object getData();
    
    /**Get the packet's type.
     * 
     * @return IType<?> The type of the packet
     */
    public Type<D> getType();
}
