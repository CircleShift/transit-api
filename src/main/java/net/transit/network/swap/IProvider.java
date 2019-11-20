package net.transit.network.swap;

import net.transit.network.packet.IPacket;

/**
 * @author Kyle Gunger
 *
 * @param <T> The type of data provided (in IPacket<<T>> form)
 */
public interface IProvider<T>
{
    /**
     * @return <b>True</b> if the provider can provide a packet.
     */
    public boolean canProvide();

    /**Get the next packet from the provider
     * 
     * @return IPacket<<T>>
     */
    public IPacket<T> provide();
    
    /**Retain the packet if the acceptor did not accept the packet.
     * 
     * @param rejected The rejected packet
     */
    public void retain(IPacket<T> rejected);
    
    /**
     * @return <b>True</b> if the acceptor has a provider assigned to it
     */
    public boolean hasAcceptor();
    
    /**Set the acceptor of the provider. The provider can decide if it wants to adopt the acceptor.
     */
    public void setAcceptor();
}