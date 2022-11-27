package org.example.prac.designpatterns.decorator;

public class TextMessage implements Message{
    @Override
    public String getContent(String input) {
        return input;
    }
}
