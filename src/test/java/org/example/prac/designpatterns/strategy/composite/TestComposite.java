package org.example.prac.designpatterns.strategy.composite;

import org.example.prac.designpatterns.composite.BinaryFile;
import org.example.prac.designpatterns.composite.File;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestComposite {
    @Test
    public void testComposite() {
        File f1 = new BinaryFile("Screenshot1", 1000);

    }
}
