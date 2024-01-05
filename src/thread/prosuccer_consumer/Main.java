package thread.prosuccer_consumer;

import java.util.*;

class Producer implements Runnable {

    private final Queue<String> stringList;

    public Producer(Queue<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public void run() {
        int iter = 0;
        while (!Thread.currentThread().isInterrupted()) {
            produceStrings(iter++);
        }
    }

    private void produceStrings(int iteration) {
        Random r = new Random();
        int count = r.nextInt(99) + 1;

        synchronized (stringList) {
            for (int i = 0; i < count; i++) {
                stringList.add("iteration:" + iteration + ": string_" + i);
            }
            stringList.notifyAll();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Consumer implements Runnable{

    private final int threadId;
    private final Queue<String> stringQueue;

    public Consumer(int threadId, Queue<String> stringQueue) {
        this.threadId = threadId;
        this.stringQueue = stringQueue;
    }

    @Override
    public void run() {
        while (! Thread.currentThread().isInterrupted()){

            while (!stringQueue.isEmpty()){
                synchronized (stringQueue){
                        System.out.println("Thread "+threadId+": "+stringQueue.poll());
                    }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}

public class Main {

    private Queue<String> stringQueue;

    public static void main(String[] args) {
        new Main().init();
    }

    private void init(){
        stringQueue = new LinkedList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            threads.add(new Thread( new Consumer(i, stringQueue)));
        }

        Thread producer = new Thread(new Producer(stringQueue));
        producer.start();

        for (Thread t: threads ) {
            t.start();
        }

    }
}
