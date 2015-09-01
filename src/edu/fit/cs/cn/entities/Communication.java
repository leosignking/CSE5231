/**
 * 
 */
package edu.fit.cs.cn.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lavanya 
 * @author Hari
 * @author Sridhar
 * @author Nandini
 *
 */
public class Communication {

	private int MTU; // Maximum Transmission Unit size
	private int RTU; // Rate of Transmission in milliseconds per one char/unit
	private List<Transmission> transmissionList = new ArrayList<Transmission>();
	
	public int getMTU() {
		return MTU;
	}
	public void setMTU(int mTU) {
		MTU = mTU;
	}
	
	public int getRateOfTransmission() {
		return RTU;
	}
	public void setRateOfTransmission(int rateOfTransmission) {
		this.RTU = rateOfTransmission;
	}
	
	public List<Transmission> getTransmissionList() {
		return transmissionList;
	}
	public void addTransmission(Transmission transmission) {
		this.transmissionList.add(transmission);
	}
	
	public void init() {
		
	}
	
}
