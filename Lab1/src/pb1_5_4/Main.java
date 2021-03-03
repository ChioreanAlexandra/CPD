package pb1_5_4;

public class Main {

	public static void main(String[] args) {
		String s= "Alexandra";
		CommonMemory memory = new CommonMemory(s, 0, s.length() - 1);
		Thread th1 = new Thread(new LeftReader(memory));
		Thread th2 = new Thread(new RightReader(memory));
		
		th1.start();
		th2.start();
	}

}
