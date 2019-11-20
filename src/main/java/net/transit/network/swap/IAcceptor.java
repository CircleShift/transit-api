package net.transit.network.swap;

import net.transit.network.packet.IPacket;

/**
 * @author Kyle Gunger
 *
 * @param <T> The type of data accepted (in IPacket<<T>> form)
 */
public interface IAcceptor<T>
{
    /**
     * @return <b>True</b> if the acceptor can accept packets. 
     */
    public boolean canAccept();

    /**
     * @param provided The packet provided.
     * @return <b>True</b> if the acceptor accepted the packet.
     */
    public boolean accept(IPacket<T> provided);
    
    /**
     * @return <b>True</b> if the acceptor has a provider assigned to it.
     */
    public boolean hasProvider();
    
    /**Set the provider of the acceptor. The acceptor can decide if it wants to adopt the provider.
     */
    public void setProvider(IProvider<T> provider);
}