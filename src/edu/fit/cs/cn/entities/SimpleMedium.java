package edu.fit.cs.cn.entities;

import edu.fit.cs.cn.interfaces.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Group7
 */
public class SimpleMedium implements Medium{

    private String connectedNodeId;
	private boolean isBusy= false;
	private List<SimpleNode> connectedNodeList = new ArrayList<SimpleNode>();
	
	public void openConnection(String nodeId){
        this.connectedNodeId = nodeId;
	}

    public void addNode(SimpleNode simpleNode) {
        connectedNodeList.add(simpleNode);
    }

	public void closeConnection(){
	}

	public boolean isBusy(){
        return isBusy;
    }

	public void transmit(char[] message){
	    isBusy = true;
        for (SimpleNode simpleNode : connectedNodeList) {
            if(!simpleNode.getNodeId().equals(connectedNodeId))
                simpleNode.receive(message);
        }
	}
	
}
