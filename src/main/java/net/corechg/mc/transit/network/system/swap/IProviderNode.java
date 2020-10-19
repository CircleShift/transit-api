package net.corechg.mc.transit.network.system.swap;

import net.corechg.mc.transit.network.system.INode;

/**
 * @author Kyle Gunger
 * @apiNote A node which can provide packets of specific types
 */
public interface IProviderNode extends INode{
	
	/** Link another node as an acceptor
	 * 
	 * @param requester The object requesting the Acceptor
	 * @param group
	 * @return boolean
	 */
	public boolean linkAcceptor(IAcceptorNode requestor, String group);
	
	
	/** Unlink a provider from the acceptor
	 * 
	 * @param requestor
	 * @return
	 */
	public boolean unlinkAcceptor(IAcceptorNode requestor);
	
}
