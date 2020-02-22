/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab4;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ahmed Al-Brashdi
 */

/*
In this version of the answer, we use the schedule with Callable. This will return Future
Then we print out the result of the future using future.get();
*/
public class Lab4AV2 {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        
        ScheduledFuture future = ses.schedule(new CallerA(), 5, TimeUnit.SECONDS);
        System.out.println("Time before delay is "+new Date());
        System.out.println("Delayed date is "+future.get());
        ses.shutdown();
    }
    

}
class CallerA implements Callable<String>{

    @Override
    public String call() throws Exception {
        return new Date().toString();
    }
    
}