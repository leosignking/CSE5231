/**
 * 
 */

package edu.fit.cs.cn;

import edu.fit.cs.cn.entities.Communication;
import edu.fit.cs.cn.util.ConfigParser;

/**
 * @author Lavanya 
 * @author Hari
 * @author Sridhar
 * @author Nanditha
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		try{
			if(args.length <= 0 && args.length > 1) {
				throw new IllegalArgumentException("Invalid Number of Arguments Passed");
			}
			Communication communication = ConfigParser.parseFile(args[0]);
			System.out.println(communication);
			communication.init();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
