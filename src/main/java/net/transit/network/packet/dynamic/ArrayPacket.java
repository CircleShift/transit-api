package net.transit.network.packet.dynamic;

import java.util.ArrayList;

import net.transit.type.Type;

/** A packet type which stores multiple values which can be accessed.  When getting data, pop and shift from the array.
 * @author Kyle Gunger
 *
 * @param <D> The data type (Object) that the packet transfers
 */
public class ArrayPacket<D> implements IDynamicPacket<D>
{
    private ArrayList<D> arrayData;
    private Type<D> type;

    /** Constructor
     * Create an array packet.  Adds the starting value.
     * @param startValue The starting value
     * @param t The type of the packet
    */
    public ArrayPacket(D startValue, Type<D> t)
    {
        arrayData = new ArrayList<D>(0);
        arrayData.add(startValue);
        type = t;
    }

    /**
     * Create an empty array packet of the desired type.
     * @param t The type of the packet
    */
    public ArrayPacket(Type<D> t)
    {
        arrayData = new ArrayList<D>(0);
        type = t;
    }
    
    /** Pop and shift data from the array.
     */
    @Override
    public D getData()
    {
        D temp = null;
        
        if(arrayData.size() > 0)
        {
            temp = arrayData.remove(0);
        }

        return temp;
    }

    /** Add data to the array.
     * @param data The data to push
     */
    public void setData(D data)
    {
        arrayData.add(data);
    }
    
    /** 
     * @return The ammount of data the packet holds
     */
    public int dataStored()
    {
    	return arrayData.size();
    }
    
    @Override
	public Type<D> getType() {
		return type;
	}
}