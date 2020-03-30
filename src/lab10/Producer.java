/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class Producer extends Thread {
	private BoundedQueue<Integer> list=null;
	private Counter ctr=null;
	public Producer(Counter _ctr, BoundedQueue<Integer> _list,String threadName) {
		list=_list;
		this.setName(threadName);
		ctr=_ctr;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			int num=ctr.getAndIncrement();
                    try {
                        list.enq(num);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    }
			
		}
	}
}
