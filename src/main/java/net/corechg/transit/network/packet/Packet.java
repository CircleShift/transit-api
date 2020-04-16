package net.corechg.transit.network.packet;

import net.corechg.transit.type.Type;

/**
 * @author Kyle Gunger
 *
 * @param <D> The data type (Object) that the packet transfers.
 */
public interface Packet<D>
{
	/**Get the packet's data
	 * 
	 * @return <D> The packet's data
	 */
    public D getData();
    
    /**Get the packet's type
     * 
     * @return IType<<D>> The type of the packet
     */
    public Type<D> getType();
}