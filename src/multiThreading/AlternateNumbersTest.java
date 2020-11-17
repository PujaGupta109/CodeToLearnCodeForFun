package multiThreading;



public class AlternateNumbersTest{
    public static void main(String[] args){
        Printer printer = new Printer();
        Thread t1= new Thread(new AlternateNumbers(printer,10,false),"Odd");
        Thread t2= new Thread(new AlternateNumbers(printer,10,true),"Even");
        t1.start();
        t2.start();
    }
}

class AlternateNumbers implements Runnable{
    private int max;
    private Printer print;
    private boolean isEvenNumber;

    public AlternateNumbers(Printer printer, int i, boolean b) {
        this.isEvenNumber = b;
        this.max =i;
        this.print = printer;

    }

    @Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while (number <= max) {
            if (isEvenNumber) {
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            number += 2;
        }
    }
}

class Printer{
  volatile  boolean isOdd;
   synchronized void printEven(int number){
      while(!isOdd){
          try {
              wait();
          } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
          }
      }
      System.out.println(Thread.currentThread().getName()+ ":" + number);
      isOdd = false;
      notify();
  }

    synchronized void printOdd(int number){
        while(isOdd){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName()+ ":" + number);
        isOdd = true;
        notify();
    }
}
