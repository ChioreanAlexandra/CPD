package pb1_5_3;

import java.util.Queue;

public class Employee implements Runnable {

	private int id;
	private int creationDelay;
	private Queue<String> docs;
	
	public Employee(int id, int creationDelay, Queue<String> docs) {
		this.id = id;
		this.creationDelay = creationDelay;
		this.docs = docs;
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(this.creationDelay);
				synchronized(docs) {
					docs.add("Employee's " + this.id + " document");
					docs.notifyAll();
					System.out.println("Employee " + this.id + " added doc.");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
