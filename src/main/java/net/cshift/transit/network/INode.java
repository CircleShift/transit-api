package net.cshift.transit.network;

import net.cshift.transit.network.packet.*;

/**
 * @author Kyle Gunger
 * @apiNote A node inside or outside a system.
 */
public interface INode
{
	/** Returns a pool manifest for the INode
	 *
	 */
	public PoolManifest getManifest();



	// ###############
	// # Connections #
	// ###############

	/** Call this function to establish a specific connection with a node.
	 * 
	 * @param <T> The type of connection being asked for
	 * @param poolID The ID of the pool the channel will interface with (see PoolManifest)
	 * @param asker The asking node
	 * @return A channel if the node accepts the request, {@code null} otherwise
	 */
	public <T> Channel<T> connect(int poolID, String group, INode asker);
	
	/** Call this function to establish a default connection with a node.
	 * 
	 * @param <T> The type of connection being asked for
	 * @param group The group that is being connected to
	 * @param asker The asking node
	 * @return A channel if the node accepts the request, {@code null} otherwise
	 */
	public <T> Channel<T> connectDefault(String group, INode asker);

	/** Accept a packet from a channel (or not).
	 * 
	 * @apiNote Do not call this function, use Channel.send(packet) instead.
	 * @param <T> The type of the packet and channel
	 * @param packet The packet to be vetted
	 * @param channel The channel which the packet is coming through
	 * @return The overflow data if the packet is only partially accepted. {@code null} otherwise.
	 */
	public <T> IStaticPacket<T> accept(IStaticPacket<T> packet, Channel<T> channel);

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
