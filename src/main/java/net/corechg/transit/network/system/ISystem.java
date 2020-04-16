package net.corechg.transit.network.system;


/**ISystem - a group of nodes optimized for performance
 * 
 * A node can exist without a system, but a system can not exist without at least one root node.
 * 
 * @param T The object type stored in the system.
 */
public interface ISystem
{
	/**The nodes stored by the system
	 * 
	 * @return INode[]
	 */
	public INode[] getNodes();
}
