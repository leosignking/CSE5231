package edu.fit.cs.cn.entities;

import edu.fit.cs.cn.interfaces.Node;

/**
 * @author Group7
 */
public class SimpleNode extends Thread implements Node{

    private String nodeId;
    private SimpleMedium simpleMedium;

    SimpleNode(String nodeId, SimpleMedium simpleMedium) {
        this.nodeId = nodeId;
        this.simpleMedium = simpleMedium;
    }

    public String getNodeId() {
        return nodeId;
    }

    @Override
    public void receive(char[] message) {
        String msg = new String(message);
        System.out.println("Received Message at "+nodeId + " : " +msg);
    }
}
