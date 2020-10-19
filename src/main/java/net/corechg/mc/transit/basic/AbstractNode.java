package net.corechg.mc.transit.basic;

import java.util.*;

import net.corechg.mc.transit.network.system.*;
import net.minecraft.block.entity.*;

public abstract class AbstractNode extends BlockEntity implements INode {

    public AbstractNode(BlockEntityType<?> type) {
        super(type);
    }

    HashMap<String, Object> data = new HashMap<String, Object>();
    ArrayList<Connection> connections = new ArrayList<Connection>(0);

    @Override
    public abstract boolean hasGroup(String groupID);

    @Override
    public ISystem getSystem() {
        return null;
    }

    @Override
    public Object getData(String groupID) {
        return data.get(groupID);
    }

    @Override
    public void setData(Object dat, String groupID) {
        data.put(groupID, dat);
    }

    @Override
    public Connection[] getConnections() {
        return (Connection[]) connections.toArray();
    }

    @Override
    public int connectionCount() {
        return connections.size();
    }
    
}