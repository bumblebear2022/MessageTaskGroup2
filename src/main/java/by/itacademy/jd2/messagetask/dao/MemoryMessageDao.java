package by.itacademy.jd2.messagetask.dao;

import by.itacademy.jd2.messagetask.domain.Message;
import by.itacademy.jd2.messagetask.dto.UserDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMessageDao implements IMessageDao{
    private Map<String, List<Message>> toWhomMessages = new HashMap<>();


    @Override
    public List<Message> get(String login) {
        return null;
    }

    @Override
    public void add(Message message) {
        toWhomMessages.computeIfAbsent(message.getToWhom().getLogin(), ()-> new ArrayList<Message>().add(message));
    }
}
