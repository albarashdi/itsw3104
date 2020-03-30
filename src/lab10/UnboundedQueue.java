/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class UnboundedQueue<T> {
    ReentrantLock enqLock, deqLock;
    Node head;
    Node tail;

    public UnboundedQueue() {
        head = new Node(null);
        tail = head;
        enqLock = new ReentrantLock();
        deqLock = new ReentrantLock();
    }

    public void enq(T x) throws InterruptedException {
        enqLock.lock();
        try {
            Node e = new Node(x);
            tail.next = tail = e;
        } finally {
            enqLock.unlock();
        }
    }

    public T deq() throws EmptyException {
        T result;
        deqLock.lock();
        try {
            if(head.next==null) {
                throw new EmptyException();
            }
            result = (T) head.next.item;
            head = head.next;
            
        } finally {
            deqLock.unlock();
        }
        
        return result;
    }
    
}
