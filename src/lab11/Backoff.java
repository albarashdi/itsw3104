/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class Backoff {
    long minWait;
    long maxWait;
    public Backoff(long min, long max){
        minWait=min;
        maxWait=max;
    }
    
    public void backoff() throws InterruptedException{
        Thread.sleep(minWait);
    }
    
}
