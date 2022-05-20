package org.example.prac.multithreading.readerwriter;

public class Writer implements Runnable{
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String messages[] = {
          "hello", "bye", "okay"
        };

        for(String m: messages) {
            System.out.println("writing");
            message.Write(m);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        message.Write("finished");
    }
}
