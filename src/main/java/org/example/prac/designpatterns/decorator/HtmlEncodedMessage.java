package org.example.prac.designpatterns.decorator;

import org.apache.commons.lang.StringEscapeUtils;

public class HtmlEncodedMessage implements Message{

    private Message message;

    public HtmlEncodedMessage(Message message) {
        this.message = message;
    }

    @Override
    public String getContent(String input) {
        return StringEscapeUtils.escapeHtml(message.getContent(input));
    }
}
