package org.example.prac.designpatterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.example.prac.designpatterns.strategy.ex1.Animal;
import org.example.prac.designpatterns.strategy.ex1.Bird;
import org.example.prac.designpatterns.strategy.ex1.Cat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Slf4j
public class StrategyTest {

    @Test
    public void testStrategy() {
        Animal cat = new Cat();
        Animal bird = new Bird();
        log.info("bird  : {} cat : {}", cat.letsFly(), bird.letsFly());
    }
}
