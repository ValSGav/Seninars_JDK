package seminar5.homeWork;

import java.util.ArrayDeque;
import java.util.Deque;

public class Talker extends Thread {

    private final Deque<String> talkingQueue;

    public Talker() {
        this.talkingQueue = new ArrayDeque<>();
    }

    public synchronized void talk(String phrase) {
        talkingQueue.add(phrase);
    }

    @Override
    public void run() {
        doIt();
    }

    private void doIt() {
        while (true) {
            if (!talkingQueue.isEmpty()) {
                talkingQueue.removeFirst();                
            }
        }
    };



}
