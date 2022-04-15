package org.example.prac.questions.readerwriter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Message {
    private String message;
    private boolean empty = true;
    private Lock lock;

    public synchronized String read() {
        if (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void Write(String message) {
        if (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.message = message;
        empty = false;
        notifyAll();
    }
}
