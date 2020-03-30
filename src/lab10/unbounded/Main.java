/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10.unbounded;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class Main {
	public static void main(String[] args) {
		UnboundedQueue<Integer> list = new UnboundedQueue<>();
		Counter ctr=new Counter(0);
		for(int i=0;i<4;i++) {
			(new Producer(ctr,list, "prod"+i)).start();
			(new Consumer(ctr,list, "cons"+i)).start();
		}
	}
}

