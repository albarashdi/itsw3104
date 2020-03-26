/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class Main {
	public static void main(String[] args) {
		LockedQueue<Integer> queue=new LockedQueue<>(10);
		
		for(int i=0;i<10;i++) {
			(new Producer(queue, "producer "+i)).start();
			(new Consumer(queue, "consumer "+i)).start();
		}
	}

}
