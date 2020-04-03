/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shimaz & Ahmed Al-Brashdi
 */
class A extends Thread {

    private LockFreeStack stack;

    A(LockFreeStack stack) {
        this.stack = stack;
    }

    public void run() {
        for (int i = 1; i < 10; i++) {
            try {
                stack.push(new Random().nextInt(99));
            } catch (InterruptedException ex) {
                Logger.getLogger(A.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class B extends Thread {

    private LockFreeStack stack;

    B(LockFreeStack stack) {
        this.stack = stack;
    }

    public void run() {
        for (int i = 1; i < 10; i++) {
            try {
                stack.push(new Random().nextInt(99));
            } catch (InterruptedException ex) {
                Logger.getLogger(B.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

public class Test {

    public static void main(String arg[]) throws InterruptedException {
        LockFreeStack stack = new LockFreeStack();

        A t1 = new A(stack);
        t1.start();
        B t2 = new B(stack);
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println("\n\nThe full stack after pushing all nodes");
        stack.print();

        stack.pop();
        System.out.println("\n\nAfter popping the top element");
        stack.print();
    }
}
