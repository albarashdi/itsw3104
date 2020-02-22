/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab4;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class Lab4A {
    public static void main(String[] args) {
        
        
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        System.out.println(new Date());
        ses.schedule(new Runner4A(), 5, TimeUnit.SECONDS);
        
        ses.shutdown();
        
        
    }

}
class Runner4A implements Runnable{

    @Override
    public void run() {
        System.out.println(new Date());
    }
    
}
