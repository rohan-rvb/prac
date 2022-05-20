package org.example.prac.multithreading;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class ThreadCreationRunnable implements Runnable{

    public void run() {
        log.info("running via implementing runnable");
        ConcurrentHashMap<Integer, Integer> g = new ConcurrentHashMap<>();
    }

}

