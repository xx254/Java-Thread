/*
    Thread States
*/

/*
    OUTPUT:
    main is  alive and in RUNNABLE state 
     and priority 5 
    Thread t1 is not alive and in NEW state
     and priority 5 
    Thread t1 is alive and in RUNNABLE state
     and priority 5 
    Thread-0 is alive and in RUNNABLE state
     and priority 5 
    Thread t2 is not alive and in TERMINATED state
     and priority 5 
    main is alive and in RUNNABLE state
     and priority 5 

*/
public class Threads_states {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        //print information about the current thread 
           System.out.printf("%s is %s alive and in %s " +
                "state %n and priority %d \n", Thread.currentThread().getName(), 
                Thread.currentThread().isAlive() ? "" : "not ",
                Thread.currentThread().getState(), 
                Thread.currentThread().getPriority());

        //Create a runnable object that prints information about the thread
            Runnable r1 = () -> {
                Thread thd = Thread.currentThread();
                System.out.printf("%s is %salive and in %s " +
                                  "state%n and priority %d \n", thd.getName(), 
                                  thd.isAlive() ? "" : "not ",
                                  thd.getState(), thd.getPriority());
            };

            //Create thread t1 and print the information BEFORE calling start(),
            // that is to execute the run() method in the Runnable interface
            Thread t1 = new Thread(r1, "Thread t1");
            System.out.printf("%s is %salive and in %s " +
                "state%n and priority %d \n", t1.getName(), 
                t1.isAlive() ? "" : "not ",
                t1.getState(), 
                t1.getPriority());
            t1.start();

            //Create thread t2 with only a runnable object and no name
            // in the output, it is: Thread-0 
            Thread t2 = new Thread(r1);
            t2.start(); 
            //put main thread to sleep for 2 seconds
            Thread.sleep(2000);
            
            //change the name of thread 2 and print out its info
            t2.setName("Thread t2");
            System.out.printf("%s is %salive and in %s " +
                "state%n and priority %d \n", t2.getName(), 
                t2.isAlive() ? "" : "not ",
                t2.getState(), 
                t2.getPriority());

            //print info about current thread 
            // at this time, t1 & t2 are already executed, only main() is left
            System.out.printf("%s is %salive and in %s " +
                "state%n and priority %d \n", Thread.currentThread().getName(), 
                Thread.currentThread().isAlive() ? "" : "not ",
                Thread.currentThread().getState(), 
                Thread.currentThread().getPriority());

    }
    
}
