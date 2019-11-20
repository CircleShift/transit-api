package net.transit.network.system;

import net.transit.network.swap.IAcceptor;
import net.transit.network.swap.IProvider;

/**
 * @author Kyle Gunger
 * @apiNote A node inside or outside a system. Provides acceptors and providers to other nodes.
 */
public interface INode
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
	public ISystem getSystem();
	
	/**Returns {@code true} if the node provides IAcceptors
	 * 
	 * @return boolean
	 */
	public boolean isAcceptor();
	
	/**Returns an IAcceptor or {@code null} depending on the requester and group
	 * 
	 * @param requester The object requesting the IAcceptor
	 * @param group
	 * @return IAcceptor
	 */
	public IAcceptor<?> requestAcceptor(Object requester, String group);
	
	/**Returns {@code true} if the node provides IProviders
	 * 
	 */
	public boolean isProvider();
	
	/**Returns an IProvider or {@code null} depending on the requester and group
	 * 
	 * @param requester The object requesting the IProvider
	 * @param group
	 * @return IProvider
	 */
	public IProvider<?> requestProvider(Object requestor, String group);
}
