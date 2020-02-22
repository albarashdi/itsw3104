/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lecture3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class TestCores {
    
    public static void main(String[] args) {
        int numCores = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(numCores);
        for(int i =1;i<11;i++){
            service.execute(new MyTask());
        }
        service.shutdown();
    }

}
class MyTask implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName());
        
    }
}