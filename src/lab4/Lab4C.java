/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class Lab4C {
    static int count =0;
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ScheduledFuture future = 
                ses.scheduleAtFixedRate(new RunnerC(), 0, 3, TimeUnit.SECONDS);
        
        
        while (true) {
            //System.out.println("count :" + count);
            Thread.sleep(1000);
            if (count == 5) {
                System.out.println("beeped 5 times, work is done!");
                future.cancel(true);
                ses.shutdown();
                break;
            }
        }
    }

}
class RunnerC implements Runnable{
    public void run(){
        java.awt.Toolkit.getDefaultToolkit().beep();
        Lab4C.count++;
    }
}