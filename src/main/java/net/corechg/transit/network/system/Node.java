package net.corechg.transit.network.system;

/**
 * @author Kyle Gunger
 * @apiNote A node inside or outside a system. Provides acceptors and providers to other nodes.
 */
public interface Node
{
	
	/**Returns the groupIDs of groups the node interacts with
	 * 
	 * @return String[]
	 */
	public String[] groupsProvided();
	
	
	/**Get the system managing the node or {@code null} if there isn't one
	 * 
	 * @return System
	 */
	public System getSystem();
	
	
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
	public Node[] getConnections();
}
