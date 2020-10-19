package net.corechg.mc.transit.network.system;

/**
 * @author Kyle Gunger
 * @apiNote A node inside or outside a system.
 */
public interface INode
{
	
	/**Returns true if the group given is used by the node
	 * 
	 * @param groupID the group to querry
	 * @return bool
	 */
	public boolean hasGroup(String groupID);
	
	
	/**Get the system managing the node or {@code null} if there isn't one
	 * 
	 * @return System
	 */
	public ISystem getSystem();
	
	
	/** Get the data of one of the TypeGroups the Node supports
	 * 
	 * @param groupID
	 * @return
	 */
	public Object getData(String groupID);
	
	
	/** Set the group data for the node
	 * 
	 * @param dat
	 * @param groupID
	 */
	public void setData(Object dat, String groupID);


	/** Get the nodes that this node is connected to
	 * 
	 * @return Node[]
	 */
	public Connection[] getConnections();


	/** Get the number of nodes that this node is connected to
	 * 
	 * @return int
	 */
	public int connectionCount();
}
