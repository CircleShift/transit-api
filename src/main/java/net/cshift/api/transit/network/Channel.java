/*
	MIT License

	Copyright (c) 2023 Kyle Gunger
	
	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:
	
	The above copyright notice and this permission notice shall be included in all
	copies or substantial portions of the Software.
	
	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
	SOFTWARE.
*/

package net.cshift.api.transit.network;

import net.cshift.api.transit.network.packet.IStaticPacket;
import net.cshift.api.transit.type.group.GroupRegistry;
import net.cshift.api.transit.type.group.TypeGroup;

/**
 * @author Kyle Gunger
 * @apiNote A channel represents a connection between two nodes.  It is able to send data in packets, and serves as a way to organize incoming traffic.
 * @param <D> The type of data the packets will be transfering
 */
public final class Channel<D> {
    private INode to;
    private int id;
    private String group;
    private Class<D> baseClass;

    /** This constructor should be called by a node approving a connection.  The approving node can give the connection an ID and group.
     * Negative IDs indicate a terminated connection, so do not initialize the class with a negative ID.
     * 
     * @param node The recieving node
     * @param id The channel's id, as assigned by the recieving node.  In most cases, this will match the pool ID as a way to match channels to pools.
     * @param group 
     */
	public Channel(INode node, int id, String group, Class<D> baseClass)
	{
        to = node;
        this.id = id;
        this.group = group;
        this.baseClass = baseClass;
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
    public TypeGroup<D> getGroup() {
        return GroupRegistry.<D>groupByID(group, baseClass);
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
    public IStaticPacket send(IStaticPacket packet)
    {
        return to.accept(packet, this);
    }
}
