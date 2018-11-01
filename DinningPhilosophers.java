public class DinningPhilosophers {
  public static void main(String args[]) {
    Philosopher philosopher[]=new Philosopher[5];
    Object forks[]=new Object[philosopher.length];
    for(int counter=0;counter<forks.length;counter++) {
      forks[counter]=new Object();
    }
    for (int counter = 0; counter < philosopher.length; counter++) {
      Object leftfork = forks[counter];
      Object rightfork = forks[(counter + 1) % forks.length];
        if(counter==philosopher.length-1) {
        philosopher[counter] = new Philosopher(rightfork, leftfork);
        }
        else {
        philosopher[counter] = new Philosopher(leftfork, rightfork);
        }
    Thread thread=new Thread(philosopher[counter], "Philosopher " + (counter + 1));
    thread.start();
    }
  }
}
