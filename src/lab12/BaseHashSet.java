/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public abstract class BaseHashSet<T> {
    
    // this is the hash table
    protected List<T>[] table;
    
    // this to hold the number of items
    protected int setSize;

    public BaseHashSet(int capacity) {
        setSize = 0;
        // each entry in the hash table is a list (ArrayList)
        table = (List<T>[]) new List[capacity];
        for (int i = 0; i < capacity; i++) {
            // initializing the lists (buckets)
            table[i] = new ArrayList<T>();
        }
    }

    public boolean contains(T x) {
        acquire(x);
        try {
            // to get where is the item, we apply the hashfunction
            int myBucket = x.hashCode() % table.length;
            return table[myBucket].contains(x);
        } finally {
            release(x);
        }
    }

    public boolean add(T x) {
        boolean result = false;
        acquire(x);
        try {
            // to decide where to add the item, we apply the hashfunction to get which bucket
            int myBucket = x.hashCode() % table.length;
            if (!table[myBucket].contains(x)) {
                table[myBucket].add(x);
                result = true;
                ++setSize;
            }
        } finally {
            release(x);
        }
        // we implemented these two methods in the sub class
        if (policy()) {
            resize();
        }
        return result;
    }

    public abstract void acquire(T x) ;
    

    public abstract void release(T x) ;

    public abstract boolean policy() ;

    public abstract void resize() ;

}
