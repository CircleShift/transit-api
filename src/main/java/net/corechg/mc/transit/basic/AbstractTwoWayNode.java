package net.corechg.mc.transit.basic;

import net.corechg.mc.transit.network.system.Connection;
import net.corechg.mc.transit.network.system.swap.*;
import net.minecraft.block.entity.BlockEntityType;

public abstract class AbstractTwoWayNode extends AbstractAcceptorNode implements IProviderNode {

    public AbstractTwoWayNode(BlockEntityType<?> type) {
        super(type);
	}

	@Override
    public boolean linkAcceptor(IAcceptorNode requestor, String group) {
        if(this.hasGroup(group))
		{
			for (Connection c : connections) {
				if(c.getNode() == requestor)
					return false;
			}

			connections.add(new Connection(requestor, (short) 1));

			return true;
		}
		
        return false;
    }

    @Override
    public boolean unlinkAcceptor(IAcceptorNode requestor) {
        for (Connection c : connections) {
			if(c.getNode() == requestor)
			{
				if(c.isProviding())
					c.setAccepting(false);
				else
					connections.remove(c);
				
				return true;
			}
		}
		
        return false;
    }

}