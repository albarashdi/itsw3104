/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class Lab3A2 {

    
public static int num = 10;
    public static void main(String[] args) throws InterruptedException {
        RunnerA2 r = new RunnerA2();
        Thread t = new Thread(r);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int s = 1; s < 11; s++) {
            executor.execute(t);
            t.sleep(1000);
        }
        executor.shutdown();
    }

}

class RunnerA2 implements Runnable {
    
    @Override
    public void run() {
        System.out.println("The square root of " + Lab3A2.num + " is " + Math.sqrt(Lab3A2.num));
        Lab3A2.num=Lab3A2.num+1;
    }
}
