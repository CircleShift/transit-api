package net.transit.network.system.swap;

import net.transit.network.packet.IStaticPacket;
import net.transit.network.system.INode;

public interface AcceptorNode extends INode
{
	
	/** Link another node as a provider
	 * 
	 * @param requester The object to be a provider
	 * @param group
	 * @return
	 */
	public boolean linkProvider(INode requester, String group);
	
	
	/** Unlink a provider from the acceptor
	 * 
	 * @param toUnlink
	 * @return
	 */
	public boolean unlinkProvider(INode toUnlink);
	
	
	/**
	 * @return Node[]
	 */
	public INode[] getProviders();
	
	
	/** Accept a packet from a provider
	 * 
	 * @param packet
	 * @param group
	 * @return
	 */
	public boolean accept(IStaticPacket<?> packet, String group);
}
