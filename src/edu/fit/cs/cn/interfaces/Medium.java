package edu.fit.cs.cn.interfaces;

public interface Medium {

	void openConnection(String nodeID);
	void transmit(char[] message);
	boolean isBusy();
	void closeConnection();
	
}
