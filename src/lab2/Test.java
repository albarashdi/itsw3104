/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmed Al-Brashdi
 */

public class Test {

    public static void main(String[] args) {
        ThreadLocalDemo threadLocal = new ThreadLocalDemo();
        Thread t1 = new Thread(threadLocal);
        Thread t2 = new Thread(threadLocal);
        Thread t3 = new Thread(threadLocal);
        Thread t4 = new Thread(threadLocal);
        Thread t5 = new Thread(threadLocal);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
