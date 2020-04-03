/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmed Al-Brashdi
 */
class A extends Thread{
    private LockFreeStack stack;
    A(LockFreeStack stack){
        this.stack=stack;
    }
    public void run(){
        for(int i=1;i<10;i++){
            try {
                stack.push(i*10);
            } catch (InterruptedException ex) {
                Logger.getLogger(A.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
}

class B extends Thread{
    private LockFreeStack stack;
    B(LockFreeStack stack){
        this.stack=stack;
    }
    public void run(){
        for(int i=1;i<10;i++){
            try {
                stack.push(i*11);
            } catch (InterruptedException ex) {
                Logger.getLogger(B.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
}
public class Test {
    public static void main(String arg[]) throws InterruptedException{
        LockFreeStack stack=new LockFreeStack();
        
      A t1=new A(stack);
      t1.start();
      B t2=new B(stack);
      t2.start();
        try{Thread.sleep(10000);}catch(Exception e){}
         System.out.println("\n\nAfter PUSH n elements");
        stack.print();
        
        stack.pop();
        System.out.println("\n\nAfter POP elements");
        stack.print();
       }
}

