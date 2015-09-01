/**
 * 
 */
package edu.fit.cs.cn.util;

import edu.fit.cs.cn.entities.Communication;
import edu.fit.cs.cn.entities.Transmission;

import java.io.*;


/**
 * @author Lavanya 
 * @author Hari
 * @author Sridhar
 * @author Nandini
 *
 */
public class ConfigParser {

	public static Communication parseFile(String configFileName) throws Exception{
		File file = new File(configFileName);
		if(!file.exists()) {
			throw new Exception("File path specified doesn't exist. "+configFileName);
		}
		
		BufferedReader br = null;
		Communication communicaton = new Communication();
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			int lineNumber = 0;
			while((line = br.readLine().trim()) != null){
				lineNumber++;
				if(lineNumber <= 2) {
					if(lineNumber == 2) 
						communicaton.setMTU(Integer.parseInt(line));
					
					if(lineNumber == 1) 
						communicaton.setRateOfTransmission(Integer.parseInt(line));
					continue;
				}
				String[] arr = line.split(" ");
				Transmission transmission = new Transmission(arr[0], arr[1], arr[2], arr[3]);
				communicaton.addTransmission(transmission);
			}
			
		} catch (FileNotFoundException e) {
			throw new Exception(e.getMessage());
		} catch (IOException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e ) {
			throw new Exception(e.getMessage());
		} finally {
			if( br != null)
				try { br.close(); } catch (IOException e) {}
		}
		
		return communicaton;
		
	}
}
