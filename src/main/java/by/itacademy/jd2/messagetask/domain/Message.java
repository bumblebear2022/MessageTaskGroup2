package by.itacademy.jd2.messagetask.domain;

import by.itacademy.jd2.messagetask.dto.MessageDto;
import by.itacademy.jd2.messagetask.dto.UserDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Message {
    private final LocalDateTime sendDateTime;
    private final String fromWhom;
    private final String toWhom;
    private final String text;

    public Message(LocalDateTime sendDateTime, String fromWhom, String toWhom, String text) {
        this.sendDateTime = sendDateTime;
        this.fromWhom = fromWhom;
        this.toWhom = toWhom;
        this.text = text;
    }

    public Message(MessageDto message) {
        this.sendDateTime = LocalDateTime.now();
        this.fromWhom = message.getFromWhom();
        this.toWhom = message.getToWhom();
        this.text = message.getText();
    }

    public static MessageBuilder builder(){
        return new MessageBuilder();
    }

    public LocalDateTime getSendDateTime() {
        return sendDateTime;
    }

    public String getFromWhom() {
        return fromWhom;
    }

    public String getToWhom() {
        return toWhom;
    }

    public String getText() {
        return text;
    }

    public static class MessageBuilder{
        private  LocalDateTime sendDateTime;
        private  String fromWhom;
        private  String toWhom;
        private  String text;

        private MessageBuilder() {
        }

        public MessageBuilder setSendDateTime(LocalDateTime sendDateTime) {
            this.sendDateTime = sendDateTime;
            return this;
        }

        public MessageBuilder setFromWhom(String fromWhom) {
            this.fromWhom = fromWhom;
            return this;
        }

        public MessageBuilder setToWhom(String toWhom) {
            this.toWhom = toWhom;
            return this;
        }

        public MessageBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public Message build(){
            return new Message(sendDateTime,fromWhom,toWhom,text);
        }
    }
}
