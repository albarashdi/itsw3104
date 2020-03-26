package lecture7;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Ahmed Al-Brashdi
 */
public class BarrierDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

	CyclicBarrier barrier = new CyclicBarrier(5, 
                () -> System.out.println("Barrier openning"));
        
        for(int i =1;i<=5;i++){
            Friend friend = new Friend(barrier, i);
            executorService.execute(friend);
        }
        
        executorService.shutdown();
    }
}

class Friend implements Runnable {

    CyclicBarrier barrier = new CyclicBarrier(5);
    String name;
    public Friend(CyclicBarrier barrier, int index) {
        this.barrier = barrier;
        this.name="Friend "+index;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            Thread.sleep((random.nextInt(20) * 100 + 100));
            System.out.println(name +" just arrived, waiting for the others");

            barrier.await();
            System.out.println("Let's go to the cinema!");
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        } catch (BrokenBarrierException ex) {
            System.out.println("Broken barrier");
        }
    }
}
