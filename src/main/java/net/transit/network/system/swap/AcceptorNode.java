package net.transit.network.system.swap;

import net.transit.network.packet.Packet;
import net.transit.network.system.Node;

public interface AcceptorNode extends Node
{
	
	/** Link another node as a provider
	 * 
	 * @param requester The object to be a provider
	 * @param group
	 * @return Provider
	 */
	public boolean linkProvider(Node requestor, String group);
	
	
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
