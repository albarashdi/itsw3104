/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class CoarseHashSet<T> extends BaseHashSet<T> {
    // we will have a single lock for the whole hashing (all methods). 
    final Lock lock;

    CoarseHashSet(int capacity) {
        super(capacity);
        lock = new ReentrantLock();
    }

    public final void acquire(T x) {
        lock.lock();
    }

    public void release(T x) {
        lock.unlock();
    }

    public boolean policy() {
        return setSize / table.length > 4;
    }

    public void resize() {
        int oldCapacity = table.length;
        lock.lock();
        try {
            if (oldCapacity != table.length) {
                return; // someone beat us to it
            }
            int newCapacity = 2 * oldCapacity;
            List<T>[] oldTable = table;
            table = (List<T>[]) new List[newCapacity];
            for (int i = 0; i < newCapacity; i++) {
                table[i] = new ArrayList<T>();
            }
            for (List<T> bucket : oldTable) {
                for (T x : bucket) {
                    table[x.hashCode() % table.length].add(x);
                }
            }
        } finally {
            lock.unlock();
        }

    }
}