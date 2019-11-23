package net.transit.network.system.swap;

import net.transit.network.packet.Packet;
import net.transit.network.system.Node;

public interface AcceptorNode extends Node
{
	
	/** Link another node as a provider
	 * 
	 * @param requester The object to be a provider
	 * @param group
	 * @return
	 */
	public boolean linkProvider(Node requester, String group);
	
	
	/** Unlink a provider from the acceptor
	 * 
	 * @param toUnlink
	 * @return
	 */
	public boolean unlinkProvider(Node toUnlink);
	
	
	/**
	 * @return Node[]
	 */
	public Node[] getProviders();
	
	
	/** Accept a packet from a provider
	 * 
	 * @param packet
	 * @param group
	 * @return
	 */
	public boolean accept(Packet<?> packet, String group);
}
