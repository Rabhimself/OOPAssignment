package ie.gmit.sw;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FileParser {
	public Map<String, Double> parse(String file) {
		Map<String, Double> temp = new ConcurrentHashMap<String, Double>();
		String[] lineArray;
		BufferedReader br = null;
		File f = new File(file);
		try {
			br = new BufferedReader(new FileReader(f));
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

	public Map<String, Double> parseFromJar() {
		Map<String, Double> temp = new ConcurrentHashMap<String, Double>();
		String[] lineArray;
		InputStream in = getClass().getResourceAsStream("/4grams.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
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
