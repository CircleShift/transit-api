package net.transit.packet;

import java.util.ArrayList;

public class ArrayPacket<D> implements IPacket<D>
{
    private ArrayList<D> arrayData;

    public ArrayPacket(D startValue)
    {
        arrayData = new ArrayList<D>(0);
        arrayData.add(startValue);
    }

    public D getData()
    {
        if(arrayData.size() > 0) return arrayData.get(0);
        return null;
    }

    public void addData(D data)
    {
        arrayData.add(data);
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
}