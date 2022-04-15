package org.example.prac.logclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LogClientTest {

    @Test
    public void testLogClient() {
        LogClient logger = new LoggerImpl();

        logger.start("1");
        logger.poll();
        logger.start("3");
        logger.poll();
        logger.end("1");
        logger.poll();
        logger.start("2");
        logger.poll();
        logger.end("2");
        logger.poll();
        logger.end("3");
        logger.poll();
        logger.poll();
        logger.poll();
    }
}
