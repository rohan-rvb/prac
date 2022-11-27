package org.example.prac.designpatterns.strategy.decorator;

import antlr.debug.MessageAdapter;
import org.example.prac.designpatterns.decorator.HtmlEncodedMessage;
import org.example.prac.designpatterns.decorator.Message;
import org.example.prac.designpatterns.decorator.TextMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestDecorator {

    @Test
    public void testDecorator() {
        Message msg = new TextMessage();

        Message htmlMessage = new HtmlEncodedMessage(msg);

        String htmlStr = "The <Force> is strong with us!";

        System.out.println("Initial message " + msg.getContent(htmlStr));
        System.out.println("After decorate " + htmlMessage.getContent(htmlStr));
    }

}
