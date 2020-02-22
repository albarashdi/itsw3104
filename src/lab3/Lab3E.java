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
public class Lab3E {
    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnerE1());
        Thread t2 = new Thread(new RunnerE2());
        Thread t3 = new Thread(new RunnerE3());
        Thread t4 = new Thread(new RunnerE4());
        Thread t5 = new Thread(new RunnerE5());
        
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(t1);
        executor.execute(t2);
        executor.execute(t3);
        executor.execute(t4);
        executor.execute(t5);
        
        executor.shutdown();
    }

}
class RunnerE1 implements Runnable {

    public void run() {
        int sum =0;

        for(int i = 1;i<=100;i++){
            sum=sum+i;
        }
        
        System.out.println("The sum of 1-100 is "+sum);

    }
}
class RunnerE2 implements Runnable {

    public void run() {

        int sum =0;

        for(int i = 101;i<=200;i++){
            sum=sum+i;
        }
        
        System.out.println("The sum of 100-200 is "+sum);
    }
}
class RunnerE3 implements Runnable {

    public void run() {

        int sum =0;

        for(int i = 201;i<=300;i++){
            sum=sum+i;
        }
        
        System.out.println("The sum of 201-300 is "+sum);
    }
}
class RunnerE4 implements Runnable {

    public void run() {

        int sum =0;

        for(int i = 301;i<=400;i++){
            sum=sum+i;
        }
        
        System.out.println("The sum of 301-400 is "+sum);
    }
}
class RunnerE5 implements Runnable {

    public void run() {

        int sum =0;

        for(int i = 401;i<=500;i++){
            sum=sum+i;
        }
        
        System.out.println("The sum of 401-500 is "+sum);
    }
}