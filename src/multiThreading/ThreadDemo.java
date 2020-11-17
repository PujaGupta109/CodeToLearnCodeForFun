/*
package multiThreading;

import java.util.concurrent.Semaphore;

public class ThreadDemo  {
public static OddRunnable odd = new OddRunnable();
public static EvenRunnable even = new EvenRunnable();
 public static Thread odds = new Thread(odd);
  public static Thread evens = new Thread(even);
  public static void main(String[] args) throws InterruptedException {
      ThreadDemo td = new ThreadDemo();

      odds.start();
     Thread.sleep(1000l);
      evens.start();
    //  Thread.sleep(1000l);
      //Semaphore sp = new Semaphore();
  }

}

class OddRunnable implements Runnable{

    @Override
    public synchronized void run() {
        for(int i = 0; i<= 100; i++){
          int n =  (i%2!=0)? i: -1;
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          if(n>0){
              System.out.println(n);
          }

          notify();
        }
    }
}

class EvenRunnable implements Runnable {

    @Override
    public synchronized void run() {
        for (int i = 0; i <= 100; i++) {
            int n = (i % 2 == 0) ? i : -1;
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (n > 0) {
                System.out.println(n);

            }
            notify();
        }
    }
}
*/
