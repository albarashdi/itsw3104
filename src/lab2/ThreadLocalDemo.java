/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class ThreadLocalDemo implements Runnable{
    ThreadLocal<Integer> threadLocalCounter = new ThreadLocal<>();
    int counter;
    @Override
    public void run() {
        counter++;
        if(threadLocalCounter.get()!=null){
            threadLocalCounter.set(threadLocalCounter.get().intValue()+1);
        }else{
            threadLocalCounter.set(0);
        }
        
        
        System.out.println("Counter :"+counter);
        System.out.println("Thread Local Counter:" + threadLocalCounter.get());
    }
    
}
