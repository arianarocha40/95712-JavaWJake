import java.sql.Timestamp;

public class Lab42 {
    public static void main(String[] args) {

        // Timestamp tStamp = new Timestamp(0); // added
        // long start = System.currentTimeMillis(); // added

        // CountDown cd1 = new CountDown(10);
        // CountDown cd2 = new CountDown(10);
        // cd1.run();
        // cd2.run();
        // System.out.println("Main: 1");

        // long end = System.currentTimeMillis(); // added
        // System.out.println(end-start); // added


        // start = System.currentTimeMillis();  // added   

        // CountDownRunnable cdr1 = new CountDownRunnable(10);
        // CountDownRunnable cdr2 = new CountDownRunnable(10);
        // Thread t1 = new Thread(cdr1);
        // Thread t2 = new Thread(cdr2);
        // t1.start();
        // t2.start();
        // System.out.println("Main: 2");

        // end = System.currentTimeMillis();  // added   
        // System.out.println("Time for Thread Count Down: " +(end-start)); // added
        
        // Counter mainCounter = new Counter();
        // for (int i = 0; i < 1000; i++) { mainCounter.increment();}
        // for (int i = 0; i < 1000; i++) { mainCounter.increment();}
        // System.out.println("Count = " + mainCounter.getCount());
        // System.out.println("Main 3"); 

        // Counter sharedCounter = new Counter();
        // Thread t3 = new Thread(new CounterRunnable(sharedCounter));
        // Thread t4 = new Thread(new CounterRunnable(sharedCounter));
        // t3.start();
        // t4.start();
        // try {
        //     t3.join();
        //     t4.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // System.out.println("Main: Counter = " + sharedCounter.getCount());
        // System.out.println("Main: 4");

        ProtectedCounter sharedPC = new ProtectedCounter();
        Thread t5 = new Thread(new CounterRunnable(sharedPC));
        Thread t6 = new Thread(new CounterRunnable(sharedPC));
        t5.start();
        t6.start();
        try {
            t5.join();
            t6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main: Counter = " + sharedPC.getCount());
        System.out.println("Main: 5");

/*        AtomicCounter atomicCounter = new AtomicCounter();
        Thread t7 = new Thread(new CounterRunnable(atomicCounter));
        Thread t8 = new Thread(new CounterRunnable(atomicCounter));
        t7.start();
        t8.start();
        try {
            t7.join();
            t8.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main: Counter = " + atomicCounter.getCount());
        System.out.println("Main: 6");*/


    }
}
