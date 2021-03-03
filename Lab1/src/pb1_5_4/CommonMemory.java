package pb1_5_4;

public class CommonMemory {
	private String s;
	private int leftPointer;
	private int rightPointer;
	private boolean canIncrement = true;
	
	public CommonMemory()
	{
		super();
	}
	
	public CommonMemory(String s, int leftPointer, int rightPointer) {
		super();
		this.s = s;
		this.leftPointer = leftPointer;
		this.rightPointer = rightPointer;
	}
	
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public int getLeftPointer() {
		return leftPointer;
	}
	public void setLeftPointer(int leftPointer) {
		this.leftPointer = leftPointer;
	}
	public int getRightPointer() {
		return rightPointer;
	}
	public void setRightPointer(int rightPointer) {
		this.rightPointer = rightPointer;
	}
	
	public synchronized void increment() {
		while(!canIncrement) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Thread left:" + this.s.charAt(this.leftPointer));
		this.leftPointer += 1;
		canIncrement = false;
		notify();
		
	}
	
	public synchronized void decrement() {
		while(canIncrement) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Thread right:" + this.s.charAt(this.rightPointer));
		this.rightPointer -= 1;
		canIncrement = true;
		notify();
	}
	
	

}
