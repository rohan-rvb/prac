package org.example.prac.questions.turn;

public class Foo {
    private String a;
    private String b;
    private String turn;
    public Foo() {
        a = new String("a");
        b= new String("b");
        turn="1";
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException{
        while (!turn.equals("1")) {
            wait();
        }
        //printSecond.run();
        printFirst.run();
        turn = "2";
        notifyAll();
        // printFirst.run() outputs "first". Do not change or remove this line.
        // printFirst.run();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (!turn.equals("2")) {
            wait();
        }
        printSecond.run();
        turn = "3";
        notifyAll();
        // printSecond.run() outputs "second". Do not change or remove this line.
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (!turn.equals("3")) {
            wait();
        }
        printThird.run();
        turn = "3";
        // printThird.run() outputs "third". Do not change or remove this line.
        // printThird.run();
    }
}
