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
public class Lab3B {
    public static int num = 10;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new RunnerB());

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int s = 1; s < 11; s++) {
            executor.submit(t);
            Thread.sleep(1000);
        }
        executor.shutdown();
    }

}

class RunnerB implements Runnable {

    public void run() {

        System.out.println("The square root of " + Lab3B.num + " is " + Math.sqrt(Lab3B.num));
        Lab3B.num=Lab3B.num+1;
    }
}


