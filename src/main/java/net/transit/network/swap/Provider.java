package net.transit.network.swap;

import net.transit.network.packet.Packet;
import net.transit.network.system.Node;

/**
 * @author Kyle Gunger
 *
 * @param <T> The type of data provided (in IPacket<<T>> form)
 */
public interface Provider<T>
{
	/** Returns the INode this Provider is attached to. All Acceptors and Providers must be attached to an INode to function.
	 * 
	 * @return INode
	 */
	public Node getNode();
	
    /**
     * @return <b>True</b> if the Provider can provide a packet.
     */
    public boolean canProvide();

    /**Get the next packet from the Provider
     * 
     * @return IPacket<<T>>
     */
    public Packet<T> provide();
    
    /**Retain the packet if the Acceptor did not accept the packet.
     * 
     * @param rejected The rejected packet
     */
    public void retain(Packet<T> rejected);
    
    /**
     * @return <b>True</b> if the Provider has an Acceptor assigned to it
     */
    public boolean hasAcceptor();
    
    /**Set the Acceptor of the Provider. The Provider can decide if it wants to adopt the Acceptor.
     */
    public void setAcceptor(Acceptor<T> acceptor);
    
    /** Request that the Provider close it's connection to a Acceptor. The Provider may also shut itself down if no more Acceptors are attached.
     * 
     * @param acceptor The Acceptor 
     */
    public void shutdown(Acceptor<T> acceptor);
}