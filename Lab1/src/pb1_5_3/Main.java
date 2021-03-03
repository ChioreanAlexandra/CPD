package pb1_5_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Queue<String> docs = new LinkedList<String>();
		Thread threads[] = new Thread[8];
		Random random = new Random();
		int max = 7000;
		int min = 4000;
		Thread printerTh = new Thread(new Printer(docs, 2000));
		printerTh.start();
		//printerTh.setPriority(10);
		
 		for (int i = 0; i<8 ; i++)
		{
 			int delay = random.nextInt(max - min + 1) + min;
 			Employee e = new Employee(i, delay, docs);
			threads[i] = new Thread(e);
			threads[i].start();
		}

	}

}
