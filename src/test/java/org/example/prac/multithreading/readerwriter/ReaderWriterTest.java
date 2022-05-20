package org.example.prac.multithreading.readerwriter;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ReaderWriterTest {

    @SneakyThrows
    @Test
    public void testReaderWriter() {
        Message message = new Message();
        Thread wth = new Thread(new Writer(message));
        Thread rth = new Thread(new Reader(message));
        String str="a";
        if(str.equals("")) {

        }
        wth.start();
        rth.start();
        wth.join();
    }
}
