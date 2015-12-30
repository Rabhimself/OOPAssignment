package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class ScoreComparer implements Runnable {
	private BlockingQueue<Resultable> queue;
	private int doneFlag;
	private Resultable best = null;
	
	public ScoreComparer(BlockingQueue<Resultable> queue, int len) {
		super();
		this.queue = queue;
		doneFlag = (len/2) - 2;
	}
	
	@Override
	public void run() {
			while(true)
			{
				try {
					if(--doneFlag == -1)
						break;
					Resultable r = queue.take();
					if(best == null || r.getScore() > best.getScore())
						best = r;
						
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			System.out.println("Score: "+best.getScore());
			System.out.println("Text: "+best.getPlainText());
			System.out.println("Key: "+best.getKey());
		

	}

}
