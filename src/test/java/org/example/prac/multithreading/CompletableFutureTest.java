package org.example.prac.multithreading;

import io.swagger.models.auth.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Time;
import java.util.concurrent.*;

@RunWith(SpringRunner.class)
public class CompletableFutureTest {
    @Test
    public void testFutureWithRunnable() {
        CompletableFuture<Void> ft = CompletableFuture.runAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Doing some processing " + Thread.currentThread().getName());
        });

        try {
            ft.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("This will print after 5 seconds " + Thread.currentThread().getName());

        // With passing a executor
        CompletableFuture<Void> ft1 = CompletableFuture.runAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Second " + Thread.currentThread().getName());
        }, Executors.newSingleThreadExecutor());

        try {
            ft.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("back to main");

    }

    @Test
    public void testFutureWithSupplier() {
        CompletableFuture<String> ft = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                String result = "hello";
                System.out.println("supplying " + result);
                return result;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "";
        });

        try {
            System.out.println("got this value " + ft.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // executor can also be passed in second argument to above, same as we did in
        // testFutureWithRunnable
    }

    @Test
    public void testProcessing() throws InterruptedException {
        // adding callback to completable future
        CompletableFuture<Integer> ft = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 0;
        }, Executors.newSingleThreadExecutor());



        CompletableFuture<Integer>ft1 = ft.thenApplyAsync(num -> {
            System.out.println("got from future Thread : " + Thread.currentThread().getName() + " " + num);
            return num *2;
        });

        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    public void testThenAccept() throws InterruptedException {
        // if we dont want any return from future we can use accept
        CompletableFuture<Integer> cft = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 3;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 0;
        });

        cft.thenAccept((num) -> System.out.println("got from fut " + num));

        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    public void testComposeFuture() {
        CompletableFuture<Integer> ft1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 0;
        });

        CompletableFuture<Integer> resultFt = ft1.thenCompose(num ->
                getNum2Future(num));

        try {
            System.out.println("final result is : " + resultFt.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }

    public CompletableFuture<Integer> getNum2Future(Integer num1) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return num1+1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 0;
        });
    }
}
