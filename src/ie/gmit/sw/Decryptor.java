package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class Decryptor implements Runnable{

	private BlockingQueue<Resultable> queue;
	private String cypherText;
	private int key;
	TextScorer scorer;
	
	public Decryptor(BlockingQueue<Resultable> queue, String cypherText, int key, QuadGramMap quadGramMap) {
		super();
		this.queue = queue;
		this.cypherText = cypherText;
		this.key = key;
		scorer = new TextScorer(quadGramMap);
	}

	public void run() {
		RailFence rf = new RailFence();
		String plainText = rf.decrypt(cypherText, key);
		double score = scorer.getScore(plainText);

		Resultable r = new Result(plainText, key, score);
		
		try {
			queue.put(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
