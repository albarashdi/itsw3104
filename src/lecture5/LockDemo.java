/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture5;


/**
 *
 * @author Ahmed Al-Brashdi
 */
public class LockDemo {
    public static void main(String[] args) {
        Incrementer in = new Incrementer();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i <= 1000; i++) {
                in.getAndIncrement();

            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i <= 1000; i++) {
                in.getAndIncrement();

            }
        });
        
        System.out.println(in.getAndIncrement());
    }
    
    
}
class Incrementer{
    private int value =0;
    
    public int getAndIncrement(){
        int temp=value;
        value = temp+1;
        return temp;
    }
}