/**
 * 
 */

package edu.fit.cs.cn;

import edu.fit.cs.cn.util.ConfigParser;
import edu.fit.cs.cn.entities.Communication;


/**
 * @author Lavanya 
 * @author Hari
 * @author Sridhar
 * @author Nandini
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		if(args.length <= 0 && args.length > 1) {
			throw new IllegalArgumentException("Invalid Number of Arguments Passed");
		}
		
		Communication communication = ConfigParser.parseFile(args[0]);
		communication.init();
	}

}
