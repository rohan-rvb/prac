package org.example.prac.multithreading;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ThreadCreation extends Thread {

    public void run() {
        log.info("running thread");
    }
}
