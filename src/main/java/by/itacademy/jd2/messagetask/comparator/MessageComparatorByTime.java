package by.itacademy.jd2.messagetask.comparator;

import by.itacademy.jd2.messagetask.domain.Message;

import java.util.Comparator;

public class MessageComparatorByTime implements Comparator<Message> {
    @Override
    public int compare(Message o1, Message o2) {
        return o2.getSendDateTime().compareTo(o1.getSendDateTime());
    }
}