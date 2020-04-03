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
    // We set the top as a node reference that may be updated atomically
    AtomicReference<Node> top = new AtomicReference<Node>(null);
    
    // setting the time to backoff if compareAndSet returns false for tryPush
    static final int MIN_DELAY = 100;
    static final int MAX_DELAY = 300;
    Backoff backoff = new Backoff(MIN_DELAY, MAX_DELAY);
    
    // Thois is called from push method. 
    protected boolean tryPush(Node node) {
        // 1) first we get the top before pushing the new element
        Node oldTop = top.get();
        // then we make the old push as the successor of the new top.
        node.next = oldTop;
        // As the top is an atomic reference, we call the method compareAndSet
        // and check, if the current value (oldTop) = to the expected value, then update to (node) which makes node the new top
        return (top.compareAndSet(oldTop, node));
    }

    public void push(T value) throws InterruptedException {
        // create a new node with the value (value)
        Node node = new Node(value);
        
        while (true) {
            if (tryPush(node)) {
                return; // if the tryPush returns true, then break the loop and return
            } else {
                System.out.println("retrying push...");
                backoff.backoff();// else, backoff (wait), then try again. 
            }
        }
    }
    
    // This is called from pop method
    protected Node tryPop(){
        // the node to e removed, the top as this is a stack
        Node oldTop = top.get();
        // if there is no top, then the stack is empty and return null
        // or you can modell it to return a custom exception
        if (oldTop == null) {
            return null;
        }
        // the new top will be the successor of the old one.
        Node newTop = oldTop.next;
        // As the top is an atomic reference, we call the method compareAndSet
        // and check, if the current value (oldTop) = to the expected value, then update to (newTop) which makes the successor of the oldTop the new top 
        if (top.compareAndSet(oldTop, newTop)) {
            return oldTop; // return the removed (popped) node
        } else {
            return null;
        }
    }

    public T pop() throws InterruptedException{
        while (true) {
            // the returnNode is the node to be popped out from the stack
            Node returnNode = tryPop();
            // if tryPop returned a node, then get its value 
            if (returnNode != null) {
                return (T)returnNode.value;
                
            // else backoff and try again
            } else {
                System.out.println("retrying pop...");
                backoff.backoff();
            }
        }
    }
    
    // this prints out the stack nodes' value
    public void print(){
     // first we set the current node as the top of the stack
     Node curr=top.get();
     // iterate the stack until nothing left (until curr = null)
     while(curr!=null){
         System.out.println(curr.value);
         curr=curr.next;
     }
 }


}
