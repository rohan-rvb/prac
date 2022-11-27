package org.example.prac.syntax;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.nio.channels.spi.SelectorProvider;

@RunWith(SpringRunner.class)
public class Bigdecimal {
    @Test
    public void testBigDecimal() {
        BigDecimal num = new BigDecimal("2.45");
    }
}
