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
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedQueue<T> {

    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    final Object[] items;
    int tail, head, count;

    public LockedQueue(int capacity) {
        items = new Object[capacity];
        tail = 0;
        head = 0;
        count = 0;
    }

    public void enq(Object x) {
        lock.lock();
        try {
            while (count == items.length)
		try {
                notFull.await();
            } catch (InterruptedException ex) {
            }
            items[tail % items.length] = x;
            ++tail;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object deq() {
        lock.lock();
        try {
            while (count == 0)
		try {
                notEmpty.await();
            } catch (InterruptedException ex) {
            }
            Object x = items[head % items.length];
            ++head;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

}
