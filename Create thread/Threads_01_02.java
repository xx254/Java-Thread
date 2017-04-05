 /*
  * This program demonstrates various ways to create a thread in Java
  * 4 threads are created in the program
 */

 /*
 Four ways to create thread:
    1. Thread()
    2. Thread(Runnable obj)
    3. Thread(Runnable obj, String name)
    4. Thread(String name)

 Two ways to create thread:
    I. extends Thread class
        - subclass
        - must override the run() method
        - an instance can be allocated and started
    II. implements Runnable interface
        - create a Runnable object and use a Thread constructor
        - must override the run() method
 */
package threads_01_02;


public class Threads_01_02 {
     public static void main(String[] args)
     {
         //II. implements Runnable interface
         //2. Thread(Runnable obj)
         (new Thread(new HelloRunnable())).start();
         
         //I. extends Thread class
         // Thread()
         (new HelloThread()).start();
         //Create a runnable object 
         Runnable r1 = new Runnable()
         {
             @Override
             public void run()
             {
                 //perform some work inside the thread
                 System.out.println("Hello from "+
                         Thread.currentThread().getName()
                         + " NOT USING LAMBDA");
             }
         };
         //Create a runnable object using lambda notation
         Runnable r2 = () -> System.out.println("Hello from "
                 + Thread.currentThread().getName()+" USING LAMBDA "
                 + "notation");
         // 3. Thread(Runnable obj, String name)
         Thread t1 = new Thread(r1, "Thread t1");
         t1.start();
         
         /*Create and start a second thread using the runnable object with 
          *lambda notation and not given a name */
         // 2. Thread(Runnable obj)
         Thread t2 = new Thread(r2);
         
         t2.start();
         }
    }

    

