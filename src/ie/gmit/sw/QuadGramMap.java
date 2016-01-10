package ie.gmit.sw;

import java.util.concurrent.ConcurrentHashMap;

public class QuadGramMap{
	public static final int GRAM_SIZE = 4;
	private ConcurrentHashMap<String, Double> map;
	
	public QuadGramMap(String file) {
		map = (ConcurrentHashMap<String, Double>) new FileParser().parse(file);
	}
	public QuadGramMap()
	{
		map = (ConcurrentHashMap<String, Double>) new FileParser().parseFromJar();
	}
	
	public double get(String quadgram)
	{
		return map.get(quadgram);
	}
	public boolean containsKey(String quadgram)
	{
		return map.containsKey(quadgram);
	}
	public int size()
	{
		return map.size();
	}
}
