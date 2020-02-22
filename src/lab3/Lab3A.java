/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class Lab3A {
    public static int num = 10;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runner());

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int s = 1; s <= 11; s++) {
            executor.execute(t);
            Thread.sleep(500);
        }
        executor.shutdown();
    }

}

class Runner implements Runnable {

    public void run() {
        

        System.out.println("The square root of " + Lab3A.num + " is " + Math.sqrt(Lab3A.num));
        Lab3A.num=Lab3A.num+1;
    }
}
