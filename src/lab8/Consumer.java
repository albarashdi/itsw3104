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
public class Consumer extends Thread {
	private LockedQueue<Integer> queue;
	public Consumer(LockedQueue<Integer> _queue,String threadName) {
		queue=_queue;
		this.setName(threadName);
	}
	
        @Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(this.getName()+": dequeues "+queue.deq());
		}
	}
}

