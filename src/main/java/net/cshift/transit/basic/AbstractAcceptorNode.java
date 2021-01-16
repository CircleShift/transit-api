package net.cshift.transit.basic;

import net.cshift.transit.network.packet.*;
import net.cshift.transit.network.system.*;
import net.cshift.transit.network.system.swap.*;
import net.minecraft.block.entity.*;

public abstract class AbstractAcceptorNode extends AbstractNode implements IAcceptorNode {

    public AbstractAcceptorNode(BlockEntityType<?> type) {
        super(type);
	}
	
	@Override
	public abstract <T> boolean accept(IStaticPacket<T> packet, String group);

    @Override
    public boolean linkProvider(IProviderNode requestor, String group) {
		if(this.hasGroup(group))
		{
			for (Connection c : connections) {
				if(c.getNode() == requestor)
					return false;
			}

			connections.add(new Connection(requestor, (short) 2));

			return true;
		}
		
        return false;
    }

    @Override
    public boolean unlinkProvider(IProviderNode requestor) {
        for (Connection c : connections) {
			if(c.getNode() == requestor)
			{
				if(c.isAccepting())
					c.setProviding(false);
				else
					connections.remove(c);
				
				return true;
			}
		}
		
        return false;
    }
    
}
