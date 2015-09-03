package edu.fit.cs.cn.entities;

import edu.fit.cs.cn.interfaces.Medium;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Group7
 */
public class SimpleMedium implements Medium{

	private boolean isBusy= false;
    private int MTU; // Maximum Transmission Unit size
    private long RTU; // Rate of Transmission in milliseconds per one char/unit
    
    private String connectedNodeId;
	
	private List<SimpleNode> connectedNodeList = new ArrayList<SimpleNode>();
	private Date timer = new Date();
	
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
	    System.out.println(this.connectedNodeId+"\t"+this.getTimerinTimeStampFormat()+"\tSTART_TX\t" +new String(message));
	    incrementTimer(message.length*this.RTU);
	    System.out.println(this.connectedNodeId+"\t"+this.getTimerinTimeStampFormat()+"\tEND_TX\t\t" +new String(message));
        for (SimpleNode simpleNode : connectedNodeList) {
            if(!simpleNode.getNodeId().equals(connectedNodeId))
                simpleNode.receive(message);
        }
	}

	public Date getTimer() {
		return timer;
	}

	public void setTimer(Date controlTimer) {
		this.timer = controlTimer;
	}
	public void incrementTimer(long ms) {
		this.timer = new Date(this.timer.getTime() + ms);
	}
	public String getTimerinTimeStampFormat() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.SSS");
		return formatter.format(this.timer);
	}

	public int getMTU() {
		return MTU;
	}

	public void setMTU(int mTU) {
		MTU = mTU;
	}

	public long getRTU() {
		return RTU;
	}

	public void setRTU(long rTU) {
		RTU = rTU;
	}

	public String getConnectedNodeId() {
		return connectedNodeId;
	}

	public void setConnectedNodeId(String connectedNodeId) {
		this.connectedNodeId = connectedNodeId;
	}

	public List<SimpleNode> getConnectedNodeList() {
		return connectedNodeList;
	}

	public void setConnectedNodeList(List<SimpleNode> connectedNodeList) {
		this.connectedNodeList = connectedNodeList;
	}

	public void setBusy(boolean isBusy) {
		this.isBusy = isBusy;
	}
	
}
