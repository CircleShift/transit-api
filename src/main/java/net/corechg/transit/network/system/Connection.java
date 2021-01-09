package net.corechg.transit.network.system;

public class Connection {
    INode node;
    short mask;

	public Connection(INode n)
	{
		node = n;
		mask = 0;
	}

    public Connection(INode n, short m)
    {
		node = n;
		mask = m;
    }

    public INode getNode()
    {
        return node;
    }

    public boolean isAccepting()
    {
        return (mask & 1) == 1;
    }

    public void setAccepting(boolean value)
    {
        if(isAccepting() && value == false)
            mask -= 1;
        else if(!isAccepting() && value == true)
            mask += 1;
    }

    public boolean isProviding()
    {
        return (mask & 2) == 2;
    }

    public void setProviding(boolean value)
    {
        if(isProviding() && value == false)
            mask -= 2;
        else if(!isProviding() && value == true)
            mask += 2;
    }
}