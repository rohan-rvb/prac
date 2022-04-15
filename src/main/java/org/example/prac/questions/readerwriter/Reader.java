package org.example.prac.questions.readerwriter;

public class Reader implements Runnable{
    private Message message;
    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (String latestMessage = message.read(); !"finished".equals(latestMessage); latestMessage = message.read()) {
            System.out.println("reading : " + latestMessage);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Reader Thread Interrupted!!!");
            }
        }
    }
}
