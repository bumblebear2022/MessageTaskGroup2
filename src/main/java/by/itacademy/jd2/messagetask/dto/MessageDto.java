package by.itacademy.jd2.messagetask.dto;

import by.itacademy.jd2.messagetask.domain.Message;

import java.time.LocalDateTime;

public class MessageDto {
    private final String fromWhom;
    private final String toWhom;
    private final String text;

    public MessageDto(String fromWhom, String toWhom, String text) {
        this.fromWhom = fromWhom;
        this.toWhom = toWhom;
        this.text = text;
    }

    public static MessageDto.MessageBuilder builder(){
        return new MessageDto.MessageBuilder();
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
        private  String fromWhom;
        private  String toWhom;
        private  String text;

        private MessageBuilder() {
        }

        public MessageDto.MessageBuilder setFromWhom(String fromWhom) {
            this.fromWhom = fromWhom;
            return this;
        }

        public MessageDto.MessageBuilder setToWhom(String toWhom) {
            this.toWhom = toWhom;
            return this;
        }

        public MessageDto.MessageBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public MessageDto build(){
            return new MessageDto(fromWhom,toWhom,text);
        }
    }
}
