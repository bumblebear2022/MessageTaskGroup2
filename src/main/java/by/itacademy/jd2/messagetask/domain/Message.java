package by.itacademy.jd2.messagetask.domain;

import by.itacademy.jd2.messagetask.dto.UserDto;

import java.time.LocalDateTime;

public class Message {
    private final LocalDateTime sendDateTime;
    private final UserDto fromWhom;
    private final UserDto toWhom;
    private final String text;

    public Message(LocalDateTime sendDateTime, UserDto fromWhom, UserDto toWhom, String text) {
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

    public UserDto getFromWhom() {
        return fromWhom;
    }

    public UserDto getToWhom() {
        return toWhom;
    }

    public String getText() {
        return text;
    }

    public static class MessageBuilder{
        private  LocalDateTime sendDateTime;
        private  UserDto fromWhom;
        private  UserDto toWhom;
        private  String text;

        private MessageBuilder() {
        }

        public MessageBuilder setSendDateTime(LocalDateTime sendDateTime) {
            this.sendDateTime = sendDateTime;
            return this;
        }

        public MessageBuilder setFromWhom(UserDto fromWhom) {
            this.fromWhom = fromWhom;
            return this;
        }

        public MessageBuilder setToWhom(UserDto toWhom) {
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
