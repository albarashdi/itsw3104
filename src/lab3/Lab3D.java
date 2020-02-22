/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab3;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class Lab3D {
    public static void main(String[] args) {
        ArrayList<Runnable> runners = new ArrayList<>();
        runners.add(new RunnerD1());
        runners.add(new RunnerD2());
        runners.add(new RunnerD3());
        runners.add(new RunnerD4());
        runners.add(new RunnerD5());
        
        Random random = new Random();
        myRun(runners.get(random.nextInt(runners.size()-1)));
    }
    
    public static void myRun(Runnable r){
        r.run();
    }

}
class RunnerD1 implements Runnable {

    public void run() {
        int sum =0;

        for(int i = 1;i<=100;i++){
            sum=sum+i;
        }
        
        System.out.println("The sum of 1-100 is "+sum);

    }
}
class RunnerD2 implements Runnable {

    public void run() {

        int sum =0;

        for(int i = 101;i<=200;i++){
            sum=sum+i;
        }
        
        System.out.println("The sum of 100-200 is "+sum);
    }
}
class RunnerD3 implements Runnable {

    public void run() {

        int sum =0;

        for(int i = 201;i<=300;i++){
            sum=sum+i;
        }
        
        System.out.println("The sum of 201-300 is "+sum);
    }
}
class RunnerD4 implements Runnable {

    public void run() {

        int sum =0;

        for(int i = 301;i<=400;i++){
            sum=sum+i;
        }
        
        System.out.println("The sum of 301-400 is "+sum);
    }
}
class RunnerD5 implements Runnable {

    public void run() {

        int sum =0;

        for(int i = 401;i<=500;i++){
            sum=sum+i;
        }
        
        System.out.println("The sum of 401-500 is "+sum);
    }
}