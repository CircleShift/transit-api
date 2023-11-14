package net.cshift.api.transit.network.packet;

import net.cshift.api.transit.type.*;

/** Static packet with extra data attached.
 * @author Kyle Gunger
 *
 * @param <D> The data type (Object) that the packet transfers
 * @param <M> The type of metadata
*/
public class MetaPacket<D, M> extends StaticPacket<D>
{
	private M metaData;

    /** Constructor
     * 
     * @param dat The data to store
     * @param t The Type of the data
     * @param meta The metadata to store
     */
    public MetaPacket(D dat, Type<D> t, M meta)
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
}
