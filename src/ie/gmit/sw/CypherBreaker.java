package ie.gmit.sw;

import java.util.concurrent.*;


//Creates Decryptor threads that decrypt text using railfence cyphers 
public class CypherBreaker {
	private static final int MAX_QUEUE_SIZE = 100;
	private BlockingQueue<Resultable> queue;
	private String cypherText;
	private QuadGramMap quadGramMap;


	public CypherBreaker(String cypherText, String file) { 
		queue = new ArrayBlockingQueue<Resultable>(MAX_QUEUE_SIZE);
		quadGramMap = new QuadGramMap(file);
		this.cypherText = cypherText;
		init();
	}

	public void init() {
		for(int i = 2; i < cypherText.length()/2; i++)
		{
			new Thread(new Decryptor(queue, cypherText, i, quadGramMap)).start();
			
		}
		new Thread(new ScoreComparer(queue, cypherText.length())).start();
	}
}
