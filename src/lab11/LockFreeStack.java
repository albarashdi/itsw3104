/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11;

import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class LockFreeStack<T> {

    AtomicReference<Node> top = new AtomicReference<Node>(null);
    static final int MIN_DELAY = 100;
    static final int MAX_DELAY = 300;
    Backoff backoff = new Backoff(MIN_DELAY, MAX_DELAY);

    protected boolean tryPush(Node node) {
        Node oldTop = top.get();
        node.next = oldTop;
        return (top.compareAndSet(oldTop, node));
    }

    public void push(T value) throws InterruptedException {
        Node node = new Node(value);
        while (true) {
            if (tryPush(node)) {
                return;
            } else {
                backoff.backoff();
            }
        }
    }

    protected Node tryPop(){
        Node oldTop = top.get();
        if (oldTop == null) {
            return null;
        }
        Node newTop = oldTop.next;
        if (top.compareAndSet(oldTop, newTop)) {
            return oldTop;
        } else {
            return null;
        }
    }

    public T pop() throws InterruptedException{
        while (true) {
            Node returnNode = tryPop();
            if (returnNode != null) {
                return (T)returnNode.value;
            } else {
                backoff.backoff();
            }
        }
    }
    
    public void print(){
     Node curr=top.get();
     while(curr!=null){
         System.out.println(curr.value);
         curr=curr.next;
     }
 }


}
