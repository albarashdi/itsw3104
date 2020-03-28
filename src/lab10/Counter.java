/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class Counter {
	private int count;
	public Counter(int _count) {
		count=_count;
	}
	public synchronized int getAndIncrement() {
		return count++;		
	}
	public synchronized int getValue() {
		return count;		
	}
}

