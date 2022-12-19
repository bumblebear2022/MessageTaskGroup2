package by.itacademy.jd2.messagetask.domain;

import java.time.LocalDateTime;

public class Message {
    private final LocalDateTime sendDateTime;
    private final User fromWhom;
    private final User toWhom;
    private final String text;

    public Message(LocalDateTime sendDateTime, User fromWhom, User toWhom, String text) {
        this.sendDateTime = sendDateTime;
        this.fromWhom = fromWhom;
        this.toWhom = toWhom;
        this.text = text;
    }
    public static MessageBuilder builder(){
        return new MessageBuilder();
    }

    public LocalDateTime getSendDateTime() {
        return sendDateTime;
    }

    public User getFromWhom() {
        return fromWhom;
    }

    public User getToWhom() {
        return toWhom;
    }

    public String getText() {
        return text;
    }

    public static class MessageBuilder{
        private LocalDateTime sendDateTime;
        private User fromWhom;
        private User toWhom;
        private String text;

        private MessageBuilder() {
        }

        public MessageBuilder setSendDateTime(LocalDateTime sendDateTime) {
            this.sendDateTime = sendDateTime;
            return this;
        }

        public MessageBuilder setFromWhom(User fromWhom) {
            this.fromWhom = fromWhom;
            return this;
        }

        public MessageBuilder setToWhom(User toWhom) {
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
