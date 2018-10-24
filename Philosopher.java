
public class Philosopher implements Runnable{

	private Object leftfork;
	private Object rightfork;
	
	public Philosopher(Object leftfork,Object rightfork)
	{
		this.leftfork=leftfork;
		this.rightfork=rightfork;
	}
	
	public void doAction(String action) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + action);
		        Thread.sleep(((int) (Math.random() * 100)));
		
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				doAction("Thinking");
				synchronized(leftfork) {
					doAction("first picked the left fork");
					synchronized(rightfork) {
						doAction("then Picked up right fork and start eating");
						doAction("Picked down right fork");
			}
					doAction("Picked down left fork and thinking");
				}
				
			}
		} catch(InterruptedException e)
		{
			Thread.currentThread().interrupt();
		}
	}
}
