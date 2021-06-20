package net.cshift.transit.network;

import net.cshift.transit.network.packet.IStaticPacket;

/**
 * @author Kyle Gunger
 * @apiNote A channel represents a connection between two nodes.  It is able to send data in packets, and serves as a way to organize incoming traffic.
 * @param <D> The type of data the packets will be transfering
 */
public final class Channel<D> {
    private INode to;
    private int id;
    private String group;

    /** This constructor should be called by a node approving a connection.  The approving node can give the connection an ID and group.
     * Negative IDs indicate a terminated connection, so do not initialize the class with a negative ID.
     * 
     * @param node The recieving node
     * @param id The channel's id, as assigned by the recieving node.  In most cases, this will match the pool ID as a way to match channels to pools.
     * @param group 
     */
	public Channel(INode node, int id, String group)
	{
        to = node;
        this.id = id;
        this.group = group;
	}



    // ####################
    // # Channel specific #
    // ####################

    /** The recieving INode
     * 
     * @return
     */
    public INode getReciever()
    {
        return to;
    }

    /** The ID of the connection, assigned by the recieving INode
     * 
     * @return
     */
    public int getID()
    {
        return id;
    }

    /** The group that the channel operates on
     * 
     * @return
     */
    public String getGroup() {
        return group;
    }

    /** Returns true if the connection has been terminated
     * 
     * @return
     */
    public boolean isTerminated()
    {
        return id < 0;
    }



    // ################################
    // # Info from the recieving node #
    // ################################

    /** Pressure
	 *
     * @apiNote This part of the api is not properly documented yet, and it's use is not reccommended for cross-mod communications.
	 * @return A Number representing the pressure from the channel (in base group units).
	 */
	public Number pressure()
    {
        return to.getPressure(this);
    }

	/** Max transfer rate
	 * 
	 * @return A Number representing the max transfer rate from the channel (in base group units per tick).
	 */
	public Number rate()
    {
        return to.getRate(this);
    }



    // ################################
    // # Interact with the other node #
    // ################################

    /** Terminates the connection and relays the termination to the recieving node
     */
    public void terminate()
    {
        id = -1;
        to.onTerminate(this);
    }

    /** Send a packet to the recieving node
     * 
     * @param packet the packet to send
     * @return The overflow data if the packet is only partially accepted. {@code null} otherwise.
     */
    public IStaticPacket<D> send(IStaticPacket<D> packet)
    {
        return to.accept(packet, this);
    }
}
