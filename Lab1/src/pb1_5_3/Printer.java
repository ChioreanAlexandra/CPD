package pb1_5_3;

import java.util.Queue;

public class Printer implements Runnable{
	private Queue<String> docs;
	private int delay;
	
	public Printer(Queue<String> docs, int delay) {
		super();
		this.docs = docs;
		this.delay = delay;
	}
	
	@Override
	public void run() {
		while(true)
		{
			synchronized(docs){
				try {
					while(docs.isEmpty())
					{
						System.out.println("Queue is empty");
						docs.wait();
					}
					String currentDoc = docs.poll();
					System.out.println(currentDoc);
					Thread.sleep(this.delay);
					System.out.println("Done processing\n");
					docs.notifyAll();
				}
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	
		
	}

}
