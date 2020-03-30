package lab10;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class BoundedQueue<T> {

    ReentrantLock enqLock, deqLock;
    Condition notEmptyCondition, notFullCondition;
    AtomicInteger size;
    Node head;
    Node tail;
    int capacity;
    Node[] items;
    int counter = 0;

    public BoundedQueue(int _capacity) {
        capacity = _capacity;
        head = new Node(null);
        tail = head;
        size = new AtomicInteger();
        enqLock = new ReentrantLock();
        notFullCondition = enqLock.newCondition();
        deqLock = new ReentrantLock();
        notEmptyCondition = deqLock.newCondition();
        items = new Node[_capacity];
    }

    public void enq(T x) throws InterruptedException {
        boolean mustWakeDequeuers = false;
        enqLock.lock();
        try {
            while (counter == capacity) {
                notFullCondition.await();
            }
            Node e = new Node(x);
            items[counter]=e;
            tail.next = tail = e;
            counter++;
            if (size.getAndIncrement() == 0) {
                mustWakeDequeuers = true;
            }
        } finally {
            enqLock.unlock();
        }
        System.out.println(Thread.currentThread().getName()+": adds "+x+" size "+counter);
        Thread.sleep(200);
        if (mustWakeDequeuers) {
            deqLock.lock();
            try {
                notEmptyCondition.signalAll();
            } finally {
                deqLock.unlock();
            }
        }
    }

    public T deq() throws InterruptedException {
        T result;
        boolean mustWakeEnqueuers = true;
        deqLock.lock();
        try {
            while (counter == 0) {
                notEmptyCondition.await();
            }
            result = (T) head.next.item;
            head = head.next;
            counter--;
            System.out.println(Thread.currentThread().getName()+": removed "+result+" size "+counter);
            Thread.sleep(200);
            if (size.getAndIncrement() == capacity) {
                mustWakeEnqueuers = true;
            }
        } finally {
            deqLock.unlock();
        }
        
        if (mustWakeEnqueuers) {
            enqLock.lock();
            try {
                notFullCondition.signalAll();
            } finally {
                enqLock.unlock();
            }
        }
        return result;
    }

}
