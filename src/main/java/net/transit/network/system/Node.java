package net.transit.network.system;

import net.transit.network.swap.Acceptor;
import net.transit.network.swap.Provider;

/**
 * @author Kyle Gunger
 * @apiNote A node inside or outside a system. Provides acceptors and providers to other nodes.
 */
public interface Node
{
	/**Returns the groupIDs of groups the node provide
	 * 
	 * @return String[]
	 */
	public String[] groupsProvided();
	
	/**Get the system managing the node or {@code null} if there isn't one
	 * 
	 * @return ISystem
	 */
	public System getSystem();
	
	/**Returns {@code true} if the node provides Acceptors
	 * 
	 * @return boolean
	 */
	public boolean isAcceptor();
	
	/**Returns an Acceptor or {@code null} depending on the requester and group
	 * 
	 * @param requester The object requesting the Acceptor
	 * @param group
	 * @return Acceptor
	 */
	public Acceptor<?> requestAcceptor(Object requester, String group);
	
	/**Returns {@code true} if the node provides Providers
	 * 
	 */
	public boolean isProvider();
	
	/**Returns an Provider or {@code null} depending on the requester and group
	 * 
	 * @param requester The object requesting the Provider
	 * @param group
	 * @return Provider
	 */
	public Provider<?> requestProvider(Object requestor, String group);
}
