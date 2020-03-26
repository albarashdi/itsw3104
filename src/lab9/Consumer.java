/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class Consumer extends Thread {
	private CoarseList<Integer> list=null;
	private Counter ctr=null;
	public Consumer(Counter _ctr,CoarseList<Integer> _list,String threadName) {
		list=_list;
		this.setName(threadName);
		ctr=_ctr;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			int num=ctr.getValue();
			list.remove(num);
			System.out.println(this.getName()+": removes "+num);
		}
	}
}
