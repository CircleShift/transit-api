package net.transit.network.swap;

import net.transit.network.packet.Packet;
import net.transit.network.system.Node;

/**
 * @author Kyle Gunger
 *
 * @param <T> The type of data accepted (in IPacket<<T>> form)
 */
public interface Acceptor<T>
{
	/** Returns the INode this Acceptor is attached to. All Acceptors and Provider must be attached to an INode to function.
	 * 
	 * @return INode
	 */
	public Node getNode();
	
    /**
     * @return <b>True</b> if the Acceptor can accept packets. 
     */
    public boolean canAccept();

    /**
     * @param provided The packet provided.
     * @return <b>True</b> if the Acceptor accepted the packet.
     */
    public boolean accept(Packet<T> provided);
    
    /**
     * @return <b>True</b> if the Acceptor has a Provider assigned to it.
     */
    public boolean hasProvider();
    
    /**Set the provider of the Acceptor. The Acceptor can decide if it wants to adopt the Provider.
     */
    public void setProvider(Provider<T> provider);
    
    /** Request that the Acceptor close it's connection to a Provider. The Acceptor may also shut itself down if no more Providers are attached.
     * 
     * @param provider The Provider 
     */
    public void shutdown(Provider<T> provider);
}