/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lecture1;

import java.util.Scanner;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class AmdahlDemo {
    
    public static void main(String[] args) {
        
        System.out.println("########### Amdahl's Law ###########\n");
        System.out.println("What is the number of processors?");
        Scanner processorInput = new Scanner(System.in);
        long processors = processorInput.nextLong();
        System.out.println("What is the parallel task?");
        Scanner parallelInput = new Scanner(System.in);
        double parallelTask = parallelInput.nextDouble();
        double sequentialTask= 1-parallelTask;        
        double speedUp = 1/(sequentialTask+(parallelTask/processors));        
        System.out.println("Speed up = "+ speedUp);
        System.out.println("###################################");
        
    }

}
