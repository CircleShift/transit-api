package net.corechg.transit.network.system.swap;

import net.corechg.transit.network.packet.IStaticPacket;
import net.corechg.transit.network.system.INode;

/**
 * @author Kyle Gunger
 * @apiNote A node which can accept packets of specific types
 */
public interface IAcceptorNode extends INode
{
	
	/** Link another node as a provider
	 * 
	 * @param requester The object to be a provider
	 * @param group
	 * @return
	 */
	public boolean linkProvider(IProviderNode requestor, String group);
	
	
	/** Unlink a provider from the acceptor
	 * 
	 * @param requestor
	 * @return
	 */
	public boolean unlinkProvider(IProviderNode requestor);
	
	
	/** Accept a packet from a provider
	 * 
	 * @param packet
	 * @param group
	 * @return
	 */
	public <T> boolean accept(IStaticPacket<T> packet, String group);
}
