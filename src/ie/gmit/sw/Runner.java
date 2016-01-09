package ie.gmit.sw;

public class Runner {

	public static void main(String[] args) {
		RailFence rf = new RailFence();
		String s = rf.encrypt("THISISASTRINGTHESESHOULDBEWORDS", 6);
		String file = ("4grams.txt");
		System.out.println(s);
		CypherBreaker breaker = new CypherBreaker(s, file);
	}
}
