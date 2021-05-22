package net.cshift.transit.network.packet;

import net.cshift.transit.type.Type;

/** Static packet with extra data attached.
 * @author Kyle Gunger
 *
 * @param <D> The data type (Object) that the packet transfers
 * @param <M> The type of metadata
*/
public class MetaDynamicPacket<D, M> extends DynamicPacket<D>
{
	private M metaData;

    /** Constructor
     *
     * @param dat The data to store
     * @param t The Type of the data
     * @param meta The metadata to store
     */
    public MetaDynamicPacket(D dat, Type<D> t, M meta)
    {
        super(dat, t);
        metaData = meta;
    }

    /** Get the metadata of the packet.
     *
     * @return The packet's metadata
     */
    public M getMetaData()
    {
    	return metaData;
    }

    /** Set the metadata of the packet.
     *
     * @param meta The packet's new metadata
     */
    public void setMetaData(M meta)
    {
        metaData = meta;
    }
}
