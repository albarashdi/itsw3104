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
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CoarseList<T> implements Set {
	private Node<Object> head;
	private Lock lock=new ReentrantLock();
	public CoarseList() {
		head=new Node<>(Integer.MIN_VALUE);
		head.next=new Node<>(Integer.MAX_VALUE);
	}
        @Override
	public boolean add(Object item) {
		Node<Object> pred,curr;
		int key=item.hashCode();
		lock.lock();
		try {
			pred=head;
			curr=pred.next;
			while(curr.key<key) {
				pred=curr;
				curr=curr.next;
			}
			if(key==curr.key)
				return false;
			else {
				Node<Object> node=new Node<Object>(key);
				node.item=item;
				node.next=curr;
				pred.next=node;
				return true;
			}
		} finally {
			lock.unlock();
		}
	}
	
	public boolean remove(Object item) {
		Node<Object> pred, curr;
		int key=item.hashCode();
		lock.lock();
		try {
			pred=head;
			curr=pred.next;
			while(curr.key<key) {
				pred=curr;
				curr=curr.next;
			}
			if(key==curr.key) {
				pred.next=curr.next;
				return true;
			}
			else {
				return false;
			}
		} finally {
			lock.unlock();
		}
	}
}
