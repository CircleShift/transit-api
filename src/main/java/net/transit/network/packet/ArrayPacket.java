package net.transit.network.packet;

import java.util.ArrayList;

import net.transit.type.Type;

public class ArrayPacket<D> implements Packet<D>
{
    private ArrayList<D> arrayData;
    private Type<D> type;

    public ArrayPacket(D startValue, Type<D> t)
    {
        arrayData = new ArrayList<D>(0);
        arrayData.add(startValue);
        type = t;
    }
    
    @Override
    public D getData()
    {
        if(arrayData.size() > 0) return arrayData.get(0);
        return null;
    }

    public void addData(D data)
    {
        arrayData.add(data);
    }
    
    public int dataStored()
    {
    	return arrayData.size();
    }

    public D popAndShift()
    {
        D temp = null;
        
        if(arrayData.size() > 0)
        {
            temp = arrayData.remove(0);
        }

        return temp;
    }
    
    @Override
	public Type<D> getType() {
		return type;
	}
}