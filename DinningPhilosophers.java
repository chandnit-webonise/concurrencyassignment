
public class DinningPhilosophers {

	public static void main(String args[])
	{
		Philosopher philosopher[]=new Philosopher[5];
		Object forks[]=new Object[philosopher.length];
		
		for(int i=0;i<forks.length;i++)
		{
			forks[i]=new Object();
		}
		
		for (int i = 0; i < philosopher.length; i++) {
            Object leftfork = forks[i];
            Object rightfork = forks[(i + 1) % forks.length];
            if(i==philosopher.length-1) {
            	philosopher[i] = new Philosopher(rightfork, leftfork);
            }
            else {
            	philosopher[i] = new Philosopher(leftfork, rightfork);
            }  
            Thread t 
              = new Thread(philosopher[i], "Philosopher " + (i + 1));
            t.start();
		}
	}
}
