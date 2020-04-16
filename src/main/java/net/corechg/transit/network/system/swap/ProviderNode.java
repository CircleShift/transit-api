package net.corechg.transit.network.system.swap;

import net.corechg.transit.network.system.INode;

public interface ProviderNode extends INode{
	
	/** Link another node as an acceptor
	 * 
	 * @param requester The object requesting the Acceptor
	 * @param group
	 * @return boolean
	 */
	public boolean linkAcceptor(INode requester, String group);
	
	
	/** Unlink a provider from the acceptor
	 * 
	 * @param toUnlink
	 * @return
	 */
	public boolean unlinkAcceptor(INode toUnlink);
	
	
	/**
	 * @return Node[]
	 */
	public INode[] getAcceptors();
	
}
