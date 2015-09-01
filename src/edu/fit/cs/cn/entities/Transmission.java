/**
 * 
 */
package edu.fit.cs.cn.entities;

/**
 * @author Lavanya 
 * @author Hari
 * @author Sridhar
 * @author Nandini
 *
 */
public class Transmission {

	private String timeStamp;
	private String sourceNode;
	private String message;
	private String destNode;
	
	public Transmission(String timeStamp, String sourceNode, String message, String destNode) {
		this.timeStamp = timeStamp;
		this.sourceNode = sourceNode;
		this.message = message;
		this.destNode = destNode;
	}
	
	public String getTimeStamp() {
		return timeStamp;
	}
	
	public String getSourceNode() {
		return sourceNode;
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
