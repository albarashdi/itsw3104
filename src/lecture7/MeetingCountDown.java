
package lecture7;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ahmed Al-Brashdi
 */
public class MeetingCountDown {

    public static void main(String[] args) {
        // First we create the meeting task and start it
         Meeting meeting = new Meeting(15);
         Thread meetingThread = new Thread(meeting);
         meetingThread.start();
         
         // Then we start welcoming the participants
         for(int i =1;i<=15;i++){
             Participant participant = new Participant(meeting, "Person "+i);
             Thread participantThread = new Thread(participant);
             participantThread.start();
         }
    }

}

class Meeting implements Runnable {

    // The total number who will attend the meeting / number of tasks
    private final CountDownLatch controller;

    Meeting(int number) {
        // Initialize the countdown latch
        controller = new CountDownLatch(number);
    }

    public void arrive(String name) {
        System.out.println(name + " has arrived");

        /* the method call wait for others
        /  it counts down (number) until it become 0 (all arrived)
         */
        controller.countDown();
        System.out.println("Waiting for " + controller.getCount() + " participants");
    }

    @Override
    public void run() {
        System.out.println("We are welcomeing participants, we expect: " + controller.getCount());

        try {
            // wait until all arrives: countdown become 0
            controller.await();
            System.out.println("All arrived,let's start meeting");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Participant implements Runnable {

    private Meeting meeting;
    private String name;

    public Participant(Meeting meeting, String name) {
        this.meeting = meeting;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Participant.class.getName()).log(Level.SEVERE, null, ex);
        }
        meeting.arrive(name);
    }

}

    

