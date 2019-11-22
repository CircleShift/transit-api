package net.transit.network.system.swap;

import net.transit.network.system.Node;

public interface ProviderNode extends Node{
	
	/** Link another node as an acceptor
	 * 
	 * @param requester The object requesting the Acceptor
	 * @param group
	 * @return boolean
	 */
	public boolean linkAcceptor(Node requester, String group);
	
	/**
	 * @return Node[]
	 */
	public Node[] getAcceptors();
	
}
