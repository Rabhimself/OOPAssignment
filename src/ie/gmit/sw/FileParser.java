package ie.gmit.sw;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FileParser {
	public Map<String, Double> parse(String file) {
		Map<String, Double> temp = new ConcurrentHashMap<String, Double>();
		String[] lineArray;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		    String line;
		    try {
				while ((line = br.readLine()) != null) {
				   lineArray = line.split(" ");
				   temp.put(lineArray[0], Double.parseDouble((lineArray[1])));
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return temp;
	}
}
