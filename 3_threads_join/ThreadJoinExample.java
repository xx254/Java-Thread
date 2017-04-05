/* This program demonstrates the use of some advanced thread 
 * methods, specifically sleep and join.  This is the main 
 * method which creates three threads. Then it tries to join 
 * thread2 causing the system to wait until it is done, then
 * thread3 can start. 
*/

/*
OUTPUT:
    t1 i = 1
    t2 i = 1
    t1 i = 2
    t2 i = 2
    t2 i = 3
    t1 i = 3
    t2 i = 4
    t1 i = 4
    t2 i = 5
    t1 i = 5
    t3 i = 1
    t3 i = 2
    t3 i = 3
    t3 i = 4
    t3 i = 5
*/


public class ThreadJoinExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestJoinClass t1 = new TestJoinClass("t1");  
        TestJoinClass t2 = new TestJoinClass("t2");  
        TestJoinClass t3 = new TestJoinClass("t3");  
        t1.start();  
        t2.start();  
        try{  
            t2.join();
        }catch(Exception e){System.out.println(e);}  
        
        //thread 3 won't start until thread 2 is complete
        t3.start();  
    }
    
}
