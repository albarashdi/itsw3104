/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab4;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class Lab4BV2 {
static int count =0;
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ScheduledFuture future = 
                ses.scheduleWithFixedDelay(new RunnerB2(), 3, 1, TimeUnit.SECONDS);
        
        
        while (true) {
            //System.out.println("count :" + count);
            Thread.sleep(1000);
            if (count == 5) {
                System.out.println("Count is 5, cancel the scheduledFuture!");
                future.cancel(true);
                ses.shutdown();
                break;
            }
        }
        
        
    }

}
class RunnerB2 implements Runnable{

    @Override
    public void run(){
        System.out.println(new Date().toString());
        Lab4BV2.count++;
    }
    
}
