package net.cshift.transit.network;

import net.cshift.transit.network.packet.*;

/**
 * @author Kyle Gunger
 * @apiNote A node inside or outside a system.
 */
public interface INode
{
	/** Returns a channel manifest for the INode
	 *
	 */
	public PoolManifest getManifest();

	/** Get the system managing the node or {@code null} if there isn't one
	 *
	 * @return System
	 */
	public ISystem getSystem();



	// ###############
	// # Connections #
	// ###############

	/** Call this function to establish a connection with a node.
	 * 
	 * @param <T> The type of connection being asked for
	 * @param group The group of connection being asked for
	 * @param asker The asking node
	 * @return A channel if the node accepts the request, {@code null} otherwise
	 */
	public <T> Channel<T> connect(int poolID, INode asker);

	/** Accept a packet from a channel (or not).
	 * 
	 * @apiNote Do not call this function, use Channel.send(packet) instead.
	 * @param <T> The type of the packet and channel
	 * @param packet The packet to be vetted
	 * @param channel The channel which the packet is coming through
	 * @return true if the node accepts the packet
	 */
	public <T> boolean accept(IStaticPacket<T> packet, Channel<T> channel);

	/** Pressure
	 *
	 * @apiNote Do not call this function, use Channel.pressure() instead.
	 * @param channel The channel asking for the pressure
	 * @return A Number representing the pressure from the channel (in base group units).
	 */
	public <T> Number getPressure(Channel<T> channel);

	/** Transfer rate
	 * 
	 * @apiNote Do not call this function, use Channel.rate() instead.
	 * @param channel The channel asking for the transfer rate
	 * @return A Number representing the transfer rate from the channel (in base group units per tick).
	 */
	public <T> Number getRate(Channel<T> channel);

	/** Called when a channel is terminated
	 * 
	 * @apiNote Do not call this function, use Channel.terminate() instead.
	 * @param <T> The type of the channel
	 * @param channel The channel being terminated
	 */
	public <T> void onTerminate(Channel<T> channel);

}
