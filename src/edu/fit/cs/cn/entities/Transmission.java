/**
 * 
 */
package edu.fit.cs.cn.entities;

/**
 * @author Lavanya 
 * @author Hari
 * @author Sridhar
 * @author Nanditha
 *
 */
public class Transmission {

	private long timeStamp;
	private String sourceNode;
	private String message;
	private String destNode;
	
	public Transmission(long timeStamp, String sourceNode, String message, String destNode) {
		this.timeStamp = timeStamp;
		this.sourceNode = sourceNode;
		this.message = message;
		this.destNode = destNode;
	}
	
	public long getTimeStamp() {
		return timeStamp;
	}
	
	public String getSourceNode() {
		return sourceNode;
	}

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
		return message;
	}
	
	public String getDestNode() {
		return destNode;
	}
	
	@Override
	public String toString() {
		return "Transmission [timeStamp=" + timeStamp + ", sourceNode="
				+ sourceNode + ", message=" + message + ", destNode="
				+ destNode + "]";
	}
	
}
