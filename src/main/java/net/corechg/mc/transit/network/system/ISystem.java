package net.corechg.mc.transit.network.system;


/**
 * @author Kyle Gunger
 * @apiNote An ISystem represents a system of nodes which has been optimized for performance.  A node can exist on its own, but an ISystem can't exist without a node.
 */
public interface ISystem
{
	/**The nodes stored by the system
	 * 
	 * @return INode[]
	 */
	public INode[] getNodes();
}
