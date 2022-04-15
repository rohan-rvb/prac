package org.example.prac.multithreading.racecondition;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
@RunWith(SpringRunner.class)
public class TestRaceCondition {

    @Test
    public void testRaceCondition() {
        Calculator calculator = new Calculator();

    }

    @Test
    public void testRaceExecutor() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Calculator calculator1 = new Calculator();
        Calculator calculator2 = new Calculator();

        IntStream.range(0, 1000)
                .forEach(it -> service.submit(calculator1::calculateWithoutSync));
        service.awaitTermination(3000, TimeUnit.MILLISECONDS);
        log.info("final sum : without synchronized {}", calculator1.getSum());

        IntStream.range(0, 100)
                .forEach(it -> service.submit(calculator2::calculateWithSync));
        service.awaitTermination(3000, TimeUnit.MILLISECONDS);
        log.info("final sum : with synchronized {}", calculator2.getSum());
    }

    @SneakyThrows
    @Test
    public void testWithLock() {
        Calculator calculator = new Calculator();
        ExecutorService service = Executors.newFixedThreadPool(3);

        IntStream.range(0, 1000)
                .forEach(it -> service.submit(calculator::calculateWithLock));

        service.awaitTermination(3000, TimeUnit.MILLISECONDS);

        log.info("final sum with lock : {}", calculator.getSum());
    }


}
