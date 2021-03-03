package pb1_5_4;

public class LeftReader implements Runnable{

public CommonMemory memory;
	
	
	public LeftReader(CommonMemory memory) {
		super();
		this.memory = memory;
	}


	@Override
	public void run() {
		synchronized(memory)
		{
			while(memory.getLeftPointer() <= memory.getRightPointer())
			{
				memory.increment();
			}
		}
		
	}

}
