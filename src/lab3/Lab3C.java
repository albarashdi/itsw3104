/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab3;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class Lab3C {
    public static int num = 10;
    public static void main(String[] args) throws InterruptedException, ExecutionException {
            

        Callable myCallable = new RunnerC();
        ArrayList<String> list = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int s = 0; s <= 10; s++) {
            /*
            * Java Callable tasks return java.util.concurrent.Future object. 
            * Using Java Future object, we can find out the status of the Callable task and get the returned Object. 
            * It provides get() method that can wait for the Callable to finish and then return the result.
            */
            executor.submit(myCallable);
            //list.add(future.get());
            Thread.sleep(500);
        }
        executor.shutdown();
        //for(String s : list){
        //    System.out.println(s);
        //}
    }

}
class RunnerC implements Callable<String>{

    @Override
    public String call() throws Exception {
        String result = "The square root of " + Lab3C.num + " is " + Math.sqrt(Lab3C.num);
        Lab3C.num=Lab3C.num+1;
        System.out.println(result);
        return result;
        
    }
    
}