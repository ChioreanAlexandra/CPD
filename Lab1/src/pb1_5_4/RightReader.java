package pb1_5_4;

public class RightReader implements Runnable{
	
	public CommonMemory memory;
	
	
	public RightReader(CommonMemory memory) {
		super();
		this.memory = memory;
	}


	@Override
	public void run() {
		synchronized(memory)
		{
			while(memory.getLeftPointer() <= memory.getRightPointer())
			{
				memory.decrement();
			}
		}
		
	}

}
