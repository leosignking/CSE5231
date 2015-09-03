/**
 *
 */
package edu.fit.cs.cn.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Lavanya
 * @author Hari
 * @author Sridhar
 * @author Nanditha
 *
 */
public class Communication {

    private int MTU; // Maximum Transmission Unit size
    private long RTU; // Rate of Transmission in milliseconds per one char/unit
    private List<Transmission> transmissionList = new ArrayList<Transmission>();
    private Set<String> nodeSet = new HashSet<String>();

    public int getMTU() {
        return MTU;
    }
    public void setMTU(int mTU) {
        MTU = mTU;
    }

    public long getRateOfTransmission() {
        return RTU;
    }
    public void setRateOfTransmission(long rateOfTransmission) {
        this.RTU = rateOfTransmission;
    }

    public List<Transmission> getTransmissionList() {
        return transmissionList;
    }
    public void addTransmission(Transmission transmission) {
        this.transmissionList.add(transmission);
        //add distinct node ids to set
        this.nodeSet.add(transmission.getSourceNode());
        this.nodeSet.add(transmission.getDestNode());
    }

    @Override
    public String toString() {
        return "Communication [MTU=" + MTU + ", RTU=" + RTU + ", nodeSetSize=" + nodeSet.size()
                + ", transmissionList=" + transmissionList + "]";
    }

    public void init() {
        try{
            SimpleMedium sMedium = new SimpleMedium();
            sMedium.setMTU(MTU);
            sMedium.setRTU(RTU);
            
            Date now = new Date();            
            sMedium.setTimer(now);
            
            for(String nodeId : nodeSet) {
                SimpleNode simpleNode = new SimpleNode(nodeId, sMedium);
                sMedium.addNode(simpleNode);
            }
            System.out.println("NodeID\tTimeStamp\t\tEvent Type\tMessage");

            long startTime = now.getTime();
            for (Transmission transmission : transmissionList){
                boolean isRun = true;
                while(isRun) {
                    if(System.currentTimeMillis() - startTime >= transmission.getTimeStamp()) {
                        sMedium.openConnection(transmission.getSourceNode());
                        String message = transmission.getMessage();
                        //System.out.println("Sending Node: "+transmission.getSourceNode());
                        for (int i = 0; i < message.length(); i++) {
                            if(message.length() >= MTU)
                                sMedium.transmit(message.substring(0, MTU).toCharArray());
                            else {
                                sMedium.transmit(message.substring(0, message.length()).toCharArray());
                                break;
                            }
                            message = message.substring(MTU, message.length());
                            transmission.setMessage(message);
                        }
                        sMedium.closeConnection();
                        isRun = false;
                    }
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
